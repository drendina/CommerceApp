<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>

<div id="nav">
    <div id="cartItems">
        <div class="card text-center">
            <div class="card-header">
                <h2>Cart</h2>
            </div>
            <div class="card-body" style = "display:inline-block;">
                    <c:forEach items="${itemList}" var="item">
                        <img src="/risorse/img/products/${item.image}" width="100" height="100"> </td>
                        <p style="border-right: 1px solid grey; display: inline-block">${item.name}</p>
                        <p style="border-right: 1px solid grey; display: inline-block">${item.size}</p>
                        <p style="border-right: 1px solid grey; display: inline-block">${item.quantity}</p>
                        <p style="border-right: 1px solid grey; display: inline-block">Prezzo: <c:out value="${singlePrice}"/> &euro;</p>
                        <p style="display: inline-block">Totale: ${item.cumulative_size_price}.0 &euro;</p>
                      <%--  <h5 class="card-title">${item.name}</h5>
                        <h5 class="card-title">${item.size}</h5>
                        <h5 class="card-title">Quantita: ${item.quantity}</h5>
--%>
                        <c:set var = "qty" value = "${item.quantity}"/>
                        <c:set var = "tot" value = "${item.cumulative_size_price}"/>
                        <c:set var = "singlePrice" value = "${tot/qty}"/>
                     <%--   <h5 class="card-title">Prezzo per articolo: <c:out value="${singlePrice}"/> &euro;</h5>
                        <h5 class="card-title">Totale per articolo/i: ${item.cumulative_size_price}.0 &euro;</h5>--%>
                        <a href="/cart/addToCartSmart?idSku=${item.idSku}&idCart=${currentCart.idCart}" class="btn btn-success" role="button">  Add  </a>
                        <a href="/cart/removeItem?idSku=${item.idSku}&idCart=${currentCart.idCart}" class="btn btn-danger" role="button">Remove</a>
                        <hr>
                    </c:forEach>
            </div>
            <div class="card-footer text-muted">
                Total: ${totalPrice} &euro;
                <form:form method="GET" action="/checkout" >
                    <button id="register" type="submit">Checkout</button>
                </form:form>
                <form:form method="GET" action="/index" >
                    <button id="continueShopping" type="submit">Continua gli acquisti</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>
<script src="/risorse/javascript/cartPage.js"></script>