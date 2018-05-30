$(document).ready( function() {
   $('#payButton').on('click', payFunction);
});

function payFunction(){
    alert('Grazie di aver acquistato sul nostro sito!');
    $.ajax({
        url: "/order/createOrder"
    });
    window.location = '/index';
}