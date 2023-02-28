package com.younnescode.user;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDataAccessService implements UserDAO {
    private static final List<User> users;

    static {
        users = new ArrayList<>();
//        for(int i = 0; i < 20; i++) {
//            Faker faker = new Faker();
//            users.add(new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress()));
//        }

// For testing purpose
        User younnes = new User(UUID.fromString("de305d54-75b4-431b-adb2-eb6b9e546014"),"Younnes", "Chebli", "younnesc@gmail.com");
        User soufiane = new User(UUID.fromString("de305d54-75b4-431b-adb2-eb6b9e546015"), "Soufiane", "Chebli", "mail@mail");
        users.add(younnes);
        users.add(soufiane);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}