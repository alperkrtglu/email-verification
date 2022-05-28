CREATE TABLE USER
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(32)  NOT NULL,
    username VARCHAR(32)  NOT NULL,
    password VARCHAR(32)  NOT NULL,
    email    VARCHAR(128) NOT NULL,
    role     VARCHAR(32)  NOT NULL
);
