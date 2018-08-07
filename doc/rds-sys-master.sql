/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.26 : Database - rds_sys
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP DATABASE IF EXISTS rds_sys;
CREATE DATABASE rds_sys;

USE rds_sys;


/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` VARCHAR(64) NOT NULL COMMENT '资源名称',
  `url` VARCHAR(100) DEFAULT NULL COMMENT '资源路径',
  `open_mode` VARCHAR(32) DEFAULT NULL COMMENT '打开方式 ajax,iframe',
  `description` VARCHAR(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` VARCHAR(32) DEFAULT NULL COMMENT '资源图标',
  `pid` BIGINT(19) DEFAULT NULL COMMENT '父级资源id',
  `seq` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `menu_type` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  `is_leaf` TINYINT(1) DEFAULT '0' COMMENT '是否是叶子',
  `resource_id` BIGINT(20) DEFAULT NULL COMMENT '资源id',
  `del_flag` TINYINT(1) DEFAULT '0' COMMENT '删除标记',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8 COMMENT='资源';

/*Data for the table `sys_menu` */

INSERT  INTO `sys_menu`(`id`,`name`,`url`,`open_mode`,`description`,`icon`,`pid`,`seq`,`status`,`menu_type`,`is_leaf`,`resource_id`,`del_flag`,`update_time`,`create_time`) VALUES (236,'系统管理','','0','','',NULL,0,0,0,1,NULL,0,'2017-01-08 03:33:16','2017-01-08 03:33:16'),(237,'机构管理','','0','','',236,0,0,0,1,NULL,0,'2017-01-08 03:33:32','2017-01-08 03:33:32'),(238,'权限管理','','0','','',236,0,0,0,1,NULL,0,'2017-01-08 03:38:43','2017-01-08 03:38:43'),(239,'机构列表','/sys/orgs/ui/list','0','','',237,0,0,0,1,NULL,0,'2017-01-10 21:13:09','2017-01-08 03:38:56'),(240,'用户列表','/sys/users/ui/list','0','','',237,0,0,0,0,NULL,0,'2017-01-10 21:14:55','2017-01-08 03:39:08'),(242,'列表','','0','','',239,0,0,1,0,NULL,0,'2017-01-10 16:23:51','2017-01-08 10:22:24'),(244,'增加','','0','','',239,1,0,1,0,NULL,0,'2017-01-08 10:23:19','2017-01-08 10:23:19'),(245,'资源列表','/sys/resources/ui/list','0','','',238,0,0,0,0,NULL,0,'2017-01-10 22:59:30','2017-01-10 21:15:22'),(246,'角色列表','/sys/roles/ui/list','0','','',238,0,0,0,0,NULL,0,'2017-01-10 21:16:15','2017-01-10 21:16:15'),(247,'物业管理','','0','','',NULL,0,0,0,1,NULL,0,'2017-01-10 21:20:31','2017-01-10 21:20:31'),(248,'小区管理','','0','','',247,0,0,0,1,NULL,0,'2017-01-10 21:20:48','2017-01-10 21:20:48'),(249,'垃圾管理','','0','','',248,0,0,0,0,NULL,0,'2017-01-10 21:21:00','2017-01-10 21:21:00');

/*Table structure for table `sys_org` */

DROP TABLE IF EXISTS `sys_org`;

CREATE TABLE `sys_org` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(64) NOT NULL COMMENT '组织名',
  `address` VARCHAR(100) DEFAULT NULL COMMENT '地址',
  `code` VARCHAR(64) NOT NULL COMMENT '编号',
  `icon` VARCHAR(32) DEFAULT NULL COMMENT '图标',
  `pid` BIGINT(19) DEFAULT NULL COMMENT '父级主键',
  `is_leaf` TINYINT(1) DEFAULT '0' COMMENT '叶子节点',
  `seq` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `del_flag` TINYINT(1) DEFAULT '0' COMMENT '删除标记',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='组织机构';

/*Data for the table `sys_org` */

