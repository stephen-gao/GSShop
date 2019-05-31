/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80016
Source Host           : 192.168.162.134:3306
Source Database       : gsshop

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-05-31 21:56:52
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `page_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '页面位置',
  `component` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '布局',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `reqAuth` int(1) DEFAULT '0' COMMENT '是否判断权限',
  `state` int(4) NOT NULL COMMENT '状态',
  `sort` int(4) DEFAULT NULL,
  `gmt_create` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `gmt_update` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_resource
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_role
-- ----------------------------

-- ----------------------------
-- Table structure for m_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `m_role_resource`;
CREATE TABLE `m_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `tel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `register_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '极光推送识别码',
  `open_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信openId',
  `balance` decimal(11,2) unsigned zerofill DEFAULT '000000000.00' COMMENT '余额',
  `vip` int(4) unsigned zerofill DEFAULT '0000' COMMENT 'vip 0/普通用户 1/v1',
  `status` int(2) unsigned zerofill DEFAULT '00' COMMENT '账号状态 0/正常 1/监控 2/异常 3/冻结 5/锁定 6/暂停 9/注销',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '盐值',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_update` timestamp NULL DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('8f5689836eef11e9869d000c29242eff', 'zhangsan', 'E9B889441E30637EED6BD9EB71E8554E', '张三', null, null, null, null, '000000000.00', '0000', '00', 'f0dfe54b41159da25d4ffe8a75aa69cc', '2019-05-24 17:53:47', '2019-05-31 17:53:54');
INSERT INTO `m_user` VALUES ('8f5689836eef11e9869d000d29242eff', 'stephen', 'aaaaaaaaaaaaaaaaa', '史蒂芬', null, null, null, null, '000000000.00', '0000', '00', 'aa', '2019-05-24 17:53:47', '2019-05-31 17:53:54');
INSERT INTO `m_user` VALUES ('9492e6f16eef11e9869d000c29242eff', 'lisi', 'FFC7B8BBFCA393E7DC187FD8026578E2', '李四', null, null, null, null, '000000000.00', '0000', '00', 'dc4ca5c1db4a7a6da810a55223a2b83a', '2019-05-24 17:53:47', '2019-05-24 17:53:47');
INSERT INTO `m_user` VALUES ('d220dcc75bb033dca3a24255636a4032', 'hongqi', 'E1E6A55CB9C9314EBB51E4918DC562DA', '洪七', null, null, null, null, '000000000.00', '0000', '00', 'cf2402a85bb498b232e6493fb023039d', '2019-05-24 17:53:47', '2019-05-24 17:53:47');
INSERT INTO `m_user` VALUES ('d7576b1b6f0011e9869d000c29242eff', 'wangwu', '97701F2531B14820624AD33C524BE751', '王五', null, null, null, null, '000000000.00', '0000', '00', 'e8f6572cadeeb68af32dcfd4cd6055b0', '2019-05-24 17:53:47', '2019-05-24 17:53:47');
INSERT INTO `m_user` VALUES ('e4a41c2c44a5ee718323c4c075de4ca8', 'maliu', 'BDCEB3D937FC5C2DB4ADB76F68924522', '马六', null, null, null, null, '000000000.00', '0000', '00', '4d44f27854a37e4952a083914f152ae4', '2019-05-24 17:53:47', '2019-05-24 17:53:47');
INSERT INTO `m_user` VALUES ('facde0366fe211e981c8000c29242eff', 'admin', '59CAB915BDB9C0EE6CAD1750AF309C38', 'admin', null, null, null, null, '000000000.00', '0000', '00', 'bf021b0447b61baedeeff1138a9fe1bc', '2019-05-24 17:53:47', '2019-05-24 17:53:47');

-- ----------------------------
-- Table structure for m_user_role
-- ----------------------------
DROP TABLE IF EXISTS `m_user_role`;
CREATE TABLE `m_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of m_user_role
-- ----------------------------

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `sub_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '子标题',
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `category_id` bigint(20) NOT NULL COMMENT '分类ID',
  `brand_id` bigint(20) NOT NULL COMMENT '品牌ID',
  `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '品牌名称',
  `country_id` bigint(20) DEFAULT NULL COMMENT '产地国家ID',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '产地国家',
  `banner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '列表图',
  `state` int(4) DEFAULT NULL COMMENT '状态',
  `gmt_create` timestamp NOT NULL,
  `gmt_update` timestamp NOT NULL,
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
