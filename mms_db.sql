/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : mms_db

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 12/04/2020 14:16:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for action_record
-- ----------------------------
DROP TABLE IF EXISTS `action_record`;
CREATE TABLE `action_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `drug_id` bigint(20) NULL DEFAULT NULL COMMENT '药品ID',
  `drug_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名称',
  `action` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作',
  `action_time` date NULL DEFAULT NULL COMMENT '操作时间',
  `amount` int(11) NULL DEFAULT NULL COMMENT '操作数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of action_record
-- ----------------------------
INSERT INTO `action_record` VALUES (1, NULL, '氨茶碱片', '入库药品', '2020-03-14', 60);
INSERT INTO `action_record` VALUES (2, NULL, '复方丹参片', '入库药品', '2020-03-14', 70);
INSERT INTO `action_record` VALUES (3, NULL, '肺宁胶囊', '入库药品', '2020-03-14', 170);
INSERT INTO `action_record` VALUES (4, NULL, '我爱', '入库药品', '2020-03-14', 66);
INSERT INTO `action_record` VALUES (5, NULL, '我爱', '入库药品', '2020-03-14', 89);
INSERT INTO `action_record` VALUES (6, NULL, '氨茶碱片', '入库药品', '2020-03-14', 100);
INSERT INTO `action_record` VALUES (7, NULL, '氨茶碱片', '出库药品', '2020-03-14', 700);
INSERT INTO `action_record` VALUES (8, NULL, '氨茶碱片', '入库药品', '2020-03-14', 20);
INSERT INTO `action_record` VALUES (9, NULL, '氨茶碱片', '出库药品', '2020-03-14', 50);
INSERT INTO `action_record` VALUES (10, NULL, '氨茶碱片', '入库药品', '2020-03-14', 30);
INSERT INTO `action_record` VALUES (11, NULL, '氨茶碱片', '出库药品', '2020-03-14', 60);
INSERT INTO `action_record` VALUES (12, NULL, '氨茶碱片', '入库药品', '2020-03-17', 241);
INSERT INTO `action_record` VALUES (13, NULL, '复方丹参片', '入库药品', '2020-03-17', 54);
INSERT INTO `action_record` VALUES (14, NULL, '氨茶碱片', '出库药品', '2020-03-17', 78);
INSERT INTO `action_record` VALUES (15, NULL, '复方丹参片', '入库药品', '2020-03-17', 45);
INSERT INTO `action_record` VALUES (16, NULL, '小儿氨酚黄那敏颗粒', '出库药品', '2020-03-17', 678);
INSERT INTO `action_record` VALUES (17, NULL, '氨茶碱片', '入库药品', '2020-03-20', 222);
INSERT INTO `action_record` VALUES (18, NULL, '银翘解毒颗粒', '入库药品', '2020-03-20', 13);
INSERT INTO `action_record` VALUES (19, NULL, '藿香清胃胶囊', '入库药品', '2020-03-20', 45);
INSERT INTO `action_record` VALUES (20, NULL, '板蓝根颗粒', '入库药品', '2020-03-20', 67);
INSERT INTO `action_record` VALUES (21, NULL, '氨茶碱片', '出库药品', '2020-03-20', 20);
INSERT INTO `action_record` VALUES (22, NULL, '复方丹参片', '出库药品', '2020-03-20', 120);
INSERT INTO `action_record` VALUES (23, NULL, '酚咖片 ', '出库药品', '2020-03-20', 155);
INSERT INTO `action_record` VALUES (24, NULL, '板蓝根颗粒', '出库药品', '2020-03-20', 34);
INSERT INTO `action_record` VALUES (25, NULL, '藿香清胃胶囊', '出库药品', '2020-03-20', 23);
INSERT INTO `action_record` VALUES (26, NULL, '氨茶碱片', '出库药品', '2020-04-07', 5);
INSERT INTO `action_record` VALUES (27, NULL, '氨茶碱片', '出库药品', '2020-04-07', 5);
INSERT INTO `action_record` VALUES (28, NULL, '氨茶碱片', '入库药品', '2020-04-07', 22);
INSERT INTO `action_record` VALUES (29, NULL, '板蓝根颗粒', '入库药品', '2020-04-07', 22);
INSERT INTO `action_record` VALUES (30, NULL, '氨茶碱片', '入库药品', '2020-04-08', 10);
INSERT INTO `action_record` VALUES (31, NULL, '氨茶碱片', '出库药品', '2020-04-08', 5);
INSERT INTO `action_record` VALUES (32, NULL, '氨茶碱片', '出库药品', '2020-04-08', 5);
INSERT INTO `action_record` VALUES (33, NULL, '氨茶碱片', '出库药品', '2020-04-08', 5);
INSERT INTO `action_record` VALUES (34, NULL, '氨茶碱片', '出库药品', '2020-04-08', 4);
INSERT INTO `action_record` VALUES (35, NULL, '氨茶碱片', '出库药品', '2020-04-08', 4);
INSERT INTO `action_record` VALUES (36, NULL, '氨茶碱片', '入库药品', '2020-04-08', 22);
INSERT INTO `action_record` VALUES (37, NULL, '银翘解毒颗粒', '入库药品', '2020-04-08', 22);
INSERT INTO `action_record` VALUES (38, NULL, '氨茶碱片', '入库药品', '2020-04-09', 20);
INSERT INTO `action_record` VALUES (39, NULL, '氨茶碱片', '出库药品', '2020-04-11', 4);
INSERT INTO `action_record` VALUES (40, NULL, '氨茶碱片', '出库药品', '2020-04-11', 4);
INSERT INTO `action_record` VALUES (41, NULL, '氨茶碱片', '出库药品', '2020-04-11', 4);
INSERT INTO `action_record` VALUES (42, NULL, '氨茶碱片', '出库药品', '2020-04-11', 4);
INSERT INTO `action_record` VALUES (43, NULL, '氨茶碱片', '出库药品', '2020-04-11', 4);
INSERT INTO `action_record` VALUES (44, NULL, '氨茶碱片', '出库药品', '2020-04-11', 4);
INSERT INTO `action_record` VALUES (45, NULL, '氨茶碱片', '出库药品', '2020-04-11', 4);
INSERT INTO `action_record` VALUES (46, NULL, '氨茶碱片', '出库药品', '2020-04-11', 5);
INSERT INTO `action_record` VALUES (47, NULL, '复方丹参片', '出库药品', '2020-04-11', 7);
INSERT INTO `action_record` VALUES (48, NULL, '氨茶碱片', '出库药品', '2020-04-11', 5);
INSERT INTO `action_record` VALUES (49, NULL, '复方丹参片', '出库药品', '2020-04-11', 7);
INSERT INTO `action_record` VALUES (50, NULL, '氨茶碱片', '出库药品', '2020-04-11', 5);
INSERT INTO `action_record` VALUES (51, NULL, '复方丹参片', '出库药品', '2020-04-11', 7);
INSERT INTO `action_record` VALUES (52, NULL, '氨茶碱片', '出库药品', '2020-04-11', 5);
INSERT INTO `action_record` VALUES (53, NULL, '复方丹参片', '出库药品', '2020-04-11', 7);

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `add_time` timestamp(0) NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'admin', '2020-03-11 16:53:32');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctorName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `InsertTime` timestamp(0) NOT NULL,
  `ano_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生姓名',
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `phone_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `section` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室',
  `t_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医生' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, 'doctor1', '2020-03-14 16:30:00', '张一样', '1112', '111111111', NULL, NULL);
INSERT INTO `doctor` VALUES (2, 'doctor2', '2020-04-12 13:31:33', '哈哈', '21314', '224141', NULL, NULL);

-- ----------------------------
-- Table structure for drug
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `drug_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `drug_count` bigint(20) NULL DEFAULT NULL COMMENT '药品数量',
  `factory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂家',
  `price` bigint(20) NULL DEFAULT NULL COMMENT '价格',
  `production_time` date NULL DEFAULT NULL COMMENT '生产日期',
  `drug_function` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品功能',
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品规格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug
-- ----------------------------
INSERT INTO `drug` VALUES (1, '氨茶碱片', 473, '\r\n国药集团汕头金石制药有限公司', 20, '2020-03-12', '适用于支气管哮喘、喘息型支气管炎、阻塞性肺气肿等缓解喘息症状；也可用于心源性肺水肿引起的哮喘。', '100片');
INSERT INTO `drug` VALUES (3, '复方丹参片', 429, '	贵州飞云岭药业股份有限公司', 10, '2020-02-26', '活血化瘀，理气止痛。用于气滞血瘀所致的胸痹，症见胸闷、心前区刺痛；冠心病心绞痛见上述症候者。', '60片');
INSERT INTO `drug` VALUES (8, '酚咖片 ', 436, '河北奥星药业有限公司', 10, '2020-03-11', '适用于伴有痰液分泌不正常及排痰功能不良的急性、慢性呼吸道疾病，例如慢性支气管炎急性加重、喘息型支气管炎、支气管扩张及支气管哮喘的祛痰治疗。', '20片');
INSERT INTO `drug` VALUES (9, '板蓝根颗粒', 436, '甘肃河西制药有限责任公司', 40, '2020-03-18', '温补肝肾，益精养血。用于血虚头晕，腰膝酸冷，虚劳消瘦。', '10袋');
INSERT INTO `drug` VALUES (10, '藿香清胃胶囊', 436, '吉林省俊宏药业有限公司', 32, '2020-03-20', '清热化湿，醒脾消滞。用于脾胃伏火引起的消化不良，脘腹涨满，不思饮食、口苦口臭等症。', '42粒');
INSERT INTO `drug` VALUES (11, '银翘解毒颗粒', 458, '四川泰乐制药有限公司', 23, '2020-03-03', '疏风解表，清热解毒。用于风热感冒，症见发热头痛、咳嗽口干、咽喉疼痛。', '10袋');

-- ----------------------------
-- Table structure for drug_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `drug_admin_user`;
CREATE TABLE `drug_admin_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_admin_userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `InsertTime` timestamp(0) NOT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药库管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_admin_user
-- ----------------------------
INSERT INTO `drug_admin_user` VALUES (1, 'drugadmin1', '2020-03-14 21:02:03');
INSERT INTO `drug_admin_user` VALUES (2, 'drugadmin2', '2020-04-07 20:01:59');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `patient_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `add_time` timestamp(0) NULL DEFAULT NULL COMMENT '添加时间',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `disease` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '患病',
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `method` int(11) NULL DEFAULT NULL COMMENT '药方ID',
  `belong_to_doctor_id` bigint(20) NULL DEFAULT NULL COMMENT '属于哪个医生',
  `ano_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '患者真实姓名',
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `medical_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医疗卡号',
  `ptype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住院或门诊',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES (1, 'patient1', '2020-03-12 22:31:16', '123456', '咳嗽', '14', '女', 2, 1, '张三', '56462', '341131', '住院');
