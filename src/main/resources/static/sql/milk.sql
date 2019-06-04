/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 100121
Source Host           : localhost:3306
Source Database       : milk

Target Server Type    : MYSQL
Target Server Version : 100121
File Encoding         : 65001

Date: 2019-06-04 17:59:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_users
-- ----------------------------
DROP TABLE IF EXISTS `m_users`;
CREATE TABLE `m_users` (
  `id` int(8) NOT NULL,
  `username` varchar(255) DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `authority` varchar(255) DEFAULT NULL COMMENT '权限',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `delete_flg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of m_users
-- ----------------------------
INSERT INTO `m_users` VALUES ('1', '1', '1', '0', 'boy', '0');