INSERT  INTO `sys_org`(`id`,`name`,`address`,`code`,`icon`,`pid`,`is_leaf`,`seq`,`del_flag`,`update_time`,`create_time`) VALUES (26,'百度','','','',NULL,1,1,0,'2017-04-21 15:32:14','2017-01-06 12:37:12'),(27,'事业部','','','',26,1,0,0,'2017-01-06 12:38:56','2017-01-06 12:37:26'),(28,'开发部','','','',27,0,0,0,'2017-01-06 12:37:37','2017-01-06 12:37:37'),(29,'产品部','','','',27,0,1,1,'2017-01-06 12:37:50','2017-01-06 12:37:50'),(30,'售后部','','','',26,0,1,0,'2017-01-06 12:38:12','2017-01-06 12:38:12'),(31,'产品部','','','',27,0,1,1,'2017-01-06 12:41:17','2017-01-06 12:41:17'),(32,'产品部','','','',27,0,1,1,'2017-01-06 12:42:38','2017-01-06 12:42:38'),(33,'产品部','','','',27,0,1,1,'2017-01-06 12:45:32','2017-01-06 12:45:32'),(34,'系统开发','','','',NULL,0,0,0,'2017-04-21 15:32:00','2017-01-06 12:55:39'),(35,'测试','','','',NULL,0,0,1,'2017-04-21 15:33:06','2017-04-21 15:33:06');

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` VARCHAR(64) NOT NULL COMMENT '资源名称',
  `url` VARCHAR(100) DEFAULT NULL COMMENT '资源路径',
  `open_mode` VARCHAR(32) DEFAULT NULL COMMENT '打开方式 ajax,iframe',
  `description` VARCHAR(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` VARCHAR(100) DEFAULT NULL COMMENT '资源图标',
  `pid` BIGINT(19) DEFAULT NULL COMMENT '父级资源id',
  `seq` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `resource_type` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  `is_leaf` TINYINT(1) DEFAULT '0' COMMENT '是否是叶子',
  `del_flag` TINYINT(1) DEFAULT '0' COMMENT '删除标记',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8 COMMENT='资源';

/*Data for the table `sys_resource` */

INSERT  INTO `sys_resource`(`id`,`name`,`url`,`open_mode`,`description`,`icon`,`pid`,`seq`,`status`,`resource_type`,`is_leaf`,`del_flag`,`update_time`,`create_time`) VALUES (236,'系统管理','','0','','/resources/images/32x32/settings.png',NULL,1,0,0,1,0,'2017-05-22 22:51:03','2017-01-08 03:33:16'),(237,'机构管理','','0','','/resources/images/32x32/1-1.png',236,0,0,0,1,0,'2017-05-22 22:39:11','2017-01-08 03:33:32'),(238,'权限管理','','0','','/resources/images/32x32/1-1.png',236,1,0,0,1,0,'2017-05-22 22:39:18','2017-01-08 03:38:43'),(239,'机构列表','/sys/orgs/ui/list','0','','/resources/images/32x32/user.png',237,0,0,0,1,0,'2017-05-23 08:12:16','2017-01-08 03:38:56'),(240,'用户列表','/sys/users/ui/list','0','','/resources/images/32x32/1-1.png',237,0,0,0,0,0,'2017-05-22 22:39:40','2017-01-08 03:39:08'),(245,'资源列表','/sys/resources/ui/list','0','','/resources/images/32x32/graphic-design.png',238,0,0,0,0,0,'2017-05-23 08:19:42','2017-01-10 21:15:22'),(246,'角色列表','/sys/roles/ui/list','0','','/resources/images/32x32/1-1.png',238,0,0,0,0,0,'2017-05-22 22:39:51','2017-01-10 21:16:15'),(247,'直播管理','','0','','/resources/images/32x32/photography.png',NULL,0,0,0,1,0,'2017-05-22 22:55:36','2017-01-10 21:20:31'),(248,'直播会员','','0','','/resources/images/32x32/sign-out.png',247,0,0,0,1,0,'2017-05-22 22:50:08','2017-01-10 21:20:48'),(249,'用户管理','/live/users/ui/list','0','','/resources/images/32x32/1-1.png',248,0,0,0,0,0,'2017-05-22 22:40:00','2017-01-10 21:21:00');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(64) NOT NULL COMMENT '角色名',
  `seq` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '排序号',
  `description` VARCHAR(255) DEFAULT NULL COMMENT '简介',
  `status` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `del_flag` TINYINT(1) DEFAULT NULL COMMENT '删除标记',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sys_role` */

INSERT  INTO `sys_role`(`id`,`name`,`seq`,`description`,`status`,`del_flag`,`update_time`,`create_time`) VALUES (11,'系统管理员',0,'',0,0,'2017-01-08 17:30:37','2017-01-08 17:30:37'),(14,'普通员工',1,'',0,NULL,NULL,NULL);

/*Table structure for table `sys_role_resource` */

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` BIGINT(19) NOT NULL COMMENT '角色id',
  `resource_id` BIGINT(19) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=606 DEFAULT CHARSET=utf8 COMMENT='角色-资源';

