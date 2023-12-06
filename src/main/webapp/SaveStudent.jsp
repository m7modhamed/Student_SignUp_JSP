
<%--
  Created by IntelliJ IDEA.
  User: m7mod
  Date: 10/4/2023
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Save Student</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.jsp_register_student.StudentInfo" %>
<%@ page import="com.example.jsp_register_student.StudentDB" %>
<%!
    StudentInfo std = new StudentInfo();
        private int id;
        private String firstName,lastName, motherName,email,
                gender,password,address,city,phone,course;

%>
<%
    firstName = request.getParameter("firstName");
    lastName = request.getParameter("lastName");
    motherName = request.getParameter("motherName");
    email = request.getParameter("Email");
    gender = request.getParameter("gender");
    password = request.getParameter("password");
    address = request.getParameter("address");
    city = StudentInfo.getSelectedCity(Integer.parseInt(request.getParameter("city")));
    phone = request.getParameter("phone");

    for (int i = 1; i <= 3; i++) {
        course = request.getParameter("course"+i);
        if (course != null && !course.isEmpty() ) {
            std.addCourse(course);
        }
    }

    std.setFirstName(firstName);
    std.setLastName(lastName);
    std.setMotherName(motherName);
    std.setEmail(email);
    std.setGender(gender);
    std.setPassword(password);
    std.setAddress(address);
    std.setCity(city);
    std.setPhone(phone);
    int state = StudentDB.save(std);

    if(state > 0){
        response.sendRedirect("ViewStudent.jsp");
    }


%>
</body>
</html>
