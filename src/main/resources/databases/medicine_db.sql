CREATE DATABASE  IF NOT EXISTS `medicine` /*!40100 DEFAULT CHARACTER SET cp1251 */;
USE `medicine`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: medicine
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Temporary view structure for view `card_view`
--

DROP TABLE IF EXISTS `card_view`;
/*!50001 DROP VIEW IF EXISTS `card_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `card_view` AS SELECT 
 1 AS `pLastName`,
 1 AS `dLastName`,
 1 AS `title`,
 1 AS `visitDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `diagnosises`
--

DROP TABLE IF EXISTS `diagnosises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnosises` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diseaseId` int(11) NOT NULL,
  `visitId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `disease_idx` (`diseaseId`),
  KEY `visitId_idx` (`visitId`),
  CONSTRAINT `disease` FOREIGN KEY (`diseaseId`) REFERENCES `diseases` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `visitId` FOREIGN KEY (`visitId`) REFERENCES `visits` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnosises`
--

LOCK TABLES `diagnosises` WRITE;
/*!40000 ALTER TABLE `diagnosises` DISABLE KEYS */;
INSERT INTO `diagnosises` VALUES (1,1,72),(2,2,72),(3,3,73),(4,4,74),(5,1,74),(6,5,74),(7,6,75),(8,2,76),(9,9,77),(10,3,77),(11,10,78),(12,2,79),(13,5,80),(14,10,82),(15,9,81),(16,7,83),(17,7,84),(18,8,85);
/*!40000 ALTER TABLE `diagnosises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diseases`
--

DROP TABLE IF EXISTS `diseases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diseases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diseases`
--

LOCK TABLES `diseases` WRITE;
/*!40000 ALTER TABLE `diseases` DISABLE KEYS */;
INSERT INTO `diseases` VALUES (1,'Синдром «каменного человека»'),(2,'Прогрессивная липодистрофия'),(3,'Географический язык'),(4,'Гастрошизис'),(5,'Пигментная ксеродерма'),(6,'Мальформация Арнольда-Киари'),(7,'Очаговая алопеция'),(8,'Синдром нейл-пателла'),(9,'Наследственная сенсорная нейропатия '),(10,'Конгенитальная миотония');
/*!40000 ALTER TABLE `diseases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) CHARACTER SET utf8 NOT NULL,
  `specialization` varchar(45) CHARACTER SET utf8 NOT NULL,
  `qualification` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=cp1251;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'Абу Али ибн Сина','Остеопат','Вторая'),(2,'Агапов','Реаниматолог','Первая'),(3,'Альбрехт фон Галлер','Травматолог','Высшая'),(4,'Амосов','Отоларинголог','Первая'),(9,'Бильрот ','Ортопед-травматолог','Вторая'),(10,'Биша Мари-Франсуа Ксавье','Нейрохирург','Первая'),(11,'Метлицкий','Иммунолог','Высшая'),(12,'Попов','Уролог','Вторая'),(13,'Михельсон','Генетик','Первая'),(14,'Петтенкофер','Инфекционист','Высшая'),(15,'Корсаков','Аллерголог','Первая'),(16,'Криштаб','Анестезиолог','Высшая');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) NOT NULL,
  `birthDay` datetime NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'Пушкин','1799-01-01 00:00:00','г. Пермь, ул Ленина 1'),(2,'Лермонтов','1814-01-01 00:00:00','г. Пермь, ул Ленина 2'),(3,'Тютчев','1803-01-01 00:00:00','г. Пермь, ул Ленина 3'),(4,'Ахматова','1889-01-01 00:00:00','г. Пермь, ул Ленина 4'),(5,'Солженицын ','1918-01-01 00:00:00','г. Пермь, ул Ленина 5'),(6,'Цветаева','1892-01-01 00:00:00','г. Пермь, ул Ленина 6'),(7,'Толстой','1883-01-01 00:00:00','г. Пермь, ул Ленина 7'),(8,'Маршак','1887-01-01 00:00:00','г. Пермь, ул Ленина 8'),(9,'Вознесенский','1933-01-01 00:00:00','г. Пермь, ул Ленина 9');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visits`
--

DROP TABLE IF EXISTS `visits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patientId` int(11) NOT NULL,
  `doctorId` int(11) NOT NULL,
  `visitDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patientId_idx` (`patientId`),
  KEY `doctorId_idx` (`doctorId`),
  CONSTRAINT `doctorId` FOREIGN KEY (`doctorId`) REFERENCES `doctors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patientId` FOREIGN KEY (`patientId`) REFERENCES `patients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visits`
--

LOCK TABLES `visits` WRITE;
/*!40000 ALTER TABLE `visits` DISABLE KEYS */;
INSERT INTO `visits` VALUES (72,1,1,'2016-02-01 00:00:00'),(73,1,2,'2016-01-03 00:00:00'),(74,2,1,'2016-12-05 00:00:00'),(75,2,3,'2016-10-23 00:00:00'),(76,3,3,'2016-11-11 00:00:00'),(77,4,1,'2016-09-21 00:00:00'),(78,6,4,'2017-05-27 00:00:00'),(79,8,9,'2015-11-21 00:00:00'),(80,9,10,'2016-03-17 00:00:00'),(81,1,11,'2016-07-21 00:00:00'),(82,3,12,'2016-08-07 00:00:00'),(83,3,14,'2016-07-10 00:00:00'),(84,5,15,'2015-11-09 00:00:00'),(85,6,16,'2017-02-12 00:00:00');
/*!40000 ALTER TABLE `visits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `card_view`
--

/*!50001 DROP VIEW IF EXISTS `card_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `card_view` AS select `p`.`lastName` AS `pLastName`,`doc`.`lastName` AS `dLastName`,`ds`.`title` AS `title`,`v`.`visitDate` AS `visitDate` from ((((`diagnosises` `dg` join `diseases` `ds` on((`dg`.`diseaseId` = `ds`.`id`))) join `visits` `v` on((`dg`.`visitId` = `v`.`id`))) join `doctors` `doc` on((`v`.`doctorId` = `doc`.`id`))) join `patients` `p` on((`v`.`patientId` = `p`.`id`))) order by `v`.`visitDate` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-21 23:19:05
