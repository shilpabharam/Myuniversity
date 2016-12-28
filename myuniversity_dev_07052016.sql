-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: MYUNIVERSITY
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `DEPARTMENTS`
--

DROP TABLE IF EXISTS `DEPARTMENTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DEPARTMENTS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `DEP_NAME` varchar(45) DEFAULT NULL,
  `VALID` tinyint(50) DEFAULT NULL,
  `UNIVERSITY_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UNIVERSITY_FK_idx` (`UNIVERSITY_ID`),
  CONSTRAINT `UNIVERSITY_FK` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `UNIVERSITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DEPARTMENTS`
--

LOCK TABLES `DEPARTMENTS` WRITE;
/*!40000 ALTER TABLE `DEPARTMENTS` DISABLE KEYS */;
INSERT INTO `DEPARTMENTS` VALUES (5,'Rupay',1,1),(6,'Education',1,1),(7,'Medical',1,1),(8,'Technical',1,1);
/*!40000 ALTER TABLE `DEPARTMENTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENROLLED_EVENTS`
--

DROP TABLE IF EXISTS `ENROLLED_EVENTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ENROLLED_EVENTS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(25) DEFAULT NULL,
  `EVENT_ID` bigint(25) DEFAULT NULL,
  `IS_COMPLETED` tinyint(50) DEFAULT NULL,
  `IS_ATTENDED` tinyint(50) DEFAULT NULL,
  `EVENT_CHECKED_IN` tinyint(50) DEFAULT NULL,
  `DELETED_FLAG` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USER_ID_idx` (`USER_ID`),
  KEY `EVENT_ID_idx` (`EVENT_ID`),
  CONSTRAINT `EVENT_ID` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENROLLED_EVENTS`
--

