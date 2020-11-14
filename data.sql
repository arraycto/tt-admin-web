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

 Date: 14/11/2020 12:10:25
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
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (2, 0, '测试部门', 0, '2020-11-14 12:03:43', '2020-11-14 12:03:43');

-- ----------------------------
-- Table structure for sys_fe_version
-- ----------------------------
DROP TABLE IF EXISTS `sys_fe_version`;
CREATE TABLE `sys_fe_version`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `fe_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '版本号',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `module` varchar(255) NOT NULL DEFAULT '' COMMENT '模块名',
  `operation_type` varchar(255) NOT NULL DEFAULT '' COMMENT '操作类型',
  `request_url` varchar(255) NOT NULL DEFAULT '' COMMENT '请求地址',
  `request_method` varchar(255) NOT NULL DEFAULT '' COMMENT '请求方法',
  `request_param` varchar(255) NOT NULL DEFAULT '' COMMENT '请求参数',
  `request_time` varchar(255) NOT NULL DEFAULT '' COMMENT '请求耗时',
  `class_method` varchar(255) NOT NULL DEFAULT '' COMMENT '类方法',
  `ip` varchar(255) NOT NULL DEFAULT '' COMMENT 'ip',
  `create_user` varchar(255) NOT NULL DEFAULT '' COMMENT '操作人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '', 1, 'ChromeOutlined', 0, 1, '2019-11-24 08:17:38', '2019-12-03 03:14:27');
INSERT INTO `sys_menu` VALUES (6, 1, '菜单管理', '/system/menu', 1, '', 0, 1, '2019-11-24 10:10:50', '2019-12-01 10:57:13');
INSERT INTO `sys_menu` VALUES (7, 1, '用户管理', '/system/user', 1, '', 0, 1, '2019-11-24 11:50:32', '2020-11-01 22:57:49');
INSERT INTO `sys_menu` VALUES (8, 1, '部门管理', '/system/dept', 1, '', 0, 1, '2019-11-24 11:53:57', '2020-11-01 20:07:27');
INSERT INTO `sys_menu` VALUES (10, 1, '角色管理', '/system/role', 1, '', 0, 1, '2019-11-24 11:58:39', '2020-10-31 12:01:15');
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
INSERT INTO `sys_menu` VALUES (28, 0, '个人中心', '/profile', 3, 'MacCommandOutlined', 0, 1, '2020-05-08 22:35:23', '2020-11-05 23:43:37');
INSERT INTO `sys_menu` VALUES (30, 1, '操作日志', '/system/log', 1, '', 0, 1, '2020-07-04 02:06:28', '2020-11-13 23:43:12');
INSERT INTO `sys_menu` VALUES (38, 0, '版本管理', '/version', 1, 'ChromeOutlined', 0, 0, '2020-11-04 21:57:39', '2020-11-05 00:05:10');
INSERT INTO `sys_menu` VALUES (39, 0, '代码生成', '/code', 1, 'QrcodeOutlined', 0, 0, '2020-11-13 22:32:25', '2020-11-13 22:32:25');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (451, 2, 1, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (452, 2, 6, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (453, 2, 13, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (454, 2, 14, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (455, 2, 15, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (456, 2, 7, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (457, 2, 8, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (458, 2, 10, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (459, 2, 30, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (460, 2, 16, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (461, 2, 17, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (462, 2, 18, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (463, 2, 26, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (464, 2, 19, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (465, 2, 20, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (466, 2, 21, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (467, 2, 22, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (468, 2, 23, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (469, 2, 24, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (470, 2, 25, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (471, 2, 28, '2020-11-01 19:27:42', '2020-11-01 19:27:42');
INSERT INTO `sys_role_menu` VALUES (602, 1, 7, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (603, 1, 8, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (604, 1, 10, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (605, 1, 30, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (606, 1, 16, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (607, 1, 17, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (608, 1, 18, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (609, 1, 26, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (610, 1, 19, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (611, 1, 20, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (612, 1, 21, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (613, 1, 22, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (614, 1, 23, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (615, 1, 24, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (616, 1, 25, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (617, 1, 6, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (618, 1, 13, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (619, 1, 14, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (620, 1, 15, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (621, 1, 28, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (622, 1, 1, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (623, 1, 38, '2020-11-13 22:32:31', '2020-11-13 22:32:31');
INSERT INTO `sys_role_menu` VALUES (624, 1, 39, '2020-11-13 22:32:31', '2020-11-13 22:32:31');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'superadmin', '超级管理员', 'email@qq.com', '81d7804250a8099dce3108a64dc0d71d', '12345678910', 1, '2019-11-20 00:00:00', 'http://localhost:9090/static//user_header_image/f778738c-e4f8-4870-b634-56703b4acafe.gif', 1, '2019-11-20 23:51:23', '2020-11-14 12:03:04');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1, '2020-05-04 01:03:13', '2020-05-04 01:03:16');

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板名称',
  `file_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件类型',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '模板内容',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模板表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of template
