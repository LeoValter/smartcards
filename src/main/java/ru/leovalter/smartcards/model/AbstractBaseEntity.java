package ru.leovalter.smartcards.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.leovalter.smartcards.HasId;

import javax.persistence.*;

@Getter
@Setter
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
