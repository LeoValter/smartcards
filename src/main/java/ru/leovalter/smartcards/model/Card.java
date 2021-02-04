package ru.leovalter.smartcards.model;

import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.util.Date;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "cards")
public class Card extends AbstractBaseEntity {

    @NonNull
    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private final Status status = Status.MEDIUM;

    @Column(name = "date_of_create")
    private Date dateOfCreate = new Date();

    @Column(name = "date_of_modified")
    private Date dateOfModified = null;

    @Column(name = "date_of_done")
    private Date dateOfDone = null;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    private Set<User> performers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "card")
    private List<ToDoList> toDoLists;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    private List<Comment> comments;

}
