create database journeysDB;
CREATE USER 'traveler'@'localhost' IDENTIFIED BY 'makeF1rstStep';
GRANT ALL PRIVILEGES ON * . * TO 'traveler'@'localhost';
use journeysDB;
show tables;