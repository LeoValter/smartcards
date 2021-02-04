package ru.leovalter.smartcards.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.leovalter.smartcards.UserTestData;
import ru.leovalter.smartcards.model.User;
import ru.leovalter.smartcards.repository.inmemory.InMemoryUserRepository;
import ru.leovalter.smartcards.util.exception.NotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.leovalter.smartcards.UserTestData.ADMIN;
import static ru.leovalter.smartcards.UserTestData.ADMIN_ID;
import static ru.leovalter.smartcards.UserTestData.USER;
import static ru.leovalter.smartcards.UserTestData.USER_ID;

@SpringJUnitConfig(locations ={"classpath:inmemory.xml"})
class InMemoryUserServiceImplTest {

    @Autowired
    private InMemoryUserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
        userRepository.init();
    }

    @Test
    void create() throws Exception {
        User newUser = UserTestData.getNew();
        User created = userServiceImpl.create(newUser);
        Integer newId = created.id();
        newUser.setId(newId);
        assertEquals(newUser, userServiceImpl.get(newId));
    }

    @Test
    void update() throws Exception {
        User user = userServiceImpl.get(USER_ID);
        user.setEmail("updated_email@mail.ru");
        userServiceImpl.update(user);
        assertEquals(user.getEmail(), userServiceImpl.get(USER_ID).getEmail());
    }

    @Test
    void get() {
        assertEquals(ADMIN, userServiceImpl.get(ADMIN_ID));
        assertEquals(USER, userServiceImpl.get(USER_ID));
    }

    @Test
    void getByLogin() {
        assertEquals(ADMIN, userServiceImpl.getByLogin(ADMIN.getLogin()));
        assertEquals(USER, userServiceImpl.getByLogin(USER.getLogin()));
    }

    @Test
    void getByEmail() {
        assertEquals(ADMIN, userServiceImpl.getByEmail(ADMIN.getEmail()));
        assertEquals(USER, userServiceImpl.getByEmail(USER.getEmail()));
    }

    @Test
    void getAll() {
        List<User> all = userServiceImpl.getAll();
        assertEquals(2, all.size());
        assertEquals(ADMIN, all.get(0));
        assertEquals(USER, all.get(1));
    }

    @Test
    void delete() throws Exception {
        userServiceImpl.delete(USER_ID);
        assertNull(userRepository.get(USER_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> userServiceImpl.delete(1));
    }

}