/*
SQLyog Ultimate v12.08 (32 bit)
MySQL - 5.7.22-log : Database - rds_sys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rds_sys` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `rds_sys`;

/*Table structure for table `gw_check_classify` */

DROP TABLE IF EXISTS `gw_check_classify`;

CREATE TABLE `gw_check_classify` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='检查分类';

/*Data for the table `gw_check_classify` */

insert  into `gw_check_classify`(`id`,`name`,`sort`,`create_time`) values (1,'公司级检查',1,'2018-08-07 10:03:37'),(2,'项目自检',2,'2018-08-07 10:03:43'),(3,'品质检查',3,'2018-08-07 10:03:57');

/*Table structure for table `gw_check_content` */

DROP TABLE IF EXISTS `gw_check_content`;

CREATE TABLE `gw_check_content` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cm_id` bigint(19) DEFAULT NULL COMMENT '外键检查线路id',
  `title` varchar(200) DEFAULT NULL COMMENT '检查内容名称',
  `content` varchar(200) DEFAULT NULL COMMENT '检查内容',
  `score` int(5) DEFAULT NULL COMMENT '分数',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `cm_id` (`cm_id`),
  CONSTRAINT `gw_check_content_ibfk_1` FOREIGN KEY (`cm_id`) REFERENCES `gw_check_manager` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='检查内容';

/*Data for the table `gw_check_content` */

insert  into `gw_check_content`(`id`,`cm_id`,`title`,`content`,`score`,`sort`,`remark`,`create_time`) values (1,1,'验证区域巡逻及防火巡查的真实性和及时性  要求：上传巡逻路线巡视记录','验证区域巡逻及防火巡查的真实性和及时性  要求：上传巡逻路线巡视记录',5,1,NULL,'2018-08-07 10:42:08'),(2,2,'检查保安人员形象是否符合要求（着装、佩戴、工号牌及服务礼仪）  要求：上传值班人员照片','检查保安人员形象是否符合要求（着装、佩戴、工号牌及服务礼仪）  要求：上传值班人员照片',5,2,NULL,'2018-08-07 10:42:10'),(3,2,'每班交接时必须召开班前班后会议  要求：上传班前班后会议人员集体照片','每班交接时必须召开班前班后会议  要求：上传班前班后会议人员集体照片',5,3,NULL,'2018-08-07 10:42:12'),(4,3,'检查岗位记录是否规范  要求：上传岗位相关记录','检查岗位记录是否规范  要求：上传岗位相关记录',5,4,NULL,'2018-08-07 10:42:14'),(5,3,'检查门岗值班人员岗位纪律（站姿、坐姿、文明用语是否规范，不得脱岗、睡岗、做与工作无关的事情）  要求：上传门岗值班人员现场值班照片','检查门岗值班人员岗位纪律（站姿、坐姿、文明用语是否规范，不得脱岗、睡岗、做与工作无关的事情）  要求：上传门岗值班人员现场值班照片',5,5,NULL,'2018-08-07 10:42:16'),(6,3,'检查外来人员及车辆管控是否到位  要求：上传岗位相关记录','检查外来人员及车辆管控是否到位  要求：上传岗位相关记录',5,6,NULL,'2018-08-07 10:42:17'),(7,3,'检查岗位5S是否符合要求  要求:上传值班岗位照片','检查岗位5S是否符合要求  要求:上传值班岗位照片',5,7,NULL,'2018-08-07 10:42:19'),(8,4,'抽查消、监控室值班人员岗位纪律（不得脱岗、睡岗、做与工作无关的事情）  要求：上传监控或现场夜查照片。','抽查消、监控室值班人员岗位纪律（不得脱岗、睡岗、做与工作无关的事情）  要求：上传监控或现场夜查照片。',5,8,NULL,'2018-08-07 10:42:21'),(9,4,'检查消防、监控室记录真实性与规范性，火警处理流程正确，处理过程可追溯。  要求：上传报警主机历史记录与记录本对照照片。','检查消防、监控室记录真实性与规范性，火警处理流程正确，处理过程可追溯。  要求：上传报警主机历史记录与记录本对照照片。',5,9,NULL,'2018-08-07 10:42:23'),(10,4,'值班室5S是否符合公司要求  要求：拍照上传岗位现场5S值班照片','值班室5S是否符合公司要求  要求：拍照上传岗位现场5S值班照片',5,10,NULL,'2018-08-07 10:42:24'),(11,4,'确认消控室值班人员是否能熟练操作消防设备  要求：上传现场值班员照片。','确认消控室值班人员是否能熟练操作消防设备  要求：上传现场值班员照片。',5,11,NULL,'2018-08-07 10:42:26'),(12,5,'检查宿舍现场环境是否符合5S要求 ，有无安全隐患（私拉乱接、使用违章电器等）情况。 要求：上传现场检查照片。','检查宿舍现场环境是否符合5S要求 ，有无安全隐患（私拉乱接、使用违章电器等）情况。 要求：上传现场检查照片。',5,12,NULL,'2018-08-07 10:42:28'),(13,5,'组织队员防火防盗、消防四个能力安全培训  要求：上传培训照片','组织队员防火防盗、消防四个能力安全培训  要求：上传培训照片',5,13,NULL,'2018-08-07 10:42:30'),(14,5,'抽查区域内消防设施是否完好（消控室设备、消防压力、喷淋、消火栓、灭火器、安全出口等），点检是否到位。  要求：上传现场检查照片','抽查区域内消防设施是否完好（消控室设备、消防压力、喷淋、消火栓、灭火器、安全出口等），点检是否到位。  要求：上传现场检查照片',5,14,NULL,'2018-08-07 10:42:31'),(15,5,'对项目重点部位（屋面、地下室等）进行防火、防盗安全隐患普查  要求：上传现场检查情况及相关记录','对项目重点部位（屋面、地下室等）进行防火、防盗安全隐患普查  要求：上传现场检查情况及相关记录',5,15,NULL,'2018-08-07 10:42:33'),(16,5,'每周组织一次全面夜查  要求：上传夜查照片','每周组织一次全面夜查  要求：上传夜查照片',5,16,NULL,'2018-08-07 10:42:35'),(17,6,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,17,NULL,'2018-08-07 10:42:36'),(18,7,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,18,NULL,'2018-08-07 10:42:38'),(19,8,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,19,NULL,'2018-08-07 10:42:40'),(20,9,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,20,NULL,'2018-08-07 10:49:49'),(21,9,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,21,NULL,'2018-08-07 10:49:52'),(22,9,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,22,NULL,'2018-08-07 10:49:54'),(23,9,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,23,NULL,'2018-08-07 10:49:56'),(24,10,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,24,NULL,'2018-08-07 10:49:58'),(25,10,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,25,NULL,'2018-08-07 10:50:01'),(26,11,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,26,NULL,'2018-08-07 10:50:03'),(27,11,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,27,NULL,'2018-08-07 10:50:05'),(28,11,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,28,NULL,'2018-08-07 10:50:08'),(29,11,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,29,NULL,'2018-08-07 10:50:11'),(30,11,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,30,NULL,'2018-08-07 10:50:13'),(31,11,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,31,NULL,'2018-08-07 10:50:16'),(32,12,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,32,NULL,'2018-08-07 10:50:19'),(33,13,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,33,NULL,'2018-08-07 10:50:21'),(34,13,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,34,NULL,'2018-08-07 10:50:23'),(35,13,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,35,NULL,'2018-08-07 10:50:25'),(36,14,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,36,NULL,'2018-08-07 10:50:27'),(37,14,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,37,NULL,'2018-08-07 10:50:29'),(38,14,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,38,NULL,'2018-08-07 10:50:31'),(39,15,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,39,NULL,'2018-08-07 10:50:34'),(40,15,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,40,NULL,'2018-08-07 10:50:36'),(41,16,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,41,NULL,'2018-08-07 10:50:38'),(42,16,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,42,NULL,'2018-08-07 10:50:40'),(43,17,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,43,NULL,'2018-08-07 10:50:42'),(44,17,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,44,NULL,'2018-08-07 10:50:44'),(45,17,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,45,NULL,'2018-08-07 10:50:46'),(46,18,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,46,NULL,'2018-08-07 10:50:48'),(47,18,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,47,NULL,'2018-08-07 10:50:50'),(48,18,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,48,NULL,'2018-08-07 10:55:37'),(49,19,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,49,NULL,'2018-08-07 10:55:39'),(50,19,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,50,NULL,'2018-08-07 10:55:41'),(51,19,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,51,NULL,'2018-08-07 10:55:43'),(52,20,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,52,NULL,'2018-08-07 10:55:46'),(53,20,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,53,NULL,'2018-08-07 10:55:48'),(54,20,'工程人员证件是否在有效期内。要求：上传工程人员上岗证件正反面照片','工程人员证件是否在有效期内。\r\n要求：上传工程人员证件统计表（注明证件种类及有效期）',5,54,NULL,'2018-08-07 10:55:50');

/*Table structure for table `gw_check_manager` */

DROP TABLE IF EXISTS `gw_check_manager`;

CREATE TABLE `gw_check_manager` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cr_id` bigint(19) DEFAULT NULL COMMENT '外键检查线路id',
  `name` varchar(20) DEFAULT NULL COMMENT '检查项目名称',
  `check` tinyint(1) DEFAULT NULL COMMENT '是否必查',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `frequency1` int(5) DEFAULT NULL COMMENT '频次1周2次',
  `frequency_type` bigint(19) DEFAULT NULL COMMENT '频次1周2次',
  `frequency2` int(5) DEFAULT NULL COMMENT '频次1周2次',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `cr_id` (`cr_id`),
  KEY `frequency_type` (`frequency_type`),
  CONSTRAINT `gw_check_manager_ibfk_1` FOREIGN KEY (`cr_id`) REFERENCES `gw_check_route` (`id`),
  CONSTRAINT `gw_check_manager_ibfk_2` FOREIGN KEY (`frequency_type`) REFERENCES `gw_frequency_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='检查管理';

/*Data for the table `gw_check_manager` */

insert  into `gw_check_manager`(`id`,`cr_id`,`name`,`check`,`sort`,`frequency1`,`frequency_type`,`frequency2`,`remark`,`create_time`) values (1,1,'区域巡逻岗',1,1,1,7,2,NULL,'2018-08-07 10:21:39'),(2,1,'队伍管理',1,2,1,7,2,NULL,'2018-08-07 10:23:37'),(3,1,'门岗',1,3,1,7,2,NULL,'2018-08-07 10:23:52'),(4,1,'消防、监控岗',1,4,1,7,1,NULL,'2018-08-07 10:24:01'),(5,1,'安全检查',1,5,1,7,1,NULL,'2018-08-07 10:24:10'),(6,2,'证件管理',1,6,1,1,1,NULL,'2018-08-07 10:25:42'),(7,2,'能耗管理',1,7,1,1,1,NULL,'2018-08-07 10:25:54'),(8,2,'计划落实',1,8,1,1,1,NULL,'2018-08-07 10:25:58'),(9,2,'工程员工管理',1,9,1,1,1,NULL,'2018-08-07 10:26:00'),(10,2,'高压配电房运行管理',1,10,1,1,2,NULL,'2018-08-07 10:26:02'),(11,2,'消防泵房运行管理',1,11,1,1,2,NULL,'2018-08-07 10:26:04'),(12,2,'消控室设备运行管理',1,12,1,1,2,NULL,'2018-08-07 10:26:05'),(13,2,'生活泵房运行管理',1,13,1,1,2,NULL,'2018-08-07 10:26:07'),(14,2,'电梯运行管理',1,14,1,2,2,NULL,'2018-08-07 10:26:09'),(15,2,'楼层强、弱电间运行管理',1,15,1,2,2,NULL,'2018-08-07 10:26:11'),(16,2,'零星维修管理',1,16,1,2,2,NULL,'2018-08-07 10:26:12'),(17,2,'空调运行管理',1,17,1,2,2,NULL,'2018-08-07 10:26:15'),(18,2,'锅炉房运行管理',1,18,1,3,2,NULL,'2018-08-07 10:26:17'),(19,2,'发电机房运行管理',1,19,1,4,2,NULL,'2018-08-07 10:26:18'),(20,2,'维保单位监督管理',1,20,1,5,2,NULL,'2018-08-07 10:26:21');

/*Table structure for table `gw_check_route` */

DROP TABLE IF EXISTS `gw_check_route`;

CREATE TABLE `gw_check_route` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `ct_id` bigint(19) DEFAULT NULL COMMENT '外键检查模板id',
  `name` varchar(20) DEFAULT NULL COMMENT '检查范围名称',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `ct_id` (`ct_id`),
  CONSTRAINT `gw_check_route_ibfk_1` FOREIGN KEY (`ct_id`) REFERENCES `gw_check_temp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='检查线路';

