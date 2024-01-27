-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2024 at 07:32 PM
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
-- Database: `easydrive`
--
CREATE DATABASE IF NOT EXISTS `easydrive` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `easydrive`;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `clientNo` int(5) NOT NULL,
  `cPostcode` int(5) NOT NULL,
  `cTelNo` varchar(12) NOT NULL,
  `dLicenseNo` int(9) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `dob` date NOT NULL,
  `officeNo` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `drivingtest`
--

CREATE TABLE `drivingtest` (
  `testNo` int(5) NOT NULL,
  `testDate` date NOT NULL,
  `testTime` time NOT NULL,
  `testCentre` varchar(20) NOT NULL,
  `testerName` varchar(20) NOT NULL,
  `attempt` int(2) NOT NULL,
  `result` int(3) NOT NULL,
  `pTestComment` int(3) NOT NULL,
  `tTestMark` int(3) NOT NULL,
  `tTestComments` varchar(100) NOT NULL,
  `clientNo` int(5) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Table structure for table `interview`
--

CREATE TABLE `interview` (
  `staffNo` int(5) NOT NULL,
  `iDate` date NOT NULL,
  `iTime` time NOT NULL,
  `iRoom` varchar(20) NOT NULL,
  `iComments` varchar(100) NOT NULL,
  `clientNo` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lesson`
--

CREATE TABLE `lesson` (
  `lessonNo` int(5) NOT NULL,
  `lessonDate` date NOT NULL,
  `lessonTime` time NOT NULL,
  `stage` varchar(10) NOT NULL,
  `progress` int(3) NOT NULL,
  `comments` varchar(100) NOT NULL,
  `mileageStart` double(7,2) NOT NULL,
  `mileageFinish` double(7,2) NOT NULL,
  `staffNo` int(5) NOT NULL,
  `clientNo` int(5) NOT NULL,
  `vehRegNo` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`clientNo`),
  ADD UNIQUE KEY `cTelNo` (`cTelNo`),
  ADD UNIQUE KEY `dLicenseNo` (`dLicenseNo`);

--
-- Indexes for table `drivingtest`
--
ALTER TABLE `drivingtest`
  ADD PRIMARY KEY (`testNo`),
  ADD UNIQUE KEY `testNo` (`testNo`),
  ADD KEY `clientNo` (`clientNo`);

--
-- Indexes for table `interview`
--
ALTER TABLE `interview`
  ADD PRIMARY KEY (`staffNo`,`iDate`),
  ADD UNIQUE KEY `staffNo` (`staffNo`),
  ADD UNIQUE KEY `clientNo` (`clientNo`);

--
-- Indexes for table `lesson`
--
ALTER TABLE `lesson`
  ADD PRIMARY KEY (`lessonNo`),
  ADD UNIQUE KEY `lessonNo` (`lessonNo`),
  ADD KEY `clientNo` (`clientNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `clientNo` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `drivingtest`
--
ALTER TABLE `drivingtest`
  MODIFY `testNo` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `interview`
--
ALTER TABLE `interview`
  MODIFY `staffNo` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lesson`
--
ALTER TABLE `lesson`
  MODIFY `lessonNo` int(5) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `drivingtest`
--
ALTER TABLE `drivingtest`
  ADD CONSTRAINT `drivingtest_ibfk_1` FOREIGN KEY (`clientNo`) REFERENCES `client` (`clientNo`);

--
-- Constraints for table `interview`
--
ALTER TABLE `interview`
  ADD CONSTRAINT `interview_ibfk_1` FOREIGN KEY (`clientNo`) REFERENCES `client` (`clientNo`);

--
-- Constraints for table `lesson`
--
ALTER TABLE `lesson`
  ADD CONSTRAINT `lesson_ibfk_1` FOREIGN KEY (`clientNo`) REFERENCES `client` (`clientNo`);
--
-- Database: `homestaybookingsystem`
--
CREATE DATABASE IF NOT EXISTS `homestaybookingsystem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `homestaybookingsystem`;

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `Booking_ID` int(5) NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  `Total_Price` double(6,2) NOT NULL,
  `Key_Status` varchar(13) NOT NULL DEFAULT 'Not Collected',
  `Customer_ID` int(5) DEFAULT NULL,
  `House_ID` int(5) DEFAULT NULL,
  `Status` varchar(10) NOT NULL DEFAULT 'Pending',
  `Owner_Rating` int(1) DEFAULT NULL,
  `Customer_Rating` int(1) DEFAULT NULL,
  `Booking_Date` date DEFAULT current_timestamp()
) ;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`Booking_ID`, `Start_Date`, `End_Date`, `Total_Price`, `Key_Status`, `Customer_ID`, `House_ID`, `Status`, `Owner_Rating`, `Customer_Rating`, `Booking_Date`) VALUES
(1, '2023-08-06', '2023-08-12', 900.00, 'Returned', 1, 2, 'Completed', 5, 3, '2023-07-21'),
(2, '2023-11-22', '2023-11-30', 680.00, 'Returned', 1, 8, 'Completed', 5, 5, '2023-11-01'),
(4, '2023-03-09', '2023-03-11', 260.00, 'Returned', 2, 8, 'Completed', 3, 5, '2023-03-01'),
(6, '2023-11-09', '2023-11-13', 360.00, 'Returned', 1, 7, 'Completed', 5, 5, '2023-11-01'),
(7, '2023-04-13', '2023-04-20', 910.00, 'Returned', 2, 8, 'Completed', 4, 5, '2023-04-11'),
(8, '2023-12-01', '2023-12-05', 600.00, 'Returned', 2, 2, 'Completed', 5, 4, '2023-11-20'),
(9, '2023-12-15', '2023-12-20', 750.00, 'Returned', 1, 2, 'Completed', 4, 5, '2023-12-05'),
(10, '2023-12-01', '2023-12-07', 540.00, 'Returned', 3, 7, 'Completed', 4, 3, '2023-11-25'),
(11, '2023-05-10', '2023-05-15', 425.00, 'Returned', 3, 8, 'Completed', 5, 5, '2023-05-01'),
(12, '2023-01-11', '2023-01-14', 450.00, 'Returned', 1, 2, 'Completed', 5, 4, '2023-01-03'),
(15, '2023-01-06', '2023-01-08', 300.00, 'Returned', 1, 2, 'Completed', 3, 4, '2023-01-01'),
(18, '2023-02-06', '2023-02-11', 160.00, 'Returned', 1, 2, 'Completed', 5, 5, '2023-02-01'),
(19, '2023-07-11', '2023-07-14', 210.00, 'Returned', 11, 7, 'Completed', 3, 5, '2023-07-05'),
(20, '2023-10-23', '2023-10-25', 130.00, 'Returned', 14, 7, 'Completed', 5, 4, '2023-10-19'),
(21, '2024-01-10', '2024-01-15', 260.00, 'Returned', 1, 2, 'Completed', 5, 5, '2024-01-04'),
(22, '2024-02-22', '2024-02-26', 300.00, 'Not Collected', 11, 2, 'Accepted', NULL, NULL, '2024-02-17'),
(23, '2024-02-06', '2024-02-10', 600.00, 'Returned', 15, 2, 'Completed', NULL, NULL, '2024-01-18');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_ID` int(5) NOT NULL,
  `Customer_Name` varchar(20) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Date_Of_Birth` date NOT NULL,
  `Address` varchar(50) NOT NULL,
  `POSTCODE` int(5) NOT NULL,
  `State` varchar(10) NOT NULL,
  `Telephone_No` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_ID`, `Customer_Name`, `Password`, `Date_Of_Birth`, `Address`, `POSTCODE`, `State`, `Telephone_No`) VALUES
(1, 'alex', 'abc123', '2001-09-11', '4A, JALAN HUA, 2C', 96000, 'Sarawak', '+60190879981'),
(2, 'bryan', 'abc456', '1996-03-10', '1F, Jalan Petani, 2A', 25012, 'Pahang', '+60124569902'),
(3, 'coco', 'pqr012', '1988-01-08', '9E, Jalan Jaminan, 3C', 80031, 'Johor', '+60193459957'),
(11, 'emily', 'abc789', '1998-05-07', '1A, Jalan Teku, 2C', 75500, 'Melaka', '+60128912456'),
(14, 'gamxia', 'abc456', '2001-01-10', '6F, Jalan String, 1E', 75500, 'Melaka', '+60126657766'),
(15, 'clement', 'abc123', '2001-05-19', '3B, Jalan Gembira, 2E', 75500, 'Melaka', '+60129918732');

-- --------------------------------------------------------

--
-- Table structure for table `homestayowner`
--

CREATE TABLE `homestayowner` (
  `Owner_ID` int(5) NOT NULL,
  `Owner_Name` varchar(20) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Date_Of_Birth` date NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Postcode` int(5) NOT NULL,
  `State` varchar(20) NOT NULL,
  `Telephone_No` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `homestayowner`
--

INSERT INTO `homestayowner` (`Owner_ID`, `Owner_Name`, `Password`, `Date_Of_Birth`, `Address`, `Postcode`, `State`, `Telephone_No`) VALUES
(1, 'lingkimhong', '567you', '1988-12-09', '5A, Jalan Masa, 3F', 75500, 'Kuala Lumpur', '+60123456789'),
(2, 'daniel', 'def456', '1988-11-11', '5A, Jalan Pendek, 8C', 30071, 'Perak', '+60168125678');

-- --------------------------------------------------------

--
-- Table structure for table `house`
--

CREATE TABLE `house` (
  `House_ID` int(5) NOT NULL,
  `House_Name` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Postcode` int(5) NOT NULL,
  `State` varchar(15) NOT NULL,
  `Amenities` varchar(100) DEFAULT NULL,
  `Price_Per_Day` double(6,2) DEFAULT NULL,
  `Status` varchar(11) DEFAULT 'Available',
  `Owner_ID` int(5) DEFAULT NULL
) ;

