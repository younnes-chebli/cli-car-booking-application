package com.younnescode.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

public class UserFileDataAccessService implements UserDAO {
    private static final File usersFile = new File("src/com/younnescode/users.csv");

    @Override
    public User[] getUsers() {
        User[] users = new User[4];
        int nextAvailableIndex = 0;

        try {
            Scanner scanner = new Scanner(usersFile);

            while(scanner.hasNext() && nextAvailableIndex < users.length) {
                String fileLine = scanner.nextLine();
                String[] userFromFile = fileLine.split(",");

                users[nextAvailableIndex++] = new User(UUID.fromString(userFromFile[0]), userFromFile[1].trim());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