/*Data for the table `sys_role_resource` */

INSERT  INTO `sys_role_resource`(`id`,`role_id`,`resource_id`) VALUES (564,11,236),(565,11,237),(566,11,239),(569,11,240),(570,11,238),(571,11,245),(572,11,246),(573,11,247),(574,11,248),(575,11,249),(603,14,247),(604,14,248),(605,14,249);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` VARCHAR(64) NOT NULL COMMENT '登录名',
  `name` VARCHAR(64) NOT NULL COMMENT '用户名',
  `password` VARCHAR(64) NOT NULL COMMENT '密码',
  `sex` TINYINT(2) DEFAULT '0' COMMENT '性别',
  `age` TINYINT(2) DEFAULT '0' COMMENT '年龄',
  `phone` VARCHAR(20) DEFAULT NULL COMMENT '手机号',
  `user_type` TINYINT(2) DEFAULT '0' COMMENT '用户类别',
  `status` TINYINT(2) DEFAULT '0' COMMENT '用户状态',
  `del_flag` TINYINT(1) DEFAULT NULL COMMENT '删除标记',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `sys_user` */

INSERT  INTO `sys_user`(`id`,`login_name`,`name`,`password`,`sex`,`age`,`phone`,`user_type`,`status`,`del_flag`,`update_time`,`create_time`) VALUES (38,'admin','系统管理员','6ff3b18929bae1973fceaf16e8746f08',0,NULL,'',0,0,0,'2017-01-09 10:52:59','2017-01-09 10:52:59'),(42,'test','测试','986b9372eaaa6adab68b024c0be2c7e3',0,NULL,'',0,0,0,'2017-01-16 21:46:39','2017-01-16 21:34:54');

/*Table structure for table `sys_user_org` */

DROP TABLE IF EXISTS `sys_user_org`;

CREATE TABLE `sys_user_org` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` BIGINT(20) DEFAULT NULL COMMENT '用户id',
  `org_id` BIGINT(20) DEFAULT NULL COMMENT '机构id',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户-机构';

/*Data for the table `sys_user_org` */

