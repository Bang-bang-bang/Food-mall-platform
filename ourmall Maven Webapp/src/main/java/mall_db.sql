/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : mall_db

 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/07/2016 23:32:14 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `free` int(11) DEFAULT NULL,
  `free1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_cart`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart` (
  `cartID` int(11) NOT NULL,
  PRIMARY KEY (`cartID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_detailpic`
-- ----------------------------
DROP TABLE IF EXISTS `tb_detailpic`;
CREATE TABLE `tb_detailpic` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `picdtID` int(11) DEFAULT NULL COMMENT '关联编号',
  `address` varchar(4000) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`ID`),
  KEY `FK_tb_detailpic_picdtID` (`picdtID`),
  CONSTRAINT `FK_tb_detailpic_picdtID` FOREIGN KEY (`picdtID`) REFERENCES `tb_goods` (`goodsID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='详情页面图片表';

-- ----------------------------
--  Table structure for `tb_goods`
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `goodsID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `goods_name` varchar(4000) DEFAULT NULL COMMENT '商品名称',
  `goods_total` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_detals` varchar(4000) DEFAULT NULL COMMENT '商品详细信息',
  `goods_sell` int(11) DEFAULT NULL COMMENT '商品销售量',
  `create_time` datetime DEFAULT NULL COMMENT '商品上传时间',
  `goods_price` float DEFAULT NULL,
  `goods_users` int(11) DEFAULT NULL,
  `goods_state` varchar(255) DEFAULT NULL,
  `goods1` varchar(255) DEFAULT NULL,
  `goods2` varchar(255) DEFAULT NULL,
  `goods_born_place` varchar(255) DEFAULT NULL,
  `goods_born_time` varchar(255) DEFAULT NULL,
  `goods_class` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goodsID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
--  Table structure for `tb_orders`
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders`;
CREATE TABLE `tb_orders` (
  `IdD` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userID` int(11) DEFAULT NULL COMMENT '关联编号',
  `orderID` int(11) DEFAULT NULL COMMENT '订单编号',
  `order_state` varchar(4000) DEFAULT NULL COMMENT '订单状态 代发货，未发货，已完成',
  `goods_totalprice` float(11,0) DEFAULT NULL COMMENT '购买商品总价格',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `Receiving_time` datetime DEFAULT NULL COMMENT '收货时间',
  `display` int(11) DEFAULT NULL COMMENT '订单显示',
  `create_time` datetime DEFAULT NULL COMMENT '订单生成时间',
  `cartID` int(11) DEFAULT NULL COMMENT '是否在购物车',
  `order1` varchar(255) DEFAULT NULL,
  `order2` varchar(255) DEFAULT NULL,
  `RecAddress` varchar(255) DEFAULT NULL,
  `RecName` varchar(255) DEFAULT NULL,
  `RecPhone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdD`),
  UNIQUE KEY `IDXU_tb_orders_orderID` (`orderID`),
  KEY `FK_tb_orders_userID` (`userID`),
  CONSTRAINT `FK_tb_orders_userID` FOREIGN KEY (`userID`) REFERENCES `tb_users` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
--  Table structure for `tb_picaddress`
-- ----------------------------
DROP TABLE IF EXISTS `tb_picaddress`;
CREATE TABLE `tb_picaddress` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `picaddID` int(11) DEFAULT NULL COMMENT '关联编号',
  `address` varchar(4000) DEFAULT NULL COMMENT '图片url',
  PRIMARY KEY (`ID`),
  KEY `FK_tb_picaddress_picaddID` (`picaddID`),
  CONSTRAINT `FK_tb_picaddress_picaddID` FOREIGN KEY (`picaddID`) REFERENCES `tb_goods` (`goodsID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='商品展示图片';

-- ----------------------------
--  Table structure for `tb_receive_msg`
-- ----------------------------
DROP TABLE IF EXISTS `tb_receive_msg`;
CREATE TABLE `tb_receive_msg` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userID` int(11) DEFAULT NULL COMMENT '关联编号',
  `name` varchar(4000) DEFAULT NULL COMMENT '收件人',
  `address` varchar(4000) DEFAULT NULL COMMENT '收件人地址',
  `phone` varchar(4000) DEFAULT NULL COMMENT '收件人电话',
  `create_time` datetime DEFAULT NULL COMMENT '地址创建时间',
  `school` varchar(255) DEFAULT NULL,
  `msg1` varchar(255) DEFAULT NULL,
  `msg2` varchar(255) DEFAULT NULL,
  `main_address` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_tb_receive_msg_userID` (`userID`),
  CONSTRAINT `FK_tb_receive_msg_userID` FOREIGN KEY (`userID`) REFERENCES `tb_users` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='收件人信息表';

-- ----------------------------
--  Table structure for `tb_usergoods`
-- ----------------------------
DROP TABLE IF EXISTS `tb_usergoods`;
CREATE TABLE `tb_usergoods` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `orderID` double(11,0) DEFAULT NULL COMMENT '关联编号',
  `goods_name` varchar(4000) DEFAULT NULL COMMENT '商品名',
  `goods_number` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_price` double DEFAULT NULL COMMENT '种类商品总价',
  `usergoods1` varchar(255) DEFAULT NULL,
  `usergoods2` varchar(255) DEFAULT NULL,
  `usergoods3` int(11) DEFAULT NULL,
  `goodID` int(11) DEFAULT NULL,
  `ifcart` int(11) DEFAULT NULL,
  `usergoods4` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_tb_usergoods_orderID` (`orderID`),
  KEY `usergoods3` (`usergoods3`),
  CONSTRAINT `tb_usergoods_ibfk_1` FOREIGN KEY (`usergoods3`) REFERENCES `tb_users` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户购买的商品表';

-- ----------------------------
--  Table structure for `tb_users`
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(4000) DEFAULT NULL COMMENT '用户名',
  `password` varchar(4000) DEFAULT NULL COMMENT '密码',
  `school` varchar(4000) DEFAULT NULL COMMENT '学校',
  `sex` varchar(4000) DEFAULT NULL COMMENT '性别',
  `create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `phone` varchar(4000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商城用户 商城用户，注册只需要手机号';

SET FOREIGN_KEY_CHECKS = 1;
