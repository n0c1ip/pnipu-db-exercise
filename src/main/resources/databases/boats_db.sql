CREATE DATABASE  IF NOT EXISTS `boats` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `boats`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: boats
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
-- Table structure for table `briefing`
--

DROP TABLE IF EXISTS `briefing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `briefing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `position` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `type_idx` (`type`),
  CONSTRAINT `briefType` FOREIGN KEY (`type`) REFERENCES `briefing_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `briefing`
--

LOCK TABLES `briefing` WRITE;
/*!40000 ALTER TABLE `briefing` DISABLE KEYS */;
INSERT INTO `briefing` VALUES (1,1,'2016-12-05 12:30:00','Петров','инструктор'),(2,2,'2016-12-05 10:00:00','Иванов','главный инструктор'),(3,3,'2016-12-05 13:10:00','Сидоров','супер инструктор');
/*!40000 ALTER TABLE `briefing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `briefing_type`
--

DROP TABLE IF EXISTS `briefing_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `briefing_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `briefing_type`
--

LOCK TABLES `briefing_type` WRITE;
/*!40000 ALTER TABLE `briefing_type` DISABLE KEYS */;
INSERT INTO `briefing_type` VALUES (1,'вводный'),(2,'первичный'),(3,'повторный');
/*!40000 ALTER TABLE `briefing_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `passport` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `passport_idx` (`passport`),
  CONSTRAINT `passport` FOREIGN KEY (`passport`) REFERENCES `passports` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Пупкин','Ленина д. 1 кв. 5',1),(2,'Иванов','Ленина д. 1 кв. 6',2),(3,'Петров','Ленина д. 1 кв. 7',3),(4,'Сидоров','Ленина д. 1 кв. 8',4);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dangers`
--

DROP TABLE IF EXISTS `dangers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dangers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `water` int(11) NOT NULL,
  `transport_type` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `iddangers_UNIQUE` (`id`),
  KEY `water_idx` (`water`),
  KEY `transport_type_idx` (`transport_type`),
  CONSTRAINT `transport_type` FOREIGN KEY (`transport_type`) REFERENCES `transport_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `water` FOREIGN KEY (`water`) REFERENCES `water` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dangers`
--

LOCK TABLES `dangers` WRITE;
/*!40000 ALTER TABLE `dangers` DISABLE KEYS */;
INSERT INTO `dangers` VALUES (1,1,1,1),(2,1,2,5),(3,1,3,3),(4,1,4,2),(5,1,5,1),(6,1,6,2),(7,2,1,3),(8,2,2,5),(9,2,3,2),(10,2,4,1),(11,2,6,3),(12,3,1,4),(13,3,2,4),(14,3,3,2),(15,3,4,1),(16,3,5,5),(17,3,6,5);
/*!40000 ALTER TABLE `dangers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passports`
--

DROP TABLE IF EXISTS `passports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `series` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `created` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passports`
--

LOCK TABLES `passports` WRITE;
/*!40000 ALTER TABLE `passports` DISABLE KEYS */;
INSERT INTO `passports` VALUES (1,5152,555252,'Выдан 21.03.1999'),(2,5251,552342,'Выдан 23.05.2013'),(3,3242,342352,'Выдан 13.12.2003'),(4,1234,552111,'Выдан 20.07.2005');
/*!40000 ALTER TABLE `passports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` int(11) NOT NULL,
  `transport` int(11) NOT NULL,
  `water` int(11) NOT NULL,
  `rented_at` datetime NOT NULL,
  `rented_to` datetime NOT NULL,
  `briefing` int(11) DEFAULT NULL,
  `briefing_done` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `client_idx` (`client`),
  KEY `transport_idx` (`transport`),
  KEY `water_idx` (`water`),
  KEY `client_idx2` (`client`),
  KEY `transport_idx2` (`transport`),
  KEY `water_idx2` (`water`),
  KEY `briefingId_idx` (`briefing`),
  CONSTRAINT `briefingId` FOREIGN KEY (`briefing`) REFERENCES `briefing` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `clientId` FOREIGN KEY (`client`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transportsId` FOREIGN KEY (`transport`) REFERENCES `transports` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `waterId` FOREIGN KEY (`water`) REFERENCES `water` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
INSERT INTO `rent` VALUES (8,1,4,1,'2016-12-05 12:30:00','2016-12-05 18:30:00',2,1),(9,2,5,1,'2016-12-06 10:00:00','2016-12-06 12:30:00',2,1),(10,3,9,2,'2016-12-07 10:30:00','2016-12-08 10:30:00',3,1),(11,4,1,3,'2016-12-07 11:30:00','2016-12-10 11:30:00',1,1);
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_eq_ref`
--

DROP TABLE IF EXISTS `transport_eq_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport_eq_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transportId` int(11) NOT NULL,
  `equipmentId` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `transportId_idx` (`transportId`),
  KEY `equipmentId_idx` (`equipmentId`),
  CONSTRAINT `equipmentId` FOREIGN KEY (`equipmentId`) REFERENCES `transport_equipment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transportId` FOREIGN KEY (`transportId`) REFERENCES `transports` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_eq_ref`
--

LOCK TABLES `transport_eq_ref` WRITE;
/*!40000 ALTER TABLE `transport_eq_ref` DISABLE KEYS */;
INSERT INTO `transport_eq_ref` VALUES (1,1,2,2),(2,1,3,1),(3,2,2,2),(4,2,3,1),(5,3,2,5),(6,4,2,5),(7,3,4,1),(8,4,4,1);
/*!40000 ALTER TABLE `transport_eq_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_equipment`
--

DROP TABLE IF EXISTS `transport_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport_equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_equipment`
--

LOCK TABLES `transport_equipment` WRITE;
/*!40000 ALTER TABLE `transport_equipment` DISABLE KEYS */;
INSERT INTO `transport_equipment` VALUES (1,'спасательная лодка'),(2,'спасательный жилет'),(3,'спасательный круг'),(4,'сигнальная ракета');
/*!40000 ALTER TABLE `transport_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_states`
--

DROP TABLE IF EXISTS `transport_states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport_states` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_states`
--

LOCK TABLES `transport_states` WRITE;
/*!40000 ALTER TABLE `transport_states` DISABLE KEYS */;
INSERT INTO `transport_states` VALUES (1,'в ремонте'),(2,'списано'),(3,'исправно');
/*!40000 ALTER TABLE `transport_states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_types`
--

DROP TABLE IF EXISTS `transport_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_types`
--

LOCK TABLES `transport_types` WRITE;
/*!40000 ALTER TABLE `transport_types` DISABLE KEYS */;
INSERT INTO `transport_types` VALUES (1,'Катер'),(2,'Лодка'),(3,'Катамаран'),(4,'Байдарка'),(5,'Водные лыжи'),(6,'Линкор');
/*!40000 ALTER TABLE `transport_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transports`
--

DROP TABLE IF EXISTS `transports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `number` varchar(45) NOT NULL,
  `state` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `availability` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `transportType_idx` (`type`),
  KEY `transportState_idx` (`state`),
  CONSTRAINT `transportState` FOREIGN KEY (`state`) REFERENCES `transport_states` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transportType` FOREIGN KEY (`type`) REFERENCES `transport_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transports`
--

LOCK TABLES `transports` WRITE;
/*!40000 ALTER TABLE `transports` DISABLE KEYS */;
INSERT INTO `transports` VALUES (1,'Лодка №1','Л-1',3,2,1),(2,'Лодка №2','Л-2',3,2,0),(3,'Катер №1','К-1',2,1,0),(4,'Катер №2','К-2',3,1,1),(5,'Катамаран №1','КТ-1',3,3,1),(6,'Катамаран №2','КТ-2',3,3,0),(7,'Байдарка №1','Б-1',2,4,0),(8,'Байдарка №2','Б-2',1,4,0),(9,'Водные лыжи','ВЛ-1',3,5,1),(10,'Линкор','ЛК-1',3,6,0);
/*!40000 ALTER TABLE `transports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_rent`
--

DROP TABLE IF EXISTS `v_rent`;
/*!50001 DROP VIEW IF EXISTS `v_rent`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_rent` AS SELECT 
 1 AS `client`,
 1 AS `title`,
 1 AS `type`,
 1 AS `water`,
 1 AS `rented_at`,
 1 AS `rented_to`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_transport`
--

DROP TABLE IF EXISTS `v_transport`;
/*!50001 DROP VIEW IF EXISTS `v_transport`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_transport` AS SELECT 
 1 AS `title`,
 1 AS `number`,
 1 AS `State`,
 1 AS `Type`,
 1 AS `availability`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `water`
--

DROP TABLE IF EXISTS `water`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `water` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `wate_type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `type_idx` (`wate_type`),
  CONSTRAINT `type` FOREIGN KEY (`wate_type`) REFERENCES `water_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `water`
--

LOCK TABLES `water` WRITE;
/*!40000 ALTER TABLE `water` DISABLE KEYS */;
INSERT INTO `water` VALUES (1,'Кама',1),(2,'Озерное озеро',2),(3,'Прудный пруд',3);
/*!40000 ALTER TABLE `water` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `water_type`
--

DROP TABLE IF EXISTS `water_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `water_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `water_type`
--

LOCK TABLES `water_type` WRITE;
/*!40000 ALTER TABLE `water_type` DISABLE KEYS */;
INSERT INTO `water_type` VALUES (1,'Река'),(2,'Озеро'),(3,'Пруд');
/*!40000 ALTER TABLE `water_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `v_rent`
--

/*!50001 DROP VIEW IF EXISTS `v_rent`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_rent` AS select `c`.`lastName` AS `client`,`t`.`title` AS `title`,`tt`.`title` AS `type`,`w`.`title` AS `water`,`rent`.`rented_at` AS `rented_at`,`rent`.`rented_to` AS `rented_to` from ((((`rent` join `client` `c` on((`rent`.`client` = `c`.`id`))) join `transports` `t` on((`rent`.`transport` = `t`.`id`))) join `transport_types` `tt` on((`t`.`type` = `tt`.`id`))) join `water` `w` on((`rent`.`water` = `w`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_transport`
--

/*!50001 DROP VIEW IF EXISTS `v_transport`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_transport` AS select `transports`.`title` AS `title`,`transports`.`number` AS `number`,`ts`.`title` AS `State`,`tt`.`title` AS `Type`,`transports`.`availability` AS `availability` from ((`transports` join `transport_states` `ts` on((`transports`.`state` = `ts`.`id`))) join `transport_types` `tt` on((`transports`.`type` = `tt`.`id`))) */;
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

-- Dump completed on 2016-12-21 23:18:08
