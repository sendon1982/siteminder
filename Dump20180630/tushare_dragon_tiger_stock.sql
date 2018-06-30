-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: tushare
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu18.04.1

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
-- Table structure for table `dragon_tiger_stock`
--

DROP TABLE IF EXISTS `dragon_tiger_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dragon_tiger_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pchange` decimal(30,4) DEFAULT NULL,
  `amount` decimal(30,2) DEFAULT NULL,
  `buy` decimal(30,2) DEFAULT NULL,
  `sell` decimal(30,2) DEFAULT NULL,
  `reason` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `bratio` decimal(15,2) DEFAULT NULL,
  `sratio` decimal(15,2) DEFAULT NULL,
  `ts_date` date DEFAULT NULL,
  `broker` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `count` bigint(20) DEFAULT NULL,
  `probability` decimal(15,2) DEFAULT NULL,
  `broker_buy` decimal(30,2) DEFAULT NULL,
  `broker_buy_prop` decimal(15,2) DEFAULT NULL,
  `broker_sell` decimal(30,2) DEFAULT NULL,
  `broker_sell_prop` decimal(15,2) DEFAULT NULL,
  `net` decimal(30,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index` (`code`,`ts_date`,`broker`,`reason`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dragon_tiger_stock`
--

LOCK TABLES `dragon_tiger_stock` WRITE;
/*!40000 ALTER TABLE `dragon_tiger_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `dragon_tiger_stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-30 17:36:21
