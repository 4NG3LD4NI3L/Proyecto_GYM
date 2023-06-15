/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `proyecto-gym` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `proyecto-gym`;

CREATE TABLE IF NOT EXISTS `clases` (
  `nombre_cla` varchar(50) NOT NULL,
  `instructor_designado_cla` varchar(50) DEFAULT NULL,
  `horario_cla` varchar(50) NOT NULL DEFAULT '',
  `dias_cla` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nombre_cla`) USING BTREE,
  KEY `instructor_FK` (`instructor_designado_cla`),
  CONSTRAINT `instructor_FK` FOREIGN KEY (`instructor_designado_cla`) REFERENCES `instructor` (`nombre_in`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `clases` DISABLE KEYS */;
INSERT INTO `clases` (`nombre_cla`, `instructor_designado_cla`, `horario_cla`, `dias_cla`) VALUES
	('Body combat', 'Jose Carlos', '7-9', 'Lunes,Martes,'),
	('xCombat', 'Maria', '8-11', 'Lunes,Martes,Jueves,Sabado'),
	('Yoga', 'Sherlyn', '5-8', 'Miercoles,Viernes,Domingo');
/*!40000 ALTER TABLE `clases` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` int(5) NOT NULL AUTO_INCREMENT,
  `nombre_cli` varchar(50) NOT NULL,
  `apellidos_cli` varchar(50) NOT NULL,
  `correo_cli` varchar(50) NOT NULL,
  `telefono_cli` varchar(50) NOT NULL,
  `telefono_eme_cli` varchar(50) DEFAULT NULL,
  `fecha_inscrito_cli` varchar(50) NOT NULL DEFAULT '',
  `asistencia_cli` int(2) DEFAULT NULL,
  `edad_cli` int(3) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `nombre_cli` (`nombre_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`id_cliente`, `nombre_cli`, `apellidos_cli`, `correo_cli`, `telefono_cli`, `telefono_eme_cli`, `fecha_inscrito_cli`, `asistencia_cli`, `edad_cli`) VALUES
	(1, 'Alfonso', 'Cota', 'alfa123@gmail.com', '6120001010', '6240001234', '2023-06-04', 1, 25),
	(2, 'Julian', 'Mendoza', 'mendozaARK@gmail.com', '4980159812', '0', '2023-06-04', 28, 38),
	(6, 'Josue', 'Zamora Garcia', 'gohan117', '6126549872', '6245120258', '07-06-2023', 0, 23),
	(9, 'Ramon', 'Fit Palomar', 'am2rica@gmail.com', '6126543210', '6244567890', '07-06-2023', 0, 45),
	(11, 'Joel', 'Miller Jonhson', 'theLastOfus@gmail.com', '6125209634', '6127410852', '12-06-2023', 0, 52);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `historial_clientes` (
  `mes_h` varchar(20) NOT NULL,
  `id_cliente_h` int(5) NOT NULL DEFAULT 0,
  `nombre_cliente_h` varchar(50) NOT NULL DEFAULT '0',
  `asistencia_h` int(2) DEFAULT 0,
  `tarifa_h` varchar(50) NOT NULL DEFAULT '0',
  `monto_h` int(5) NOT NULL DEFAULT 0,
  KEY `id_clienteFK` (`id_cliente_h`),
  KEY `nombre_clienteFK` (`nombre_cliente_h`),
  CONSTRAINT `id_clienteFK` FOREIGN KEY (`id_cliente_h`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `nombre_clienteFK` FOREIGN KEY (`nombre_cliente_h`) REFERENCES `clientes` (`nombre_cli`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `historial_clientes` DISABLE KEYS */;
INSERT INTO `historial_clientes` (`mes_h`, `id_cliente_h`, `nombre_cliente_h`, `asistencia_h`, `tarifa_h`, `monto_h`) VALUES
	('04-06-2023', 1, 'Alfonso', 3, '1 mes', 300),
	('04-06-2023', 2, 'Julian', 5, '1 mes', 300),
	('07-06-2023', 6, 'Josue', 0, '1 mes', 300),
	('07-06-2023', 9, 'Ramon', 9, '1 año', 3300),
	('12-06-2023', 11, 'Joel', 13, '6 meses', 1600),
	('15-06-2023', 1, 'Alfonso', 0, '6 meses', 1600),
	('15-06-2023', 11, 'Joel', 0, '1 Mes', 300);
/*!40000 ALTER TABLE `historial_clientes` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `inscripciones_a_clases` (
  `clase` varchar(50) NOT NULL,
  `instructor_nombre` varchar(50) NOT NULL,
  `id_cliente_inscrito` int(5) NOT NULL DEFAULT 0,
  `nombre_cliente_inscrito` varchar(50) NOT NULL,
  KEY `clase_nombre_FK` (`clase`),
  KEY `nombre_instructor_FK` (`instructor_nombre`),
  KEY `id_cliente_FK` (`id_cliente_inscrito`),
  KEY `nombre_cliente_FK` (`nombre_cliente_inscrito`),
  CONSTRAINT `clase_nombre_FK` FOREIGN KEY (`clase`) REFERENCES `clases` (`nombre_cla`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_cliente_FK` FOREIGN KEY (`id_cliente_inscrito`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `nombre_cliente_FK` FOREIGN KEY (`nombre_cliente_inscrito`) REFERENCES `clientes` (`nombre_cli`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nombre_instructor_FK` FOREIGN KEY (`instructor_nombre`) REFERENCES `instructor` (`nombre_in`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `inscripciones_a_clases` DISABLE KEYS */;
INSERT INTO `inscripciones_a_clases` (`clase`, `instructor_nombre`, `id_cliente_inscrito`, `nombre_cliente_inscrito`) VALUES
	('xCombat', 'Maria', 1, 'Alfonso'),
	('Body combat', 'Jose Carlos', 6, 'Josue'),
	('Body combat', 'Jose Carlos', 11, 'Joel'),
	('xCombat', 'Maria', 6, 'Josue'),
	('Yoga', 'Sherlyn', 9, 'Ramon'),
	('Yoga', 'Sherlyn', 6, 'Josue');
/*!40000 ALTER TABLE `inscripciones_a_clases` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `instructor` (
  `id_instructor` int(5) NOT NULL AUTO_INCREMENT,
  `nombre_in` varchar(50) NOT NULL,
  `apellido_in` varchar(50) NOT NULL,
  `edad_in` int(3) NOT NULL,
  `correo_in` varchar(50) NOT NULL,
  `telefono_in` varchar(10) NOT NULL DEFAULT '',
  `telefono_eme_in` varchar(10) NOT NULL DEFAULT '',
  `sueldo_in` int(10) NOT NULL,
  PRIMARY KEY (`id_instructor`),
  UNIQUE KEY `nombre_in` (`nombre_in`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` (`id_instructor`, `nombre_in`, `apellido_in`, `edad_in`, `correo_in`, `telefono_in`, `telefono_eme_in`, `sueldo_in`) VALUES
	(1, 'Maria', 'Chavez', 20, 'chama89@gmail.com', '6129991548', '6244579014', 0),
	(2, 'Jose Carlos', 'Aveiro Lopez', 30, 'jcarlosLZ@gmail.com', '6245204103', '6241598524', 0),
	(3, 'Alberto Juan', 'Sedillo Alcatraz', 41, 'xXentrenadorXx@gmail.com', '9604568795', '6128527410', 0),
	(4, 'Sherlyn', 'Cruz Rodrigrez', 26, '3str3lla@gmail.com', '4568529519', '2579786547', 0);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `tarifas` (
  `plan_tr` varchar(50) NOT NULL,
  `costo_tr` int(4) NOT NULL,
  `id_tarifa` int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_tarifa`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `tarifas` DISABLE KEYS */;
INSERT INTO `tarifas` (`plan_tr`, `costo_tr`, `id_tarifa`) VALUES
	('6 meses', 1600, 7),
	('1 Mes', 300, 10),
	('1 Año', 3300, 11);
/*!40000 ALTER TABLE `tarifas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
