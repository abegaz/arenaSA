-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2017 at 03:18 AM
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
-- Table structure for table `advertismentscheme`
--

CREATE TABLE `advertismentscheme` (
  `AdvertismentSchemeID` int(11) NOT NULL,
  `AdSchemeName` varchar(45) DEFAULT NULL,
  `AdPrice` varchar(100) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `advertismentscheme`
--

INSERT INTO `advertismentscheme` (`AdvertismentSchemeID`, `AdSchemeName`, `AdPrice`) VALUES
(1, 'Top Banner', '8'),
(2, 'Left Side Banner', '10'),
(3, 'Right Side Banner', '10'),
(4, 'Bottom Banner', '8'),
(5, 'Background Banner', '7');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertismentscheme`
--
ALTER TABLE `advertismentscheme`
  ADD PRIMARY KEY (`AdvertismentSchemeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advertismentscheme`
--
ALTER TABLE `advertismentscheme`
  MODIFY `AdvertismentSchemeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
