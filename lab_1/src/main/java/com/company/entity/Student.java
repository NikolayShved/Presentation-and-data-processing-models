package com.company.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String country;
    private String city;
    private String group;
    private boolean isMarriage;

    public Student() throws IOException {

        // Initialization and read the Student.ini file
        Properties properties = new Properties();
        properties.load(new FileInputStream("./src/main/resources/Student.ini"));

        // Write to class fields
        firstName = properties.getProperty("FIRST_NAME");
        lastName = properties.getProperty("LAST_NAME");
        age = Integer.valueOf(properties.getProperty("AGE"));
        country = properties.getProperty("COUNTRY");
        city = properties.getProperty("CITY");
        group = properties.getProperty("GROUP");
        isMarriage = Boolean.valueOf(properties.getProperty("IS_MARRIAGE"));

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isMarriage() {
        return isMarriage;
    }

    public void setMarriage(boolean marriage) {
        isMarriage = marriage;
    }
}
