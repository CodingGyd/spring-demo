DROP TABLE IF EXISTS user_info;

CREATE TABLE user_info (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              first_name VARCHAR(250) NOT NULL,
                              last_name VARCHAR(250) NOT NULL,
                              age int DEFAULT NULL
);
