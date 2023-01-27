package com.younnescode.user;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;

    private static final UserService userService = new UserService();

    {
        this.id = UUID.randomUUID();
    }

    public User(String name) {;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User[] getUsers() {
        return userService.getUsers();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
