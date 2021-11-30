create database journeysDB;
CREATE USER 'traveler'@'localhost' IDENTIFIED BY 'makeF1rstStep';
GRANT ALL PRIVILEGES ON * . * TO 'traveler'@'localhost';

use journeysDB;
show tables;
select * from country;
select * from place;

select country_id AS 'country', status, count(id) AS 'places' , sum(days_needed) AS 'days' from place
group by country_id, status;
select count(distinct country_id) AS 'Visited countries' FROM place where status = 1;
select count(distinct country_id) AS 'Favourite countries' FROM place where status = 3;
select count(id) AS 'Visited places' FROM place where status = 1;
select count(id) AS 'Favourite places' FROM place where status = 3;
select count(id) AS 'Places - next trip', sum(days_needed) AS 'Days needed' from  place where status = 2;
SELECT SUM(days_needed) FROM Place p WHERE p.status = 3;
SELECT SUM(days_needed) FROM Place p group by p.status HAVING p.status = 3;



insert into country (id, name) values 
(1, "Quatar"),
(2, "Tunisia"),
(3, "Yemen"),
(4, "Zambia"),
(5, "Oman"),
(6, "Island");

insert into place (id, name) values 
(1, "Desert"),
(2, "Mountain"),
(3, "Ocean"),
(4, "Forest"),
(5, "Cave");