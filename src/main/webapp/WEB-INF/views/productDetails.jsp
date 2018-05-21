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
                
                <form:form method="POST" action="/cart/addToCart" modelAttribute="listaSku">
                  
                    <form:select path="empty">
                        <form:option value="NONE" label="--- Select Size ---"/>
                        <form:options items="${listaSku}"  itemValue="idSku"/>
                    </form:select>
        
                    <input id="addToCart" type="submit" value="ADD TO CART">
                </form:form>
            </div>
            
            
            
        </div>
    </div>
    <div id="footer">
        <%--uguale all'homepage--%>
    </div>
    </body>

</html>