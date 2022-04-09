<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 4/5/22
  Time: 7:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>

<form:form modelAttribute="user" action="form">
    Name: <form:input path="name"/><br/><br/>
    Surname: <form:input path="surname"/><br/><br/>
    Username: <form:input path="username"/><br/><br/>
    Age: <form:input path="age"/><br/><br/>
    <input type="submit" value="Send"/>
</form:form>

</body>
</html>
