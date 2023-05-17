package com.cli.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UserDAO {
    private static List<User> usersList;

    static {
        User[] users = {
            new User("Mohamed"),
            new User("Wassem"),
            new User("Shaaban")
        };
        usersList = Arrays.asList(users);
    }
    public List<User> getAllUsers() {
        return usersList;
    }

    public User getUserById(UUID id) {
        for(var user : usersList) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
