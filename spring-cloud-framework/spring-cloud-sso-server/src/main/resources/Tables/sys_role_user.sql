/*
Navicat MySQL Data Transfer

Source Server         : root_password
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-23 14:07:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL,
  `sys_user_id` int(11) NOT NULL,
  `sys_role_id` int(11) NOT NULL,
  PRIMARY KEY (`sys_user_id`,`sys_role_id`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '1', '1');
INSERT INTO `sys_role_user` VALUES ('2', '2', '2');
