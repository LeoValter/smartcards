package ru.leovalter.smartcards.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class AbstractTitleEntity extends AbstractBaseEntity {
    @Column(name = "name")
    private String title;
}
