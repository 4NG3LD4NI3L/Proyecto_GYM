-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2023 at 12:27 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proyecto-gym`
--

-- --------------------------------------------------------

--
-- Table structure for table `clases`
--

CREATE TABLE `clases` (
  `nombre_cla` varchar(50) NOT NULL,
  `instructor_designado_cla` varchar(50) NOT NULL,
  `horario_cla` varchar(50) NOT NULL DEFAULT '',
  `dias_cla` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `clases`
--

INSERT INTO `clases` (`nombre_cla`, `instructor_designado_cla`, `horario_cla`, `dias_cla`) VALUES
('Body combat', 'Jose Carlos', '7:00 AM - 9:00 AM', 'Lunes,Martes'),
('xCombat', 'Maria', '8:00 AM - 11:00 AM', 'Lunes,Martes,Jueves,Sabado');

-- --------------------------------------------------------

--
-- Table structure for table `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(5) NOT NULL,
  `nombre_cli` varchar(50) NOT NULL,
  `apellidos_cli` varchar(50) NOT NULL,
  `correo_cli` varchar(50) NOT NULL,
  `telefono_cli` varchar(50) NOT NULL,
  `telefono_eme_cli` varchar(50) DEFAULT NULL,
  `fecha_inscrito_cli` varchar(50) NOT NULL DEFAULT '',
  `asistencia_cli` int(2) DEFAULT NULL,
  `edad_cli` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre_cli`, `apellidos_cli`, `correo_cli`, `telefono_cli`, `telefono_eme_cli`, `fecha_inscrito_cli`, `asistencia_cli`, `edad_cli`) VALUES
(1, 'Alfonso', 'Cota', 'alfa123@gmail.com', '6120001010', '6240001234', '2023-06-04', 1, 25),
(2, 'Julian', 'Mendoza', 'mendozaARK@gmail.com', '4980159812', '0', '2023-06-04', 28, 38),
(4, 'David', 'Castro Montaño', 'david@gmail.com', '6122294578', '6242013140', '07-06-2023', 0, 18),
(6, 'Josue', 'Zamora Garcia', 'gohan117', '6126549872', '6245120258', '07-06-2023', 0, 23),
(9, 'wqwqwq', 'qwqwqw', 'qwqwqw@gmail.com', '6126543210', '6244567890', '07-06-2023', 0, 98),
(11, 'Joel', 'Miller Jonhson', 'theLastOfus@gmail.com', '6125209634', '6127410852', '12-06-2023', 0, 52);

-- --------------------------------------------------------

--
-- Table structure for table `inscripciones_a_clases`
--

CREATE TABLE `inscripciones_a_clases` (
  `clase` varchar(50) NOT NULL,
  `instructor_nombre` varchar(50) NOT NULL,
  `id_cliente_inscrito` int(5) NOT NULL DEFAULT 0,
  `nombre_cliente_inscrito` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `inscripciones_a_clases`
--

INSERT INTO `inscripciones_a_clases` (`clase`, `instructor_nombre`, `id_cliente_inscrito`, `nombre_cliente_inscrito`) VALUES
('xCombat', 'Maria', 1, 'Alfonso'),
('Body combat', 'Jose Carlos', 6, 'Josue'),
('Body combat', 'Jose Carlos', 11, 'Joel');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `id_instructor` int(5) NOT NULL,
  `nombre_in` varchar(50) NOT NULL,
  `apellido_in` varchar(50) NOT NULL,
  `edad_in` int(3) NOT NULL,
  `correo_in` varchar(50) NOT NULL,
  `telefono_in` varchar(10) NOT NULL DEFAULT '',
  `telefono_eme_in` varchar(10) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`id_instructor`, `nombre_in`, `apellido_in`, `edad_in`, `correo_in`, `telefono_in`, `telefono_eme_in`) VALUES
(1, 'Maria', 'Chavez', 20, 'chama89@gmail.com', '6129991548', '6244579014'),
(2, 'Jose Carlos', 'Aveiro Lopez', 30, 'jcarlosLZ@gmail.com', '6245204103', '6241598524'),
(3, 'Alberto Juan', 'Sedillo Alcatraz', 41, 'xXentrenadorXx@gmail.com', '9604568795', '6128527410'),
(4, 'Sherlyn', 'Cruz Rodrigrez', 26, '3str3lla@gmail.com', '4568529519', '2579786547');

-- --------------------------------------------------------

--
-- Table structure for table `tarifas`
--

CREATE TABLE `tarifas` (
  `plan_tr` varchar(50) NOT NULL,
  `costo_tr` int(4) NOT NULL,
  `id_tarifa` int(3) NOT NULL,
  `instructor_tr` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tarifas`
--

INSERT INTO `tarifas` (`plan_tr`, `costo_tr`, `id_tarifa`, `instructor_tr`) VALUES
('xCombat', 300, 0, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`nombre_cla`) USING BTREE,
  ADD KEY `instructor_FK` (`instructor_designado_cla`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `nombre_cli` (`nombre_cli`);

--
-- Indexes for table `inscripciones_a_clases`
--
ALTER TABLE `inscripciones_a_clases`
  ADD KEY `clase_nombre_FK` (`clase`),
  ADD KEY `nombre_instructor_FK` (`instructor_nombre`),
  ADD KEY `id_cliente_FK` (`id_cliente_inscrito`),
  ADD KEY `nombre_cliente_FK` (`nombre_cliente_inscrito`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`id_instructor`),
  ADD UNIQUE KEY `nombre_in` (`nombre_in`);

--
-- Indexes for table `tarifas`
--
ALTER TABLE `tarifas`
  ADD PRIMARY KEY (`id_tarifa`),
  ADD KEY `clase_FK` (`plan_tr`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `instructor`
--
ALTER TABLE `instructor`
  MODIFY `id_instructor` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `clases`
--
ALTER TABLE `clases`
  ADD CONSTRAINT `instructor_FK` FOREIGN KEY (`instructor_designado_cla`) REFERENCES `instructor` (`nombre_in`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `inscripciones_a_clases`
--
ALTER TABLE `inscripciones_a_clases`
  ADD CONSTRAINT `clase_nombre_FK` FOREIGN KEY (`clase`) REFERENCES `clases` (`nombre_cla`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_cliente_FK` FOREIGN KEY (`id_cliente_inscrito`) REFERENCES `clientes` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `nombre_cliente_FK` FOREIGN KEY (`nombre_cliente_inscrito`) REFERENCES `clientes` (`nombre_cli`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `nombre_instructor_FK` FOREIGN KEY (`instructor_nombre`) REFERENCES `instructor` (`nombre_in`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tarifas`
--
ALTER TABLE `tarifas`
  ADD CONSTRAINT `clase_FK` FOREIGN KEY (`plan_tr`) REFERENCES `clases` (`nombre_cla`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
