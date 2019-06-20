/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : milk

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-06-20 14:00:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_files
-- ----------------------------
DROP TABLE IF EXISTS `m_files`;
CREATE TABLE `m_files` (
  `id` varchar(128) NOT NULL COMMENT '主键',
  `file_name` varchar(255) NOT NULL COMMENT '文件名称原本',
  `file_url` varchar(255) NOT NULL COMMENT '文件地址',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_files
-- ----------------------------
INSERT INTO `m_files` VALUES ('05630e0d8b5443929f2ccf178a06be1d', '2.jpg', 'D:/pic/20190620/20190620135805', '123');
INSERT INTO `m_files` VALUES ('9359080b5bbf4f26973bd65f5f3b0fe6', '3.jpg', 'D:/pic/20190620/20190620135805', '123');
INSERT INTO `m_files` VALUES ('d4d8c3db1736433ba3476ba0079e25a2', '1.png', 'D:/pic/20190620/20190620135805', '123');

-- ----------------------------
-- Table structure for m_users
-- ----------------------------
DROP TABLE IF EXISTS `m_users`;
CREATE TABLE `m_users` (
  `id` varchar(64) NOT NULL,
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
INSERT INTO `m_users` VALUES ('1', 'aaa', '111111', '0', '1', '0');
INSERT INTO `m_users` VALUES ('2', 'bbb', '222222', '0', '0', '0');
INSERT INTO `m_users` VALUES ('3', 'ccc', '333333', '0', '0', '0');
INSERT INTO `m_users` VALUES ('4', 'ddd', '444444', '1', '1', '0');
INSERT INTO `m_users` VALUES ('5', 'eee', '55555', '1', '1', '0');
