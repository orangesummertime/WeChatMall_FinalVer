/*
SQLyog Ultimate v11.3 (64 bit)
MySQL - 5.7.32-log : Database - lingshipifajiaoyi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lingshipifajiaoyi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lingshipifajiaoyi`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yonghu_id` int(20) NOT NULL COMMENT '创建用户',
  `address_name` varchar(200) NOT NULL COMMENT '收货人 ',
  `address_phone` varchar(200) NOT NULL COMMENT '电话 ',
  `address_dizhi` varchar(200) NOT NULL COMMENT '地址 ',
  `isdefault_types` int(11) NOT NULL COMMENT '是否默认地址 ',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 show3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='收货地址';

/*Data for the table `address` */

insert  into `address`(`id`,`yonghu_id`,`address_name`,`address_phone`,`address_dizhi`,`isdefault_types`,`insert_time`,`update_time`,`create_time`) values (1,2,'收货人1','17703786901','地址1',1,'2023-02-14 09:33:17','2023-02-14 09:33:17','2023-02-14 09:33:17'),(2,2,'收货人2','17703786902','地址2',1,'2023-02-14 09:33:17','2023-02-14 09:33:17','2023-02-14 09:33:17'),(3,1,'收货人3','17703786903','地址3',1,'2023-02-14 09:33:17','2023-02-14 09:33:17','2023-02-14 09:33:17'),(4,2,'收货人4','17703786904','地址4',1,'2023-02-14 09:33:17','2023-02-14 09:33:17','2023-02-14 09:33:17'),(5,3,'收货人5','17703786905','地址5',1,'2023-02-14 09:33:17','2023-02-14 09:33:17','2023-02-14 09:33:17'),(6,5,'张6','17703769696','河南省郑州市金水区东风路16号郑州市金水区人民政府(东风路北)',2,'2023-02-14 13:33:03','2023-02-14 13:33:03','2023-02-14 13:33:03');

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '所属用户',
  `shangpin_id` int(11) DEFAULT NULL COMMENT '零食',
  `buy_number` int(11) DEFAULT NULL COMMENT '购买数量',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='购物车';

/*Data for the table `cart` */

insert  into `cart`(`id`,`yonghu_id`,`shangpin_id`,`buy_number`,`create_time`,`update_time`,`insert_time`) values (2,1,2,1,'2023-02-14 13:05:46',NULL,'2023-02-14 13:05:46'),(3,1,3,1,'2023-02-14 13:06:01',NULL,'2023-02-14 13:06:01');

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';

/*Data for the table `config` */

insert  into `config`(`id`,`name`,`value`) values (1,'轮播图1111','upload/config1.jpg'),(2,'轮播图2','upload/config2.jpg'),(3,'轮播图3','upload/config3.jpg');

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字段名',
  `code_index` int(11) DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int(11) DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='字典';

/*Data for the table `dictionary` */

insert  into `dictionary`(`id`,`dic_code`,`dic_name`,`code_index`,`index_name`,`super_id`,`beizhu`,`create_time`) values (1,'sex_types','性别类型',1,'男',NULL,NULL,'2023-02-14 09:27:27'),(2,'sex_types','性别类型',2,'女',NULL,NULL,'2023-02-14 09:27:27'),(3,'shangxia_types','上下架',1,'上架',NULL,NULL,'2023-02-14 09:27:27'),(4,'shangxia_types','上下架',2,'下架',NULL,NULL,'2023-02-14 09:27:27'),(5,'shangpin_types','零食类型',1,'零食类型1',NULL,NULL,'2023-02-14 09:27:27'),(6,'shangpin_types','零食类型',2,'零食类型2',NULL,NULL,'2023-02-14 09:27:27'),(7,'shangpin_types','零食类型',3,'零食类型3',NULL,NULL,'2023-02-14 09:27:27'),(8,'shangpin_types','零食类型',4,'零食类型4',NULL,NULL,'2023-02-14 09:27:27'),(9,'shangpin_collection_types','收藏表类型',1,'收藏',NULL,NULL,'2023-02-14 09:27:27'),(10,'shangpin_order_types','订单类型',1,'已支付',NULL,NULL,'2023-02-14 09:27:27'),(11,'shangpin_order_types','订单类型',2,'退款',NULL,NULL,'2023-02-14 09:27:28'),(12,'shangpin_order_types','订单类型',3,'已发货',NULL,NULL,'2023-02-14 09:27:28'),(13,'shangpin_order_types','订单类型',4,'已收货',NULL,NULL,'2023-02-14 09:27:28'),(14,'shangpin_order_types','订单类型',5,'已评价',NULL,NULL,'2023-02-14 09:27:28'),(15,'shangpin_order_payment_types','订单支付类型',1,'余额',NULL,NULL,'2023-02-14 09:27:28'),(16,'isdefault_types','是否默认地址',1,'否',NULL,NULL,'2023-02-14 09:27:28'),(17,'isdefault_types','是否默认地址',2,'是',NULL,NULL,'2023-02-14 09:27:28'),(18,'shangpin_types','零食类型',5,'零食类型5',NULL,'','2023-02-14 13:41:16');

