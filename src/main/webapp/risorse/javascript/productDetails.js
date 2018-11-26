/*$(document).ready( function() {
/!* $('#addToCart').on('click' , function (idSku) {
        url:"/cart/addToCart?idSku="+idSku
        }
     )*!/
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
}*/

function addToCart(idSku){
    alert('Il prodotto è stato aggiunto al carrello con successo!');
    $.ajax({ url:"/cart/addToCart?idSku="+idSku})

}
