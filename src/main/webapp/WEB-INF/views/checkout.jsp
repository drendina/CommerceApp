<%@ include file="headers/headerGeneric.jsp"%>
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
<%@ include file="footers/footer.jsp"%>