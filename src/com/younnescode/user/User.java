package com.younnescode.user;

import java.util.Objects;
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

    public String getName() {
        return name;
    }

    public static User[] getUsers() {
        return userService.getUsers();
    }

    public static User getUserById(String userId) {
        return userService.getUserById(userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ID, user.ID) && Objects.equals(name, user.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(ID, name);
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
