$(document).ready( function(){
    refresh();
});

function refresh(){
    variables = parseGetVars();
    $.ajax(
        {
            type: 'get',
            url: "/category/getAllProduct?gender=" + variables.pop() + "&category=" + variables.pop(),
            dataType: "json",
            success: function (risposta) {
                var template = $('#templateCategory').html();
                Mustache.parse(template);
                $('#showDataCategory').empty();
                risposta.forEach(function (item) {
                    var rendered = Mustache.render(template, item);
                    $('#showDataCategory').append(rendered);
                });
            },
            error: function () {
                alert("Chiamata fallita! Mustache doesn't work: ");
            }
        }
    )
}

function parseGetVars()
{
    // creo una array
    var args = new Array();
    // individuo la query (cioè tutto quello che sta a destra del ?)
    // per farlo uso il metodo substring della proprietà search
    // dell'oggetto location
    var query = window.location.search.substring(1);
    // se c'è una querystring procedo alla sua analisi
    if (query)
    {
        // divido la querystring in blocchi sulla base del carattere &
        // (il carattere & è usato per concatenare i diversi parametri della URL)
        var strList = query.split('&');
        // faccio un ciclo per leggere i blocchi individuati nella querystring
        args.push(strList.pop().split('=').pop());
        args.push(strList.pop().split('=').pop());
    }
    return args;
}