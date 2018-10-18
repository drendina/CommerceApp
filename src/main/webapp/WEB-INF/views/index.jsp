<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>

    <div class="container" id="nav">
        <div class="row">
            <div class="col"></div>
            <div class="col-10">
                <script id="template" type="x-tmpl-mustache">
                    <div>
                        <a href="/product/productDetails?idProduct={{idProduct}}"><img src="/risorse/img/products/{{image}}" width="200" height="200"></a>
                        <span>
                            {{name}}
                            {{colore}}
                        </span>
                    </div>
            </script>
                <div id="showData"></div>
            </div>
            <div class="col"></div>
        </div>
    </div>

</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="/risorse/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/risorse/javascript/index.js"></script>
<script type="text/javascript" src="/risorse/javascript/everywhere.js"></script>