--
-- Dumping data for table `house`
--

INSERT INTO `house` (`House_ID`, `House_Name`, `Address`, `Postcode`, `State`, `Amenities`, `Price_Per_Day`, `Status`, `Owner_ID`) VALUES
(2, 'House1', '1A, Jalan Panjang, 5E', 75500, 'Malacca', 'Free Wifi, 2 Single Room, 1 Double Room', 150.00, 'Available', 1),
(5, 'HouseA', '5B, Jalan Harimau, 1C', 30071, 'Perak', '3 Single Room, 1 Double Room', 130.00, 'Available', 2),
(6, 'HouseB', '4B, Jalan Kuching, 2A', 15013, 'Kelantan', 'Free Wifi, 2 Double Room', 85.00, 'Available', 2),
(7, 'House3', '3C, Jalan Air, 1D', 70027, 'Negeri Sembilan', '4 Single Room, Free WIFI', 90.00, 'Available', 1),
(8, 'House4', '6A, Jalan Lembu, 2F', 96000, 'Sarawak', '1 Double Room, 2 Single Room', 400.00, 'Available', 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Payment_ID` int(5) NOT NULL,
  `Deposit` double(6,2) DEFAULT 0.00,
  `Remainder` double(6,2) DEFAULT 0.00,
  `Damage` double(6,2) DEFAULT 0.00,
  `Total` double(6,2) DEFAULT 0.00,
  `Status` varchar(10) DEFAULT 'Incomplete',
  `Booking_ID` int(5) DEFAULT NULL,
  `payment_date` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Payment_ID`, `Deposit`, `Remainder`, `Damage`, `Total`, `Status`, `Booking_ID`, `payment_date`) VALUES
