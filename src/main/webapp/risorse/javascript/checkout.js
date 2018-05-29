$(document).ready( function() {
   $('#payButton').on('click', payFunction);
});

function payFunction(){
    alert('Grazie di aver acquistato sul nostro sito!');
    $.ajax({
        url: "/order/createOrder"
    });
    window.location = '/index';

    /*

    1 - salva tutti i dati del carrello nell'ordine
    2 - riduci stock
    3 - cancella il carrello
    */
}