/*
Navicat MySQL Data Transfer

Source Server         : root_password
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-23 14:07:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER');
