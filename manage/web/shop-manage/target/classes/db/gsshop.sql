/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80016
Source Host           : 192.168.162.134:3306
Source Database       : gsshop

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-06-06 18:42:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_customer_info
-- ----------------------------
DROP TABLE IF EXISTS `c_customer_info`;
CREATE TABLE `c_customer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_id` bigint(11) DEFAULT NULL,
  `username` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tel` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `real_name` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '真实姓名',
  `id_card_type` varchar(4) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_card_no` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` varchar(4) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `birthday` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `photo_small` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `photo_mid` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `photo_source` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_money` decimal(16,2) DEFAULT '0.00' COMMENT '余额',
  `user_point` int(11) DEFAULT '0' COMMENT '积分',
  `vip_level` varchar(4) COLLATE utf8mb4_general_ci DEFAULT '0',
  `state` varchar(4) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gmt_create` timestamp NOT NULL,
  `gmt_update` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of c_customer_info
-- ----------------------------
INSERT INTO `c_customer_info` VALUES ('1', '1', 'zhangsan', '张三', '11', '张三', '1', '111', null, '1', null, null, null, null, '10000.01', '10000', '0', '0', '2019-06-06 16:29:57', '2019-06-06 05:16:47');

-- ----------------------------
-- Table structure for c_customer_login
-- ----------------------------
DROP TABLE IF EXISTS `c_customer_login`;
CREATE TABLE `c_customer_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `access_token` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tel` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `salt` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `state` varchar(4) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gmt_create` timestamp NOT NULL,
  `gmt_update` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of c_customer_login
-- ----------------------------
INSERT INTO `c_customer_login` VALUES ('1', 'zhangsan', '1CE4BD16797046B610B6942186250FFA', null, '111', '9094fda40116bee074173ba7890592d6', '0', '2019-06-06 16:29:07', '2019-06-06 05:16:47');

-- ----------------------------
-- Table structure for c_vip_level
-- ----------------------------
DROP TABLE IF EXISTS `c_vip_level`;
CREATE TABLE `c_vip_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vip_level` varchar(4) COLLATE utf8mb4_general_ci NOT NULL,
  `level_name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `min_point` int(11) DEFAULT NULL,
  `max_point` int(11) DEFAULT NULL,
  `gmt_create` timestamp NULL DEFAULT NULL,
  `gmt_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of c_vip_level
-- ----------------------------
INSERT INTO `c_vip_level` VALUES ('1', '0', '普通用户', '0', '49', '2019-06-06 14:19:34', '2019-06-06 14:19:36');
INSERT INTO `c_vip_level` VALUES ('2', '1', '1级', '50', '199', '2019-06-06 14:20:30', '2019-06-06 14:20:34');
INSERT INTO `c_vip_level` VALUES ('3', '2', '2级', '200', '499', '2019-06-06 14:21:34', '2019-06-06 14:21:37');

