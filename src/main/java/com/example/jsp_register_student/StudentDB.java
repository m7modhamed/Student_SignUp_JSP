package com.example.jsp_register_student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CallToPrintStackTrace")
public class StudentDB {

    public static Connection getConnection() {
        String url = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "hr", "hr");
        } catch (ClassNotFoundException | SQLException sq) {
            //noinspection CallToPrintStackTrace
            sq.printStackTrace();
        }

        return con;
    }

    public static int save(StudentInfo std) {
        String query = "insert into students (firstName,lastname,mothername,email,gender,password,address,city,phone) values(?,?,?,?,?,?,?,?,?)";
        Connection con = StudentDB.getConnection();
        int st;
        try {
            PreparedStatement sqlStatement = con.prepareStatement(query);

            sqlStatement.setString(1, std.getFirstName());
            sqlStatement.setString(2, std.getLastName());
            sqlStatement.setString(3, std.getMotherName());
            sqlStatement.setString(4, std.getEmail());
            sqlStatement.setString(5, std.getGender());
            sqlStatement.setString(6, std.getPassword());
            sqlStatement.setString(7, std.getAddress());
            sqlStatement.setString(8, std.getCity());
            sqlStatement.setString(9, std.getPhone());

            st = sqlStatement.executeUpdate();

            //insert courses here

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select max(id) from students");
            resultSet.next();
            int id = -1;
            if (resultSet.getBoolean(1)) {
                id = resultSet.getInt(1);
            }
            for (String s : std.getCourse()) {
                statement.execute("insert into COURSE_STUDENT values(" + id + " , '" + s + "')");
            }

            resultSet.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return st;
    }


    public static int update(StudentInfo std) {
        String query = "update StidentInfo set firstname=? ,lastname=? ,email=? ,pasword=? where id=?";
        Connection con = StudentDB.getConnection();
        int st;
        try {
            PreparedStatement sqlStatement = con.prepareStatement(query);

            sqlStatement.setString(1, std.getFirstName());
            sqlStatement.setString(2, std.getLastName());
            sqlStatement.setString(3, std.getEmail());
            sqlStatement.setString(4, std.getPassword());
            sqlStatement.setInt(5, std.getId());

            st = sqlStatement.executeUpdate();

            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return st;
    }

    public static int delete(int id) {
        String query = "delete from students where id=?";
        Connection con = StudentDB.getConnection();
        int st,stCourse;
        try {
            PreparedStatement sqlStatement = con.prepareStatement(query);

            sqlStatement.setInt(1, id);

            st = sqlStatement.executeUpdate();

            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return st;
    }


    public static StudentInfo getStudentById(int id) {
        String query = "select * from StudentInfo where id=?";
        Connection con = StudentDB.getConnection();
        StudentInfo std = new StudentInfo();

        try {
            PreparedStatement sqlStatement = con.prepareStatement(query);
            sqlStatement.setInt(1, id);
            ResultSet set = sqlStatement.executeQuery();
            while (set.next()) {

                std.setId(set.getInt(1));
                std.setFirstName(set.getString(2));
                std.setLastName(set.getString(3));
                std.setEmail(set.getString(4));
                std.setPassword(set.getString(5));
            }

            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return std;
    }


    public static List<StudentInfo> getAllStudent() {
        ArrayList<StudentInfo> list = new ArrayList<>();
        String query = "select * from Students order by id";
        Connection con = StudentDB.getConnection();
        StudentInfo std;
        ResultSet set = null;

        try {
            PreparedStatement sqlStatement = con.prepareStatement(query);
            set = sqlStatement.executeQuery();

            while (set.next()) {
                std = new StudentInfo();
                std.setId(set.getInt(1));
                std.setFirstName(set.getString(2));
                std.setLastName(set.getString(3));
                std.setMotherName(set.getString(4));
                std.setEmail(set.getString(5));
                std.setGender(set.getString(6));
                std.setPassword(set.getString(7));
                std.setAddress(set.getString(8));
                std.setCity(set.getString(9));
                std.setPhone(set.getString(10));
                list.add(std);
            }

            con.close();
            set.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<String> getCourses(int id) {
        ArrayList<String> list = new ArrayList<>();

        String query = "select * from Course_Student where student_id=?";
        Connection con = StudentDB.getConnection();

        try {
            PreparedStatement sqlStatement = con.prepareStatement(query);
            sqlStatement.setInt(1, id);
            ResultSet set = sqlStatement.executeQuery();

            while (set.next()) {
                list.add(set.getString(2));
            }
        } catch (SQLException e) {
        }

        return list;
    }
}
