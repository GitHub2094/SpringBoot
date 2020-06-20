/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : frame

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 20/06/2020 10:50:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '答案ID',
  `subject_id` int(20) DEFAULT NULL COMMENT '题目ID',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '答案内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `subject_answer`(`subject_id`) USING BTREE,
  CONSTRAINT `subject_answer` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (1, 1, 'A');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `college_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学院名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '软件学院');
INSERT INTO `college` VALUES (2, '计算机学院');
INSERT INTO `college` VALUES (3, '法学院');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `course_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `college_id` int(20) DEFAULT NULL COMMENT '隶属学院',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邀请码',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '概率统计与应用', 1, '2020-04-21 10:26:59', '2020-06-17 10:27:03', '方继潘', '123456', '软件工程专业选修课程\r\n\r\n周五#1班');
INSERT INTO `course` VALUES (2, '公民与法律', 3, '2020-04-22 09:17:18', '2020-06-22 09:17:21', '张三', '777777', '法学入门课程，比较简单、实用，目的在于培养基本法律意识，学会解决简单法律问题');
INSERT INTO `course` VALUES (3, 'XML程序设计', 1, '2020-06-05 12:31:03', '2020-07-30 12:31:05', '方继潘', '666666', 'XML程序设计，软件工程专业选修课程 周五#1班');
INSERT INTO `course` VALUES (4, '新型冠状病毒防疫安全公益课', NULL, '2020-06-15 00:00:00', '2020-06-30 00:00:00', '李清照', NULL, 't内容来自于网络，仅做知识普及免费公益推广，不做任何商业用途。如有侵权，请立即删除');
INSERT INTO `course` VALUES (5, '测试课程1', NULL, '2020-06-02 14:50:00', '2020-06-23 10:50:00', '测试老师账号1', NULL, '测试课程1，tttttttttttt');
INSERT INTO `course` VALUES (6, '测试课程444', NULL, '2020-06-19 18:45:00', '2020-06-25 19:45:00', '李清照', NULL, '第三方士大夫士大夫');
INSERT INTO `course` VALUES (7, '测试课程3', NULL, '2020-06-20 08:40:00', '2020-06-30 17:45:00', '测试老师账号2', NULL, 'ffffffffffffffffffffffffffffffffffffffffff');

-- ----------------------------
-- Table structure for course_job
-- ----------------------------
DROP TABLE IF EXISTS `course_job`;
CREATE TABLE `course_job`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `course_id` int(20) NOT NULL COMMENT '课程ID',
  `job_id` int(20) NOT NULL COMMENT '作业ID',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_id1`(`course_id`) USING BTREE,
  INDEX `job_id1`(`job_id`) USING BTREE,
  CONSTRAINT `course_id1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `job_id1` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_job
-- ----------------------------
INSERT INTO `course_job` VALUES (1, 1, 1, '2020-04-21 11:14:25', '2020-06-30 11:14:29');
INSERT INTO `course_job` VALUES (2, 1, 2, '2020-04-22 09:53:32', '2020-06-30 09:53:36');
INSERT INTO `course_job` VALUES (3, 3, 3, '2020-06-10 09:45:00', '2020-06-30 09:45:00');
INSERT INTO `course_job` VALUES (4, 1, 3, '2020-06-10 09:50:00', '2020-06-30 09:45:00');
INSERT INTO `course_job` VALUES (5, 1, 5, '2020-06-12 15:35:00', '2020-06-26 15:35:00');
INSERT INTO `course_job` VALUES (6, 1, 6, '2020-06-19 11:10:00', '2020-06-30 11:10:00');
INSERT INTO `course_job` VALUES (7, 3, 9, '2020-06-19 18:45:00', '2020-06-30 18:45:00');
INSERT INTO `course_job` VALUES (8, 3, 13, '2020-06-19 19:35:00', '2020-06-30 15:55:00');
INSERT INTO `course_job` VALUES (9, 3, 14, '2020-06-19 19:40:00', '2020-06-30 19:40:00');

