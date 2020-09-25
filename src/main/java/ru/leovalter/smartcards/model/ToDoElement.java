package ru.leovalter.smartcards.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "to_do_elements")
public class ToDoElement extends AbstractBaseEntity {

    @Column(name = "description")
    String description;

    @Column(name = "done")
    boolean isDone = false;

}
