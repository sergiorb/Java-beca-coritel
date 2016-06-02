/* create database IF NOT EXISTS test; */

DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

CREATE TABLE students (
    id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL
);

CREATE TABLE subjects (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	type VARCHAR(2) NOT NULL,
	credits int NOT NULL
);

CREATE TABLE students_subjects(
	id_student INT NOT NULL,
	id_subject INT NOT NULL,
	taken CHAR(1) NOT NULL
);

INSERT INTO students (name, last_name) VALUES
("Juan", "Romero"),
("Albaro", "Erringer"),
("Sara", "Porras");

INSERT INTO subjects (name, type, credits) VALUES
("Geografy", "AB", 10),
("Math", "CD", 12),
("Computer Programing", "FG", 2);

INSERT INTO students_subjects (id_student, id_subject, taken) values
(1,1,'n'),
(1,2,'y'),
(2,1,'y'),
(2,1,'n'),
(2,3,'y');

/*
SELECT * FROM students;
SELECT * from subjects;
SELECT * from students WHERE id = 1;

SELECT name, last_name
FROM students, students_subjects 
WHERE students.id = students_subjects.id_student;

SELECT name, last_name from students where id not in (SELECT );

SELECT last_name, name FROM students where last_name like "R%";

SELECT name FROM  subjects WHERE name like "%Computer%";

SELECT last_name, name 
FROM students 
WHERE last_name <= ALL(SELECT last_name from students);

SELECT last_name, name
FROM students
WHERE last_name = (SELECT min(last_name) FROM students);
*/
