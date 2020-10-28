DELETE FROM users;
ALTER SEQUENCE global_sequence RESTART WITH 100000;

INSERT INTO users (first_name, last_name, login, password, email)
VALUES ('Gleb', 'Jiglov', 'admin', 'admin', 'admin@mail.ru'),
       ('Volodya', 'Sharapov', 'user', 'user', 'user@mail.ru');