CREATE DATABASE  IF NOT EXISTS `cinema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cinema`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
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
-- Table structure for table `cinema_types`
--

DROP TABLE IF EXISTS `cinema_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinema_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema_types`
--

LOCK TABLES `cinema_types` WRITE;
/*!40000 ALTER TABLE `cinema_types` DISABLE KEYS */;
INSERT INTO `cinema_types` VALUES (1,'A'),(2,'B'),(3,'C'),(4,'D'),(5,'E');
/*!40000 ALTER TABLE `cinema_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinemas`
--

DROP TABLE IF EXISTS `cinemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinemas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `hallCount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `types_idx` (`type`),
  CONSTRAINT `types` FOREIGN KEY (`type`) REFERENCES `cinema_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinemas`
--

LOCK TABLES `cinemas` WRITE;
/*!40000 ALTER TABLE `cinemas` DISABLE KEYS */;
INSERT INTO `cinemas` VALUES (1,'Факел','ш. Энтузиастов, 15/16','+7 (495) 362 12 19',1,1000,7),(2,'Премьера ','Пионерская, 15, корп. 1','+7 (495) 526 36 36',2,750,3),(3,'Балтика','Сходненская, 56, ТРЦ «Калейдоскоп»','+7 (495) 775 77 79',2,700,5),(4,'Галерея Кино','просп. Ленина, 0/10, ТРЦ «Эльград»','+7 (496) 579 19 99',5,1500,10),(5,'Формула Кино Сити','Пресненская наб., 2, ТЦ «Афимолл-сити»','+7 800 250 80 25',4,700,5),(6,'Олимпик Синема','5-я Кабельная, 2, стр. 1,','+7 (495) 647 49 19',3,500,3),(7,'Искра','Костякова, 10 ','+7 (499) 976 14 44',2,750,5),(8,'Звезда','Земляной Вал, 18/22 ','+7 (495) 916 28 05',3,1000,10),(9,'Октябрь','Октябрьский просп., 198',' +7 (495) 554 20 96',2,800,6);
/*!40000 ALTER TABLE `cinemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'США'),(2,'Российская федерация');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directors`
--

DROP TABLE IF EXISTS `directors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `directors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directors`
--

LOCK TABLES `directors` WRITE;
/*!40000 ALTER TABLE `directors` DISABLE KEYS */;
INSERT INTO `directors` VALUES (1,'Джеймс Кэмерон'),(2,'Роберт Земекис'),(3,'Кристофер Нолан'),(4,'Даг Лайман'),(5,'Стивен Спилберг'),(6,'Джордж Лукас'),(7,'Ридли Скотт');
/*!40000 ALTER TABLE `directors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_themes`
--

DROP TABLE IF EXISTS `movie_themes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie_themes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_themes`
--

LOCK TABLES `movie_themes` WRITE;
/*!40000 ALTER TABLE `movie_themes` DISABLE KEYS */;
INSERT INTO `movie_themes` VALUES (1,'Фантастика'),(2,'Боевик'),(3,'Детектив'),(4,'Драма'),(5,'Комедия'),(6,'Триллер');
/*!40000 ALTER TABLE `movie_themes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `director` int(11) NOT NULL,
  `createdDate` datetime NOT NULL,
  `country` int(11) NOT NULL,
  `seriesCount` int(11) NOT NULL,
  `theme` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `director_idx` (`director`),
  KEY `country_idx` (`country`),
  KEY `theme_idx` (`theme`),
  CONSTRAINT `country` FOREIGN KEY (`country`) REFERENCES `countries` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `director` FOREIGN KEY (`director`) REFERENCES `directors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `theme` FOREIGN KEY (`theme`) REFERENCES `movie_themes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Терминатор 2',1,'1991-01-01 00:00:00',1,1,1),(2,'Чужие',1,'1986-01-01 00:00:00',1,1,1),(3,'Аватар',1,'2009-01-01 00:00:00',1,1,1),(4,'Назад в будущее 2 ',2,'2009-01-01 00:00:00',1,1,1),(5,'Начало',3,'2010-01-01 00:00:00',1,1,1),(6,'Назад в будущее',2,'1985-01-01 00:00:00',1,1,1),(7,'Терминатор',1,'1984-01-01 00:00:00',1,1,1),(8,'Назад в будущее 3',2,'1990-01-01 00:00:00',1,1,1),(9,'Парк Юрского периода',5,'1993-01-01 00:00:00',1,1,1),(10,'Интерстеллар',3,'2014-01-01 00:00:00',1,1,1),(11,'Звездные войны: Эпизод 3',6,'2005-01-01 00:00:00',1,1,1),(12,'Чужой',7,'1979-01-01 00:00:00',1,1,1);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shows`
--

DROP TABLE IF EXISTS `shows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shows` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema` int(11) NOT NULL,
  `movie` int(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `cinema_idx` (`cinema`),
  KEY `movie_idx` (`movie`),
  CONSTRAINT `cinema` FOREIGN KEY (`cinema`) REFERENCES `cinemas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `movie` FOREIGN KEY (`movie`) REFERENCES `movies` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shows`
--

LOCK TABLES `shows` WRITE;
/*!40000 ALTER TABLE `shows` DISABLE KEYS */;
INSERT INTO `shows` VALUES (1,1,1,'2017-01-10 16:30:00'),(2,2,2,'2017-01-11 17:45:00'),(3,3,3,'2017-01-15 18:40:00'),(4,4,4,'2017-01-17 15:30:00'),(5,1,3,'2017-02-11 16:35:00'),(6,1,2,'2017-02-15 13:45:00'),(7,1,2,'2017-02-10 13:40:00'),(8,1,1,'2017-03-20 17:30:00'),(10,3,3,'2017-04-14 17:35:00'),(11,5,4,'2017-04-15 17:30:00'),(12,6,7,'2017-04-15 19:45:00'),(13,6,6,'2017-04-21 17:10:00'),(14,2,8,'2017-01-05 19:35:00'),(15,3,2,'2017-05-16 16:35:00');
/*!40000 ALTER TABLE `shows` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-21 23:19:30