INSERT  INTO `sys_user_org`(`id`,`user_id`,`org_id`) VALUES (22,38,34),(25,42,28);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` BIGINT(19) NOT NULL COMMENT '用户id',
  `role_id` BIGINT(19) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户-角色';

/*Data for the table `sys_user_role` */

INSERT  INTO `sys_user_role`(`id`,`user_id`,`role_id`) VALUES (4,38,11),(7,42,14);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
CREATE TABLE `sys_mbg` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `mbg_id` BIGINT(19) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='测试mbg';

-- ----------------------------
-- 项目名称
-- ----------------------------
DROP TABLE IF EXISTS `sys_project`;
CREATE TABLE `sys_project` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(32) DEFAULT NULL COMMENT '项目名称',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='项目名称';
INSERT INTO `sys_project` (`id`,`name`) VALUES (1,'日志管理系统'),(2,'wms仓库管理系统'),(3,'格力大金项目');
-- ----------------------------
-- 日志管理
-- ----------------------------
DROP TABLE IF EXISTS `sys_journal`;
CREATE TABLE `sys_journal` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `p_id` BIGINT(19) DEFAULT NULL COMMENT '外键项目id',
    `u_id` BIGINT(19) DEFAULT NULL COMMENT '外键用户id',
    `j_date` DATETIME DEFAULT NULL COMMENT '工作日期',
    `work_duration` INT(10) DEFAULT NULL COMMENT '工作时长',
    `work_desc` VARCHAR(500) DEFAULT NULL COMMENT '工作描述',
    `over_time` INT(10) DEFAULT NULL COMMENT '加班时长',
    `over_desc` VARCHAR(500) DEFAULT NULL COMMENT '加班描述',
    `examine` INT(2) DEFAULT 0 COMMENT '是否审查',
    FOREIGN KEY(`p_id`) REFERENCES `sys_project`(`id`) ,
    FOREIGN KEY(`u_id`) REFERENCES `sys_user`(`id`) ,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='日志管理';

-- ----------------------------
-- 供应商信息（被检查的公司）
-- ----------------------------
DROP TABLE IF EXISTS `gw_supplier`;
CREATE TABLE `gw_supplier` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `name` VARCHAR(20) DEFAULT NULL COMMENT '供应商名称',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='供应商管理';


-- ----------------------------
-- 部门信息（客户公司的分类（或自己的公司））
-- ----------------------------
DROP TABLE IF EXISTS `gw_company`;
CREATE TABLE `gw_company` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `name` VARCHAR(20) DEFAULT NULL COMMENT '子公司名称',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `parent_id` BIGINT(19) DEFAULT NULL COMMENT '父类id',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='子公司管理';


-- ----------------------------
-- 检查分类
-- ----------------------------
DROP TABLE IF EXISTS `gw_check_classify`;
CREATE TABLE `gw_check_classify` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `name` VARCHAR(20) DEFAULT NULL COMMENT '分类名称',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='检查分类';


-- ----------------------------
-- 频次管理 日 周 双周 半月 月 季 半年 年
-- ----------------------------
DROP TABLE IF EXISTS `gw_frequency_type`;
CREATE TABLE `gw_frequency_type` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `name` VARCHAR(20) DEFAULT NULL COMMENT '频次名称',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='频次管理';

-- ----------------------------
-- 检查模板 4个级别 检查模板,检查线路,检查管理,检查内容
-- ----------------------------
DROP TABLE IF EXISTS `gw_check_temp`;
CREATE TABLE `gw_check_temp` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `cc_id` BIGINT(19) DEFAULT NULL COMMENT '外键检查分类id',
    `s_id` BIGINT(19) DEFAULT NULL COMMENT '外键供应商(房产项目)id',
    `name` VARCHAR(20) DEFAULT NULL COMMENT '模板名称',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `remark` VARCHAR(20) DEFAULT NULL COMMENT '备注',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    FOREIGN KEY(`cc_id`) REFERENCES `gw_check_classify`(`id`) ,
    FOREIGN KEY(`s_id`) REFERENCES `gw_supplier`(`id`) ,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='检查模板';

DROP TABLE IF EXISTS `gw_check_route`;
CREATE TABLE `gw_check_route` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `ct_id` BIGINT(19) DEFAULT NULL COMMENT '外键检查模板id',
    `name` VARCHAR(20) DEFAULT NULL COMMENT '检查范围名称',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `remark` VARCHAR(20) DEFAULT NULL COMMENT '备注',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    FOREIGN KEY(`ct_id`) REFERENCES `gw_check_temp`(`id`) ,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='检查线路';

DROP TABLE IF EXISTS `gw_check_manager`;
CREATE TABLE `gw_check_manager` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `cr_id` BIGINT(19) DEFAULT NULL COMMENT '外键检查线路id',
    `name` VARCHAR(20) DEFAULT NULL COMMENT '检查项目名称',
    `check` BOOLEAN DEFAULT NULL COMMENT '是否必查',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `frequency1` INTEGER(5) DEFAULT NULL COMMENT '频次1周2次',
    `frequency_type` BIGINT(19) DEFAULT NULL COMMENT '频次1周2次',
    `frequency2` INTEGER(5) DEFAULT NULL COMMENT '频次1周2次',
    `remark` VARCHAR(20) DEFAULT NULL COMMENT '备注',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    FOREIGN KEY(`cr_id`) REFERENCES `gw_check_route`(`id`) ,
    FOREIGN KEY(`frequency_type`) REFERENCES `gw_frequency_type`(`id`) ,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='检查管理';


DROP TABLE IF EXISTS `gw_check_content`;
CREATE TABLE `gw_check_content` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `cm_id` BIGINT(19) DEFAULT NULL COMMENT '外键检查线路id',
    `title` VARCHAR(200) DEFAULT NULL COMMENT '检查内容名称',
    `content` VARCHAR(200) DEFAULT NULL COMMENT '检查内容',
    `score` INTEGER(5) DEFAULT NULL COMMENT '分数',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `remark` VARCHAR(20) DEFAULT NULL COMMENT '备注',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    FOREIGN KEY(`cm_id`) REFERENCES `gw_check_manager`(`id`) ,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='检查内容';


-- ----------------------------
-- 关系数据库
-- ----------------------------


-- ----------------------------
-- 岗位自检 计划
-- ----------------------------

DROP TABLE IF EXISTS `gw_quality_inspect_task`;
CREATE TABLE `gw_quality_inspect_task` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `s_id` BIGINT(19) DEFAULT NULL COMMENT '所属项目id',
    `ct_id` BIGINT(19) DEFAULT NULL COMMENT '外键模板id',
    `c_id` BIGINT(19) DEFAULT NULL COMMENT '所属部门id',
    `u_id` BIGINT(19) DEFAULT NULL COMMENT '编制人id',
    `inspector_id` BIGINT(19) DEFAULT NULL COMMENT '检查人id',
    `name` VARCHAR(200) DEFAULT NULL COMMENT '计划名称',
    `year` BIGINT(19) DEFAULT NULL COMMENT '计划年份',
    `start_time` DATETIME NOT NULL COMMENT '开始时间',
    `end_time` DATETIME NOT NULL COMMENT '结束时间',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `remark` VARCHAR(20) DEFAULT NULL COMMENT '备注',
    `create_time` DATETIME NOT NULL COMMENT '编制时间',
    FOREIGN KEY(`s_id`) REFERENCES `gw_supplier`(`id`) ,
    FOREIGN KEY(`ct_id`) REFERENCES `gw_check_temp`(`id`) ,
    FOREIGN KEY(`c_id`) REFERENCES `gw_company`(`id`) ,
    FOREIGN KEY(`u_id`) REFERENCES `sys_user`(`id`) ,
    FOREIGN KEY(`inspector_id`) REFERENCES `sys_user`(`id`) ,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='岗位自检 计划';

-- ----------------------------
-- 岗位自检 计划详情
-- ----------------------------

DROP TABLE IF EXISTS `gw_quality_inspect_task_detail`;
CREATE TABLE `gw_quality_inspect_task_detail` (
    `id` BIGINT(19) NOT NULL  AUTO_INCREMENT COMMENT '主键id',
    `qit_id` BIGINT(19) DEFAULT NULL COMMENT '外键 岗位自检 计划id',
    `check_project` VARCHAR(200) DEFAULT NULL COMMENT '检查项目',
    `check_point` VARCHAR(50) DEFAULT NULL COMMENT '检查点',
    `frequency` VARCHAR(20) DEFAULT NULL COMMENT '频次',
    `qualified` BOOLEAN DEFAULT NULL COMMENT '是否合格',
    `score` VARCHAR(20) DEFAULT NULL COMMENT '得分/总分',
    `check_time` DATETIME DEFAULT NULL COMMENT '检查时间',
    `check_user` BIGINT(19) DEFAULT NULL COMMENT '检查人',
    `task_time` DATETIME NOT NULL COMMENT '计划时间',
    `sort` INTEGER(5) DEFAULT NULL COMMENT '排序',
    `enclosure` VARCHAR(20) DEFAULT NULL COMMENT '附件地址',
    `remark` VARCHAR(20) DEFAULT NULL COMMENT '备注',
    FOREIGN KEY(`qit_id`) REFERENCES `gw_quality_inspect_task`(`id`) ,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='岗位自检 计划详情';











