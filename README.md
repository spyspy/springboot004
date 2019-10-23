# springboot004
# SpringBoot with MySQL and JPA example

when we access db successfully. you will see following content on your browser.

[{"id":1,"name":"Peter","address":"Taipei"},{"id":2,"name":"Jacky","address":"Taichung"},{"id":3,"name":"Lewis","address":"WOWOW"}]


# Be Careful: Table name and Java Object name is different. Persons vs Person
# So we use Annotation to tell SpringBoot to use the correct one.

# MySQL command
create database newdb;

use newdb;

CREATE TABLE Persons (
id int NOT NULL AUTO_INCREMENT,
name varchar(255),
address varchar(255),
PRIMARY KEY (id)
);

INSERT INTO Persons (name,address)values('Peter','Taipei');
INSERT INTO Persons (name,address)values('Jacky','Taichung');
INSERT INTO Persons (name,address)values('Lewis','New York');
INSERT INTO Persons (name,address)values('Michael Jack','Washington');

#Run:  Springboot004Application.java
URL:[暗暗暗](http://localhost:8080/kiki/wow)
Note: Set /kiki in application.properties
[Swagger](https://swagger.io)

#Swagger
http://127.0.0.1:8080/kiki/swagger-ui.html



#Problem solving?
If in "Intellij" see a Red Circle J. Move mouse to pom.xml and Mouse Right Click, and  
