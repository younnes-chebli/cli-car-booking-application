package com.younnescode;

import com.younnescode.user.User;
import com.younnescode.user.UserDAO;
import com.younnescode.user.UserDataAccessService;
import com.younnescode.user.UserService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class UserServiceTest {
    UserDAO userDataAccessService = new UserDataAccessService();
    UserService userService = new UserService(userDataAccessService);

    @Test
    void getUsers() {
        List<User> given = new ArrayList<>();
        User younnes = new User(UUID.fromString("de305d54-75b4-431b-adb2-eb6b9e546014"), "Younnes", "Chebli", "younnesc@gmail.com");
        User soufiane= new User(UUID.fromString("de305d54-75b4-431b-adb2-eb6b9e546015"), "Soufiane", "Chebli", "mail@mail.com");
        given.add(younnes);
        given.add(soufiane);

        List<User> expected = userService.getUsers();

        assertThat(given).isEqualTo(expected);
    }

    @Test
    void getUserById() {
        UUID given = UUID.fromString("de305d54-75b4-431b-adb2-eb6b9e546014");

        User expected = userService.getUserById("de305d54-75b4-431b-adb2-eb6b9e546014");

        assertThat(expected.getID()).isEqualTo(given);
    }


}
