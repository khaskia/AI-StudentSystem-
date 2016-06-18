-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: stu
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `class` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `degree` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'mohamed khaskia','16','20 st alead','0145877485','1/4','khaskia@khaskia.com','80'),(2,'ahmed kamal','17','21 st elsalam','01256955845','2/1','kamal@gmail.com','65'),(3,'amal mahmoud','16','33 st sl55','012755555','1/6','amal@amal.com','68'),(4,'ibraheem ali','16','33 st slkdf ','01276399758','1/2','ibraheem@gmail.com','91'),(5,'Eslam ibraheem','18','22 st slkm','01265899585','1/3','eslam@gmai.com','84'),(6,'mohamed mahmoud','16','33 st slksdf','0127588965','1/5','mohamedmahmoud14@gmail.com','74'),(8,'amr kamal','17','15 st kjnooo','0127548896','2/2','amr@gmail.com','82'),(9,'khaled gamal','17','36 st jnino','01276588458','2/5','khaled@gmail.co','74'),(10,'Mustafa ali','17','22 st lknio','01111111111','2/1','mustafa@kksdf.com','45'),(11,'amira ahmed','18','33 st 55sdf','0127588569','3/5','amira@yahoo.com','60'),(12,'omnia gamal','18','22st skdmf','0145844758','3/1','omnia@gamil.com','54'),(15,'tarek soubhi','17','22 st sdfi ','0125486665','2/2','tarem@gmail.com','58'),(20,'petter petter','18','12 st kjsfdn','01274588956','3/5','petter@yahoo.com','57'),(30,'nader ali','16','32 st sdk;fm','01274455896','1/2','nader@gmail.com','77'),(31,'nermeen mahmoud','16','32 st sdk;fm','0136655476','1/1','nermeen@gmail.com','23');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-18  4:14:52
