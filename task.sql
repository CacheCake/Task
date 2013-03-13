CREATE DATABASE  IF NOT EXISTS `task` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `task`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: task
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `tId` int(11) NOT NULL AUTO_INCREMENT,
  `tName` varchar(45) DEFAULT NULL,
  `tDescription` varchar(512) DEFAULT NULL,
  `tBeginDate` date DEFAULT NULL,
  `tEndDate` date DEFAULT NULL,
  `tRealBeginDate` date DEFAULT NULL,
  `tRealEndDate` date DEFAULT NULL,
  `tStatus` varchar(15) DEFAULT NULL,
  `user_uId` int(11) NOT NULL,
  `user_uMgr` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`tId`,`user_uId`),
  KEY `fk_task_user_idx` (`user_uId`),
  CONSTRAINT `fk_task_user` FOREIGN KEY (`user_uId`) REFERENCES `user` (`uId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'测试一','这是一个好玩又好看的任务，你可以跑，可以跳，可以上山下海。','2013-03-11','2013-03-15','2013-03-11','2013-03-15','未实施',1,'Tom'),(2,'测试一','这是一个好玩又好看的任务，你可以跑，可以跳，可以上山下海。Let s do it well!','2013-03-11','2013-03-15','2013-03-11','2013-03-15','已完成',1,'Tom'),(3,'测试一','这是一个好玩又好看的任务，你可以跑，可以跳，可以上山下海。Let s do it well!','2013-03-11','2013-03-15','2013-03-11','2013-03-15','实施中',2,'Tom'),(4,'测试一','这是一个好玩又好看的任务，你可以跑，可以跳，可以上山下海。Let s do it well!','2013-02-27','2013-03-22',NULL,NULL,'未实施',1,'Tom'),(5,'12341234','1234213432413413413241234123412343421','2013-02-28','2013-03-15',NULL,NULL,'未实施',1,'Tom'),(6,'qweqew','qweqeqweqwe','2013-03-22','2013-04-05',NULL,NULL,'未实施',1,'Tom');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan` (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `pName` varchar(45) DEFAULT NULL,
  `pDescription` varchar(512) DEFAULT NULL,
  `pBeginDate` date DEFAULT NULL,
  `pEndDate` date DEFAULT NULL,
  `pStatus` varchar(15) DEFAULT NULL,
  `pFeedback` int(11) DEFAULT '0',
  `pFeedbackMsg` varchar(256) DEFAULT NULL,
  `task_tId` int(11) NOT NULL,
  `user_uId` int(11) NOT NULL,
  PRIMARY KEY (`pId`,`task_tId`,`user_uId`),
  KEY `fk_plan_user1_idx` (`user_uId`),
  KEY `fk_plan_task1_idx` (`task_tId`),
  CONSTRAINT `fk_plan_task1` FOREIGN KEY (`task_tId`) REFERENCES `task` (`tId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_plan_user1` FOREIGN KEY (`user_uId`) REFERENCES `user` (`uId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,'111111','1111111','2013-02-06','2013-02-09','未完成',0,'eerqwe',2,3),(4,'42342','werrwerw','2013-03-07','2013-03-16','未实施',0,NULL,1,3),(5,'eqerqwe','dfaf','2013-03-14','2013-03-22','未实施',0,NULL,3,3),(6,'eqerqwe','dfaf','2013-03-14','2013-03-22','未实施',0,NULL,3,3),(7,'wqerq','qerqwer','2013-03-08','2013-03-30','未实施',0,NULL,1,3),(8,'wqerq','qerqwer','2013-03-08','2013-03-30','未实施',0,NULL,1,3),(9,'asda','asdasda','2013-03-07','2013-03-31','未实施',0,NULL,1,3);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `uName` varchar(45) DEFAULT NULL,
  `uPwd` varchar(45) DEFAULT NULL,
  `uGender` varchar(15) DEFAULT NULL,
  `uHireDate` varchar(45) DEFAULT NULL,
  `uRole` int(11) DEFAULT NULL,
  `uPosition` varchar(45) DEFAULT NULL,
  `uProfessional` varchar(45) DEFAULT NULL,
  `uExprience` varchar(45) DEFAULT NULL,
  `uBirthday` varchar(45) DEFAULT NULL,
  `uMgr` varchar(45) DEFAULT NULL,
  `uEducation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uId`),
  UNIQUE KEY `uId_UNIQUE` (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Cache','qwe',NULL,NULL,0,NULL,NULL,NULL,NULL,'Cache',NULL),(2,'cc','666666','男',NULL,2,'系统工程师','cc','cc',NULL,'Cache','cc'),(3,'Babala','666666','男',NULL,3,'视觉设计师','平面设计','shampoo UI',NULL,'Tom',''),(4,'Tom','666666','男',NULL,2,'产品经理','软件工程','豆瓣',NULL,'Cache','喜欢美女');
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

-- Dump completed on 2013-03-13 22:42:47
