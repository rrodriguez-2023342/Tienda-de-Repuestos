drop database if exists DBProyectoSpringBootEjemplo;
create database DBProyectoSpringBootEjemplo;
use DBProyectoSpringBootEjemplo;

CREATE TABLE users (
id INT not null AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
email VARCHAR(100),
primary key pk_id(id)
);
select * from users;