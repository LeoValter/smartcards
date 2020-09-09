package ru.leovalter.smartcards.model;

import lombok.Data;

@Data
public class User extends AbstractBaseEntity {
    private String firstName;
    private String lastName;
    private String login;
    private String email;
}
