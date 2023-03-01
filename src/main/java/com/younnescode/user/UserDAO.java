package com.younnescode.user;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();

    void addUser(User user);
}
