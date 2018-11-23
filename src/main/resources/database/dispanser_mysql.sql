CREATE DATABASE  IF NOT EXISTS `dispanser` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dispanser`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dispanser
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
-- Table structure for table `diagnoses`
--

DROP TABLE IF EXISTS `diagnoses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnoses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor` int(11) NOT NULL,
  `patient` int(11) NOT NULL,
  `date` date NOT NULL,
  `disease` int(11) NOT NULL,
  `doc_comment` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `doc_idx` (`doctor`),
  KEY `patient_idx` (`patient`),
  KEY `disease_idx` (`disease`),
  CONSTRAINT `disease` FOREIGN KEY (`disease`) REFERENCES `diseases` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `doc` FOREIGN KEY (`doctor`) REFERENCES `doctors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patient` FOREIGN KEY (`patient`) REFERENCES `patients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnoses`
--

LOCK TABLES `diagnoses` WRITE;
/*!40000 ALTER TABLE `diagnoses` DISABLE KEYS */;
INSERT INTO `diagnoses` VALUES (1,5,1,'2020-01-20',3,'Усиление одышки, увеличение объема и гнойности мокроты.\\nУмеренная бронхообструкция (ОФВ1 і 50%), без сопутствующих заболеваний, редкие обострения (менее 4 раз в год)');
/*!40000 ALTER TABLE `diagnoses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diseases`
--

DROP TABLE IF EXISTS `diseases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diseases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `code` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diseases`
--

LOCK TABLES `diseases` WRITE;
/*!40000 ALTER TABLE `diseases` DISABLE KEYS */;
INSERT INTO `diseases` VALUES (1,'Ишемическая болезнь сердца','I25.5'),(2,'Геморрагический инсульт','I67 '),(3,'Инфекции нижних дыхательных путей','J06.0'),(4,'СПИД','B20'),(5,'Хроническая обструктивная болезнь легких','J60'),(6,'Туберкулез','A15'),(7,'Малярия','B50'),(8,'Рак легких','D02.2'),(9,'Гипертоническая болезнь','I13.0'),(10,'Рак желудка','C16.2');
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
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  `specialization` int(11) NOT NULL,
  `qualification` int(11) NOT NULL,
  `vacation` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `spec_idx` (`specialization`),
  KEY `qual_idx` (`qualification`),
  CONSTRAINT `qual` FOREIGN KEY (`qualification`) REFERENCES `doctors_qualification` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `spec` FOREIGN KEY (`specialization`) REFERENCES `doctors_specialization` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'Григорий ','Захарьин ','Антонович ',1,3,0),(2,'Николай ','Пирогов ','Иванович ',2,3,0),(3,'Николай ','Склифосовский ','Васильевич ',2,3,0),(4,'Сергей ','Боткин','Петрович ',1,2,0),(5,'Иван','Павлов','Петрович ',3,1,0),(6,'Сергей ','Юдин ','Сергеевич ',4,2,0),(7,'Владимир ','Филатов ','Петрович ',5,1,0),(8,'Гавриил ','Илизаров ','Абрамович ',6,3,1);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors_qualification`
--

DROP TABLE IF EXISTS `doctors_qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctors_qualification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors_qualification`
--

