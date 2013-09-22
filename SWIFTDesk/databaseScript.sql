--Added By Jamil on Sept-22,2013-----
--For login in mysql command prompt as a root user 
mysql -u root -p
-- creating database name of "swiftdb" 
 create database swiftdb;
-- mounting "swiftdb" database for creating table under this table 
 use swiftdb;

CREATE TABLE user_info(
   id INT NOT NULL AUTO_INCREMENT,
   username VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   email VARCHAR(50) NOT NULL,
   first_name VARCHAR(50),
   last_name VARCHAR(50),
   created_date DATE,
   PRIMARY KEY (id )
);
 
INSERT INTO user_info(username,password, email,first_name,last_name,created_date) VALUES ("user1","pass1","user1@sd.com","first name","last name", NOW());
INSERT INTO user_info(username,password, email,first_name,last_name,created_date) VALUES ("user2","pass2","user2@sd.com","first name","last name", NOW());
INSERT INTO user_info(username,password, email,first_name,last_name,created_date) VALUES ("user3","pass3","user3@sd.com","first name","last name", NOW());
INSERT INTO user_info(username,password, email,first_name,last_name,created_date) VALUES ("user4","pass4","user4@sd.com","first name","last name", NOW());
commit;

-------------End----------------