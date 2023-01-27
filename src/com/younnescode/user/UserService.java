package com.younnescode.user;

import com.younnescode.car.Car;

import java.util.Arrays;

public class UserService {
    private static final UserDAO userDAO = new UserDAO();

    static User[] getUsers() {
        return userDAO.getUsers();
    }

    private static String[] getAllIds() {
        User[] users = UserDAO.getUsers();
        int usersCapacity = users.length;
        String[] userIds = new String[usersCapacity];
        int nextAvailableIndex = 0;

        for (User user : users) {
            if(nextAvailableIndex < usersCapacity) {
                userIds[nextAvailableIndex++] = user.getID().toString();
            }
        }

        return userIds;
    }

    static boolean match(String userId) {
        String[] userIds = getAllIds();
        return Arrays.asList(userIds).contains(userId);
    }
}
