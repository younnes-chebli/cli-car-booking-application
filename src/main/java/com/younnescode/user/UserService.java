package com.younnescode.user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserDAO userDataAccessService;

    public UserService(UserDAO userFileDataAccessService) {
        this.userDataAccessService = userFileDataAccessService;
    }

    public List<User> getUsers() {
        return userDataAccessService.getUsers();
    }

    public User getUserById(String userId) {
        var users = userDataAccessService.getUsers();
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
