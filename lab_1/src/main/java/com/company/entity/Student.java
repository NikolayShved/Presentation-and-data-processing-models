package com.company.entity;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String country;
    private String city;
    private String group;
    private boolean isMarriage;

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

    public String getMarriage(boolean marriage) {
        return marriage ? "Женат" : "Не женат";
    }

    @Override
    public String toString() {
        String studentInfo = "Имя - '" + firstName + "'\n" +
                ", Фамилия - '" + lastName + "'\n" +
                ", Возраст - " + age + "\n" +
                ", Страна - " + country + "\n" +
                ", Город - " + city + "\n" +
                ", Группа - " + group + "\n";

        if (isMarriage) {
            studentInfo += ", Женат ";
        } else {
            studentInfo += ", Не женат ";
        }

        return studentInfo;
    }
}
