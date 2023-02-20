package com.younnescode.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDataAccessService implements UserDAO {
    private static final List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("Younnes"));
        users.add(new User("Soufiane"));
        users.add(new User("Yavuz"));
        users.add(new User(UUID.fromString("7e4b9220-a47a-45a7-a33b-7182ee0dc30e"), "Leila"));
        users.add(new User(UUID.fromString("0236e9db-8c46-45a1-8fef-718d12e271f3"), "Bond"));
        users.add(new User(UUID.fromString("43bf7ab5-1f20-4693-a4f0-7319a7926d66"), "Ali"));
        users.add(new User(UUID.fromString("1fda7774-b948-42fa-ad35-7eb1a7248e35"), "Samira"));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}