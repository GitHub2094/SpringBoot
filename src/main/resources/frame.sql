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

 Date: 09/06/2020 22:40:08
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
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_college`(`college_id`) USING BTREE,
  CONSTRAINT `course_college` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '概率统计与应用', 1, '2020-04-21 10:26:59', '2020-06-17 10:27:03', '方继潘', '123456', '软件工程专业选修课程\r\n\r\n周五#1班');
INSERT INTO `course` VALUES (2, '公民与法律', 3, '2020-04-22 09:17:18', '2020-06-22 09:17:21', '张三', '777777', '法学入门课程，比较简单、实用，目的在于培养基本法律意识，学会解决简单法律问题');
INSERT INTO `course` VALUES (3, 'XML程序设计', 1, '2020-06-05 12:31:03', '2020-07-30 12:31:05', '方继潘', '666666', 'XML程序设计');

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_job
-- ----------------------------
INSERT INTO `course_job` VALUES (1, 1, 1, '2020-04-21 11:14:25', '2020-04-30 11:14:29');
INSERT INTO `course_job` VALUES (2, 1, 2, '2020-04-22 09:53:32', '2020-04-30 09:53:36');

-- ----------------------------
-- Table structure for course_job_user
-- ----------------------------
DROP TABLE IF EXISTS `course_job_user`;
CREATE TABLE `course_job_user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '流水号',
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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_job_user
-- ----------------------------
INSERT INTO `course_job_user` VALUES (1, 1, 1, '3', 90, '2020-06-05 15:11:48', '2020-06-05 16:35:25', 'tddd');
INSERT INTO `course_job_user` VALUES (2, 2, 1, '2', 13, NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_user
-- ----------------------------
INSERT INTO `course_user` VALUES (1, 1, 1);
INSERT INTO `course_user` VALUES (2, 2, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (1, '实验一', '方继潘', '2020-04-21 10:33:08');
INSERT INTO `job` VALUES (2, '实验二', '方继潘', '2020-04-22 09:53:14');
INSERT INTO `job` VALUES (3, '新建作业202006091998', '方继潘', '2020-06-09 16:43:01');
INSERT INTO `job` VALUES (4, '新建作业20200609192131', '方继潘', '2020-06-09 19:21:31');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of opt
-- ----------------------------
INSERT INTO `opt` VALUES (1, 1, '立法');
INSERT INTO `opt` VALUES (2, 1, '审判');
INSERT INTO `opt` VALUES (3, 1, '监察');

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
  `score` int(5) DEFAULT 100 COMMENT '分值',
  `analysis` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '解析',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_subject`(`course_id`) USING BTREE,
  CONSTRAINT `course_subject` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '1', '行政法以规范国家的（   ）关系为其内容', 1, 1, 50, '解析');
INSERT INTO `subject` VALUES (2, '3', '在行政法律关系中，与行政主体处于相对应的一方的公民、法人和其他组织成为（     ）。', 1, 1, 50, '');
INSERT INTO `subject` VALUES (4, '3', '<p><span style=\"color: rgb(51, 51, 51); font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; font-size: 14px; letter-spacing: 0.54px; text-align: justify;\">李某(男)深夜遇到单身女子王某，起歹意将王某强奸，事后怕王某报案欲杀人灭口，正卡王某脖子时，因有人路过，李某逃离现场，经鉴定王某脖子处构成轻伤。李某的行为属于？</span><br></p>', 1, 3, 20, NULL);
INSERT INTO `subject` VALUES (5, '3', '<p>test</p>', 1, 4, 20, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据表' ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '题目类型', 'subject_type', '0', 'lsm', '2020-04-30 14:13:18', 'root1', '2020-05-01 11:04:05', '题目类型列表');
INSERT INTO `sys_dict_type` VALUES (2, '系统开关', 'sys_normal_disable', '0', 'admin', '2020-04-30 11:33:00', 'ry', '2020-04-30 11:33:00', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统是否', 'sys_yes_no', '0', 'admin', '2020-04-30 11:33:00', 'ry', '2020-04-30 11:33:00', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (13, '作业状态', 'job_state', '0', 'root1', '2020-05-06 08:48:43', 'root1', '2020-05-06 08:48:57', '作业状态列表');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 101, 'student1', '沈安北', '01', 'shenanbei@qq.com', '13954878648', '0', '', 'ee3fdd6689856a7f2f689f6ec1730f60', '11111111', '0', '0', '', '2020-03-28 23:09:55', 'lsm', '2020-03-28 23:09:10', '', NULL, NULL);
INSERT INTO `user` VALUES (2, 102, 'teacher1', '方继潘', '02', 'fangjipan@qq.com', '13959554873', '1', NULL, '0721e5e85ee6f94092ff0951ba2b97c3', '22222222', '0', '0', NULL, NULL, 'lsm', '2020-03-28 23:11:06', NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 100, 'root1', 'lsm', '00', '184544849@qq.com', '18354879187', '0', '', '15eb6048f347628cabd0be96c0427382', 'f9dfee', '0', '0', NULL, NULL, 'lsm', '2020-03-28 23:13:29', NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_reply
-- ----------------------------
INSERT INTO `user_reply` VALUES (1, 1, 1, '立法', 50, '');
INSERT INTO `user_reply` VALUES (2, 1, 2, '<p><span style=\"font-size: 24px;\">test</span></p><p><span style=\"font-size: 24px; background-color: rgb(255, 255, 0);\">test</span></p>', 40, NULL);

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

SET FOREIGN_KEY_CHECKS = 1;
