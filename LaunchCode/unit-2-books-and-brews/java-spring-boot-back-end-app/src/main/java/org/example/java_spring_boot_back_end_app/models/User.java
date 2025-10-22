package org.example.java_spring_boot_back_end_app.models;

import java.util.Objects;

public class User {

    public static int nextId = 1;

    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String firstName, String lastName, String email, String address, String phoneNumber) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        nextId++;
    }

    // Getters and Setters
    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return
                "First name: '" + firstName + '\'' +
                ", Last name: '" + lastName + '\'' +
                ", Address: " + address +
                ", Email: '" + email + '\'' +
                ", Phone number: '" + phoneNumber + '\'';
    }

    //make easy certain operations  to be completed
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
