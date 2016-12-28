CREATE TABLE `MYUNIVERSITY`.`EVENT_TYPE` (
  `ID` INT NOT NULL,
  `EVENT_TYPE` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));
  
ALTER TABLE `MYUNIVERSITY`.`EVENT_TYPE` 
CHANGE COLUMN `ID` `ID` BIGINT(25) NOT NULL ;

INSERT INTO `MYUNIVERSITY`.`EVENT_TYPE` (`ID`, `EVENT_TYPE`) VALUES ('1', 'PUBLIC');
INSERT INTO `MYUNIVERSITY`.`EVENT_TYPE` (`ID`, `EVENT_TYPE`) VALUES ('2', 'PRIVATE');

ALTER TABLE `MYUNIVERSITY`.`EVENTS` 
ADD COLUMN `EVENT_TYPE_ID` BIGINT(25) NULL AFTER `FEATURED`,
ADD INDEX `EVENT_TYPE_FK_idx` (`EVENT_TYPE_ID` ASC);
ALTER TABLE `MYUNIVERSITY`.`EVENTS` 
ADD CONSTRAINT `EVENT_TYPE_FK`
  FOREIGN KEY (`EVENT_TYPE_ID`)
  REFERENCES `MYUNIVERSITY`.`EVENT_TYPE` (`ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

UPDATE `MYUNIVERSITY`.`EVENTS` SET `EVENT_TYPE_ID`='1' WHERE `ID`='1';

UPDATE `MYUNIVERSITY`.`INTERESTS` SET `UNIVERSITY_ID`='1' WHERE `ID`='1';
UPDATE `MYUNIVERSITY`.`INTERESTS` SET `UNIVERSITY_ID`='1' WHERE `ID`='2';
UPDATE `MYUNIVERSITY`.`INTERESTS` SET `UNIVERSITY_ID`='1' WHERE `ID`='3';

ALTER TABLE `MYUNIVERSITY`.`EVENTS` 
ADD COLUMN `PUBLISHING` TINYINT(1) NULL AFTER `EVENT_TYPE_ID`;

ALTER TABLE `MYUNIVERSITY`.`EVENTS` 
CHANGE COLUMN `PUBLISHING` `PUBLISHED` TINYINT(1) NULL DEFAULT NULL ;

UPDATE `MYUNIVERSITY`.`EVENTS` SET `PUBLISHED`='1' WHERE `ID`='1';

INSERT INTO `MYUNIVERSITY`.`ENROLLED_EVENTS` (`ID`, `USER_ID`, `EVENT_ID`, `IS_COMPLETED`, `IS_ATTENDED`, `EVENT_CHECKED_IN`) VALUES ('1', '3', '1', '1', '1', '1');