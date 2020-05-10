select * from users where name='anamika';
delete from users where id=1;
SET SQL_SAFE_UPDATES = 0;
drop table users;
select * from users;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `city` varchar(128) NOT NULL,
  `contact` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `city` varchar(128) NOT NULL,
  `contact` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
);
select * from employees;
drop table customer;


CREATE TABLE `Customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `city` varchar(128) NOT NULL,
  `contact` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
);
select * from employees;
drop table customer;