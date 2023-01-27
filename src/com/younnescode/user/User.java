package com.younnescode.user;

import java.util.UUID;

public class User {
    private final UUID ID;
    private String name;

    private static final UserService userService = new UserService();

    {
        this.ID = UUID.randomUUID();
    }

    public User(String name) {;
        this.name = name;
    }

    public static User[] getUsers() {
        return userService.getUsers();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
