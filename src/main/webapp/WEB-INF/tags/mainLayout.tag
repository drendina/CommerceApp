<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title> <spring:message code="message.mainTitle"/> </title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="<c:url value="/risorse/style.css" />" rel="stylesheet">
    </head>
    
    <body>

        <nav class="navbar navbar-light background">
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" title="Change language" aria-haspopup="true" aria-expanded="false" style="background-color: #c6d4fd">
                    <img border="0" alt="Select language" src="/risorse/img/icons/globe.png" width="36" height="36">
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="/index/changeLanguageItalian"><img border="0" alt="Italian" src="/risorse/img/italy.png" width="48" height="36"> Italiano </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/index/changeLanguageEnglish"><img border="0" alt="English" src="/risorse/img/uk.png" width="48" height="36"> Inglese </a>
                </div>
            </div>

            <a class="navbar-brand" href="/index/" title="Go home"><img src="/risorse/img/logo-gucci.png" width="auto" height="32" class="d-inline-block align-top" alt="GUCCI HOME"></a>

            <c:choose>
                <c:when test="${empty loggedUser.name}">
                    <!--
                    <a href="/form/registration"><img border="0" alt="Registration" src="/risorse/img/icons/user.png" width="36" height="36"></a>
                    -->
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" style="background-color: #c6d4fd">
                        <img border="0" alt="Registration" src="/risorse/img/icons/user.png" width="36" height="36">
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Login</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form:form id="registerForm" method="POST" action="/index/login"  modelAttribute="login" >
                                        <div class="form-group">
                                            <label for="emailInput">Email address</label>
                                            <form:input type="email" path="emailLogin" class="form-control" id="emailInput" placeholder="Enter email"/>
                                            <form:errors path="emailLogin"></form:errors>
                                        </div>
                                        <div class="form-group">
                                            <label for="pwdInput">Password</label>
                                            <form:input type="password" path="passwordLogin" class="form-control" id="pwdInput" placeholder="Password"/>
                                            <form:errors path="passwordLogin"></form:errors>
                                        </div>

                                        <button id="submitLogin" type="submit" class="btn btn-primary">Submit</button>

                                        <%-- <input id="submitLogin" type="submit" value="LOGIN"> --%>
                                    </form:form>
                                    <!--
                                    <form method="post" action="/index/login" modelAttribute="login">
                                        <div class="form-group">
                                            <label for="emailInput">Email address</label>
                                            <input type="email" class="form-control" id="emailInput" aria-describedby="emailHelp" placeholder="Enter email">
                                        </div>
                                        <div class="form-group">
                                            <label for="pwdInput">Password</label>
                                            <input type="password" class="form-control" id="pwdInput" placeholder="Password">
                                        </div>
                                        <button id="submitLogin" type="submit" class="btn btn-primary">Submit</button>
                                    </form>
                                    -->
                                </div>

                                <div class="modal-footer">
                                    <label for="notUser">Not registered yet?</label>
                                    <a id="notUser" class="btn btn-primary" href="/form/registration" role="button">Register</a>
                                </div>

                            </div>
                        </div>
                    </div>

                </c:when>
                <c:otherwise>
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color: #c6d4fd">
                            <img border="0" alt="My Account" src="/risorse/img/icons/myAccount.png" width="27" height="27">
                        </button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                            <input type="text" readonly class="form-control-plaintext greetings background" id="staticEmail" value="Hi ${loggedUser.name}!">
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/cart/"><img border="0" alt="Registration" src="/risorse/img/icons/cart.png" width="36" height="36"> Go to cart </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/myAccount/"><img border="0" alt="Registration" src="/risorse/img/icons/gear.png" width="36" height="36">Account Settings</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/index/logout"><img border="0" alt="Registration" src="/risorse/img/icons/logout.png" width="36" height="36">Logout</a>
                        </div>
                    </div>

                </c:otherwise>
            </c:choose>

        </nav>

        <div class="container">
            <jsp:doBody />
        </div>


        <nav class="navbar navbar-light navbax-fixed-down" style="background-color: #c6d4fd;">
            <div class="copy">
                <c:choose>
                    <c:when test="${loggedUser.role == 'ADMIN'}">
                        <a id="management" href="/management"><img border="0" alt="Gear" src="/risorse/img/icons/gear.png" width="48" height="48"></a>
                    </c:when>
                    <c:otherwise>
                        <%--TODO--%>
                        <button type="button" class="btn" data-toggle="popover" title="Copyright:" data-content="2018 Gucci. Inc"><img border="0" alt="Copyright" src="/risorse/img/icons/copy.png" width="30" height="30"></button>

                    </c:otherwise>
                </c:choose>
            </div>

            <div class="contactUsContainer">
              <%--  <a target="_blank" title="Email us:" href="gucci@gucci.com"><img alt="Email us:" src="/risorse/img/icons/email.png" border=0 width="30" height="30"></a>
                <a target="_blank" title="Call us:" href="gucci@gucci.com"><img alt="Email us:" src="/risorse/img/icons/email.png" border=0 width="30" height="30"></a>--%>
                <button type="button" class="btn background" data-toggle="popover" title="Email us:" data-content="gucci@gucci.com"><img border="0" alt="Gear" src="/risorse/img/icons/email.png" width="30" height="30"></button>
                <button type="button" class="btn background" data-toggle="popover" title="Call us at:" data-content="+39 0001234567"><img border="0" alt="Gear" src="/risorse/img/icons/phone.png" width="30" height="30"></button>
            </div>

            <%--<div class="dropup">
                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color: #c6d4fd">
                    <img border="0" alt="Need help?" src="/risorse/img/icons/help.png" width="36" height="36">
                </button>
                <div class="dropdown-menu dropdown-menu-right social-dropdown" aria-labelledby="dropdownMenuButton">
                    &lt;%&ndash; TODO:fix &ndash;%&gt;

                    <a class="dropdown-item" target="_blank" title="Email us:" href="gucci@gucci.com"><img alt="Email us:" src="/risorse/img/icons/email.png" border=0 width="30" height="30"></a>
                    <div class="dropdown-divider"></div>
                    <button type="button" class="btn" data-toggle="popover" title="Call us at:" data-trigger="hover" data-content="+39 0001234567"><img border="0" alt="Gear" src="/risorse/img/icons/phone.png" width="48" height="48"></button>
                </div>
            </div>--%>

            <div class="dropup">
                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color: #c6d4fd">
                    <img border="0" alt="My Account" src="/risorse/img/icons/networking.png" width="30" height="30">
                </button>
                <div class="dropdown-menu dropdown-menu-right social-dropdown" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" target="_blank" title="follow me on instagram" href="http://www.instagram.com/gucci/"><img alt="follow me on instagram" src="https://c866088.ssl.cf3.rackcdn.com/assets/instagram30x30.png" border=0></a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" target="_blank" title="follow me on Twitter" href="http://www.twitter.com/gucci"><img alt="follow me on Twitter" src="https://c866088.ssl.cf3.rackcdn.com/assets/twitter30x30.png" border=0></a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" target="_blank" title="follow me on facebook" href="http://www.facebook.com/GUCCI/"><img alt="follow me on facebook" src="https://c866088.ssl.cf3.rackcdn.com/assets/facebook30x30.png" border=0></a>
                </div>
            </div>
        </nav>

            <script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
            <script src="/risorse/node_modules/mustache/mustache.js"></script>
            <script type="text/javascript" src="/risorse/javascript/everywhere.js"></script>
            <%--<script type="text/javascript" src="/risorse/javascript/checkout.js"></script>
            <script type="text/javascript" src="/risorse/javascript/productDetails.js"></script>--%>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        </body>


</html>