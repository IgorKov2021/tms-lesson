
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Hello, ${name}</H1>
<h3>Add tasks for you:</h3>
<form method="post" action="/tasks">
<input type="text" name="task">
    <input type="hidden" name="login" value="${login}">
    <input type="submit" value="ADD">

   </form>

<form method="post" action="/showAll">
    <input type="submit" value="SHOW ALL TASKS">
</form>
<%-- <select name="task">
    <c:forEach var="user" items="${userList}">
        <option><c:out value="${user.name}" />  - <c:out value="${user.login}" /><</option>>
            <c:out value="${user.userActivities}" /></li>
    </c:forEach>

        <option name="1" value="">sdsd</option>
        <option name = "2"></option>
        <option name = "3">sdsd </option>
    </select>
    <input type="submit" value="ADD">--%>

<c:choose>
    <c:when test="${ taskEmpty == 'empty'}">
        <p>TASK NOT FOUND!</p>
    </c:when>
    <c:when test="${ taskEmpty == 'all'}">

       <ol>
            <c:forEach var = "act" items="${AllAct}"  >

                <li> ${act.name} - ${act.status}
                    </li>

            </c:forEach>
        </ol>
    </c:when>
<c:when test="${ taskEmpty == 'done'}">
    <ol>
        <c:forEach var = "actDone" items="${ActivityDone}"  >
            <c:choose>
                <c:when test = "${actDone.status =='DONE'}">
                </c:when>
                <c:otherwise>
                    <form method="post" action="/change">
                        <li> ${actDone.name} - ${actDone.status}<input type="hidden" name="actName" value="${actDone.name}">
                            <input type="submit" value="change" ></li></li>
                    </form>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ol>
</c:when>
    <c:otherwise>
        <ol>
            <c:forEach var = "act" items="${Activity}"  >
                <c:choose>
                <c:when test = "${act.status =='DONE'}">
                </c:when>
                <c:otherwise>
                    <form method="post" action="/change">
                    <li> ${act.name} - ${act.status}<input type="hidden" name="actName" value="${act.name}">
                        <input type="submit" value="change" ></li></li>
                </form>
                </c:otherwise>
                </c:choose>
            </c:forEach>
        </ol>
    </c:otherwise>
    </c:choose>


</body>
</html>
