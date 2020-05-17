/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1_chen2018
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 127.0.0.1:3306
 Source Schema         : dubbo

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 17/05/2020 01:10:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_dubbo
-- ----------------------------
DROP TABLE IF EXISTS `test_dubbo`;
CREATE TABLE `test_dubbo`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_dubbo
-- ----------------------------
INSERT INTO `test_dubbo` VALUES (1, 'cdd', 1);
INSERT INTO `test_dubbo` VALUES (2, 'dario', 2);

SET FOREIGN_KEY_CHECKS = 1;
