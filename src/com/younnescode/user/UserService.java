package com.younnescode.user;

import java.util.UUID;

public class UserService {
    private static final UserDAO userDAO = new UserDAO();

    User[] getUsers() {
        return userDAO.getUsers();
    }

    User getUserById(String userId) {
        User[] users = userDAO.getUsers();
        UUID ID = null;

        try{
            ID = UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        for (User user : users) {
            if(user != null && user.getID().equals(ID)) {
                return user;
            }
        }

        return null;
    }
}
