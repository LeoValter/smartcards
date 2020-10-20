package ru.leovalter.smartcards;

import ru.leovalter.smartcards.model.User;

import static ru.leovalter.smartcards.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {

    public static final int ADMIN_ID = START_SEQ;
    public static final int USER_ID = START_SEQ + 1;

    public static final User ADMIN = new User(ADMIN_ID, "Gleb", "Jiglov", "admin", "admin", "admin@mail.ru");
    public static final User USER = new User(USER_ID, "Volodya", "Sharapov", "user", "user", "user@mail.ru");

    public static User getNew() {
        return new User(null, "Some firstName", "Some lastName", "Some login", "Some password", "some_email@mail.ru");
    }
}
