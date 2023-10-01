<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 20.09.2023
  Time: 08:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr>

<a href="/?lang=eng">eng</a>
<a href="/?lang=ru">ru</a>
<a href="/?lang=de">de</a>
<hr>

<p>
    <spring:message code="label.title"></spring:message> <br>
    <spring:message code="label.body"></spring:message>
</p>
<hr>
<H1>BOOK SERVICE!!!</H1>
<form method="post" action="/">
    Title:      <input type="text" name="title"> ${title_error}<br>
    Author:     <input type="text" name="author">${author_error}<br>
    Pages:      <input type="number" name="pages">${pages_error}<br>
    <input type="submit" value="Add">
</form>

<form method="post" action="/show">

    <input type="submit" value="ShowALL">
</form>
<form method="post" action="/search">
    Title:      <input type="text" name="title"><br>
    <input type="submit" value="Search">
</form>
<ol>
    <c:forEach var="book" items="${all}">
        <li> ${book.author} - ${book.title} - ${book.pages}
        </li>
    </c:forEach>
</ol>
</body>
</html>
