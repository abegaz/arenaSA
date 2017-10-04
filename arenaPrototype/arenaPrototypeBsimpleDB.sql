-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: arena
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.26-MariaDB

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
-- Table structure for table `new_users`
--

DROP TABLE IF EXISTS `new_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `new_users` (
  `newUserName` varchar(15) NOT NULL,
  `newUserPassword` varchar(15) NOT NULL,
  `newUserEmail` varchar(30) NOT NULL,
  `newUserFName` varchar(15) DEFAULT NULL,
  `newUserLName` varchar(15) DEFAULT NULL,
  `newUserRole` varchar(15) NOT NULL,
  `isConfirmed` char(4) NOT NULL DEFAULT 'no',
  `newUserIDNum` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`newUserIDNum`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_users`
--

LOCK TABLES `new_users` WRITE;
/*!40000 ALTER TABLE `new_users` DISABLE KEYS */;
INSERT INTO `new_users` VALUES ('Bobo','bob','Bobs@fakeEmail.org','Bob','Boberson','Operator','yes',1),('Tom','tom','Tomsf@ke.com','Tom','Slick','League Owner','no',2),('John','john','Johnsf@ke.com','John','Smith','Operator','yes',3),('Jim','jim','jimsf@keemail.com','Jim','Kirk','Operator','no',4),('Suzy','suzy','suzysf@keemail.com','Suzy','Q','Player','yes',5),('Josh','josh','joshsf@keemail.com','Josh','Jones','Spectator','yes',6),('Don','don','donsf@keEmail.com','Don','Atello','Advertiser','yes',7);
/*!40000 ALTER TABLE `new_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-01 13:07:05
