<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<custom:mainLayout>

    <div id="nav">
        <h1> Account settings </h1>
        ${loggedUser}
        <form:form class="needs-validation" method="POST" action="/form/submit" modelAttribute="loggedUser">
            <h4>Personal data</h4>

            <%--<div class="form-row">
                <div class="form-group col-md-10">
                    <label for="address">Address</label>
                    <form:input type="text" class="form-control" path="addresses" placeholder="1234 Main St"/>
                </div>
                <div class="form-group col-md-2">
                    <label for="cap">Zip</label>
                    <form:input type="text" class="form-control" path="cap"/>
                </div>
            </div>--%>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="title">Title</label>
                    <form:select class="form-control" path="title">
                        <c:choose>
                            <c:when test="${title == Mr}">
                                <option selected value="Mr">Mr.</option>
                                <option value="Miss">Miss</option>
                                <option value="Mrs">Mrs.</option>
                            </c:when>
                            <c:when test="${title == Miss}">
                                <option value="Mr">Mr.</option>
                                <option selected value="Miss">Miss</option>
                                <option value="Mrs">Mrs.</option>
                            </c:when>
                            <c:when test="${title == Mrs}">
                                <option value="Mr">Mr.</option>
                                <option value="Miss">Miss</option>
                                <option selected value="Mrs">Mrs.</option>
                            </c:when>
                            <c:otherwise>
                                <option selected>Choose title</option>
                                <option value="Mr">Mr.</option>
                                <option value="Miss">Miss</option>
                                <option value="Mrs">Mrs.</option>
                            </c:otherwise>
                        </c:choose>
                    </form:select>
                </div>
                <div class="form-group col-md-5">
                    <label for="name">Name</label>
                    <form:input type="text" class="form-control" path="name"/>
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                </div>
                <div class="form-group col-md-5">
                    <label for="surname">Surname</label>
                    <form:input type="text" class="form-control" path="surname"/>
                </div>

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

                    <%--<div class="form-group col-md-4">
                        <label for="passwordRepeat">Password</label>
                        <form:input type="password" class="form-control" path="passwordRepeat" placeholder="Repeat Password"/>
                    </div>--%>
                </div>

            </div>

            <%--<div class="form-row">
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



            <hr>
            <h4>Policy</h4>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="newsletter">Subscribe to Newsletter</label>
                    <form:select class="form-control" path="newsletter">
                        <option selected value="YES">Yes</option>
                        <option value="NO">No</option>
                    </form:select>
                </div>--%>
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
</custom:mainLayout>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>