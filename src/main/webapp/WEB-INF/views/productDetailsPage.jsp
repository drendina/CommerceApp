<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>
<div class="container" id="nav">
    <div class="card-group">
        <div class="card" id="prodImg">
            <img src="/risorse/img/products/${productData.image}" height="400px" width="400px" alt="Product image">
        </div>
        <div class="card" id="prodDetails">
            <div class="card-body">
                <h5 class="card-title">${productData.name}</h5>
                <hr>
                <p class="card-text">${productData.description}</p>
                <hr>
                <h6 class="card-subtitle mb-2 text-muted">Colore: ${productData.colore}</h6>
                <h6 class="card-subtitle mb-2 text-muted">Tessuto: ${productData.tessuto}</h6>
                <h6 class="card-subtitle mb-2 text-muted">Codice: ${productData.code}</h6>
                <c:choose>
                    <c:when test="${not empty loggedUser.name}">
                        <hr>
                        <h6 class="card-subtitle mb-2 text-muted">Select a size:</h6>
                        <c:forEach items="${listaSku}" var="x">
                            <a id="addToCart" onclick="addToCart('<c:out value="${x.idSku}"/>')" class="btn btn-primary" role="button">${x.size}</a>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>
</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>
<script type="text/javascript" src="/risorse/javascript/productDetails.js"></script>