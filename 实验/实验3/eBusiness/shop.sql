/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2022-11-13 18:56:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ausertable`
-- ----------------------------
DROP TABLE IF EXISTS `ausertable`;
CREATE TABLE `ausertable` (
  `aname` varchar(255) NOT NULL,
  `apwd` varchar(255) default NULL,
  PRIMARY KEY  (`aname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ausertable
-- ----------------------------
INSERT INTO `ausertable` VALUES ('admin', 'admin');
INSERT INTO `ausertable` VALUES ('lhx', 'lhx');

-- ----------------------------
-- Table structure for `busertable`
-- ----------------------------
DROP TABLE IF EXISTS `busertable`;
CREATE TABLE `busertable` (
  `id` int(11) NOT NULL auto_increment,
  `bemail` varchar(255) default NULL,
  `bpwd` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of busertable
-- ----------------------------
INSERT INTO `busertable` VALUES ('1', '304361324@qq.com', '78f8a7ae700c91db09facb05a675432b');
INSERT INTO `busertable` VALUES ('2', 'lhx8866@126.com', '78f8a7ae700c91db09facb05a675432b');
INSERT INTO `busertable` VALUES ('3', 'aaa@126.com', 'f545cc86bb347394d9d5395b21a7f3aa');

-- ----------------------------
-- Table structure for `carttable`
-- ----------------------------
DROP TABLE IF EXISTS `carttable`;
CREATE TABLE `carttable` (
  `id` int(11) NOT NULL auto_increment,
  `busertable_id` int(11) default NULL,
  `goodstable_id` int(11) default NULL,
  `shoppingnum` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carttable
-- ----------------------------
INSERT INTO `carttable` VALUES ('1', '1', '2', '1');
INSERT INTO `carttable` VALUES ('2', '1', '1', '2');
INSERT INTO `carttable` VALUES ('3', '2', '2', '2');

-- ----------------------------
-- Table structure for `focustable`
-- ----------------------------
DROP TABLE IF EXISTS `focustable`;
CREATE TABLE `focustable` (
  `id` int(11) NOT NULL auto_increment,
  `goodstable_id` int(11) default NULL,
  `busertable_id` int(11) default NULL,
  `focustime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of focustable
-- ----------------------------
INSERT INTO `focustable` VALUES ('1', '2', '1', '2022-08-07 20:01:47');
INSERT INTO `focustable` VALUES ('2', '2', '2', '2022-11-09 11:10:06');
INSERT INTO `focustable` VALUES ('3', '2', '3', '2022-11-13 16:06:54');
INSERT INTO `focustable` VALUES ('4', '1', '3', '2022-11-13 16:07:12');

-- ----------------------------
-- Table structure for `goodstable`
-- ----------------------------
DROP TABLE IF EXISTS `goodstable`;
CREATE TABLE `goodstable` (
  `id` int(11) NOT NULL auto_increment,
  `gname` varchar(255) default NULL,
  `goprice` double default NULL,
  `grprice` double default NULL,
  `gstore` int(11) default NULL,
  `gpicture` varchar(255) default NULL,
  `fileName` varchar(255) default NULL,
  `goodstype_id` int(11) default NULL,
  `typename` varchar(255) default NULL,
  `buyNumber` int(11) default NULL,
  `isAdvertisement` int(11) default NULL,
  `isRecommend` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstable
-- ----------------------------
INSERT INTO `goodstable` VALUES ('1', '苹果', '5', '4', '10', '202208219195616739.webp', null, '4', null, null, '0', '1');
INSERT INTO `goodstable` VALUES ('2', '电视', '2322', '2000', '10', '202208219195733944.jpg', null, '1', null, null, '0', '1');
INSERT INTO `goodstable` VALUES ('3', '猕猴桃', '15', '12', '7', '202211317165546873.jpg', null, '4', null, null, '0', '1');

-- ----------------------------
-- Table structure for `goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `id` int(11) NOT NULL auto_increment,
  `typename` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('1', '电子商品');
INSERT INTO `goodstype` VALUES ('2', '食品');
INSERT INTO `goodstype` VALUES ('3', '家电');
INSERT INTO `goodstype` VALUES ('4', '水果');

-- ----------------------------
-- Table structure for `orderbasetable`
-- ----------------------------
DROP TABLE IF EXISTS `orderbasetable`;
CREATE TABLE `orderbasetable` (
  `id` int(11) NOT NULL auto_increment,
  `busertable_id` int(11) default NULL,
  `amount` double default NULL,
  `status` int(11) default NULL,
  `orderdate` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderbasetable
-- ----------------------------
INSERT INTO `orderbasetable` VALUES ('8', '3', '48', '1', '2022-11-13 18:52:20');

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL auto_increment,
  `busertable_id` int(11) default NULL,
  `orderbasetable_id` int(11) default NULL,
  `goodstable_id` int(11) default NULL,
  `SHOPPINGNUM` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', null, '8', '3', '4');
