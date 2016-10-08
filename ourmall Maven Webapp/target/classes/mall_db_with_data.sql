/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : mall_db

 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/08/2016 14:43:03 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_admin`
-- ----------------------------
BEGIN;
INSERT INTO `tb_admin` VALUES ('1', 'liam', 'liam', null, '123', '2016-10-08 01:07:27', null, null, null), ('2', 'liam1', null, null, null, '2016-10-08 13:34:10', '2', null, null);
COMMIT;

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
--  Records of `tb_detailpic`
-- ----------------------------
BEGIN;
INSERT INTO `tb_detailpic` VALUES ('1', '1', 'https1-1'), ('2', '1', 'https1-2'), ('3', '2', 'https2-1'), ('4', '7', 'http://localhost:8080/ourmall/images/goods_images/ea219c8309c548f1937145ab47b45f9a.jpeg'), ('5', '7', 'http://localhost:8080/ourmall/images/goods_images/60d752af90e44bd3988730da195c20fe.jpeg'), ('6', '10', 'http://localhost:8080/ourmall/images/goods_images/a27dc3e81eff4bb8b19a040aa525557e.jpeg'), ('7', '11', 'http://localhost:8080/ourmall/images/goods_images/542d220f6bf748d7a1a4806fcf60183e.jpeg'), ('8', '12', 'http://localhost:8080/ourmall/images/goods_images/ae8290aeae074cdf915ef390830a298c.jpeg');
COMMIT;

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
--  Records of `tb_goods`
-- ----------------------------
BEGIN;
INSERT INTO `tb_goods` VALUES ('1', '花生', '100', '好吃', '1900', '2016-09-25 22:23:17', '12', '100', null, null, null, null, null, '1'), ('2', '瓜子', '100', '非常好吃', '1800', '2016-09-25 22:25:44', '60', '50', null, null, null, null, null, '1'), ('3', '水', '100', '好喝', '1990', '2016-09-25 22:26:51', '40', '120', null, null, null, null, null, '2'), ('4', '好吃的瓜子', '100', null, null, null, '100', null, null, null, null, null, null, '3'), ('5', '豆', null, null, null, null, '12', null, null, null, null, null, null, null), ('6', '花生豆', null, null, null, null, '40', null, null, null, null, null, null, null), ('7', '花生米', null, null, null, null, '1', null, null, null, null, null, null, null), ('8', '', null, null, null, null, null, null, null, null, null, null, null, null), ('9', '11', null, null, null, null, '11', null, null, null, null, null, null, null), ('10', null, '111', '1111', null, null, '111', null, null, null, null, '11', '10/07/2016 - 10/07/2016', '饼干零食'), ('11', null, '111', '1111', null, null, '111', null, null, null, null, '11', '10/07/2016 - 10/07/2016', '饼干零食'), ('12', null, '100', '非常好吃！', null, null, '120', null, null, null, null, '法国', '10/07/2016 - 10/07/2016', '饮品');
COMMIT;

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
--  Records of `tb_orders`
-- ----------------------------
BEGIN;
INSERT INTO `tb_orders` VALUES ('1', '1', '123', '已完成', '1000', '2016-09-28 11:58:51', null, '2', '2016-09-28 11:59:00', null, null, null, null, null, null), ('2', '1', '111', '已取消', '100', '2016-09-29 23:14:32', '2016-09-29 23:14:36', '1', '2016-09-29 23:14:41', '1', '[Null', '[Null', null, null, null), ('3', '1', '222', '待付款', '100', null, null, '1', null, null, null, null, null, null, null), ('4', '1', '333', '待收货', '120', null, null, '1', null, null, null, null, null, null, null), ('6', '1', '-1867925924', '待付款', '120', null, null, null, '2016-10-05 01:07:04', null, null, null, null, null, null), ('7', '1', '-1793823405', '待付款', '120', null, null, null, '2016-10-05 21:42:07', null, null, null, null, null, null), ('8', '1', '-1793689737', '待付款', '120', null, null, null, '2016-10-05 21:44:20', null, null, null, null, null, null), ('9', '1', '-1793585262', '待付款', '120', null, null, null, '2016-10-05 21:46:05', null, null, null, '嗑药大生活区9栋', '吕绍选', '110');
COMMIT;

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
--  Records of `tb_picaddress`
-- ----------------------------
BEGIN;
INSERT INTO `tb_picaddress` VALUES ('1', '1', 'http1-1'), ('2', '1', 'http1-2'), ('3', '2', 'http2-1'), ('4', '6', 'http://localhost:8080/ourmall/images/goods_images/c58c9d980196429385f9ad817f9b24b9.jpeg'), ('5', '6', 'http://localhost:8080/ourmall/images/goods_images/1061f7e90e7144daa6ab71259e432e45.jpeg'), ('6', '7', 'http://localhost:8080/ourmall/images/goods_images/8ada6653b2994e16b1589e305cf0bf05.jpeg'), ('7', '7', 'http://localhost:8080/ourmall/images/goods_images/f741db9055614c41a738209106331c5a.jpeg'), ('8', '1', 'http://localhost:8080/ourmall/images/goods_images/8ec8565b9a3f498eb771a8cd50b29747.jpeg'), ('9', '1', 'http://localhost:8080/ourmall/images/goods_images/cbf5f535e04a4eaba150a86ea601e056.jpeg'), ('10', '9', 'http://localhost:8080/ourmall/images/goods_images/6306c4322b8a4c619f06624e88d9e5b8.jpeg'), ('11', '9', 'http://localhost:8080/ourmall/images/goods_images/eddae397ccc34e1aa1ec3d94ec3d2558.jpeg'), ('12', '10', 'http://localhost:8080/ourmall/images/goods_images/6b8c7a2089894645804ce803ce221f3d.jpeg'), ('13', '11', 'http://localhost:8080/ourmall/images/goods_images/c299ae95b1ef43dba5fdd15a179100df.jpeg'), ('14', '12', 'http://localhost:8080/ourmall/images/goods_images/1130dcf831f244148a770d12b8ab5888.jpeg');
COMMIT;

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
--  Records of `tb_receive_msg`
-- ----------------------------
BEGIN;
INSERT INTO `tb_receive_msg` VALUES ('1', '1', '吕绍选', '嗑药大生活区9栋', '110', '2016-09-26 23:18:02', null, null, null, '1'), ('2', '1', '罗安妮', '嗑药大生活区8栋', '120', '2016-09-26 23:18:50', null, null, null, '0'), ('3', '3', 'liam', '广东药科大学9栋', '114', '2016-09-26 23:19:51', null, null, null, null), ('4', '1', null, null, null, null, null, null, null, '0'), ('5', '1', null, null, null, null, null, null, null, '0');
COMMIT;

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
--  Records of `tb_usergoods`
-- ----------------------------
BEGIN;
INSERT INTO `tb_usergoods` VALUES ('1', '111', '花生', null, null, 'usergood-Img', null, '1', null, null, null), ('2', '-1793585262', 'gg', null, null, null, null, '1', null, null, null), ('3', '222', 'hhh', null, null, null, null, '1', null, null, null), ('4', null, null, null, null, null, null, '3', null, null, null), ('5', '-1867925924', '花生', '10', '120', null, null, '1', '1', null, null), ('6', null, '花生', '1', '12', null, null, null, '1', null, null), ('10', '-1793585262', '花生', '10', '120', null, null, '1', '1', null, null);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='商城用户 商城用户，注册只需要手机号';

-- ----------------------------
--  Records of `tb_users`
-- ----------------------------
BEGIN;
INSERT INTO `tb_users` VALUES ('1', 'liam', '12', '广东药科大学', '男', '2016-09-24 11:17:33', null, null, null), ('3', '123', '22022cfbb9662faac5590755bf99644b0711522d22344b770', null, null, null, null, null, null), ('4', '133', 'f99ffcc3fdd711522bfaa933366a6670e336fdd0feed779fbbc443', null, null, '2016-09-24 18:07:06', null, null, null), ('5', '133', 'f99ffcc3fdd711522bfaa933366a6670e336fdd0feed779fbbc443', null, null, '2016-10-07 18:27:39', null, null, null), ('6', '133', 'f99ffcc3fdd711522bfaa933366a6670e336fdd0feed779fbbc443', null, null, '2016-10-07 18:27:46', null, null, null), ('7', 'liam1', '22022cfbb9662faac5590755bf99644b0711522d22344b770', null, null, '2016-10-08 13:41:50', null, null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
