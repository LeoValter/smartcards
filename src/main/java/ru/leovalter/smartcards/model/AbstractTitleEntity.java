package ru.leovalter.smartcards.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractTitleEntity extends AbstractBaseEntity {
    private String title;
}
