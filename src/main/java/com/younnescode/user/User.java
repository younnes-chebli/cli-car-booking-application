package com.younnescode.user;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final UUID ID;
    private String firsname;
    private String lastname;
    private String email;

    public User(String firsname, String lastname, String email) {
        this.ID = UUID.randomUUID();
        this.firsname = firsname;
        this.lastname = lastname;
        this.email = email;
    }

    public UUID getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ID, user.ID) && Objects.equals(firsname, user.firsname) && Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firsname, lastname);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", firsname='" + firsname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