/*Data for the table `gw_check_route` */

insert  into `gw_check_route`(`id`,`ct_id`,`name`,`sort`,`remark`,`create_time`) values (1,1,'保安条线',1,'保安条线','2018-08-07 10:16:09'),(2,2,'工程条线',2,'工程条线','2018-08-07 10:16:23'),(3,3,'保洁条线',3,'保洁条线','2018-08-07 10:18:37'),(4,4,'项目负责人',4,'项目负责人','2018-08-07 10:19:14'),(5,5,'小项目负责人',5,'小项目负责人','2018-08-07 10:19:29'),(6,6,'项目日常自查',6,'项目日常自查','2018-08-07 10:20:22');

/*Table structure for table `gw_check_temp` */

DROP TABLE IF EXISTS `gw_check_temp`;

CREATE TABLE `gw_check_temp` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cc_id` bigint(19) DEFAULT NULL COMMENT '外键检查分类id',
  `s_id` bigint(19) DEFAULT NULL COMMENT '外键供应商(房产项目)id',
  `name` varchar(20) DEFAULT NULL COMMENT '模板名称',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `cc_id` (`cc_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `gw_check_temp_ibfk_1` FOREIGN KEY (`cc_id`) REFERENCES `gw_check_classify` (`id`),
  CONSTRAINT `gw_check_temp_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `gw_supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='检查模板';

