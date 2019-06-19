/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : milk

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2019-06-19 18:51:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `m_files`
-- ----------------------------
DROP TABLE IF EXISTS `m_files`;
CREATE TABLE `m_files` (
  `id` varchar(128) NOT NULL COMMENT '主键',
  `file_name` varchar(255) NOT NULL COMMENT '文件名称',
  `file_url` varchar(255) NOT NULL COMMENT '文件地址',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_files
-- ----------------------------

-- ----------------------------
-- Table structure for `m_users`
-- ----------------------------
DROP TABLE IF EXISTS `m_users`;
CREATE TABLE `m_users` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL COMMENT '用户名（邮箱）',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `authority` varchar(255) NOT NULL COMMENT '权限身份',
  `sex` varchar(255) NOT NULL COMMENT '性别',
  `delete_flg` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of m_users
-- ----------------------------
INSERT INTO `m_users` VALUES ('1', 'admin', '123456', '0', 'boy', '0');
INSERT INTO `m_users` VALUES ('2', 'xiao', '123456', '0', 'girl', '0');
INSERT INTO `m_users` VALUES ('fcc0c17296c64ffb99cde9778290b5f8', '1259699442@qq.com', '123456', '0', 'boy', '0');
