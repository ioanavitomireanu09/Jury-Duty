-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: jury
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `password` varchar(256) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='list of users';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ORG','Test','Test','$2a$10$GlOxD6XQxvnRwP5U/8iK6eBOGxgFEmsBk4OVV30oqIUdshDGu.si2','test'),(2,'0','Admin','Admin','$2a$10$K5XNLRUyuczZcaPTCtFPiepneW0qAI2HJVUcX6CUQTCyodv.IVZka','admin'),(3,'0','Admin1','Admin1','$2a$10$s5opygMbct26Z14iNY55/ewhhTOnbmMvZN9C59hSaN.lfajKOs0lK','admin1'),(4,'0','Organizator','Test','$2a$10$roLmRhOU8jfHpFw8l5U2C.R.N1YXPRWWgqRO8Yoc.QYc/yYyB80Lu','organizator'),(5,'0','Organizator','Test2','$2a$10$PxuJFOflrxYYIPdNocR0cuMKAyC0rrUcdhnKsJ2FjB6ir.x7ALe1i','organizator1'),(6,'0','Scinteie','Sebastian','$2a$10$JkrVrOCDu.1i5aXyPuQ9KOi2uMUDZSozEtxOmypnMnQrIQA5KZqcW','sebastian'),(7,'0','Scinteie','Sebastian','$2a$10$8KgcJUpDlMUMyDuAypaOme1qFyc/9QHWzL14/cZPjs.U.oc5ZdirO','sebastian1'),(8,'5','Scinteie','Sebastian','sebastian1','sebastian5');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-28 23:25:13
