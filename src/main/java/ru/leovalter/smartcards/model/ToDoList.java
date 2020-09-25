package ru.leovalter.smartcards.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "to_do_lists")
public class ToDoList extends AbstractTitleEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "to_do_list")
    private List<ToDoElement> toDoElements;

}