(13, 450.00, 450.00, 0.00, 900.00, 'Completed', 1, '2023-08-12'),
(14, 340.00, 340.00, 70.00, 750.00, 'Completed', 2, '2023-11-30'),
(15, 180.00, 180.00, 0.00, 360.00, 'Completed', 6, '2023-11-13'),
(16, 375.00, 375.00, 0.00, 750.00, 'Completed', 9, '2023-12-20'),
(17, 225.00, 225.00, 105.60, 555.60, 'Completed', 12, '2023-01-14'),
(18, 150.00, 150.00, 50.50, 350.50, 'Completed', 15, '2023-01-08'),
(19, 80.00, 80.00, 0.00, 160.00, 'Completed', 18, '2023-02-11'),
(20, 130.00, 130.00, 92.30, 352.30, 'Completed', 21, '2024-01-15'),
(21, 130.00, 130.00, 0.00, 260.00, 'Completed', 4, '2023-03-11'),
(22, 455.00, 455.00, 0.00, 910.00, 'Completed', 7, '2023-04-20'),
(23, 300.00, 300.00, 0.00, 600.00, 'Completed', 8, '2023-12-05'),
(24, 270.00, 270.00, 0.00, 540.00, 'Completed', 10, '2023-12-07'),
(25, 212.50, 212.50, 0.00, 425.00, 'Completed', 11, '2023-05-15'),
(26, 105.00, 105.00, 0.00, 210.00, 'Completed', 19, '2023-07-14'),
(27, 65.00, 65.00, 0.00, 130.00, 'Completed', 20, '2023-10-25'),
(28, 300.00, 300.00, 100.00, 700.00, 'Completed', 23, '2024-01-18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`Booking_ID`),
  ADD KEY `booking_ibfk_4` (`House_ID`),
  ADD KEY `Customer_ID` (`Customer_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_ID`),
  ADD UNIQUE KEY `Customer_Name` (`Customer_Name`),
  ADD UNIQUE KEY `Telephone_No` (`Telephone_No`),
  ADD KEY `Password_2` (`Password`);

--
-- Indexes for table `homestayowner`
--
ALTER TABLE `homestayowner`
  ADD PRIMARY KEY (`Owner_ID`),
  ADD UNIQUE KEY `Owner_Name` (`Owner_Name`),
  ADD KEY `Password_2` (`Password`);

--
-- Indexes for table `house`
--
ALTER TABLE `house`
  ADD PRIMARY KEY (`House_ID`),
  ADD UNIQUE KEY `House_Name` (`House_Name`),
  ADD KEY `house_ibfk_1` (`Owner_ID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_ID`),
  ADD KEY `payment_ibfk_1` (`Booking_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `Booking_ID` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `homestayowner`
--
ALTER TABLE `homestayowner`
  MODIFY `Owner_ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `house`
--
ALTER TABLE `house`
  MODIFY `House_ID` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Payment_ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `booking_ibfk_4` FOREIGN KEY (`House_ID`) REFERENCES `house` (`House_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `booking_ibfk_5` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`),
  ADD CONSTRAINT `booking_ibfk_6` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`),
  ADD CONSTRAINT `booking_ibfk_7` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`);

--
-- Constraints for table `house`
--
ALTER TABLE `house`
  ADD CONSTRAINT `house_ibfk_1` FOREIGN KEY (`Owner_ID`) REFERENCES `homestayowner` (`Owner_ID`) ON DELETE CASCADE;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`Booking_ID`) REFERENCES `booking` (`Booking_ID`) ON DELETE CASCADE;
