$(document).ready( function() {
    refresh();
 $('#productSelectBtn').on('click' , addToCart);
});

function refresh(){
    $.ajax(
        {
            type: 'get',
            url: "/product/getSizes",
            dataType: "json",
            success: function (risposta) {
                alert("it works");
                var template = $('#template').html();
                Mustache.parse(template);
                $('#showSizeForm').empty();
                risposta.forEach(function (item) {
                    var rendered = Mustache.render(template, item);
                    $('#showSizeForm').append(rendered);
                });
            },
            error: function () {
                alert("productDetails.js -> Chiamata fallita!");
            }
        }
    )
}

function addToCart(){
    alert('prodotto aggiunto al carrello');
}