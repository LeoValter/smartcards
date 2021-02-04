package ru.leovalter.smartcards.model;

import lombok.Data;
import ru.leovalter.smartcards.HasId;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@MappedSuperclass
public abstract class AbstractBaseEntity implements HasId {

    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_sequence", sequenceName = "global_sequence", allocationSize = 1,
            initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_sequence")
    private Integer id;

    public AbstractBaseEntity() {
    }

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }
}