--
-- Database: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Table structure for table `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) NOT NULL DEFAULT '',
  `user` varchar(255) NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `query` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Table structure for table `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) NOT NULL,
  `col_name` varchar(64) NOT NULL,
  `col_type` varchar(64) NOT NULL,
  `col_length` text DEFAULT NULL,
  `col_collation` varchar(64) NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) DEFAULT '',
  `col_default` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Table structure for table `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `column_name` varchar(64) NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `transformation` varchar(255) NOT NULL DEFAULT '',
  `transformation_options` varchar(255) NOT NULL DEFAULT '',
  `input_transformation` varchar(255) NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) NOT NULL,
  `settings_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Table structure for table `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL,
  `export_type` varchar(10) NOT NULL,
  `template_name` varchar(64) NOT NULL,
  `template_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Table structure for table `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Table structure for table `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db` varchar(64) NOT NULL DEFAULT '',
  `table` varchar(64) NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) NOT NULL,
  `item_name` varchar(64) NOT NULL,
  `item_type` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Table structure for table `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Dumping data for table `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"homestaybookingsystem\",\"table\":\"payment\"},{\"db\":\"homestaybookingsystem\",\"table\":\"booking\"},{\"db\":\"homestaybookingsystem\",\"table\":\"homestayowner\"},{\"db\":\"homestaybookingsystem\",\"table\":\"house\"},{\"db\":\"homestaybookingsystem\",\"table\":\"customer\"}]');

-- --------------------------------------------------------

--
-- Table structure for table `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) NOT NULL DEFAULT '',
  `master_table` varchar(64) NOT NULL DEFAULT '',
  `master_field` varchar(64) NOT NULL DEFAULT '',
  `foreign_db` varchar(64) NOT NULL DEFAULT '',
  `foreign_table` varchar(64) NOT NULL DEFAULT '',
  `foreign_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Table structure for table `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `search_name` varchar(64) NOT NULL DEFAULT '',
  `search_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `display_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `prefs` text NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Table structure for table `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text NOT NULL,
  `schema_sql` text DEFAULT NULL,
  `data_sql` longtext DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Dumping data for table `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2024-01-17 14:26:14', '{\"Console\\/Mode\":\"collapse\"}');

-- --------------------------------------------------------

--
-- Table structure for table `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) NOT NULL,
  `tab` varchar(64) NOT NULL,
  `allowed` enum('Y','N') NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Table structure for table `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) NOT NULL,
  `usergroup` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indexes for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indexes for table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indexes for table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indexes for table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indexes for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indexes for table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indexes for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indexes for table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indexes for table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indexes for table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indexes for table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indexes for table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indexes for table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Database: `sparepartcarshopsystem`
--
CREATE DATABASE IF NOT EXISTS `sparepartcarshopsystem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `sparepartcarshopsystem`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `employee_id` varchar(6) NOT NULL,
  `administrative_bonus` double(7,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`employee_id`, `administrative_bonus`) VALUES
('E00001', 800.00),
('E00002', 500.00),
('E00006', 400.00),
('E00007', 600.00);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` varchar(6) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(10) NOT NULL,
  `postcode` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `name`, `phone_number`, `street`, `city`, `state`, `postcode`) VALUES
