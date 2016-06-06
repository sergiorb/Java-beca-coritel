DROP DATABASE IF EXISTS university;
CREATE DATABASE university;

USE university;

SET default_storage_engine = INNODB;

CREATE TABLE students (
    id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
	uuid VARCHAR(64) NOT NULL,
    name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL
);

