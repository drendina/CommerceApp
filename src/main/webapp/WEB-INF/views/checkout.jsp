<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <title>Title</title>
        <link href="<c:url value="/risorse/style.css"/>" rel="stylesheet">
    </head>
    
    <body>
        <div id="header">
            <%--uguale all'homepage ma senza il <div id="cart">--%>
        </div>
        <div id="nav">
            <div id="body">
                <div id="order">
                    <h1>CHECKOUT</h1>
                    <%-- TODO lista di elementi con mustache, ma senza il pulsante delete--%>
                    ${itemList}
                
                    <%--<form:form method="POST" action="/cart/checkout" >--%>
                        <%--<input id="register" type="submit" value="PAGA">--%>
                    <%--</form:form>--%>
                    
                    <BR>
                    <button type="button" id="payButton">PAY</button>
                    
                </div>
            </div>
        </div>
        <div id="footer">
            <%--uguale all'homepage--%>
        </div>
        <script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
        <script src="/risorse/node_modules/mustache/mustache.js"></script>
        <script type="text/javascript" src="/risorse/javascript/checkout.js"></script>
    </body>

</html>