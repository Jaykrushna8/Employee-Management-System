-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2016 at 08:55 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employeemanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee_information`
--

CREATE TABLE `employee_information` (
  `Id` int(11) NOT NULL,
  `FirstName` varchar(30) DEFAULT NULL,
  `LastName` varchar(30) DEFAULT NULL,
  `ContactNumber` int(11) DEFAULT NULL,
  `Address` varchar(60) DEFAULT NULL,
  `Salary` double DEFAULT NULL,
  `Employee_Type` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_information`
--

INSERT INTO `employee_information` (`Id`, `FirstName`, `LastName`, `ContactNumber`, `Address`, `Salary`, `Employee_Type`) VALUES
(58, 'Sam', 'Shah', 874852963, 'California', 5000, 'Fulltime'),
(5, 'Sachin', 'Jagar', 789456213, 'India', 7800, 'Fulltime'),
(60, 'Abhay', 'Patel', 875876925, 'Newyork', 25, 'Intern'),
(6, 'Laura', 'Bretan', 216456123, 'Ohio', 40, 'Parttime'),
(7, 'Julia', 'Scotti', 515456213, 'NewJersey', 75, 'Intern');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee_information`
--
ALTER TABLE `employee_information`
  ADD PRIMARY KEY (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
