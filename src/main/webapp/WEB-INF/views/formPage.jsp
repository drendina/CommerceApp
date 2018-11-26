<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>
        <div class="container" id="nav">
        <%--
                <h2>LOGIN</h2>

                <div id="login2" >
                    <form:form id="registerForm" method="GET" action="/index/login" modelAttribute="login" >
                        Email:<form:input path="emailLogin" id="emailInput"/>
                        <form:errors path="emailLogin"></form:errors>
                        <br>
                        Password: <form:password path="passwordLogin" id="pwdInput"/>
                        <form:errors path="passwordLogin"></form:errors>

                        <input id="submitLogin" type="submit" value="LOGIN">
                    </form:form>
                </div>
                <hr>
                <hr>
        --%>
            <h2>REGISTRATION</h2>
            <form:form class="needs-validation" method="POST" action="/form/submit" modelAttribute="completeUserForm">
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
            <script>
                // Example starter JavaScript for disabling form submissions if there are invalid fields
                (function() {
                    'use strict';
                    window.addEventListener('load', function() {
                        // Fetch all the forms we want to apply custom Bootstrap validation styles to
                        var forms = document.getElementsByClassName('needs-validation');
                        // Loop over them and prevent submission
                        var validation = Array.prototype.filter.call(forms, function(form) {
                            form.addEventListener('submit', function(event) {
                                if (form.checkValidity() === false) {
                                    event.preventDefault();
                                    event.stopPropagation();
                                }
                                form.classList.add('was-validated');
                            }, false);
                        });
                    }, false);
                })();
            </script>


<%--
            <form:form method="POST" action="/form/submit" modelAttribute="completeUserForm" >
                <form:radiobutton path="title" value="Mr" /> Mr.
                <form:radiobutton path="title" value="Miss" /> Miss
                <form:radiobutton path="title" value="Mrs" /> Mrs.
                <form:errors path="title"></form:errors>
                <br>
                <form:label path="name">Name</form:label>
                <form:input path="name"/>
                <form:errors path="name"></form:errors>
                <br>
                <form:label path="surname">Surname</form:label>
                <form:input path="surname"/>
                <form:errors path="surname"></form:errors>
                <br>
                <form:label path="address">Address</form:label>
                <form:input path="address"/>
                <form:errors path="address"></form:errors>
                <br>
                <form:label path="number">Phone number</form:label>
                <form:input path="number"/>
                <form:errors path="number"></form:errors>
                <br>
                <form:label path="cap">Zipcode</form:label>
                <form:input path="cap"/>
                <form:errors path="cap"></form:errors>
                <br>
                <form:label path="city">City</form:label>
                <form:input path="city"/>
                <form:errors path="city"></form:errors>
                <br>
                <form:label path="nation">Nation</form:label>
                <form:input path="nation"/>
                <form:errors path="nation"></form:errors>
                <br>
                <form:label path="email">Email</form:label>
                <form:input path="email"/>
                <form:errors path="email"></form:errors>
                <br>
                Password: <form:password path="password" />
                <%--<form:input path="password"/>
                <form:errors path="password"></form:errors>
                <br>
                Repeat password: <form:password  path="passwordRepeat"/>
                <%--<form:input path="passwordRepeat"/>
                <form:errors path="passwordRepeat"></form:errors>
                <br>
                <form:radiobutton path="newsletter" value="YES" /> Yes
                <form:radiobutton path="newsletter" value="NO" /> No
                <form:errors path="newsletter"></form:errors>
                <br>
                <form:button name="submit">Submit</form:button>
            </form:form>
--%>
           
        </div>
</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>

