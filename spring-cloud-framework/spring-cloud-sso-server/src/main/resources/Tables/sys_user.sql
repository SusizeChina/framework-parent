/*
Navicat MySQL Data Transfer

Source Server         : root_password
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-23 14:07:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$TzaGYZ8Y9H5MjwIZDYiXTOUW7YOrN6f1bNo1ztZagXmjSGNzip1VC');
INSERT INTO `sys_user` VALUES ('2', 'user', '$2a$10$y8fOlSVLt5zkZHjmT4Gj0OUAkfoWrUKw0E0igMOwM0vVH91x2YqDm');