('C00001', 'John Smith', '+60123456789', '123 Main Street', 'Kuala Lumpur', 'WP', 54321),
('C00002', 'Jane Doe', '+60432156789', '456 Elm Street', 'Johor Bahru', 'JH', 81234),
('C00003', 'Ali bin Ahmad', '+60198765432', '789 Oak Lane', 'Penang', 'PG', 12345),
('C00004', 'Siti binti Awang', '+60165432198', '101 Maple Drive', 'Ipoh', 'PH', 34567),
('C00005', 'Raj Kumar', '+60132589634', '202 Pine Street', 'Melaka', 'ML', 78901),
('C00006', 'Ahmad bin Khalid', '+60123459001', 'No. 10, Jalan Mawar, Taman Melati', 'Kuala Lumpur', 'WP', 53100);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` varchar(6) NOT NULL,
  `name` varchar(50) NOT NULL,
  `ic_number` bigint(12) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(10) NOT NULL,
  `postcode` int(5) NOT NULL,
  `salary` double(7,2) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL
) ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `name`, `ic_number`, `phone_number`, `street`, `city`, `state`, `postcode`, `salary`, `username`, `password`, `position`) VALUES
('E00001', 'Nurul Amira binti Roslan', 980123145678, '+60123456789', '12, Jalan Bunga Raya', 'Alor Setar', 'KD', 5400, 5600.00, 'namiraroslan', 'nAm1ra2024', 'admin'),
('E00002', 'Muhammad Irfan bin Ahmad', 971234567890, '+60176543210', 'B-15-08, Pangsapuri Seri Damai', 'Petaling Jaya', 'SG', 46350, 4800.00, 'muhammadirfan', '1rf4n97!', 'staff'),
('E00003', 'Lee Wei Chun', 960519012345, '+60167890123', 'No. 5, Jalan Teratai', 'Ipoh', 'PH', 31400, 4200.00, 'leeweichun', 'w31chUn!', 'admin'),
('E00004', 'Devi a/p Subramaniam', 951108678901, '+60192345678', '10, Lorong 2, Taman Indah', 'Johor Bahru', 'JH', 81100, 2500.00, 'devisubra', 'D3vSubRa95', 'staff'),
('E00005', 'Ali bin Abu', 940825432109, '+60111234567', '88, Jalan Merdeka', 'Kuala Terengganu', 'TR', 20400, 3000.00, 'aliabu', 'Al1AbU2024', 'staff'),
('E00006', 'Siti Fatimah binti Ali', 930614789012, '+60145678901', '55, Taman Bunga Raya', 'Kota Bharu', 'KB', 15300, 6000.00, 'sitifatimah', 'S1t1f4t1m4h', 'admin'),
('E00007', 'Tan Ah Seng', 921205345678, '+60138901234', 'No. 12, Jalan 3/45', 'Melaka', 'ML', 75100, 4000.00, 'tanahseng', '4h53n9!', 'admin'),
('E00008', 'Priya a/p Chandran', 910915678901, '+60189012345', 'B-2-10, Pangsapuri Seri Wangi', 'Kuching', 'SR', 93200, 5200.00, 'priyachandran', 'Pr1yaCh91!', 'staff'),
('E00009', 'Hardeep Singh', 900722567890, '+60101234567', 'Lot 1234, Jalan Sultan', 'Shah Alam', 'SL', 42100, 3400.00, 'hardeepsingh', 'H4rd33p2024', 'staff'),
('E00010', 'Rosli bin Mat Isa', 890518432109, '+60152345678', '24, Jalan Mawar', 'Kuala Lumpur', 'WP', 53000, 2900.00, 'roslimisa', 'r0sl1m4t1s4', 'staff');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `purchase_id` varchar(6) NOT NULL,
  `amount` double(7,2) NOT NULL,
  `date` date NOT NULL,
  `employee_id` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`purchase_id`, `amount`, `date`, `employee_id`) VALUES
('P00001', 525.00, '2024-01-02', 'E00006'),
('P00002', 190.00, '2024-01-05', 'E00002'),
('P00003', 975.00, '2024-01-07', 'E00001'),
('P00004', 360.00, '2024-01-03', 'E00007'),
('P00005', 710.00, '2024-01-06', 'E00006'),
('P00006', 250.00, '2024-01-01', 'E00007'),
('P00007', 835.00, '2024-01-08', 'E00006'),
('P00008', 425.00, '2024-01-04', 'E00001'),
('P00009', 600.00, '2024-01-09', 'E00002'),
('P00010', 135.00, '2024-01-10', 'E00006');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_sparepart`
--

