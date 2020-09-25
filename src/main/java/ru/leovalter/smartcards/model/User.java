package ru.leovalter.smartcards.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {
    @Column(name = "first_name")
    private String fullName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

//    private Role role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Board> boards;
}
