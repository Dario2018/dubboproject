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

 Date: 11/07/2020 15:14:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wb_role
-- ----------------------------
DROP TABLE IF EXISTS `wb_role`;
CREATE TABLE `wb_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
  `role_type` int(2) NOT NULL DEFAULT 0 COMMENT '角色类型(操作级别)',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '0-无效，1-有效',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wb_role
-- ----------------------------
INSERT INTO `wb_role` VALUES (1, 'ROLE_ADMIN', 0, 1, '2020-07-03 00:38:04');
INSERT INTO `wb_role` VALUES (2, 'ROLE_USER', 0, 1, '2020-07-11 10:58:18');

-- ----------------------------
-- Table structure for wb_user
-- ----------------------------
DROP TABLE IF EXISTS `wb_user`;
CREATE TABLE `wb_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `last_login` datetime(6) NULL DEFAULT NULL COMMENT '最近登录时间',
  `is_superuser` tinyint(1) NOT NULL COMMENT '是否管理员',
  `username` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL COMMENT '0-无效，1-有效',
  `create_time` datetime(6) NOT NULL,
  `company_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属公司编码',
  `user_type` int(2) NULL DEFAULT NULL COMMENT '0-超级管理员，1-普通管理，2-普通用户',
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wb_user
-- ----------------------------
INSERT INTO `wb_user` VALUES (2, '$2a$10$PGCM6t0oZtcvR4mhKxBVmuLHOPQC7aRjJ4oWLb3.1cwkvlyLoTgsu', '2020-05-30 11:55:37.000000', 0, 'Dario', '登录密码-ddd', 'da', '1191695933@qq.com', 1, 1, '2020-05-30 11:56:12.000000', '10086', 1, NULL, 'Dario');

-- ----------------------------
-- Table structure for web_company
-- ----------------------------
DROP TABLE IF EXISTS `web_company`;
CREATE TABLE `web_company`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '公司编码',
  `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '公司名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '公司地址',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '公司性质',
  `enable` tinyint(1) NULL DEFAULT 1 COMMENT '0-无效，1-有效',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_company
-- ----------------------------
INSERT INTO `web_company` VALUES (1, '10086', '中国移动', '广东深圳', '通信类', 1, '2020-07-11 11:00:13', 'admin');

-- ----------------------------
-- Table structure for web_menu
-- ----------------------------
DROP TABLE IF EXISTS `web_menu`;
CREATE TABLE `web_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `enable` tinyint(1) NULL DEFAULT 1 COMMENT '状态0-无效，1-有效',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '类型',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '链接',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图片',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父类id',
  `role_leve` int(11) NULL DEFAULT 1 COMMENT '角色级别看见：0-系统管理员可见，1-普通用户可见，2-管理员可见',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建用户',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for web_user_role
-- ----------------------------
DROP TABLE IF EXISTS `web_user_role`;
CREATE TABLE `web_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_user_role
-- ----------------------------
INSERT INTO `web_user_role` VALUES (1, 2, 1);
INSERT INTO `web_user_role` VALUES (2, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
