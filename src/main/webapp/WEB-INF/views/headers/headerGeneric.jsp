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
        
        </div>
        <div id="cartQty" class="floating"></div>
    </div>
    
    <div id="login" class="floating">

    </div>
</div>