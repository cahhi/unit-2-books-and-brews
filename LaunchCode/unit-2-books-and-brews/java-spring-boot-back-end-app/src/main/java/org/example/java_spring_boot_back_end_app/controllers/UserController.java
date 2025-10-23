package org.example.java_spring_boot_back_end_app.controllers;


import org.example.java_spring_boot_back_end_app.data.UserData;
import org.example.java_spring_boot_back_end_app.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
public class UserController {

    //retrieve all users
    //GET http://localhost:8080/api/users
    @GetMapping("")
    public Collection<User> getAllUsers() {
        // For demonstration purposes, returning a static list of users
        return UserData.getAll();
    }

    //retrieve a specific user by ID
    @GetMapping("/details/{userId}")
    public User getUserById(@PathVariable int userId) {
        return UserData.getById(userId); //returning object and Spring returns it as a JSON
    }

    //Retrieve a specific user and return as HTML
    @GetMapping("/details/{userId}/html") //path variable
    public String displayUserDetails(@PathVariable int userId) {
        User user = UserData.getById(userId);
        return "<h2>User</h2>" + //returning object and Spring returns it
                "<p><b>ID:</b> " + user.getId() + "</p>" +
                "<p><b>First Name:</b> " + user.getFirstName() + "</p>" +
                "<p><b>Last Name:</b> " + user.getLastName() + "</p>" +
                "<p><b>Email:</b> " + user.getEmail() + "</p>" +
                "<p><b>Phone Number:</b> " + user.getPhoneNumber() + "</p>" +
                "<p><b>Address:</b> " + user.getAddress() + "</p>";
    }

    //Save user
    //use query parameters
    @PostMapping("/add")
    public String addNewUser(@RequestParam String firstName, String lastName, String email, String address, String phoneNumber) {
        User newUser = new User(firstName, lastName, email, address, phoneNumber);
        UserData.addNewUser(newUser);
        return "User added successfully: " + newUser;
    }
}
