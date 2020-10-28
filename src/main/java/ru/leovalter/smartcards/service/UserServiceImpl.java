package ru.leovalter.smartcards.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.leovalter.smartcards.model.User;
import ru.leovalter.smartcards.repository.UserRepository;
import ru.leovalter.smartcards.util.exception.NotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must be not nul");
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(int id) {
        return userRepository.get(id);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void delete(int id) {
        if (userRepository.get(id) == null) {
            throw new NotFoundException("Deleting User by ID: " + id + " not found");
        }
        userRepository.delete(id);
    }
}

