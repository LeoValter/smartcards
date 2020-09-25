package ru.leovalter.smartcards.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "comments")
public class Comment extends AbstractBaseEntity {

    @Column(name = "content")
    private String content;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "comment")
    private User user;

    @Column(name = "date")
    private Date date;

}
