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
                <form>
                    <c:forEach items="${listaSku}" var="S">
                        <input type="checkbox" value="${S.idSku}"/> ${S.size}
                    </c:forEach>
                    <input id="idSku" type="submit" value="submit">
                </form>
                <form:form method="POST" action="/cart/addToCart" modelAttribute="listaSku">
                  
                    <%--<form:select path="empty">--%>
                        <%--<form:option value="NONE" label="--- Select Size ---"/>--%>
                        <%--<form:options items="${listaSku}"  itemValue="idSku"/>--%>
                    <%--</form:select>--%>
                    ${listaSku}
                    <%--<form>--%>
                        <%--<input type="checkbox" id="tg_S" value="1" >--%>
                        <%--<label for="tg_S">Taglia S</label>--%>
                        <%--<input type="checkbox" id="tg_M" value="2">--%>
                        <%--<label for="tg_M">Taglia M</label>--%>
                        <%--<input type="checkbox" id="tg_L" value="3">--%>
                        <%--<label for="tg_L">Taglia L</label>--%>
                        <%--<input id="addToCart1" type="submit" value="ADD TO CART1">--%>
                    <%--</form>--%>
        
                    <%--<input id="addToCart" type="submit" value="ADD TO CART">--%>
                </form:form>
                
                <form:form method="GET" action="/cart/addToCart?idSku=1">
                    <input id="addToCart" type="submit" value="ADD SKU TO CART">
                </form:form>
    
                <form:form method="POST" action="/cart/addToCart" value="idSku">
                    <input type="text">
                    <input id="register" type="submit" value="sub">
                </form:form>

            </div>
            
            
            
        </div>
    </div>
    <div id="footer">
        <%--uguale all'homepage--%>
    </div>
    </body>

</html>