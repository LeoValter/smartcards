package ru.leovalter.smartcards.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {
    @Column(name = "first_name")
    private String firstName;
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

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String login, String password, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
