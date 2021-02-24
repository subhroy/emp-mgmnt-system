drop table if exists employee;

create table employee(
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(50),
     age INT(3),
     phone_number VARCHAR(25),
     state VARCHAR(15)
);