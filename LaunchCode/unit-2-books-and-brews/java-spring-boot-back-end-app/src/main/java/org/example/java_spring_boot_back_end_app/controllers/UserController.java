package org.example.java_spring_boot_back_end_app.controllers;


import org.example.java_spring_boot_back_end_app.data.UserData;
import org.example.java_spring_boot_back_end_app.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
