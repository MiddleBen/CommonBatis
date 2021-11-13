/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.25a : Database - jpet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jpet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jpet`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `userid` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `firstname` varchar(80) NOT NULL,
  `lastname` varchar(80) NOT NULL,
  `status` varchar(2) DEFAULT NULL,
  `addr1` varchar(80) NOT NULL,
  `addr2` varchar(40) DEFAULT NULL,
  `city` varchar(80) NOT NULL,
  `state` varchar(80) NOT NULL,
  `zip` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `phone` varchar(80) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`userid`,`email`,`firstname`,`lastname`,`status`,`addr1`,`addr2`,`city`,`state`,`zip`,`country`,`phone`) values ('ACID','acid@yourdomain.com','ABC','XYX','OK','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','555-555-5555'),('j2ee','yourname@yourdomain.com','ABC','XYX','OK','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','555-555-5555');

/*Table structure for table `bannerdata` */

DROP TABLE IF EXISTS `bannerdata`;

CREATE TABLE `bannerdata` (
  `favcategory` varchar(80) NOT NULL,
  `bannername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`favcategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bannerdata` */

insert  into `bannerdata`(`favcategory`,`bannername`) values ('BIRDS','<image src=\"../images/banner_birds.gif\">'),('CATS','<image src=\"../images/banner_cats.gif\">'),('DOGS','<image src=\"../images/banner_dogs.gif\">'),('FISH','<image src=\"../images/banner_fish.gif\">'),('REPTILES','<image src=\"../images/banner_reptiles.gif\">');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `catid` varchar(10) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `descn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`catid`,`name`,`descn`) values ('BIRDS','Birds','<image src=\"../images/birds_icon.gif\"><font size=\"5\" color=\"blue\"> Birds</font>'),('CATS','Cats','<image src=\"../images/cats_icon.gif\"><font size=\"5\" color=\"blue\"> Cats</font>'),('DOGS','Dogs','<image src=\"../images/dogs_icon.gif\"><font size=\"5\" color=\"blue\"> Dogs</font>'),('FISH','Fish','<image src=\"../images/fish_icon.gif\"><font size=\"5\" color=\"blue\"> Fish</font>'),('REPTILES','Reptiles','<image src=\"../images/reptiles_icon.gif\"><font size=\"5\" color=\"blue\"> Reptiles</font>');

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `itemid` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `inventory` */

insert  into `inventory`(`itemid`,`qty`) values ('EST-1',10000),('EST-10',10000),('EST-11',10000),('EST-12',9999),('EST-13',9989),('EST-14',9999),('EST-15',10000),('EST-16',9999),('EST-17',10000),('EST-18',10000),('EST-19',10000),('EST-2',10000),('EST-20',10000),('EST-21',10000),('EST-22',10000),('EST-23',10000),('EST-24',10000),('EST-25',10000),('EST-26',9998),('EST-27',10000),('EST-28',10000),('EST-3',10000),('EST-4',9997),('EST-5',10000),('EST-6',10000),('EST-7',9999),('EST-8',10000),('EST-9',10000);

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `itemid` varchar(10) NOT NULL,
  `productid` varchar(10) NOT NULL,
  `listprice` decimal(10,2) DEFAULT NULL,
  `unitcost` decimal(10,2) DEFAULT NULL,
  `supplier` int(11) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `attr1` varchar(80) DEFAULT NULL,
  `attr2` varchar(80) DEFAULT NULL,
  `attr3` varchar(80) DEFAULT NULL,
  `attr4` varchar(80) DEFAULT NULL,
  `attr5` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `fk_item_2` (`supplier`),
  KEY `itemProd` (`productid`),
  CONSTRAINT `fk_item_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `fk_item_2` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`suppid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`itemid`,`productid`,`listprice`,`unitcost`,`supplier`,`status`,`attr1`,`attr2`,`attr3`,`attr4`,`attr5`) values ('EST-1','FI-SW-01','16.50','10.00',1,'P','Large',NULL,NULL,NULL,NULL),('EST-10','K9-DL-01','18.50','12.00',1,'P','Spotted Adult Female',NULL,NULL,NULL,NULL),('EST-11','RP-SN-01','18.50','12.00',1,'P','Venomless',NULL,NULL,NULL,NULL),('EST-12','RP-SN-01','18.50','12.00',1,'P','Rattleless',NULL,NULL,NULL,NULL),('EST-13','RP-LI-02','18.50','12.00',1,'P','Green Adult',NULL,NULL,NULL,NULL),('EST-14','FL-DSH-01','58.50','12.00',1,'P','Tailless',NULL,NULL,NULL,NULL),('EST-15','FL-DSH-01','23.50','12.00',1,'P','With tail',NULL,NULL,NULL,NULL),('EST-16','FL-DLH-02','93.50','12.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-17','FL-DLH-02','93.50','12.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-18','AV-CB-01','193.50','92.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-19','AV-SB-02','15.50','2.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-2','FI-SW-01','16.50','10.00',1,'P','Small',NULL,NULL,NULL,NULL),('EST-20','FI-FW-02','5.50','2.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-21','FI-FW-02','5.29','1.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-22','K9-RT-02','135.50','100.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-23','K9-RT-02','145.49','100.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-24','K9-RT-02','255.50','92.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-25','K9-RT-02','325.29','90.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-26','K9-CW-01','125.50','92.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-27','K9-CW-01','155.29','90.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-28','K9-RT-01','155.29','90.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-3','FI-SW-02','18.50','12.00',1,'P','Toothless',NULL,NULL,NULL,NULL),('EST-4','FI-FW-01','18.50','12.00',1,'P','Spotted',NULL,NULL,NULL,NULL),('EST-5','FI-FW-01','18.50','12.00',1,'P','Spotless',NULL,NULL,NULL,NULL),('EST-6','K9-BD-01','18.50','12.00',1,'P','Male Adult',NULL,NULL,NULL,NULL),('EST-7','K9-BD-01','18.50','12.00',1,'P','Female Puppy',NULL,NULL,NULL,NULL),('EST-8','K9-PO-02','18.50','12.00',1,'P','Male Puppy',NULL,NULL,NULL,NULL),('EST-9','K9-DL-01','18.50','12.00',1,'P','Spotless Male Puppy',NULL,NULL,NULL,NULL);

/*Table structure for table `lineitem` */

DROP TABLE IF EXISTS `lineitem`;

CREATE TABLE `lineitem` (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `itemid` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitprice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`orderid`,`linenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lineitem` */

insert  into `lineitem`(`orderid`,`linenum`,`itemid`,`quantity`,`unitprice`) values (1,2,'11555551',3,'4.00'),(1,23,'11555551',3,'3.00'),(22,2,'1111111',122,'111.00'),(52,51,'54',53,'55.00'),(223,2223,'1003',1223,'1113.00'),(1002,2,'1111111',1,'18.50'),(1008,2,'1111111',1,'58.50'),(1008,3,'EST-16',1,'93.50');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL,
  `userid` varchar(80) NOT NULL,
  `orderdate` date NOT NULL,
  `shipaddr1` varchar(80) NOT NULL,
  `shipaddr2` varchar(80) DEFAULT NULL,
  `shipcity` varchar(80) NOT NULL,
  `shipstate` varchar(80) NOT NULL,
  `shipzip` varchar(20) NOT NULL,
  `shipcountry` varchar(20) NOT NULL,
  `billaddr1` varchar(80) NOT NULL,
  `billaddr2` varchar(80) DEFAULT NULL,
  `billcity` varchar(80) NOT NULL,
  `billstate` varchar(80) NOT NULL,
  `billzip` varchar(20) NOT NULL,
  `billcountry` varchar(20) NOT NULL,
  `courier` varchar(80) NOT NULL,
  `totalprice` decimal(10,2) NOT NULL,
  `billtofirstname` varchar(80) NOT NULL,
  `billtolastname` varchar(80) NOT NULL,
  `shiptofirstname` varchar(80) NOT NULL,
  `shiptolastname` varchar(80) NOT NULL,
  `creditcard` varchar(80) NOT NULL,
  `exprdate` varchar(7) NOT NULL,
  `cardtype` varchar(80) NOT NULL,
  `locale` varchar(80) NOT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`orderid`,`userid`,`orderdate`,`shipaddr1`,`shipaddr2`,`shipcity`,`shipstate`,`shipzip`,`shipcountry`,`billaddr1`,`billaddr2`,`billcity`,`billstate`,`billzip`,`billcountry`,`courier`,`totalprice`,`billtofirstname`,`billtolastname`,`shiptofirstname`,`shiptolastname`,`creditcard`,`exprdate`,`cardtype`,`locale`) values (1000,'j2ee','2014-05-05','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','37.00','ABC','XYX','ABC','XYX','999 9999 9999 9999','12/03','Visa','CA'),(1001,'j2ee','2014-05-05','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','37.00','ABC','XYX','ABC','XYX','999 9999 9999 9999','12/03','Visa','CA'),(1002,'j2ee','2014-05-05','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','144.00','ABC','XYX','ABC','XYX','999 9999 9999 9999','12/03','Visa','CA'),(1004,'j2ee','2014-05-05','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','37.00','ABC','XYX','ABC','XYX','999 9999 9999 9999','12/03','Visa','CA'),(1006,'j2ee','2014-05-05','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','55.50','ABC','XYX','ABC','XYX','999 9999 9999 9999','12/03','Visa','CA'),(1007,'j2ee','2014-05-05','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','55.50','ABC','XYX','ABC','XYX','999 9999 9999 9999','12/03','Visa','CA'),(1008,'j2ee','2014-05-05','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','277.50','ABC','XYX','ABC','XYX','999 9999 9999 9999','12/03','Visa','CA');

/*Table structure for table `orderstatus` */

DROP TABLE IF EXISTS `orderstatus`;

CREATE TABLE `orderstatus` (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `timestamp` date NOT NULL,
  `status` varchar(2) NOT NULL,
  PRIMARY KEY (`orderid`,`linenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderstatus` */

insert  into `orderstatus`(`orderid`,`linenum`,`timestamp`,`status`) values (0,0,'2014-05-10','1'),(1000,1000,'2014-05-05','P'),(1001,1001,'2014-05-05','P'),(1002,1002,'2014-05-05','P'),(1004,1004,'2014-05-05','P'),(1006,1006,'2014-05-05','P'),(1007,1007,'2014-05-05','P'),(1008,1008,'2014-05-05','P');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `productid` varchar(10) NOT NULL,
  `category` varchar(10) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `descn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productid`),
  KEY `productCat` (`category`),
  KEY `productName` (`name`),
  CONSTRAINT `fk_product_1` FOREIGN KEY (`category`) REFERENCES `category` (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`productid`,`category`,`name`,`descn`) values ('AV-CB-01','BIRDS','Amazon Parrot','<image src=\"../images/bird2.gif\">Great companion for up to 75 years'),('AV-SB-02','BIRDS','Finch','<image src=\"../images/bird1.gif\">Great stress reliever'),('FI-FW-01','FISH','Koi','<image src=\"../images/fish3.gif\">Fresh Water fish from Japan'),('FI-FW-02','FISH','Goldfish','<image src=\"../images/fish2.gif\">Fresh Water fish from China'),('FI-SW-01','FISH','Angelfish','<image src=\"../images/fish1.gif\">Salt Water fish from Australia'),('FI-SW-02','FISH','Tiger Shark','<image src=\"../images/fish4.gif\">Salt Water fish from Australia'),('FL-DLH-02','CATS','Persian','<image src=\"../images/cat1.gif\">Friendly house cat, doubles as a princess'),('FL-DSH-01','CATS','Manx','<image src=\"../images/cat2.gif\">Great for reducing mouse populations'),('K9-BD-01','DOGS','Bulldog','<image src=\"../images/dog2.gif\">Friendly dog from England'),('K9-CW-01','DOGS','Chihuahua','<image src=\"../images/dog4.gif\">Great companion dog'),('K9-DL-01','DOGS','Dalmation','<image src=\"../images/dog5.gif\">Great dog for a Fire Station'),('K9-PO-02','DOGS','Poodle','<image src=\"../images/dog6.gif\">Cute dog from France'),('K9-RT-01','DOGS','Golden Retriever','<image src=\"../images/dog1.gif\">Great family dog'),('K9-RT-02','DOGS','Labrador Retriever','<image src=\"../images/dog5.gif\">Great hunting dog'),('RP-LI-02','REPTILES','Iguana','<image src=\"../images/lizard1.gif\">Friendly green friend'),('RP-SN-01','REPTILES','Rattlesnake','<image src=\"../images/snake1.gif\">Doubles as a watch dog');

/*Table structure for table `profile` */

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `userid` varchar(80) NOT NULL,
  `langpref` varchar(80) NOT NULL,
  `favcategory` varchar(30) DEFAULT NULL,
  `mylistopt` int(11) DEFAULT NULL,
  `banneropt` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `profile` */

insert  into `profile`(`userid`,`langpref`,`favcategory`,`mylistopt`,`banneropt`) values ('ACID','english','CATS',1,1),('j2ee','english','DOGS',1,1);

/*Table structure for table `sequence` */

DROP TABLE IF EXISTS `sequence`;

CREATE TABLE `sequence` (
  `name` varchar(30) NOT NULL,
  `nextid` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sequence` */

insert  into `sequence`(`name`,`nextid`) values ('ordernum',1009);

/*Table structure for table `signon` */

DROP TABLE IF EXISTS `signon`;

CREATE TABLE `signon` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `signon` */

insert  into `signon`(`username`,`password`) values ('ACID','ACID'),('j2ee','j2ee');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `suppid` int(11) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `status` varchar(2) NOT NULL,
  `addr1` varchar(80) DEFAULT NULL,
  `addr2` varchar(80) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  `state` varchar(80) DEFAULT NULL,
  `zip` varchar(5) DEFAULT NULL,
  `phone` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`suppid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supplier` */

insert  into `supplier`(`suppid`,`name`,`status`,`addr1`,`addr2`,`city`,`state`,`zip`,`phone`) values (1,'XYZ Pets','AC','600 Avon Way','','Los Angeles','CA','94024','212-947-0797'),(2,'ABC Pets','AC','700 Abalone Way','','San Francisco ','CA','94024','415-947-0797');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
