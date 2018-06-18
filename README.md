#springboot004
#SpringBoot with MySQL and JPA example

when we access db successfully. you will see following content on your browser.

[{"id":1,"name":"Peter","address":"Taipei"},{"id":2,"name":"Jacky","address":"Taichung"},{"id":3,"name":"Lewis","address":"WOWOW"}]


#Be Careful: Table name and Java Object name is different. Persons vs Person
#So we use Annotation to tell SpringBoot to use the correct one.

#MySQL command
create database newdb;

CREATE TABLE Persons (
id int,
name varchar(255),
address varchar(255)
)

INSERT INTO Persons (id,name,address)values(1,'Peter','Taipei');
INSERT INTO Persons (id,name,address)values(2,'Jacky','Taichung');
INSERT INTO Persons (id,name,address)values(3,'Lewis','WOWOW');

