package ru.leovalter.smartcards;

import org.springframework.util.Assert;

public interface HasId {

    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        return getId() == null;
    }

    default int id() {
        Assert.notNull(getId(), "ID must not be null");
        return getId();
    }
}
