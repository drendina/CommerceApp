$(document).ready( function() {
   //refresh()
});


function add(idSku, idCart){
    alert('Il prodotto è stato aggiunto al carrello con successo!');
    $.ajax({
        url:"/cart/addToCartSmart?idSku=" + idSku + "&idCart=" + idCart
    });
    refresh()
}

function remove(idSku, idCart){
    alert('Il prodotto è stato rimosso al carrello con successo!');
    $.ajax({
        url:"/cart/removeItem?idSku=" + idSku + "&idCart=" + idCart
    });
    refresh()
}

function refresh(){
    $.ajax({
        url:"redirect:/cart"
    })
}