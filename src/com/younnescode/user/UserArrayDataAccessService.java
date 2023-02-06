package com.younnescode.user;

public class UserArrayDataAccessService implements UserDAO {
    private static final User[] users;

    static {
        users = new User[]{
                new User("Younnes"),
                new User("Soufiane"),
                new User("Yavuz")
        };
    }

    @Override
    public User[] getUsers() {
        return users;
    }
}
