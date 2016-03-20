-- MySQL dump 10.13  Distrib 5.5.11, for Win64 (x86)
--
-- Host: localhost    Database: refaccionaria
-- ------------------------------------------------------
-- Server version	5.5.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulo` (
  `art_id` varchar(25) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `cantidad` int(10) DEFAULT NULL,
  `tipo_carro` varchar(10) NOT NULL DEFAULT 'General',
  `precio` double DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `fecha_adq` date NOT NULL,
  `disponible` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`art_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES ('000Foco-2W','Foco-2W',6,'General',8.52,NULL,'2011-05-25',1),('001AceiteMotor-1L','AceiteMotor-1L',12,'General',45.95,NULL,'2011-05-25',1),('001Bujia','Bujia',29,'Chico',20,NULL,'2011-05-25',1),('001Foco-5W','Foco-5W',5,'Chico',9,NULL,'2011-05-25',1),('002Pila','Pila',15,'Chico',750,NULL,'2011-05-31',1),('002Wiper','Wiper',1,'Chico',89.56,NULL,'2011-05-25',1),('003TapaGasolina','TapaGasolina',8,'Mediano',55.8,NULL,'2011-05-25',1);
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checador`
--

DROP TABLE IF EXISTS `checador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `checador` (
  `emple_id` int(11) NOT NULL,
  `entrada` time NOT NULL,
  `salida` time NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`emple_id`,`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checador`
--

LOCK TABLES `checador` WRITE;
/*!40000 ALTER TABLE `checador` DISABLE KEYS */;
INSERT INTO `checador` VALUES (1,'08:12:05','17:03:45','2011-05-27'),(1,'14:13:57','17:01:57','2011-05-28'),(1,'08:00:00','17:50:07','2011-05-30'),(2,'12:15:16','17:27:56','2011-05-23'),(2,'02:51:27','17:33:31','2011-05-24'),(2,'02:51:27','17:33:37','2011-05-25'),(2,'02:51:27','17:33:41','2011-05-26'),(2,'12:51:27','17:33:50','2011-05-27'),(2,'12:51:27','17:33:57','2011-05-28');
/*!40000 ALTER TABLE `checador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `emple_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) DEFAULT NULL,
  `apellido` varchar(15) DEFAULT NULL,
  `calle` varchar(20) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `facc` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `puesto_id` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`emple_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Hector','Garc¡a','Calle 1ra',125,'Tecolotes','rotceh_1203@hotmail.com','(686)512-3456',2),(2,'Michael','Duarte','Grito de dolores',120,'Hidalgo','michael.duarte@hotmail.com','(686)232-7433',1),(3,'Manuel','Iribe','Calle 2da',215,'Barcelona','Orobi@hotmail.com','(686)512-2676',3),(4,'Juan Luis','Olguin','Calle 3ra',521,'Heroico','eviltopollillo@hotmail.com','(686)123-2321',4),(5,'Yolanda','Roro','Calle 4ta',512,'Lejos','Yolip@hotmail.com','(686)741-8520',5);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puesto` (
  `puesto_id` tinyint(4) NOT NULL,
  `puesto` varchar(25) NOT NULL,
  `sueldo` double NOT NULL,
  PRIMARY KEY (`puesto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (1,'jefe',88888.88),(2,'cajero',1250.5),(3,'chalan',150.5),(4,'conserje',5550.5),(5,'secretaria',15550.5);
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vent_art`
--

DROP TABLE IF EXISTS `vent_art`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vent_art` (
  `venta_id` int(11) NOT NULL,
  `art_id` varchar(25) NOT NULL DEFAULT '',
  `cant` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`art_id`,`venta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vent_art`
--

LOCK TABLES `vent_art` WRITE;
/*!40000 ALTER TABLE `vent_art` DISABLE KEYS */;
INSERT INTO `vent_art` VALUES (2,'000Foco-2W',1),(1,'001Bujia',10),(2,'001Foco-5W',1),(2,'003TapaGasolina',1);
/*!40000 ALTER TABLE `vent_art` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `venta_id` int(11) NOT NULL AUTO_INCREMENT,
  `total` double NOT NULL,
  `fecha_venta` date NOT NULL,
  `emple_id` int(8) NOT NULL DEFAULT '1',
  PRIMARY KEY (`venta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,200,'2011-05-26',1),(2,73.32,'2011-05-27',2);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-06-04 20:10:13
