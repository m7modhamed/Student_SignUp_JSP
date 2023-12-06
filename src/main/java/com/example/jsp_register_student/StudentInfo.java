package com.example.jsp_register_student;

import java.util.ArrayList;

public class StudentInfo {
    private int id;
    private String firstName, lastName, motherName, email,
            gender, password, address, city, phone;
    ArrayList<String> course;

    public StudentInfo() {
        course = new ArrayList<>();
    }

    public ArrayList<String> getCourse() {
        return this.course;
    }

    public boolean addCourse(String course) {
        return this.course.add(course);
    }

    public int getId() {
        return id;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getSelectedCity(int x) {
        String city = switch (x) {
            case 1 -> "Jordan";
            case 2 -> "USA";
            case 3 -> "palestine";
            case 4 -> "Egypt";
            case 5 -> "syria";
            default -> "";
        };
        return city;
    }
}
