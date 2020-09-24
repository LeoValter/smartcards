DROP TABLE IF EXISTS Comments;
DROP TABLE IF EXISTS To_do_elements;
DROP TABLE IF EXISTS Cards;
DROP TABLE IF EXISTS Card_lists;
DROP TABLE IF EXISTS Boards;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS User_boards;
DROP TABLE IF EXISTS User_card_comments;

DROP SEQUENCE IF EXISTS global_sequence;

CREATE SEQUENCE global_sequence START WITH 100000;

CREATE TABLE Users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
    first_name VARCHAR NOT NULL,
    last_name  VARCHAR NOT NULL,
    login      VARCHAR NOT NULL,
    password   VARCHAR NOT NULL,
    email      VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON Users (email);

CREATE TABLE Boards
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
    name VARCHAR NOT NULL
);

CREATE TABLE Card_lists
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
    name     VARCHAR NOT NULL,
    board_id INTEGER NOT NULL,
    FOREIGN KEY (board_id) REFERENCES Boards (id) ON DELETE CASCADE
);

CREATE TABLE Cards
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
    description      TEXT,
    status           VARCHAR,
    date_of_create   TIMESTAMP,
    date_of_modified TIMESTAMP,
    date_of_done     TIMESTAMP,
    card_list_id     INTEGER NOT NULL,
    FOREIGN KEY (card_list_id) REFERENCES Card_lists (id) ON DELETE CASCADE
);

CREATE TABLE To_do_elements
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
    description TEXT    NOT NULL,
    id_done     BOOLEAN             DEFAULT FALSE,
    card_id     INTEGER NOT NULL,
    FOREIGN KEY (card_id) REFERENCES Cards (id) ON DELETE CASCADE
);

CREATE TABLE Comments
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
    content TEXT      NOT NULL,
    user_id INTEGER   NOT NULL,
    date    TIMESTAMP NOT NULL,
    card_id INTEGER   NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE
);

CREATE TABLE User_boards
(
  user_id INTEGER NOT NULL ,
  board_id INTEGER NOT NULL ,
  PRIMARY KEY (user_id, board_id)
);

CREATE TABLE User_card_comments
(
    user_id INTEGER NOT NULL ,
    card_id    INTEGER NOT NULL,
    comment_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, card_id, comment_id)
);

