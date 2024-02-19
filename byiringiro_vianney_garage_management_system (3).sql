-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 02:19 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `byiringiro_vianney_garage_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `id_number` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `martial_status` varchar(20) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `id_number`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('rttyyy', 'hgfds', '123456', '9087654', 'Male', 'single', '2000-12-09', 'twsrytjy@gmail.com', '1987ghj'),
('byiringiro', 'vianney', '222017985', '0785922794', 'Male', 'single', '2004-12-09', 'byir@gmail.com', '12345'),
('mune', 'sam', '22222', '0788888', 'Male', 'single', '2007-07-06', 'mune@gmail.com', '12345'),
('simeon', 'simo', '222017985', '0785922789', 'Male', 'single', '2000-12-02', 'simeon@sgmail.com', '123456'),
('simeon', 'simo', '222017985', '0785922789', 'Male', 'single', '2000-12-02', 'simeon@sgmail.com', '123456'),
('simeon', 'simo', '222017985', '0785922789', 'Male', 'single', '2000-12-02', 'simeon@sgmail.com', '123456'),
('ishimwe', 'ange', '1234567', '0791234567', 'Female', 'single', '2001-01-18', 'ishimwe@gmail.com', '12');

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `Appointment_Id` int(11) NOT NULL,
  `Customer_Id` int(11) NOT NULL,
  `Vehicle_Id` int(11) NOT NULL,
  `Service_Id` int(11) NOT NULL,
  `Appointment_Date` date NOT NULL,
  `Status` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`Appointment_Id`, `Customer_Id`, `Vehicle_Id`, `Service_Id`, `Appointment_Date`, `Status`) VALUES
(4, 5, 1, 4, '2023-10-14', 'Cancelled'),
(5, 4, 4, 2, '2023-08-25', 'Scheduled'),
(8, 2, 3, 5, '2023-12-15', 'Completed'),
(9, 1, 5, 4, '2023-12-01', 'Scheduled'),
(13, 10, 7, 8, '2009-12-09', 'fghhh'),
(20, 4, 3, 2, '3009-09-09', 'DTRUY'),
(25, 10, 7, 8, '1897-08-03', 'received'),
(29, 2, 3, 5, '2002-08-02', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `Customer_Id` int(11) NOT NULL,
  `First_Name` varchar(100) NOT NULL,
  `Last_Name` varchar(120) NOT NULL,
  `Contact_Number` varchar(10) NOT NULL,
  `Address` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`Customer_Id`, `First_Name`, `Last_Name`, `Contact_Number`, `Address`) VALUES
(1, 'Simon', 'Dave', '0724567890', '123 Main St'),
(2, 'eghjkjnbv', 'fghjkj', '0987654', 'kger'),
(3, 'Kevin', 'Debryne', '0785111223', '789 Pine Rd'),
(4, 'Alison', 'Becker', '0787888999', '101 Cedar Ln'),
(5, 'Shadia', 'Mbabazi', '0787666677', '202 Elm Blvd'),
(6, 'tuyi', 'shime', '0799999', 'kgl23'),
(8, 'moure', 'keila', '078888', 'kgl'),
(10, 'vox', 'wagen', '07896543', 'rozario'),
(13, 'brigitte', 'uwa', '0788888', 'kr');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `Employee_Id` int(11) NOT NULL,
  `First_Name` varchar(100) NOT NULL,
  `Last_Name` varchar(120) NOT NULL,
  `Contact_Number` varchar(10) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Position` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`Employee_Id`, `First_Name`, `Last_Name`, `Contact_Number`, `Email`, `Position`) VALUES
(1, 'tuyi', 'sabie', '07890987', 'tuy@sabgmail.com', 'secretair'),
(2, 'Albert', 'Mugisha', '0795555222', 'albertmgsh@gmail.com', 'Accountant'),
(3, 'Albert', 'Peter', '0721555112', 'leandrepeter@gmail.com', 'Manager'),
(4, 'Uwera', 'Diane', '075785222', 'uweradiane@gmail.com', 'Secretary'),
(6, 'muneza', 'fred', '0788988888', 'muneza@gmail.com', 'manager'),
(7, 'nsabima', 'eric', '07888999', 'nsab@gmail.com', 'scretary'),
(8, 'muhay', 'simon', '0789895656', 'muh@gmail.com', 'secretary'),
(11, 'mune', 'sam', '0722222222', 'mune@gmail.com', 'humnRM'),
(13, 'kanani', 'kamir', '078654376', 'byi@gmail.com', 'manager'),
(15, 'niyo', 'xavie', '0732343233', 'niyo@gmail.com', 'auditor'),
(16, 'knc', 'kakuza', '07888888', 'knc@gmail.com', 'presid');

-- --------------------------------------------------------

--
-- Table structure for table `party_inventory`
--

