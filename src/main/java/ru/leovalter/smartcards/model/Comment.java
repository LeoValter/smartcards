package ru.leovalter.smartcards.model;

import lombok.EqualsAndHashCode;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
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
