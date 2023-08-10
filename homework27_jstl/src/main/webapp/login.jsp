
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<html>
<head>
    <style><%@ include file="/my.css" %></style>
    <title>Title</title>
</head>

<body>
<form method="post" action="/">
    <h3>Sign in or register!</h3>
    login: <input type="text" name="login">
    Password: <input type="password" name="password"> <br><br>
    <input type="submit" value="Sign in">
    <input class="my" type="submit" value="Register">
</form>
</body>
</html>
