<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>
    <div id="nav">
        <div id="prodDetails">
            <%-- --%>
                    <h1>PRODUCT DETAILS</h1>
                     <%--${productData}--%>
            <%-- --%>
                <img class="prodImage" src="/risorse/img/products/${productData.image}" height="400px" width="400px">
            
            <div id="information" class="floating product">
                <h2>${productData.name}</h2>
                <h5>${productData.description}</h5>
                <h3>
                    CODICE: 200110${productData.idProduct}000
                    <br>
                    COLORE: ${productData.colore}
                    <br>
                    TESSUTO: ${productData.tessuto}
                </h3>
                
                <%--<c:forEach items="${listaSku}" var="S">--%>
                    <%--<form:form method="get" action="/cart/addToCart?idSku=${S.idSku}"  >--%>
                        <%--<button><a href="/cart/addToCart?idSku=${S.idSku}"/>${}</button>--%>
                    <%--</form:form>--%>
                <%--</c:forEach>--%>
                
                <c:choose>
                    <c:when test="${empty loggedUser.name}">
                    
                    </c:when>
                    <c:otherwise>
                   
                        <c:forEach items="${listaSku}" var="x">
                            <button id="productSelectBtn"><a href="/cart/addToCart?idSku=${x.idSku}"/>${x.size}</button>
                            ${x.size}
                           
                        </c:forEach>
                        
                        <%--<form:form method = "GET" action = "/cart/addToCart?idSku${listaSku.idSku}" modelAttribute="productData">
                            <form:select path="idProduct">
                                <form:option value="-1" label="--- Select Size ---"/>
                                <form:options items="${listaSku}"/>
                                <input type = "submit">
                            </form:select>
                        </form:form>--%>
                        <%--<button id="productSelectBtn"><a href="/cart/addToCart?idSku=1"/>small</button>--%>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>
<script type="text/javascript" src="/risorse/javascript/productDetails.js"></script>