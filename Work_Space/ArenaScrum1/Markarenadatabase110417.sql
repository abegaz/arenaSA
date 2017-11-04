-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 04, 2017 at 05:34 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `arenadatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `advertisment`
--

CREATE TABLE `advertisment` (
  `AdvertismentID` int(11) NOT NULL,
  `AdvertismentName` varchar(45) DEFAULT NULL,
  `users_userID` int(10) NOT NULL,
  `users_userRoleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `advertismentscheme`
--

CREATE TABLE `advertismentscheme` (
  `AdvertismentSchemeID` int(11) NOT NULL,
  `Advertisment_AdvertismentID` int(11) NOT NULL,
  `League_LeagueID` int(11) NOT NULL,
  `Tournament_TournamentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `arena`
--

CREATE TABLE `arena` (
  `ArenaID` int(11) NOT NULL,
  `ArenaName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `arena`
--

INSERT INTO `arena` (`ArenaID`, `ArenaName`) VALUES
(50001, 'Atlanta'),
(50003, 'New Orleans');

-- --------------------------------------------------------

--
-- Table structure for table `arenamembers`
--

CREATE TABLE `arenamembers` (
  `arena_ArenaID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `expertratingformula`
--

CREATE TABLE `expertratingformula` (
  `ExpertRatingFormulaID` int(11) NOT NULL,
  `ExpertRatingFormulaFormula` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `expertratingformula`
--

INSERT INTO `expertratingformula` (`ExpertRatingFormulaID`, `ExpertRatingFormulaFormula`) VALUES
(990001, 'Something Goes Here'),
(990002, 'Something Else Goes Here'),
(990003, 'Something ELSE goes Here');

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `GameID` int(11) NOT NULL,
  `GameName` varchar(45) DEFAULT NULL,
  `GameDescription` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`GameID`, `GameName`, `GameDescription`) VALUES
(11001, 'Pokemon', 'Trading Card Game'),
(11002, 'Magic', 'Trading Card Game'),
(11004, 'Soccer', 'American Football'),
(11014, 'Test', 'Test Desc'),
(11016, 'TestName1', 'TestDesc1');

-- --------------------------------------------------------

--
-- Table structure for table `league`
--

CREATE TABLE `league` (
  `LeagueID` int(11) NOT NULL,
  `LeagueName` varchar(45) DEFAULT NULL,
  `leagueDesc` varchar(45) DEFAULT NULL,
  `ExpertRatingFormula_ExpertRatingFormulaID` int(11) NOT NULL,
  `users_userID_LeagueOwner` int(10) NOT NULL,
  `arena_ArenaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `league`
--

INSERT INTO `league` (`LeagueID`, `LeagueName`, `leagueDesc`, `ExpertRatingFormula_ExpertRatingFormulaID`, `users_userID_LeagueOwner`, `arena_ArenaID`) VALUES
(800001, 'Example League Name', NULL, 990001, 900000001, 50001),
(800002, 'Example League Test Name', NULL, 990001, 900000005, 50001),
(800003, 'League Test Name Test1', NULL, 990001, 900000001, 50001),
(800004, 'asdfqweas', 'asdf aczeaf asdf', 990001, 900000005, 50001),
(800005, 'madkemc', 'asdf acze', 990001, 900000005, 50001),
(800006, 'Test2', 'Now not jibberish', 990001, 900000005, 50001),
(800007, 'Testing Edit', 'Is it Working?', 990001, 900000006, 50001);

-- --------------------------------------------------------

--
-- Table structure for table `leaguemembers`
--

CREATE TABLE `leaguemembers` (
  `League_LeagueID` int(11) NOT NULL,
  `MembershipStatusCode_MembershipStatusCodeID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `leaguemembers`
--

INSERT INTO `leaguemembers` (`League_LeagueID`, `MembershipStatusCode_MembershipStatusCodeID`, `users_userID`) VALUES
(800001, 1, 900000003),
(800002, 1, 900000006);

-- --------------------------------------------------------

--
-- Table structure for table `match`
--

CREATE TABLE `match` (
  `MatchID` int(11) NOT NULL,
  `OutcomeWin_UserID` varchar(45) DEFAULT NULL,
  `OutcomeLoss_UserID` varchar(45) DEFAULT NULL,
  `MatchStatus_MatchStatusID` int(11) NOT NULL,
  `Game_GameID` int(11) NOT NULL,
  `Tournament_TournamentID` int(11) NOT NULL,
  `matchDate` datetime DEFAULT NULL,
  `teams_TeamID2` int(11) NOT NULL,
  `teams_TeamID1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `matchstatus`
--

CREATE TABLE `matchstatus` (
  `MatchStatusID` int(11) NOT NULL,
  `MatchStatusName` varchar(45) DEFAULT NULL,
  `MatchStatusDesc` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `membershipstatuscode`
--

CREATE TABLE `membershipstatuscode` (
  `MembershipStatusCodeID` int(11) NOT NULL,
  `MembershipStatusCodeName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `membershipstatuscode`
--

INSERT INTO `membershipstatuscode` (`MembershipStatusCodeID`, `MembershipStatusCodeName`) VALUES
(1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pending`
--

CREATE TABLE `pending` (
  `appID` int(11) NOT NULL,
  `appUserID` int(10) NOT NULL,
  `appCurrentRole` int(11) NOT NULL,
  `desired_RoleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `scores`
--

CREATE TABLE `scores` (
  `ScoreID` int(11) NOT NULL,
  `match_MatchID` int(11) NOT NULL,
  `game_GameID` int(11) NOT NULL,
  `Team1_Score` varchar(45) DEFAULT NULL,
  `Team2_Score` varchar(45) DEFAULT NULL,
  `teams_TeamID2` int(11) NOT NULL,
  `teams_TeamID1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `TeamID` int(11) NOT NULL,
  `TeamName` varchar(45) DEFAULT NULL,
  `users_userID` int(10) NOT NULL,
  `league_LeagueID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tournament`
--

CREATE TABLE `tournament` (
  `TournamentID` int(11) NOT NULL,
  `TournamentName` varchar(45) DEFAULT NULL,
  `TournamentDescription` varchar(45) DEFAULT NULL,
  `League_LeagueID` int(11) NOT NULL,
  `TournamentStyleCode_TournamentStyleCodeID` int(11) NOT NULL,
  `tournamentDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tournament`
--

INSERT INTO `tournament` (`TournamentID`, `TournamentName`, `TournamentDescription`, `League_LeagueID`, `TournamentStyleCode_TournamentStyleCodeID`, `tournamentDate`) VALUES
(1000000, 'Test Tournament', 'Test Tournament Description', 800001, 40001, '2000-01-01'),
(1000001, 'Tourny Test Name', 'Football Tournament', 800003, 40001, '2017-12-12');

-- --------------------------------------------------------

--
-- Table structure for table `tournamentstylecode`
--

CREATE TABLE `tournamentstylecode` (
  `TournamentStyleCodeID` int(11) NOT NULL,
  `TournamentStyleCodeName` varchar(45) DEFAULT NULL,
  `TournamentStyleCodeDesc` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tournamentstylecode`
--

INSERT INTO `tournamentstylecode` (`TournamentStyleCodeID`, `TournamentStyleCodeName`, `TournamentStyleCodeDesc`) VALUES
(40001, 'Single Elimination', 'Single Elimination');

-- --------------------------------------------------------

--
-- Table structure for table `userroletype`
--

CREATE TABLE `userroletype` (
  `userRoleTypeID` int(11) NOT NULL,
  `userRoleTypeName` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userroletype`
--

INSERT INTO `userroletype` (`userRoleTypeID`, `userRoleTypeName`) VALUES
(0, 'Operator'),
(1, 'LeagueOwner'),
(2, 'Advertiser'),
(3, 'Player'),
(4, 'Spectator');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(10) NOT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `userPassword` varchar(45) DEFAULT NULL,
  `userRoleID` int(11) NOT NULL DEFAULT '4'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `userName`, `userPassword`, `userRoleID`) VALUES
(900000000, 'Admin', 'Password', 0),
(900000001, 'LeagueOwner', 'LeagueOwnerPassword ', 1),
(900000002, 'Advertiser', 'AvertiserPassword', 2),
(900000003, 'Player', 'PlayerPassword', 3),
(900000004, 'Rob', 'rob', 0),
(900000005, 'James', 'james', 1),
(900000006, 'Franky', 'frank', 3),
(900000007, 'bren', 'bren', 4),
(900000008, 'Mike', 'mikey', 2),
(900000009, 'phil', 'phily', 4),
(900000010, 'phily', 'phil', 4),
(900000012, 'sam', 'sammy', 4),
(900000013, 'roboo', 'robby', 1),
(900000014, 'philyd', 'philyd', 3),
(900000016, 'tay', 'tay', 2),
(900000017, 'bob', 'bob', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertisment`
--
ALTER TABLE `advertisment`
  ADD PRIMARY KEY (`AdvertismentID`,`users_userID`,`users_userRoleID`),
  ADD KEY `fk_advertisment_users1_idx` (`users_userID`,`users_userRoleID`);

--
-- Indexes for table `advertismentscheme`
--
ALTER TABLE `advertismentscheme`
  ADD PRIMARY KEY (`AdvertismentSchemeID`,`Advertisment_AdvertismentID`,`League_LeagueID`,`Tournament_TournamentID`),
  ADD KEY `fk_AdvertismentScheme_Advertisment1_idx` (`Advertisment_AdvertismentID`),
  ADD KEY `fk_AdvertismentScheme_League1_idx` (`League_LeagueID`),
  ADD KEY `fk_AdvertismentScheme_Tournament1_idx` (`Tournament_TournamentID`);

--
-- Indexes for table `arena`
--
ALTER TABLE `arena`
  ADD PRIMARY KEY (`ArenaID`);

--
-- Indexes for table `arenamembers`
--
ALTER TABLE `arenamembers`
  ADD PRIMARY KEY (`arena_ArenaID`,`users_userID`),
  ADD KEY `fk_arenamembers_arena1_idx` (`arena_ArenaID`),
  ADD KEY `fk_arenamembers_users1` (`users_userID`);

--
-- Indexes for table `expertratingformula`
--
ALTER TABLE `expertratingformula`
  ADD PRIMARY KEY (`ExpertRatingFormulaID`);

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`GameID`);

--
-- Indexes for table `league`
--
ALTER TABLE `league`
  ADD PRIMARY KEY (`LeagueID`,`ExpertRatingFormula_ExpertRatingFormulaID`,`users_userID_LeagueOwner`,`arena_ArenaID`),
  ADD KEY `fk_League_ExpertRatingFormula1_idx` (`ExpertRatingFormula_ExpertRatingFormulaID`),
  ADD KEY `fk_league_arena1_idx` (`arena_ArenaID`),
  ADD KEY `fk_league_users1_idx` (`users_userID_LeagueOwner`);

--
-- Indexes for table `leaguemembers`
--
ALTER TABLE `leaguemembers`
  ADD PRIMARY KEY (`League_LeagueID`,`MembershipStatusCode_MembershipStatusCodeID`,`users_userID`),
  ADD KEY `fk_LeagueMembers_MembershipStatusCode1_idx` (`MembershipStatusCode_MembershipStatusCodeID`),
  ADD KEY `fk_leaguemembers_users1_idx` (`users_userID`);

--
-- Indexes for table `match`
--
ALTER TABLE `match`
  ADD PRIMARY KEY (`MatchID`,`MatchStatus_MatchStatusID`,`Game_GameID`,`Tournament_TournamentID`,`teams_TeamID2`,`teams_TeamID1`),
  ADD UNIQUE KEY `MatchID_UNIQUE` (`MatchID`),
  ADD KEY `fk_Match_MatchStatus1_idx` (`MatchStatus_MatchStatusID`),
  ADD KEY `fk_Match_Game_idx` (`Game_GameID`),
  ADD KEY `fk_Match_Tournament1_idx` (`Tournament_TournamentID`),
  ADD KEY `fk_match_teams1_idx` (`teams_TeamID2`),
  ADD KEY `fk_match_teams2_idx` (`teams_TeamID1`);

--
-- Indexes for table `matchstatus`
--
ALTER TABLE `matchstatus`
  ADD PRIMARY KEY (`MatchStatusID`);

--
-- Indexes for table `membershipstatuscode`
--
ALTER TABLE `membershipstatuscode`
  ADD PRIMARY KEY (`MembershipStatusCodeID`),
  ADD UNIQUE KEY `MembershipStatusCodeID_UNIQUE` (`MembershipStatusCodeID`);

--
-- Indexes for table `pending`
--
ALTER TABLE `pending`
  ADD PRIMARY KEY (`appID`,`appUserID`,`appCurrentRole`,`desired_RoleID`),
  ADD KEY `fk_pending_users1_idx` (`appUserID`,`appCurrentRole`),
  ADD KEY `fk_pending_userroletype1_idx` (`desired_RoleID`);

--
-- Indexes for table `scores`
--
ALTER TABLE `scores`
  ADD PRIMARY KEY (`ScoreID`,`match_MatchID`,`game_GameID`,`teams_TeamID2`,`teams_TeamID1`),
  ADD UNIQUE KEY `ScoreID_UNIQUE` (`ScoreID`),
  ADD KEY `fk_MatchScores_game1_idx` (`game_GameID`),
  ADD KEY `fk_MatchScores_match1` (`match_MatchID`),
  ADD KEY `fk_scores_teams1_idx` (`teams_TeamID2`),
  ADD KEY `fk_scores_teams2_idx` (`teams_TeamID1`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`TeamID`,`users_userID`,`league_LeagueID`),
  ADD KEY `fk_teams_users1_idx` (`users_userID`),
  ADD KEY `fk_teams_league1_idx` (`league_LeagueID`);

--
-- Indexes for table `tournament`
--
ALTER TABLE `tournament`
  ADD PRIMARY KEY (`TournamentID`,`League_LeagueID`,`TournamentStyleCode_TournamentStyleCodeID`),
  ADD UNIQUE KEY `TournamentID_UNIQUE` (`TournamentID`),
  ADD KEY `fk_Tournament_League1_idx` (`League_LeagueID`),
  ADD KEY `fk_Tournament_TournamentStyleCode1_idx` (`TournamentStyleCode_TournamentStyleCodeID`);

--
-- Indexes for table `tournamentstylecode`
--
ALTER TABLE `tournamentstylecode`
  ADD PRIMARY KEY (`TournamentStyleCodeID`);

--
-- Indexes for table `userroletype`
--
ALTER TABLE `userroletype`
  ADD PRIMARY KEY (`userRoleTypeID`,`userRoleTypeName`),
  ADD UNIQUE KEY `userRoleTypeID_UNIQUE` (`userRoleTypeID`),
  ADD UNIQUE KEY `userRoleTypeName_UNIQUE` (`userRoleTypeName`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`,`userRoleID`),
  ADD UNIQUE KEY `userID_UNIQUE` (`userID`),
  ADD UNIQUE KEY `userName_UNIQUE` (`userName`),
  ADD KEY `RoleTypeID_idx` (`userRoleID`),
  ADD KEY `fk_users_userroletype1_idx` (`userRoleID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advertisment`
--
ALTER TABLE `advertisment`
  MODIFY `AdvertismentID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `arena`
--
ALTER TABLE `arena`
  MODIFY `ArenaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50004;

--
-- AUTO_INCREMENT for table `expertratingformula`
--
ALTER TABLE `expertratingformula`
  MODIFY `ExpertRatingFormulaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=990004;

--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `GameID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11017;

--
-- AUTO_INCREMENT for table `league`
--
ALTER TABLE `league`
  MODIFY `LeagueID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=800008;

--
-- AUTO_INCREMENT for table `pending`
--
ALTER TABLE `pending`
  MODIFY `appID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `scores`
--
ALTER TABLE `scores`
  MODIFY `ScoreID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tournament`
--
ALTER TABLE `tournament`
  MODIFY `TournamentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000002;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=900000018;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `advertisment`
--
ALTER TABLE `advertisment`
  ADD CONSTRAINT `fk_advertisment_users1` FOREIGN KEY (`users_userID`,`users_userRoleID`) REFERENCES `users` (`userID`, `userRoleID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `advertismentscheme`
--
ALTER TABLE `advertismentscheme`
  ADD CONSTRAINT `fk_AdvertismentScheme_Advertisment1` FOREIGN KEY (`Advertisment_AdvertismentID`) REFERENCES `advertisment` (`AdvertismentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_AdvertismentScheme_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_AdvertismentScheme_Tournament1` FOREIGN KEY (`Tournament_TournamentID`) REFERENCES `tournament` (`TournamentID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `arenamembers`
--
ALTER TABLE `arenamembers`
  ADD CONSTRAINT `fk_arenamembers_arena1` FOREIGN KEY (`arena_ArenaID`) REFERENCES `arena` (`ArenaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_arenamembers_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `league`
--
ALTER TABLE `league`
  ADD CONSTRAINT `fk_League_ExpertRatingFormula1` FOREIGN KEY (`ExpertRatingFormula_ExpertRatingFormulaID`) REFERENCES `expertratingformula` (`ExpertRatingFormulaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_league_arena1` FOREIGN KEY (`arena_ArenaID`) REFERENCES `arena` (`ArenaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_league_users1` FOREIGN KEY (`users_userID_LeagueOwner`) REFERENCES `users` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `leaguemembers`
--
ALTER TABLE `leaguemembers`
  ADD CONSTRAINT `fk_LeagueMembers_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_LeagueMembers_MembershipStatusCode1` FOREIGN KEY (`MembershipStatusCode_MembershipStatusCodeID`) REFERENCES `membershipstatuscode` (`MembershipStatusCodeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_leaguemembers_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `match`
--
ALTER TABLE `match`
  ADD CONSTRAINT `fk_Match_Game` FOREIGN KEY (`Game_GameID`) REFERENCES `game` (`GameID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Match_MatchStatus1` FOREIGN KEY (`MatchStatus_MatchStatusID`) REFERENCES `matchstatus` (`MatchStatusID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_match_teams1` FOREIGN KEY (`teams_TeamID2`) REFERENCES `teams` (`TeamID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_match_teams2` FOREIGN KEY (`teams_TeamID1`) REFERENCES `teams` (`TeamID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pending`
--
ALTER TABLE `pending`
  ADD CONSTRAINT `fk_pending_userroletype1` FOREIGN KEY (`desired_RoleID`) REFERENCES `userroletype` (`userRoleTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pending_users1` FOREIGN KEY (`appUserID`,`appCurrentRole`) REFERENCES `users` (`userID`, `userRoleID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `scores`
--
ALTER TABLE `scores`
  ADD CONSTRAINT `fk_MatchScores_game1` FOREIGN KEY (`game_GameID`) REFERENCES `game` (`GameID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_MatchScores_match1` FOREIGN KEY (`match_MatchID`) REFERENCES `match` (`MatchID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_scores_teams1` FOREIGN KEY (`teams_TeamID2`) REFERENCES `teams` (`TeamID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_scores_teams2` FOREIGN KEY (`teams_TeamID1`) REFERENCES `teams` (`TeamID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `teams`
--
ALTER TABLE `teams`
  ADD CONSTRAINT `fk_teams_league1` FOREIGN KEY (`league_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_teams_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tournament`
--
ALTER TABLE `tournament`
  ADD CONSTRAINT `fk_Tournament_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Tournament_TournamentStyleCode1` FOREIGN KEY (`TournamentStyleCode_TournamentStyleCodeID`) REFERENCES `tournamentstylecode` (`TournamentStyleCodeID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_userroletype1` FOREIGN KEY (`userRoleID`) REFERENCES `userroletype` (`userRoleTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
