$(document).ready( function(){
   refresh();
 // $('#submitLogin').on('click', refreshItemNumber);
//TODO aggiornare numero degli item nel carrello
    $('#submitLogin').on('click', checkLogin);
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
                alert("Chiamata fallita! Mustache doesn't work");
            }
        }
    )

}
// TODO sistemare questa funzione che va sempre in error, modificare con oggetto carrello in sessione

function refreshItemNumber(){
    $.ajax(
        {
            url: "/index/quantity",
            success: function (resp) { alert(resp); $('#qty').html(resp + "elementi nel carrello"); },
            error: function() { alert("")}
        }
    )
}
function checkLogin(){
    $.ajax({
        type: 'get',
        url: 'index/error',
        dataType: "boolean",
        success: function(risposta){
            if(risposta==true){

            }
            else
            {return 'index/login'}
        }

    })
}
