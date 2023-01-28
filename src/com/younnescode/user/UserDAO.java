package com.younnescode.user;

import java.util.UUID;

public class UserDAO {
    private static final User[] users;

    static {
        users = new User[]{
            new User("Younnes"),
            new User("Soufiane"),
            new User("Yavuz")
        };
    }

    User[] getUsers() {
        return users;
    }
}
