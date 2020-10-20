package ru.leovalter.smartcards.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import ru.leovalter.smartcards.model.User;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    int deleteUserById(int id);

    User getUserByLogin(String login);

    User getUserByEmail(String email);

}