CREATE TABLE `party_inventory` (
  `Item_Id` int(11) NOT NULL,
  `Item_Name` varchar(350) NOT NULL,
  `Description` varchar(700) NOT NULL,
  `Item_Type` varchar(100) NOT NULL,
  `Cost_Per_Type` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `party_inventory`
--

INSERT INTO `party_inventory` (`Item_Id`, `Item_Name`, `Description`, `Item_Type`, `Cost_Per_Type`) VALUES
(5, 'Oil', 'A viscous liquid derived from petroleum, especially for use as fuel or lubricant', 'Synthetic Oil', 15000),
(7, 'iufrh', ';djhfmd', 'bmw', 6000),
(8, 'rtijhg', 'hgfdgh', 'fghj', 1340),
(9, 'battery', 'batt234', 'for car', 50000),
(10, 'battery', 'batt234', 'for car', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `Service_Id` int(11) NOT NULL,
  `Service_Name` varchar(250) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `Cost` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`Service_Id`, `Service_Name`, `Description`, `Cost`) VALUES
(2, 'ffghj', 'hjkk', 3000),
(3, 'Customer Relationship Management', 'To helps build and maintain strong relationships with customers. ', 10000),
(4, 'Warranty Tracking', 'Keeps track of warranties for parts and services, helping the garage and customers stay informed about coverage and expiration dates', 12000),
(5, 'Repair vehicles', 'To repairing the broken vehicles and renew them', 15000),
(6, 'fghfghj', 'dfgty', 500),
(8, 'fjkl', 'ffghukjl', 20000),
(10, 'sells', 'battery', 50000),
(12, 'sells', 'battery', 50000),
(13, 'fghj', 'ghjnm', 17000);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `Transaction_Id` int(11) NOT NULL,
  `Customer_Id` int(11) NOT NULL,
  `Employee_Id` int(11) NOT NULL,
  `Service_Id` int(11) NOT NULL,
  `Transaction_Name` varchar(800) NOT NULL,
  `Transaction_Date` date NOT NULL,
  `Total_Amount` float NOT NULL,
  `Payment_Method` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`Transaction_Id`, `Customer_Id`, `Employee_Id`, `Service_Id`, `Transaction_Name`, `Transaction_Date`, `Total_Amount`, `Payment_Method`) VALUES
(10, 5, 1, 3, 'Selling wheels', '2023-01-01', 40000, 'Credit Card'),
(11, 5, 3, 4, 'Selling Engine', '2023-03-20', 500000, 'Cheque'),
(12, 1, 1, 4, 'Selling oil', '2023-04-10', 15000, 'Credit Card'),
(13, 4, 4, 2, 'Axle ordered', '2023-05-05', 30000, 'Cash'),
(14, 4, 4, 2, 'yfkglkhl', '1987-12-09', 7000, 'fyljk'),
(19, 10, 11, 8, 'pay', '2006-12-03', 1200, 'cash'),
(21, 10, 11, 8, 'repair', '2009-09-07', 12000, 'momo');

-- --------------------------------------------------------

--
-- Table structure for table `vehicles`
--

CREATE TABLE `vehicles` (
  `Vehicle_Id` int(11) NOT NULL,
  `Customer_Id` int(11) NOT NULL,
  `Make` varchar(300) NOT NULL,
  `Model` varchar(250) NOT NULL,
  `Licence_Plate` varchar(95) NOT NULL,
  `Vehicle_Identification_Number` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehicles`
--

INSERT INTO `vehicles` (`Vehicle_Id`, `Customer_Id`, `Make`, `Model`, `Licence_Plate`, `Vehicle_Identification_Number`) VALUES
(1, 5, 'Toyota', 'Camry', 'RAG123', 'VIN12345678901234'),
(2, 3, 'Barabas', 'Civic', 'RAD789', 'VIN56789012345678'),
(3, 2, 'Suzuki', 'Escape', 'RAC456', 'VIN90123456789012'),
(4, 4, 'Chevrolet', 'Malibu', 'RAB789', 'VIN34567890123456'),
(5, 5, 'BUGHAT', 'UGST', 'URG145', 'VIN3456789'),
(7, 10, 'HGFV', 'HGFVB', 'BGFCXD6', 'FRTT6777'),
(10, 10, 'yhundai', 'taxon', 'fgd', '12345'),
(12, 10, 'VBNM', 'HJKL', 'HJK', 'FGY7');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`Appointment_Id`),
  ADD KEY `Customer_Id` (`Customer_Id`),
  ADD KEY `Vehicle_Id` (`Vehicle_Id`),
  ADD KEY `Service_Id` (`Service_Id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`Customer_Id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`Employee_Id`);

--
-- Indexes for table `party_inventory`
--
ALTER TABLE `party_inventory`
  ADD PRIMARY KEY (`Item_Id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`Service_Id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`Transaction_Id`),
  ADD KEY `Customer_Id` (`Customer_Id`),
  ADD KEY `Employee_Id` (`Employee_Id`),
  ADD KEY `Service_Id` (`Service_Id`);

--
-- Indexes for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`Vehicle_Id`),
  ADD KEY `Customer_Id` (`Customer_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `Appointment_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `Customer_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `Employee_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `party_inventory`
--
ALTER TABLE `party_inventory`
  MODIFY `Item_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `Service_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `Transaction_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `vehicles`
--
ALTER TABLE `vehicles`
  MODIFY `Vehicle_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`Customer_Id`) REFERENCES `customers` (`Customer_Id`),
  ADD CONSTRAINT `appointments_ibfk_2` FOREIGN KEY (`Vehicle_Id`) REFERENCES `vehicles` (`Vehicle_Id`),
  ADD CONSTRAINT `appointments_ibfk_3` FOREIGN KEY (`Service_Id`) REFERENCES `services` (`Service_Id`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`Customer_Id`) REFERENCES `customers` (`Customer_Id`),
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`Employee_Id`) REFERENCES `employees` (`Employee_Id`),
  ADD CONSTRAINT `transactions_ibfk_3` FOREIGN KEY (`Service_Id`) REFERENCES `services` (`Service_Id`);

--
-- Constraints for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD CONSTRAINT `vehicles_ibfk_1` FOREIGN KEY (`Customer_Id`) REFERENCES `customers` (`Customer_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
