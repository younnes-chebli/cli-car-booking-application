package com.younnescode.user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserDAO userFileDataAccessService;

    public UserService(UserDAO userFileDataAccessService) {
        this.userFileDataAccessService = userFileDataAccessService;
    }

    public List<User> getUsers() {
        return userFileDataAccessService.getUsers();
    }

    public User getUserById(String userId) {
        var users = userFileDataAccessService.getUsers();
        UUID ID = null;

        try{
            ID = UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        for (var user : users) {
            if(user.getID().equals(ID)) {
                return user;
            }
        }

        return null;
    }
}
