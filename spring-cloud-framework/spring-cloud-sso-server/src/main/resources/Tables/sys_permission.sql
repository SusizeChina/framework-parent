/*
Navicat MySQL Data Transfer

Source Server         : root_password
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-23 14:07:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `descritpion` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '权限A', 'menu_a', '/user/menu_a', null);
INSERT INTO `sys_permission` VALUES ('2', '权限B', 'menu_b', '/user/menu_b', null);
INSERT INTO `sys_permission` VALUES ('3', '权限C', 'menu_b', '/user/menu_c', null);
