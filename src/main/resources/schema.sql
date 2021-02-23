drop table if exists employee;

create table employee(
     empId INT AUTO_INCREMENT PRIMARY KEY,
     firstName VARCHAR(50),
     age INT(3),
     phoneNo VARCHAR(25),
     initialState VARCHAR(15)
);