-- ----------------------------
-- Table structure for m_resource
-- ----------------------------
DROP TABLE IF EXISTS `m_resource`;
CREATE TABLE `m_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父资源id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路由节点',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型0/菜单,1/中间、2叶子',
  `sort` int(4) DEFAULT NULL,
  `gmt_create` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `gmt_update` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=REDUNDANT;

-- ----------------------------
-- Records of m_resource
-- ----------------------------
INSERT INTO `m_resource` VALUES ('11', '0', '首页', '/home', '/home', 's-home', '0', '0', '2019-06-05 11:32:07', '2019-06-05 11:32:07');
INSERT INTO `m_resource` VALUES ('18', '0', '用户管理', '/user', '/user', 'user-solid', '0', '1', '2019-06-05 11:32:07', '2019-06-05 11:32:07');
INSERT INTO `m_resource` VALUES ('19', '0', '系统管理', '/sys', '/sys', 's-tools', '0', '2', '2019-06-05 11:32:07', '2019-06-05 11:32:07');
INSERT INTO `m_resource` VALUES ('20', '18', '商城用户', '/usershop', '/usershop', 's-custom', '0', '1', '2019-06-03 04:46:22', '2019-06-04 22:21:45');
INSERT INTO `m_resource` VALUES ('21', '18', '后台用户', '/usermanage', '/usermanage', 's-custom', '0', '2', '2019-06-03 04:46:57', '2019-06-04 22:21:51');
INSERT INTO `m_resource` VALUES ('22', '18', '角色管理', '/role', '/role', 's-custom', '0', '3', '2019-06-03 04:47:58', '2019-06-04 22:21:54');
INSERT INTO `m_resource` VALUES ('23', '18', '资源管理', '/resource', '/resource', 's-custom', '0', '4', '2019-06-03 04:48:45', '2019-06-04 22:21:58');
INSERT INTO `m_resource` VALUES ('24', '19', '数据字典', '/sysdic', '/sysdic', 's-opportunity', '0', '1', '2019-06-03 04:56:28', '2019-06-04 22:22:01');
INSERT INTO `m_resource` VALUES ('25', '19', '关于', '/about', '/about', 's-opportunity', '0', '2', '2019-06-03 04:57:13', '2019-06-04 22:22:09');

-- ----------------------------
-- Table structure for m_role
-- ----------------------------
DROP TABLE IF EXISTS `m_role`;
CREATE TABLE `m_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  `gmt_create` timestamp NULL DEFAULT NULL,
  `gmt_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_role
-- ----------------------------
INSERT INTO `m_role` VALUES ('5', '超级管理员', '超级管理员', '1', '2019-06-04 01:08:48', '2019-06-05 05:51:21');
INSERT INTO `m_role` VALUES ('6', '管理员', '管理员', '2', '2019-06-04 01:14:37', '2019-06-05 05:51:11');
INSERT INTO `m_role` VALUES ('7', '普通用户1', '普通用户1', '3', '2019-06-04 01:17:23', '2019-06-05 05:51:01');

-- ----------------------------
-- Table structure for m_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `m_role_resource`;
CREATE TABLE `m_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  `resource_code` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_role_resource
-- ----------------------------
INSERT INTO `m_role_resource` VALUES ('75', '7', '11', '/home');
INSERT INTO `m_role_resource` VALUES ('76', '7', '18', '/user');
INSERT INTO `m_role_resource` VALUES ('77', '7', '20', '/usershop');
INSERT INTO `m_role_resource` VALUES ('78', '7', '19', '/sys');
INSERT INTO `m_role_resource` VALUES ('79', '7', '25', '/about');
INSERT INTO `m_role_resource` VALUES ('80', '6', '11', '/home');
INSERT INTO `m_role_resource` VALUES ('81', '6', '18', '/user');
INSERT INTO `m_role_resource` VALUES ('82', '6', '20', '/usershop');
INSERT INTO `m_role_resource` VALUES ('83', '6', '21', '/usermanage');
INSERT INTO `m_role_resource` VALUES ('84', '6', '19', '/sys');
INSERT INTO `m_role_resource` VALUES ('85', '6', '25', '/about');
INSERT INTO `m_role_resource` VALUES ('86', '5', '11', '/home');
INSERT INTO `m_role_resource` VALUES ('87', '5', '18', '/user');
INSERT INTO `m_role_resource` VALUES ('88', '5', '20', '/usershop');
INSERT INTO `m_role_resource` VALUES ('89', '5', '21', '/usermanage');
INSERT INTO `m_role_resource` VALUES ('90', '5', '22', '/role');
INSERT INTO `m_role_resource` VALUES ('91', '5', '23', '/resource');
INSERT INTO `m_role_resource` VALUES ('92', '5', '19', '/sys');
INSERT INTO `m_role_resource` VALUES ('93', '5', '24', '/sysdic');
INSERT INTO `m_role_resource` VALUES ('94', '5', '25', '/about');

-- ----------------------------
-- Table structure for m_sys_dic_item
-- ----------------------------
DROP TABLE IF EXISTS `m_sys_dic_item`;
CREATE TABLE `m_sys_dic_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type_id` bigint(20) NOT NULL,
  `type_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sort` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_sys_dic_item
-- ----------------------------
INSERT INTO `m_sys_dic_item` VALUES ('1', '男', '0', '1', 'sys_gender', '0');
INSERT INTO `m_sys_dic_item` VALUES ('2', '女', '1', '1', 'sys_gender', '1');
INSERT INTO `m_sys_dic_item` VALUES ('3', '保密', '2', '1', 'sys_gender', '2');
INSERT INTO `m_sys_dic_item` VALUES ('4', '菜单节点', '0', '2', 'sys_resource_item_type', '0');
INSERT INTO `m_sys_dic_item` VALUES ('5', '资源结点', '1', '2', 'sys_resource_item_type', '1');
INSERT INTO `m_sys_dic_item` VALUES ('6', '正常', '0', '3', 'sys_user_manager_state', '0');
INSERT INTO `m_sys_dic_item` VALUES ('7', '监控', '1', '3', 'sys_user_manager_state', '1');
INSERT INTO `m_sys_dic_item` VALUES ('8', '异常', '2', '3', 'sys_user_manager_state', '2');
INSERT INTO `m_sys_dic_item` VALUES ('9', '冻结', '3', '3', 'sys_user_manager_state', '3');
INSERT INTO `m_sys_dic_item` VALUES ('10', '锁定', '4', '3', 'sys_user_manager_state', '4');
INSERT INTO `m_sys_dic_item` VALUES ('11', '暂停', '5', '3', 'sys_user_manager_state', '5');
INSERT INTO `m_sys_dic_item` VALUES ('12', '注销', '9', '3', 'sys_user_manager_state', '9');
INSERT INTO `m_sys_dic_item` VALUES ('18', '正常', '0', '9', 'shop_customer_state', '0');
INSERT INTO `m_sys_dic_item` VALUES ('19', '监控', '1', '9', 'shop_customer_state', '1');
INSERT INTO `m_sys_dic_item` VALUES ('20', '异常', '2', '9', 'shop_customer_state', '2');
INSERT INTO `m_sys_dic_item` VALUES ('21', '冻结', '3', '9', 'shop_customer_state', '3');
INSERT INTO `m_sys_dic_item` VALUES ('22', '锁定', '4', '9', 'shop_customer_state', '4');
INSERT INTO `m_sys_dic_item` VALUES ('23', '暂停', '5', '9', 'shop_customer_state', '5');
INSERT INTO `m_sys_dic_item` VALUES ('24', '注销', '9', '9', 'shop_customer_state', '9');

