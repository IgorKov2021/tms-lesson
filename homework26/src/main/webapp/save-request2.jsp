<%@ page import="org.example.Application" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Заявка успешно сохранена!</H1>
<%
Object app = request.getAttribute("apps");
List<Application> apps = (ArrayList<Application>)app;
    out.write ("<h3>" + "Список заявок: </h3>  <br>");
   for (Application appAll: apps)
    {   out.write(appAll.getName() + " " + appAll.getDescription() + "<br>");


        }

%>
</body>
</html>
