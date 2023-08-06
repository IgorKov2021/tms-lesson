
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Введите название заявки и описание в форме ниже</h1>

<%
   Object desc = request.getAttribute("description");
    Object name = request.getAttribute("name");
    if (name == null && desc == null) {
        out.write(
                "<form method='post' action='/'> Название <input type='text' " +
                        "name='name'>" +
                        "<br> <br> Описание <textarea  name='description'> </textarea> <br> <br> "+
                         "<input type='submit'  value='Save'> </form>" );}
    else {
        String name2 = (String) name;
        String desc2 = (String) desc;
        out.write(
                "<form method='post' action='/'> Название <input type='text' " +
                        "name='name' value = "+ name2 + "> <br> <br>" +
                        "Описание <textarea  name='description'>" + desc2 +   "</textarea> <br> "+
                        "<input type='submit'  value='Save'> </form>" );
    }



%>
</body>
</html>
