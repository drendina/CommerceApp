<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header"></div>
<div id="nav">
    <div id="form">
        <%--aggiungere action="formPage/submit" modelAttribute="completeUserForm"--%>
        <form:form method="POST" action="/form/submit" modelAttribute="completeUserForm" >
            <form:radiobutton path="title" value="Mr" /> Mr.
            <form:radiobutton path="title" value="Miss" /> Miss
            <form:radiobutton path="title" value="Mrs" /> Mrs.
            <br>
            
            <form:label path="name">NAME</form:label>
            <form:input path="name"/>
            <br>
    
            <form:label path="surname">SURNAME</form:label>
            <form:input path="surname"/>
            <br>
    
            <form:label path="address">ADDRESS</form:label>
            <form:input path="address"/>
            <br>
    
            <form:label path="number">NUMBER</form:label>
            <form:input path="number"/>
            <br>
    
            <form:label path="cap">cap</form:label>
            <form:input path="cap"/>
            <br>
    
            <form:label path="city">city</form:label>
            <form:input path="city"/>
            <br>
    
            <form:label path="nation">nation</form:label>
            <form:input path="nation"/>
            <br>
    
            <form:label path="email">email</form:label>
            <form:input path="email"/>
            <br>
    
            <form:label path="password">password</form:label>
            <form:input path="password"/>
            <br>
            
            <form:radiobutton path="newsletter" value="YES" /> Yes
            <form:radiobutton path="newsletter" value="NO" /> No
            <br>
            
            <form:button name="submit">Submit</form:button>
        </form:form>
        
    </div>
</div>
<div id="footer"></div>

</body>
</html>
