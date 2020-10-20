package ru.leovalter.smartcards.repository.inmemory;

import ru.leovalter.smartcards.model.AbstractBaseEntity;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.leovalter.smartcards.model.AbstractBaseEntity.START_SEQ;

public class InMemoryBaseRepository<T extends AbstractBaseEntity> {

    Map<Integer, T> map = new ConcurrentHashMap<>();

    private static AtomicInteger counter = new AtomicInteger(START_SEQ);

    public T save(T entry) {
        Objects.requireNonNull(entry, "Entry must not be null");
        if (entry.isNew()) {
            entry.setId(counter.incrementAndGet());
            map.put(entry.getId(), entry);
            return entry;
        }
        return map.computeIfPresent(entry.getId(), (id, oldId) -> entry);
    }

    public T get(int id) {
        return map.get(id);
    }

    Collection<T> getCollection() {
        return map.values();
    }

    public boolean delete(int id) {
        return map.remove(id) != null;
    }


}
