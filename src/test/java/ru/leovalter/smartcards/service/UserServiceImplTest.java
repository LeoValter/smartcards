package ru.leovalter.smartcards.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.leovalter.smartcards.UserTestData;
import ru.leovalter.smartcards.model.User;
import ru.leovalter.smartcards.repository.UserRepository;
import ru.leovalter.smartcards.util.exception.NotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.leovalter.smartcards.UserTestData.*;
import static ru.leovalter.smartcards.UserTestData.USER_ID;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("dataJpaUserRepository")
    private UserRepository userRepository;

    @Test
    void create() throws Exception {
        User newUser = UserTestData.getNew();
        User created = userService.create(newUser);
        Integer newId = created.id();
        newUser.setId(newId);
        assertEquals(newUser, userService.get(newId));
    }

    @Test
    void update() throws Exception {
        User user = userService.get(USER_ID);
        user.setEmail("updated_email@mail.ru");
        User updated = userService.update(user);
        assertEquals(user, updated);
    }

    @Test
    void get() {
        assertEquals(ADMIN, userService.get(ADMIN_ID));
        assertEquals(USER, userService.get(USER_ID));
    }

    @Test
    void getByLogin() {
        assertEquals(ADMIN, userService.getByLogin(ADMIN.getLogin()));
        assertEquals(USER, userService.getByLogin(USER.getLogin()));
    }

    @Test
    void getByEmail() {
        assertEquals(ADMIN, userService.getByEmail(ADMIN.getEmail()));
        assertEquals(USER, userService.getByEmail(USER.getEmail()));
    }

    @Test
    void getAll() {
        List<User> all = userService.getAll();
        assertEquals(2, all.size());
        assertEquals(ADMIN, all.get(0));
        assertEquals(USER, all.get(1));
    }

    @Test
    void delete() throws Exception {
        userService.delete(USER_ID);
        assertNull(userRepository.get(USER_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> userService.delete(1));
    }

}
