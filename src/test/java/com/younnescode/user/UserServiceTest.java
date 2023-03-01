package com.younnescode.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class UserServiceTest {
    UserDAO userDataAccessService = new UserDataAccessService();
    UserService userService = new UserService(userDataAccessService);

    @Test
    void getUserById() {
        var users = userService.getUsers();
        var firstUserID = users.get(0).getID().toString();
        var expected = users.get(0);

        User result = userService.getUserById(firstUserID);

        assertThat(result).isEqualTo(expected);
    }


}
