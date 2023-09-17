<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 15.09.2023
  Time: 07:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>BOOKS</H1>
<form method="post" action="/books">
    Name of the book: <input type="text" name="title"><br>
    <input type="submit" value="Search">
</form>
<h1>
    ${message}
</h1>
<ol>
    <c:forEach var="book" items="${books}">
        <li> ${book.author} - ${book.title} - ${book.numberOfPages}
        </li>
    </c:forEach>
</ol>
</body>
</html>
