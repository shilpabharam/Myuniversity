ALTER TABLE `MYUNIVERSITY`.`EVENTS` 
CHANGE COLUMN `EVENT_SHORT_DESC` `EVENT_SHORT_DESC` VARCHAR(500) NULL DEFAULT NULL ,
CHANGE COLUMN `EVENT_LONG_DESC` `EVENT_LONG_DESC` VARCHAR(500) NULL DEFAULT NULL ;

INSERT INTO `MYUNIVERSITY`.`EVENTS` (`EVENT_NAME`, `EVENT_FROM_TIME`, `EVENT_TO_TIME`, `EVENT_SHORT_DESC`, `EVENT_LONG_DESC`, `EVENT_ADDRESS`, `EVENT_CREATED_BY`, `UNIVERSITY_ID`, `CAPACITY`) VALUES 
('Mobile camp ', '2016-06-20 08:30', '2016-07-08 15:00', 'To secure your place in the interesting course of programmes, book by 29th April, 2016', 'The University of the new mexico Cape School of Public Health is proud to present the 38th Short Course School in a series of Winter and Summer Schools held at UWC since 1992. Read more', 'School of Public Health UWC', '3', '1', '2000');
INSERT INTO `MYUNIVERSITY`.`EVENTS` (`EVENT_NAME`, `EVENT_FROM_TIME`, `EVENT_TO_TIME`, `EVENT_SHORT_DESC`, `EVENT_LONG_DESC`, `EVENT_ADDRESS`, `EVENT_CREATED_BY`, `UNIVERSITY_ID`, `CAPACITY`) VALUES 
('Make in India ', '2016-06-20 08:30', '2016-07-08 15:00', 'To secure your place in the interesting course of programmes, book by 29th April, 2016', 'The University of the new mexico Cape School of Public Health is proud to present the 38th Short Course School in a series of Winter and Summer Schools held at UWC since 1992. Read more', 'School of Public Health UWC', '3', '1', '2000');
INSERT INTO `MYUNIVERSITY`.`EVENTS` (`EVENT_NAME`, `EVENT_FROM_TIME`, `EVENT_TO_TIME`, `EVENT_SHORT_DESC`, `EVENT_LONG_DESC`, `EVENT_ADDRESS`, `EVENT_CREATED_BY`, `UNIVERSITY_ID`, `CAPACITY`) VALUES 
('Skilled India ', '2016-06-20 08:30', '2016-07-08 15:00', 'To secure your place in the interesting course of programmes, book by 29th April, 2016', 'The University of the new mexico Cape School of Public Health is proud to present the 38th Short Course School in a series of Winter and Summer Schools held at UWC since 1992. Read more', 'School of Public Health UWC', '3', '1', '2000');
