$(document).ready( function(){
   refresh();
   $('#submitLogin').on('click', refreshItemNumber);

//TODO aggiornare numero degli item nel carrello
});

function refresh(){
    $.ajax(
        {
            type: 'get',
            url: "/index/getAllProduct",
            dataType: "json",
            success: function (risposta) {
                var template = $('#template').html();
                Mustache.parse(template);
                $('#showData').empty();
                risposta.forEach(function (item) {
                    var rendered = Mustache.render(template, item);
                    $('#showData').append(rendered);
                });
            },
            error: function () {
                alert("Chiamata fallita!");
            }
        }
    )

}
// TODO sistemare questa funzione che da sempre chiamata fallita

function refreshItemNumber(){
    $.ajax(
        {
            type: 'get',
            url: '/index/quantity',
            dataType: 'int',
            success: function (risposta) {
                alert(risposta);
                // $('#qty').append(risposta);
                 },
            error: function () { alert("Chiamata fallita") }
        }
    )
}