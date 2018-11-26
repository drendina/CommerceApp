<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>
    <div id="nav">
      <h1> Admin management page </h1>

        <button type=submit  name="insertProduct" OnClick=mostra(name)>Insert New Product</button>
        <button type=submit  name="insertAdmin" OnClick=mostra(name)>Insert New Admin</button>

        <%-- TODO: MODALI? --%>

        <div id="insertProduct" class="variabile" style="display: none;">
            <form:form class="needs-validation" method="POST" action="/management/insert" modelAttribute="productData" enctype = "multipart/form-data">
                <h4>Insert new product</h4>

                <div class="form-group col-md-10">
                    <label for="name">Name</label>
                    <form:input type="text" class="form-control" id="name" path="name" />
                </div>

                <div class="form-group col-md-10">
                    <label for="description">Description</label>
                    <form:textarea class="form-control" id="description" path="description" rows="3"></form:textarea>
                </div>

                <div class="form-group col-md-10">
                    <input id="loadingimage" type = "file" name = "file" size = "50" />
                    <form:input id="inputLoadingImage" type = "hidden" name = "image" value="" path="image"/>
                    <%--<label for="image">Image</label>
                    <form:input type="text" class="form-control" id="image" path="image" placeholder="Example: image.jpg"/>--%>
                </div>

                <div class="form-group col-md-10">
                    <label for="code">Code</label>
                    <form:input type="text" class="form-control" id="code" path="code" />
                </div>

                <div class="form-group col-md-10">
                    <label for="colore">Colore</label>
                    <form:input type="text" class="form-control" id="colore" path="colore" />
                </div>

                <div class="form-group col-md-10">
                    <label for="tessuto">Tessuto</label>
                    <form:input type="text" class="form-control" id="tessuto" path="tessuto" />
                </div>

                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="category">Category</label>
                        <form:select class="form-control" id="category" path="category">
                            <option selected>Choose title</option>
                            <option value="BAGS">Bags</option>
                        </form:select>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="gender">Gender</label>
                        <form:select class="form-control" id="gender" path="gender">
                            <option selected>Choose title</option>
                            <option value="MALE">Male</option>
                            <option value="FEMALE">Female</option>
                        </form:select>
                    </div>
                </div>
                <button id="submitButton" type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>

        <div id="insertAdmin" class="variabile" style="display: none;">
            <form:form class="needs-validation" method="POST" action="/management/submit" modelAttribute="completeUserForm">
                <h4>Personal data</h4>

                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="title">Title</label>
                        <form:select class="form-control" path="title">
                            <option selected>Choose title</option>
                            <option value="Mr">Mr.</option>
                            <option value="Miss">Miss</option>
                            <option value="Mrs">Mrs.</option>
                        </form:select>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="name">Name</label>
                        <form:input type="text" class="form-control" path="name" placeholder="John" />
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="surname">Surname</label>
                        <form:input type="text" class="form-control" path="surname" placeholder="Doe"/>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-10">
                        <label for="address">Address</label>
                        <form:input type="text" class="form-control" path="address" placeholder="1234 Main St"/>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="cap">Zip</label>
                        <form:input type="text" class="form-control" path="cap"/>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="city">City</label>
                        <form:input type="text" class="form-control" path="city"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="nation">State</label>
                        <form:input type="text" class="form-control" path="nation"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="number">Phone number</label>
                        <form:input type="number" class="form-control" path="number"/>
                    </div>
                </div>

                <hr>

                <h4>Sign in data</h4>

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="email">Email</label>
                        <form:input type="email" class="form-control" path="email" placeholder="Email"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="password">Password</label>
                        <form:input type="password" class="form-control" path="password" placeholder="Password"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="passwordRepeat">Password</label>
                        <form:input type="password" class="form-control" path="passwordRepeat" placeholder="Repeat Password"/>
                    </div>
                </div>

                <hr>
                <h4>Policy</h4>

                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="newsletter">Subscribe to Newsletter</label>
                        <form:select class="form-control" path="newsletter">
                            <option selected value="YES">Yes</option>
                            <option value="NO">No</option>
                        </form:select>
                    </div>
                        <%--
                        <div class="form-group col-md-2">
                            <label for="phoneAgreeement">Receive SMS with last offer</label>
                            <form:select class="form-control" path="phoneAgreeement">
                                <option selected value="YES">Yes</option>
                                <option value="NO">No</option>
                            </form:select>
                        </div>
                        --%>
                </div>

                <button type="submit" class="btn btn-primary">Sign in</button>
            </form:form>
        </div>
    </div>


    <script language="javascript">
        function mostra(name)
        {
            if(document.getElementById(name).style.display == "block"){
                document.getElementById(name).style.display = "none";
            }else{
                document.getElementById(name).style.display = "block"
            }
        }


        var filename = $('[type="file"]').val().split('\\').pop();
        document.getElementById('submitButton').on("click", function(){
            alert("Sto funzionando!!!");
            this.image = filename;
        })
    </script>

</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>