CREATE DATABASE  IF NOT EXISTS `astrobuses` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `astrobuses`;
-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: localhost    Database: astrobuses
-- ------------------------------------------------------
-- Server version	8.0.20-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `astrobus`
--

DROP TABLE IF EXISTS `astrobus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `astrobus` (
  `IdAstrobus` int NOT NULL,
  `cantAsientos` int NOT NULL,
  `distService` int DEFAULT NULL,
  `distLimite` int NOT NULL,
  `estado` int NOT NULL,
  `fecha_alta` date NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `motivo` int DEFAULT NULL,
  PRIMARY KEY (`IdAstrobus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astrobus`
--

LOCK TABLES `astrobus` WRITE;
/*!40000 ALTER TABLE `astrobus` DISABLE KEYS */;
INSERT INTO `astrobus` VALUES (1,100,100000,1000000,1,'2020-01-01',NULL,0);
/*!40000 ALTER TABLE `astrobus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planeta`
--

DROP TABLE IF EXISTS `planeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planeta` (
  `id_planeta` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `estado` int NOT NULL DEFAULT '1',
  `coordenadaX` int NOT NULL,
  `coordenadaY` int NOT NULL,
  `url` longtext,
  PRIMARY KEY (`id_planeta`,`coordenadaX`,`coordenadaY`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planeta`
--

LOCK TABLES `planeta` WRITE;
/*!40000 ALTER TABLE `planeta` DISABLE KEYS */;
INSERT INTO `planeta` VALUES (1,'Tierra',0,100,150,'http://localhost:8080/Web/img/tierra.png'),(2,'Luna',1,200,350,'http://paulbourke.net/miscellaneous/moon/2ds.gif'),(13,'Marte',1,400,500,NULL),(14,'Mercurio',1,50,50,'https://4.bp.blogspot.com/-pI5FDHTM1t8/Ue0zXJZZVVI/AAAAAAAAVYw/RWQySG0Sbh8/s1600/mercury_map_2013_945.jpg'),(15,'Saturno',1,500,500,NULL),(16,'Venus',1,35,35,NULL),(17,'Pluton',1,1500,4500,NULL),(18,'Urano',1,19,100,NULL),(19,'Jupiter',1,100,200,NULL),(20,'Cibertron',1,1000,4000,NULL),(21,'Nebula',1,10000,140000,NULL),(22,'Z9000',1,450,400,NULL),(23,'Z4000',1,50000,45000,NULL),(24,'Z3200',1,50000,40000,NULL),(25,'AZ4000',1,1000,4000,NULL),(26,'AZ9500',1,10042,213123,NULL),(27,'AZ10231',1,100040,100030,NULL),(28,'Kamino',1,1000,4000,NULL),(29,'Tatooine',1,5000312,1230000,NULL),(30,'Yavin IV',1,90000,80000,NULL),(31,'Hoth',1,3000,4000,NULL),(32,'Coruscant',1,9501,978,NULL),(33,'La luna de Endor',1,4700,7581,NULL),(34,'Prueba',1,123,123,NULL),(35,'Lala',1,123,123,NULL),(36,'bebe',1,123,123,NULL),(37,'chacha',1,123,123,NULL),(38,'chache',1,123,123,NULL),(39,'Motorola',1,10002,20003,NULL);
/*!40000 ALTER TABLE `planeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raza`
--

DROP TABLE IF EXISTS `raza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raza` (
  `IdRaza` int NOT NULL AUTO_INCREMENT,
  `nombreRaza` varchar(45) NOT NULL,
  `nivelPeligro` int NOT NULL,
  PRIMARY KEY (`IdRaza`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raza`
--

LOCK TABLES `raza` WRITE;
/*!40000 ALTER TABLE `raza` DISABLE KEYS */;
INSERT INTO `raza` VALUES (1,'Humano',9);
/*!40000 ALTER TABLE `raza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resenia`
--

DROP TABLE IF EXISTS `resenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resenia` (
  `id_planeta` int NOT NULL,
  `dgu` int NOT NULL,
  `puntaje` int NOT NULL,
  `comentario` varchar(45) DEFAULT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id_planeta`,`dgu`),
  KEY `dgu_idx` (`dgu`),
  CONSTRAINT `dgu` FOREIGN KEY (`dgu`) REFERENCES `usuario` (`dgu`),
  CONSTRAINT `id_planeta` FOREIGN KEY (`id_planeta`) REFERENCES `planeta` (`id_planeta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resenia`
--

LOCK TABLES `resenia` WRITE;
/*!40000 ALTER TABLE `resenia` DISABLE KEYS */;
INSERT INTO `resenia` VALUES (1,35152603,2,'Prueba 2','2020-06-04'),(1,37336261,4,'Prueba','2020-06-03');
/*!40000 ALTER TABLE `resenia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `dgu` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `rol` int NOT NULL,
  `us_raza` int NOT NULL,
  PRIMARY KEY (`dgu`),
  KEY `us_raza_idx` (`us_raza`),
  CONSTRAINT `raza de usuario` FOREIGN KEY (`us_raza`) REFERENCES `raza` (`IdRaza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (35152603,'Estefani','Pardo','epardo','7581','tefy__04@hotmail.com',0,1),(37336261,'Elias','Bucci','ebucci','7581','buccielias@gmail.com',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaje` (
  `idviaje` int NOT NULL AUTO_INCREMENT,
  `salida` datetime NOT NULL,
  `llegada` datetime NOT NULL,
  `id_astrobus` int NOT NULL,
  `origen` int NOT NULL,
  `destino` int NOT NULL,
  PRIMARY KEY (`idviaje`),
  KEY `astrobus_idx` (`id_astrobus`),
  KEY `origen_idx` (`origen`),
  KEY `destino_idx` (`destino`),
  CONSTRAINT `astrobus` FOREIGN KEY (`id_astrobus`) REFERENCES `astrobus` (`IdAstrobus`),
  CONSTRAINT `destino` FOREIGN KEY (`destino`) REFERENCES `planeta` (`id_planeta`),
  CONSTRAINT `origen` FOREIGN KEY (`origen`) REFERENCES `planeta` (`id_planeta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
INSERT INTO `viaje` VALUES (1,'2020-06-11 00:00:00','2020-06-14 00:00:00',1,1,2);
/*!40000 ALTER TABLE `viaje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-29 20:24:45
