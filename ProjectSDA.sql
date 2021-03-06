CREATE database SDAProject;
USE SDAProject;

CREATE TABLE customer(
    username VARCHAR(30),
    FirstName CHAR(30),
    LastName CHAR(30),
    Email VARCHAR(35) ,
    password VARCHAR(30) ,
    phone  VARCHAR(20)
);


INSERT INTO customer(username,password) VALUES ('usama78','123');
INSERT INTO customer(username,password) VALUES ('summanchan','111');
INSERT INTO customer(username,password) VALUES ('エレン','nani');

select * from customer;

ALTER TABLE customer ADD CNIC CHAR(30);
TRUNCATE customer;

UPDATE customer set FirstName=? where username=?;

INSERT INTO customer(username,Email,password) values (?,?,?);
