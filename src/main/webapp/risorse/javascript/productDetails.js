$(document).ready( function() {
 $('#productSelectBtn').on('click' , addToCart);
});

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

function addToCart(){
    alert('prodotto aggiunto al carrello');
}