-- ----------------------------
-- Table structure for m_sys_dic_type
-- ----------------------------
DROP TABLE IF EXISTS `m_sys_dic_type`;
CREATE TABLE `m_sys_dic_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sort` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_sys_dic_type
-- ----------------------------
INSERT INTO `m_sys_dic_type` VALUES ('1', 'sys_gender', '性别', '1');
INSERT INTO `m_sys_dic_type` VALUES ('2', 'sys_resource_item_type', '资源节点类型', '2');
INSERT INTO `m_sys_dic_type` VALUES ('3', 'sys_user_manager_state', '后台用户状态', '3');
INSERT INTO `m_sys_dic_type` VALUES ('9', 'shop_customer_state', '商城用户状态', '4');

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `tel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '极光推送识别码',
  `photo` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `state` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '账号状态 0/正常 1/监控 2/异常 3/冻结 5/锁定 6/暂停 9/注销',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '盐值',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_update` timestamp NULL DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('2', 'stephen', 'aaaaaaaaaaaaaaaaa', '史蒂芬', null, null, null, '0', 'aa', '2019-05-24 17:53:47', '2019-05-31 17:53:54');
INSERT INTO `m_user` VALUES ('3', 'lisi', 'FFC7B8BBFCA393E7DC187FD8026578E2', '李四', null, null, null, '0', 'dc4ca5c1db4a7a6da810a55223a2b83a', '2019-05-24 17:53:47', '2019-05-24 17:53:47');
INSERT INTO `m_user` VALUES ('4', 'hongqi', 'E1E6A55CB9C9314EBB51E4918DC562DA', '洪七', null, null, null, '0', 'cf2402a85bb498b232e6493fb023039d', '2019-05-24 17:53:47', '2019-05-24 17:53:47');
INSERT INTO `m_user` VALUES ('5', 'wangwu', '97701F2531B14820624AD33C524BE751', '王五', null, null, null, '0', 'e8f6572cadeeb68af32dcfd4cd6055b0', '2019-05-24 17:53:47', '2019-05-24 17:53:47');
INSERT INTO `m_user` VALUES ('6', 'maliu', 'F2FE96E76514C28D90BBF30C0DF8234B', '马六', null, null, null, '0', 'd925cd9ecea101dcb9e971892cadedc8', '2019-05-24 17:53:47', '2019-06-05 21:44:11');
INSERT INTO `m_user` VALUES ('7', 'admin', 'BF3DDC9D8CA6696368C4C52896081D91', 'admin', null, null, null, '0', '61f4d676f0cf22663609219a823a3f8a', '2019-05-24 17:53:47', '2019-06-05 21:44:47');
INSERT INTO `m_user` VALUES ('9', 'wangba', '5FEC0DFE23768A6D7B5B214D8BBDFD74', '王八', '', '', '', '0', '5d6f2e7568ede6d99a823331d0d1b58d', '2019-06-05 04:53:32', '2019-06-05 04:53:32');
INSERT INTO `m_user` VALUES ('10', 'zhangsan', 'AC7E2561691F2DB37B07801FC2F74D98', '张三', '', '', '', '0', '1ea5c781350165b0daf07b07a79beecd', '2019-06-05 04:56:00', '2019-06-05 04:56:00');
INSERT INTO `m_user` VALUES ('11', 'super', '59809F8968BB62564630BD4133B2B1B1', 'super', '', '', '', '0', '2db096d9aed8fc2002f21f0cfdbdad05', '2019-06-05 21:44:39', '2019-06-05 21:44:39');

