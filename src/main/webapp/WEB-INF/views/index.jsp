<%@ include file="headers/headerHome.jsp"%>
        <div id="nav">
            <div id="mustache">
                <script id="template" type="x-tmpl-mustache">
                    <div>
                        <a href="/product/productDetails?idProduct={{idProduct}}"><img src="/risorse/img/{{image}}" width="200" height="200"></a>
                        <span>
                            {{name}}
                            {{colore}}
                        </span>
                    </div>
                </script>
                
                <div id="showData"></div>
             <%--template mustache che inserisce i div dei signoli prodotti--%>
            </div>
        </div>

<%@ include file="footers/footer.jsp"%>