DROP TABLE IF EXISTS todolist;

CREATE TABLE todolist
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL
);