package ru.leovalter.smartcards.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class Card {
    private String description;
    private final Status status = Status.MEDIUM;
    private Set<User> performers;
    private Date dateOfCreate;
    private Date dateOfModified;
    private Date dateOfDone;
    private List<String> checkBoxList;
    private List<Comment> comments;
}
