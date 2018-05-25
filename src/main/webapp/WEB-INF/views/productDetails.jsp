<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/risorse/style.css" />" rel="stylesheet">
</head>
<body>
    <div id="header">
        <%--uguale all'homepage ma senza il <div id="cart">--%>
    </div>

    <div id="nav">
        <div id="prodDetails">
            <%-- --%>
                    <h1>PRODUCT DETAILS</h1>
                     <%--${productData}--%>
            <%-- --%>
            
            
            <div id="img" class="floating product"> <img class="prodImage" src="/risorse/img/${productData.image}" height="400px" width="400px"></div>
            
            <div id="information" class="floating product">
                <h2>${productData.name}</h2>
                <h5>${productData.description}</h5>
                <h3>
                    CODICE: ${productData.idProduct}
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
                        <button><a href="/cart/addToCart?idSku=1"/>small</button>
                    </c:otherwise>
                </c:choose>
                
                
                
                
            </div>
            
            
            
        </div>
    </div>
    
    
    <div id="footer">
        <%--uguale all'homepage--%>
    </div>
    
    <script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
    <script src="/risorse/node_modules/mustache/mustache.js"></script>
    <script type="text/javascript" src="/risorse/javascript/productDetails.js"></script>
    
    </body>

</html>