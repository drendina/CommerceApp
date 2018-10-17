<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>
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
</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>
<script type="text/javascript" src="/risorse/javascript/checkout.js"></script>
