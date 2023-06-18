-- phpMyAdmin SQL Dump
-- version 5.2.2-dev+20230323.56d19eb4aa
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2023 at 02:21 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `futsaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `absent`
--

CREATE TABLE `absent` (
  `id` varchar(36) NOT NULL,
  `employee_id` varchar(36) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `information` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `absent`
--

INSERT INTO `absent` (`id`, `employee_id`, `date`, `information`) VALUES
('28e43589-b4d9-40ac-aace-fb325d0ab3d5', 'K0001', '2023-03-16', 'Izin');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` varchar(36) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `employee_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `employee_id`) VALUES
('0588ec24-6ad5-438a-b363-476b95166a94', 'ryan', 'admin123', 'K0004'),
('4af7ca54-7290-4bae-9be7-759bdb28622e', 'indra', 'admin123', 'K0001');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  `venue_id` varchar(5) DEFAULT NULL,
  `dateOrder` date DEFAULT NULL,
  `dateBooked` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `isConfirmed` tinyint(1) DEFAULT NULL,
  `image` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `user_id`, `venue_id`, `dateOrder`, `dateBooked`, `start_time`, `end_time`, `price`, `isConfirmed`, `image`) VALUES
('BK10-062641', 'db720d4a-07e0-4402-acee-fd4fb5f15527', 'FT002', '2023-04-10', '2023-04-15', '11:00:00', '12:00:00', 200000, 1, 'src/upload/BK10-062641.jpg'),
('BK10-073736', 'db720d4a-07e0-4402-acee-fd4fb5f15527', 'FT002', '2023-04-10', '2023-04-15', '11:00:00', '12:00:00', 200000, 1, 'src/upload/BK10-073736.jpg'),
('BK10-073843', 'db720d4a-07e0-4402-acee-fd4fb5f15527', 'FT002', '2023-04-10', '2023-04-16', '11:00:00', '14:00:00', 600000, 0, 'src/upload/BK10-073843.jpg'),
('BK10-073927', 'db720d4a-07e0-4402-acee-fd4fb5f15527', 'FT002', '2023-04-10', '2023-04-16', '12:00:00', '14:00:00', 400000, 0, 'src/upload/BK10-073927.jpg'),
('BK10-082625', 'db720d4a-07e0-4402-acee-fd4fb5f15527', 'FT002', '2023-04-10', '2023-04-16', '12:00:00', '14:00:00', 400000, 1, 'src/upload/BK10-082625.jpg'),
('BK10-082706', 'db720d4a-07e0-4402-acee-fd4fb5f15527', 'FT002', '2023-04-10', '2023-04-16', '11:00:00', '12:00:00', 200000, NULL, 'src/upload/BK10-082706.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` varchar(36) NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
('119f52f2-e693-4e60-a72c-697a7074ae98', 'Badminton'),
('1cc42e31-41d3-485e-8d0e-86f1cd22df69', 'Basket'),
('50f5bf32-af8a-48e0-9a91-5db199f1fee5', 'Voli'),
('ae293b7d-b524-472a-b920-1efd2d24272e', 'Futsal');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `phonenumber` varchar(14) NOT NULL,
  `position` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `address`, `birthdate`, `phonenumber`, `position`, `sex`) VALUES
('K0001', 'Indra Putra', 'Jakasetia, Bekasi', '2000-03-10', '08976456534', 'Admin', 'Laki-Laki'),
('K0003', 'Sinaga Andre', 'Jakarta Utara', '2000-03-16', '08976453654', 'Manager', 'Laki-Laki'),
('K0004', 'Ryan Anggoro', 'Bekasi, Jawa Barat', '2000-03-04', '081343545455', 'Admin', 'Laki-Laki'),
('K0005', 'Rendi Nugraha', 'Cakung, Jakarta timur', '2000-04-07', '0865763443', 'Personalia', 'Laki-Laki'),
('K0006', 'Putri Anindita', 'Pluit, Jakarta Utara\n', '1998-04-16', '0877787872', 'Warehouse', 'Perempuan');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `kode` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jenis` varchar(100) NOT NULL,
  `stok` varchar(10) NOT NULL,
  `lapangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`kode`, `nama`, `jenis`, `stok`, `lapangan`) VALUES
('FB01', 'Bola Futsal', 'Bola', '5', 'Futsal'),
('FB02', 'Gawang Futsal', 'Gawang', '3', 'Futsal'),
('BB01', 'Bola Basket', 'Bola', '5', 'Basket'),
('BB02', 'Ring Basket', 'Tiang', '3', 'Basket'),
('BTB01', 'Net Bulu Tangkis', 'Tiang', '2', 'Bulu Tangkis'),
('VB01', 'Bola Voli', 'Bola', '5', 'Voli');

-- --------------------------------------------------------

--
-- Table structure for table `personalia`
--

CREATE TABLE `personalia` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `personalia`
--

INSERT INTO `personalia` (`id`, `username`, `password`) VALUES
(1, 'personalia', 'personalia123');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `username` varchar(25) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `phonenumber` varchar(14) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `fullname`, `phonenumber`, `address`, `email`, `password`) VALUES
('346e6034-b660-452d-869e-501195a2385f', 'Putra22', 'Ahmad Putra', '08774676344', 'Tanjung Priuk, Jakarta\n', 'putra@email.com', '$2a$10$92z0BrRm9Y7G7sgE86.wJO9obukMhlM.wNXCyTmU1gg1JY1Nc/ctG'),
('db720d4a-07e0-4402-acee-fd4fb5f15527', 'Angga', 'Angga Yunandar', '0897665463323', 'Bekasi Timur, Bekasi', 'angga@email.com', '$2a$10$OKKKiSTo71q6aybjGpQl4u06/BJzWiaHit9oV2VTI.xs/gYjHBo.e');

-- --------------------------------------------------------

--
-- Table structure for table `venue`
--

CREATE TABLE `venue` (
  `id` varchar(36) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `open` time DEFAULT NULL,
  `close` time DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `category_id` varchar(36) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `venue`
--

INSERT INTO `venue` (`id`, `name`, `description`, `open`, `close`, `price`, `category_id`, `isActive`) VALUES
('BD001', 'Badminton 1', 'Good', '08:00:00', '20:00:00', 50000, '119f52f2-e693-4e60-a72c-697a7074ae98', 1),
('FT001', 'Futsal 1', 'Finil', '08:00:00', '20:00:00', 150000, 'ae293b7d-b524-472a-b920-1efd2d24272e', 1),
('FT002', 'Futsal 2', 'Sintetis', '08:00:00', '22:00:00', 200000, 'ae293b7d-b524-472a-b920-1efd2d24272e', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absent`
--
ALTER TABLE `absent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `attendance_employee_id_fk` (`employee_id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `admin_employee_id_fk` (`employee_id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `booking_user_id_fk` (`user_id`),
  ADD KEY `booking_venue_id_fk` (`venue_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `employee_pk2` (`phonenumber`);

--
-- Indexes for table `personalia`
--
ALTER TABLE `personalia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phonenumber` (`phonenumber`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `venue`
--
ALTER TABLE `venue`
  ADD PRIMARY KEY (`id`),
  ADD KEY `venue_category_id_fk` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `personalia`
--
ALTER TABLE `personalia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absent`
--
ALTER TABLE `absent`
  ADD CONSTRAINT `attendance_employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `booking_venue_id_fk` FOREIGN KEY (`venue_id`) REFERENCES `venue` (`id`);

--
-- Constraints for table `venue`
--
ALTER TABLE `venue`
  ADD CONSTRAINT `venue_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
