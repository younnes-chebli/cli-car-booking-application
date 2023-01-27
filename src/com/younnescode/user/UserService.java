package com.younnescode.user;

public class UserService {
    private static final UserDAO userDAO = new UserDAO();

    User[] getUsers() {
        return userDAO.getUsers();
    }
}
