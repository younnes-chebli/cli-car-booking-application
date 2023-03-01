package com.younnescode.user;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDataAccessService implements UserDAO {
    private static final List<User> users;

    static {
        users = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            Faker faker = new Faker();
            users.add(new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress()));
        }
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}