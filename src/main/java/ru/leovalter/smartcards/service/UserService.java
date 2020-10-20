package ru.leovalter.smartcards.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.leovalter.smartcards.model.User;
import ru.leovalter.smartcards.repository.UserRepository;
import ru.leovalter.smartcards.util.exception.NotFoundException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        Assert.notNull(user, "user must be not nul");
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void delete(int id) throws Exception {
        if (userRepository.get(id) == null) {
            throw new NotFoundException("Deleting User by ID: " + id + " not found");
        }
        userRepository.delete(id);
    }
}

