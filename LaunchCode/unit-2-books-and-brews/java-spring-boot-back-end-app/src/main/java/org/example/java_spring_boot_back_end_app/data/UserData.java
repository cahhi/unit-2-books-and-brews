package org.example.java_spring_boot_back_end_app.data;


import org.example.java_spring_boot_back_end_app.models.User;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

    //Temporary Representation of user data storage
    private static final Map <Integer, User> users = new HashMap<>();

    //Temporary CRUD methods for users
    public static Collection<User> getAll() { //reading all the users from a list
        return users.values();
    }

    public static void addNewUser(User user) { //adding a new user to the list
        users.put(user.getId(), user);
    }

    public static User getById(int id) { //retrieving a specific user by their ID
        return users.get(id);
    }

}
