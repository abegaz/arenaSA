-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 23, 2017 at 11:27 PM
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
-- Database: `primary arena db`
--

-- --------------------------------------------------------

--
-- Table structure for table `advertisers`
--

CREATE TABLE `advertisers` (
  `AdvertiserID` int(11) NOT NULL,
  `AdvertiserName` varchar(30) NOT NULL,
  `AdvertisingSchemeID` int(11) NOT NULL,
  `Paidamount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `advertisingscheme`
--

CREATE TABLE `advertisingscheme` (
  `AdvertiseSchemeID` int(11) NOT NULL,
  `AdvertiseSchemeName` varchar(15) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `league`
--

CREATE TABLE `league` (
  `LeagueID` int(11) NOT NULL,
  `League Name` varchar(30) NOT NULL,
  `League Owner` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `players`
--

CREATE TABLE `players` (
  `Player ID` int(11) NOT NULL,
  `PlayerName` varchar(30) NOT NULL,
  `LeagueID` int(11) NOT NULL,
  `LeaguePoints` int(11) NOT NULL,
  `LeagueRank` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertisers`
--
ALTER TABLE `advertisers`
  ADD PRIMARY KEY (`AdvertiserID`);

--
-- Indexes for table `advertisingscheme`
--
ALTER TABLE `advertisingscheme`
  ADD PRIMARY KEY (`AdvertiseSchemeID`);

--
-- Indexes for table `league`
--
ALTER TABLE `league`
  ADD PRIMARY KEY (`LeagueID`),
  ADD UNIQUE KEY `League Name` (`League Name`);

--
-- Indexes for table `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`Player ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
