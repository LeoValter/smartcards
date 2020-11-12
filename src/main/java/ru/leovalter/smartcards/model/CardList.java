package ru.leovalter.smartcards.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
//@Entity
@Table(name = "card_lists")
public class CardList extends AbstractTitleEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card_list")
    private List<Card> cards;

}