CREATE TABLE `purchase_sparepart` (
  `purchase_id` varchar(6) NOT NULL,
  `sparepart_id` varchar(7) NOT NULL,
  `quantity` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchase_sparepart`
--

INSERT INTO `purchase_sparepart` (`purchase_id`, `sparepart_id`, `quantity`) VALUES
('P00001', 'SP0004', 3),
('P00001', 'SP0009', 2),
('P00002', 'SP0001', 1),
('P00002', 'SP0007', 4),
('P00003', 'SP0005', 5),
('P00003', 'SP0008', 2),
('P00004', 'SP0002', 6),
('P00004', 'SP0010', 1),
('P00005', 'SP0003', 3),
('P00005', 'SP0006', 4),
('P00006', 'SP0001', 2),
('P00006', 'SP0009', 3),
('P00007', 'SP0004', 1),
('P00007', 'SP0007', 2),
('P00008', 'SP0005', 4),
('P00008', 'SP0008', 1),
('P00009', 'SP0002', 3),
('P00009', 'SP0010', 2),
('P00010', 'SP0003', 1),
('P00010', 'SP0006', 5);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sales_id` varchar(6) NOT NULL,
  `amount` double(7,2) NOT NULL,
  `date` date NOT NULL,
  `customer_id` varchar(6) NOT NULL,
  `employee_id` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sales_id`, `amount`, `date`, `customer_id`, `employee_id`) VALUES
('S00001', 350.00, '2024-01-04', 'C00002', 'E00001'),
('S00002', 125.00, '2024-01-06', 'C00002', 'E00005'),
('S00003', 850.00, '2024-01-02', 'C00001', 'E00003'),
('S00004', 210.00, '2024-01-07', 'C00003', 'E00002'),
('S00005', 575.00, '2024-01-05', 'C00005', 'E00004'),
('S00006', 480.00, '2024-01-03', 'C00003', 'E00007'),
('S00007', 175.00, '2024-01-08', 'C00001', 'E00005'),
('S00008', 620.00, '2024-01-01', 'C00002', 'E00003'),
('S00009', 395.00, '2024-01-05', 'C00004', 'E00001'),
('S00010', 240.00, '2024-01-07', 'C00005', 'E00006');

-- --------------------------------------------------------

--
-- Table structure for table `sparepart`
--

CREATE TABLE `sparepart` (
  `sparepart_id` varchar(6) NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` double(7,2) NOT NULL,
  `car_make` varchar(20) NOT NULL,
  `car_model` varchar(20) NOT NULL,
  `production_year` int(4) NOT NULL,
  `cost` double(7,2) NOT NULL,
  `quantity` int(4) NOT NULL,
  `supplier_id` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sparepart`
--

INSERT INTO `sparepart` (`sparepart_id`, `name`, `price`, `car_make`, `car_model`, `production_year`, `cost`, `quantity`, `supplier_id`) VALUES
('SP0001', 'Brake Pads', 150.00, 'Toyota', 'Vios', 2018, 100.00, 20, 'S0001'),
('SP0002', 'Oil Filter', 35.00, 'Honda', 'City', 2020, 20.00, 50, 'S0002'),
('SP0003', 'Spark Plugs', 80.00, 'Proton', 'Saga', 2015, 50.00, 30, 'S0003'),
('SP0004', 'Headlight Bulb', 25.00, 'Perodua', 'Myvi', 2019, 15.00, 40, 'S0002'),
('SP0005', 'Air Filter', 40.00, 'Nissan', 'Almera', 2022, 25.00, 15, 'S0004'),
('SP0006', 'Engine Oil (5W-30)', 75.00, 'Hyundai', 'Elantra', 2021, 50.00, 10, 'S0005'),
('SP0007', 'Wiper Blades', 30.00, 'Mitsubishi', 'Triton', 2017, 20.00, 25, 'S0001'),
('SP0008', 'Clutch Kit', 250.00, 'Volkswagen', 'Polo', 2019, 180.00, 5, 'S0003'),
('SP0009', 'Timing Belt', 120.00, 'Ford', 'Ranger', 2023, 80.00, 12, 'S0004'),
('SP0010', 'Battery', 180.00, 'Kia', 'Rio', 2020, 120.00, 8, 'S0002');

-- --------------------------------------------------------

--
-- Table structure for table `sparepart_sales`
--

CREATE TABLE `sparepart_sales` (
  `sparepart_id` varchar(6) NOT NULL,
  `sales_id` varchar(6) NOT NULL,
  `quantity` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sparepart_sales`
--

INSERT INTO `sparepart_sales` (`sparepart_id`, `sales_id`, `quantity`) VALUES
('SP0001', 'S00003', 4),
('SP0001', 'S00004', 1),
('SP0002', 'S00001', 2),
('SP0002', 'S00004', 3),
('SP0003', 'S00001', 2),
('SP0003', 'S00007', 1),
('SP0004', 'S00002', 1),
('SP0004', 'S00005', 2),
('SP0005', 'S00002', 1),
('SP0005', 'S00005', 4),
('SP0006', 'S00003', 3),
('SP0006', 'S00007', 2),
('SP0007', 'S00006', 1),
('SP0007', 'S00010', 3),
('SP0008', 'S00006', 2),
('SP0008', 'S00009', 3),
('SP0009', 'S00002', 2),
('SP0009', 'S00008', 1),
('SP0010', 'S00009', 1),
('SP0010', 'S00010', 1);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `employee_id` varchar(6) NOT NULL,
  `manager_id` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`employee_id`, `manager_id`) VALUES
('E00003', 'E00001'),
('E00004', 'E00001'),
('E00005', 'E00002'),
('E00008', 'E00006'),
('E00009', 'E00006'),
('E00010', 'E00006');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` varchar(6) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(10) NOT NULL,
  `postcode` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `name`, `phone_number`, `email`, `street`, `city`, `state`, `postcode`) VALUES
('S0001', 'ABC Electronics Sdn Bhd', '+60312345678', 'abcelectronics@example.com', 'No. 12, Jalan Industri 1', 'Shah Alam', 'SL', 40000),
('S0002', 'Perniagaan Maju Jaya', '+60456781234', 'majujaya@example.com', 'Lot 234, Jalan Besar', 'Johor Bahru', 'JH', 80000),
('S0003', 'Global Supplies', '+60169876543', 'globalsupplies@example.com', 'B-10-15, Menara Alpha', 'Kuala Lumpur', 'WP', 50088),
('S0004', 'Petani Fresh Produce', '+60123498765', 'petanifresh@example.com', 'Kampung Seri Tani', 'Alor Setar', 'KD', 5150),
('S0005', 'Sentosa Trading', '+60175432198', 'sentosatrading@example.com', 'No. 88, Jalan Sentosa', 'Ipoh', 'PH', 31350);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `phone_number` (`phone_number`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `ic_number` (`ic_number`),
  ADD UNIQUE KEY `phone_number` (`phone_number`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `password` (`password`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`purchase_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `purchase_sparepart`
