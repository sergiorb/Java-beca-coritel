/* create database IF NOT EXISTS test; */

DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

CREATE TABLE Students (
    id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL
);

CREATE TABLE Subjects (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL
);

CREATE TABLE Students_Subjects(
	id_student INT NOT NULL,
	id_subject INT NOT NULL,
	taken CHAR(1) NOT NULL
);

INSERT INTO Students (name, last_name, course, degree) VALUES
("Juan", "Romero", 2, 4),
("Sara", "Porras", 3, 1);


SELECT * FROM Students;

Select * from Students WHERE id = 1;