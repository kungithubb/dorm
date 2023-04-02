/*
 Navicat Premium Data Transfer

 Source Server         : msi
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : dorm

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 09/03/2023 14:16:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` datetime NULL DEFAULT NULL,
  `build_id` int NULL DEFAULT NULL,
  `dorm_id` int NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2023001', '123456', '0001', '刘昊然', '00001111', '2023001@ecut.com', '0', '2000-01-01 00:00:00', 1, 1, '南昌', '2023-03-07 03:37:42', NULL);
INSERT INTO `user` VALUES ('2', '2023002', '123456', '0002', '蔡徐坤', '00002222', '2023002@ecut.com', '0', '2000-01-02 00:00:00', 1, 1, '北京', '2023-03-07 03:41:42', NULL);
INSERT INTO `user` VALUES ('3', '2023003', '123456', '0003', '周杰伦', '00003333', '2023003@ecut.com', '0', '2000-01-03 00:00:00', 1, 1, '深圳', '2023-03-09 03:37:42', NULL);
INSERT INTO `user` VALUES ('4', '2023004', '123456', '0004', '彭昱畅', '00004444', '2023004@ecut.com', '0', '2000-01-04 00:00:00', 1, 1, '上海', '2023-03-09 14:37:42', NULL);

SET FOREIGN_KEY_CHECKS = 1;