LOCK TABLES `doctors_qualification` WRITE;
/*!40000 ALTER TABLE `doctors_qualification` DISABLE KEYS */;
INSERT INTO `doctors_qualification` VALUES (1,'Первая категория'),(2,'Вторая категория'),(3,'Высшая категория');
/*!40000 ALTER TABLE `doctors_qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors_specialization`
--

DROP TABLE IF EXISTS `doctors_specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctors_specialization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors_specialization`
--

LOCK TABLES `doctors_specialization` WRITE;
/*!40000 ALTER TABLE `doctors_specialization` DISABLE KEYS */;
INSERT INTO `doctors_specialization` VALUES (1,'Терапевт'),(2,'Хирург'),(3,'Невролог'),(4,'Реаниматолог'),(5,'Травматолог'),(6,'Отоларинголог'),(7,'Ортопед-травматолог'),(8,'Кардиохирург'),(9,'Иммунолог'),(10,'Нейрохирург'),(11,'Уролог'),(12,'Инфекционист'),(13,'Аллерголог'),(14,'Анестезиолог'),(15,'Нарколог'),(16,'Стоматолог'),(17,'Онколог');
/*!40000 ALTER TABLE `doctors_specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `middleName` varchar(45) DEFAULT NULL,
  `birthDay` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `control` tinyint(4) NOT NULL,
  `card_number` varchar(10) DEFAULT NULL,
  `snils` varchar(14) DEFAULT NULL,
  `polis` varchar(13) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `male` tinyint(1) DEFAULT NULL,
  `workinfo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'Иван','Иванов','Иванович','2022-01-20','г. Пермь ул. Кировоградская, 37а-87',1,'H-23415','123-456-789 12','01 05 5421596','2386457',1,'ООО \"Рога и копыта\"'),(2,'Роман','Абакумов','Петрович','1988-03-15','г. Пермь, Кабельщиков, 12-59',1,'J-25698','029-280-798 11','01 05 9825879','2372544',1,'Пермский Краевой Совет Профсоюзов'),(3,'Олег','Лосев','Алексеевич','1975-09-23','г. Пермь, Цимлянская, 109-1',0,'A-12587','123-698-158 07','01 02 3589156','2684859',1,'Союз Архитектурных И Проектных Организаций Пермского Края, СРО'),(4,'Наталья','Ибрагимова','Сергеевна','2006-08-13','г. Пермь, Цветочная, 5-98',1,'K-13259','236-168-629 03','03 05 2568942','2154832',0,'Граф Орлов, агентство праздников'),(5,'Константин','Гаев','Семенович','1982-01-21','г. Персь, Ленина, 13А-11',1,'R-22236','158-228-698 02','03 58 6587912','2691543',1,'Филиал ООО «ЛУКОЙЛ-Инжиниринг» «ПермНИПИнефть»'),(6,'Татьяна','Ощепкова','Леонидовна','1961-05-24','г. Пермь, Менжинского, 53а-44',1,'Q-56987','123-589-125 09','01 02 6521441','2895603',0,'Портал Properm.ru'),(7,'Ольга','Некрасова','Леопольдовна','1957-12-11','г. Пермь, Некрасова, 65-79',1,'L-65876','128-569-136 17','08 05 2154321','2589651',0,'Справочник недвижимости и организаций в Перми и Пермском крае'),(8,'Екатерина','Пушкина','Яковлевна','1923-12-31','г. Пермь, Ктрова, 114-53',0,'T-23549','123-698-286 13','01 09 2154312','2478623',0,'Пенсионер'),(9,'Анфим','Елисеев','Немулеевич','1999-07-06','г. Пермь, Ленина, 102-2',1,'P-78965','123-147-258 01','01 09 2154138','2658924',1,'Всероссийское Общество Инвалидов, Орджоникидзевская Районная Организация Пермской Краевой'),(10,'Маркус','Гауф','Джонович','1983-05-05','г. Пермь, Пушкина, 8-12',1,'R-11111','128-298-658 19','01 02 2589631','2469852',1,'Пермское Религиозное Общество Мусульман При Соборной Мечети Города Перми'),(11,'Тимофей','Пастернак','Аристархович','1937-08-19','г. Пермь, Академика Королева, 15-103',1,'Q-69825','258-689-255 03','01 28 3556412','2348766',1,'Общественная Организация Ветеранов'),(12,'Анжела','Кошкина','Петровна','1970-12-23','г. Пермь, Карбышева, 86-111',0,'T-87915','123-478-125 17','04 18 2145525','2682565',0,'ВАСИЛЕК, Пермская общественная организация матерей детей-инвалидов'),(13,'Кира','Ромашкина','Александровна','1945-02-19','г. Пермь,Эксковаторная 100-1',0,'A-12589','123-698-568 01','13 25 0525810','2146589',0,'Пермский Дом Науки И Техники');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients_research`
--

DROP TABLE IF EXISTS `patients_research`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients_research` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient` int(11) NOT NULL,
  `doctor` int(11) NOT NULL,
  `research_ref` int(11) NOT NULL,
  `result` varchar(1000) NOT NULL,
  `res_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_idx` (`patient`),
  KEY `doctor_idx` (`doctor`),
  KEY `res_fk_idx` (`research_ref`),
  CONSTRAINT `doctor_fk` FOREIGN KEY (`doctor`) REFERENCES `doctors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patient_fk` FOREIGN KEY (`patient`) REFERENCES `patients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `res_fk` FOREIGN KEY (`research_ref`) REFERENCES `research` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients_research`
--

LOCK TABLES `patients_research` WRITE;
/*!40000 ALTER TABLE `patients_research` DISABLE KEYS */;
INSERT INTO `patients_research` VALUES (1,1,1,1,'Общий белок - 63-87 г/л\\nБелковые фракции: альбумины глобулины (α1, α2, β, γ) - 35-45 г/л 21,2-34,9 г/л\\nМочевина - 2,5-8,3 ммоль/л\\n','2016-05-12'),(2,1,2,2,'Заключение врача невролога','2016-05-12'),(3,1,3,4,'Результат ЭКГ','2016-05-12');
/*!40000 ALTER TABLE `patients_research` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research`
--

DROP TABLE IF EXISTS `research`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `research_type_fk_idx` (`type`),
  CONSTRAINT `research_type_fk` FOREIGN KEY (`type`) REFERENCES `research_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research`
--

LOCK TABLES `research` WRITE;
/*!40000 ALTER TABLE `research` DISABLE KEYS */;
INSERT INTO `research` VALUES (1,'Биохимический анализ крови',1),(2,'Осмотр врача-невролога профилактический',2),(3,'Осмотр врача общей практики',2),(4,'Электрокардиография ',3),(5,'СМАД',3),(6,'Спирографи',3),(7,'Электрокардиограмма ',3),(8,'Эхокардиография ',3),(9,'Ультразвуковое исследование сосудов',3),(10,'Электроэнцефалография',3),(11,'Клинический анализ крови ',1),(12,'Общий анализ мочи',1),(13,'Флюорография легких',3);
/*!40000 ALTER TABLE `research` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `research_type`
--

DROP TABLE IF EXISTS `research_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `research_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `research_type`
--

LOCK TABLES `research_type` WRITE;
/*!40000 ALTER TABLE `research_type` DISABLE KEYS */;
INSERT INTO `research_type` VALUES (1,'Лабораторное исследование'),(2,'Осмотр специалиста'),(3,'Функциональная диагностика');
/*!40000 ALTER TABLE `research_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheduler`
--

DROP TABLE IF EXISTS `scheduler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheduler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datetime` datetime NOT NULL,
  `doctorId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_ref_idx` (`patientId`),
  KEY `doctor_ref_idx` (`doctorId`),
  CONSTRAINT `doctor_ref` FOREIGN KEY (`doctorId`) REFERENCES `doctors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patient_ref` FOREIGN KEY (`patientId`) REFERENCES `patients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheduler`
--

LOCK TABLES `scheduler` WRITE;
/*!40000 ALTER TABLE `scheduler` DISABLE KEYS */;
INSERT INTO `scheduler` VALUES (1,'2017-01-10 16:30:00',1,1),(2,'2017-01-10 16:45:00',2,1),(3,'2017-01-10 17:30:00',2,2),(4,'2017-01-10 18:00:00',2,2),(5,'2017-01-10 18:45:00',2,3),(6,'2017-01-10 19:30:00',3,4),(7,'2017-01-11 09:30:00',4,5),(8,'2017-01-11 09:45:00',5,6),(9,'2017-01-11 09:20:00',6,7),(10,'2017-01-11 10:30:00',7,8),(11,'2017-01-11 11:30:00',4,9),(12,'2017-01-11 12:30:00',4,10),(13,'2017-01-11 12:45:00',5,2),(14,'2017-01-11 13:30:00',6,3),(15,'2017-01-11 13:50:00',7,4),(16,'2017-01-11 18:30:00',3,5),(17,'2017-01-11 15:45:00',2,6);
/*!40000 ALTER TABLE `scheduler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-17  0:39:05
