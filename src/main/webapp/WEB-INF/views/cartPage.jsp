<%@ include file="headers/headerHome.jsp"%>

<div id="nav">
        <div id="cartItems">
            <h1>CARTPAGE</h1>
            <%--TODO lista di elementi con mustache--%>
            <table>
                ${itemList}
           
                <%--<c:forEach items="${itemList}" var="item">--%>
                    <%--<tr>--%>
                        <%--<td> ${item.name} </td>--%>
                        <%--<td> ${item.price} </td>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>
            </table>
        </div>
        
        <form:form method="GET" action="/cart/checkout" >
            <input id="register" type="submit" value="CHECKOUT">
        </form:form>
    </div>

    <%@ include file="footers/footer.jsp"%>
