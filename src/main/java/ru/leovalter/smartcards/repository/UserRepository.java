package ru.leovalter.smartcards.repository;

import ru.leovalter.smartcards.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User get(int id);

    User getByLogin(String login);

    User getByEmail(String email);

    List<User> getAll();

    boolean delete(int id);

}
