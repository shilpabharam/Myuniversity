ALTER TABLE `MYUNIVERSITY`.`EVENTS` 
ADD COLUMN `CAPACITY` INT(10) NULL AFTER `UNIVERSITY_ID`,
ADD COLUMN `FEATUTERED` TINYINT(1) NULL AFTER `CAPACITY`;


UPDATE `MYUNIVERSITY`.`EVENTS` SET `CAPACITY`='500', `FEATUTERED`='1' WHERE `ID`='1';


ALTER TABLE `MYUNIVERSITY`.`EVENTS` 
CHANGE COLUMN `FEATUTERED` `FEATURED` TINYINT(1) NULL DEFAULT NULL ;