LOCK TABLES `ENROLLED_EVENTS` WRITE;
/*!40000 ALTER TABLE `ENROLLED_EVENTS` DISABLE KEYS */;
INSERT INTO `ENROLLED_EVENTS` VALUES (1,3,1,1,1,1,NULL),(2,3,1,1,1,1,NULL),(3,2,4,1,1,1,0),(4,2,2,1,1,1,0),(5,1,4,1,1,1,0),(6,1,2,1,1,1,0),(7,3,2,1,1,1,0),(8,4,1,1,1,1,1),(9,4,2,1,1,1,1),(10,4,3,1,1,1,1),(11,6,2,1,1,1,0),(12,6,11,1,1,1,1),(13,6,12,1,1,1,1),(14,6,10,1,1,1,1),(15,6,5,1,1,1,0),(16,6,4,1,1,1,1),(17,6,1,1,1,1,0),(18,8,1,1,1,1,1),(19,8,2,1,1,1,0),(20,6,3,1,1,1,1),(21,8,3,1,1,1,0),(22,5,1,1,1,1,0),(23,8,11,1,1,1,0),(24,4,4,1,1,1,1),(25,4,12,1,1,1,1),(26,4,11,1,1,1,0),(29,11,1,1,1,1,1),(30,11,2,1,1,1,1),(31,11,3,1,1,1,1),(32,11,5,1,1,1,0),(33,11,10,1,1,1,1),(34,11,12,1,1,1,0),(35,11,4,1,1,1,1),(36,11,11,1,1,1,1),(37,NULL,1,1,1,1,0),(38,NULL,1,1,1,1,0),(39,NULL,12,1,1,1,0),(40,NULL,12,1,1,1,0),(41,NULL,12,1,1,1,0),(42,NULL,2,1,1,1,0),(43,NULL,4,1,1,1,0),(44,NULL,2,1,1,1,0),(45,NULL,2,1,1,1,0),(46,12,2,1,1,1,0),(47,NULL,1,1,1,1,0),(48,NULL,1,1,1,1,0),(49,NULL,1,1,1,1,0),(50,NULL,2,1,1,1,0),(51,NULL,1,1,1,1,0),(52,NULL,1,1,1,1,0),(53,NULL,1,1,1,1,0),(54,NULL,1,1,1,1,0),(55,NULL,3,1,1,1,0),(56,NULL,1,1,1,1,0),(57,NULL,3,1,1,1,0),(58,NULL,2,1,1,1,0),(59,NULL,2,1,1,1,0),(60,NULL,2,1,1,1,0),(61,NULL,1,1,1,1,0),(62,NULL,2,1,1,1,0),(63,NULL,1,1,1,1,0),(64,NULL,1,1,1,1,0),(65,NULL,1,1,1,1,0),(66,NULL,2,1,1,1,0),(67,12,1,1,1,1,0),(68,NULL,1,1,1,1,0),(69,NULL,1,1,1,1,0),(70,13,11,1,1,1,0),(71,13,5,1,1,1,1),(72,NULL,1,1,1,1,0),(73,13,1,1,1,1,0),(74,NULL,2,1,1,1,0),(75,NULL,5,1,1,1,0),(76,14,12,1,1,1,0),(77,NULL,5,1,1,1,0),(78,5,4,1,1,1,0),(79,NULL,2,1,1,1,0),(80,NULL,2,1,1,1,0),(81,NULL,2,1,1,1,0),(82,NULL,2,1,1,1,0),(83,NULL,2,1,1,1,0),(84,NULL,2,1,1,1,0),(85,NULL,2,1,1,1,0),(86,NULL,4,1,1,1,0),(87,NULL,2,1,1,1,0),(88,NULL,2,1,1,1,0),(89,NULL,2,1,1,1,0),(90,NULL,2,1,1,1,0),(91,NULL,1,1,1,1,0),(92,18,1,1,1,1,1),(93,NULL,1,1,1,1,0),(94,NULL,2,1,1,1,0),(95,16,2,1,1,1,0),(96,16,1,1,1,1,1),(97,NULL,1,1,1,1,0),(98,NULL,2,1,1,1,0),(99,NULL,2,1,1,1,0),(100,NULL,2,1,1,1,0),(101,NULL,2,1,1,1,0),(102,NULL,3,1,1,1,0),(103,NULL,1,1,1,1,0),(104,NULL,2,1,1,1,0),(105,NULL,2,1,1,1,0),(106,NULL,2,1,1,1,0),(107,NULL,2,1,1,1,0),(108,NULL,1,1,1,1,0),(109,NULL,1,1,1,1,0),(110,NULL,1,1,1,1,0),(111,NULL,1,1,1,1,0),(112,NULL,5,1,1,1,0),(113,NULL,11,1,1,1,0),(114,NULL,2,1,1,1,0),(115,18,2,1,1,1,1),(116,NULL,5,1,1,1,0),(117,15,2,1,1,1,0),(118,NULL,2,1,1,1,0),(119,NULL,2,1,1,1,0),(120,NULL,2,1,1,1,0),(121,NULL,2,1,1,1,0),(122,NULL,18,1,1,1,0),(123,NULL,18,1,1,1,0),(124,NULL,18,1,1,1,0),(125,NULL,20,1,1,1,0),(126,NULL,21,1,1,1,0),(127,NULL,21,1,1,1,0),(128,NULL,1,1,1,1,0),(129,NULL,2,1,1,1,0),(130,15,20,1,1,1,1),(131,NULL,20,1,1,1,0),(132,NULL,20,1,1,1,0),(133,NULL,20,1,1,1,0),(134,NULL,26,1,1,1,0),(135,NULL,26,1,1,1,0),(136,15,26,1,1,1,1),(137,NULL,26,1,1,1,0),(138,NULL,26,1,1,1,0),(139,NULL,19,1,1,1,0),(140,20,12,1,1,1,0),(141,20,18,1,1,1,1),(142,20,10,1,1,1,1),(143,NULL,18,1,1,1,0),(144,NULL,29,1,1,1,0),(145,NULL,29,1,1,1,0),(146,15,29,1,1,1,1),(147,NULL,1,1,1,1,0),(148,NULL,1,1,1,1,0),(149,NULL,1,1,1,1,0),(150,NULL,1,1,1,1,0),(151,NULL,1,1,1,1,0),(152,NULL,1,1,1,1,0),(153,NULL,2,1,1,1,0),(154,NULL,1,1,1,1,0),(155,18,22,1,1,1,1),(156,21,2,1,1,1,1),(157,21,1,1,1,1,0),(158,NULL,18,1,1,1,0),(159,NULL,1,1,1,1,0),(160,NULL,1,1,1,1,0),(161,NULL,1,1,1,1,0),(162,NULL,1,1,1,1,0),(163,NULL,3,1,1,1,0),(164,NULL,1,1,1,1,0),(165,NULL,4,1,1,1,0),(166,NULL,3,1,1,1,0),(167,NULL,1,1,1,1,0),(168,NULL,1,1,1,1,0),(169,NULL,1,1,1,1,0),(170,NULL,1,1,1,1,0),(171,NULL,18,1,1,1,0),(172,NULL,1,1,1,1,0),(173,NULL,1,1,1,1,0),(174,NULL,2,1,1,1,0),(175,NULL,1,1,1,1,0),(176,NULL,1,1,1,1,0),(177,NULL,5,1,1,1,0),(178,NULL,4,1,1,1,0),(179,NULL,4,1,1,1,0),(180,NULL,4,1,1,1,0),(181,NULL,4,1,1,1,0),(182,NULL,4,1,1,1,0),(183,11,22,1,1,1,1),(184,11,25,1,1,1,1),(185,20,4,1,1,1,1),(186,11,21,1,1,1,0),(187,18,20,1,1,1,1),(188,18,23,1,1,1,1),(189,20,25,1,1,1,1),(190,18,18,1,1,1,0),(191,18,19,1,1,1,0),(192,18,21,1,1,1,1),(193,18,35,1,1,1,0),(194,15,44,1,1,1,1),(195,11,44,1,1,1,0),(196,12,21,1,1,1,0),(197,15,47,1,1,1,0),(198,15,49,1,1,1,0),(199,15,35,1,1,1,0),(200,12,20,1,1,1,0),(201,15,18,1,1,1,1),(202,15,50,1,1,1,0),(203,20,1,1,1,1,1),(204,20,30,1,1,1,1),(205,20,2,1,1,1,0),(206,15,58,1,1,1,1),(207,12,50,1,1,1,0),(208,20,5,1,1,1,1),(209,12,23,1,1,1,0),(210,12,44,1,1,1,0),(211,12,30,1,1,1,0),(212,15,64,1,1,1,0),(213,15,30,1,1,1,0),(214,15,12,1,1,1,0),(215,15,11,1,1,1,0),(216,6,64,1,1,1,0),(217,15,65,1,1,1,0),(218,15,67,1,1,1,0),(219,15,69,1,1,1,0),(220,15,5,1,1,1,0),(221,15,68,1,1,1,0),(222,11,65,1,1,1,0),(223,15,70,1,1,1,0),(224,11,82,1,1,1,0),(225,15,71,1,1,1,0),(226,5,5,1,1,1,0),(227,5,2,1,1,1,0),(228,15,72,1,1,1,0),(229,15,77,1,1,1,0),(230,15,78,1,1,1,0);
/*!40000 ALTER TABLE `ENROLLED_EVENTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENTS`
--

DROP TABLE IF EXISTS `EVENTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENTS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `EVENT_NAME` varchar(45) DEFAULT NULL,
  `EVENT_FROM_TIME` datetime DEFAULT NULL,
  `EVENT_TO_TIME` datetime DEFAULT NULL,
  `EVENT_SHORT_DESC` varchar(500) DEFAULT NULL,
  `EVENT_LONG_DESC` varchar(500) DEFAULT NULL,
  `EVENT_ADDRESS` varchar(200) DEFAULT NULL,
  `EVENT_CREATED_BY` bigint(25) DEFAULT NULL,
  `UNIVERSITY_ID` bigint(25) DEFAULT NULL,
  `CAPACITY` int(10) DEFAULT NULL,
  `FEATURED` tinyint(1) DEFAULT NULL,
  `EVENT_TYPE_ID` bigint(25) DEFAULT NULL,
  `PUBLISHED` tinyint(1) DEFAULT NULL,
  `KEYWORDS` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Created_by_idx` (`EVENT_CREATED_BY`),
  KEY `UNIVERSITY_FK_idx` (`UNIVERSITY_ID`),
  KEY `EVENT_TYPE_FK_idx` (`EVENT_TYPE_ID`),
  CONSTRAINT `Created_by` FOREIGN KEY (`EVENT_CREATED_BY`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `EVENT_TYPE_FK` FOREIGN KEY (`EVENT_TYPE_ID`) REFERENCES `EVENT_TYPE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `UNIVERSITY_EV_FK` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `UNIVERSITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENTS`
--

LOCK TABLES `EVENTS` WRITE;
/*!40000 ALTER TABLE `EVENTS` DISABLE KEYS */;
INSERT INTO `EVENTS` VALUES (1,'Alumni events','2015-02-17 03:00:00','2015-02-17 03:30:00','Alumni event',NULL,'Swami Vivekanand Auditorium',3,1,500,1,1,1,NULL),(2,'eLearning Africa 2016','2016-05-24 08:00:00','2016-05-26 17:00:00','eLearning Africa is the key networking event for ICT enhanced development, education and training in Africa.','eLearning Africa is the key networking event for ICT enhanced development, education and training in Africa. As the largest conference of its kind, the three-day event is a must for those wanting to develop multinational, cross-industry partnerships and contacts whilst sharing knowledge and learning new skills.','Cairo Egypt',3,1,1000,1,1,1,NULL),(3,'Orientation','2016-02-09 10:00:00','2016-02-13 16:00:00','The Orientation Programme is aimed at assisting new students with their registration and introducing them to the UWC campus and university lifeThe Orientation Programme is aimed at assisting new students with their registration and introducing them to the UWC campus and university life','The Orientation Programme is aimed at assisting new students with their registration and introducing them to the UWC campus and university life','UWC',3,1,700,1,1,1,NULL),(4,'SOPH Summer School','2016-02-08 08:30:00','2016-02-26 17:00:00','Summer School Programmes are aimed at our Postgraduate students','Summer School Programmes are aimed at our Postgraduate students only at this stage. These short courses provide introductory blocks for the core study modules in the postgraduate qualifications, as well as a general orientation to academic study, distance learning and information literacy.  Read more','School of Public Health UWC',3,1,1500,1,1,1,NULL),(5,'SOPH Winter School ','2016-06-20 08:30:00','2016-07-08 15:00:00','To secure your place in the interesting course of programmes, book by 29th April, 2016','The University of the Western Cape School of Public Health is proud to present the 38th Short Course School in a series of Winter and Summer Schools held at UWC since 1992. Read more','School of Public Health UWC',3,1,2000,1,1,1,NULL),(10,'Mobile camp ','2016-06-20 08:30:00','2016-07-08 15:00:00','To secure your place in the interesting course of programmes, book by 29th April, 2016','The University of the new mexico Cape School of Public Health is proud to present the 38th Short Course School in a series of Winter and Summer Schools held at UWC since 1992. Read more','School of Public Health UWC',3,1,2000,1,1,1,NULL),(11,'Make in India ','2016-06-20 08:30:00','2016-07-08 15:00:00','To secure your place in the interesting course of programmes, book by 29th April, 2016','The University of the new mexico Cape School of Public Health is proud to present the 38th Short Course School in a series of Winter and Summer Schools held at UWC since 1992. Read more','School of Public Health UWC',3,1,2000,1,1,1,NULL),(12,'Skilled India ','2016-06-20 08:30:00','2016-07-08 15:00:00','To secure your place in the interesting course of programmes, book by 29th April, 2016','The University of the new mexico Cape School of Public Health is proud to present the 38th Short Course School in a series of Winter and Summer Schools held at UWC since 1992. Read more','School of Public Health UWC',3,1,2000,1,1,1,NULL),(18,'fghj','2016-03-31 18:30:00','2016-03-31 18:30:00',NULL,'fghjk','fghjn',3,1,7,NULL,1,1,'fghij'),(19,'fghj','2016-03-31 18:30:00','2016-03-31 18:30:00',NULL,'fghjk','fghjn',3,1,7,NULL,1,1,'fghij'),(20,'Springs session','2016-04-01 06:30:00','2016-04-25 09:30:00',NULL,'Test event','Hyderabad',3,1,100,NULL,1,1,'java'),(21,'Springs session','2016-04-01 06:30:00','2016-04-25 09:30:00',NULL,'Test event','Hyderabad',3,1,100,NULL,1,1,'java'),(22,'Springs session','2016-04-01 06:30:00','2016-04-25 09:30:00',NULL,'Test event','Hyderabad',3,1,100,NULL,1,1,'java'),(23,'Sample','2016-04-04 06:30:00','2016-04-29 18:30:00',NULL,'Testing event created by ravi','Hyderabad',3,1,2000,NULL,1,1,'sample'),(24,'dfghjk','2016-04-03 18:30:00','2016-04-03 18:30:00',NULL,'dfg','dfghj',3,1,4,NULL,1,1,'uyyirryi'),(25,'Sample University event','2016-04-09 22:30:00','2016-04-15 18:30:00',NULL,'Sample long description for testing','Chicago',3,1,50,NULL,1,1,'java, android, php'),(26,'Wednesday April','2016-04-12 07:30:00','2016-04-20 16:30:00','Tested','Tested Evenet on wednesday','Pune',3,1,100,NULL,1,1,'prashant, devjiva, highschool, picture'),(27,'dfghjk','2016-04-05 18:30:00','2016-04-05 18:30:00',NULL,'fghj','fghjk',3,1,2,NULL,2,1,'fghj'),(28,'fghj','2016-04-05 18:30:00','2016-04-05 18:30:00','fghjkl','gvhbjnkml,','fgh',3,1,1,NULL,1,1,'fgvhbjk'),(29,'Devjiva Event','2016-04-06 18:30:00','2016-04-19 18:30:00','The Rosendale Trestle is a 940-foot (290 m) continuous truss bridge and former railroad trestle in Rosendale in Ulster County, New York.','The Rosendale Trestle is a 940-foot (290 m) continuous truss bridge and former railroad trestle in Rosendale in Ulster County, New York.The Rosendale Trestle is a 940-foot (290 m) continuous truss bridge and former railroad trestle in Rosendale in Ulster County, New York.','Pune',3,1,100,NULL,2,1,'bottle, pen, chair, table, key'),(30,'DevJiva 25','2016-04-05 18:30:00','2016-05-29 18:30:00','tested tested tested tested tested tested tested tested tested tested tested tested tested tested v','prashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashantprashant','Pune',3,1,1000,NULL,2,1,'table, chair, laptop, bottle, key'),(31,'Prashant 20','2016-04-06 18:30:00','2016-05-19 18:30:00','Prashant Prashant Prashant Prashant Prashant Prashant Prashant Prashant Prashant Prashant Prashant Prashant','BharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharamBharam','Pune',3,1,100,0,2,0,'table, chair, laptop'),(35,'sss','2016-04-04 18:15:00','2016-02-27 18:15:00','aaa','aaa','IPL',3,1,50,1,1,0,'aaaa'),(37,'New Event','2016-04-10 18:30:00','2016-04-29 18:30:00','tested','tested','Pune',3,1,100,0,2,0,'jnnk'),(38,'Computer Event','2016-04-10 18:30:00','2016-04-29 18:30:00','aacdaadacd','vsdvdsvddvds','Pune',3,1,100,0,2,0,'jkkkj'),(41,'Sansunng','2016-04-28 18:30:00','2016-04-29 18:30:00','cCDSV','VFVFSA','Pune',3,1,100,0,2,0,'FVSVSFFVF'),(43,'Dell Event Two','2016-04-13 18:30:00','2016-04-29 18:30:00','prashant prashant prashant prashant prashant prashant prashant prashant','barambarambarambarambarambarambarambarambarambarambarambarambarambarambaram','Pune',3,1,100,1,1,1,'water, bottle, key, mobile'),(44,'Samsung Event','2016-04-19 18:30:00','2016-04-29 18:30:00','tested tested tested tested tested tested tested','tested tested tested tested tested tested tested','Pune',3,1,100,1,1,1,'tested'),(45,'ipl9','2016-04-20 18:15:00','2016-04-20 18:15:00','hello','hello','hyd',3,1,8,0,1,1,'hello'),(46,'Studdds Event','2016-04-18 18:30:00','2016-04-19 18:30:00','testsed','tested','Pune',3,1,100,0,1,1,'bharam'),(47,'vega event','2016-04-25 18:30:00','2016-04-29 18:30:00','Tesyed TestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTestedTested','tested','Pune',3,1,100000,1,1,0,'Tested'),(48,'Search Event','2016-04-19 18:30:00','2016-04-29 18:30:00','Prashant Bharam\nFlat no. 615, Sai anant sahakari gruhrachana, near new india school, right bhusari colony, opp. Kothrud depo. Pune\nNear new india school\nPune - 411038\nMaharashtra','Prashant Bharam\nFlat no. 615, Sai anant sahakari gruhrachana, near new india school, right bhusari colony, opp. Kothrud depo. Pune\nNear new india school\nPune - 411038\nMaharashtraPrashant Bharam\nFlat no. 615, Sai anant sahakari gruhrachana, near new india school, right bhusari colony, opp. Kothrud depo. Pune\nNear new india school\nPune - 411038\nMaharashtra','Pune',3,1,100,1,2,1,'prashant, bharam'),(49,'The Event','2016-04-19 18:30:00','2016-04-29 18:30:00','prashant prashant prashant prashant prashant prashant prashant prashant prashant','prashant prashant prashant prashant prashant prashant prashant prashant','Pune',3,1,1000,0,2,0,'prashant'),(50,'Kinley Eevent','2016-04-19 18:30:00','2016-04-29 18:30:00','davfsv','vcvfags','Pune',3,1,100,1,1,1,'intel, inside, core'),(51,'Display 123','2016-04-19 18:30:00','2016-04-23 18:30:00','fe','QVef','Pune',3,1,100,0,1,1,'eqfeqf'),(52,'web event','2016-04-24 18:30:00','2016-04-29 18:30:00','saF','eqfq','Pune',3,1,122,0,1,1,'edeQ'),(53,'ubkunou','2016-04-12 18:28:00','2016-04-18 18:30:00',NULL,'sdcfsdcwsdcdsfsdfdsfdfsdfsdfsdfsdfs','dddwdf',3,1,100,0,2,0,'sdcsdfdsfsdf'),(54,'Shift Event','2016-04-25 18:30:00','2016-04-29 18:30:00','Tested','Tested','Pune',3,1,100,0,2,1,'cool, wave'),(55,'jnnlk','2016-04-12 18:30:00','2016-03-31 18:30:00',NULL,'edddsds','lm;lml',3,1,611,0,2,0,'ddaadasd'),(56,'ABC Event','2016-04-26 18:30:00','2016-04-29 18:30:00','Tested','Tested','Pune',3,1,1000,1,1,1,'Tested'),(57,'Search the Web','2016-04-26 18:30:00','2016-04-29 18:30:00','Teste','Tested','Pune',3,1,100,1,1,0,'teated'),(58,'Gadgets Events','2016-04-19 18:30:00','2016-04-25 18:30:00','Tested','Tested','Pune',3,1,1000,1,1,1,'Tested'),(59,'Windows Prashant','2016-04-27 18:30:00','2016-04-29 18:30:00','Tested','Tsetd','Pune',3,1,100,0,1,0,'tested'),(60,'Moto G2','2016-04-27 18:30:00','2016-04-29 18:30:00','Tested','Tested','Pune',3,1,100,1,1,1,'Tested'),(61,'Menu123','2016-04-19 18:30:00','2016-04-24 18:30:00','Tested','Tested','Pune',3,1,100,1,2,1,'tested'),(62,'www Event','2016-04-27 18:30:00','2016-04-29 18:30:00','tested','testedqtested','Pune',3,1,10000,1,2,0,'tested'),(63,'ipl2','2016-05-17 06:35:00','2016-05-19 06:36:00','hello','hello','Hyd',3,1,5,1,1,0,'hello'),(64,'DiwaliEvent','2016-05-11 11:33:00','2016-05-18 11:34:00','dfghjk','dfghjk','pune',3,1,12,1,2,1,'fghjk'),(65,'Inspiron 1','2016-05-05 06:50:00','2016-05-30 06:51:00','tested','tested','Pune',3,1,1000,1,1,1,'tested'),(66,'Inspiron 2','2016-05-05 06:50:00','2016-05-29 06:51:00','tested','tested','Pune',3,1,100,1,1,0,'tested'),(67,'Tata Sky','2016-05-06 06:50:00','2016-05-31 06:51:00','tested','tested','Pune',3,1,100,1,2,1,'fixtures, true, service, smt'),(68,'Durvaankur Event','2016-05-18 06:50:00','2016-05-25 06:51:00','tested','tested','Pune',3,1,100,0,1,1,'marathi, hindi, english'),(69,'Institute Event','2016-05-12 06:50:00','2016-05-26 06:51:00','tested','tt','Pune',3,1,100,0,2,1,'pursuit, foundation, business, touchpad'),(70,'Games XYZ','2016-06-01 06:38:00','2016-06-10 06:39:00','Test','Tested Tested','Xyz',3,1,200,0,2,1,'games'),(71,'Athletics Events','2016-07-01 06:38:00','2016-07-20 06:39:00','Test','Tested tested','Test',3,1,300,1,1,1,'Athletics'),(72,'Drawing Event','2016-07-13 06:38:00','2016-07-26 06:39:00','Test','Tested 123','Test123',3,1,500,1,1,1,'Art'),(73,'Career Event','2016-09-01 06:38:00','2016-09-05 06:39:00','Test','Tested Tested','Test 1234',3,1,400,0,2,1,'Career'),(74,'Civic event','2016-07-15 06:38:00','2016-09-25 06:39:00','Test','Tested','Test',3,1,150,0,1,0,'Civic'),(75,'Cultural Event','2016-06-26 06:38:00','2016-09-30 06:39:00','Test','Tested Tested','Test',3,1,250,1,1,1,'Cultural'),(76,'Entertainment Event','2016-08-10 06:38:00','2016-09-15 06:39:00','Test','Tested Tested','Test',3,1,50,0,2,1,'Entertainment'),(77,'Students Events','2016-05-10 06:38:00','2016-09-18 06:39:00','Test','Tested tested','Test',3,1,300,1,1,1,'Students'),(78,'Health Event','2016-06-21 06:38:00','2016-09-30 06:39:00','Test','Tested  Tested Tested Tested','Test',3,1,100,1,1,1,'Health'),(79,'Resident Event','2016-10-01 06:38:00','2016-10-07 06:39:00','Test','Tested Tested','Test',3,1,250,1,2,1,'Resident'),(80,'Campus Event','2016-10-10 06:38:00','2016-10-15 06:39:00','Test','Tested Tested','Test',3,1,400,1,2,1,'campus'),(81,'Social Event','2016-09-01 06:38:00','2016-09-15 06:39:00','Test','Tested Tested','Test',3,1,500,0,1,1,'Social'),(82,'Environmental Event','2016-05-15 06:38:00','2016-09-20 06:39:00','Test','Tested Tested','Test',3,1,600,1,1,1,'Environment'),(83,'Maaza Event','2016-05-11 09:15:00','2016-05-25 09:16:00','tested','tested','Pune',3,1,100,1,1,0,'tested'),(84,'MPSC Event','2016-05-06 08:48:00','2016-05-30 08:49:00','tested','tested','Pune',3,1,100,1,2,1,'bhugol, maharashtra, nirali, kahi, madat, hote'),(85,'cdavc','2016-05-24 08:48:00','2016-05-26 08:49:00','tested','tested','pune',3,1,100,1,1,1,'tested'),(86,'fkjkvbupfb','2016-05-06 08:53:00','2016-05-25 08:54:00','tested','tested','Pune',3,1,100,1,1,1,'tested'),(87,'MobileTechnology Event','2016-05-06 14:48:00','2016-05-13 14:49:00',NULL,'Event is happening on mobile technologies android, iphone','Hyderabad',3,1,50,1,1,1,'java, android, iphone'),(88,'Delete Event','2016-05-07 08:43:00','2016-05-30 08:44:00','tested','tested','Pune',3,1,100,0,2,1,'tested'),(89,'Yahoo Event','2016-05-07 11:14:00','2016-05-31 11:15:00','tested','tested','Pune',3,1,100,0,2,1,'tested'),(90,'Painting Event','2016-05-16 10:17:00','2016-05-19 10:18:00','painting','Painting event is held in hyderabad for social cause.','Hyderabad',3,1,100,0,1,1,'fd');
/*!40000 ALTER TABLE `EVENTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_INTERESTS`
--

DROP TABLE IF EXISTS `EVENT_INTERESTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_INTERESTS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `EVENT_ID` bigint(25) DEFAULT NULL,
  `INTEREST_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FF11_idx` (`EVENT_ID`),
  KEY `FF22_idx` (`INTEREST_ID`),
  CONSTRAINT `FF11` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FF22` FOREIGN KEY (`INTEREST_ID`) REFERENCES `INTERESTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_INTERESTS`
--

LOCK TABLES `EVENT_INTERESTS` WRITE;
/*!40000 ALTER TABLE `EVENT_INTERESTS` DISABLE KEYS */;
INSERT INTO `EVENT_INTERESTS` VALUES (1,2,6),(2,2,1),(3,4,3),(4,5,3),(6,1,6),(7,18,1),(8,19,1),(9,20,1),(10,20,2),(11,20,3),(12,20,4),(13,20,5),(14,20,6),(15,20,7),(16,20,8),(17,20,9),(18,20,10),(19,20,11),(20,20,12),(21,21,1),(22,21,2),(23,21,3),(24,21,4),(25,21,5),(26,21,6),(27,21,7),(28,21,8),(29,21,9),(30,21,10),(31,21,11),(32,21,12),(33,22,1),(34,22,2),(35,22,3),(36,22,4),(37,22,5),(38,22,6),(39,22,7),(40,22,8),(41,22,9),(42,22,10),(43,22,11),(44,22,12),(45,23,1),(46,23,2),(47,23,3),(48,23,4),(49,23,5),(50,23,6),(51,23,7),(52,23,8),(53,23,9),(54,23,10),(55,23,11),(56,23,12),(57,24,4),(58,25,1),(59,25,2),(60,25,3),(61,26,1),(62,27,3),(63,28,2),(64,29,1),(65,30,1),(66,31,1),(67,35,1),(68,35,2),(69,35,4),(70,37,1),(71,38,1),(72,41,1),(73,43,1),(74,44,1),(75,44,12),(76,45,1),(77,46,1),(78,47,1),(79,48,1),(80,49,1),(81,49,2),(82,49,3),(83,49,4),(84,49,5),(85,49,6),(86,49,7),(87,49,8),(88,49,9),(89,49,10),(90,49,11),(91,49,12),(92,49,13),(93,49,14),(94,49,15),(95,49,16),(96,49,17),(97,50,1),(98,51,1),(99,52,1),(100,53,9),(101,54,1),(102,55,3),(103,56,1),(104,57,1),(105,58,2),(106,58,3),(107,58,4),(108,58,5),(109,58,6),(110,58,7),(111,58,8),(112,58,9),(113,58,10),(114,58,11),(115,58,12),(116,58,13),(117,58,14),(118,58,15),(119,58,16),(120,58,17),(121,59,1),(122,59,2),(123,59,3),(124,59,4),(125,59,5),(126,59,6),(127,59,7),(128,59,8),(129,59,9),(130,59,10),(131,59,11),(132,59,12),(133,59,13),(134,59,14),(135,59,15),(136,59,16),(137,59,17),(138,60,17),(139,61,1),(140,62,1),(141,63,1),(142,63,2),(143,63,3),(144,64,5),(145,65,1),(146,65,2),(147,65,3),(148,65,4),(149,65,5),(150,65,6),(151,65,7),(152,65,8),(153,65,9),(154,65,10),(155,65,11),(156,65,12),(157,65,13),(158,65,14),(159,65,15),(160,65,16),(161,65,17),(162,66,1),(163,66,2),(164,66,15),(165,66,16),(166,67,1),(167,67,2),(168,67,3),(169,67,4),(170,67,5),(171,67,6),(172,67,7),(173,67,8),(174,67,9),(175,67,10),(176,67,11),(177,67,12),(178,67,13),(179,67,14),(180,67,15),(181,67,16),(182,67,17),(183,68,1),(184,69,1),(185,69,2),(186,70,1),(187,71,2),(188,72,3),(189,73,4),(190,74,5),(191,75,6),(192,76,7),(193,77,8),(194,78,9),(195,79,10),(196,80,12),(197,81,15),(198,82,16),(199,83,1),(200,83,2),(201,83,3),(202,83,4),(203,83,5),(204,83,6),(205,83,7),(206,83,8),(207,83,9),(208,83,10),(209,83,11),(210,83,12),(211,83,13),(212,83,14),(213,83,15),(214,83,16),(215,83,17),(216,84,1),(217,85,1),(218,86,1),(219,87,1),(220,87,2),(221,88,1),(222,89,1),(223,90,4),(224,90,5),(225,90,6),(226,90,7),(227,90,8);
/*!40000 ALTER TABLE `EVENT_INTERESTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_SKILLS`
--

DROP TABLE IF EXISTS `EVENT_SKILLS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_SKILLS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `EVENT_ID` bigint(25) DEFAULT NULL,
  `SKILL_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EVENT_ID_idx` (`EVENT_ID`),
  KEY `SKILL_ID_idx` (`SKILL_ID`),
  CONSTRAINT `FEVENT` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FSKILL` FOREIGN KEY (`SKILL_ID`) REFERENCES `SKILLS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_SKILLS`
--

LOCK TABLES `EVENT_SKILLS` WRITE;
/*!40000 ALTER TABLE `EVENT_SKILLS` DISABLE KEYS */;
INSERT INTO `EVENT_SKILLS` VALUES (1,1,1),(2,1,3),(3,1,5),(4,1,4),(5,1,15),(6,1,10),(7,1,21),(8,1,25),(9,18,13),(10,19,13),(11,20,17),(12,21,17),(13,22,17),(14,23,11),(15,23,15),(16,24,13),(17,25,2),(18,25,4),(19,25,10),(20,25,2),(21,26,1),(22,26,2),(23,26,6),(24,26,7),(25,26,11),(26,26,16),(27,26,17),(28,26,12),(29,26,25),(30,26,23),(31,27,13),(32,28,7),(33,28,13),(34,28,13),(35,29,3),(36,29,15),(37,30,1),(38,30,2),(39,30,3),(40,30,4),(41,30,5),(42,30,6),(43,30,7),(44,30,8),(45,30,9),(46,30,10),(47,30,11),(48,30,12),(49,30,13),(50,30,14),(51,30,15),(52,30,16),(53,30,17),(54,30,18),(55,30,19),(56,30,20),(57,30,21),(58,30,22),(59,30,23),(60,30,24),(61,30,25),(62,31,3),(63,31,14),(64,31,18),(73,35,16),(76,37,14),(77,43,20),(78,44,15),(79,45,16),(80,46,1),(81,46,6),(82,46,11),(83,46,17),(84,46,25),(85,47,5),(86,48,17),(87,49,1),(88,49,8),(89,49,14),(90,49,17),(91,49,25),(92,50,14),(93,51,18),(94,52,16),(95,53,12),(96,54,17),(97,55,16),(98,56,16),(99,57,16),(100,58,16),(101,59,17),(102,60,8),(103,61,16),(104,61,2),(105,62,16),(106,63,18),(107,63,13),(108,63,10),(109,64,14),(110,65,8),(111,66,15),(112,67,1),(113,67,2),(114,67,3),(115,67,4),(116,67,5),(117,67,6),(118,67,7),(119,67,8),(120,67,9),(121,67,10),(122,67,11),(123,67,12),(124,67,13),(125,67,14),(126,67,15),(127,67,16),(128,67,17),(129,67,18),(130,67,19),(131,67,20),(132,67,21),(133,67,22),(134,67,23),(135,67,24),(136,67,25),(137,68,10),(138,69,14),(139,70,7),(140,71,9),(141,72,24),(142,73,25),(143,74,13),(144,75,1),(145,76,4),(146,77,23),(147,78,16),(148,79,23),(149,80,22),(150,81,9),(151,82,20),(152,83,14),(153,84,9),(154,85,14),(155,86,6),(156,87,1),(157,88,17),(158,89,10),(159,90,4);
/*!40000 ALTER TABLE `EVENT_SKILLS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_SKILL_SCHEDULE`
--

DROP TABLE IF EXISTS `EVENT_SKILL_SCHEDULE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_SKILL_SCHEDULE` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `EVENT_ID` bigint(25) DEFAULT NULL,
  `EVENT_SKILL_ID` bigint(25) DEFAULT NULL,
  `EVENT_START_TIME` datetime DEFAULT NULL,
  `EVENT_END_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EVENT11_idx` (`EVENT_ID`),
  KEY `ESKILL11_idx` (`EVENT_SKILL_ID`),
  CONSTRAINT `EVENT11` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ESKILL11` FOREIGN KEY (`EVENT_SKILL_ID`) REFERENCES `EVENT_SKILLS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_SKILL_SCHEDULE`
--

LOCK TABLES `EVENT_SKILL_SCHEDULE` WRITE;
/*!40000 ALTER TABLE `EVENT_SKILL_SCHEDULE` DISABLE KEYS */;
INSERT INTO `EVENT_SKILL_SCHEDULE` VALUES (1,18,9,'2016-03-31 18:30:00','2016-03-31 18:30:00'),(2,19,10,'2016-03-31 18:30:00','2016-03-31 18:30:00'),(3,20,11,'2016-03-31 18:30:00','2016-04-06 06:30:00'),(4,21,12,'2016-03-31 18:30:00','2016-04-05 18:30:00'),(5,22,13,'2016-03-31 18:30:00','2016-04-05 18:30:00'),(6,23,14,'2016-04-04 07:30:00','2016-04-13 06:30:00'),(7,23,15,'2016-04-04 06:30:00','2016-04-20 18:30:00'),(8,24,16,'2016-04-03 18:30:00','2016-04-03 18:30:00'),(9,25,17,'2016-04-10 09:30:00','2016-04-10 11:30:00'),(10,25,18,'2016-04-11 06:30:00','2016-04-11 08:30:00'),(11,25,19,'2016-04-12 18:30:00','2016-04-13 09:30:00'),(12,25,20,'2016-04-11 18:30:00','2016-04-12 08:30:00'),(13,26,21,'2016-04-04 18:30:00','2016-04-05 18:30:00'),(14,26,22,'2016-04-25 18:30:00','2016-04-24 18:30:00'),(15,26,23,'2016-04-10 18:30:00','2016-04-10 18:30:00'),(16,26,24,NULL,NULL),(17,26,25,NULL,NULL),(18,26,26,NULL,NULL),(19,26,27,NULL,NULL),(20,26,28,NULL,NULL),(21,26,29,NULL,NULL),(22,26,30,NULL,NULL),(23,27,31,'2016-04-05 18:30:00','2016-04-05 18:30:00'),(24,28,32,'2016-04-05 18:30:00','2016-04-25 18:30:00'),(25,28,33,'2016-04-20 18:30:00','2016-04-05 18:30:00'),(26,28,34,'2016-04-05 18:30:00','2016-04-13 18:30:00'),(27,29,35,'2016-04-06 18:30:00','2016-04-07 18:30:00'),(28,29,36,'2016-04-08 18:30:00','2016-04-10 18:30:00'),(29,30,37,'2016-04-05 18:30:00','2016-04-06 18:30:00'),(30,30,38,'2016-04-06 18:30:00','2016-04-07 18:30:00'),(31,30,39,'2016-04-07 18:30:00','2016-04-08 18:30:00'),(32,30,40,'2016-04-08 18:30:00','2016-04-09 18:30:00'),(33,30,41,'2016-04-09 18:30:00','2016-04-10 18:30:00'),(34,30,42,'2016-04-10 18:30:00','2016-04-11 18:30:00'),(35,30,43,'2016-04-11 18:30:00','2016-04-12 18:30:00'),(36,30,44,'2016-04-12 18:30:00','2016-04-13 18:30:00'),(37,30,45,'2016-04-13 18:30:00','2016-04-14 18:30:00'),(38,30,46,'2016-04-14 18:30:00','2016-04-15 18:30:00'),(39,30,47,'2016-04-15 18:30:00','2016-04-16 18:30:00'),(40,30,48,'2016-04-16 18:30:00','2016-04-17 18:30:00'),(41,30,49,'2016-04-17 18:30:00','2016-04-18 18:30:00'),(42,30,50,'2016-04-18 18:30:00','2016-04-19 18:30:00'),(43,30,51,'2016-04-19 18:30:00','2016-04-20 18:30:00'),(44,30,52,'2016-04-20 18:30:00','2016-04-21 18:30:00'),(45,30,53,'2016-04-21 18:30:00','2016-04-22 18:30:00'),(46,30,54,'2016-04-22 18:30:00','2016-04-23 18:30:00'),(47,30,55,'2016-04-23 18:30:00','2016-04-24 18:30:00'),(48,30,56,'2016-04-24 18:30:00','2016-04-25 18:30:00'),(49,30,57,'2016-04-25 18:30:00','2016-04-26 18:30:00'),(50,30,58,'2016-04-26 18:30:00','2016-04-27 18:30:00'),(51,30,59,'2016-04-27 18:30:00','2016-04-28 18:30:00'),(52,30,60,'2016-04-28 18:30:00','2016-04-29 18:30:00'),(53,30,61,'2016-04-29 18:30:00','2016-04-30 18:30:00'),(54,31,62,'2016-04-19 18:30:00','2016-04-20 18:30:00'),(55,31,63,'2016-04-25 18:30:00','2016-04-27 18:30:00'),(56,31,64,'2016-05-02 18:30:00','2016-05-05 18:30:00'),(62,35,73,'2016-05-03 18:15:00','2016-04-25 18:15:00'),(64,37,76,'2016-04-18 18:30:00','2016-04-20 18:30:00'),(65,43,77,'2016-04-19 18:30:00','2016-04-26 18:30:00'),(66,44,78,'2016-04-20 18:30:00','2016-04-21 18:30:00'),(67,45,79,'2016-04-26 18:15:00','2016-04-19 18:15:00'),(68,46,80,'2016-04-19 18:30:00','2016-04-20 18:30:00'),(69,46,81,'2016-04-21 18:30:00','2016-04-22 18:30:00'),(70,46,82,'2016-04-22 18:30:00','2016-04-23 18:30:00'),(71,46,83,'2016-04-23 18:30:00','2016-04-24 18:30:00'),(72,46,84,'2016-04-24 18:30:00','2016-04-25 18:30:00'),(73,47,85,'2016-04-27 18:30:00','2016-04-28 18:30:00'),(74,48,86,'2016-04-25 18:30:00','2016-04-26 18:30:00'),(75,49,87,'2016-04-18 18:30:00','2016-04-19 18:30:00'),(76,49,88,'2016-04-19 18:30:00','2016-04-20 18:30:00'),(77,49,89,'2016-04-20 18:30:00','2016-04-21 18:30:00'),(78,49,90,'2016-04-21 18:30:00','2016-04-22 18:30:00'),(79,49,91,'2016-04-22 18:30:00','2016-04-23 18:30:00'),(80,50,92,'2016-04-25 18:30:00','2016-04-26 18:30:00'),(81,51,93,'2016-04-19 18:30:00','2016-04-21 18:30:00'),(82,52,94,'2016-04-25 18:30:00','2016-04-26 18:30:00'),(83,53,95,'2016-03-31 18:30:00','2016-04-25 18:30:00'),(84,54,96,'2016-04-26 18:30:00','2016-04-27 18:30:00'),(85,55,97,'2016-04-07 18:30:00','2016-04-11 18:30:00'),(86,56,98,'2016-04-27 18:30:00','2016-04-28 18:30:00'),(87,57,99,'2016-04-26 18:30:00','2016-04-27 18:30:00'),(88,58,100,'2016-04-27 18:30:00','2016-04-28 18:30:00'),(89,59,101,'2016-04-27 18:30:00','2016-04-28 18:30:00'),(90,60,102,'2016-04-27 18:30:00','2016-04-29 18:30:00'),(91,61,103,'2016-04-18 18:30:00','2016-04-23 18:30:00'),(92,61,104,'2016-04-25 18:30:00','2016-04-27 18:30:00'),(93,62,105,'2016-04-27 18:30:00','2016-04-28 18:30:00'),(94,63,106,'2016-05-30 18:15:00','2016-05-30 18:16:00'),(95,63,107,'2016-05-16 18:15:00','2016-05-30 18:16:00'),(96,63,108,'2016-05-18 18:15:00','2016-05-30 18:16:00'),(97,64,109,'2016-05-11 11:34:00','2016-05-13 11:35:00'),(98,65,110,'2016-05-06 06:51:00','2016-05-29 06:52:00'),(99,66,111,'2016-05-27 06:51:00','2016-05-29 06:50:00'),(100,67,112,'2016-05-06 06:51:00','2016-05-07 06:52:00'),(101,67,113,'2016-05-06 06:51:00','2016-05-07 06:52:00'),(102,67,114,'2016-05-07 06:51:00','2016-05-08 06:52:00'),(103,67,115,'2016-05-08 06:51:00','2016-05-09 06:52:00'),(104,67,116,'2016-05-09 06:51:00','2016-05-10 06:52:00'),(105,67,117,'2016-05-10 06:51:00','2016-05-11 06:52:00'),(106,67,118,'2016-05-11 06:51:00','2016-05-12 06:52:00'),(107,67,119,'2016-05-12 06:51:00','2016-05-13 06:52:00'),(108,67,120,'2016-05-13 06:51:00','2016-05-14 06:52:00'),(109,67,121,'2016-05-14 06:51:00','2016-05-15 06:52:00'),(110,67,122,'2016-05-15 06:51:00','2016-05-16 06:52:00'),(111,67,123,'2016-05-16 06:51:00','2016-05-17 06:52:00'),(112,67,124,'2016-05-17 06:51:00','2016-05-18 06:52:00'),(113,67,125,'2016-05-18 06:51:00','2016-05-19 06:52:00'),(114,67,126,'2016-05-19 06:51:00','2016-05-20 06:52:00'),(115,67,127,'2016-05-20 06:51:00','2016-05-21 06:52:00'),(116,67,128,'2016-05-21 06:51:00','2016-05-22 06:52:00'),(117,67,129,'2016-05-22 06:51:00','2016-05-23 06:52:00'),(118,67,130,'2016-05-23 06:51:00','2016-05-24 06:52:00'),(119,67,131,'2016-05-24 06:51:00','2016-05-25 06:52:00'),(120,67,132,'2016-05-25 06:51:00','2016-05-26 06:52:00'),(121,67,133,'2016-05-26 06:51:00','2016-05-27 06:52:00'),(122,67,134,'2016-05-27 06:51:00','2016-05-28 06:52:00'),(123,67,135,'2016-05-28 06:51:00','2016-05-29 06:52:00'),(124,67,136,'2016-05-29 06:51:00','2016-05-30 06:52:00'),(125,68,137,'2016-05-18 06:51:00','2016-05-24 06:52:00'),(126,69,138,'2016-05-12 06:51:00','2016-05-25 06:52:00'),(127,70,139,'2016-06-01 06:39:00','2016-06-09 06:40:00'),(128,71,140,'2016-07-01 06:39:00','2016-07-19 06:40:00'),(129,72,141,'2016-07-13 06:39:00','2016-07-25 06:40:00'),(130,73,142,'2016-09-01 06:39:00','2016-09-04 06:40:00'),(131,74,143,'2016-07-15 06:39:00','2016-07-25 06:40:00'),(132,75,144,'2016-06-26 06:39:00','2016-06-30 06:40:00'),(133,76,145,'2016-08-10 06:39:00','2016-08-17 06:40:00'),(134,77,146,'2016-05-10 06:39:00','2016-05-17 06:40:00'),(135,78,147,'2016-06-21 06:39:00','2016-06-30 06:40:00'),(136,79,148,'2016-10-01 06:39:00','2016-10-06 06:40:00'),(137,80,149,'2016-10-10 06:39:00','2016-10-14 06:40:00'),(138,81,150,'2016-09-01 06:39:00','2016-09-14 06:40:00'),(139,82,151,'2016-05-15 06:39:00','2016-05-25 06:40:00'),(140,83,152,'2016-05-11 09:16:00','2016-05-12 09:17:00'),(141,84,153,'2016-05-07 08:49:00','2016-05-08 08:50:00'),(142,85,154,'2016-05-24 08:49:00','2016-05-25 08:50:00'),(143,86,155,'2016-05-06 08:54:00','2016-05-07 08:55:00'),(144,87,156,'2016-05-06 14:49:00','2016-05-06 15:50:00'),(145,88,157,'2016-05-08 08:44:00','2016-05-09 08:45:00'),(146,89,158,'2016-05-09 11:15:00','2016-05-25 11:16:00'),(147,90,159,'2016-05-16 10:18:00','2016-05-18 10:19:00');
/*!40000 ALTER TABLE `EVENT_SKILL_SCHEDULE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_SOCIAL_BADGE`
--

DROP TABLE IF EXISTS `EVENT_SOCIAL_BADGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_SOCIAL_BADGE` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `SOCIAL_BADGE_ID` bigint(25) DEFAULT NULL,
  `EVENT_ID` bigint(25) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `social_badge_id_idx` (`SOCIAL_BADGE_ID`),
  KEY `event_id_idx` (`EVENT_ID`),
  CONSTRAINT `event_id_fkk` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `social_badge_id_fk` FOREIGN KEY (`SOCIAL_BADGE_ID`) REFERENCES `SOCIAL_BADGES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_SOCIAL_BADGE`
--

LOCK TABLES `EVENT_SOCIAL_BADGE` WRITE;
/*!40000 ALTER TABLE `EVENT_SOCIAL_BADGE` DISABLE KEYS */;
/*!40000 ALTER TABLE `EVENT_SOCIAL_BADGE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_SPONSOR`
--

DROP TABLE IF EXISTS `EVENT_SPONSOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_SPONSOR` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `EVENT_ID` bigint(25) DEFAULT NULL,
  `SPONSOR_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `event_id_idx` (`EVENT_ID`),
  KEY `sponsor_id_idx` (`SPONSOR_ID`),
  CONSTRAINT `event_id_sp` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sponsor_id` FOREIGN KEY (`SPONSOR_ID`) REFERENCES `SPONSOR` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_SPONSOR`
--

LOCK TABLES `EVENT_SPONSOR` WRITE;
/*!40000 ALTER TABLE `EVENT_SPONSOR` DISABLE KEYS */;
INSERT INTO `EVENT_SPONSOR` VALUES (1,19,1),(2,22,2),(3,26,3),(4,26,4),(5,28,5),(6,29,6),(7,30,7),(8,31,8),(9,35,9),(10,37,10),(11,38,11),(12,41,12),(13,43,13),(14,44,14),(15,45,15),(16,46,16),(17,47,17),(18,48,18),(19,49,19),(20,50,20),(21,51,21),(22,52,22),(23,54,23),(24,56,24),(25,57,25),(26,58,26),(27,59,27),(28,60,28),(29,61,29),(30,62,30),(31,63,31),(32,64,32),(33,65,33),(34,66,34),(35,67,35),(36,68,36),(37,69,37),(38,83,38),(39,84,39),(40,85,40),(41,86,41),(42,88,42),(43,89,43);
/*!40000 ALTER TABLE `EVENT_SPONSOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_TAGS`
--

DROP TABLE IF EXISTS `EVENT_TAGS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_TAGS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `EVENT_ID` bigint(25) DEFAULT NULL,
  `TAG_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EVENT1FF_idx` (`EVENT_ID`),
  KEY `TAGFF_idx` (`TAG_ID`),
  CONSTRAINT `EVENT1FF` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TAGFF` FOREIGN KEY (`TAG_ID`) REFERENCES `TAGS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_TAGS`
--

LOCK TABLES `EVENT_TAGS` WRITE;
/*!40000 ALTER TABLE `EVENT_TAGS` DISABLE KEYS */;
INSERT INTO `EVENT_TAGS` VALUES (1,1,2),(3,1,5),(4,18,2),(5,19,2),(6,20,1),(7,20,2),(9,21,1),(10,21,2),(12,22,1),(13,22,2),(15,23,1),(16,23,2),(18,23,4),(19,23,5),(20,23,6),(21,24,5),(22,25,1),(23,25,2),(25,26,1),(26,26,2),(28,26,4),(29,26,5),(30,26,6),(33,29,1),(34,29,2),(35,30,1),(36,30,2),(38,30,4),(39,30,5),(40,30,6),(41,31,1),(42,31,2),(44,31,4),(45,31,5),(46,31,6),(60,35,1),(61,35,2),(68,37,1),(69,38,1),(72,41,1),(74,43,1),(75,44,1),(76,45,1),(77,46,1),(78,47,1),(79,48,1),(80,48,2),(82,48,4),(83,48,5),(84,48,6),(85,49,1),(86,49,2),(88,49,4),(89,49,5),(90,49,6),(91,50,1),(92,50,2),(93,51,1),(94,52,1),(95,53,1),(96,54,1),(97,55,1),(98,56,1),(99,57,1),(100,58,1),(101,58,2),(102,58,4),(103,58,5),(104,59,1),(105,59,2),(106,59,4),(107,59,5),(108,59,6),(109,60,1),(110,60,2),(111,60,4),(112,60,5),(113,60,6),(114,61,1),(115,62,1),(116,63,1),(117,63,2),(118,63,4),(119,64,6),(120,65,1),(121,65,2),(122,65,4),(123,65,5),(124,65,6),(125,66,1),(126,66,2),(127,66,4),(128,66,5),(129,66,6),(130,67,1),(131,67,2),(132,67,4),(133,67,5),(134,67,6),(135,68,1),(136,69,1),(137,70,1),(138,70,2),(139,71,1),(140,71,2),(141,71,4),(142,72,1),(143,72,2),(144,72,5),(145,72,6),(146,73,1),(147,73,2),(148,73,4),(149,73,5),(150,73,6),(151,74,1),(152,74,5),(153,75,1),(154,75,6),(155,76,1),(156,76,2),(157,76,4),(158,76,5),(159,77,1),(160,77,2),(161,78,1),(162,78,2),(163,78,4),(164,78,5),(165,78,6),(166,79,1),(167,79,2),(168,80,1),(169,80,5),(170,81,2),(171,81,6),(172,82,1),(173,82,2),(174,83,1),(175,83,2),(176,83,4),(177,83,5),(178,83,6),(179,84,1),(180,85,1),(181,86,1),(182,87,1),(183,87,2),(184,88,1),(185,88,2),(186,88,4),(187,88,5),(188,88,6),(189,89,1),(190,90,1),(191,90,2),(192,90,4),(193,90,5),(194,90,6);
/*!40000 ALTER TABLE `EVENT_TAGS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_THEME`
--

DROP TABLE IF EXISTS `EVENT_THEME`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_THEME` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `EVENT_ID` bigint(25) DEFAULT NULL,
  `THEME_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EV11_idx` (`EVENT_ID`),
  KEY `THEM11_idx` (`THEME_ID`),
  CONSTRAINT `EV11` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `THEM11` FOREIGN KEY (`THEME_ID`) REFERENCES `THEMEBADGE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_THEME`
--

LOCK TABLES `EVENT_THEME` WRITE;
/*!40000 ALTER TABLE `EVENT_THEME` DISABLE KEYS */;
/*!40000 ALTER TABLE `EVENT_THEME` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_TYPE`
--

DROP TABLE IF EXISTS `EVENT_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_TYPE` (
  `ID` bigint(25) NOT NULL,
  `EVENT_TYPE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_TYPE`
--

LOCK TABLES `EVENT_TYPE` WRITE;
/*!40000 ALTER TABLE `EVENT_TYPE` DISABLE KEYS */;
INSERT INTO `EVENT_TYPE` VALUES (1,'PUBLIC'),(2,'PRIVATE');
/*!40000 ALTER TABLE `EVENT_TYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FACEBOOK_PROFILE`
--

DROP TABLE IF EXISTS `FACEBOOK_PROFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FACEBOOK_PROFILE` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `FACEBOOK_ID` bigint(25) DEFAULT NULL,
  `SHORT_LIVED_TOKEN` varchar(500) DEFAULT NULL,
  `LONG_LIVED_TOKEN` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FACEBOOK_PROFILE`
--

LOCK TABLES `FACEBOOK_PROFILE` WRITE;
/*!40000 ALTER TABLE `FACEBOOK_PROFILE` DISABLE KEYS */;
/*!40000 ALTER TABLE `FACEBOOK_PROFILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INTERESTS`
--

DROP TABLE IF EXISTS `INTERESTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INTERESTS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `INTEREST_NAME` varchar(45) DEFAULT NULL,
  `UNIVERSITY_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UNIVERSITY_IN_FK_idx` (`UNIVERSITY_ID`),
  CONSTRAINT `UNIVERSITY_IN_FK` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `UNIVERSITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INTERESTS`
--

LOCK TABLES `INTERESTS` WRITE;
/*!40000 ALTER TABLE `INTERESTS` DISABLE KEYS */;
INSERT INTO `INTERESTS` VALUES (1,'Academic Support',1),(2,'Athletics and Recreation',1),(3,'Art (Performing and Visual)',1),(4,'Career Assistance',1),(5,'Civic Engagement',1),(6,'Cultural',1),(7,'Entertainment and Enlightenment',1),(8,'Graduate Students',1),(9,'Health',1),(10,'Residence Life',1),(11,'Student Government',1),(12,'Services on Campus',1),(13,'Student Orgs',1),(14,'Spiritual',1),(15,'Social',1),(16,'Environmental',1),(17,'STEM',1);
/*!40000 ALTER TABLE `INTERESTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOBO_BADGES`
--

DROP TABLE IF EXISTS `LOBO_BADGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOBO_BADGES` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `LOBO_BADGE_NAME` varchar(100) DEFAULT NULL,
  `EFFECTIVE_COMMUNICATION` varchar(100) DEFAULT NULL,
  `EFFECTIVE_COMMUNICATION_MEDAL` bigint(25) DEFAULT NULL,
  `COLLABORATION` varchar(100) DEFAULT NULL,
  `COLLABORATION_MEDAL` bigint(25) DEFAULT NULL,
  `CRITICAL_THINKING` varchar(100) DEFAULT NULL,
  `CRITICAL_THINKING_MEDAL` bigint(25) DEFAULT NULL,
  `PROFESSIONALISM` varchar(100) DEFAULT NULL,
  `PROFESSIONALISM_MEDAL` bigint(25) DEFAULT NULL,
  `REASEARCH_ANALYSIS` varchar(100) DEFAULT NULL,
  `REASEARCH_ANALYSIS_MEDAL` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EFFECTIVE_COMMU_idx` (`EFFECTIVE_COMMUNICATION_MEDAL`),
  KEY `COLLABORATION_idx` (`COLLABORATION_MEDAL`),
  KEY `CRITICAL_THINKING_idx` (`CRITICAL_THINKING_MEDAL`),
  KEY `PROFESSIONALISM_idx` (`PROFESSIONALISM_MEDAL`),
  KEY `RESEARCH_ANALYSIS_idx` (`REASEARCH_ANALYSIS_MEDAL`),
  CONSTRAINT `EFFECTIVE_COMMU` FOREIGN KEY (`EFFECTIVE_COMMUNICATION_MEDAL`) REFERENCES `SKILL_BADGES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `COLLABORATION` FOREIGN KEY (`COLLABORATION_MEDAL`) REFERENCES `SKILL_BADGES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `CRITICAL_THINKING` FOREIGN KEY (`CRITICAL_THINKING_MEDAL`) REFERENCES `SKILL_BADGES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PROFESSIONALISM` FOREIGN KEY (`PROFESSIONALISM_MEDAL`) REFERENCES `SKILL_BADGES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RESEARCH_ANALYSIS` FOREIGN KEY (`REASEARCH_ANALYSIS_MEDAL`) REFERENCES `SKILL_BADGES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOBO_BADGES`
--

LOCK TABLES `LOBO_BADGES` WRITE;
/*!40000 ALTER TABLE `LOBO_BADGES` DISABLE KEYS */;
INSERT INTO `LOBO_BADGES` VALUES (1,'Lobo Pup','4',1,'2',1,'3',1,'4',1,'5',1),(2,'Lobo Scout','3',2,'2',2,'3',2,'4',2,'5',2),(3,'Lobo','1',3,'3',3,'3',3,'4',3,'5',3),(4,'Pak Leader','1',4,'3',4,'3',4,'4',4,'5',4);
/*!40000 ALTER TABLE `LOBO_BADGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PATHFINDER`
--

DROP TABLE IF EXISTS `PATHFINDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PATHFINDER` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `NOTES` varchar(500) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `TITLE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PATHFINDER`
--

LOCK TABLES `PATHFINDER` WRITE;
/*!40000 ALTER TABLE `PATHFINDER` DISABLE KEYS */;
INSERT INTO `PATHFINDER` VALUES (1,'The Pathfinder UNM Student Handbook  provides campus services and campus policies available to students. Policies such as the student code of conduct and grievance procedures are located within The Pathfinder.','2016-06-20 08:30:00','UNM Student Handbook');
/*!40000 ALTER TABLE `PATHFINDER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROLES`
--

DROP TABLE IF EXISTS `ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLES` (
  `ID` bigint(25) NOT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `UNIVERSITY_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UNIVERSITY_RO_FK_idx` (`UNIVERSITY_ID`),
  CONSTRAINT `UNIVERSITY_RO_FK` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `UNIVERSITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROLES`
--

LOCK TABLES `ROLES` WRITE;
/*!40000 ALTER TABLE `ROLES` DISABLE KEYS */;
INSERT INTO `ROLES` VALUES (1,'ADMIN',1),(2,'STUDENT',1),(3,'USER',1),(4,'SUPER_ADMIN',1);
/*!40000 ALTER TABLE `ROLES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SKILLS`
--

DROP TABLE IF EXISTS `SKILLS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SKILLS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `SKILL_NAME` varchar(45) DEFAULT NULL,
  `SKILL_CATEGORY_ID` bigint(25) DEFAULT NULL,
  `UNIVERSITY_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SKILL_CATEGORY_idx` (`SKILL_CATEGORY_ID`),
  KEY `UNIVERSITY_SK_FK_idx` (`UNIVERSITY_ID`),
  CONSTRAINT `SKILL_CATEGORY` FOREIGN KEY (`SKILL_CATEGORY_ID`) REFERENCES `SKILL_CATEGORIES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `UNIVERSITY_SK_FK` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `UNIVERSITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SKILLS`
--

LOCK TABLES `SKILLS` WRITE;
/*!40000 ALTER TABLE `SKILLS` DISABLE KEYS */;
INSERT INTO `SKILLS` VALUES (1,'Written Communication',1,1),(2,'Oral Communication',1,1),(3,'Non Verbal Communication',1,1),(4,'Active Listening ',1,1),(5,'Contextual Communication',1,1),(6,'Creating and Maintaing relationships',2,1),(7,'Group and team dynamics',2,1),(8,'Measuring progress and sucess',2,1),(9,'Leadership Practice',2,1),(10,'Community Engagement',2,1),(11,'Exploration',3,1),(12,'Application',3,1),(13,'Analyzation',3,1),(14,'Integration',3,1),(15,'Evaluation',3,1),(16,'Research And Assessment',4,1),(17,'Data Collection',4,1),(18,'Data Analysis',4,1),(19,'Communication and research assesment',4,1),(20,'Impact and ethics assessement',4,1),(21,'Ethics and Integrity',5,1),(22,'Professional Development',5,1),(23,'Personal Development',5,1),(24,'Workplace expectations',5,1),(25,'Career Exploration',5,1);
/*!40000 ALTER TABLE `SKILLS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SKILL_BADGES`
--

DROP TABLE IF EXISTS `SKILL_BADGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SKILL_BADGES` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `SKILL_BADGE_NAME` varchar(45) DEFAULT NULL,
  `SKILL_BADGE_POINTS` double DEFAULT NULL,
  `UNIVERSITY_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UNIVERSITY_SB_FK_idx` (`UNIVERSITY_ID`),
  CONSTRAINT `UNIVERSITY_SB_FK` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `UNIVERSITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SKILL_BADGES`
--

LOCK TABLES `SKILL_BADGES` WRITE;
/*!40000 ALTER TABLE `SKILL_BADGES` DISABLE KEYS */;
INSERT INTO `SKILL_BADGES` VALUES (1,'bronze',100,1),(2,'silver',200,1),(3,'gold',300,1),(4,'platinum',400,1);
/*!40000 ALTER TABLE `SKILL_BADGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SKILL_CATEGORIES`
--

DROP TABLE IF EXISTS `SKILL_CATEGORIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SKILL_CATEGORIES` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SKILL_CATEGORIES`
--

LOCK TABLES `SKILL_CATEGORIES` WRITE;
/*!40000 ALTER TABLE `SKILL_CATEGORIES` DISABLE KEYS */;
INSERT INTO `SKILL_CATEGORIES` VALUES (1,'Commmunication'),(2,'Collabration'),(3,'Critical Thinking'),(4,'Research And Data'),(5,'Professionalism');
/*!40000 ALTER TABLE `SKILL_CATEGORIES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SOCIAL_BADGES`
--

DROP TABLE IF EXISTS `SOCIAL_BADGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SOCIAL_BADGES` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `BADGE_NAME` varchar(50) DEFAULT NULL,
  `BADGE_DESCRIPTION` varchar(100) DEFAULT NULL,
  `NUMBER_OF_EVENTS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SOCIAL_BADGES`
--

LOCK TABLES `SOCIAL_BADGES` WRITE;
/*!40000 ALTER TABLE `SOCIAL_BADGES` DISABLE KEYS */;
INSERT INTO `SOCIAL_BADGES` VALUES (44,'DevJiva Soft','cdacAS',1),(47,'SADSA','CADCS',1),(49,'dvCzxdsfdsffv','dscds',3),(54,'TESTED','TESTED',2),(55,'NZGDB','VDSv',2);
/*!40000 ALTER TABLE `SOCIAL_BADGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SOCIAL_BADGES_DEPARTMENTS`
--

DROP TABLE IF EXISTS `SOCIAL_BADGES_DEPARTMENTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SOCIAL_BADGES_DEPARTMENTS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `SOCIAL_BADGE_ID` bigint(25) DEFAULT NULL,
  `DEPARTMENT_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `social_badge_id_idx` (`SOCIAL_BADGE_ID`),
  KEY `deparment_id_idx` (`DEPARTMENT_ID`),
  CONSTRAINT `social_badge_id` FOREIGN KEY (`SOCIAL_BADGE_ID`) REFERENCES `SOCIAL_BADGES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `deparment_id` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `DEPARTMENTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SOCIAL_BADGES_DEPARTMENTS`
--

LOCK TABLES `SOCIAL_BADGES_DEPARTMENTS` WRITE;
/*!40000 ALTER TABLE `SOCIAL_BADGES_DEPARTMENTS` DISABLE KEYS */;
INSERT INTO `SOCIAL_BADGES_DEPARTMENTS` VALUES (93,44,5),(96,47,5),(98,49,5),(105,49,7),(106,54,6),(107,55,5);
/*!40000 ALTER TABLE `SOCIAL_BADGES_DEPARTMENTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SPONSOR`
--

DROP TABLE IF EXISTS `SPONSOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SPONSOR` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `SPONSOR_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SPONSOR`
--

LOCK TABLES `SPONSOR` WRITE;
/*!40000 ALTER TABLE `SPONSOR` DISABLE KEYS */;
INSERT INTO `SPONSOR` VALUES (1,'xdcvhbj'),(2,'hiii'),(3,'Prashant'),(4,' bharam'),(5,'fghjk'),(6,'Prashant Bharam'),(7,'bharam'),(8,'Bharam prashant'),(9,'aaaa'),(10,'khhbihb'),(11,'kjbk'),(12,'VFVFV'),(13,'bharam'),(14,'tested tested tested tested'),(15,'heloo'),(16,'bharam'),(17,'tested'),(18,'fdFfcD'),(19,'prashant'),(20,'prashant'),(21,'qfe'),(22,'DWQD'),(23,'tested'),(24,'Tsted'),(25,'teated'),(26,'tested'),(27,'tested'),(28,'tested'),(29,'tested'),(30,'tested'),(31,'hello'),(32,'dfghj'),(33,'tested'),(34,'tested'),(35,'tested'),(36,'tested'),(37,'tested'),(38,'tested'),(39,'tested'),(40,'tetsed'),(41,'tested'),(42,'tested'),(43,'tested');
/*!40000 ALTER TABLE `SPONSOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TAGS`
--

DROP TABLE IF EXISTS `TAGS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TAGS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `TAG_NAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TAGS`
--

LOCK TABLES `TAGS` WRITE;
/*!40000 ALTER TABLE `TAGS` DISABLE KEYS */;
INSERT INTO `TAGS` VALUES (1,'Family Friendly'),(2,'Meal Provided'),(4,'Paid Registration'),(5,'Off-Campus'),(6,'Group Friendly');
/*!40000 ALTER TABLE `TAGS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `THEMEBADGE`
--

DROP TABLE IF EXISTS `THEMEBADGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `THEMEBADGE` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `THEME_BADGE_NAME` varchar(45) DEFAULT NULL,
  `THEME_BADGE_POINTS` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `THEMEBADGE`
--

LOCK TABLES `THEMEBADGE` WRITE;
/*!40000 ALTER TABLE `THEMEBADGE` DISABLE KEYS */;
/*!40000 ALTER TABLE `THEMEBADGE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TOP_LEVEL_BADGES`
--

DROP TABLE IF EXISTS `TOP_LEVEL_BADGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TOP_LEVEL_BADGES` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `TOP_BADGE_NAME` varchar(45) DEFAULT NULL,
  `TOP_BADGE_POINTS` double DEFAULT NULL,
  `UNIVERSITY_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UNIVERSITY_TLB_FK_idx` (`UNIVERSITY_ID`),
  CONSTRAINT `UNIVERSITY_TLB_FK` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `UNIVERSITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TOP_LEVEL_BADGES`
--

LOCK TABLES `TOP_LEVEL_BADGES` WRITE;
/*!40000 ALTER TABLE `TOP_LEVEL_BADGES` DISABLE KEYS */;
/*!40000 ALTER TABLE `TOP_LEVEL_BADGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UNIVERSITY`
--

DROP TABLE IF EXISTS `UNIVERSITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UNIVERSITY` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `UNIVERSITY_NAME` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UNIVERSITY`
--

LOCK TABLES `UNIVERSITY` WRITE;
/*!40000 ALTER TABLE `UNIVERSITY` DISABLE KEYS */;
INSERT INTO `UNIVERSITY` VALUES (1,'MyUniversity');
/*!40000 ALTER TABLE `UNIVERSITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `FULLNAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `IS_ACTIVE` tinyint(25) DEFAULT NULL,
  `PHONE_NUMBER` bigint(25) DEFAULT NULL,
  `DEVICE_ID` bigint(25) DEFAULT NULL,
  `DEVICE_TYPE` varchar(45) DEFAULT NULL,
  `DEVICE_OS_VERSION` bigint(25) DEFAULT NULL,
  `DEVICE_APP_TOKEN` varchar(45) DEFAULT NULL,
  `APP_VERSION` bigint(25) DEFAULT NULL,
  `USER_ROLE` bigint(25) DEFAULT NULL,
  `UNIVERSITY_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USER_ROLE_idx` (`USER_ROLE`),
  KEY `UNIVERSITY_UR_FK_idx` (`UNIVERSITY_ID`),
  CONSTRAINT `UNIVERSITY_UR_FK` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `UNIVERSITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `USER_ROLE` FOREIGN KEY (`USER_ROLE`) REFERENCES `ROLES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES (1,'devram',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,1,1),(2,'Ashvini','Ashu@123','ashu.nagaw@gmail.com',0,9673,56,'pc',8,'Abc',101,1,1),(3,'Ashu','Ashu@123','ashu.nagawade@gmail.com',1,9673,56,'pc',8,'Abc',101,1,1),(4,'Ravinder Reddy','test','ravinderreddy@devjiva.com',1,123456,NULL,'ANDROID',4,'1',1,1,1),(5,'k','hokeypoke','komal.tyagi@yahoo.com',1,123456,NULL,'ANDROID',4,'1',1,1,1),(6,'Leonel','mony3l','ladiaz@unm.edu',1,123456,NULL,'ANDROID',4,'1',1,1,1),(7,'Dakota Meza','Holly13^','dmeza@unm.edu',1,123456,NULL,'ANDROID',4,'1',1,1,1),(8,'rama','rama','rama@devjiva.com',1,123456,NULL,'ANDROID',4,'1',1,1,1),(9,'JACOB LOMAS SANCHEZ','mmabba4e','jlsanchez.lmsw@gmail.com',1,123456,NULL,'ANDROID',4,'1',1,1,1),(10,'devram','dev123','kandharedeva87@gmail.com',1,7798,21,'PC',8,'Abc',101,1,1),(11,'mounikareddy','123456','mounikareddy903@gmail.com',1,123456,NULL,'ANDROID',4,'1',1,2,1),(12,'ravi','test','ravinderjreddy@gmail.com',1,123456,NULL,'ANDROID',4,'1',1,2,1),(13,'Sugunakar','sandeep','sugu540@gmail.com',1,123456,NULL,'ANDROID',4,'1',1,2,NULL),(14,'Anna Cairo','Qw4y9n12','acairo8@unm.edu',1,123456,NULL,'ANDROID',4,'1',1,2,NULL),(15,'Prashant Bharam','bharam123','bharam.prashant94@gmail.com',1,123456,NULL,'ANDROID',4,'1',1,2,NULL),(16,'Rahul Sharma','bharam123','bharam.prashant@yahoo.com',1,123456,NULL,'ANDROID',4,'1',1,2,NULL),(17,'suhel','654321','skkhan089@gmail.com',1,123456,NULL,'ANDROID',4,'1',1,2,NULL),(18,'Pankaj','123456','pankajpaswan0123@gmail.com',1,123456,NULL,'ANDROID',4,'1',1,2,NULL),(19,'tkdg','djfy','mounikareddy@gmail.com',0,123456,NULL,'ANDROID',4,'1',1,2,NULL),(20,'suhel khan','123456','suhelkh44@gmail.com',1,123456,NULL,'ANDROID',4,'1',1,2,NULL),(21,'sukanya','sukanya','sukanya.kakkirala@gmail.com',1,123456,NULL,'ANDROID',4,'1',1,2,NULL);
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_INTERESTS`
--

DROP TABLE IF EXISTS `USER_INTERESTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_INTERESTS` (
  `ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(25) DEFAULT NULL,
  `INTEREST_ID` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EUSER_idx` (`USER_ID`),
  KEY `EINTEREST_idx` (`INTEREST_ID`),
  CONSTRAINT `EINTEREST` FOREIGN KEY (`INTEREST_ID`) REFERENCES `INTERESTS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `EUSER` FOREIGN KEY (`USER_ID`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=433 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_INTERESTS`
--

LOCK TABLES `USER_INTERESTS` WRITE;
/*!40000 ALTER TABLE `USER_INTERESTS` DISABLE KEYS */;
INSERT INTO `USER_INTERESTS` VALUES (1,4,1),(3,9,3),(4,2,4),(5,5,5),(6,8,6),(7,7,7),(9,10,9),(10,1,10),(63,6,10),(79,13,11),(80,13,1),(81,14,1),(82,14,10),(83,7,4),(84,7,3),(85,7,1),(86,7,6),(96,16,1),(97,16,2),(98,16,3),(99,16,4),(100,16,5),(101,16,6),(102,16,7),(103,16,8),(104,16,9),(105,16,10),(106,16,11),(107,16,12),(108,6,3),(109,6,6),(110,5,10),(128,21,4),(129,21,1),(140,21,6),(188,18,1),(219,3,2),(220,3,3),(221,3,4),(243,6,5),(244,6,2),(256,12,6),(257,18,4),(258,18,3),(259,18,2),(262,18,8),(263,18,9),(326,12,17),(327,12,11),(328,12,10),(329,12,1),(330,12,2),(333,18,10),(334,18,6),(335,18,7),(336,18,5),(337,18,11),(338,18,12),(339,18,13),(340,18,14),(341,12,16),(392,15,17),(393,15,1),(394,20,1),(395,15,2),(396,15,3),(397,15,4),(398,15,5),(399,15,6),(400,15,7),(401,15,8),(402,15,9),(403,15,10),(404,15,11),(405,15,12),(406,15,13),(407,15,14),(408,15,15),(409,15,16),(416,11,15),(417,11,14),(418,11,13),(419,11,16),(420,11,17),(421,11,12),(422,11,11),(423,11,10),(424,11,9),(425,5,6),(426,5,7),(427,5,4),(428,5,3),(429,5,9),(430,5,8),(431,14,12),(432,14,13);
/*!40000 ALTER TABLE `USER_INTERESTS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-07 16:10:50
