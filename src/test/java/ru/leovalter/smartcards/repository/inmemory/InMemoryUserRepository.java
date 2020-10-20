package ru.leovalter.smartcards.repository.inmemory;

import org.springframework.stereotype.Repository;
import ru.leovalter.smartcards.UserTestData;
import ru.leovalter.smartcards.model.User;
import ru.leovalter.smartcards.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static ru.leovalter.smartcards.UserTestData.ADMIN;
import static ru.leovalter.smartcards.UserTestData.USER;

@Repository
public class InMemoryUserRepository extends InMemoryBaseRepository<User> implements UserRepository {

    public void init() {
        map.clear();
        map.put(UserTestData.ADMIN_ID, ADMIN);
        map.put(UserTestData.USER_ID, USER);
    }

    @Override
    public User getByLogin(String login) {
        Objects.requireNonNull(login, "Login must not be null");
        return getCollection().stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        Objects.requireNonNull(email, "Email must not be null");
        return getCollection().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAll() {
        return getCollection().stream()
                .sorted(Comparator.comparing(User::getLogin).thenComparing(User::getEmail))
                .collect(Collectors.toList());
    }
}
