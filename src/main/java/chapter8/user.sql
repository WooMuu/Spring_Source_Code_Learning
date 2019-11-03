/*
Navicat MySQL Data Transfer

Source Server         : mysql_local
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : spring_source_code_leaning

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-11-01 15:36:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
