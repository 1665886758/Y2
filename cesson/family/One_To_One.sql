/*
SQLyog Ultimate v8.32 
MySQL - 5.5.20 : Database - family
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`family` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `family`;

/*Table structure for table `husband` */

DROP TABLE IF EXISTS `husband`;

CREATE TABLE `husband` (
  `husband_id` INT(4) NOT NULL AUTO_INCREMENT,
  `husband_name` VARCHAR(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wife_id` INT(4) DEFAULT NULL,
  PRIMARY KEY (`husband_id`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `husband` */

INSERT  INTO `husband`(`husband_id`,`husband_name`,`wife_id`) VALUES (1,'邓超',2),(2,'胡歌',NULL);

/*Table structure for table `husband_wife` */

DROP TABLE IF EXISTS `husband_wife`;

CREATE TABLE `husband_wife` (
  `id` INT(4) NOT NULL AUTO_INCREMENT,
  `husband_id` INT(4) DEFAULT NULL,
  `wife_id` INT(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `husband_wife` */

INSERT  INTO `husband_wife`(`id`,`husband_id`,`wife_id`) VALUES (1,1,1),(2,2,NULL);

/*Table structure for table `wife` */

DROP TABLE IF EXISTS `wife`;

CREATE TABLE `wife` (
  `wife_id` INT(4) NOT NULL AUTO_INCREMENT,
  `wife_name` VARCHAR(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `husband_id` INT(4) DEFAULT NULL,
  PRIMARY KEY (`wife_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO wife(wife_name,husband_id)VALUES('孙俪',1);

/*Data for the table `wife` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
SELECT *FROM wife;
SELECT *FROM husband_wife;
SELECT *FROM husband;
