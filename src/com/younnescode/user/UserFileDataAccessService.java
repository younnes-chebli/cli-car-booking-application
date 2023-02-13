package com.younnescode.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

public class UserFileDataAccessService implements UserDAO {
    private static final File usersFile = new File("src/com/younnescode/files/users.csv");

    @Override
    public User[] getUsers() {
        var users = new User[4];
        var nextAvailableIndex = 0;

        try {
            var scanner = new Scanner(usersFile);

            scanner.nextLine();
            while(scanner.hasNext()) {
                var fileLine = scanner.nextLine();
                var userFromFile = fileLine.split(",");
                var nextFileIndex = 0;

                try {
                    users[nextAvailableIndex++] = new User(
                            UUID.fromString(userFromFile[nextFileIndex++].trim()),
                            userFromFile[nextFileIndex++].trim()
                    );
                } catch(IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
