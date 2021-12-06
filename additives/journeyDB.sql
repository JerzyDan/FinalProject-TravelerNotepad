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



insert into country (id, name, area) values 
(1, "Quatar","11610"),
(2, "Tunisia", "155360"),
(3, "Yemen","527970"),
(4, "Zambia","743390"),
(5, "Oman","309500"),
(6, "Iceland","100250");

insert into place (id, name, city, days_needed, status, description, country_id) values 
(1, "Triglav","Zgornja Radovna",1,2,"Top of Slovenia",7),
(2, "Vernar","Goreljek",2,2,"Vodnikov dom na Velem polju",7),
(3, "Old City Venezia","Venezia",7,2,"Venezia and surroundings",6),
(4, "Col Rosa","Cortina d'Amprezzo",1,3,"Via Ferrata",6),
(5, "Monte Cristallo","Cortina d'Amprezzo",1,0,"Via Ferrata",6);