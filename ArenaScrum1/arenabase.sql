-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: arenadatabase
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.25-MariaDB

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
-- Table structure for table `advertisment`
--

DROP TABLE IF EXISTS `advertisment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertisment` (
  `AdvertismentID` int(11) NOT NULL,
  `AdvertismentName` varchar(45) DEFAULT NULL,
  `Users_userID` int(10) NOT NULL,
  PRIMARY KEY (`AdvertismentID`,`Users_userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisment`
--

LOCK TABLES `advertisment` WRITE;
/*!40000 ALTER TABLE `advertisment` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertisment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertismentscheme`
--

DROP TABLE IF EXISTS `advertismentscheme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertismentscheme` (
  `AdvertismentSchemeID` int(11) NOT NULL,
  `Advertisment_AdvertismentID` int(11) NOT NULL,
  `League_LeagueID` int(11) NOT NULL,
  `Tournament_TournamentID` int(11) NOT NULL,
  PRIMARY KEY (`AdvertismentSchemeID`,`Advertisment_AdvertismentID`,`League_LeagueID`,`Tournament_TournamentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertismentscheme`
--

LOCK TABLES `advertismentscheme` WRITE;
/*!40000 ALTER TABLE `advertismentscheme` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertismentscheme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arena`
--

DROP TABLE IF EXISTS `arena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arena` (
  `ArenaID` int(11) NOT NULL,
  `ArenaName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ArenaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arena`
--

LOCK TABLES `arena` WRITE;
/*!40000 ALTER TABLE `arena` DISABLE KEYS */;
/*!40000 ALTER TABLE `arena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arenamembers`
--

DROP TABLE IF EXISTS `arenamembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arenamembers` (
  `Arena_ArenaID` int(11) NOT NULL,
  `Users_userID` int(10) NOT NULL,
  PRIMARY KEY (`Arena_ArenaID`,`Users_userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arenamembers`
--

LOCK TABLES `arenamembers` WRITE;
/*!40000 ALTER TABLE `arenamembers` DISABLE KEYS */;
/*!40000 ALTER TABLE `arenamembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expertratingformula`
--

DROP TABLE IF EXISTS `expertratingformula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expertratingformula` (
  `ExpertRatingFormulaID` int(11) NOT NULL,
  `ExpertRatingFormulaFormula` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ExpertRatingFormulaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expertratingformula`
--

LOCK TABLES `expertratingformula` WRITE;
/*!40000 ALTER TABLE `expertratingformula` DISABLE KEYS */;
/*!40000 ALTER TABLE `expertratingformula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `GameID` int(11) NOT NULL,
  `GameName` varchar(45) DEFAULT NULL,
  `GameDescription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`GameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `league`
--

DROP TABLE IF EXISTS `league`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `league` (
  `LeagueID` int(11) NOT NULL,
  `LeagueName` varchar(45) DEFAULT NULL,
  `LeagueOwner_userID` int(10) NOT NULL,
  `Arena_ArenaID` int(11) NOT NULL,
  `ExpertRatingFormula_ExpertRatingFormulaID` int(11) NOT NULL,
  PRIMARY KEY (`LeagueID`,`LeagueOwner_userID`,`Arena_ArenaID`,`ExpertRatingFormula_ExpertRatingFormulaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `league`
--

LOCK TABLES `league` WRITE;
/*!40000 ALTER TABLE `league` DISABLE KEYS */;
/*!40000 ALTER TABLE `league` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaguemembers`
--

DROP TABLE IF EXISTS `leaguemembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leaguemembers` (
  `League_LeagueID` int(11) NOT NULL,
  `Users_userID` int(10) NOT NULL,
  `MembershipStatusCode_MembershipStatusCodeID` int(11) NOT NULL,
  PRIMARY KEY (`League_LeagueID`,`Users_userID`,`MembershipStatusCode_MembershipStatusCodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaguemembers`
--

LOCK TABLES `leaguemembers` WRITE;
/*!40000 ALTER TABLE `leaguemembers` DISABLE KEYS */;
/*!40000 ALTER TABLE `leaguemembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match`
--

DROP TABLE IF EXISTS `match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match` (
  `MatchID` int(11) NOT NULL,
  `OutcomeWin_UserID` varchar(45) DEFAULT NULL,
  `OutcomeLoss_UserID` varchar(45) DEFAULT NULL,
  `MatchStatus_MatchStatusID` int(11) NOT NULL,
  `Game_GameID` int(11) NOT NULL,
  `Tournament_TournamentID` int(11) NOT NULL,
  `Tournament_Arena_ArenaID` int(11) NOT NULL,
  `Tournament_League_LeagueID` int(11) NOT NULL,
  `Tournament_TournamentStyleCode_TournamentStyleCodeID` int(11) NOT NULL,
  PRIMARY KEY (`MatchID`,`MatchStatus_MatchStatusID`,`Game_GameID`,`Tournament_TournamentID`,`Tournament_Arena_ArenaID`,`Tournament_League_LeagueID`,`Tournament_TournamentStyleCode_TournamentStyleCodeID`),
  UNIQUE KEY `MatchID_UNIQUE` (`MatchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matchparticipants`
--

DROP TABLE IF EXISTS `matchparticipants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matchparticipants` (
  `MatchParticipantsID` int(11) NOT NULL,
  `Users_userID` int(10) NOT NULL,
  `Match_MatchID` int(11) NOT NULL,
  PRIMARY KEY (`MatchParticipantsID`,`Users_userID`,`Match_MatchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matchparticipants`
--

LOCK TABLES `matchparticipants` WRITE;
/*!40000 ALTER TABLE `matchparticipants` DISABLE KEYS */;
/*!40000 ALTER TABLE `matchparticipants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matchstatus`
--

DROP TABLE IF EXISTS `matchstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matchstatus` (
  `MatchStatusID` int(11) NOT NULL,
  `MatchStatusName` varchar(45) DEFAULT NULL,
  `MatchStatusDesc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MatchStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matchstatus`
--

LOCK TABLES `matchstatus` WRITE;
/*!40000 ALTER TABLE `matchstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `matchstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membershipstatuscode`
--

DROP TABLE IF EXISTS `membershipstatuscode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membershipstatuscode` (
  `MembershipStatusCodeID` int(11) NOT NULL,
  `MembershipStatusCodeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MembershipStatusCodeID`),
  UNIQUE KEY `MembershipStatusCodeID_UNIQUE` (`MembershipStatusCodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membershipstatuscode`
--

LOCK TABLES `membershipstatuscode` WRITE;
/*!40000 ALTER TABLE `membershipstatuscode` DISABLE KEYS */;
/*!40000 ALTER TABLE `membershipstatuscode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pending`
--

DROP TABLE IF EXISTS `pending`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pending` (
  `appID` int(11) NOT NULL AUTO_INCREMENT,
  `roleID_desired` int(11) NOT NULL,
  `appUserID` int(11) NOT NULL,
  `appUserName` varchar(45) NOT NULL,
  `appUserPassword` varchar(45) NOT NULL,
  `appCurrentRole` int(11) NOT NULL,
  PRIMARY KEY (`appID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pending`
--

LOCK TABLES `pending` WRITE;
/*!40000 ALTER TABLE `pending` DISABLE KEYS */;
/*!40000 ALTER TABLE `pending` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tournament`
--

DROP TABLE IF EXISTS `tournament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tournament` (
  `TournamentID` int(11) NOT NULL,
  `TournamentName` varchar(45) DEFAULT NULL,
  `TournamentDescription` varchar(45) DEFAULT NULL,
  `Arena_ArenaID` int(11) NOT NULL,
  `League_LeagueID` int(11) NOT NULL,
  `TournamentStyleCode_TournamentStyleCodeID` int(11) NOT NULL,
  PRIMARY KEY (`TournamentID`,`Arena_ArenaID`,`League_LeagueID`,`TournamentStyleCode_TournamentStyleCodeID`),
  UNIQUE KEY `TournamentID_UNIQUE` (`TournamentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournament`
--

LOCK TABLES `tournament` WRITE;
/*!40000 ALTER TABLE `tournament` DISABLE KEYS */;
/*!40000 ALTER TABLE `tournament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tournamentstylecode`
--

DROP TABLE IF EXISTS `tournamentstylecode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tournamentstylecode` (
  `TournamentStyleCodeID` int(11) NOT NULL,
  `TournamentStyleCodeName` varchar(45) DEFAULT NULL,
  `TournamentStyleCodeDesc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TournamentStyleCodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournamentstylecode`
--

LOCK TABLES `tournamentstylecode` WRITE;
/*!40000 ALTER TABLE `tournamentstylecode` DISABLE KEYS */;
/*!40000 ALTER TABLE `tournamentstylecode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroletype`
--

DROP TABLE IF EXISTS `userroletype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userroletype` (
  `userRoleTypeID` int(11) NOT NULL,
  `userRoleTypeName` varchar(45) NOT NULL,
  PRIMARY KEY (`userRoleTypeID`),
  UNIQUE KEY `userRoleTypeID_UNIQUE` (`userRoleTypeID`),
  UNIQUE KEY `userRoleTypeName_UNIQUE` (`userRoleTypeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroletype`
--

LOCK TABLES `userroletype` WRITE;
/*!40000 ALTER TABLE `userroletype` DISABLE KEYS */;
INSERT INTO `userroletype` VALUES (5,'Advertiserr'),(3,'League Owner'),(2,'Operator'),(4,'Player'),(1,'Spectator');
/*!40000 ALTER TABLE `userroletype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `userPassword` varchar(45) NOT NULL,
  `userRoleType_userRoleTypeID` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (20,'AdamOne','bob',2),(21,'AdamThree','bob',3),(22,'Bobo','bob',1),(23,'John','bob',1),(25,'Jene','bob',3),(26,'BamBam','bob',2),(27,'TomTom','bob',3),(29,'Dan','bob',3),(30,'AdamTwo','bob',1),(32,'BoboTwo','bob',1),(33,'TimTim','bob',1),(34,'Sammy','bob',2),(35,'Tina','bob',1),(36,'Jonny','bob',1),(37,'JonnyTwo','bob',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-28 19:27:41