-- ----------------------------
-- Table structure for m_user_role
-- ----------------------------
DROP TABLE IF EXISTS `m_user_role`;
CREATE TABLE `m_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_user_role
-- ----------------------------
INSERT INTO `m_user_role` VALUES ('3', '2', '7');
INSERT INTO `m_user_role` VALUES ('4', '3', '7');
INSERT INTO `m_user_role` VALUES ('5', '4', '7');
INSERT INTO `m_user_role` VALUES ('6', '5', '7');
INSERT INTO `m_user_role` VALUES ('7', '6', '7');
INSERT INTO `m_user_role` VALUES ('8', '7', '6');
INSERT INTO `m_user_role` VALUES ('9', '9', '7');
INSERT INTO `m_user_role` VALUES ('10', '10', '7');
INSERT INTO `m_user_role` VALUES ('11', '11', '5');

-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `letter` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gmt_create` timestamp NOT NULL,
  `gmt_update` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of t_brand
-- ----------------------------

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `parent_id` bigint(20) NOT NULL,
  `sort` int(11) NOT NULL,
  `gmt_create` timestamp NOT NULL COMMENT '创建时间',
  `gmt_update` timestamp NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='分类表';

-- ----------------------------
-- Records of t_category
-- ----------------------------

-- ----------------------------
-- Table structure for t_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_sku`;
CREATE TABLE `t_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) NOT NULL COMMENT 'spu_id',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品标题',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'sku图片',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `cost_price` decimal(10,0) DEFAULT NULL,
  `activity_price` decimal(10,0) DEFAULT NULL,
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '库存',
  `state` int(4) DEFAULT NULL COMMENT '状态',
  `sort` int(11) DEFAULT NULL,
  `gmt_create` timestamp NOT NULL,
  `gmt_update` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of t_sku
-- ----------------------------

-- ----------------------------
-- Table structure for t_sku_spec
-- ----------------------------
DROP TABLE IF EXISTS `t_sku_spec`;
CREATE TABLE `t_sku_spec` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) NOT NULL,
  `spec_tree_id` bigint(20) NOT NULL,
  `spec_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `spec_value` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  `gmt_create` timestamp NOT NULL,
  `gmt_update` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of t_sku_spec
-- ----------------------------

-- ----------------------------
-- Table structure for t_spec_tree
-- ----------------------------
DROP TABLE IF EXISTS `t_spec_tree`;
CREATE TABLE `t_spec_tree` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spec_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
  `spec_value` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格值',
  `parent_id` bigint(20) NOT NULL COMMENT '父节点',
  `type` int(2) NOT NULL COMMENT '区分sku/spu,0/spu,1/sku',
  `spec_flag` int(1) NOT NULL COMMENT '是否是可选规格(叶子节点)标识',
  `sort` int(4) DEFAULT NULL,
  `gmt_create` timestamp NULL DEFAULT NULL,
  `gmt_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of t_spec_tree
-- ----------------------------

-- ----------------------------
-- Table structure for t_spu
-- ----------------------------
DROP TABLE IF EXISTS `t_spu`;
CREATE TABLE `t_spu` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
  `title`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题' ,
  `sub_title`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '子标题' ,
  `description`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述' ,
  `category_id`  bigint(20) NOT NULL COMMENT '分类ID' ,
  `brand_id`  bigint(20) NOT NULL COMMENT '品牌ID' ,
  `brand`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌名称' ,
  `country_id`  bigint(20) NULL DEFAULT NULL COMMENT '产地国家ID' ,
  `country`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产地国家' ,
  `banner`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列表图' ,
  `state`  int(4) NULL DEFAULT NULL COMMENT '状态 0下架，1上架' ,
  `type`  int(4) NULL DEFAULT NULL COMMENT '商品类型，1普通商品、2新人商品、3活动商品（待续）' ,
  `gmt_create`  timestamp NOT NULL ,
  `gmt_update`  timestamp NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of t_spu
-- ----------------------------

-- ----------------------------
-- Table structure for t_spu_group
-- ----------------------------
DROP TABLE IF EXISTS `t_spu_group`;
CREATE TABLE `t_spu_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) NOT NULL COMMENT 'spu_id',
  `group_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格组名称',
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `gmt_create` timestamp NULL DEFAULT NULL,
  `gmt_update` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of t_spu_group
-- ----------------------------

-- ----------------------------
-- Table structure for t_spu_group_spec
-- ----------------------------
DROP TABLE IF EXISTS `t_spu_group_spec`;
CREATE TABLE `t_spu_group_spec` (
  `id` bigint(20) NOT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `spec_tree_id` bigint(20) NOT NULL,
  `spec_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `spec_value` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  `gmt_create` timestamp NOT NULL,
  `gmt_update` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of t_spu_group_spec
-- ----------------------------