/*Table structure for table `shangpin` */

DROP TABLE IF EXISTS `shangpin`;

CREATE TABLE `shangpin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `shangpin_name` varchar(200) DEFAULT NULL COMMENT '零食名称  Search111 ',
  `shangpin_uuid_number` varchar(200) DEFAULT NULL COMMENT '零食编号',
  `shangpin_photo` varchar(200) DEFAULT NULL COMMENT '零食照片',
  `shangpin_types` int(11) DEFAULT NULL COMMENT '零食类型 Search111',
  `shangpin_kucun_number` int(11) DEFAULT NULL COMMENT '零食库存/箱',
  `shangpin_old_money` decimal(10,2) DEFAULT NULL COMMENT '零食原价 ',
  `shangpin_new_money` decimal(10,2) DEFAULT NULL COMMENT '现价',
  `shangpin_clicknum` int(11) DEFAULT NULL COMMENT '零食热度 ',
  `shangpin_content` text COMMENT '零食介绍 ',
  `shangxia_types` int(11) DEFAULT NULL COMMENT '是否上架 ',
  `shangpin_delete` int(11) DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='零食';

/*Data for the table `shangpin` */

insert  into `shangpin`(`id`,`shangpin_name`,`shangpin_uuid_number`,`shangpin_photo`,`shangpin_types`,`shangpin_kucun_number`,`shangpin_old_money`,`shangpin_new_money`,`shangpin_clicknum`,`shangpin_content`,`shangxia_types`,`shangpin_delete`,`insert_time`,`create_time`) values (1,'零食名称1','1676338398054','upload/shangpin1.jpg',2,9,'681.62','104.16',137,'零食介绍1',1,1,'2023-02-14 09:33:17','2023-02-14 09:33:17'),(2,'零食名称2','1676338398017','upload/shangpin2.jpg',3,101,'729.45','434.62',75,'零食介绍2',1,1,'2023-02-14 09:33:17','2023-02-14 09:33:17'),(3,'零食名称3','1676338398064','upload/shangpin3.jpg',3,101,'982.75','68.02',314,'零食介绍3',1,1,'2023-02-14 09:33:17','2023-02-14 09:33:17'),(4,'零食名称4','1676338398001','upload/shangpin4.jpg',4,103,'795.57','296.59',243,'零食介绍4',1,1,'2023-02-14 09:33:17','2023-02-14 09:33:17'),(5,'零食名称5','1676338397973','upload/shangpin5.jpg',1,103,'782.33','274.05',453,'零食介绍5',1,1,'2023-02-14 09:33:17','2023-02-14 09:33:17');

/*Table structure for table `shangpin_collection` */

DROP TABLE IF EXISTS `shangpin_collection`;

CREATE TABLE `shangpin_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shangpin_id` int(11) DEFAULT NULL COMMENT '零食',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `shangpin_collection_types` int(11) DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='零食收藏';

/*Data for the table `shangpin_collection` */

insert  into `shangpin_collection`(`id`,`shangpin_id`,`yonghu_id`,`shangpin_collection_types`,`insert_time`,`create_time`) values (1,1,2,1,'2023-02-14 09:33:17','2023-02-14 09:33:17'),(2,2,2,1,'2023-02-14 09:33:17','2023-02-14 09:33:17'),(3,3,2,1,'2023-02-14 09:33:17','2023-02-14 09:33:17'),(4,4,3,1,'2023-02-14 09:33:17','2023-02-14 09:33:17'),(5,5,3,1,'2023-02-14 09:33:17','2023-02-14 09:33:17'),(6,3,5,1,'2023-02-14 13:33:44','2023-02-14 13:33:44');

/*Table structure for table `shangpin_commentback` */

DROP TABLE IF EXISTS `shangpin_commentback`;

CREATE TABLE `shangpin_commentback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shangpin_id` int(11) DEFAULT NULL COMMENT '零食',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `shangpin_commentback_text` text COMMENT '评价内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '评价时间',
  `reply_text` text COMMENT '回复内容',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='零食评价';

/*Data for the table `shangpin_commentback` */

insert  into `shangpin_commentback`(`id`,`shangpin_id`,`yonghu_id`,`shangpin_commentback_text`,`insert_time`,`reply_text`,`update_time`,`create_time`) values (1,1,2,'评价内容1','2023-02-14 09:33:17','回复信息1','2023-02-14 09:33:17','2023-02-14 09:33:17'),(2,2,2,'评价内容2','2023-02-14 09:33:17','回复信息2','2023-02-14 09:33:17','2023-02-14 09:33:17'),(3,3,1,'评价内容3','2023-02-14 09:33:17','回复信息3','2023-02-14 09:33:17','2023-02-14 09:33:17'),(4,4,1,'评价内容4','2023-02-14 09:33:17','回复信息4','2023-02-14 09:33:17','2023-02-14 09:33:17'),(5,5,3,'评价内容5','2023-02-14 09:33:17','回复信息5','2023-02-14 09:33:17','2023-02-14 09:33:17'),(6,3,5,'fdsgsdghsd','2023-02-14 13:38:44','发的是但是跟','2023-02-14 13:41:39','2023-02-14 13:38:44');

/*Table structure for table `shangpin_order` */

DROP TABLE IF EXISTS `shangpin_order`;

CREATE TABLE `shangpin_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shangpin_order_uuid_number` varchar(200) DEFAULT NULL COMMENT '订单号 Search111 ',
  `address_id` int(11) DEFAULT NULL COMMENT '收货地址 ',
  `shangpin_id` int(11) DEFAULT NULL COMMENT '零食',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `yuangong_id` int(11) DEFAULT NULL COMMENT '员工',
  `buy_number` int(11) DEFAULT NULL COMMENT '购买数量',
  `shangpin_order_true_price` decimal(10,2) DEFAULT NULL COMMENT '实付价格',
  `shangpin_order_courier_name` varchar(200) DEFAULT NULL COMMENT '快递公司',
  `shangpin_order_courier_number` varchar(200) DEFAULT NULL COMMENT '订单快递单号',
  `shangpin_order_types` int(11) DEFAULT NULL COMMENT '订单类型 Search111 ',
  `shangpin_order_payment_types` int(11) DEFAULT NULL COMMENT '支付类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='零食订单';

/*Data for the table `shangpin_order` */

insert  into `shangpin_order`(`id`,`shangpin_order_uuid_number`,`address_id`,`shangpin_id`,`yonghu_id`,`yuangong_id`,`buy_number`,`shangpin_order_true_price`,`shangpin_order_courier_name`,`shangpin_order_courier_number`,`shangpin_order_types`,`shangpin_order_payment_types`,`insert_time`,`create_time`) values (1,'1676351135226',3,1,1,NULL,2,'548.10',NULL,NULL,1,1,'2023-02-14 13:05:35','2023-02-14 13:05:35'),(2,'1676351154057',3,1,1,NULL,1,'434.62',NULL,NULL,1,1,'2023-02-14 13:05:54','2023-02-14 13:05:54'),(3,'1676351185905',3,2,1,NULL,1,'68.02',NULL,NULL,1,1,'2023-02-14 13:06:26','2023-02-14 13:06:26'),(4,'1676351135226',3,3,1,NULL,2,'548.10','','',1,1,'2023-02-14 13:05:35','2023-02-14 13:05:35'),(5,'1676351154057',3,3,1,NULL,1,'434.62','','',1,1,'2023-02-14 13:05:54','2023-02-14 13:05:54'),(6,'1676351185905',3,4,1,NULL,1,'68.02','','',1,1,'2023-02-14 13:06:26','2023-02-14 13:06:26'),(7,'1676351154057',3,4,1,NULL,1,'434.62','','',1,1,'2023-02-14 13:05:54','2023-02-14 13:05:54'),(8,'1676351185905',3,5,1,NULL,1,'68.02','','',1,1,'2023-02-14 13:06:26','2023-02-14 13:06:26'),(9,'1676351135226',3,5,1,NULL,2,'548.10','','',1,1,'2023-02-14 13:05:35','2023-02-14 13:05:35'),(10,'1676351154057',3,1,1,1,1,'434.62','员工姓名1','17703786901',3,1,'2023-02-14 13:05:54','2023-02-14 13:05:54'),(11,'1676351185905',3,1,1,1,1,'68.02','员工姓名1','17703786901',3,1,'2023-02-14 13:06:26','2023-02-14 13:06:26'),(12,'1676352829130',6,3,5,1,1,'68.02','员工姓名1','17703786901',5,1,'2023-02-14 13:33:49','2023-02-14 13:33:49'),(13,'1676352829130',6,4,5,NULL,1,'296.59',NULL,NULL,1,1,'2023-02-14 13:33:49','2023-02-14 13:33:49'),(14,'1676352842260',6,3,5,1,1,'68.02','员工姓名1','17703786901',3,1,'2023-02-14 13:34:02','2023-02-14 13:34:02');

/*Table structure for table `shangpin_pandian` */

DROP TABLE IF EXISTS `shangpin_pandian`;

CREATE TABLE `shangpin_pandian` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `shangpin_id` int(11) DEFAULT NULL COMMENT '零食',
  `yuangong_id` int(11) DEFAULT NULL COMMENT '员工',
  `shangpin_pandian_qian_number` int(11) DEFAULT NULL COMMENT '盘点前数量 ',
  `shangpin_pandian_hou_number` int(11) DEFAULT NULL COMMENT '盘点数量 ',
  `shangpin_pandian_cha_number` varchar(200) DEFAULT NULL COMMENT '差数量',
  `shangpin_pandian_content` text COMMENT '盘点备注 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '盘点时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='零食盘点';

/*Data for the table `shangpin_pandian` */

insert  into `shangpin_pandian`(`id`,`shangpin_id`,`yuangong_id`,`shangpin_pandian_qian_number`,`shangpin_pandian_hou_number`,`shangpin_pandian_cha_number`,`shangpin_pandian_content`,`insert_time`,`create_time`) values (1,1,2,113,63,'差数量1','盘点备注1','2023-02-14 09:33:17','2023-02-14 09:33:17'),(2,2,3,258,335,'差数量2','盘点备注2','2023-02-14 09:33:17','2023-02-14 09:33:17'),(3,3,2,337,176,'差数量3','盘点备注3','2023-02-14 09:33:17','2023-02-14 09:33:17'),(4,4,1,280,339,'差数量4','盘点备注4','2023-02-14 09:33:17','2023-02-14 09:33:17'),(5,5,2,17,257,'差数量5','盘点备注5','2023-02-14 09:33:17','2023-02-14 09:33:17'),(6,3,1,100,101,'1','<p>多出一箱</p>','2023-02-14 13:43:37','2023-02-14 13:43:37');

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='token表';

/*Data for the table `token` */

insert  into `token`(`id`,`userid`,`username`,`tablename`,`role`,`token`,`addtime`,`expiratedtime`) values (1,1,'a1','yonghu','用户','cwvggt8set0tetrtmphq3ncnabxl9ufw','2023-02-14 09:41:55','2023-02-14 14:26:48'),(2,1,'admin','users','管理员','478y7dzo9ylrjgu1oshd702xnewqq6zz','2023-02-14 09:44:30','2023-02-14 14:41:00'),(3,1,'a1','yuangong','员工','6jw82clegrw6ime6n0dvltfe3rmcjbs1','2023-02-14 11:10:51','2023-02-14 14:42:14'),(4,5,'a6','yonghu','用户','d5ev21a6ptmtv6lfngoadh5p3w3bkmq7','2023-02-14 13:32:33','2023-02-14 14:32:33');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`role`,`addtime`) values (1,'admin','admin','管理员','2022-05-01 00:00:00');

/*Table structure for table `yonghu` */

DROP TABLE IF EXISTS `yonghu`;

CREATE TABLE `yonghu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `yonghu_name` varchar(200) DEFAULT NULL COMMENT '用户姓名 Search111 ',
  `yonghu_phone` varchar(200) DEFAULT NULL COMMENT '用户手机号',
  `yonghu_id_number` varchar(200) DEFAULT NULL COMMENT '用户身份证号',
  `yonghu_photo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `sex_types` int(11) DEFAULT NULL COMMENT '性别',
  `yonghu_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `new_money` decimal(10,2) DEFAULT NULL COMMENT '余额 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `yonghu` */

