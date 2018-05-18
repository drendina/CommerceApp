$(document).ready( function(){
   refresh();
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