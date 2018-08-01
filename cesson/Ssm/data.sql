/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.54 : Database - ssm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssm`;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`price`) values (1,'西瓜一点红1','33.00'),(2,'西瓜一点红','33.00'),(3,'西瓜一点红','33.00'),(4,'西瓜一点红','33.00'),(5,'西瓜一点红','33.00'),(6,'西瓜一点红6','33.00'),(7,'西瓜一点红','33.00'),(8,'西瓜一点红','33.00'),(9,'西瓜一点红','33.00'),(10,'西瓜一点红','33.00'),(11,'西瓜一点红11','33.00'),(12,'西瓜一点红','33.00'),(13,'西瓜一点红','33.00'),(14,'西瓜一点红','33.00'),(15,'西瓜一点红','33.00'),(16,'西瓜一点红16','33.00'),(17,'西瓜一点红','33.00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
