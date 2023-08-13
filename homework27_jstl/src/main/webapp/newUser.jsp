
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Title</title>

</head>
<body>
<form method="post" action="/newUser">
    <h3>Sign in or register!</h3>
    Name: <input type="text" name="name">
    Login: <input type="text" name="login">
    Surname: <input type="text" name="surname">
    E-mail: <input type="text" name="email">
    Password: <input type="password" name="password">
    <input type="submit" value="SAVE">
</form>

<c:if test="${repeat == true}">
    <p>LOGIN IS ALREADY EXISTS OR fill in the required fields "login" and "password"!</p>
</c:if>
</body>
</html>
