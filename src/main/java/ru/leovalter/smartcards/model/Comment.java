package ru.leovalter.smartcards.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Comment extends AbstractBaseEntity {
    private String content;
    private User user;
    private Date date;
}