INSERT INTO `patient` VALUES (9, 'patient2', '2020-04-12 13:25:14', NULL, '', '25', '男', NULL, NULL, '李文峰', '243567', '', '');
INSERT INTO `patient` VALUES (10, 'patient3', '2020-04-12 13:48:54', '123456', '', '25', '', NULL, NULL, 'lisi', NULL, NULL, '住院');

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药方说明',
  `usage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用法',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药方状态',
  `create_time` date NULL DEFAULT NULL COMMENT '创建日期',
  `belong_to_patient_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属于哪个患者',
  `belong_to_doctor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开局药方的医生的姓名',
  `did` int(11) NULL DEFAULT NULL COMMENT '医生ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药方' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES (11, '氨茶碱片x5,复方丹参片x7', '哈哈', '已取药', NULL, '张三', '张一样', 1);

-- ----------------------------
-- Table structure for pwd_user
-- ----------------------------
DROP TABLE IF EXISTS `pwd_user`;
CREATE TABLE `pwd_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_type` int(11) NULL DEFAULT NULL COMMENT '类型 1-管理员 2-药库管理员 3-医生 4-病患',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pwd_user
-- ----------------------------
INSERT INTO `pwd_user` VALUES (1, 'admin', '123456', 1);
INSERT INTO `pwd_user` VALUES (2, 'patient1', '123456', 4);
INSERT INTO `pwd_user` VALUES (4, 'doctor1', '123456', 3);
INSERT INTO `pwd_user` VALUES (5, 'drugadmin1', '123456', 2);
INSERT INTO `pwd_user` VALUES (9, 'drugadmin2', '123456', 2);
INSERT INTO `pwd_user` VALUES (10, 'patient2', 'asdfgh', 4);
INSERT INTO `pwd_user` VALUES (11, 'doctor2', '123456', 3);
INSERT INTO `pwd_user` VALUES (12, 'patient3', '123456', 4);

SET FOREIGN_KEY_CHECKS = 1;
