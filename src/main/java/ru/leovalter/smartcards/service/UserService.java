package ru.leovalter.smartcards.service;

import ru.leovalter.smartcards.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User update(User user);

    User get(int id);

    User getByLogin(String login);

    User getByEmail(String email);

    List<User> getAll();

    void delete(int id);
}
