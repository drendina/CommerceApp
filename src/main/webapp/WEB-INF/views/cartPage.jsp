<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>

<div id="nav">
        <div id="cartItems">
            <h1>CARTPAGE</h1>
            <hr>
            <%--<script id="template" type="x-tmpl-mustache">
                <div class="card">
                    <a href="/product/productDetails?idProduct={{idProduct}}"><img src="/risorse/img/products/{{image}}" width="300" height="300"></a>
                    <div class="card-body">

                        &lt;%&ndash;<h5 class="card-title"> {{name}} </h5>&ndash;%&gt;
                        &lt;%&ndash;<p class="card-text">{{description}}</p>&ndash;%&gt;
                    </div>
                </div>
            </script>
            <div class="card-group" id="showData"></div>--%>

            <%--TODO lista di elementi con mustache--%>
            <table>
                <%--${itemList}--%>
           
                <c:forEach items="${itemList}" var="item">
                    <%--<tr>
                        <td> ${item.name} </td>
                        <td> ${item.price} </td>
                    </tr>--%>
                    ${item}
                    ${item.idSku}
                    ${item.idCart}
                    ${item.idSku_cart}
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
