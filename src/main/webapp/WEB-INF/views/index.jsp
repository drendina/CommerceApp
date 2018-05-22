<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title> <spring:message code="message.mainTitle"/> </title>
        <link href="<c:url value="/risorse/style.css" />" rel="stylesheet">
    </head>
    
    <body>
        <div id="header">
            <div id="logo" class="floating">
                <div id="imgLogo" class="floating"> <img src="/risorse/img/logo-gucci.png"></div>
                <div id="language" class="floating">
                    <a class="flags" id="italianFlag" href="/index/changeLanguageItalian"><img border="0" alt="Italian" src="/risorse/img/italy.png" width="32" height="24"></a>
                    <a class="flags" href="/index/changeLanguageEnglish"><img border="0" alt="English" src="/risorse/img/uk.png" width="32" height="24"></a>
                </div>
            </div>
            
            <div id="cart" class="floating">
                <div id="cartImg" class="floating">
                    <c:choose>
                        <c:when test="${empty loggedUser.name}">
                            <form:form method="GET" action="/index/registration" >
                                <input id="register" type="submit" value="REGISTER">
                            </form:form>
                        </c:when>
                        <c:otherwise>
                            ${cart}
                            <form:form method="GET" action="/cart/" >
                                <input id="register" type="submit" value="GO TO CART">
                            </form:form>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div id="cartQty" class="floating"></div>
            </div>
            
            <div id="login" class="floating">
                 <c:choose>
                    <c:when test="${empty loggedUser.name}">
                        <form:form id="registerForm" method="GET" action="/index/login" modelAttribute="user" >
                            Email:<form:input path="email" id="emailInput"/>
                            <br>
                            Password: <form:input path="password" id="pwdInput"/>
                            <input id="submit "type="submit" value="LOGIN">
                        </form:form>
                    </c:when>
                    <c:otherwise>
                        <form:form method="GET" action="/index/logout" id="registerForm">
                            <div>
                                 ${loggedUser.title} ${loggedUser.name} ${loggedUser.surname}
                                <input type="submit" value="LOGOUT">
                            </div>
                        </form:form>
                    </c:otherwise>
                </c:choose>
 
            </div>
        </div>
        
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
        
        <div id="footer">
            <div id="manage" class="floating thitrythree">
               <c:choose>
                   <c:when test="${loggedUser.role == 'ADMIN'}">
                       <h6>INSERIRE COLLEGAMENTO A MANAGEMENT PAGE</h6>
                   </c:when>
                   <c:otherwise>
                       <span>Copyright 2018 Gucci. Inc</span>
                   </c:otherwise>
               </c:choose>
            </div>
            
            <div id="contact_us" class="floating thitrythree">
                <span> CONTACT US </span> <br>
                <span>gucci@gucci.com</span><br>
                <span>+39 0001234567</span>
            </div>
            
            <div id="follow_us" class="floating thitrythree">
                <a target="_blank" title="follow me on instagram" href="http://www.instagram.com/gucci/"><img alt="follow me on instagram" src="https://c866088.ssl.cf3.rackcdn.com/assets/instagram30x30.png" border=0></a>
                <a target="_blank" title="follow me on Twitter" href="http://www.twitter.com/gucci"><img alt="follow me on Twitter" src="https://c866088.ssl.cf3.rackcdn.com/assets/twitter30x30.png" border=0></a>
                <a target="_blank" title="follow me on facebook" href="http://www.facebook.com/GUCCI/"><img alt="follow me on facebook" src="https://c866088.ssl.cf3.rackcdn.com/assets/facebook30x30.png" border=0></a>
            </div>
        </div>
        
       <script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
        <script src="/risorse/node_modules/mustache/mustache.js"></script>
        <script type="text/javascript" src="/risorse/javascript/index.js"></script>
    </body>
</html>