<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header">
    <%--uguale all'homepage ma senza il <div id="cart">--%>
</div>
<div id="body">
    <div id="cartItems">
        <h1>CARTPAGE</h1>
        <%--lista di elementi con mustache--%>
    </div>
    
    <form:form method="GET" action="/cart/checkout" >
        <input id="register" type="submit" value="CHECKOUT">
    </form:form>
</div>
<div id="footer">
    <%--uguale all'homepage--%>
</div>
</body>
</html>
