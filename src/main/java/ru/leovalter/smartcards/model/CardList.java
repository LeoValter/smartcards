package ru.leovalter.smartcards.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CardList extends AbstractTitleEntity {
    private List<Card> listCards;
}
