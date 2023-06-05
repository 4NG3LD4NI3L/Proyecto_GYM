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
  `instructor_designado_cla` varchar(50) NOT NULL,
  `horario_cla` varchar(5) NOT NULL DEFAULT '',
  `dias_cla` varchar(100) DEFAULT NULL,
  `clientes_nombre_cla` varchar(50) NOT NULL,
  `clientes_id_cla` int(5) NOT NULL,
  PRIMARY KEY (`nombre_cla`) USING BTREE,
  KEY `instructor_FK` (`instructor_designado_cla`),
  KEY `clientes_nombre_FK` (`clientes_nombre_cla`),
  KEY `clientes_id_FK` (`clientes_id_cla`),
  CONSTRAINT `clientes_id_FK` FOREIGN KEY (`clientes_id_cla`) REFERENCES `clientes` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `clientes_nombre_FK` FOREIGN KEY (`clientes_nombre_cla`) REFERENCES `clientes` (`nombre_cli`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `instructor_FK` FOREIGN KEY (`instructor_designado_cla`) REFERENCES `instructor` (`nombre_in`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `clases` DISABLE KEYS */;
/*!40000 ALTER TABLE `clases` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` int(5) NOT NULL AUTO_INCREMENT,
  `nombre_cli` varchar(50) NOT NULL,
  `apellido_pat_cli` varchar(50) NOT NULL,
  `apellido_mat_cli` varchar(50) NOT NULL,
  `correo_cli` varchar(50) NOT NULL,
  `telefono_cli` varchar(50) NOT NULL,
  `telefono_eme_cli` varchar(50) DEFAULT NULL,
  `fecha_inscrito_cli` date NOT NULL,
  `asistencia_cli` int(2) DEFAULT NULL,
  `edad_cli` int(3) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `nombre_cli` (`nombre_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`id_cliente`, `nombre_cli`, `apellido_pat_cli`, `apellido_mat_cli`, `correo_cli`, `telefono_cli`, `telefono_eme_cli`, `fecha_inscrito_cli`, `asistencia_cli`, `edad_cli`) VALUES
	(1, 'Alfonso', 'Cota', 'Jauregui', 'alfa123@gmail.com', '6120001010', '6240001234', '2023-06-04', 1, 25),
	(2, 'Julian', 'Mendoza', 'Espinoza', 'mendozaARK@gmail.com', '4980159812', '0', '2023-06-04', 28, 38);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `instructor` (
  `id_instructor` int(5) NOT NULL AUTO_INCREMENT,
  `nombre_in` varchar(50) NOT NULL,
  `apellido_pat_in` varchar(50) NOT NULL,
  `apellido_mat_in` varchar(50) NOT NULL,
  `edad_in` int(3) NOT NULL,
  `correo_in` varchar(50) NOT NULL,
  `telefono_in` int(10) NOT NULL,
  `telefono_eme_in` int(10) NOT NULL,
  PRIMARY KEY (`id_instructor`),
  UNIQUE KEY `nombre_in` (`nombre_in`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `tarifas` (
  `clase_tr` varchar(50) NOT NULL,
  `costo_tr` int(4) NOT NULL,
  KEY `clase_FK` (`clase_tr`),
  CONSTRAINT `clase_FK` FOREIGN KEY (`clase_tr`) REFERENCES `clases` (`nombre_cla`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*!40000 ALTER TABLE `tarifas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarifas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
