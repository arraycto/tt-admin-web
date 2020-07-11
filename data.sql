/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : tt_admin

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 12/07/2020 00:00:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '上级部门ID，一级部门为0',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '部门名称',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '可用状态 1.可用 2.不可用',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_fe_version
-- ----------------------------
DROP TABLE IF EXISTS `sys_fe_version`;
CREATE TABLE `sys_fe_version`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `fe_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `module` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '模块名',
  `operation_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作类型',
  `request_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '请求地址',
  `request_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '请求方法',
  `request_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '请求参数',
  `request_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '请求耗时',
  `class_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类方法',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作人',
  `create_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.03', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:55:16', '2020-07-11 23:55:16');
INSERT INTO `sys_log` VALUES (2, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.01', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:56:12', '2020-07-11 23:56:12');
INSERT INTO `sys_log` VALUES (3, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.00', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:56:36', '2020-07-11 23:56:36');
INSERT INTO `sys_log` VALUES (4, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.00', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:56:53', '2020-07-11 23:56:53');
INSERT INTO `sys_log` VALUES (5, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.01', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:56:53', '2020-07-11 23:56:53');
INSERT INTO `sys_log` VALUES (6, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.00', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:56:53', '2020-07-11 23:56:53');
INSERT INTO `sys_log` VALUES (7, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.01', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:57:38', '2020-07-11 23:57:38');
INSERT INTO `sys_log` VALUES (8, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.00', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:57:45', '2020-07-11 23:57:45');
INSERT INTO `sys_log` VALUES (9, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.00', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:57:48', '2020-07-11 23:57:48');
INSERT INTO `sys_log` VALUES (10, '获取权限菜单', '查看', '/system/menu/permission-list', 'GET', '[MenuVO(pageNum=1, pageSize=10, id=null, parentId=0, name=null, url=null, operate=null, type=null, icon=null, orderNum=null, status=null, createTime=null, updateTime=null, children=null, roleSign=null)]', '0.01', 'com.tt.system.controller.MenuController.getPermissionList', 'superadmin', '2020-07-11 23:57:48', '2020-07-11 23:57:48');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父菜单ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜单名称',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜单URL',
  `type` tinyint(1) NOT NULL DEFAULT 0 COMMENT '类型 1：菜单 2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜单图标',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '可用状态 1.可用 2.不可用',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '', 1, 'el-icon-setting', 0, 1, '2019-11-24 08:17:38', '2019-12-03 03:14:27');
