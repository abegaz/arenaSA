-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2017 at 03:17 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Table structure for table `adbalances`
--

CREATE TABLE `adbalances` (
  `balID` int(10) NOT NULL,
  `userID` int(20) NOT NULL,
  `balance` varchar(8) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `adbalances`
--

INSERT INTO `adbalances` (`balID`, `userID`, `balance`) VALUES
(1, 1, '0'),
(2, 0, '0'),
(4, 900000016, '159');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adbalances`
--
ALTER TABLE `adbalances`
  ADD PRIMARY KEY (`balID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adbalances`
--
ALTER TABLE `adbalances`
  MODIFY `balID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
