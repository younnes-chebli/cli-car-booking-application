package com.younnescode.user;

import java.util.UUID;

public class UserService {
    private static final UserDAO userDAO = new UserDAO();

    static User[] getUsers() {
        return userDAO.getUsers();
    }

    static User getUserById(String userId) {
        User[] users = UserDAO.getUsers();
        UUID ID = null;

        try{
            ID = UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        for (User user : users) {
            if(user.getID().equals(ID)) {
                return user;
            }
        }

        return null;
    }
}
