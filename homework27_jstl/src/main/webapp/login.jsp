
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
</form>
<form method="get" action="/newUser">
    <input class="my" type="submit" value="Register">

</form>

<c:choose>
    <c:when test="${ blank == 'blank'}">
        <p>FIELDS LOGIN AND PASSWORD CAN NOT BE EMPTY! </p>
    </c:when>
    <c:when test="${ wrongPassword == 'wrong'}">
        <p>WRONG LOGIN OR PASSWORD!</p>
        </c:when>
</c:choose>


</body>
</html>
