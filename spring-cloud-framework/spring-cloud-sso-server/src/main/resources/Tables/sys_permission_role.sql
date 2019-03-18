/*
Navicat MySQL Data Transfer

Source Server         : root_password
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-23 14:07:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_role`;
CREATE TABLE `sys_permission_role` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_role
-- ----------------------------
INSERT INTO `sys_permission_role` VALUES ('1', '1', '1');
INSERT INTO `sys_permission_role` VALUES ('2', '1', '2');
INSERT INTO `sys_permission_role` VALUES ('3', '2', '3');
