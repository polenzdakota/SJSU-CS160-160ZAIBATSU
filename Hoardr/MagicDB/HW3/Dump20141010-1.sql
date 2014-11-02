CREATE DATABASE  IF NOT EXISTS `magicdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `magicdb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: magicdb
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `collection1`
--

DROP TABLE IF EXISTS `collection1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collection1` (
  `ENTRY` int(11) NOT NULL AUTO_INCREMENT,
  `LIBRARY_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`ENTRY`),
  KEY `LIBRARY_ID` (`LIBRARY_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `collection1_ibfk_1` FOREIGN KEY (`LIBRARY_ID`) REFERENCES `library` (`LIBRARY_ID`),
  CONSTRAINT `collection1_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection1`
--

LOCK TABLES `collection1` WRITE;
/*!40000 ALTER TABLE `collection1` DISABLE KEYS */;
INSERT INTO `collection1` VALUES (51,123,1),(52,123,1),(53,123,1),(54,444,1),(55,223,1);
/*!40000 ALTER TABLE `collection1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deck`
--

DROP TABLE IF EXISTS `deck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deck` (
  `DECK_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `COLLECTION_ID` int(11) NOT NULL,
  PRIMARY KEY (`DECK_ID`),
  KEY `COLLECTION_ID` (`COLLECTION_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `deck_ibfk_1` FOREIGN KEY (`COLLECTION_ID`) REFERENCES `collection1` (`LIBRARY_ID`),
  CONSTRAINT `deck_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deck`
--

LOCK TABLES `deck` WRITE;
/*!40000 ALTER TABLE `deck` DISABLE KEYS */;
INSERT INTO `deck` VALUES (20,1,123),(21,1,223);
/*!40000 ALTER TABLE `deck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `library`
--

DROP TABLE IF EXISTS `library`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `library` (
  `LIBRARY_ID` int(11) NOT NULL,
  `Card_Name` varchar(255) NOT NULL,
  `Ability` varchar(255) NOT NULL,
  `Type_` varchar(255) NOT NULL,
  `Cost` varchar(255) NOT NULL,
  PRIMARY KEY (`LIBRARY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `library`
--

LOCK TABLES `library` WRITE;
/*!40000 ALTER TABLE `library` DISABLE KEYS */;
INSERT INTO `library` VALUES (123,'Abzan Banner','When Abzan Ascendancy enters the battlefield, put a +1/+1 counter on each creature you control.Whenever','Instant','5'),(223,'Shatters','When Abzan Ascendancy enters the battlefield, put a +1/+1 counter on each creature you control.Whenever','Instant','5'),(333,'DakotaTron','You win','Instant','500'),(444,'Hooters','testing field','Instant','5'),(555,'Abzan Ascendancy','When Abzan Ascendancy enters the battlefield,','Enchantment','5'),(666,'Crippling Chilld','ature token with flying onto the battlefield.','Enchantment','5'),(999,'Throttle','When Abzan Ascendancy enters the battlefield, put a +1/+1 counter on each creature you control.Whenever','Instant','5');
/*!40000 ALTER TABLE `library` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Chris is dumb','485414856\r'),(2,'Dakota','fasdjk;fasj;');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-10 11:24:12