-- ----------------------------
-- Table structure for course_job_user
-- ----------------------------
DROP TABLE IF EXISTS `course_job_user`;
CREATE TABLE `course_job_user`  (
  `id` int(20) NOT NULL COMMENT '流水号',
  `course_job_id` int(20) NOT NULL COMMENT '作业课程ID',
  `user_id` int(20) NOT NULL COMMENT '学生ID',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '0未完成 1待批阅 2已完成',
  `score` int(5) DEFAULT NULL COMMENT '评分',
  `submit_time` datetime DEFAULT NULL COMMENT '提交时间',
  `review_time` datetime DEFAULT NULL COMMENT '批改时间',
  `review_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '批改人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_job_id`(`course_job_id`) USING BTREE,
  INDEX `user_id2`(`user_id`) USING BTREE,
  CONSTRAINT `course_job_id` FOREIGN KEY (`course_job_id`) REFERENCES `course_job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_job_user
-- ----------------------------
INSERT INTO `course_job_user` VALUES (1, 1, 1, '2', 100, '2020-06-19 13:13:34', '2020-06-12 10:00:39', '方继潘');
INSERT INTO `course_job_user` VALUES (2, 2, 1, '2', 13, NULL, NULL, NULL);
INSERT INTO `course_job_user` VALUES (200610131, 4, 1, '3', 20, '2020-06-10 11:44:46', '2020-06-10 11:48:17', '方继潘');
INSERT INTO `course_job_user` VALUES (200611331, 3, 1, '3', 5, '2020-06-11 08:18:34', '2020-06-19 19:36:50', '方继潘');
INSERT INTO `course_job_user` VALUES (200612151, 5, 1, '3', 50, '2020-06-19 11:03:21', '2020-06-19 13:22:38', '方继潘');
INSERT INTO `course_job_user` VALUES (200619161, 6, 1, '3', 50, '2020-06-19 12:56:59', '2020-06-19 13:16:46', '方继潘');
INSERT INTO `course_job_user` VALUES (200619391, 7, 1, '2', 0, '2020-06-19 18:48:36', NULL, NULL);
INSERT INTO `course_job_user` VALUES (2006193131, 8, 1, '2', 0, '2020-06-19 19:37:33', NULL, NULL);
INSERT INTO `course_job_user` VALUES (2006193141, 9, 1, '2', 0, '2020-06-19 19:46:50', NULL, NULL);

-- ----------------------------
-- Table structure for course_user
-- ----------------------------
DROP TABLE IF EXISTS `course_user`;
CREATE TABLE `course_user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `course_id` int(20) NOT NULL COMMENT '课程ID',
  `user_id` int(20) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_user
-- ----------------------------
INSERT INTO `course_user` VALUES (1, 1, 1);
INSERT INTO `course_user` VALUES (2, 2, 1);
INSERT INTO `course_user` VALUES (3, 3, 1);
INSERT INTO `course_user` VALUES (4, 4, 1);
INSERT INTO `course_user` VALUES (5, 4, 4);
INSERT INTO `course_user` VALUES (6, 5, 7);
INSERT INTO `course_user` VALUES (7, 5, 8);
INSERT INTO `course_user` VALUES (8, 6, 7);
INSERT INTO `course_user` VALUES (9, 6, 8);
INSERT INTO `course_user` VALUES (10, 7, 7);
INSERT INTO `course_user` VALUES (11, 7, 8);
INSERT INTO `course_user` VALUES (12, 7, 11);

-- ----------------------------
-- Table structure for file_upload
-- ----------------------------
DROP TABLE IF EXISTS `file_upload`;
CREATE TABLE `file_upload`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `filePath` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件地址',
  `job_id` int(20) DEFAULT NULL COMMENT '作业地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of file_upload
-- ----------------------------
INSERT INTO `file_upload` VALUES (1, NULL, NULL);
INSERT INTO `file_upload` VALUES (2, '5c9734f3-2702-452e-9e5c-bd4059838302.pdf', 6);
INSERT INTO `file_upload` VALUES (3, '72d753c8-5ea0-47c3-8208-acae28ec0e71.pdf', 6);
INSERT INTO `file_upload` VALUES (4, '3684d829-482c-44d5-8b4c-96a828267fbc.pdf', 6);
INSERT INTO `file_upload` VALUES (5, '4d68b50e-db74-41ea-a69e-0add84cf14f1.pdf', 9);
INSERT INTO `file_upload` VALUES (6, 'af97824c-8f64-4300-b22f-f222914b7a6a.pdf', 10);
INSERT INTO `file_upload` VALUES (7, 'ffd5d9d8-7b9c-455b-8a15-81ceaf10ca92.pdf', 13);
INSERT INTO `file_upload` VALUES (8, 'ea3cf0eb-4baf-4b31-9ea4-0ce318fa5b29.pdf', 14);
INSERT INTO `file_upload` VALUES (9, '158535ce-e4e4-4b6b-8a87-23eeb003b911.pdf', 13);
INSERT INTO `file_upload` VALUES (10, '990e1ff2-ff36-4cb5-b44a-eaf6fc149fd4.pdf', 15);

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '作业ID',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作业标题',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (1, '实验一', '方继潘', '2020-04-21 10:33:08');
INSERT INTO `job` VALUES (2, '实验二', '方继潘', '2020-04-22 09:53:14');
INSERT INTO `job` VALUES (3, '新建作业202006091998', '方继潘', '2020-06-09 16:43:01');
INSERT INTO `job` VALUES (4, '新建作业20200609192131', '方继潘', '2020-06-09 19:21:31');
INSERT INTO `job` VALUES (5, 'testOPT', '方继潘', '2020-06-12 15:35:18');
INSERT INTO `job` VALUES (6, '测试上传', '方继潘', '2020-06-19 11:11:20');
INSERT INTO `job` VALUES (7, '新建作业20200619131746', '方继潘', '2020-06-19 13:17:46');
INSERT INTO `job` VALUES (8, '新建作业20200619150825', '测试老师账号1', '2020-06-19 15:08:25');
INSERT INTO `job` VALUES (9, '测试作业添加t', '方继潘', '2020-06-19 18:43:23');
INSERT INTO `job` VALUES (10, '新建作业20200619192807', '方继潘', '2020-06-19 19:28:07');
INSERT INTO `job` VALUES (11, '新建作业20200619193118', '方继潘', '2020-06-19 19:31:18');
INSERT INTO `job` VALUES (13, '测试作业添加', '方继潘', '2020-06-19 19:33:45');
INSERT INTO `job` VALUES (14, '测试sss', '方继潘', '2020-06-19 19:43:15');
INSERT INTO `job` VALUES (15, '测试dddd', '方继潘', '2020-06-20 09:30:29');
INSERT INTO `job` VALUES (16, '新建作业20200620093844', '方继潘', '2020-06-20 09:38:44');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` int(20) DEFAULT 0 COMMENT '父菜单ID',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限标识',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '管理员', 0, 'system:root');
INSERT INTO `menu` VALUES (2, '学生', 0, 'system:student');
INSERT INTO `menu` VALUES (3, '教师', 0, 'system:teacher');

-- ----------------------------
-- Table structure for opt
-- ----------------------------
DROP TABLE IF EXISTS `opt`;
CREATE TABLE `opt`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '选项ID',
  `subject_id` int(20) NOT NULL COMMENT '题目ID',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of opt
-- ----------------------------
INSERT INTO `opt` VALUES (1, 1, '立法');
INSERT INTO `opt` VALUES (2, 1, '审判');
INSERT INTO `opt` VALUES (3, 1, '监察');
INSERT INTO `opt` VALUES (4, 6, '乡镇');
INSERT INTO `opt` VALUES (5, 6, '派出所');
INSERT INTO `opt` VALUES (6, 6, '街道办公室');
INSERT INTO `opt` VALUES (7, 6, '公安局');
INSERT INTO `opt` VALUES (8, 7, '对');
INSERT INTO `opt` VALUES (9, 7, '错');
INSERT INTO `opt` VALUES (10, 6, 'test');
INSERT INTO `opt` VALUES (11, 9, '对');
INSERT INTO `opt` VALUES (12, 9, '错');
INSERT INTO `opt` VALUES (13, 11, 'A:测试1');
INSERT INTO `opt` VALUES (14, 11, 'B:测试2');
INSERT INTO `opt` VALUES (15, 11, 'C:测试3');
INSERT INTO `opt` VALUES (16, 13, 'A:测试1');
INSERT INTO `opt` VALUES (17, 13, 'B:测试1');
INSERT INTO `opt` VALUES (18, 13, 'C:测试2');
INSERT INTO `opt` VALUES (19, 16, 'test1');
INSERT INTO `opt` VALUES (20, 16, 'test3');
INSERT INTO `opt` VALUES (21, 16, 'tset2');
INSERT INTO `opt` VALUES (22, 16, 'test5');
INSERT INTO `opt` VALUES (23, 18, 'test5');
INSERT INTO `opt` VALUES (24, 18, 'test5');
INSERT INTO `opt` VALUES (25, 18, 'tset3');
INSERT INTO `opt` VALUES (26, 18, '6eee');
INSERT INTO `opt` VALUES (27, 20, 'test5');
INSERT INTO `opt` VALUES (28, 20, '55555');
INSERT INTO `opt` VALUES (29, 20, '555554444');
INSERT INTO `opt` VALUES (30, 20, '546877');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示索引',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '数据范围',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', 'root', 1, NULL);
INSERT INTO `role` VALUES (2, '学生', 'student', 2, NULL);
INSERT INTO `role` VALUES (3, '教师', 'teacher', 3, NULL);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` int(20) NOT NULL COMMENT '角色ID',
  `menu_id` int(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (2, 2);
INSERT INTO `role_menu` VALUES (3, 3);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '题目ID',
  `type` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型(01 02 03 04）',
  `stem` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题干',
  `course_id` int(20) NOT NULL COMMENT '课程id',
  `job_id` int(20) NOT NULL COMMENT '作业id',
  `score` int(5) DEFAULT 0 COMMENT '分值',
  `analysis` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '解析',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_subject`(`course_id`) USING BTREE,
  CONSTRAINT `course_subject` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '1', '行政法以规范国家的（   ）关系为其内容', 1, 1, 50, '解析');
INSERT INTO `subject` VALUES (2, '3', 'test:在行政法律关系中，与行政主体处于相对应的一方的公民、法人和其他组织成为（     ）。', 1, 1, 50, '');
INSERT INTO `subject` VALUES (4, '3', '<p><span style=\"color: rgb(51, 51, 51); font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; font-size: 14px; letter-spacing: 0.54px; text-align: justify;\">李某(男)深夜遇到单身女子王某，起歹意将王某强奸，事后怕王某报案欲杀人灭口，正卡王某脖子时，因有人路过，李某逃离现场，经鉴定王某脖子处构成轻伤。李某的行为属于？</span><br></p>', 1, 3, 20, NULL);
INSERT INTO `subject` VALUES (5, '3', '<p>test</p>', 1, 4, 20, NULL);
INSERT INTO `subject` VALUES (6, '1', '<p><span style=\"font-family: 宋体; font-size: 14px;\">下列各项中不具有行政主体资格的是（&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ）。</span><br></p>', 1, 5, 20, NULL);
INSERT INTO `subject` VALUES (7, '1', '<p><span style=\"overflow-wrap: break-word; white-space: pre-wrap; color: rgb(51, 51, 51); font-size: 14px; font-family: 宋体;\">有甲乙两盒，每盒都有</span><span style=\"overflow-wrap: break-word; white-space: pre-wrap; color: rgb(51, 51, 51); font-size: 14px; font-family: &quot;Times New Roman&quot;;\">2</span><span style=\"overflow-wrap: break-word; white-space: pre-wrap; color: rgb(51, 51, 51); font-size: 14px; font-family: 宋体;\">个红球，</span><span style=\"overflow-wrap: break-word; white-space: pre-wrap; color: rgb(51, 51, 51); font-size: 14px; font-family: &quot;Times New Roman&quot;;\">3</span><span style=\"overflow-wrap: break-word; white-space: pre-wrap; color: rgb(51, 51, 51); font-size: 14px; font-family: 宋体;\">个白球，从甲盒中取一球放入乙盒，再从乙盒中采用不放回抽样取出</span><span style=\"overflow-wrap: break-word; white-space: pre-wrap; color: rgb(51, 51, 51); font-size: 14px; font-family: &quot;Times New Roman&quot;;\">2</span><span style=\"overflow-wrap: break-word; white-space: pre-wrap; color: rgb(51, 51, 51); font-size: 14px; font-family: 宋体;\">球，则取到两个球是一红一白的概率为14/25。</span><br></p>', 1, 5, 30, NULL);
INSERT INTO `subject` VALUES (8, '3', '<span style=\"background-color: rgb(255, 255, 0);\">test ttttt</span>', 1, 6, 20, NULL);
INSERT INTO `subject` VALUES (9, '1', '<p>testsetsetstest</p>', 1, 6, 30, NULL);
INSERT INTO `subject` VALUES (10, '3', '<p>测试简单题</p>', 1, 9, 50, NULL);
INSERT INTO `subject` VALUES (11, '1', '<p>测试选择题</p>', 1, 9, 50, NULL);
INSERT INTO `subject` VALUES (12, '3', '<p>测试题目添加</p>', 1, 10, 50, NULL);
INSERT INTO `subject` VALUES (13, '1', '<p>测试题目添加<br></p>', 1, 10, 50, NULL);
INSERT INTO `subject` VALUES (14, '3', '<p>测试题目添加<br></p>', 1, 11, 50, NULL);
INSERT INTO `subject` VALUES (15, '3', '<p>测试题目添加ttt<br></p>', 1, 13, 50, NULL);
INSERT INTO `subject` VALUES (16, '1', '<p>测试题目添加<br></p>', 1, 13, 50, NULL);
INSERT INTO `subject` VALUES (17, '3', '<p>测试</p>', 1, 14, 50, NULL);
INSERT INTO `subject` VALUES (18, '1', '<p>测试333</p>', 1, 14, 50, NULL);
INSERT INTO `subject` VALUES (19, '3', '<p>testttt</p>', 1, 15, 50, NULL);
INSERT INTO `subject` VALUES (20, '1', '<p>45455454454545</p>', 1, 15, 30, NULL);

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (00001, '账号初始密码', 'sys.user.initPassword', '111111', 'Y', 'root1', '2020-06-14 15:00:12', 'root1', '2020-06-15 11:44:01', '初始化密码 111111');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'lsm', '2020-04-30 11:33:00', 'lsm', '2020-04-30 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (2, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'lsm', '2020-04-30 11:33:00', 'lsm', '2020-04-30 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (3, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2020-04-30 11:33:00', 'lsm', '2020-04-30 11:33:00', '系统默认是');
INSERT INTO `sys_dict_data` VALUES (4, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'lsm', '2020-04-30 11:33:00', '系统默认否');
INSERT INTO `sys_dict_data` VALUES (28, 1, '单选题', '1', 'subject_type', '', 'info', 'N', '0', 'lsm', '2020-04-30 14:18:58', 'root1', '2020-05-06 08:47:16', '题目类型-单选题');
INSERT INTO `sys_dict_data` VALUES (29, 2, '多选题', '2', 'subject_type', '', 'primary', 'N', '0', 'root1', '2020-05-01 11:04:56', 'root1', '2020-05-06 08:47:10', '题目类型-多选题');
INSERT INTO `sys_dict_data` VALUES (30, 3, '简答题', '3', 'subject_type', '', 'success', 'Y', '0', 'root1', '2020-05-01 11:07:24', 'root1', '2020-05-06 08:47:14', '题目类型-简答题');
INSERT INTO `sys_dict_data` VALUES (31, 4, '判断题', '4', 'subject_type', '', 'warning', 'N', '0', 'root1', '2020-05-01 11:09:18', 'root1', '2020-05-06 08:47:20', '题目类型-判断题\r\n');
INSERT INTO `sys_dict_data` VALUES (32, 1, '未完成', '1', 'job_state', NULL, 'danger', 'Y', '0', 'root1', '2020-05-06 08:50:11', '', NULL, '作业状态-未完成');
INSERT INTO `sys_dict_data` VALUES (33, 2, '待批阅', '2', 'job_state', NULL, 'warning', 'Y', '0', 'root1', '2020-05-06 08:50:45', '', NULL, '作业状态-待批阅');
INSERT INTO `sys_dict_data` VALUES (34, 3, '已完成', '3', 'job_state', NULL, 'success', 'Y', '0', 'root1', '2020-05-06 08:51:33', '', NULL, '作业状态-已完成');
INSERT INTO `sys_dict_data` VALUES (35, 1, 'root', '00', 'user_type', '', 'danger', 'Y', '0', 'root1', '2020-06-13 16:39:01', 'root1', '2020-06-13 16:40:00', '系统管理员');
INSERT INTO `sys_dict_data` VALUES (36, 2, 'student', '01', 'user_type', NULL, 'primary', 'Y', '0', 'root1', '2020-06-13 16:39:51', '', NULL, '学生用户');
INSERT INTO `sys_dict_data` VALUES (37, 3, 'teacher', '02', 'user_type', NULL, 'success', 'Y', '0', 'root1', '2020-06-13 16:40:35', '', NULL, '教师用户');
INSERT INTO `sys_dict_data` VALUES (38, 1, '男', '0', 'user_sex', NULL, 'success', 'Y', '0', 'root1', '2020-06-13 17:02:51', '', NULL, '男性');
INSERT INTO `sys_dict_data` VALUES (39, 2, '女', '1', 'user_sex', NULL, 'danger', 'Y', '0', 'root1', '2020-06-13 17:03:12', '', NULL, '女性');
INSERT INTO `sys_dict_data` VALUES (40, 3, '不明', '2', 'user_sex', NULL, 'warning', 'Y', '0', 'root1', '2020-06-13 17:03:44', '', NULL, '不明性别');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '题目类型', 'subject_type', '0', 'lsm', '2020-04-30 14:13:18', 'root1', '2020-05-01 11:04:05', '题目类型列表');
INSERT INTO `sys_dict_type` VALUES (2, '系统开关', 'sys_normal_disable', '0', 'admin', '2020-04-30 11:33:00', 'ry', '2020-04-30 11:33:00', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统是否', 'sys_yes_no', '0', 'admin', '2020-04-30 11:33:00', 'ry', '2020-04-30 11:33:00', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (13, '作业状态', 'job_state', '0', 'root1', '2020-05-06 08:48:43', 'root1', '2020-05-06 08:48:57', '作业状态列表');
INSERT INTO `sys_dict_type` VALUES (14, '用户类型', 'user_type', '0', 'root1', '2020-06-13 16:37:33', 'root1', '2020-06-13 17:01:48', '用户类型\r\n');
INSERT INTO `sys_dict_type` VALUES (15, '用户性别', 'user_sex', '0', 'root1', '2020-06-13 17:01:40', '', NULL, '用户性别');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` int(20) DEFAULT NULL COMMENT '学院ID',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '用户类型（01学生 02老师 00管理员）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像路径',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '111111' COMMENT '密码',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐加密',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '删除标志（0存在 2删除）',
  `login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 101, 'student1', '沈安北', '01', 'shenanbei@qq.com', '13954878648', '0', '', '86e09d11ca67bc71b990232c935d8298', 'e5a08d', '0', '0', '', '2020-03-28 23:09:55', 'lsm', '2020-03-28 23:09:10', 'lsm', '2020-06-13 19:59:54', 'tttt');
INSERT INTO `user` VALUES (2, 102, 'teacher1', '方继潘', '02', 'fangjdddn@qq.com', '18434444444', '0', NULL, '0721e5e85ee6f94092ff0951ba2b97c3', '22222222', '0', '0', NULL, NULL, 'lsm', '2020-03-28 23:11:06', NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 100, 'root1', 'lsm', '00', '184544849@qq.com', '18354879187', '0', '', '15eb6048f347628cabd0be96c0427382', 'f9dfee', '0', '0', NULL, NULL, 'lsm', '2020-03-28 23:13:29', NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, NULL, 'dufu', '杜甫', '01', 'dufu@qq.com', '14332423423', '0', NULL, '3fda89500a4c0fb110113c4f79d619e3', '151c19', '0', '0', NULL, NULL, 'lsm', '2020-06-14 15:43:47', 'lsm', '2020-06-14 15:44:09', '测试账号');
INSERT INTO `user` VALUES (6, NULL, 'liqinzhao', '李清照', '02', 'liqinzhao@qq.com', '14332423423', '1', NULL, 'b7ac5fda4444f13711a87482ae07aa30', 'bc0e12', '0', '0', NULL, NULL, 'lsm', '2020-06-14 15:47:28', 'lsm', '2020-06-15 12:34:21', '测试账号--教师');
INSERT INTO `user` VALUES (7, NULL, 'test1', '测试学生用户1', '01', 'test1@qq.com', '18345678977', '0', NULL, 'f2b02ec08ccdbc0d925d48b2d61908b5', 'c654b6', '0', '0', NULL, NULL, 'lsm', '2020-06-19 14:48:36', 'lsm', '2020-06-19 18:05:20', '测试账号');
INSERT INTO `user` VALUES (8, NULL, 'test2', '测试学生用户2', '01', '154950467@qq.com', '18379178807', '1', NULL, 'f5a9c997fd0749292f6105542b34b93d', '199128', '0', '0', NULL, NULL, 'lsm', '2020-06-19 14:50:51', NULL, NULL, '测试账号\r\n');
INSERT INTO `user` VALUES (9, NULL, 'test3', '测试老师账号1', '02', '154950747@qq.com', '18379178801', '1', NULL, 'c9f24b480c2b924d60e2b6df1b2f6905', '33a3bb', '0', '0', NULL, NULL, 'lsm', '2020-06-19 14:51:53', 'lsm', '2020-06-19 15:07:07', '测试用户');
INSERT INTO `user` VALUES (10, NULL, 'teacher2', '测试老师账号2', '02', '154950767@qq.com', '18379178809', '0', NULL, '8fe5be6ba141beabbb1baca8ed0e9184', '018d7b', '0', '0', NULL, NULL, 'lsm', '2020-06-19 15:07:42', 'lsm', '2020-06-19 18:05:50', 'ttttttttttttttttttttttt');
INSERT INTO `user` VALUES (11, NULL, 'test6', '测试学生用户5fff', '01', '154950767@qq.com', '18379178809', '1', NULL, '4dc50fcfb0fa44afcc9f2f0a545b8bc7', '2b8a89', '0', '0', NULL, NULL, 'lsm', '2020-06-19 19:38:15', 'lsm', '2020-06-19 19:38:32', 'se6se6se6dfgdfg');
INSERT INTO `user` VALUES (12, NULL, 'test4444', '测试学生用户3333', '01', '154950767@qq.com', '18379178809', '1', NULL, 'c533df2eeacb452ac18988e760857004', '637bad', '0', '0', NULL, NULL, 'lsm', '2020-06-19 19:48:00', 'lsm', '2020-06-20 08:44:21', 'dfsfdsfdsf');

-- ----------------------------
-- Table structure for user_reply
-- ----------------------------
DROP TABLE IF EXISTS `user_reply`;
CREATE TABLE `user_reply`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `cju_id` int(20) DEFAULT NULL COMMENT '课程作业用户ID',
  `subject` int(20) DEFAULT NULL COMMENT '题目ID',
  `reply` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回答',
  `score` int(5) DEFAULT NULL COMMENT '评分',
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '批语',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cju_id`(`cju_id`) USING BTREE,
  INDEX `subject`(`subject`) USING BTREE,
  CONSTRAINT `cju_id` FOREIGN KEY (`cju_id`) REFERENCES `course_job_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject` FOREIGN KEY (`subject`) REFERENCES `subject` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_reply
-- ----------------------------
INSERT INTO `user_reply` VALUES (1, 1, 1, '审判', 50, '');
INSERT INTO `user_reply` VALUES (2, 1, 2, '<p><span style=\"font-size: 24px;\">test</span></p><p><span style=\"font-size: 24px; background-color: rgb(255, 255, 0);\">test</span></p>', 50, NULL);
INSERT INTO `user_reply` VALUES (3, 200610131, 4, 'test', 20, NULL);
INSERT INTO `user_reply` VALUES (5, 200611331, 4, '强奸未遂', 5, NULL);
INSERT INTO `user_reply` VALUES (6, 200612151, 6, '街道办公室', 20, NULL);
INSERT INTO `user_reply` VALUES (7, 200612151, 7, '错', 30, NULL);
INSERT INTO `user_reply` VALUES (8, 200619161, 8, 'ttt', 20, NULL);
INSERT INTO `user_reply` VALUES (9, 200619161, 9, '错', 30, NULL);
INSERT INTO `user_reply` VALUES (10, 200619391, 10, 'ttttt', 0, NULL);
INSERT INTO `user_reply` VALUES (11, 200619391, 11, 'B:测试2', 0, NULL);
INSERT INTO `user_reply` VALUES (12, 2006193131, 15, 'testestset', 0, NULL);
INSERT INTO `user_reply` VALUES (13, 2006193131, 16, 'test3', 0, NULL);
INSERT INTO `user_reply` VALUES (14, 2006193141, 17, '<span style=\"background-color: rgb(255, 255, 0);\">cdsfjosdjfsoifdsfdsfd</span>', 0, NULL);
INSERT INTO `user_reply` VALUES (15, 2006193141, 18, '6eee', 0, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(20) NOT NULL COMMENT '用户ID',
  `role_id` int(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 2);
INSERT INTO `user_role` VALUES (2, 3);
INSERT INTO `user_role` VALUES (3, 1);
INSERT INTO `user_role` VALUES (4, 2);
INSERT INTO `user_role` VALUES (6, 3);
INSERT INTO `user_role` VALUES (7, 2);
INSERT INTO `user_role` VALUES (8, 2);
INSERT INTO `user_role` VALUES (9, 3);
INSERT INTO `user_role` VALUES (10, 3);
INSERT INTO `user_role` VALUES (11, 2);
INSERT INTO `user_role` VALUES (12, 2);

SET FOREIGN_KEY_CHECKS = 1;