/*Data for the table `gw_check_temp` */

insert  into `gw_check_temp`(`id`,`cc_id`,`s_id`,`name`,`sort`,`remark`,`create_time`) values (1,2,1,'保安条线项目自检',1,'保安条线项目自检','2018-08-07 10:06:00'),(2,2,1,'工程条线项目自检',2,'工程条线项目自检','2018-08-07 10:09:42'),(3,2,1,'保洁条线项目自检',3,'保洁条线项目自检','2018-08-07 10:11:37'),(4,2,1,'项目负责人日常自检',4,'项目负责人日常自检','2018-08-07 10:11:52'),(5,2,1,'小项目负责人项目自检',5,'小项目负责人项目自检','2018-08-07 10:12:09'),(6,2,1,'项目品质检查标准（新）',6,'项目品质检查标准（新）','2018-08-07 10:12:32'),(7,2,1,'项目安全检查（新）',7,'项目安全检查（新）','2018-08-07 10:13:01'),(8,2,1,'项目安全检查表（确认版）',8,'项目安全检查表（确认版）','2018-08-07 10:13:15'),(9,2,1,'项目品质检查表（确认版）',9,'项目品质检查表（确认版）','2018-08-07 10:13:36'),(10,2,1,'项目安全检查表',10,'项目安全检查表','2018-08-07 10:13:49'),(11,2,1,'项目品质检查表',11,'项目品质检查表','2018-08-07 10:14:20'),(12,2,1,'夏季防火汛期安全管理',12,'夏季防火汛期安全管理','2018-08-07 10:14:31'),(13,2,1,'督导员检查模板',13,'督导员检查模板','2018-08-07 10:14:52');

/*Table structure for table `gw_company` */

DROP TABLE IF EXISTS `gw_company`;

CREATE TABLE `gw_company` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) DEFAULT NULL COMMENT '子公司名称',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `parent_id` bigint(19) DEFAULT NULL COMMENT '父类id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='子公司管理';

/*Data for the table `gw_company` */

insert  into `gw_company`(`id`,`name`,`sort`,`parent_id`,`create_time`) values (1,'公司总部',1,0,'2018-08-07 10:00:43'),(2,'西交大分布',1,1,'2018-08-07 10:01:20'),(3,'中国移动分布',2,1,'2018-08-07 10:01:40'),(4,'园区物业五分部',3,1,'2018-08-07 10:01:56'),(5,'城区分部',4,1,'2018-08-07 10:02:18'),(6,'园区物业三分部',5,1,'2018-08-07 10:02:36'),(7,'校园绿化中心',6,1,'2018-08-07 10:02:51');

