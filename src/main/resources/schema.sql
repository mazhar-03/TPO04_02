CREATE TABLE Users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Role (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Blog (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255) UNIQUE NOT NULL,
                      manager_id BIGINT UNIQUE,
                      FOREIGN KEY (manager_id) REFERENCES Users(id) ON DELETE CASCADE
);

CREATE TABLE Article (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         title VARCHAR(255) NOT NULL,
                         author_id BIGINT,
                         blog_id BIGINT,
                         FOREIGN KEY (author_id) REFERENCES Users(id) ON DELETE CASCADE ,
                         FOREIGN KEY (blog_id) REFERENCES Blog(id) ON DELETE CASCADE
);

CREATE TABLE User_Role (
                           user_id BIGINT,
                           role_id BIGINT,
                           PRIMARY KEY (user_id, role_id),
                           FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE,
                           FOREIGN KEY (role_id) REFERENCES Role(id) ON DELETE CASCADE
);
