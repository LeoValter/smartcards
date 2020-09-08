package ru.leovalter.smartcards.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Card {
    private String title;
    private String description;
    private final Status status = Status.MEDIUM;
    private Set<User> performers;
    private Date dateOfCreate;
    private Date dateOfModified;
    private Date dateOfDone;
    private List<String> checkBoxList;
    private List<Comment> comments;
}