/*Table structure for table `gw_frequency_type` */

DROP TABLE IF EXISTS `gw_frequency_type`;

CREATE TABLE `gw_frequency_type` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) DEFAULT NULL COMMENT '频次名称',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='频次管理';

/*Data for the table `gw_frequency_type` */

insert  into `gw_frequency_type`(`id`,`name`,`sort`,`create_time`) values (1,'日',1,'2018-08-07 09:58:06'),(2,'半周',2,'2018-08-07 09:58:23'),(3,'周',3,'2018-08-07 09:58:31'),(4,'两周',4,'2018-08-07 09:58:43'),(5,'半月',5,'2018-08-07 09:58:58'),(6,'月',6,'2018-08-07 09:59:05'),(7,'季',7,'2018-08-07 09:59:14'),(8,'半年',8,'2018-08-07 09:59:22'),(9,'年',9,'2018-08-07 09:59:29');

/*Table structure for table `gw_quality_inspect_task` */

DROP TABLE IF EXISTS `gw_quality_inspect_task`;

CREATE TABLE `gw_quality_inspect_task` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `s_id` bigint(19) DEFAULT NULL COMMENT '所属项目id',
  `ct_id` bigint(19) DEFAULT NULL COMMENT '外键模板id',
  `c_id` bigint(19) DEFAULT NULL COMMENT '所属部门id',
  `u_id` bigint(19) DEFAULT NULL COMMENT '编制人id',
  `inspector_id` bigint(19) DEFAULT NULL COMMENT '检查人id',
  `name` varchar(200) DEFAULT NULL COMMENT '计划名称',
  `year` bigint(19) DEFAULT NULL COMMENT '计划年份',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `is_generate` tinyint(1) DEFAULT NULL COMMENT '是否生成详情',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '编制时间',
  PRIMARY KEY (`id`),
  KEY `s_id` (`s_id`),
  KEY `ct_id` (`ct_id`),
  KEY `c_id` (`c_id`),
  KEY `u_id` (`u_id`),
  KEY `inspector_id` (`inspector_id`),
  CONSTRAINT `gw_quality_inspect_task_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `gw_supplier` (`id`),
  CONSTRAINT `gw_quality_inspect_task_ibfk_2` FOREIGN KEY (`ct_id`) REFERENCES `gw_check_temp` (`id`),
  CONSTRAINT `gw_quality_inspect_task_ibfk_3` FOREIGN KEY (`c_id`) REFERENCES `gw_company` (`id`),
  CONSTRAINT `gw_quality_inspect_task_ibfk_4` FOREIGN KEY (`u_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `gw_quality_inspect_task_ibfk_5` FOREIGN KEY (`inspector_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='岗位自检 计划';

/*Data for the table `gw_quality_inspect_task` */

insert  into `gw_quality_inspect_task`(`id`,`s_id`,`ct_id`,`c_id`,`u_id`,`inspector_id`,`name`,`year`,`start_time`,`end_time`,`sort`,`is_generate`,`remark`,`create_time`) values (1,1,1,4,38,38,'游客中心8月-10月项目安全检查',2018,'2018-08-08 00:00:00','2018-10-08 00:00:00',0,1,NULL,'2018-08-08 15:34:55'),(3,1,2,4,38,38,'游客中心11月-12月项目安全检查',2018,'2018-11-08 00:00:00','2018-12-08 00:00:00',1,0,NULL,'2018-08-09 11:43:29');

/*Table structure for table `gw_quality_inspect_task_detail` */

DROP TABLE IF EXISTS `gw_quality_inspect_task_detail`;

CREATE TABLE `gw_quality_inspect_task_detail` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `qit_id` bigint(19) DEFAULT NULL COMMENT '外键 岗位自检 计划id',
  `check_project` varchar(200) DEFAULT NULL COMMENT '检查项目',
  `check_point` varchar(50) DEFAULT NULL COMMENT '检查点',
  `frequency` varchar(20) DEFAULT NULL COMMENT '频次',
  `qualified` tinyint(1) DEFAULT NULL COMMENT '是否合格',
  `score` varchar(20) DEFAULT NULL COMMENT '得分/总分',
  `check_time` datetime DEFAULT NULL COMMENT '检查时间',
  `check_user` bigint(19) DEFAULT NULL COMMENT '检查人',
  `is_checked` tinyint(1) DEFAULT NULL COMMENT '是否检查',
  `task_stime` datetime NOT NULL COMMENT '计划开始时间',
  `task_etime` datetime NOT NULL COMMENT '计划结束时间',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `enclosure` varchar(20) DEFAULT NULL COMMENT '附件',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `qit_id` (`qit_id`),
  CONSTRAINT `gw_quality_inspect_task_detail_ibfk_1` FOREIGN KEY (`qit_id`) REFERENCES `gw_quality_inspect_task` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2144 DEFAULT CHARSET=utf8 COMMENT='岗位自检 计划详情';

/*Data for the table `gw_quality_inspect_task_detail` */

insert  into `gw_quality_inspect_task_detail`(`id`,`qit_id`,`check_project`,`check_point`,`frequency`,`qualified`,`score`,`check_time`,`check_user`,`is_checked`,`task_stime`,`task_etime`,`sort`,`enclosure`,`remark`) values (2136,1,'保安条线项目自检->保安条线->区域巡逻岗','区域巡逻岗','1季2次',NULL,'0/5','2018-08-10 13:28:08',NULL,NULL,'2018-08-08 00:00:00','2018-10-07 00:00:00',NULL,NULL,NULL),(2137,1,'保安条线项目自检->保安条线->区域巡逻岗','区域巡逻岗','1季2次',NULL,'0/5','2018-08-10 13:28:08',NULL,NULL,'2018-10-07 00:00:00','2018-10-08 00:00:00',NULL,NULL,NULL),(2138,1,'保安条线项目自检->保安条线->队伍管理','队伍管理','1季2次',NULL,'0/10','2018-08-10 13:28:08',NULL,NULL,'2018-08-08 00:00:00','2018-10-07 00:00:00',NULL,NULL,NULL),(2139,1,'保安条线项目自检->保安条线->队伍管理','队伍管理','1季2次',NULL,'0/10','2018-08-10 13:28:08',NULL,NULL,'2018-10-07 00:00:00','2018-10-08 00:00:00',NULL,NULL,NULL),(2140,1,'保安条线项目自检->保安条线->门岗','门岗','1季2次',NULL,'0/20','2018-08-10 13:28:08',NULL,NULL,'2018-08-08 00:00:00','2018-10-07 00:00:00',NULL,NULL,NULL),(2141,1,'保安条线项目自检->保安条线->门岗','门岗','1季2次',NULL,'0/20','2018-08-10 13:28:08',NULL,NULL,'2018-10-07 00:00:00','2018-10-08 00:00:00',NULL,NULL,NULL),(2142,1,'保安条线项目自检->保安条线->消防、监控岗','消防、监控岗','1季1次',NULL,'0/20','2018-08-10 13:28:08',NULL,NULL,'2018-08-08 00:00:00','2018-10-08 00:00:00',NULL,NULL,NULL),(2143,1,'保安条线项目自检->保安条线->安全检查','安全检查','1季1次',NULL,'0/25','2018-08-10 13:28:08',NULL,NULL,'2018-08-08 00:00:00','2018-10-08 00:00:00',NULL,NULL,NULL);

/*Table structure for table `gw_quality_inspect_task_result` */

DROP TABLE IF EXISTS `gw_quality_inspect_task_result`;

CREATE TABLE `gw_quality_inspect_task_result` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `qitd_id` bigint(19) DEFAULT NULL COMMENT '外键 岗位自检 计划详情id',
  `check_content` varchar(200) DEFAULT NULL COMMENT '检查内容',
  `is_qualified` tinyint(1) DEFAULT NULL COMMENT '是否合格',
  `score` int(5) DEFAULT NULL COMMENT '得分',
  `check_time` datetime DEFAULT NULL COMMENT '检查时间',
  `check_situation` varchar(300) DEFAULT NULL COMMENT '检查情况',
  `enclosure` varchar(20) DEFAULT NULL COMMENT '附件地址',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `qitd_id` (`qitd_id`),
  CONSTRAINT `gw_quality_inspect_task_result_ibfk_1` FOREIGN KEY (`qitd_id`) REFERENCES `gw_quality_inspect_task_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5644 DEFAULT CHARSET=utf8 COMMENT='岗位自检 检查内容及反馈';

/*Data for the table `gw_quality_inspect_task_result` */

insert  into `gw_quality_inspect_task_result`(`id`,`qitd_id`,`check_content`,`is_qualified`,`score`,`check_time`,`check_situation`,`enclosure`,`remark`) values (5621,2136,'验证区域巡逻及防火巡查的真实性和及时性  要求：上传巡逻路线巡视记录',NULL,NULL,NULL,NULL,NULL,NULL),(5622,2137,'验证区域巡逻及防火巡查的真实性和及时性  要求：上传巡逻路线巡视记录',NULL,NULL,NULL,NULL,NULL,NULL),(5623,2138,'检查保安人员形象是否符合要求（着装、佩戴、工号牌及服务礼仪）  要求：上传值班人员照片',NULL,NULL,NULL,NULL,NULL,NULL),(5624,2138,'每班交接时必须召开班前班后会议  要求：上传班前班后会议人员集体照片',NULL,NULL,NULL,NULL,NULL,NULL),(5625,2139,'检查保安人员形象是否符合要求（着装、佩戴、工号牌及服务礼仪）  要求：上传值班人员照片',NULL,NULL,NULL,NULL,NULL,NULL),(5626,2139,'每班交接时必须召开班前班后会议  要求：上传班前班后会议人员集体照片',NULL,NULL,NULL,NULL,NULL,NULL),(5627,2140,'检查岗位记录是否规范  要求：上传岗位相关记录',NULL,NULL,NULL,NULL,NULL,NULL),(5628,2140,'检查门岗值班人员岗位纪律（站姿、坐姿、文明用语是否规范，不得脱岗、睡岗、做与工作无关的事情）  要求：上传门岗值班人员现场值班照片',NULL,NULL,NULL,NULL,NULL,NULL),(5629,2140,'检查外来人员及车辆管控是否到位  要求：上传岗位相关记录',NULL,NULL,NULL,NULL,NULL,NULL),(5630,2140,'检查岗位5S是否符合要求  要求:上传值班岗位照片',NULL,NULL,NULL,NULL,NULL,NULL),(5631,2141,'检查岗位记录是否规范  要求：上传岗位相关记录',NULL,NULL,NULL,NULL,NULL,NULL),(5632,2141,'检查门岗值班人员岗位纪律（站姿、坐姿、文明用语是否规范，不得脱岗、睡岗、做与工作无关的事情）  要求：上传门岗值班人员现场值班照片',NULL,NULL,NULL,NULL,NULL,NULL),(5633,2141,'检查外来人员及车辆管控是否到位  要求：上传岗位相关记录',NULL,NULL,NULL,NULL,NULL,NULL),(5634,2141,'检查岗位5S是否符合要求  要求:上传值班岗位照片',NULL,NULL,NULL,NULL,NULL,NULL),(5635,2142,'抽查消、监控室值班人员岗位纪律（不得脱岗、睡岗、做与工作无关的事情）  要求：上传监控或现场夜查照片。',NULL,NULL,NULL,NULL,NULL,NULL),(5636,2142,'检查消防、监控室记录真实性与规范性，火警处理流程正确，处理过程可追溯。  要求：上传报警主机历史记录与记录本对照照片。',NULL,NULL,NULL,NULL,NULL,NULL),(5637,2142,'值班室5S是否符合公司要求  要求：拍照上传岗位现场5S值班照片',NULL,NULL,NULL,NULL,NULL,NULL),(5638,2142,'确认消控室值班人员是否能熟练操作消防设备  要求：上传现场值班员照片。',NULL,NULL,NULL,NULL,NULL,NULL),(5639,2143,'检查宿舍现场环境是否符合5S要求 ，有无安全隐患（私拉乱接、使用违章电器等）情况。 要求：上传现场检查照片。',NULL,NULL,NULL,NULL,NULL,NULL),(5640,2143,'组织队员防火防盗、消防四个能力安全培训  要求：上传培训照片',NULL,NULL,NULL,NULL,NULL,NULL),(5641,2143,'抽查区域内消防设施是否完好（消控室设备、消防压力、喷淋、消火栓、灭火器、安全出口等），点检是否到位。  要求：上传现场检查照片',NULL,NULL,NULL,NULL,NULL,NULL),(5642,2143,'对项目重点部位（屋面、地下室等）进行防火、防盗安全隐患普查  要求：上传现场检查情况及相关记录',NULL,NULL,NULL,NULL,NULL,NULL),(5643,2143,'每周组织一次全面夜查  要求：上传夜查照片',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `gw_supplier` */

DROP TABLE IF EXISTS `gw_supplier`;

CREATE TABLE `gw_supplier` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) DEFAULT NULL COMMENT '供应商名称',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='供应商管理';

/*Data for the table `gw_supplier` */

insert  into `gw_supplier`(`id`,`name`,`sort`,`create_time`) values (1,'苏州市阳澄湖半岛游客中心',1,'2018-08-07 09:56:23'),(2,'上海市海洋馆游客中心',2,'2018-08-07 09:56:56'),(3,'安徽中科大学校',3,'2018-08-07 09:57:29');

/*Table structure for table `sys_journal` */

DROP TABLE IF EXISTS `sys_journal`;

CREATE TABLE `sys_journal` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `p_id` bigint(19) DEFAULT NULL COMMENT '外键项目id',
  `u_id` bigint(19) DEFAULT NULL COMMENT '外键用户id',
  `j_date` datetime DEFAULT NULL COMMENT '工作日期',
  `work_duration` int(10) DEFAULT NULL COMMENT '工作时长',
  `work_desc` varchar(500) DEFAULT NULL COMMENT '工作描述',
  `over_time` int(10) DEFAULT NULL COMMENT '加班时长',
  `over_desc` varchar(500) DEFAULT NULL COMMENT '加班描述',
  `examine` int(2) DEFAULT '0' COMMENT '是否审查',
  PRIMARY KEY (`id`),
  KEY `p_id` (`p_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `sys_journal_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `sys_project` (`id`),
  CONSTRAINT `sys_journal_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='日志管理';

/*Data for the table `sys_journal` */

insert  into `sys_journal`(`id`,`p_id`,`u_id`,`j_date`,`work_duration`,`work_desc`,`over_time`,`over_desc`,`examine`) values (2,2,38,'2018-11-11 11:11:11',8,'编写日志管理',4,'编写日志管理',0),(3,1,38,'2018-01-01 11:11:11',11,'1111',4,'1111',0),(12,1,38,'2018-08-07 11:11:11',8,'岗位自检数据库编写',4,'岗位自检数据库编写',0);

/*Table structure for table `sys_mbg` */

DROP TABLE IF EXISTS `sys_mbg`;

CREATE TABLE `sys_mbg` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `mbg_id` bigint(19) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试mbg';

/*Data for the table `sys_mbg` */

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '资源名称',
  `url` varchar(100) DEFAULT NULL COMMENT '资源路径',
  `open_mode` varchar(32) DEFAULT NULL COMMENT '打开方式 ajax,iframe',
  `description` varchar(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` varchar(32) DEFAULT NULL COMMENT '资源图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级资源id',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `menu_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  `is_leaf` tinyint(1) DEFAULT '0' COMMENT '是否是叶子',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源id',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8 COMMENT='资源';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`name`,`url`,`open_mode`,`description`,`icon`,`pid`,`seq`,`status`,`menu_type`,`is_leaf`,`resource_id`,`del_flag`,`update_time`,`create_time`) values (236,'系统管理','','0','','',NULL,0,0,0,1,NULL,0,'2017-01-08 03:33:16','2017-01-08 03:33:16'),(237,'机构管理','','0','','',236,0,0,0,1,NULL,0,'2017-01-08 03:33:32','2017-01-08 03:33:32'),(238,'权限管理','','0','','',236,0,0,0,1,NULL,0,'2017-01-08 03:38:43','2017-01-08 03:38:43'),(239,'机构列表','/sys/orgs/ui/list','0','','',237,0,0,0,1,NULL,0,'2017-01-10 21:13:09','2017-01-08 03:38:56'),(240,'用户列表','/sys/users/ui/list','0','','',237,0,0,0,0,NULL,0,'2017-01-10 21:14:55','2017-01-08 03:39:08'),(242,'列表','','0','','',239,0,0,1,0,NULL,0,'2017-01-10 16:23:51','2017-01-08 10:22:24'),(244,'增加','','0','','',239,1,0,1,0,NULL,0,'2017-01-08 10:23:19','2017-01-08 10:23:19'),(245,'资源列表','/sys/resources/ui/list','0','','',238,0,0,0,0,NULL,0,'2017-01-10 22:59:30','2017-01-10 21:15:22'),(246,'角色列表','/sys/roles/ui/list','0','','',238,0,0,0,0,NULL,0,'2017-01-10 21:16:15','2017-01-10 21:16:15'),(247,'物业管理','','0','','',NULL,0,0,0,1,NULL,0,'2017-01-10 21:20:31','2017-01-10 21:20:31'),(248,'小区管理','','0','','',247,0,0,0,1,NULL,0,'2017-01-10 21:20:48','2017-01-10 21:20:48'),(249,'垃圾管理','','0','','',248,0,0,0,0,NULL,0,'2017-01-10 21:21:00','2017-01-10 21:21:00');

/*Table structure for table `sys_org` */

DROP TABLE IF EXISTS `sys_org`;

CREATE TABLE `sys_org` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '组织名',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `code` varchar(64) NOT NULL COMMENT '编号',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级主键',
  `is_leaf` tinyint(1) DEFAULT '0' COMMENT '叶子节点',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='组织机构';

/*Data for the table `sys_org` */

insert  into `sys_org`(`id`,`name`,`address`,`code`,`icon`,`pid`,`is_leaf`,`seq`,`del_flag`,`update_time`,`create_time`) values (26,'百度','','','',NULL,1,1,0,'2017-04-21 15:32:14','2017-01-06 12:37:12'),(27,'事业部','','','',26,1,0,0,'2017-01-06 12:38:56','2017-01-06 12:37:26'),(28,'开发部','','','',27,0,0,0,'2017-01-06 12:37:37','2017-01-06 12:37:37'),(29,'产品部','','','',27,0,1,1,'2017-01-06 12:37:50','2017-01-06 12:37:50'),(30,'售后部','','','',26,0,1,0,'2017-01-06 12:38:12','2017-01-06 12:38:12'),(31,'产品部','','','',27,0,1,1,'2017-01-06 12:41:17','2017-01-06 12:41:17'),(32,'产品部','','','',27,0,1,1,'2017-01-06 12:42:38','2017-01-06 12:42:38'),(33,'产品部','','','',27,0,1,1,'2017-01-06 12:45:32','2017-01-06 12:45:32'),(34,'系统开发','','','',NULL,0,0,0,'2017-04-21 15:32:00','2017-01-06 12:55:39'),(35,'测试','','','',NULL,0,0,1,'2017-04-21 15:33:06','2017-04-21 15:33:06');

/*Table structure for table `sys_project` */

DROP TABLE IF EXISTS `sys_project`;

CREATE TABLE `sys_project` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) DEFAULT NULL COMMENT '项目名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='项目名称';

/*Data for the table `sys_project` */

insert  into `sys_project`(`id`,`name`) values (1,'日志管理系统'),(2,'wms仓库管理系统'),(3,'格力大金项目');

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '资源名称',
  `url` varchar(100) DEFAULT NULL COMMENT '资源路径',
  `open_mode` varchar(32) DEFAULT NULL COMMENT '打开方式 ajax,iframe',
  `description` varchar(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` varchar(100) DEFAULT NULL COMMENT '资源图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级资源id',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `resource_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  `is_leaf` tinyint(1) DEFAULT '0' COMMENT '是否是叶子',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8 COMMENT='资源';

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`id`,`name`,`url`,`open_mode`,`description`,`icon`,`pid`,`seq`,`status`,`resource_type`,`is_leaf`,`del_flag`,`update_time`,`create_time`) values (236,'系统管理','','0','','/resources/images/32x32/settings.png',NULL,1,0,0,1,0,'2017-05-22 22:51:03','2017-01-08 03:33:16'),(237,'机构管理','','0','','/resources/images/32x32/1-1.png',236,0,0,0,1,0,'2017-05-22 22:39:11','2017-01-08 03:33:32'),(238,'权限管理','','0','','/resources/images/32x32/1-1.png',236,1,0,0,1,0,'2017-05-22 22:39:18','2017-01-08 03:38:43'),(239,'机构列表','/sys/orgs/ui/list','0','','/resources/images/32x32/user.png',237,0,0,0,1,0,'2017-05-23 08:12:16','2017-01-08 03:38:56'),(240,'用户列表','/sys/users/ui/list','0','','/resources/images/32x32/1-1.png',237,0,0,0,0,0,'2017-05-22 22:39:40','2017-01-08 03:39:08'),(245,'资源列表','/sys/resources/ui/list','0','','/resources/images/32x32/graphic-design.png',238,0,0,0,0,0,'2017-05-23 08:19:42','2017-01-10 21:15:22'),(246,'角色列表','/sys/roles/ui/list','0','','/resources/images/32x32/1-1.png',238,0,0,0,0,0,'2017-05-22 22:39:51','2017-01-10 21:16:15'),(247,'业务管理','','0','','/resources/images/32x32/photography.png',NULL,0,0,0,1,0,'2017-05-22 22:55:36','2017-01-10 21:20:31'),(248,'直播会员','','0','','/resources/images/32x32/sign-out.png',247,0,0,0,1,0,'2017-05-22 22:50:08','2017-01-10 21:20:48'),(249,'用户管理','/live/users/ui/list','0','','/resources/images/32x32/1-1.png',248,0,0,0,0,0,'2017-05-22 22:40:00','2017-01-10 21:21:00'),(252,'日志管理','','0','','/resources/images/32x32/attibutes.png',247,1,0,0,1,0,'2018-08-03 09:53:27','2018-08-03 09:53:27'),(253,'日报管理','/journal/topage/list','0','','/resources/images/32x32/attibutes.png',252,0,0,0,0,0,'2018-08-03 09:54:16','2018-08-03 09:54:16'),(254,'日报审核','','0','','/resources/images/32x32/old-versions.png',252,1,0,0,0,0,'2018-08-03 09:54:49','2018-08-03 09:54:49'),(255,'周报管理','','0','','/resources/images/32x32/billing.png',252,2,0,0,0,0,'2018-08-03 09:55:14','2018-08-03 09:55:14'),(258,'周报审核','','0','','/resources/images/32x32/old-versions.png',252,3,0,0,0,0,'2018-08-03 09:56:28','2018-08-03 09:56:28'),(259,'办公管理','','0','','/resources/images/32x32/home.png',247,2,0,0,1,0,'2018-08-03 09:57:45','2018-08-03 09:57:45'),(260,'办公室预约','','0','','/resources/images/32x32/current-work.png',259,0,0,0,0,0,'2018-08-03 09:58:30','2018-08-03 09:58:30'),(264,'岗位自检','/QualityInspectTask/ui/list','0','','/resources/images/32x32/current-work.png',259,1,0,0,0,0,'2018-08-07 14:48:50','2018-08-07 14:48:52');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '角色名',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序号',
  `description` varchar(255) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`seq`,`description`,`status`,`del_flag`,`update_time`,`create_time`) values (11,'系统管理员',0,'',0,0,'2017-01-08 17:30:37','2017-01-08 17:30:37'),(14,'普通员工',1,'',0,NULL,NULL,NULL),(15,'111',2,'11',0,0,'2018-08-06 10:58:07','2018-08-06 10:58:07');

/*Table structure for table `sys_role_resource` */

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  `resource_id` bigint(19) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=933 DEFAULT CHARSET=utf8 COMMENT='角色-资源';

/*Data for the table `sys_role_resource` */

insert  into `sys_role_resource`(`id`,`role_id`,`resource_id`) values (865,11,247),(866,11,248),(867,11,252),(868,11,259),(869,11,248),(870,11,249),(871,11,249),(872,11,252),(873,11,253),(874,11,254),(875,11,255),(876,11,258),(877,11,253),(878,11,254),(879,11,255),(880,11,258),(881,11,259),(882,11,260),(883,11,264),(884,11,260),(885,11,264),(886,11,236),(887,11,237),(888,11,238),(889,11,237),(890,11,239),(891,11,240),(892,11,239),(893,11,240),(894,11,238),(895,11,245),(896,11,246),(897,11,245),(898,11,246),(899,14,247),(900,14,248),(901,14,252),(902,14,259),(903,14,248),(904,14,249),(905,14,249),(906,14,252),(907,14,253),(908,14,254),(909,14,255),(910,14,258),(911,14,253),(912,14,254),(913,14,255),(914,14,258),(915,14,259),(916,14,260),(917,14,264),(918,14,260),(919,14,264),(920,14,236),(921,14,237),(922,14,238),(923,14,237),(924,14,239),(925,14,240),(926,14,239),(927,14,240),(928,14,238),(929,14,245),(930,14,246),(931,14,245),(932,14,246);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(64) NOT NULL COMMENT '登录名',
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `sex` tinyint(2) DEFAULT '0' COMMENT '性别',
  `age` tinyint(2) DEFAULT '0' COMMENT '年龄',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `user_type` tinyint(2) DEFAULT '0' COMMENT '用户类别',
  `status` tinyint(2) DEFAULT '0' COMMENT '用户状态',
  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`login_name`,`name`,`password`,`sex`,`age`,`phone`,`user_type`,`status`,`del_flag`,`update_time`,`create_time`) values (38,'admin','系统管理员','cbf87778dc36ff1e8a6ce93d89655023',0,NULL,'',0,0,0,'2017-01-09 10:52:59','2017-01-09 10:52:59'),(42,'test','测试','cbf87778dc36ff1e8a6ce93d89655023',0,NULL,'',0,0,0,'2017-01-16 21:46:39','2017-01-09 10:52:59'),(43,'test1','test1','cbf87778dc36ff1e8a6ce93d89655023',0,NULL,'',0,0,0,'2018-07-25 15:46:50','2018-07-25 15:46:50'),(44,'a','a','cbf87778dc36ff1e8a6ce93d89655023',0,NULL,'',0,0,0,'2018-07-25 15:54:54','2018-07-25 15:54:54');

/*Table structure for table `sys_user_org` */

DROP TABLE IF EXISTS `sys_user_org`;

CREATE TABLE `sys_user_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `org_id` bigint(20) DEFAULT NULL COMMENT '机构id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户-机构';

/*Data for the table `sys_user_org` */

insert  into `sys_user_org`(`id`,`user_id`,`org_id`) values (22,38,34),(25,42,28),(26,43,34),(27,44,34);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(19) NOT NULL COMMENT '用户id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户-角色';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values (4,38,11),(7,42,14),(8,43,11),(9,44,11);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
