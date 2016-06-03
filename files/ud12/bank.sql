DROP DATABASE IF EXISTS bank;
CREATE DATABASE bank;

USE bank;

SET default_storage_engine = INNODB;

CREATE TABLE users (
    id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
	uuid VARCHAR(64) NOT NULL,
    name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL
);

CREATE TABLE accounts (
    id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    uuid VARCHAR(64) NOT NULL,
	amount FLOAT(10,2) NOT NULL DEFAULT '0.00',
	id_user INT NOT NULL,
	FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE CASCADE	
);

CREATE TABLE transactions (
    id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    uuid VARCHAR(64) NOT NULL,
	type SET('w', 'd'),
	amount FLOAT(10,2) NOT NULL DEFAULT '0.00',
	performed_on TIMESTAMP,
	id_user INT NOT NULL,
	FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE CASCADE,
	id_account INT NOT NULL,
	FOREIGN KEY (id_account) REFERENCES accounts(id) ON DELETE CASCADE	
);

INSERT INTO users(uuid, name, last_name) VALUES
("467e95f1-698b-440c-a612-56903605a2b1", "Tony", "Stark"),
("88bb487d-d401-4fad-b3ec-003d1c5c8319", "Steve", "Rogers"),
("c943e81b-1ea6-4144-88f7-b2bd64c47b5d","Peter", "Parker"),
("774de973-a9b4-4424-b432-d9cff9be503d", "Nicholas", "Fury");

INSERT INTO accounts(uuid, amount, id_user) VALUES
("1be7ea6e-ed13-477b-a95e-cb837807ab5a", 84698754.0, 1),
("aaf0477d-8a26-41fc-be57-78c6abc27fee", 26784.0, 2),
("029aaebf-5e4e-4a01-8309-1562b6d7a235", 1436.0, 3),
("bcde668b-a4dc-4a0b-970c-8f0e723a4030", 254143.0, 4);


INSERT INTO transactions(uuid, type, amount, id_user, id_account) VALUES
("1be7ea6e-ed13-477b-a95e-cb837807ab5a", 'w', 14500.0, 1, 1),
("029aaebf-5e4e-4a01-8309-1562b6d7a235", 'w', 2200.87, 1, 1),
("bcde668b-a4dc-4a0b-970c-8f0e723a4030", 'd', 110.90, 1, 1),
("aaf0477d-8a26-41fc-be57-78c6abc27fee", 'w', 3124.35, 1, 1),
("774de973-a9b4-4424-b432-d9cff9be503d", 'd', 2120.0, 1, 1),
("1be7ea6e-ed13-477b-a95e-cb837807ab5a", 'w', 500.0, 2, 2),
("029aaebf-5e4e-4a01-8309-1562b6d7a235", 'w', 200.87, 2, 2),
("bcde668b-a4dc-4a0b-970c-8f0e723a4030", 'd', 10.90, 2, 2),
("aaf0477d-8a26-41fc-be57-78c6abc27fee", 'w', 124.35, 2, 2),
("774de973-a9b4-4424-b432-d9cff9be503d", 'd', 120.0, 2, 2),
("1be7ea6e-ed13-477b-a95e-cb837807ab5a", 'w', 55.0, 3, 3),
("029aaebf-5e4e-4a01-8309-1562b6d7a235", 'w', 21.87, 3, 3),
("bcde668b-a4dc-4a0b-970c-8f0e723a4030", 'd', 3.90, 3, 3),
("aaf0477d-8a26-41fc-be57-78c6abc27fee", 'w', 24.35, 3, 3),
("774de973-a9b4-4424-b432-d9cff9be503d", 'd', 20.10, 3, 3),
("1be7ea6e-ed13-477b-a95e-cb837807ab5a", 'w', 455.0, 4, 4),
("029aaebf-5e4e-4a01-8309-1562b6d7a235", 'w', 921.87, 4, 4),
("bcde668b-a4dc-4a0b-970c-8f0e723a4030", 'd', 73.90, 4, 4),
("aaf0477d-8a26-41fc-be57-78c6abc27fee", 'w', 624.35, 4, 4),
("774de973-a9b4-4424-b432-d9cff9be503d", 'd', 420.10, 4, 4);
