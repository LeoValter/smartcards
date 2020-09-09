package ru.leovalter.smartcards.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Board extends AbstractTitleEntity {
    private List<CardList> cardLists;
}
