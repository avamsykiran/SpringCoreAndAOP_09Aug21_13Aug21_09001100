DROP DATABASE bdgdb;

CREATE DATABASE bdgdb;

USE bdgdb;

CREATE TABLE transactions (
	txId INT PRIMARY KEY,
	header VARCHAR(100) NOT NULL,
	amount DECIMAL NOT NULL,
	dot DATE NOT NULL,
	type CHAR(20) NOT NULL
);