<%@ include file="headers/headerGeneric.jsp"%>
        <div id="nav">
            <div id="form">
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
                    <%--<form:input path="password"/>--%>
                    <form:errors path="password"></form:errors>
                    <br>
                    Repeat password: <form:password  path="passwordRepeat"/>
                    <%--<form:input path="passwordRepeat"/>--%>
                    <form:errors path="passwordRepeat"></form:errors>
                    <br>
                    <form:radiobutton path="newsletter" value="YES" /> Yes
                    <form:radiobutton path="newsletter" value="NO" /> No
                    <form:errors path="newsletter"></form:errors>
                    <br>
                    <form:button name="submit">Submit</form:button>
                </form:form>
                
            </div>
        </div>
<%@ include file="footers/footer.jsp"%>
