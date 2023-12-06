<%@ page import="com.example.jsp_register_student.StudentDB" %><%--
  Created by IntelliJ IDEA.
  User: m7mod
  Date: 10/5/2023
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
int id=0,state=0;
%>
<%
id=Integer.parseInt(request.getParameter("id"));

    state=StudentDB.delete(id);
    if(state > 0){
        response.sendRedirect("ViewStudent.jsp");
    }else{

    }
%>
</body>
</html>
