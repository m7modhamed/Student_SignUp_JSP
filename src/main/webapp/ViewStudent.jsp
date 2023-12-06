<%@ page import="com.example.jsp_register_student.StudentInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jsp_register_student.StudentDB" %>

<%--
  Created by IntelliJ IDEA.
  User: m7mod
  Date: 10/4/2023
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Student</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.css">
    <link rel="stylesheet" href="View.css">
</head>
<body>

    <h1>View Student</h1>
<table border='1' width='100%' class="styled-table">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Mother Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Password</th>
        <th>Address</th>
        <th>City</th>
        <th>Phone</th>
        <th>Courses</th>
        <th>Delete</th>
    </tr>

    <%!
        List<StudentInfo> list = null;
        StringBuilder builder = new StringBuilder();
    %>
    <%
        list = StudentDB.getAllStudent();

    %>

    <% for (StudentInfo s : list) {%>
    <%!List<String> coursesList;%>
    <%
        builder.setLength(0);
        coursesList = StudentDB.getCourses(s.getId());
    %>
    <% for (int i = 0; coursesList != null && i < coursesList.size(); i++) {
    if (i != 0) {
    builder.append(" & ");
    }
    builder.append(coursesList.get(i)); %>
    <%}%>
    <tbody>
    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getFirstName()%></td>
        <td><%=s.getLastName()%></td>
        <td><%=s.getMotherName()%></td>
        <td><%=s.getEmail()%></td>
        <td><%=s.getGender()%></td>
        <td><%=s.getPassword()%></td>
        <td><%=s.getAddress()%></td>
        <td><%=s.getCity()%></td>
        <td><%=s.getPhone()%></td>
        <td><%=builder.toString()%></td>
        <td><a href='DeleteStudent.jsp?id=<%=s.getId()%>' class="delete">delete</a></td>
    </tr>
    </tbody>
    <%
        }
    %>



</table>


    <div class="button">
        <button type="button" onclick="window.location.href='SignUp.html';"  class="btnadd">Add Student</button>
    </div>

</body>

</html>
