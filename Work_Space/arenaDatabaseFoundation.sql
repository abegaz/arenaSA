-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema arenadatabase
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `arenadatabase` ;

-- -----------------------------------------------------
-- Schema arenadatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `arenadatabase` DEFAULT CHARACTER SET utf8 ;
USE `arenadatabase` ;

-- -----------------------------------------------------
-- Table `arenadatabase`.`UserRoleType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`UserRoleType` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`UserRoleType` (
  `userRoleTypeID` INT NOT NULL,
  `userRoleTypeName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userRoleTypeID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `userRoleTypeID_UNIQUE` ON `arenadatabase`.`UserRoleType` (`userRoleTypeID` ASC);

CREATE UNIQUE INDEX `userRoleTypeName_UNIQUE` ON `arenadatabase`.`UserRoleType` (`userRoleTypeName` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`Users` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`Users` (
  `userID` INT(10) NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `userPassword` VARCHAR(45) NOT NULL,
  `UserRoleType_userRoleTypeID` INT NOT NULL,
  PRIMARY KEY (`userID`, `UserRoleType_userRoleTypeID`),
  CONSTRAINT `fk_Users_UserRoleType`
    FOREIGN KEY (`UserRoleType_userRoleTypeID`)
    REFERENCES `arenadatabase`.`UserRoleType` (`userRoleTypeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Users_UserRoleType_idx` ON `arenadatabase`.`Users` (`UserRoleType_userRoleTypeID` ASC);

CREATE UNIQUE INDEX `userID_UNIQUE` ON `arenadatabase`.`Users` (`userID` ASC);

CREATE UNIQUE INDEX `userName_UNIQUE` ON `arenadatabase`.`Users` (`userName` ASC);

CREATE UNIQUE INDEX `userPassword_UNIQUE` ON `arenadatabase`.`Users` (`userPassword` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`Arena`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`Arena` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`Arena` (
  `ArenaID` INT NOT NULL,
  `ArenaName` VARCHAR(45) NULL,
  PRIMARY KEY (`ArenaID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arenadatabase`.`ExpertRatingFormula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`ExpertRatingFormula` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`ExpertRatingFormula` (
  `ExpertRatingFormulaID` INT NOT NULL,
  `ExpertRatingFormulaFormula` VARCHAR(45) NULL,
  PRIMARY KEY (`ExpertRatingFormulaID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arenadatabase`.`League`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`League` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`League` (
  `LeagueID` INT NOT NULL,
  `LeagueName` VARCHAR(45) NULL,
  `LeagueOwner_userID` INT(10) NOT NULL,
  `Arena_ArenaID` INT NOT NULL,
  `ExpertRatingFormula_ExpertRatingFormulaID` INT NOT NULL,
  PRIMARY KEY (`LeagueID`, `LeagueOwner_userID`, `Arena_ArenaID`, `ExpertRatingFormula_ExpertRatingFormulaID`),
  CONSTRAINT `fk_League_Users1`
    FOREIGN KEY (`LeagueOwner_userID`)
    REFERENCES `arenadatabase`.`Users` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_League_Arena1`
    FOREIGN KEY (`Arena_ArenaID`)
    REFERENCES `arenadatabase`.`Arena` (`ArenaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_League_ExpertRatingFormula1`
    FOREIGN KEY (`ExpertRatingFormula_ExpertRatingFormulaID`)
    REFERENCES `arenadatabase`.`ExpertRatingFormula` (`ExpertRatingFormulaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_League_Users1_idx` ON `arenadatabase`.`League` (`LeagueOwner_userID` ASC);

CREATE INDEX `fk_League_Arena1_idx` ON `arenadatabase`.`League` (`Arena_ArenaID` ASC);

CREATE INDEX `fk_League_ExpertRatingFormula1_idx` ON `arenadatabase`.`League` (`ExpertRatingFormula_ExpertRatingFormulaID` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`ArenaMembers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`ArenaMembers` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`ArenaMembers` (
  `Arena_ArenaID` INT NOT NULL,
  `Users_userID` INT(10) NOT NULL,
  PRIMARY KEY (`Arena_ArenaID`, `Users_userID`),
  CONSTRAINT `fk_ArenaMembers_Arena1`
    FOREIGN KEY (`Arena_ArenaID`)
    REFERENCES `arenadatabase`.`Arena` (`ArenaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ArenaMembers_Users1`
    FOREIGN KEY (`Users_userID`)
    REFERENCES `arenadatabase`.`Users` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_ArenaMembers_Users1_idx` ON `arenadatabase`.`ArenaMembers` (`Users_userID` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`Advertisment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`Advertisment` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`Advertisment` (
  `AdvertismentID` INT NOT NULL,
  `AdvertismentName` VARCHAR(45) NULL,
  `Users_userID` INT(10) NOT NULL,
  PRIMARY KEY (`AdvertismentID`, `Users_userID`),
  CONSTRAINT `fk_Advertisment_Users1`
    FOREIGN KEY (`Users_userID`)
    REFERENCES `arenadatabase`.`Users` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Advertisment_Users1_idx` ON `arenadatabase`.`Advertisment` (`Users_userID` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`MembershipStatusCode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`MembershipStatusCode` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`MembershipStatusCode` (
  `MembershipStatusCodeID` INT NOT NULL,
  `MembershipStatusCodeName` VARCHAR(45) NULL,
  PRIMARY KEY (`MembershipStatusCodeID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `MembershipStatusCodeID_UNIQUE` ON `arenadatabase`.`MembershipStatusCode` (`MembershipStatusCodeID` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`LeagueMembers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`LeagueMembers` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`LeagueMembers` (
  `League_LeagueID` INT NOT NULL,
  `Users_userID` INT(10) NOT NULL,
  `MembershipStatusCode_MembershipStatusCodeID` INT NOT NULL,
  PRIMARY KEY (`League_LeagueID`, `Users_userID`, `MembershipStatusCode_MembershipStatusCodeID`),
  CONSTRAINT `fk_LeagueMembers_League1`
    FOREIGN KEY (`League_LeagueID`)
    REFERENCES `arenadatabase`.`League` (`LeagueID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LeagueMembers_Users1`
    FOREIGN KEY (`Users_userID`)
    REFERENCES `arenadatabase`.`Users` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LeagueMembers_MembershipStatusCode1`
    FOREIGN KEY (`MembershipStatusCode_MembershipStatusCodeID`)
    REFERENCES `arenadatabase`.`MembershipStatusCode` (`MembershipStatusCodeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_LeagueMembers_Users1_idx` ON `arenadatabase`.`LeagueMembers` (`Users_userID` ASC);

CREATE INDEX `fk_LeagueMembers_MembershipStatusCode1_idx` ON `arenadatabase`.`LeagueMembers` (`MembershipStatusCode_MembershipStatusCodeID` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`TournamentStyleCode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`TournamentStyleCode` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`TournamentStyleCode` (
  `TournamentStyleCodeID` INT NOT NULL,
  `TournamentStyleCodeName` VARCHAR(45) NULL,
  `TournamentStyleCodeDesc` VARCHAR(45) NULL,
  PRIMARY KEY (`TournamentStyleCodeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arenadatabase`.`Tournament`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`Tournament` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`Tournament` (
  `TournamentID` INT NOT NULL,
  `TournamentName` VARCHAR(45) NULL,
  `TournamentDescription` VARCHAR(45) NULL,
  `Arena_ArenaID` INT NOT NULL,
  `League_LeagueID` INT NOT NULL,
  `TournamentStyleCode_TournamentStyleCodeID` INT NOT NULL,
  PRIMARY KEY (`TournamentID`, `Arena_ArenaID`, `League_LeagueID`, `TournamentStyleCode_TournamentStyleCodeID`),
  CONSTRAINT `fk_Tournament_Arena1`
    FOREIGN KEY (`Arena_ArenaID`)
    REFERENCES `arenadatabase`.`Arena` (`ArenaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournament_League1`
    FOREIGN KEY (`League_LeagueID`)
    REFERENCES `arenadatabase`.`League` (`LeagueID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournament_TournamentStyleCode1`
    FOREIGN KEY (`TournamentStyleCode_TournamentStyleCodeID`)
    REFERENCES `arenadatabase`.`TournamentStyleCode` (`TournamentStyleCodeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Tournament_Arena1_idx` ON `arenadatabase`.`Tournament` (`Arena_ArenaID` ASC);

CREATE INDEX `fk_Tournament_League1_idx` ON `arenadatabase`.`Tournament` (`League_LeagueID` ASC);

CREATE UNIQUE INDEX `TournamentID_UNIQUE` ON `arenadatabase`.`Tournament` (`TournamentID` ASC);

CREATE INDEX `fk_Tournament_TournamentStyleCode1_idx` ON `arenadatabase`.`Tournament` (`TournamentStyleCode_TournamentStyleCodeID` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`AdvertismentScheme`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`AdvertismentScheme` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`AdvertismentScheme` (
  `AdvertismentSchemeID` INT NOT NULL,
  `Advertisment_AdvertismentID` INT NOT NULL,
  `League_LeagueID` INT NOT NULL,
  `Tournament_TournamentID` INT NOT NULL,
  PRIMARY KEY (`AdvertismentSchemeID`, `Advertisment_AdvertismentID`, `League_LeagueID`, `Tournament_TournamentID`),
  CONSTRAINT `fk_AdvertismentScheme_Advertisment1`
    FOREIGN KEY (`Advertisment_AdvertismentID`)
    REFERENCES `arenadatabase`.`Advertisment` (`AdvertismentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AdvertismentScheme_League1`
    FOREIGN KEY (`League_LeagueID`)
    REFERENCES `arenadatabase`.`League` (`LeagueID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AdvertismentScheme_Tournament1`
    FOREIGN KEY (`Tournament_TournamentID`)
    REFERENCES `arenadatabase`.`Tournament` (`TournamentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_AdvertismentScheme_Advertisment1_idx` ON `arenadatabase`.`AdvertismentScheme` (`Advertisment_AdvertismentID` ASC);

CREATE INDEX `fk_AdvertismentScheme_League1_idx` ON `arenadatabase`.`AdvertismentScheme` (`League_LeagueID` ASC);

CREATE INDEX `fk_AdvertismentScheme_Tournament1_idx` ON `arenadatabase`.`AdvertismentScheme` (`Tournament_TournamentID` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`MatchStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`MatchStatus` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`MatchStatus` (
  `MatchStatusID` INT NOT NULL,
  `MatchStatusName` VARCHAR(45) NULL,
  `MatchStatusDesc` VARCHAR(45) NULL,
  PRIMARY KEY (`MatchStatusID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arenadatabase`.`Game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`Game` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`Game` (
  `GameID` INT NOT NULL,
  `GameName` VARCHAR(45) NULL,
  `GameDescription` VARCHAR(45) NULL,
  PRIMARY KEY (`GameID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arenadatabase`.`Match`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`Match` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`Match` (
  `MatchID` INT NOT NULL,
  `OutcomeWin_UserID` VARCHAR(45) NULL,
  `OutcomeLoss_UserID` VARCHAR(45) NULL,
  `MatchStatus_MatchStatusID` INT NOT NULL,
  `Game_GameID` INT NOT NULL,
  `Tournament_TournamentID` INT NOT NULL,
  `Tournament_Arena_ArenaID` INT NOT NULL,
  `Tournament_League_LeagueID` INT NOT NULL,
  `Tournament_TournamentStyleCode_TournamentStyleCodeID` INT NOT NULL,
  PRIMARY KEY (`MatchID`, `MatchStatus_MatchStatusID`, `Game_GameID`, `Tournament_TournamentID`, `Tournament_Arena_ArenaID`, `Tournament_League_LeagueID`, `Tournament_TournamentStyleCode_TournamentStyleCodeID`),
  CONSTRAINT `fk_Match_MatchStatus1`
    FOREIGN KEY (`MatchStatus_MatchStatusID`)
    REFERENCES `arenadatabase`.`MatchStatus` (`MatchStatusID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Game1`
    FOREIGN KEY (`Game_GameID`)
    REFERENCES `arenadatabase`.`Game` (`GameID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_Tournament1`
    FOREIGN KEY (`Tournament_TournamentID` , `Tournament_Arena_ArenaID` , `Tournament_League_LeagueID` , `Tournament_TournamentStyleCode_TournamentStyleCodeID`)
    REFERENCES `arenadatabase`.`Tournament` (`TournamentID` , `Arena_ArenaID` , `League_LeagueID` , `TournamentStyleCode_TournamentStyleCodeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `MatchID_UNIQUE` ON `arenadatabase`.`Match` (`MatchID` ASC);

CREATE INDEX `fk_Match_MatchStatus1_idx` ON `arenadatabase`.`Match` (`MatchStatus_MatchStatusID` ASC);

CREATE INDEX `fk_Match_Game1_idx` ON `arenadatabase`.`Match` (`Game_GameID` ASC);

CREATE INDEX `fk_Match_Tournament1_idx` ON `arenadatabase`.`Match` (`Tournament_TournamentID` ASC, `Tournament_Arena_ArenaID` ASC, `Tournament_League_LeagueID` ASC, `Tournament_TournamentStyleCode_TournamentStyleCodeID` ASC);


-- -----------------------------------------------------
-- Table `arenadatabase`.`MatchParticipants`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arenadatabase`.`MatchParticipants` ;

CREATE TABLE IF NOT EXISTS `arenadatabase`.`MatchParticipants` (
  `MatchParticipantsID` INT NOT NULL,
  `Users_userID` INT(10) NOT NULL,
  `Match_MatchID` INT NOT NULL,
  PRIMARY KEY (`MatchParticipantsID`, `Users_userID`, `Match_MatchID`),
  CONSTRAINT `fk_MatchParticipants_Users1`
    FOREIGN KEY (`Users_userID`)
    REFERENCES `arenadatabase`.`Users` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatchParticipants_Match1`
    FOREIGN KEY (`Match_MatchID`)
    REFERENCES `arenadatabase`.`Match` (`MatchID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_MatchParticipants_Users1_idx` ON `arenadatabase`.`MatchParticipants` (`Users_userID` ASC);

CREATE INDEX `fk_MatchParticipants_Match1_idx` ON `arenadatabase`.`MatchParticipants` (`Match_MatchID` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
