-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-06-2023 a las 11:11:28
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto-gym`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clases`
--

CREATE TABLE `clases` (
  `nombre_cla` varchar(50) NOT NULL,
  `instructor_designado_cla` varchar(50) NOT NULL,
  `horario_cla` varchar(5) NOT NULL DEFAULT '',
  `dias_cla` varchar(100) DEFAULT NULL,
  `clientes_nombre_cla` varchar(50) NOT NULL,
  `clientes_id_cla` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(5) NOT NULL,
  `nombre_cli` varchar(50) NOT NULL,
  `apellido_pat_cli` varchar(50) NOT NULL,
  `apellido_mat_cli` varchar(50) NOT NULL,
  `correo_cli` varchar(50) NOT NULL,
  `telefono_cli` varchar(50) NOT NULL,
  `telefono_eme_cli` varchar(50) DEFAULT NULL,
  `fecha_inscrito_cli` date NOT NULL,
  `asistencia_cli` int(2) DEFAULT NULL,
  `edad_cli` int(3) NOT NULL,
  `Imagenes` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre_cli`, `apellido_pat_cli`, `apellido_mat_cli`, `correo_cli`, `telefono_cli`, `telefono_eme_cli`, `fecha_inscrito_cli`, `asistencia_cli`, `edad_cli`, `Imagenes`) VALUES
(1, 'Alfonso', 'Cota', 'Jauregui', 'alfa123@gmail.com', '6120001010', '6240001234', '2023-06-04', 1, 25, NULL),
(2, 'Julian', 'Mendoza', 'Espinoza', 'mendozaARK@gmail.com', '4980159812', '0', '2023-06-04', 28, 38, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instructor`
--

CREATE TABLE `instructor` (
  `id_instructor` int(5) NOT NULL,
  `nombre_in` varchar(50) NOT NULL,
  `apellido_in` varchar(50) DEFAULT NULL,
  `edad_in` int(3) NOT NULL,
  `correo_in` varchar(50) NOT NULL,
  `telefono_in` varchar(50) NOT NULL,
  `telefono_eme_in` varchar(50) NOT NULL,
  `Fecha_Inscrito_in` varchar(50) DEFAULT NULL,
  `asistencia_in` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `instructor`
--

INSERT INTO `instructor` (`id_instructor`, `nombre_in`, `apellido_in`, `edad_in`, `correo_in`, `telefono_in`, `telefono_eme_in`, `Fecha_Inscrito_in`, `asistencia_in`) VALUES
(1, 'er', 'ere', 23, 'as@gmail.com', '1234512345', '1234512345', '0000-00-00', '0'),
(2, 'as', 'as', 12, 'fr', '1234567890', '1234567890', '0000-00-00', '0'),
(4, 'erdgs', 'sdfsdggs', 20, 'asa', '6123450945', '1234567890', '07-06-2023', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifas`
--

CREATE TABLE `tarifas` (
  `clase_tr` varchar(50) NOT NULL,
  `costo_tr` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`nombre_cla`) USING BTREE,
  ADD KEY `instructor_FK` (`instructor_designado_cla`),
  ADD KEY `clientes_nombre_FK` (`clientes_nombre_cla`),
  ADD KEY `clientes_id_FK` (`clientes_id_cla`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `nombre_cli` (`nombre_cli`);

--
-- Indices de la tabla `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`id_instructor`),
  ADD UNIQUE KEY `nombre_in` (`nombre_in`);

--
-- Indices de la tabla `tarifas`
--
ALTER TABLE `tarifas`
  ADD KEY `clase_FK` (`clase_tr`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `instructor`
--
ALTER TABLE `instructor`
  MODIFY `id_instructor` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clases`
--
ALTER TABLE `clases`
  ADD CONSTRAINT `clientes_id_FK` FOREIGN KEY (`clientes_id_cla`) REFERENCES `clientes` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `clientes_nombre_FK` FOREIGN KEY (`clientes_nombre_cla`) REFERENCES `clientes` (`nombre_cli`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `instructor_FK` FOREIGN KEY (`instructor_designado_cla`) REFERENCES `instructor` (`nombre_in`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tarifas`
--
ALTER TABLE `tarifas`
  ADD CONSTRAINT `clase_FK` FOREIGN KEY (`clase_tr`) REFERENCES `clases` (`nombre_cla`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
