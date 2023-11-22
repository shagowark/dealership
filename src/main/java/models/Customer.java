package models;

import enums.Gender;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String lastName;
    private String firstName;
    private String middleName;
    private int age;
    private Gender gender;

    public Customer(String lastName, String firstName, String middleName, int age, Gender gender) {

        this.id = UUID.randomUUID();
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
    }
    public Customer(UUID id, String lastName, String firstName, String middleName, int age, Gender gender) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
    }

    public Customer() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    @Override
    public String toString() {
        return id.toString() +
                " " +
                lastName +
                " " +
                firstName +
                " " +
                middleName +
                " " +
                age +
                " " +
                gender.toString();
    }
}
