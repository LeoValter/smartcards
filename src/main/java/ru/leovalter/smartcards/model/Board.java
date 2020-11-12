package ru.leovalter.smartcards.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
//@Entity
@Table(name = "boards")
public class Board extends AbstractTitleEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
//    private List<CardList> cardLists;

}