--
ALTER TABLE `purchase_sparepart`
  ADD PRIMARY KEY (`purchase_id`,`sparepart_id`),
  ADD KEY `sparepart_id` (`sparepart_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sales_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `sparepart`
--
ALTER TABLE `sparepart`
  ADD PRIMARY KEY (`sparepart_id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `supplier_id` (`supplier_id`);

--
-- Indexes for table `sparepart_sales`
--
ALTER TABLE `sparepart_sales`
  ADD PRIMARY KEY (`sparepart_id`,`sales_id`),
  ADD KEY `sales_id` (`sales_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`employee_id`),
  ADD KEY `manager_id` (`manager_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `phone_number` (`phone_number`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `purchase_sparepart`
--
ALTER TABLE `purchase_sparepart`
  ADD CONSTRAINT `purchase_sparepart_ibfk_1` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`purchase_id`),
  ADD CONSTRAINT `purchase_sparepart_ibfk_2` FOREIGN KEY (`sparepart_id`) REFERENCES `sparepart` (`sparepart_id`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  ADD CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `sparepart`
--
ALTER TABLE `sparepart`
  ADD CONSTRAINT `sparepart_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`);

--
-- Constraints for table `sparepart_sales`
--
ALTER TABLE `sparepart_sales`
  ADD CONSTRAINT `sparepart_sales_ibfk_1` FOREIGN KEY (`sparepart_id`) REFERENCES `sparepart` (`sparepart_id`),
  ADD CONSTRAINT `sparepart_sales_ibfk_2` FOREIGN KEY (`sales_id`) REFERENCES `sales` (`sales_id`);

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `staff_ibfk_2` FOREIGN KEY (`manager_id`) REFERENCES `admin` (`employee_id`);
--
-- Database: `sport_facility_rental_system`
--
CREATE DATABASE IF NOT EXISTS `sport_facility_rental_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `sport_facility_rental_system`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(3) NOT NULL,
  `Name` varchar(80) NOT NULL,
  `PhoneNum` varchar(13) NOT NULL,
  `EmailAddress` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `Name`, `PhoneNum`, `EmailAddress`) VALUES
(1, 'Alex Teo', '+60128945566', 'alex012@gmail.com'),
(2, 'Bryan Lim', '+60167890123', 'bryan345@gmail.com'),
(3, 'Clement Ho', '+60167890012', 'clement123@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `facility_type`
--

CREATE TABLE `facility_type` (
  `FacilityType` varchar(20) NOT NULL,
  `Description` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `facility_type`
--

INSERT INTO `facility_type` (`FacilityType`, `Description`) VALUES
('Basketball', 'Basketball Court'),
('Swimming', 'Indoor Swimming Pool'),
('Tennis', 'Tennis Court');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PaymentID` int(3) NOT NULL,
  `ReservationID` int(3) NOT NULL,
  `Amount` double(5,2) NOT NULL,
  `PaymentDate` date NOT NULL,
  `PaymentMethod` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`PaymentID`, `ReservationID`, `Amount`, `PaymentDate`, `PaymentMethod`) VALUES
(1, 1, 20.00, '2024-01-26', 'Cash/QR'),
(3, 1, 25.00, '2024-01-27', 'Card'),
(4, 2, 18.00, '2024-01-28', 'Cash/QR'),
(5, 3, 20.00, '2024-01-30', 'Card'),
(6, 4, 15.00, '2024-02-01', 'Cash/QR'),
(7, 5, 22.00, '2024-02-03', 'Card'),
(8, 6, 16.00, '2024-02-05', 'Cash/QR'),
(9, 7, 18.00, '2024-02-07', 'Card'),
(10, 8, 14.00, '2024-02-09', 'Cash/QR'),
(11, 9, 20.00, '2024-02-11', 'Card'),
(12, 10, 15.00, '2024-02-13', 'Cash/QR'),
(13, 11, 22.00, '2024-02-15', 'Card'),
(14, 12, 16.00, '2024-02-17', 'Cash/QR'),
(15, 13, 18.00, '2024-02-19', 'Card'),
(16, 14, 14.00, '2024-02-21', 'Cash/QR'),
(17, 15, 20.00, '2024-02-23', 'Card'),
(18, 16, 15.00, '2024-02-25', 'Cash/QR'),
(19, 17, 22.00, '2024-02-27', 'Card'),
(20, 18, 16.00, '2024-02-29', 'Cash/QR'),
(21, 19, 18.00, '2024-03-02', 'Card'),
(22, 20, 14.00, '2024-03-03', 'Cash/QR'),
(25, 10, 30.00, '2024-01-26', 'Cash/QR');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `ReservationID` int(3) NOT NULL,
  `CustomerID` int(3) NOT NULL,
  `FacilityID` int(3) NOT NULL,
  `ReservationDate` date NOT NULL,
  `StartTime` time NOT NULL DEFAULT current_timestamp(),
  `EndTime` time NOT NULL DEFAULT current_timestamp(),
  `RequestDate` date NOT NULL DEFAULT current_timestamp(),
  `StaffID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`ReservationID`, `CustomerID`, `FacilityID`, `ReservationDate`, `StartTime`, `EndTime`, `RequestDate`, `StaffID`) VALUES
(1, 1, 1, '2024-01-25', '16:00:00', '18:00:00', '2024-01-25', 1),
(10, 1, 3, '2024-01-26', '17:00:00', '19:00:00', '2024-01-26', 1),
(20, 1, 1, '2024-01-27', '14:00:00', '16:00:00', '2024-01-26', 1),
(21, 2, 2, '2024-01-28', '10:00:00', '12:00:00', '2024-01-26', 1),
(22, 1, 1, '2024-01-29', '16:00:00', '18:00:00', '2024-01-28', 1),
(23, 2, 2, '2024-02-01', '09:00:00', '11:00:00', '2024-01-30', 1),
(24, 1, 1, '2024-02-03', '13:00:00', '15:00:00', '2024-02-02', 1),
(25, 2, 2, '2024-02-05', '11:00:00', '13:00:00', '2024-02-04', 1),
(26, 1, 1, '2024-02-07', '15:00:00', '17:00:00', '2024-02-06', 1),
(27, 2, 2, '2024-02-09', '12:00:00', '14:00:00', '2024-02-08', 1),
(28, 1, 1, '2024-02-11', '14:00:00', '16:00:00', '2024-02-10', 1),
(29, 2, 2, '2024-02-13', '10:00:00', '12:00:00', '2024-02-12', 1),
(30, 1, 1, '2024-02-15', '16:00:00', '18:00:00', '2024-02-14', 1),
(31, 2, 2, '2024-02-17', '09:00:00', '11:00:00', '2024-02-16', 1),
(32, 1, 1, '2024-02-19', '13:00:00', '15:00:00', '2024-02-18', 1),
(33, 2, 2, '2024-02-21', '11:00:00', '13:00:00', '2024-02-20', 1),
(34, 1, 1, '2024-02-23', '15:00:00', '17:00:00', '2024-02-22', 1),
(35, 2, 2, '2024-02-25', '12:00:00', '14:00:00', '2024-02-24', 1),
(36, 1, 1, '2024-02-27', '14:00:00', '16:00:00', '2024-02-26', 1),
(37, 2, 2, '2024-02-29', '10:00:00', '12:00:00', '2024-02-28', 1),
(38, 1, 1, '2024-03-02', '16:00:00', '18:00:00', '2024-03-01', 1),
(39, 2, 2, '2024-03-04', '09:00:00', '11:00:00', '2024-03-03', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sport_facility`
--

CREATE TABLE `sport_facility` (
  `FacilityID` int(3) NOT NULL,
  `FacilityName` varchar(50) NOT NULL,
  `Location` varchar(50) NOT NULL,
  `Capacity` int(3) DEFAULT NULL,
  `RentalCost` double(5,2) NOT NULL,
  `FacilityType` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sport_facility`
--

INSERT INTO `sport_facility` (`FacilityID`, `FacilityName`, `Location`, `Capacity`, `RentalCost`, `FacilityType`) VALUES
(1, 'Basketball Court 1', 'Indoor Arena', 100, 10.00, 'Basketball'),
(2, 'Swimming Pool A', 'Aquatics Center', 200, 12.00, 'Swimming'),
(3, 'Tennis Court A', 'Outdoor Courts', 50, 15.00, 'Tennis');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `StaffID` int(3) NOT NULL,
  `Name` varchar(80) NOT NULL,
  `Password` varchar(8) NOT NULL,
  `PhoneNum` varchar(13) NOT NULL,
  `EmailAddress` varchar(80) NOT NULL,
  `username` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaffID`, `Name`, `Password`, `PhoneNum`, `EmailAddress`, `username`) VALUES
(1, 'John Doe', 'pass123', '+60123456789', 'john.doe@example.com', 'John');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `facility_type`
--
ALTER TABLE `facility_type`
  ADD PRIMARY KEY (`FacilityType`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`ReservationID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `FacilityID` (`FacilityID`),
  ADD KEY `StaffID` (`StaffID`);

--
-- Indexes for table `sport_facility`
--
ALTER TABLE `sport_facility`
  ADD PRIMARY KEY (`FacilityID`),
  ADD KEY `FacilityType` (`FacilityType`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`StaffID`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `ReservationID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `sport_facility`
--
ALTER TABLE `sport_facility`
  MODIFY `FacilityID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `StaffID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`FacilityID`) REFERENCES `sport_facility` (`FacilityID`),
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`);

--
-- Constraints for table `sport_facility`
--
ALTER TABLE `sport_facility`
  ADD CONSTRAINT `sport_facility_ibfk_1` FOREIGN KEY (`FacilityType`) REFERENCES `facility_type` (`FacilityType`);
--
-- Database: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
