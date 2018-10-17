<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>

<div id="nav">
        <div id="cartItems">
            <h1>CARTPAGE</h1>
            <hr>
            <%--TODO lista di elementi con mustache--%>
            <table>
                <%--${itemList}--%>
           
                <c:forEach items="${itemList}" var="item">
                    <%--<tr>
                        <td> ${item.name} </td>
                        <td> ${item.price} </td>
                    </tr>--%>
                    ${item}
                </c:forEach>
            </table>
        </div>

        <form:form method="GET" action="/cart/checkout" >
            <input id="register" type="submit" value="CHECKOUT">
        </form:form>
    </div>
</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>