INSERT INTO `sys_menu` VALUES (6, 1, '菜单管理', '/system/menu', 1, '', 0, 1, '2019-11-24 10:10:50', '2019-12-01 10:57:13');
INSERT INTO `sys_menu` VALUES (7, 1, '用户管理', '/system/user', 1, '', 0, 1, '2019-11-24 11:50:32', '2019-12-01 10:57:19');
INSERT INTO `sys_menu` VALUES (8, 1, '部门管理', '/system/dept', 1, '', 0, 1, '2019-11-24 11:53:57', '2019-12-01 10:57:23');
INSERT INTO `sys_menu` VALUES (10, 1, '角色管理', '/system/role', 1, '', 0, 1, '2019-11-24 11:58:39', '2019-12-01 10:57:26');
INSERT INTO `sys_menu` VALUES (11, 0, '系统工具', '', 1, 'el-icon-menu', 0, 1, '2019-12-19 01:21:31', '2019-12-19 01:23:37');
INSERT INTO `sys_menu` VALUES (12, 11, '代码生成', '/system-tool/meta', 1, '', 0, 1, '2019-12-19 01:29:30', '2019-12-19 01:29:30');
INSERT INTO `sys_menu` VALUES (13, 6, '新增', 'add', 2, '', 0, 1, '2020-05-05 02:00:26', '2020-05-05 02:13:15');
INSERT INTO `sys_menu` VALUES (14, 6, '修改', 'update', 2, '', 0, 1, '2020-05-05 02:04:54', '2020-05-05 02:13:21');
INSERT INTO `sys_menu` VALUES (15, 6, '删除', 'delete', 2, '', 0, 1, '2020-05-05 02:05:49', '2020-05-05 02:13:26');
INSERT INTO `sys_menu` VALUES (16, 7, '新增', 'add', 2, '', 0, 1, '2020-05-05 02:07:18', '2020-05-05 02:13:35');
INSERT INTO `sys_menu` VALUES (17, 7, '修改', 'update', 2, '', 0, 1, '2020-05-05 02:07:27', '2020-05-05 02:13:40');
INSERT INTO `sys_menu` VALUES (18, 7, '删除', 'delete', 2, '', 0, 1, '2020-05-05 02:07:37', '2020-05-05 02:13:45');
INSERT INTO `sys_menu` VALUES (19, 8, '新增', 'add', 2, '', 0, 1, '2020-05-05 02:07:49', '2020-05-05 02:13:54');
INSERT INTO `sys_menu` VALUES (20, 8, '修改', 'update', 2, '', 0, 1, '2020-05-05 02:07:57', '2020-05-05 02:14:00');
INSERT INTO `sys_menu` VALUES (21, 8, '删除', 'delete', 2, '', 0, 1, '2020-05-05 02:08:06', '2020-05-05 02:14:04');
INSERT INTO `sys_menu` VALUES (22, 10, '添加', 'add', 2, '', 0, 1, '2020-05-05 18:08:31', '2020-05-05 18:08:31');
INSERT INTO `sys_menu` VALUES (23, 10, '修改', 'update', 2, '', 0, 1, '2020-05-05 18:08:42', '2020-05-05 18:08:42');
INSERT INTO `sys_menu` VALUES (24, 10, '删除', 'delete', 2, '', 0, 1, '2020-05-05 18:08:59', '2020-05-05 18:08:59');
INSERT INTO `sys_menu` VALUES (25, 10, '权限', 'permission', 2, '', 0, 1, '2020-05-05 18:09:15', '2020-05-05 18:09:15');
INSERT INTO `sys_menu` VALUES (26, 7, '重置密码', 'reset-password', 2, '', 0, 1, '2020-05-05 18:09:48', '2020-05-05 18:09:48');
INSERT INTO `sys_menu` VALUES (27, 12, '生成', 'generate', 2, '', 0, 1, '2020-05-05 22:34:46', '2020-05-05 22:34:46');
INSERT INTO `sys_menu` VALUES (28, 0, '版本管理', '/system/version', 1, 'el-icon-edit-outline', 0, 1, '2020-05-08 22:35:23', '2020-05-16 17:56:02');
INSERT INTO `sys_menu` VALUES (30, 1, '操作日志', '/system/log', 1, '', 0, 1, '2020-07-04 02:06:28', '2020-07-04 02:06:28');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_sign` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色标识',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'SUPER_ADMIN', '拥有所有权限', '2019-11-26 00:21:50', '2019-11-26 00:21:50');
INSERT INTO `sys_role` VALUES (2, '管理员', 'ADMIN', '拥有部分权限', '2020-05-05 16:27:17', '2020-05-05 16:27:17');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL DEFAULT 0 COMMENT '角色ID',
  `menu_id` int(11) NOT NULL DEFAULT 0 COMMENT '菜单ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 198 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (143, 2, 1, '2020-05-05 22:37:47', '2020-05-05 22:37:47');
INSERT INTO `sys_role_menu` VALUES (144, 2, 6, '2020-05-05 22:37:47', '2020-05-05 22:37:47');
INSERT INTO `sys_role_menu` VALUES (145, 2, 13, '2020-05-05 22:37:47', '2020-05-05 22:37:47');
INSERT INTO `sys_role_menu` VALUES (146, 2, 14, '2020-05-05 22:37:47', '2020-05-05 22:37:47');
INSERT INTO `sys_role_menu` VALUES (147, 2, 15, '2020-05-05 22:37:47', '2020-05-05 22:37:47');
INSERT INTO `sys_role_menu` VALUES (148, 2, 7, '2020-05-05 22:37:47', '2020-05-05 22:37:47');
INSERT INTO `sys_role_menu` VALUES (149, 2, 11, '2020-05-05 22:37:47', '2020-05-05 22:37:47');
INSERT INTO `sys_role_menu` VALUES (150, 2, 12, '2020-05-05 22:37:47', '2020-05-05 22:37:47');
INSERT INTO `sys_role_menu` VALUES (174, 1, 1, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (175, 1, 6, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (176, 1, 13, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (177, 1, 14, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (178, 1, 15, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (179, 1, 7, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (180, 1, 16, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (181, 1, 17, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (182, 1, 18, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (183, 1, 26, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (184, 1, 8, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (185, 1, 19, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (186, 1, 20, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (187, 1, 21, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (188, 1, 10, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (189, 1, 22, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (190, 1, 23, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (191, 1, 24, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (192, 1, 25, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (193, 1, 30, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (194, 1, 11, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (195, 1, 12, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (196, 1, 27, '2020-07-04 02:07:39', '2020-07-04 02:07:39');
INSERT INTO `sys_role_menu` VALUES (197, 1, 28, '2020-07-04 02:07:39', '2020-07-04 02:07:39');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `sex` tinyint(1) NOT NULL DEFAULT 0 COMMENT '性别 1.男 2.女',
  `birth` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出身日期',
  `image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '头像',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '可用状态 1.可用 2.不可用',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'superadmin', '超级管理员', '', '81d7804250a8099dce3108a64dc0d71d', '', 1, '2019-11-20 00:00:00', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 1, '2019-11-20 23:51:23', '2020-07-11 23:56:51');

-- ----------------------------
-- Table structure for sys_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `create_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_index_user_dept_id`(`user_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户ID',
  `role_id` int(11) NOT NULL DEFAULT 0 COMMENT '角色ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1, '2020-05-04 01:03:13', '2020-05-04 01:03:16');

SET FOREIGN_KEY_CHECKS = 1;
