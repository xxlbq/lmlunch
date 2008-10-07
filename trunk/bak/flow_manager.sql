# EMS MySQL Manager Lite 3.2.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : flow_manager


SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `flow_manager`;

CREATE DATABASE `flow_manager`
    CHARACTER SET 'gb2312'
    COLLATE 'gb2312_chinese_ci';

USE `flow_manager`;

#
# Structure for the `t_cash_balance` table :
#

DROP TABLE IF EXISTS `t_cash_balance`;

CREATE TABLE `t_cash_balance` (
  `USER_ID` varchar(10) NOT NULL,
  `CASH_BALANCE` decimal(15,0) NOT NULL,
  `INPUT_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `UPDATE_DATE` timestamp NOT NULL default '0000-00-00 00:00:00',
  `ACTIVE_FLAG` int(1) NOT NULL,
  PRIMARY KEY  (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Structure for the `t_food` table :
#

DROP TABLE IF EXISTS `t_food`;

CREATE TABLE `t_food` (
  `FOOD_ID` int(4) NOT NULL auto_increment,
  `FOOD_NAME` varchar(20) NOT NULL,
  `FOOD_PROVIDER_ID` int(4) NOT NULL,
  `FOOD_PRICE` decimal(15,0) NOT NULL,
  `INPUT_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `UPDATE_DATE` timestamp NOT NULL,
  `DELETED_FLAG` int(1) default '0',
  PRIMARY KEY  (`FOOD_ID`),
  UNIQUE KEY `FOOD_NAME` (`FOOD_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for the `t_food` table  (LIMIT 0,500)
#

INSERT INTO `t_food` (`FOOD_ID`, `FOOD_NAME`, `FOOD_PROVIDER_ID`, `FOOD_PRICE`, `INPUT_DATE`, `UPDATE_DATE`, `DELETED_FLAG`) VALUES
  (1,'¼¦ÍÈ·¹',1,'8','2007-04-09 00:03:00','2007-04-08 00:00:00',0),
  (2,'Â±Èâ·¹',1,'7','2007-04-09 00:03:00','2007-04-08 00:00:00',0),
  (3,'¼¦¶¡·¹',1,'6','2007-04-09 00:03:01','2007-04-08 00:00:00',0),
  (4,'ÇÑ×Ó·¹',1,'5','2007-04-09 00:03:01','2007-04-08 00:00:00',0),
  (5,'ÓñÃ×·¹',1,'5','2007-04-09 00:03:02','2007-04-08 00:00:00',0),
  (6,'ºìÉÕÈâ·¹',1,'5','2007-04-09 00:03:03','2007-04-08 00:00:00',0),
  (7,'¼¦ÅÅ·¹',1,'8','2007-04-09 00:03:03','2007-04-08 00:00:00',0),
  (8,'5ÔªÌ×²Í',2,'5','2007-04-09 00:03:06','2007-04-08 00:00:00',0),
  (9,'6ÔªÌ×²Í',2,'6','2007-04-09 00:03:08','2007-04-08 00:00:00',0);

COMMIT;

#
# Structure for the `t_food_provider` table :
#

DROP TABLE IF EXISTS `t_food_provider`;

CREATE TABLE `t_food_provider` (
  `FOOD_PROVIDER_ID` int(4) NOT NULL auto_increment,
  `FOOD_PROVIDER_NAME` varchar(20) NOT NULL,
  `FOOD_PROVIDER_ADDRESS` varchar(50) default NULL,
  `FOOD_PROVIDER_PHONE` varchar(15) NOT NULL,
  `INPUT_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `UPDATE_DATE` timestamp NOT NULL default '0000-00-00 00:00:00',
  `ACTIVE_FLAG` int(1) default '1',
  PRIMARY KEY  (`FOOD_PROVIDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for the `t_food_provider` table  (LIMIT 0,500)
#

INSERT INTO `t_food_provider` (`FOOD_PROVIDER_ID`, `FOOD_PROVIDER_NAME`, `FOOD_PROVIDER_ADDRESS`, `FOOD_PROVIDER_PHONE`, `INPUT_DATE`, `UPDATE_DATE`, `ACTIVE_FLAG`) VALUES
  (1,'±¦±¦Ã×','´ó¹¤±±ÃÅ','000','2007-08-15 23:09:34','2007-04-08 00:00:00',1),
  (2,'æ¤æ¤','»ðÐÇÐÇËÞº£','000','2007-08-15 23:10:16','2007-04-08 00:00:00',1);

COMMIT;

#
# Structure for the `t_group` table :
#

DROP TABLE IF EXISTS `t_group`;

CREATE TABLE `t_group` (
  `GROUP_ID` int(4) NOT NULL auto_increment,
  `GROUP_NAME` varchar(30) NOT NULL,
  `GROUP_LEVEL_RELATION` varchar(300) NOT NULL,
  `GROUP_FATHER` int(4) default NULL,
  `INPUT_USER_ID` int(10) NOT NULL,
  `INPUT_DATETIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `UPDATE_USER_ID` int(10) default NULL,
  `UPDATE_DATETIME` timestamp NOT NULL default '0000-00-00 00:00:00',
  `DELETED_FLAG` int(1) NOT NULL,
  `GROUP_DESC` varchar(500) default NULL,
  PRIMARY KEY  (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for the `t_group` table  (LIMIT 0,500)
#

INSERT INTO `t_group` (`GROUP_ID`, `GROUP_NAME`, `GROUP_LEVEL_RELATION`, `GROUP_FATHER`, `INPUT_USER_ID`, `INPUT_DATETIME`, `UPDATE_USER_ID`, `UPDATE_DATETIME`, `DELETED_FLAG`, `GROUP_DESC`) VALUES
  (1,'test','aaaa',NULL,1,'2006-08-29 10:00:40',NULL,'2006-08-29 10:00:40',1,NULL),
  (2,'test2','bbbb',NULL,2,'2006-08-29 22:35:35',NULL,'2006-08-29 22:35:35',0,NULL),
  (3,'test3','cccc',NULL,9,'2006-08-29 22:35:35',NULL,'2006-08-29 22:35:35',1,NULL);

COMMIT;

#
# Structure for the `t_group_source` table :
#

DROP TABLE IF EXISTS `t_group_source`;

CREATE TABLE `t_group_source` (
  `GROUP_SOURCE_ID` int(10) NOT NULL auto_increment,
  `GROUP_ID` int(10) NOT NULL,
  `SOURCE_ID` int(10) NOT NULL,
  `INPUT_USER_ID` int(10) NOT NULL,
  `INPUT_DATETIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `UPDATE_USER_ID` int(10) default NULL,
  `UPDATE_DATETIME` timestamp NOT NULL default '0000-00-00 00:00:00',
  `DELETED_FLAG` int(10) NOT NULL,
  `GROUP_SOURCE_DESC` varchar(500) default NULL,
  PRIMARY KEY  (`GROUP_SOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for the `t_group_source` table  (LIMIT 0,500)
#

INSERT INTO `t_group_source` (`GROUP_SOURCE_ID`, `GROUP_ID`, `SOURCE_ID`, `INPUT_USER_ID`, `INPUT_DATETIME`, `UPDATE_USER_ID`, `UPDATE_DATETIME`, `DELETED_FLAG`, `GROUP_SOURCE_DESC`) VALUES
  (1,2,1,1,'2006-08-31 11:50:34',1,'2006-08-29 22:35:35',0,'this is test1'),
  (2,3,1,2,'2006-08-31 14:50:39',2,'2006-08-29 22:35:35',1,'this is test2'),
  (3,3,4,3,'2006-08-31 11:50:51',3,'2006-08-29 22:35:35',0,'this is test3'),
  (4,1,4,4,'2006-08-31 15:32:42',4,'2006-08-29 22:35:35',0,'this is test4'),
  (5,3,5,5,'2006-08-31 15:31:13',5,'2006-08-29 22:35:35',0,'this is test5'),
  (6,3,4,6,'2006-08-31 15:31:13',6,'2006-08-29 22:35:35',0,'this is test6'),
  (7,3,7,7,'2006-08-31 15:31:12',7,'2006-08-29 22:35:35',0,'this is test7'),
  (8,3,2,8,'2006-09-02 15:08:07',8,'2006-08-29 22:35:35',0,'this is test8'),
  (9,3,8,9,'2006-08-31 15:31:59',9,'2006-08-29 22:35:35',0,'this is test9'),
  (11,2,8,999,'2006-08-31 15:32:00',999,'2006-08-30 14:18:23',1,'update is done'),
  (13,1,1,999,'2006-08-31 11:50:29',999,'2006-08-31 11:07:50',1,'update is done~~'),
  (14,999,999,999,'2006-09-02 11:24:45',999,'2006-09-02 11:24:45',1,'this is test add');

COMMIT;

#
# Structure for the `t_group_user` table :
#

DROP TABLE IF EXISTS `t_group_user`;

CREATE TABLE `t_group_user` (
  `GROUP_USER_ID` int(10) NOT NULL auto_increment,
  `GROUP_ID` int(10) NOT NULL,
  `USER_ID` int(10) NOT NULL,
  `INPUT_USER_ID` int(10) NOT NULL,
  `INPUT_DATETIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `GROUP_USER_DESC` varchar(500) default NULL,
  PRIMARY KEY  (`GROUP_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Structure for the `t_log` table :
#

DROP TABLE IF EXISTS `t_log`;

CREATE TABLE `t_log` (
  `LOG_ID` int(10) NOT NULL auto_increment,
  `USER_ID` int(10) NOT NULL,
  `GROUP_SOURCE_ID` int(10) NOT NULL,
  `LOG_MESSAGE` varchar(500) NOT NULL,
  `INPUTE_DATETIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for the `t_log` table  (LIMIT 0,500)
#

INSERT INTO `t_log` (`LOG_ID`, `USER_ID`, `GROUP_SOURCE_ID`, `LOG_MESSAGE`, `INPUTE_DATETIME`) VALUES
  (1,1,1,'add one data','2006-08-23 16:19:32'),
  (2,1,1,'add one data','2006-08-23 16:28:44'),
  (3,1,1,'add one data','2006-08-23 16:36:10'),
  (4,1,1,'add one data','2006-08-23 16:40:29'),
  (5,1,1,'add one data','2006-08-23 16:41:56'),
  (6,1,1,'add one data','2006-08-23 16:45:08'),
  (7,1,1,'add one data','2006-08-24 16:27:28'),
  (8,1,1,'add one data','2006-08-24 16:31:08'),
  (9,1,1,'add one data','2006-08-24 16:32:44');

COMMIT;

#
# Structure for the `t_log_his` table :
#

DROP TABLE IF EXISTS `t_log_his`;

CREATE TABLE `t_log_his` (
  `LOG_ID` int(10) NOT NULL auto_increment,
  `USER_ID` int(10) NOT NULL,
  `GROUP_SOURCE_ID` int(10) NOT NULL,
  `LOG_MESSAGE` varchar(500) NOT NULL,
  `INPUTE_DATETIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for the `t_log_his` table  (LIMIT 0,500)
#

INSERT INTO `t_log_his` (`LOG_ID`, `USER_ID`, `GROUP_SOURCE_ID`, `LOG_MESSAGE`, `INPUTE_DATETIME`) VALUES
  (1,2,3,'sdfsdfsdfsdf','2006-08-23 00:00:00');

COMMIT;

#
# Structure for the `t_role` table :
#

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `ROLE_ID` int(4) NOT NULL auto_increment,
  `ROLE_NAME` varchar(150) default 'IS_AUTHENTICATED_ANONYMOUSLY',
  `INPUT_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `UPDATE_DATE` timestamp NOT NULL default '0000-00-00 00:00:00',
  `DELETED_FLAG` int(4) NOT NULL default '0',
  PRIMARY KEY  (`ROLE_ID`),
  UNIQUE KEY `input_date` (`INPUT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for the `t_role` table  (LIMIT 0,500)
#

INSERT INTO `t_role` (`ROLE_ID`, `ROLE_NAME`, `INPUT_DATE`, `UPDATE_DATE`, `DELETED_FLAG`) VALUES
  (1,'ROLE_SUPERVISOR','2008-07-17 22:43:56','2007-04-22 00:00:09',0),
  (2,'ROLE_NORMAL','2007-04-22 22:44:13','2007-04-23 00:00:00',0),
  (3,'ROLE_ANONYMOUS','2007-04-22 22:44:29','2007-04-19 00:00:00',0),
  (4,'IS_AUTHENTICATED_ANONYMOUSLY','2007-06-06 00:00:00','2007-06-06 00:00:00',0);

COMMIT;

#
# Structure for the `t_source` table :
#

DROP TABLE IF EXISTS `t_source`;

CREATE TABLE `t_source` (
  `SOURCE_ID` int(10) NOT NULL auto_increment,
  `SOURCE_NAME` varchar(30) NOT NULL,
  `SOURCE_FOOD_ID` int(10) NOT NULL,
  `SOURCE_FOOD_COUNT` int(10) NOT NULL default '0',
  `SOURCE_FOOD_SUM` decimal(10,2) NOT NULL default '0.00',
  `INPUT_USER_ID` int(10) NOT NULL,
  `INPUT_DATETIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `UPDATE_USER_ID` int(10) default NULL,
  `UPDATE_DATETIME` timestamp NOT NULL default '0000-00-00 00:00:00',
  `DELETED_FLAG` int(10) NOT NULL,
  PRIMARY KEY  (`SOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for the `t_source` table  (LIMIT 0,500)
#

INSERT INTO `t_source` (`SOURCE_ID`, `SOURCE_NAME`, `SOURCE_FOOD_ID`, `SOURCE_FOOD_COUNT`, `SOURCE_FOOD_SUM`, `INPUT_USER_ID`, `INPUT_DATETIME`, `UPDATE_USER_ID`, `UPDATE_DATETIME`, `DELETED_FLAG`) VALUES
  (1,'a123',1,0,'0.00',1,'2007-04-04 21:32:54',3,'2006-09-11 22:10:40',1),
  (2,'plum_313',2,200,'0.00',2,'2007-04-04 21:33:03',2,'2007-09-16 08:25:05',0),
  (3,'abc',3,0,'0.00',2,'2007-04-04 21:33:07',3,'2007-07-11 23:55:45',0),
  (4,'dsss',3,0,'0.00',2,'2007-04-04 21:33:12',2,'2006-09-11 21:48:57',0),
  (5,'CACHE',4,0,'0.00',1,'2007-04-04 21:33:15',2,'2006-09-11 22:12:48',1),
  (6,'ff',5,0,'0.00',2,'2007-04-04 21:33:17',2,'2006-08-29 14:40:46',0),
  (7,'again',3,0,'0.00',1,'2007-04-04 21:33:23',3,'2006-08-29 14:40:46',0),
  (8,'globle',4,0,'0.00',1,'2007-04-04 21:33:25',3,'2006-08-29 14:40:46',0),
  (9,'ibm',3,0,'0.00',1,'2007-04-04 21:33:31',1,'2006-09-02 15:33:27',0),
  (10,'addone-update',2,0,'0.00',2,'2007-04-04 21:33:34',1,'2006-09-12 09:09:14',0),
  (11,'111',1,0,'0.00',1,'2007-04-04 21:33:36',2,'2006-09-06 23:31:13',0),
  (12,'lm01',5,0,'0.00',1,'2007-04-04 21:33:48',2,'2006-09-14 21:41:23',0),
  (13,'heartbro',6,0,'0.00',1,'2007-04-04 21:33:51',2,'2007-09-06 20:56:03',0),
  (14,'gone',5,0,'0.00',1,'2007-04-04 21:34:04',2,'2006-09-07 22:32:03',0),
  (15,'one',1,0,'0.00',1,'2007-04-04 21:34:07',2,'2006-09-07 22:43:03',0),
  (16,'two',2,0,'0.00',1,'2007-04-04 21:34:10',2,'2006-09-07 22:51:51',0),
  (17,'test6',3,0,'0.00',1,'2007-04-04 21:34:20',2,'2006-09-07 22:55:43',0),
  (18,'test7',2,0,'0.00',1,'2007-04-04 21:34:31',2,'2006-09-07 22:56:05',0),
  (19,'444',3,0,'0.00',1,'2007-04-04 21:34:32',2,'2006-09-07 22:58:25',0),
  (20,'us',4,0,'0.00',1,'2007-04-04 21:34:32',2,'2006-09-07 23:04:30',0),
  (21,'qqq',5,0,'0.00',1,'2007-04-04 21:34:33',2,'2006-09-07 23:07:25',0),
  (22,'i change it',2,0,'0.00',1,'2007-04-04 21:34:34',2,'2007-03-25 09:58:47',0),
  (23,'l',4,0,'0.00',1,'2007-04-04 21:34:36',2,'2006-09-07 23:17:17',0),
  (24,'hand',3,0,'0.00',3,'2007-04-04 21:34:34',3,'2006-09-11 09:16:59',0),
  (25,'lee',4,0,'0.00',3,'2007-04-04 21:34:35',3,'2006-09-11 21:05:12',0),
  (26,'lm06',6,0,'0.00',3,'2007-04-04 21:34:38',3,'2006-09-13 00:36:13',1),
  (27,'spring01',1,0,'0.00',3,'2007-04-04 21:34:46',3,'2006-11-19 18:16:52',0),
  (28,'LM',4,0,'0.00',3,'2007-04-04 21:34:39',3,'2007-03-25 08:52:21',0),
  (29,'ball',3,0,'0.00',3,'2007-04-04 21:34:40',3,'2007-04-02 20:37:59',0),
  (30,'1155',2,2,'14.00',3,'2007-07-11 01:51:15',3,'2007-07-11 01:51:15',0),
  (31,'fuk',1,20,'160.00',3,'2007-07-11 22:45:40',3,'2007-07-11 22:45:40',0),
  (32,'t60',4,3,'15.00',3,'2007-07-23 22:59:12',3,'2007-07-23 22:59:12',0);

COMMIT;

#
# Structure for the `t_sys_balance` table :
#

DROP TABLE IF EXISTS `t_sys_balance`;

CREATE TABLE `t_sys_balance` (
  `SYS_ID` varchar(30) NOT NULL,
  `USER_ID` varchar(10) NOT NULL,
  `CASH_BALANCE` decimal(15,0) NOT NULL,
  `INPUT_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `UPDATE_DATE` timestamp NOT NULL default '0000-00-00 00:00:00',
  `ACTIVE_FLAG` int(1) NOT NULL,
  PRIMARY KEY  (`SYS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Structure for the `t_user` table :
#

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `USER_ID` int(10) NOT NULL auto_increment,
  `USER_NAME` varchar(30) NOT NULL,
  `USER_PASSWORD` varchar(30) NOT NULL,
  `USER_ROLE` int(10) default NULL,
  `USER_PHOTO` varchar(30) default NULL,
  `USER_EMAIL` varchar(30) default NULL,
  `USER_MSN` varchar(30) default NULL,
  `USER_SKYPE` varchar(30) default NULL,
  `ACCOUNT_NON_EXPIRED` int(4) NOT NULL default '0',
  `ACCOUNT_NON_LOCKED` int(4) NOT NULL default '0',
  `CREDENTIALS_NON_EXPIRED` int(4) NOT NULL default '0',
  `INPUT_USER_ID` int(10) NOT NULL,
  `INPUT_DATETIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `UPDATE_USER_ID` int(10) default NULL,
  `UPDATE_DATETIME` timestamp NOT NULL default '0000-00-00 00:00:00',
  `DELETED_FLAG` int(1) NOT NULL,
  `USER_DESC` varchar(500) default NULL,
  PRIMARY KEY  (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Data for the `t_user` table  (LIMIT 0,500)
#

INSERT INTO `t_user` (`USER_ID`, `USER_NAME`, `USER_PASSWORD`, `USER_ROLE`, `USER_PHOTO`, `USER_EMAIL`, `USER_MSN`, `USER_SKYPE`, `ACCOUNT_NON_EXPIRED`, `ACCOUNT_NON_LOCKED`, `CREDENTIALS_NON_EXPIRED`, `INPUT_USER_ID`, `INPUT_DATETIME`, `UPDATE_USER_ID`, `UPDATE_DATETIME`, `DELETED_FLAG`, `USER_DESC`) VALUES
  (1,'Mary','1111',2,NULL,NULL,NULL,NULL,0,1,1,1,'2007-09-10 01:27:02',NULL,'2006-01-02 00:00:00',0,NULL),
  (2,'Tom','2222',3,NULL,NULL,NULL,NULL,1,1,1,2,'2007-05-17 21:10:50',NULL,'2006-02-02 00:00:00',0,NULL),
  (3,'MEI','3333',1,NULL,NULL,NULL,NULL,1,1,1,3,'2008-05-18 22:18:27',NULL,'2006-01-02 00:00:00',0,NULL);

COMMIT;

#
# Structure for the `t_user_group_source` table :
#

DROP TABLE IF EXISTS `t_user_group_source`;

CREATE TABLE `t_user_group_source` (
  `USER_GROUP_SOURCE_ID` int(10) NOT NULL auto_increment,
  `USER_ID` int(10) NOT NULL,
  `GROUP_SOURCE_ID` int(10) NOT NULL,
  `USER_GROUP_SOURCE_DESC` varchar(500) default NULL,
  PRIMARY KEY  (`USER_GROUP_SOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;






#
# Structure for the `t_role_action` table :
#



DROP TABLE IF EXISTS `t_role_action`;

CREATE TABLE t_role_action (
  `MENU_SEQ` varchar(8) NOT NULL,
  `ROLE_ACTION_URL` varchar(255) default NULL,
  `ROLE_ACTION_NAME` varchar(255) default NULL,
  `DISPLAY_ORDER` int (10) default NULL,
  `PARENT_MENU_SEQ` varchar(8) default NULL,
  `UPDATE_STAFF_ID` varchar(6) default NULL,
  `INPUT_STAFF_ID` varchar(6) default NULL,
  `ACTIVE_FLAG` int (1) default NULL,
  `INPUT_DATE` timestamp NULL default NULL,
  `UPDATE_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`MENU_SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
	

-- parent menu

INSERT INTO t_role_action(MENU_SEQ, ROLE_ACTION_URL, ROLE_ACTION_NAME, DISPLAY_ORDER, PARENT_MENU_SEQ, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES('R001', '(boy.do)', 'boy', 1, NULL, 'CS0001', 'CS0001', 1, '2007-07-07 17:32:37.0', '2007-07-07 17:32:37.0');
INSERT INTO t_role_action(MENU_SEQ, ROLE_ACTION_URL, ROLE_ACTION_NAME, DISPLAY_ORDER, PARENT_MENU_SEQ, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES('R002', '(girl.do)', 'girl', 2, NULL, 'CS0001', 'CS0001', 1, '2007-07-07 17:32:37.0', '2007-07-07 17:32:37.0');


-- son menu	
	
INSERT INTO t_role_action(MENU_SEQ, ROLE_ACTION_URL, ROLE_ACTION_NAME, DISPLAY_ORDER, PARENT_MENU_SEQ, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES('R00101', '(lubq_jack.do)', 'jack', 1, 'R001', 'CS0001', 'CS0001', 1, '2007-07-07 17:32:37.0', '2007-07-07 17:32:37.0');

INSERT INTO t_role_action(MENU_SEQ, ROLE_ACTION_URL, ROLE_ACTION_NAME, DISPLAY_ORDER, PARENT_MENU_SEQ, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES('R00102', '(lubq_tom.do)', 'tom', 2, 'R001', 'CS0001', 'CS0001', 1, '2007-07-07 17:32:37.0', '2007-07-07 17:32:37.0');

INSERT INTO t_role_action(MENU_SEQ, ROLE_ACTION_URL, ROLE_ACTION_NAME, DISPLAY_ORDER, PARENT_MENU_SEQ, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES('R00201', '(lubq_rose.do)', 'rose', 1, 'R002', 'CS0001', 'CS0001', 1, '2007-07-07 17:32:37.0', '2007-07-07 17:32:37.0');

INSERT INTO t_role_action(MENU_SEQ, ROLE_ACTION_URL, ROLE_ACTION_NAME, DISPLAY_ORDER, PARENT_MENU_SEQ, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES('R00202', '(lubq_marry.do)', 'marry', 2, 'R002', 'CS0001', 'CS0001', 1, '2007-07-07 17:32:37.0', '2007-07-07 17:32:37.0');







#
# Structure for the `t_role_action` table :
#



DROP TABLE IF EXISTS `t_role_authority`;

CREATE TABLE `t_role_authority` (
  `ROLE_ID` int (10) NOT NULL,
  `MENU_SEQ` varchar(8) NOT NULL,
  `SELECTED_FLAG` int (1) default NULL,
  `UPDATE_STAFF_ID` varchar(6) default NULL,
  `INPUT_STAFF_ID` varchar(6) default NULL,
  `ACTIVE_FLAG` int (1) default NULL,
  `INPUT_DATE` timestamp NULL default NULL,
  `UPDATE_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`ROLE_ID`,`MENU_SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

INSERT INTO t_role_authority(ROLE_ID, MENU_SEQ, SELECTED_FLAG, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES(1, 'R001', 1, 'CS0001', 'CS0001', 1, '2007-07-07 16:42:37.0', '2008-04-10 16:51:41.0');
INSERT INTO t_role_authority(ROLE_ID, MENU_SEQ, SELECTED_FLAG, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES(1, 'R002', 1, 'CS0001', 'CS0001', 1, '2007-07-07 16:42:37.0', '2007-07-07 00:00:00.0');

INSERT INTO t_role_authority(ROLE_ID, MENU_SEQ, SELECTED_FLAG, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES(1, 'R00101', 1, 'CS0001', 'CS0001', 1, '2007-07-07 16:42:37.0', '2007-07-07 00:00:00.0');
INSERT INTO t_role_authority(ROLE_ID, MENU_SEQ, SELECTED_FLAG, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES(1, 'R00102', 1, 'CS0001', 'CS0001', 1, '2007-07-07 16:42:37.0', '2007-07-07 00:00:00.0');

INSERT INTO t_role_authority(ROLE_ID, MENU_SEQ, SELECTED_FLAG, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES(1, 'R00201', 1, 'CS0001', 'CS0001', 1, '2007-07-07 16:42:37.0', '2007-07-07 00:00:00.0');
INSERT INTO t_role_authority(ROLE_ID, MENU_SEQ, SELECTED_FLAG, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES(1, 'R00202', 1, 'CS0001', 'CS0001', 1, '2007-07-07 16:42:37.0', '2007-07-07 00:00:00.0');



INSERT INTO t_role_authority(ROLE_ID, MENU_SEQ, SELECTED_FLAG, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES(2, 'R001', 1, 'CS0001', 'CS0001', 1, '2007-07-07 16:42:37.0', '2007-07-07 00:00:00.0');
INSERT INTO t_role_authority(ROLE_ID, MENU_SEQ, SELECTED_FLAG, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES(2, 'R00101', 1, 'CS0001', 'CS0001', 1, '2007-07-07 16:42:37.0', '2007-07-07 00:00:00.0');
INSERT INTO t_role_authority(ROLE_ID, MENU_SEQ, SELECTED_FLAG, UPDATE_STAFF_ID, INPUT_STAFF_ID, ACTIVE_FLAG, INPUT_DATE, UPDATE_DATE)
  VALUES(2, 'R00102', 1, 'CS0001', 'CS0001', 1, '2007-07-07 16:42:37.0', '2007-07-07 00:00:00.0');


-- ROLE_ID  1  AND PARENT_ACTION_SEQ = 'R001'

SELECT * FROM  t_role_action WHERE PARENT_MENU_SEQ =(SELECT ACT.`PARENT_MENU_SEQ` FROM  t_role_action AS ACT LEFT OUTER JOIN t_role_authority AS AUT ON AUT.`MENU_SEQ` =ACT.`MENU_SEQ`
       WHERE AUT.ROLE_ID = 1 AND INSTR(ACT.ROLE_ACTION_URL,'jack.do') > 0 AND AUT.`SELECTED_FLAG` = 1 )




SELECT * FROM  t_role_action AS ACT LEFT OUTER JOIN t_role_authority AS AUT ON AUT.ROLE_ACTION_SEQ =ACT.ROLE_ACTION_SEQ
       WHERE AUT.ROLE_ID = 1 AND ACT.PARENT_ACTION_SEQ = 'R001'


SELECT CASE WHEN PARENT_MENU_SEQ IS NULL THEN NULL ELSE PARENT_MENU_SEQ END
FROM `t_role_action` WHERE INSTR(ROLE_ACTION_URL,'jack.do') > 0

SELECT CASE WHEN PARENT_MENU_SEQ IS NULL THEN NULL ELSE PARENT_MENU_SEQ END
FROM `t_role_action` WHERE INSTR(ROLE_ACTION_URL,'boy.do') > 0

SELECT * FROM t_role_authority WHERE ROLE_ID = 1 and SELECTED_FLAG = 1
SELECT * FROM t_role_action WHERE PARENT_MENU_SEQ IS NULL AND (SELECT * FROM t_role_authority WHERE ROLE_ID = 1 and SELECTED_FLAG = 1 );







SELECT ACT.`MENU_SEQ`,ACT.`ROLE_ACTION_URL`,ACT.`ROLE_ACTION_NAME`,ACT.`DISPLAY_ORDER` FROM  t_role_action AS ACT , t_role_authority AS AUT
       WHERE  AUT.`MENU_SEQ` =ACT.`MENU_SEQ` AND AUT.ROLE_ID = 1 AND AUT.`SELECTED_FLAG`=1 AND ACT.`PARENT_MENU_SEQ` IS NULL


SELECT ACT.`MENU_SEQ`,ACT.`ROLE_ACTION_URL`,ACT.`ROLE_ACTION_NAME`,ACT.`DISPLAY_ORDER` FROM  t_role_action AS ACT , t_role_authority AS AUT
       WHERE  AUT.`MENU_SEQ` =ACT.`MENU_SEQ` AND AUT.ROLE_ID = 1 AND AUT.`SELECTED_FLAG`=1 AND ACT.PARENT_MENU_SEQ =(SELECT CASE PARENT_MENU_SEQ WHEN (PARENT_MENU_SEQ IS NULL )THEN MENU_SEQ ELSE PARENT_MENU_SEQ END FROM `t_role_action` where INSTR(ROLE_ACTION_URL,'jack.do') > 0)



    select
        roleaction0_.MENU_SEQ as col_0_0_,
        roleaction0_.ROLE_ACTION_URL as col_1_0_,
        roleaction0_.ROLE_ACTION_NAME as col_2_0_,
        roleaction0_.DISPLAY_ORDER as col_3_0_
    from
        t_role_action roleaction0_,
        t_role_authority roleauthor1_
    where
        roleauthor1_.MENU_SEQ=roleaction0_.MENU_SEQ
        and roleauthor1_.ROLE_ID=1
        and roleauthor1_.SELECTED_FLAG=1
        and roleaction0_.PARENT_MENU_SEQ=(
            select
                roleaction2_.PARENT_MENU_SEQ
            from
                t_role_action roleaction2_
            where
                INSTR(roleaction2_.ROLE_ACTION_URL, 'boy.do')>0
        )
        
        
        
        
        SELECT
        CASE PARENT_MENU_SEQ
        WHEN (PARENT_MENU_SEQ IS NULL )THEN MENU_SEQ
        WHEN PARENT_MENU_SEQ IS NOT NULL THEN PARENT_MENU_SEQ
        END 
        FROM `t_role_action` where INSTR(ROLE_ACTION_URL,'boy.do') > 0
        
        
        
        
        SELECT PARENT_MENU_SEQ FROM `t_role_action` where INSTR(ROLE_ACTION_URL,'boy.do') > 0

