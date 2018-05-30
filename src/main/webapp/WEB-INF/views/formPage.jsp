<%@ include file="headers/headerGeneric.jsp"%>
        <div id="nav">
            <div id="form">
                <form:form method="POST" action="/form/submit" modelAttribute="completeUserForm" >
                    <form:radiobutton path="title" value="Mr" /> Mr.
                    <form:radiobutton path="title" value="Miss" /> Miss
                    <form:radiobutton path="title" value="Mrs" /> Mrs.
                    <form:errors path="title"></form:errors>
                    <br>
                    <form:label path="name">NAME</form:label>
                    <form:input path="name"/>
                    <form:errors path="name"></form:errors>
                    <br>
                    <form:label path="surname">SURNAME</form:label>
                    <form:input path="surname"/>
                    <form:errors path="surname"></form:errors>
                    <br>
                    <form:label path="address">ADDRESS</form:label>
                    <form:input path="address"/>
                    <form:errors path="address"></form:errors>
                    <br>
                    <form:label path="number">NUMBER</form:label>
                    <form:input path="number"/>
                    <form:errors path="number"></form:errors>
                    <br>
                    <form:label path="cap">cap</form:label>
                    <form:input path="cap"/>
                    <form:errors path="cap"></form:errors>
                    <br>
                    <form:label path="city">city</form:label>
                    <form:input path="city"/>
                    <form:errors path="city"></form:errors>
                    <br>
                    <form:label path="nation">nation</form:label>
                    <form:input path="nation"/>
                    <form:errors path="nation"></form:errors>
                    <br>
                    <form:label path="email">email</form:label>
                    <form:input path="email"/>
                    <form:errors path="email"></form:errors>
                    <br>
                    <form:label path="password">password</form:label>
                    <form:input path="password"/>
                    <form:errors path="password"></form:errors>
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
