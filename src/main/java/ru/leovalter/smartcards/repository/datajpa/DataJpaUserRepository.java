package ru.leovalter.smartcards.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.leovalter.smartcards.model.User;
import ru.leovalter.smartcards.repository.UserRepository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    private static final Sort SORT_BY_LOGIN_EMAIL = Sort.by(Sort.Direction.ASC, "login", "email");

    private final CrudUserRepository crudUserRepository;

    public DataJpaUserRepository(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public User save(User user) {
        return crudUserRepository.save(user);
    }

    @Override
    public User get(int id) {
        return crudUserRepository.getOne(id);
    }

    @Override
    public User getByLogin(String login) {
        return crudUserRepository.getUserByLogin(login);
    }

    @Override
    public User getByEmail(String email) {
        return crudUserRepository.getUserByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return crudUserRepository.findAll(SORT_BY_LOGIN_EMAIL);
    }

    @Override
    public boolean delete(int id) {
        return crudUserRepository.deleteUserById(id) != 0;
    }
}
