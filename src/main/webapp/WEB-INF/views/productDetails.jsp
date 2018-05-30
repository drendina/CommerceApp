<%@ include file="headers/headerGeneric.jsp"%>
    <div id="nav">
        <div id="prodDetails">
            <%-- --%>
                    <h1>PRODUCT DETAILS</h1>
                     <%--${productData}--%>
            <%-- --%>
                <img class="prodImage" src="/risorse/img/${productData.image}" height="400px" width="400px">
            
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
                        <button id="productSelectBtn"><a href="/cart/addToCart?idSku=1"/>small</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
<%@ include file="footers/footer.jsp"%>