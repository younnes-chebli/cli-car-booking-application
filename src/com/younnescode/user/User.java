package com.younnescode.user;

import java.util.UUID;

public class User {
    private final UUID ID;
    private String name;

    private static final UserService userService = new UserService();

    public User(UUID uuid, String name) {;
        this.name = name;
        this.ID = uuid;
    }

    public User(String name) {;
        this.name = name;
        this.ID = UUID.randomUUID();
    }

    public UUID getID() {
        return ID;
    }

    public static User[] getUsers() {
        return userService.getUsers();
    }

    public static User getUserById(String userId) {
        return userService.getUserById(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
