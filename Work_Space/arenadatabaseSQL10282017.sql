-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: arenadatabase
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
  `AdvertismentID` int(11) NOT NULL AUTO_INCREMENT,
  `AdvertismentName` varchar(45) DEFAULT NULL,
  `users_userID` int(10) NOT NULL,
  `users_userRoleID` int(11) NOT NULL,
  PRIMARY KEY (`AdvertismentID`,`users_userID`,`users_userRoleID`),
  KEY `fk_advertisment_users1_idx` (`users_userID`,`users_userRoleID`),
  CONSTRAINT `fk_advertisment_users1` FOREIGN KEY (`users_userID`, `users_userRoleID`) REFERENCES `users` (`userID`, `userRoleID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  PRIMARY KEY (`AdvertismentSchemeID`,`Advertisment_AdvertismentID`,`League_LeagueID`,`Tournament_TournamentID`),
  KEY `fk_AdvertismentScheme_Advertisment1_idx` (`Advertisment_AdvertismentID`),
  KEY `fk_AdvertismentScheme_League1_idx` (`League_LeagueID`),
  KEY `fk_AdvertismentScheme_Tournament1_idx` (`Tournament_TournamentID`),
  CONSTRAINT `fk_AdvertismentScheme_Advertisment1` FOREIGN KEY (`Advertisment_AdvertismentID`) REFERENCES `advertisment` (`AdvertismentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AdvertismentScheme_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AdvertismentScheme_Tournament1` FOREIGN KEY (`Tournament_TournamentID`) REFERENCES `tournament` (`TournamentID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `ArenaID` int(11) NOT NULL AUTO_INCREMENT,
  `ArenaName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ArenaID`)
) ENGINE=InnoDB AUTO_INCREMENT=50004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arena`
--

LOCK TABLES `arena` WRITE;
/*!40000 ALTER TABLE `arena` DISABLE KEYS */;
INSERT INTO `arena` VALUES (50001,'Atlanta'),(50003,'New Orleans');
/*!40000 ALTER TABLE `arena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arenamembers`
--

DROP TABLE IF EXISTS `arenamembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arenamembers` (
  `arena_ArenaID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL,
  PRIMARY KEY (`arena_ArenaID`,`users_userID`),
  KEY `fk_arenamembers_arena1_idx` (`arena_ArenaID`),
  KEY `fk_arenamembers_users1` (`users_userID`),
  CONSTRAINT `fk_arenamembers_arena1` FOREIGN KEY (`arena_ArenaID`) REFERENCES `arena` (`ArenaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_arenamembers_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `ExpertRatingFormulaID` int(11) NOT NULL AUTO_INCREMENT,
  `ExpertRatingFormulaFormula` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ExpertRatingFormulaID`)
) ENGINE=InnoDB AUTO_INCREMENT=990004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expertratingformula`
--

LOCK TABLES `expertratingformula` WRITE;
/*!40000 ALTER TABLE `expertratingformula` DISABLE KEYS */;
INSERT INTO `expertratingformula` VALUES (990001,'Something Goes Here'),(990002,'Something Else Goes Here'),(990003,'Something ELSE goes Here');
/*!40000 ALTER TABLE `expertratingformula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `GameID` int(11) NOT NULL AUTO_INCREMENT,
  `GameName` varchar(45) DEFAULT NULL,
  `GameDescription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`GameID`)
) ENGINE=InnoDB AUTO_INCREMENT=11017 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (11001,'Pokemon','Trading Card Game'),(11002,'Magic','Trading Card Game'),(11004,'Soccer','American Football'),(11014,'Test','Test Desc'),(11016,'TestName1','TestDesc1');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `league`
--

DROP TABLE IF EXISTS `league`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `league` (
  `LeagueID` int(11) NOT NULL AUTO_INCREMENT,
  `LeagueName` varchar(45) DEFAULT NULL,
  `ExpertRatingFormula_ExpertRatingFormulaID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL,
  `arena_ArenaID` int(11) NOT NULL,
  PRIMARY KEY (`LeagueID`,`ExpertRatingFormula_ExpertRatingFormulaID`,`users_userID`,`arena_ArenaID`),
  KEY `fk_League_ExpertRatingFormula1_idx` (`ExpertRatingFormula_ExpertRatingFormulaID`),
  KEY `fk_league_arena1_idx` (`arena_ArenaID`),
  KEY `fk_league_users1_idx` (`users_userID`),
  CONSTRAINT `fk_League_ExpertRatingFormula1` FOREIGN KEY (`ExpertRatingFormula_ExpertRatingFormulaID`) REFERENCES `expertratingformula` (`ExpertRatingFormulaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_league_arena1` FOREIGN KEY (`arena_ArenaID`) REFERENCES `arena` (`ArenaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_league_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=800004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `league`
--

LOCK TABLES `league` WRITE;
/*!40000 ALTER TABLE `league` DISABLE KEYS */;
INSERT INTO `league` VALUES (800001,'Example League Name',990001,900000001,50001),(800002,'Example League Test Name',990001,900000005,50001),(800003,'League Test Name Test1',990001,900000001,50001);
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
  `MembershipStatusCode_MembershipStatusCodeID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL,
  `users_userRoleID` int(11) NOT NULL,
  PRIMARY KEY (`League_LeagueID`,`MembershipStatusCode_MembershipStatusCodeID`,`users_userID`,`users_userRoleID`),
  KEY `fk_LeagueMembers_MembershipStatusCode1_idx` (`MembershipStatusCode_MembershipStatusCodeID`),
  KEY `fk_leaguemembers_users1_idx` (`users_userID`,`users_userRoleID`),
  CONSTRAINT `fk_LeagueMembers_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_LeagueMembers_MembershipStatusCode1` FOREIGN KEY (`MembershipStatusCode_MembershipStatusCodeID`) REFERENCES `membershipstatuscode` (`MembershipStatusCodeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_leaguemembers_users1` FOREIGN KEY (`users_userID`, `users_userRoleID`) REFERENCES `users` (`userID`, `userRoleID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `matchDate` datetime DEFAULT NULL,
  PRIMARY KEY (`MatchID`,`MatchStatus_MatchStatusID`,`Game_GameID`,`Tournament_TournamentID`,`Tournament_Arena_ArenaID`,`Tournament_League_LeagueID`,`Tournament_TournamentStyleCode_TournamentStyleCodeID`),
  UNIQUE KEY `MatchID_UNIQUE` (`MatchID`),
  KEY `fk_Match_MatchStatus1_idx` (`MatchStatus_MatchStatusID`),
  KEY `fk_Match_Tournament1_idx` (`Tournament_TournamentID`,`Tournament_Arena_ArenaID`,`Tournament_League_LeagueID`,`Tournament_TournamentStyleCode_TournamentStyleCodeID`),
  KEY `fk_Match_Game_idx` (`Game_GameID`),
  CONSTRAINT `fk_Match_Game` FOREIGN KEY (`Game_GameID`) REFERENCES `game` (`GameID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_MatchStatus1` FOREIGN KEY (`MatchStatus_MatchStatusID`) REFERENCES `matchstatus` (`MatchStatusID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `Match_MatchID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL,
  `users_userRoleID` int(11) NOT NULL,
  `match Score` int(11) DEFAULT NULL,
  PRIMARY KEY (`MatchParticipantsID`,`Match_MatchID`,`users_userID`,`users_userRoleID`),
  KEY `fk_MatchParticipants_Match1_idx` (`Match_MatchID`),
  KEY `fk_matchparticipants_users1_idx` (`users_userID`,`users_userRoleID`),
  CONSTRAINT `fk_MatchParticipants_Match1` FOREIGN KEY (`Match_MatchID`) REFERENCES `match` (`MatchID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matchparticipants_users1` FOREIGN KEY (`users_userID`, `users_userRoleID`) REFERENCES `users` (`userID`, `userRoleID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `matchscores`
--

DROP TABLE IF EXISTS `matchscores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matchscores` (
  `match_MatchScores_date` datetime NOT NULL,
  `match_MatchID` int(11) NOT NULL,
  `game_GameID` int(11) NOT NULL,
  `User1_userID` int(10) NOT NULL,
  `User2_userID` int(10) NOT NULL,
  `User1_Score` varchar(45) DEFAULT NULL,
  `User2_Score` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`match_MatchScores_date`,`match_MatchID`,`game_GameID`,`User1_userID`,`User2_userID`),
  KEY `fk_MatchScores_game1_idx` (`game_GameID`),
  KEY `fk_MatchScores_users1_idx` (`User1_userID`),
  KEY `fk_MatchScores_users1_idx1` (`User2_userID`),
  KEY `fk_MatchScores_match1` (`match_MatchID`),
  CONSTRAINT `fk_MatchScores_game1` FOREIGN KEY (`game_GameID`) REFERENCES `game` (`GameID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatchScores_match1` FOREIGN KEY (`match_MatchID`) REFERENCES `match` (`MatchID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatchScores_users1` FOREIGN KEY (`User1_userID`) REFERENCES `users` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatchScores_users2` FOREIGN KEY (`User2_userID`) REFERENCES `users` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matchscores`
--

LOCK TABLES `matchscores` WRITE;
/*!40000 ALTER TABLE `matchscores` DISABLE KEYS */;
/*!40000 ALTER TABLE `matchscores` ENABLE KEYS */;
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
  `tournamentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`TournamentID`,`Arena_ArenaID`,`League_LeagueID`,`TournamentStyleCode_TournamentStyleCodeID`),
  UNIQUE KEY `TournamentID_UNIQUE` (`TournamentID`),
  KEY `fk_Tournament_League1_idx` (`League_LeagueID`),
  KEY `fk_Tournament_TournamentStyleCode1_idx` (`TournamentStyleCode_TournamentStyleCodeID`),
  KEY `fk_tournament_arena1_idx` (`Arena_ArenaID`),
  CONSTRAINT `fk_Tournament_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournament_TournamentStyleCode1` FOREIGN KEY (`TournamentStyleCode_TournamentStyleCodeID`) REFERENCES `tournamentstylecode` (`TournamentStyleCodeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tournament_arena1` FOREIGN KEY (`arena_ArenaID`) REFERENCES `arena` (`ArenaID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  PRIMARY KEY (`userRoleTypeID`,`userRoleTypeName`),
  UNIQUE KEY `userRoleTypeID_UNIQUE` (`userRoleTypeID`),
  UNIQUE KEY `userRoleTypeName_UNIQUE` (`userRoleTypeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroletype`
--

LOCK TABLES `userroletype` WRITE;
/*!40000 ALTER TABLE `userroletype` DISABLE KEYS */;
INSERT INTO `userroletype` VALUES (0,'Operator'),(1,'LeagueOwner'),(2,'Advertiser'),(3,'Player'),(4,'Spectator');
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
  `userName` varchar(45) DEFAULT NULL,
  `userPassword` varchar(45) DEFAULT NULL,
  `userRoleID` int(11) NOT NULL DEFAULT '4',
  PRIMARY KEY (`userID`,`userRoleID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  UNIQUE KEY `userPassword_UNIQUE` (`userPassword`),
  KEY `RoleTypeID_idx` (`userRoleID`),
  KEY `fk_users_userroletype1_idx` (`userRoleID`),
  CONSTRAINT `fk_users_userroletype1` FOREIGN KEY (`userRoleID`) REFERENCES `userroletype` (`userRoleTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=900000011 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (900000000,'Admin','Password',0),(900000001,'LeagueOwner','LeagueOwnerPassword ',1),(900000002,'Advertiser','AvertiserPassword',2),(900000003,'Player','PlayerPassword',3),(900000004,'Rob','rob',0),(900000005,'James','james',1),(900000006,'Franky','frank',3),(900000007,'bren','bren',4),(900000008,'Mike','mikey',2),(900000009,'phil','phily',4),(900000010,'phily','phil',4);
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

-- Dump completed on 2017-10-28 20:25:16
