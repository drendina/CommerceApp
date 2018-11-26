<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>
    <%--
    <div id="nav">
        <h1> Category Page</h1>
        ${categoryList}
    </div>
    --%>
    <div class="container" id="nav">
        <h3>Category Page</h3>
        <div class="row">
                <%--<div class="col"></div>--%>
            <div class="col-10">

                <script id="templateCategory" type="x-tmpl-mustache">
                        <div class="card">
                            <a href="/product/productDetails?idProduct={{idProduct}}"><img src="/risorse/img/products/{{image}}" width="300" height="300"></a>

                        </div>
                    </script>
                <div class="card-group" id="showDataCategory"></div>
            </div>
                <%--<div class="col"></div>--%>
        </div>
    </div>

</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="/risorse/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="/risorse/javascript/categoryPage.js"></script>