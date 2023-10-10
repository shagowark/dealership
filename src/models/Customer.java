package models;

import enums.Gender;

public class Customer {
    private static int ID_COUNTER;
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private int age;
    private Gender gender;

    public Customer(String lastName, String firstName, String middleName, int age, Gender gender) {

        this.id = ++ID_COUNTER;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
    }
    public Customer(int id, String lastName, String firstName, String middleName, int age, Gender gender) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
