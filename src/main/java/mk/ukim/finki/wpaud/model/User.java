package mk.ukim.finki.wpaud.model;

import lombok.Data;

@Data //koristi lombok i ima pristap do geteri i seteri
public class User {
    private String username;

    private String password;

    private String name;

    private String surname;

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
