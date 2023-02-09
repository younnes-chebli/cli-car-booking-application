package com.younnescode.user;

import java.util.UUID;

public class UserService {
    private final UserFileDataAccessService userFileDataAccessService;

    public UserService(UserFileDataAccessService userFileDataAccessService) {
        this.userFileDataAccessService = userFileDataAccessService;
    }

    public User[] getUsers() {
        return userFileDataAccessService.getUsers();
    }

    public User getUserById(String userId) {
        User[] users = userFileDataAccessService.getUsers();
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