insert  into `yonghu`(`id`,`username`,`password`,`yonghu_name`,`yonghu_phone`,`yonghu_id_number`,`yonghu_photo`,`sex_types`,`yonghu_email`,`new_money`,`create_time`) values (1,'a1','123456','用户姓名1','17703786901','410224199010102001','upload/yonghu1.jpg',1,'1@qq.com','9100.30','2023-02-14 09:33:17'),(2,'a2','123456','用户姓名2','17703786902','410224199010102002','upload/yonghu2.jpg',1,'2@qq.com','917.45','2023-02-14 09:33:17'),(3,'a3','123456','用户姓名3','17703786903','410224199010102003','upload/yonghu3.jpg',1,'3@qq.com','591.94','2023-02-14 09:33:17'),(4,'a5','123456','张5','17777777777','410224111111111115',NULL,1,NULL,'0.00','2023-02-14 13:23:58'),(5,'a6','123456','张6','17703786906','410222222222222226','upload/1676352808195.jpg',1,'6@qq.com','9566.37','2023-02-14 13:32:28');

/*Table structure for table `yuangong` */

DROP TABLE IF EXISTS `yuangong`;

CREATE TABLE `yuangong` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `yuangong_name` varchar(200) DEFAULT NULL COMMENT '员工姓名 Search111 ',
  `yuangong_phone` varchar(200) DEFAULT NULL COMMENT '员工手机号',
  `yuangong_id_number` varchar(200) DEFAULT NULL COMMENT '员工身份证号',
  `yuangong_photo` varchar(200) DEFAULT NULL COMMENT '员工头像',
  `sex_types` int(11) DEFAULT NULL COMMENT '性别',
  `yuangong_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='员工';

/*Data for the table `yuangong` */

insert  into `yuangong`(`id`,`username`,`password`,`yuangong_name`,`yuangong_phone`,`yuangong_id_number`,`yuangong_photo`,`sex_types`,`yuangong_email`,`create_time`) values (1,'a1','123456','员工姓名1','17703786901','410224199010102001','upload/yuangong1.jpg',2,'1@qq.com','2023-02-14 09:33:17'),(2,'a2','123456','员工姓名2','17703786902','410224199010102002','upload/yuangong2.jpg',1,'2@qq.com','2023-02-14 09:33:17'),(3,'a3','123456','员工姓名3','17703786903','410224199010102003','upload/yuangong3.jpg',2,'3@qq.com','2023-02-14 09:33:17');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
