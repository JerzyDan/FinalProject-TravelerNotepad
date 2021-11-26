create database journeysDB;
CREATE USER 'traveler'@'localhost' IDENTIFIED BY 'makeF1rstStep';
GRANT ALL PRIVILEGES ON * . * TO 'traveler'@'localhost';

use journeysDB;
show tables;
select * from country;
select * from place;

insert into country (id, name) values 
(1, "Quatar"),
(2, "Tunisia"),
(3, "Yemen"),
(4, "Zambia"),
(5, "Oman");

insert into place (id, name) values 
(1, "Desert"),
(2, "Mountain"),
(3, "Ocean"),
(4, "Forest"),
(5, "Cave");