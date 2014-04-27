--Added By Jamil on Sept-22,2013-----
--For login in mysql command prompt as a root user 
mysql -u root
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
 
INSERT INTO `swiftdb`.`role_menu` (`Role_Id`, `menu_Id`) VALUES ('1', '1');
INSERT INTO `swiftdb`.`role_menu` (`Role_Id`, `menu_Id`) VALUES ('1', '2');
INSERT INTO `swiftdb`.`role_menu` (`Role_Id`, `menu_Id`) VALUES ('1', '3');
INSERT INTO `swiftdb`.`role_menu` (`Role_Id`, `menu_Id`) VALUES ('1', '4');
INSERT INTO `swiftdb`.`role_menu` (`Role_Id`, `menu_Id`) VALUES ('1', '5');
INSERT INTO `swiftdb`.`role_menu` (`Role_Id`, `menu_Id`) VALUES ('1', '6');
INSERT INTO `swiftdb`.`role_menu` (`Role_Id`, `menu_Id`) VALUES ('1', '7');

commit;

INSERT INTO `menu` (`Id`,`href`,`name`,`parentId`) VALUES (1,'contact','Contact',NULL);
INSERT INTO `menu` (`Id`,`href`,`name`,`parentId`) VALUES (2,'#','Admin',NULL);
INSERT INTO `menu` (`Id`,`href`,`name`,`parentId`) VALUES (3,'fwdToMenu.action','Create Menu',2);
INSERT INTO `menu` (`Id`,`href`,`name`,`parentId`) VALUES (4,'#','Transaction',NULL);
INSERT INTO `menu` (`Id`,`href`,`name`,`parentId`) VALUES (5,'fwdToTransfer.action','Fund Transfer',4);
INSERT INTO `menu` (`Id`,`href`,`name`,`parentId`) VALUES (6,'fwdToAddPayee.action','Add Payee',4);
INSERT INTO `menu` (`Id`,`href`,`name`,`parentId`) VALUES (7,'fwdToUserRegistration.action','User Registration',2);

commit;

-------------End----------------