package com.cli.user;

import com.cli.utils.PrintListItems;

import java.util.List;
import java.util.UUID;

public class UserService {
    private UserDAO userDAO;
    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }

    public User getUserById(UUID id) {
        return this.userDAO.getUserById(id);
    }
}