-- ----------------------------
INSERT INTO `template` VALUES (1, 'Dao', 'java', 'package ${package}.${module}.dao;\n\nimport ${package}.${module}.vo.${TableName}VO;\nimport ${package}.${module}.model.${TableName}DO;\n\nimport java.util.List;\n\npublic interface ${TableName}Dao {\n\n${TableName}DO findById(Integer id);\n\nList<${TableName}DO> findByCondition(${TableName}VO ${tableName}VO);\n\nvoid save(${TableName}DO ${tableName});\n\nint update(${TableName}DO ${tableName});\n\nint deleteById(Integer id);\n\n}', 'admin', '2020-10-24 15:10:31', '2020-10-24 15:10:31');
INSERT INTO `template` VALUES (2, 'DO', 'java', 'package ${package}.${module}.vo;\n\nimport lombok.Data;\n\n#if($hasDate)\nimport java.util.Date;\n#end\n\n@Data\npublic class ${TableName} {\n\n    #foreach($metaColumn in $columns)\n    /**\n     * $metaColumn.columnComment\n     */\n    private $metaColumn.columnType $metaColumn.columnName;\n    #end\n}\n', 'admin', '2020-10-25 00:45:47', '2020-10-25 00:45:47');
INSERT INTO `template` VALUES (3, 'Service', 'java', 'package ${package}.${module}.service;\n\nimport ${package}.${module}.vo.${TableName}VO;\nimport ${package}.${module}.model.${TableName}DO;\n\nimport java.util.List;\n\npublic interface ${TableName}Service {\n\n    ${TableName}DO findById(Integer id);\n\n    List<${TableName}DO> findByCondition(${TableName}VO ${tableName}VO);\n\n    void save(${TableName}DO user);\n\n    void update(${TableName}DO user);\n\n    void deleteById(Integer id);\n\n    List<${TableName}DO> findAll(${TableName}VO ${tableName}VO);\n\n}', 'admin', '2020-10-25 00:47:34', '2020-10-25 00:47:34');
INSERT INTO `template` VALUES (4, 'ServiceImpl', 'java', 'package ${package}.${module}.service.impl;\n\nimport com.github.pagehelper.PageHelper;\nimport ${package}.${module}.dao.${TableName}Dao;\nimport ${package}.${module}.vo.${TableName}VO;\nimport ${package}.${module}.model.${TableName}DO;\nimport ${package}.${module}.service.${TableName}Service;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Service;\nimport org.springframework.transaction.annotation.Transactional;\n\nimport java.util.List;\n\n@Service\npublic class ${TableName}ServiceImpl implements ${TableName}Service {\n\n	@Autowired\n	private ${TableName}Dao ${tableName}Dao;\n\n	@Override\n	public ${TableName}DO findById(Integer id) {\n		return ${tableName}Dao.findById(id);\n	}\n\n	@Override\n	public List<${TableName}DO> findByCondition(${TableName}VO ${tableName}VO) {\n		PageHelper.startPage(${tableName}VO.getPageNum(), ${tableName}VO.getPageSize());\n		return ${tableName}Dao.findByCondition(${tableName}VO);\n	}\n\n	@Override\n	@Transactional(rollbackFor = Exception.class)\n	public void save(${TableName}DO ${tableName}) {\n		${tableName}Dao.save(${tableName});\n	}\n\n	@Override\n	@Transactional(rollbackFor = Exception.class)\n	public void update(${TableName}DO ${tableName}) {\n		${tableName}Dao.update(${tableName});\n	}\n\n	@Override\n	@Transactional(rollbackFor = Exception.class)\n	public void deleteById(Integer id) {\n		${tableName}Dao.deleteById(id);\n	}\n\n	@Override\n	public List<${TableName}DO> findAll(${TableName}VO ${tableName}VO) {\n		return ${tableName}Dao.findByCondition(${tableName}VO);\n	}\n}\n', 'admin', '2020-10-25 00:49:12', '2020-10-25 00:49:12');
INSERT INTO `template` VALUES (5, 'Controller', 'java', 'package ${package}.${module}.controller;\n\nimport com.github.pagehelper.Page;\nimport ${package}.common.vo.Result;\nimport ${package}.${module}.vo.${TableName}VO;\nimport ${package}.${module}.model.${TableName}DO;\nimport ${package}.${module}.service.${TableName}Service;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport lombok.extern.slf4j.Slf4j;\nimport org.springframework.web.bind.annotation.*;\n\nimport java.util.List;\n\n@RestController\n@Slf4j\n@RequestMapping(\"/${module}/${tableName}\")\npublic class ${TableName}Controller {\n\n    @Autowired\n    private ${TableName}Service ${tableName}Service;\n\n    @GetMapping(\"/list\")\n    @SysLog(module = \"获取${tableName}分页数据\", operationType = \"查看\", desc = \"\")\n    public Result getPageList(${TableName}VO ${tableName}VO) {\n        try {\n            List<${TableName}DO> ${tableName}List = ${tableName}Service.findByCondition(${tableName}VO);\n            if (${tableName}List instanceof Page) {\n                Page page = (Page) ${tableName}List;\n                return Result.ok(${tableName}List, page.getPageNum(), page.getPageSize(), (int) page.getTotal());\n            }\n            return Result.ok(${tableName}List);\n        } catch (Exception e) {\n            log.error(e.getMessage(), e);\n            return Result.error(e.getMessage());\n        }\n    }\n\n    @GetMapping(\"/all-list\")\n    @SysLog(module = \"获取${tableName}全部数据\", operationType = \"查看\", desc = \"\")\n    public Result getAllList(${TableName}VO ${tableName}VO) {\n        try {\n            return Result.ok(${tableName}Service.findAll(${tableName}VO));\n        } catch (Exception e) {\n            log.error(e.getMessage(), e);\n            return Result.error(e.getMessage());\n        }\n    }\n\n    @PostMapping(\"/save\")\n    @SysLog(module = \"添加${tableName}全部数据\", operationType = \"新增\", desc = \"\")\n    public Result save(@RequestBody ${TableName}DO ${tableName}) {\n        try {\n            ${tableName}Service.save(${tableName});\n            return Result.ok();\n        } catch (Exception e) {\n            log.error(e.getMessage(), e);\n            return Result.error(e.getMessage());\n        }\n    }\n\n    @RequestMapping(\"/update\")\n    @SysLog(module = \"修改${tableName}\", operationType = \"修改\", desc = \"\")\n    public Result update(@RequestBody ${TableName}DO ${tableName}) {\n        try {\n            ${tableName}Service.update(${tableName});\n            return Result.ok();\n        } catch (Exception e) {\n            log.error(e.getMessage(), e);\n            return Result.error(e.getMessage());\n        }\n    }\n\n    @PostMapping(\"/delete/{id}\")\n    @SysLog(module = \"删除${tableName}\", operationType = \"删除\", desc = \"\")\n    public Result remove(@PathVariable Integer id) {\n        try {\n            ${tableName}Service.deleteById(id);\n            return Result.ok();\n        } catch (Exception e) {\n            log.error(e.getMessage(), e);\n            return Result.error(e.getMessage());\n        }\n    }\n}\n', 'admin', '2020-10-25 00:50:50', '2020-10-25 00:50:50');
INSERT INTO `template` VALUES (6, 'Mapper', 'xml', '<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n\n<mapper namespace=\"${package}.${module}.dao.${TableName}Dao\">\n\n	<select id=\"findById\" parameterType=\"java.lang.Integer\" resultType=\"${package}.${module}.model.${TableName}DO\">\n		select *\n		from ${table}\n		where id = #{id}\n	</select>\n\n	<select id=\"findByCondition\" parameterType=\"${package}.${module}.vo.${TableName}VO\" resultType=\"${package}.${module}.model.${TableName}DO\">\n		select *\n		from\n		${table}\n        <where>\n        #foreach($metaColumn in $columns)\n		#if($metaColumn.columnName!=\"id\" && $metaColumn.columnType!=\"Date\")\n        <if test=\"$metaColumn.columnName != null #if($metaColumn.columnType==\"String\") and $metaColumn.columnName != \'\' #end\">\n            and `$metaColumn.columnName` = #{$metaColumn.columnName}\n        </if>\n		#end\n        #end\n		</where>\n	</select>\n\n	<insert id=\"save\" parameterType=\"${package}.${module}.model.${TableName}DO\">\n		<selectKey keyProperty=\"id\" order=\"AFTER\" resultType=\"java.lang.Integer\">\n			select last_insert_id()\n		</selectKey>\n		insert into ${table}\n		<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n            #foreach($metaColumn in $columns)\n			#if(($metaColumn.columnType == \"createTime\"))\n				`create_time`,\n			#elseif(($metaColumn.columnName == \"updateTime\"))\n				`update_time`,\n            #elseif($metaColumn.columnName != \"id\")\n			<if test=\"$metaColumn.columnName != null\">\n				`$metaColumn.columnName`,\n			</if>\n			#end\n            #end\n		</trim>\n		<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n            #foreach($metaColumn in $columns)\n                #if(($metaColumn.columnName == \"createTime\" || $metaColumn.columnName == \"updateTime\")&&$metaColumn.columnName != \"id\")\n                now(),\n                #elseif($metaColumn.columnName != \"id\")\n                <if test=\"$metaColumn.columnName != null\">\n                #{$metaColumn.columnName},\n                </if>\n                #end\n            #end\n		</trim>\n	</insert>\n\n	<update id=\"update\" parameterType=\"${package}.${module}.model.${TableName}DO\">\n		update ${table}\n		<set>\n		    #foreach($metaColumn in $columns)\n		        #if($metaColumn.columnName == \'updateTime\'&&$metaColumn.columnName != \'id\')\n                `$metaColumn.column_name` = now(),\n                #elseif($metaColumn.columnName != \'id\'&& $metaColumn.columnName != \'createTime\')\n			    <if test=\"$metaColumn.columnName != null\">`$metaColumn.column_name` = #{$metaColumn.columnName}, </if>\n                #end\n            #end\n		</set>\n		where id = #{id}\n	</update>\n\n	<delete id=\"deleteById\" parameterType=\"java.lang.Integer\">\n		delete from ${table} where id = #{id}\n	</delete>\n	\n</mapper>', 'admin', '2020-10-25 01:04:16', '2020-10-25 01:04:16');
INSERT INTO `template` VALUES (7, 'VO', 'java', 'package ${package}.${module}.vo;\n\nimport lombok.Data;\n\n@Data\npublic class ${TableName}VO {\n\n    private Integer pageNum = 1;\n\n    private Integer pageSize = 10;\n\n    #foreach($metaColumn in $columns)\n    #if($metaColumn.columnName!=\"id\" && $metaColumn.columnType!=\"Date\")\n    /**\n     * $metaColumn.columnComment\n     */\n    private $metaColumn.columnType $metaColumn.columnName;\n    #end\n    #end\n}\n', 'admin', '2020-10-25 21:56:06', '2020-10-25 21:56:06');
INSERT INTO `template` VALUES (8, 'Vue', 'vue', '<template>\n  <div class=\"app-container\">\n    <div class=\"filter-container\">\n      #foreach($metaColumn in $columns)\n      #if($metaColumn.columnName!=\"id\" && $metaColumn.columnType!=\"Date\")\n      <el-input v-model=\"queryParam.$metaColumn.columnName\" placeholder=\"$metaColumn.columnComment\" style=\"width: 200px;\" class=\"filter-item\" />\n      #end\n      #end\n      <el-button class=\"filter-item\" style=\"margin-left: 10px;\" type=\"primary\" icon=\"el-icon-search\" @click=\"search\">\n        搜索\n      </el-button>\n      <el-button\n        class=\"filter-item\"\n        style=\"margin-left: 10px;\"\n        type=\"primary\"\n        icon=\"el-icon-edit\"\n        @click=\"createDialogShow = true\"\n      >添加\n      </el-button>\n    </div>\n\n    <el-table\n      v-loading=\"loading\"\n      border\n      fit\n      :data=\"tableData\"\n      row-key=\"id\"\n      highlight-current-row\n      style=\"width: 100%;\"\n    >\n      >\n      #foreach($metaColumn in $columns)\n      <el-table-metaColumn label=\"$metaColumn.columnComment\" prop=\"$metaColumn.columnName\" align=\"center\" />\n      #end\n      <el-table-metaColumn label=\"操作\" align=\"center\" class-name=\"small-padding fixed-width\">\n        <template slot-scope=\"{row}\">\n          <el-button type=\"primary\" @click=\"edit(row)\">编辑</el-button>\n          <el-button type=\"danger\" @click=\"remove(row)\">删除</el-button>\n        </template>\n      </el-table-metaColumn>\n    </el-table>\n\n    <el-pagination :page-size=\"queryParam.pageSize\" :current-page=\"queryParam.pageNum\" :total=\"queryParam.total\" @current-change=\"pageChange\"/>\n\n    <el-dialog :visible.sync=\"createDialogShow\" :close-on-click-modal=\"false\" destroy-on-close @close=\"closeDialogCallBack\">\n      <el-form ref=\"form\" :model=\"form\" label-position=\"right\" label-width=\"100px\">\n        #foreach($metaColumn in $columns)\n        #if($metaColumn.columnName!=\"id\" && $metaColumn.columnType!=\"Date\")\n        <el-form-item label=\"$metaColumn.columnComment\">\n          <el-input v-model=\"form.$metaColumn.columnName\" />\n        </el-form-item>\n        #end\n        #end\n      </el-form>\n      <div slot=\"footer\" class=\"dialog-footer\">\n        <el-button type=\"primary\" @click=\"save\">提交</el-button>\n      </div>\n    </el-dialog>\n  </div>\n</template>\n\n<script>\nimport { list, remove, add, update } from \'../../../api/${module}/${tableName}\'\n\nexport default {\n  data() {\n    return {\n      tableData: [],\n      loading: false,\n      queryParam: {\n        #foreach($metaColumn in $columns)\n        #if($metaColumn.columnName!=\"id\" && $metaColumn.columnType!=\"Date\")\n        $metaColumn.columnName:\'\',\n        #end\n        #end\n        pageNum: 1,\n        pageSize: 10,\n        total: 0\n      },\n      createDialogShow: false,\n      form: {\n        #foreach($metaColumn in $columns)\n        #if($metaColumn.columnName!=\"id\" && $metaColumn.columnType!=\"Date\")\n        $metaColumn.columnName:\'\',\n        #end\n        #end\n      }\n    }\n  },\n  created() {\n    this.getTableData()\n  },\n  methods: {\n    getTableData() {\n      this.loading = true\n      list(this.queryParam).then(res => {\n        this.loading = false\n        if (res.data.status === 200) {\n          this.tableData = res.data.data\n          this.queryParam.total = res.data.total\n        }\n      }).catch(error => {\n        this.loading = false\n        console.error(error)\n      })\n    },\n    search() {\n      this.queryParam.pageNum = 1\n      this.getTableData()\n    },\n    edit(row) {\n      this.form = { ...row }\n      this.createDialogShow = true\n    },\n    async remove(row) {\n      try {\n        const confirm = await this.$confirm(\'删除\' + row.id + \', 是否继续?\', \'提示\', {\n          confirmButtonText: \'确定\',\n          cancelButtonText: \'取消\',\n          showCancelButton: false,\n          type: \'warning\'\n        })\n        if (confirm === \'confirm\') {\n          let loading\n          try {\n            loading = this.$loading({ fullscreen: true })\n            const res = await remove(row)\n            loading.close()\n            if (res.data.status === 200) {\n              this.getTableData()\n            }\n          } catch (e) {\n            console.error(e)\n            loading.close()\n            this.$message({\n              type: \'error\',\n              message: \'删除失败\'\n            })\n          }\n        }\n      } catch (e) {\n        console.log(\'取消删除\')\n      }\n    },\n    async save() {\n      const loading = this.$loading({ fullscreen: true })\n      let res\n      try {\n        if (this.form.id) {\n          res = await update(this.form)\n        } else {\n          res = await add(this.form)\n        }\n        loading.close()\n        if (res.data.status === 200) {\n          this.$message({ type: \'success\', message: this.form.id ? \'更新成功\' : \'添加成功\' })\n          this.createDialogShow = false\n          this.getTableData()\n        }\n      } catch (e) {\n        console.error(e)\n        loading.close()\n        this.$message({ type: \'error\', message: \'提交\' })\n      }\n    },\n    pageChange(page) {\n      this.queryParam.pageNum = page\n      this.getTableData()\n    },\n    closeDialogCallBack() {\n      this.form.id = null\n    }\n  }\n}\n</script>\n\n<style lang=\"scss\">\n  .el-table .cell {\n    white-space: nowrap;\n  }\n</style>\n', 'admin', '2020-10-25 22:00:09', '2020-10-25 22:00:09');
INSERT INTO `template` VALUES (9, 'Api', 'js', 'import request from \'@/utils/request\'\n\nexport const list = params => request.get(\'/${module}/${tableName}/list\', { params })\nexport const allList = params => request.get(\'/${module}/${tableName}/all-list\', { params })\nexport const add = params => request.post(\'/${module}/${tableName}/save\', params)\nexport const update = params => request.post(\'/${module}/${tableName}/update\', params)\nexport const remove = params => request.post(`/${module}/${tableName}/delete/${params.id}`)', 'admin', '2020-10-25 22:02:49', '2020-10-25 22:02:49');
INSERT INTO `template` VALUES (10, 'React', 'js', 'import React, { useState, useEffect, useRef } from \'react\'\n\nimport { Button, Divider, Input, Table, Form, Modal, notification } from \'antd\'\nimport { list, remove, add, update } from \'@/api/${module}/${tableName}\'\n\nexport default() => {\n  const [tableData, setTableData] = useState([])\n  const [query, setQuery] = useState({\n    pageNum: 1,\n    pageSize: 10,\n    total: 0,\n    fetch: false,\n    #foreach($metaColumn in $columns)\n    #if($metaColumn.columnName!=\"id\" && $metaColumn.columnType!=\"Date\")\n    $metaColumn.columnName:\'\',\n    #end\n    #end\n  })\n  const [tableLoading, setTableLoading] = useState(false)\n  const [formModalShow, setFormModalShow] = useState(false)\n  const formInstance = useRef(null)\n  const [formModalSubmitButtonLoading, setFormModalSubmitButtonLoading] = useState(false)\n  useEffect(() => {\n    getTableData()\n  }, [])\n\n  useEffect(() => {\n    if (query.fetch) {\n      getTableData()\n    }\n  }, [query])\n  const getTableData = () => {\n    setTableLoading(true)\n    list(query).then(res => {\n      setTableLoading(false)\n      setTableData(res.data)\n    }).catch(error => {\n      console.error(error)\n      setTableLoading(false)\n    })\n  }\n\n  const save = (data) => {\n    setFormModalSubmitButtonLoading(true)\n    if (!data.id) {\n      add({ ...data }).then(res => {\n        setFormModalSubmitButtonLoading(false)\n        notification.success({ message: \'添加成功\', duration: 3 })\n        setFormModalShow(false)\n        setQuery({ ...query, pageNum: 1, fetch: true })\n      })\n    } else {\n      update({ ...data }).then(res => {\n        setFormModalSubmitButtonLoading(false)\n        notification.success({ message: \'修改成功\', duration: 3 })\n        setFormModalShow(false)\n        setQuery({ ...query, pageNum: 1, fetch: true })\n      })\n    }\n  }\n  const deleteData = (data) => {\n    Modal.confirm({\n      title: \'删除\',\n      content: `确认删除${data.id} ?`,\n      okText: \'确认\',\n      cancelText: \'取消\',\n      onOk: () => {\n        remove(data).then(res => {\n          notification.success({ message: \'删除成功\', duration: 3 })\n          setQuery({ ...query, fetch: true })\n        })\n      }\n    })\n  }\n\n  const columns = [ \n    #foreach($metaColumn in $columns)\n    {\n        title: \'$metaColumn.columnComment\',\n        align: \'center\',\n        dataIndex:\'$metaColumn.columnName\',\n        key:\'$metaColumn.columnName\'\n    },\n    #end\n    {\n    title: \'操作\',\n    align: \'center\',\n    width: \'20%\',\n    render: (value, record) => {\n      return <div>\n        <Divider type=\'vertical\' />\n        <Button type=\'primary\' onClick={() => {\n          setFormModalShow(true)\n          formInstance.current.setFieldsValue({ ...record })\n        }}>编辑</Button>\n        <Divider type=\'vertical\' />\n        <Button type=\'danger\' onClick={() => {\n          deleteData(record)\n        }}>删除</Button>\n      </div>\n    }\n  }]\n  const getFieldValue = key => {\n    return formInstance.current && formInstance.current.getFieldValue(key)\n  }\n  const renderFormModal = () => {\n    return <Modal\n      title={getFieldValue(\'id\') ? \'修改\' : \'添加\'}\n      visible={formModalShow}\n      forceRender\n      okText={\'提交\'}\n      cancelText={\'取消\'}\n      footer={<div>\n        <Button onClick={() => {\n          setFormModalShow(false)\n        }}>取消</Button>\n        <Button loading={formModalSubmitButtonLoading} type=\'primary\' onClick={() => {\n          formInstance.current.validateFields()\n            .then(values => {\n              // 表单校验成功\n              save(formInstance.current.getFieldValue())\n            }).catch(e => {\n              // 表单校验失败\n              console.log(e)\n            })\n        }}>提交</Button>\n      </div>}\n      onCancel={() => {\n        setFormModalShow(false)\n      }}\n    >\n      <Form ref={formInstance} labelCol={{ span: 4 }} wrapperCol={{ span: 16 }}>\n        #foreach($metaColumn in $columns)\n        #if($metaColumn.columnName!=\"id\" && $metaColumn.columnType!=\"Date\")\n        <Form.Item label=\'$metaColumn.columnComment\' name=\'$metaColumn.columnName\' rules={[{ required: true, message: \'必填\' }]} hasFeedbac>\n          <Input/>\n        </Form.Item>\n        #end\n        #end\n      </Form>\n    </Modal>\n  }\n  return <div className=\'${tableName}-contain\'>\n    <div className=\'${tableName}-contain-search\' style={{ marginBottom: 10 }}>\n      <Form name=\'horizontal_login\' layout=\'inline\'>\n        #foreach($metaColumn in $columns)\n        #if($metaColumn.columnName!=\"id\" && $metaColumn.columnType!=\"Date\")\n        <Form.Item>\n          <Input value={query.$metaColumn.columnName} onChange={e => { setQuery({ ...query, $metaColumn.columnName: e.target.value, fetch: false }) }} placeholder=\'$metaColumn.columnComment\' onPressEnter={() => setQuery({ ...query, 		pageNum: 1, fetch: true })} />\n        </Form.Item>\n        #end\n        #end\n\n        <Form.Item >\n          <Button type=\'primary\' onClick={() => { setQuery({ ...query, pageNum: 1, fetch: true }) }} >查询</Button>\n        </Form.Item>\n        <Form.Item >\n          <Button type=\'primary\' onClick={() => {\n            formInstance.current.setFieldsValue({ id: null, parentId: 0 })\n            setFormModalShow(true)\n          }} >添加</Button>\n        </Form.Item>\n      </Form>\n    </div>\n    <div className=\'${tableName}-contain-content\'>\n      <Table\n        rowKey=\'id\'\n        loading={tableLoading}\n        dataSource={tableData}\n        columns={columns}\n        pagination={{\n          current: query.pageNum,\n          pageSize: query.pageSize,\n          total: query.total,\n          showSizeChanger: false,\n          onChange: page => {\n            setQuery({ ...query, pageNum: page, fetch: true })\n          }\n        }} />\n    </div>\n    {renderFormModal()}\n  </div>\n}\n', 'admin', '2020-10-31 11:49:26', '2020-10-31 11:49:26');