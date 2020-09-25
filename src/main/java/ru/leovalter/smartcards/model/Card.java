package ru.leovalter.smartcards.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "cards")
public class Card extends AbstractBaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private final Status status = Status.MEDIUM;

    @Column(name = "date_of_create")
    private Date dateOfCreate;

    @Column(name = "date_of_modified")
    private Date dateOfModified;

    @Column(name = "date_of_done")
    private Date dateOfDone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    private Set<User> performers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "card")
    private List<ToDoList> toDoLists;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    private List<Comment> comments;

}
