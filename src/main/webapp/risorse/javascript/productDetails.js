$(document).ready( function() {

}

function refresh(){
    $.ajax(
        {
            type: 'get',
            url: "/product/getSizes",
            dataType: "json",
            success: function (risposta) {
                var template = $('#template').html();
                Mustache.parse(template);
                $('#showSizeForm').empty();
                risposta.forEach(function (item) {
                    var rendered = Mustache.render(template, item);
                    $('#showSizeForm').append(rendered);
                });
            },
            error: function () {
                alert("Chiamata fallita!");
            }
        }
    )

}