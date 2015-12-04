/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : bbs2.0

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-08-13 22:58:20
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bbs_module`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_module`;
CREATE TABLE `bbs_module` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '模块名',
  `description` varchar(100) DEFAULT NULL COMMENT '对模块的描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_module
-- ----------------------------
INSERT INTO bbs_module VALUES ('1', 'sport', 'sport');
INSERT INTO bbs_module VALUES ('2', 'travel', 'travel');
INSERT INTO bbs_module VALUES ('3', 'interest', 'interest');

-- ----------------------------
-- Table structure for `bbs_response`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_response`;
CREATE TABLE `bbs_response` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme_id` int(11) NOT NULL COMMENT '该回复对应的主题',
  `user_id` varchar(50) NOT NULL COMMENT '回复者',
  `content` varchar(500) NOT NULL COMMENT '回复的内容',
  `create_time` datetime NOT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`),
  KEY `theme_id` (`theme_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bbs_response_ibfk_1` FOREIGN KEY (`theme_id`) REFERENCES `bbs_theme` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bbs_response_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `bbs_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_response
-- ----------------------------
INSERT INTO bbs_response VALUES ('1', '3', 'admin', 't', '2015-08-11 23:37:39');
INSERT INTO bbs_response VALUES ('2', '4', 'admin', 'n', '2015-08-11 23:38:40');
INSERT INTO bbs_response VALUES ('3', '4', 'admin', 'test', '2015-08-12 14:37:14');
INSERT INTO bbs_response VALUES ('4', '4', 'admin', 't2', '2015-08-12 14:41:41');
INSERT INTO bbs_response VALUES ('5', '4', 'admin', 't3', '2015-08-12 14:43:07');
INSERT INTO bbs_response VALUES ('6', '4', 'admin', 't4', '2015-08-12 14:43:15');
INSERT INTO bbs_response VALUES ('7', '4', 'admin', '5', '2015-08-12 14:43:51');
INSERT INTO bbs_response VALUES ('8', '4', 'admin', '6', '2015-08-12 14:51:12');
INSERT INTO bbs_response VALUES ('9', '4', 'admin', '7', '2015-08-12 14:51:55');
INSERT INTO bbs_response VALUES ('10', '4', 'admin', '8', '2015-08-12 14:52:41');
INSERT INTO bbs_response VALUES ('11', '4', 'admin', '9', '2015-08-12 14:52:55');
INSERT INTO bbs_response VALUES ('12', '5', 'admin', 'len', '2015-08-12 15:17:57');
INSERT INTO bbs_response VALUES ('13', '4', 'admin', '10', '2015-08-12 15:20:03');
INSERT INTO bbs_response VALUES ('14', '6', 'admin', 'visit', '2015-08-12 17:16:00');
INSERT INTO bbs_response VALUES ('15', '7', 'admin', 'BJ', '2015-08-13 01:43:58');
INSERT INTO bbs_response VALUES ('16', '8', 'a', '你好', '2015-08-13 15:24:06');
INSERT INTO bbs_response VALUES ('17', '9', 'a', 'reading', '2015-08-13 15:33:21');
INSERT INTO bbs_response VALUES ('18', '9', 'a', 'like it, too', '2015-08-13 15:33:46');

-- ----------------------------
-- Table structure for `bbs_theme`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_theme`;
CREATE TABLE `bbs_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(200) DEFAULT NULL COMMENT '帖子主题',
  `user_id` varchar(50) NOT NULL COMMENT '贴子创建者id',
  `module_id` tinyint(4) NOT NULL COMMENT '该贴子所属的模块',
  `is_up` tinyint(3) DEFAULT '0' COMMENT '是否置顶，1表示置顶，0表示不置顶',
  `is_hot` tinyint(3) DEFAULT NULL,
  `is_lock` tinyint(3) unsigned zerofill DEFAULT '000' COMMENT '是否锁定，1表示锁定，0表示不锁定，锁定之后不能再回复',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `module_id` (`module_id`),
  CONSTRAINT `bbs_theme_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `bbs_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_theme
-- ----------------------------
INSERT INTO bbs_theme VALUES ('3', 't', 'admin', '1', '0', '0', '001', '2015-08-11 23:37:39');
INSERT INTO bbs_theme VALUES ('4', 'n', 'admin', '1', '0', '1', '000', '2015-08-11 23:38:40');
INSERT INTO bbs_theme VALUES ('5', 'len', 'admin', '1', '1', '0', '000', '2015-08-12 15:17:57');
INSERT INTO bbs_theme VALUES ('6', 'visit', 'admin', '1', '0', '1', '000', '2015-08-12 17:16:00');
INSERT INTO bbs_theme VALUES ('7', 'Beijing', 'admin', '2', '0', '1', '000', '2015-08-13 01:43:58');
INSERT INTO bbs_theme VALUES ('8', '你好', 'a', '2', '0', '0', '000', '2015-08-13 15:24:06');
INSERT INTO bbs_theme VALUES ('9', 'Reading', 'a', '3', '0', '0', '000', '2015-08-13 15:33:21');

-- ----------------------------
-- Table structure for `bbs_user`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user` (
  `id` varchar(50) NOT NULL COMMENT '用户ID，必须唯一',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_user
-- ----------------------------
INSERT INTO bbs_user VALUES ('', '', '', null);
INSERT INTO bbs_user VALUES ('a', 'a', 'a', 'a');
INSERT INTO bbs_user VALUES ('admin', 'admin', 'admin', 'admin@qq.com');

-- ----------------------------
-- Table structure for `visit_log`
-- ----------------------------
DROP TABLE IF EXISTS `visit_log`;
CREATE TABLE `visit_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL,
  `theme_id` int(11) NOT NULL,
  `start_time` datetime DEFAULT NULL COMMENT '进入贴子时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `theme_id` (`theme_id`),
  CONSTRAINT `visit_log_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `bbs_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `visit_log_ibfk_2` FOREIGN KEY (`theme_id`) REFERENCES `bbs_theme` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visit_log
-- ----------------------------
INSERT INTO visit_log VALUES ('2', 'admin', '3', '2015-08-11 23:37:39');
INSERT INTO visit_log VALUES ('3', 'admin', '4', '2015-08-11 23:38:40');
INSERT INTO visit_log VALUES ('6', 'admin', '3', '2015-08-11 23:41:23');
INSERT INTO visit_log VALUES ('17', 'admin', '3', '2015-08-12 00:04:52');
INSERT INTO visit_log VALUES ('24', 'admin', '4', '2015-08-12 09:50:30');
INSERT INTO visit_log VALUES ('25', 'admin', '4', '2015-08-12 10:15:16');
INSERT INTO visit_log VALUES ('26', 'admin', '4', '2015-08-12 10:53:22');
INSERT INTO visit_log VALUES ('28', 'admin', '4', '2015-08-12 10:55:05');
INSERT INTO visit_log VALUES ('30', 'admin', '3', '2015-08-12 11:00:41');
INSERT INTO visit_log VALUES ('31', 'admin', '3', '2015-08-12 11:01:46');
INSERT INTO visit_log VALUES ('32', 'admin', '3', '2015-08-12 11:36:18');
INSERT INTO visit_log VALUES ('33', 'admin', '4', '2015-08-12 11:36:26');
INSERT INTO visit_log VALUES ('34', 'admin', '3', '2015-08-12 11:38:06');
INSERT INTO visit_log VALUES ('35', 'admin', '3', '2015-08-12 11:39:14');
INSERT INTO visit_log VALUES ('36', 'admin', '3', '2015-08-12 11:39:19');
INSERT INTO visit_log VALUES ('37', 'admin', '3', '2015-08-12 11:40:06');
INSERT INTO visit_log VALUES ('38', 'admin', '3', '2015-08-12 14:08:07');
INSERT INTO visit_log VALUES ('39', 'admin', '4', '2015-08-12 14:08:31');
INSERT INTO visit_log VALUES ('40', 'admin', '3', '2015-08-12 14:18:18');
INSERT INTO visit_log VALUES ('41', 'admin', '3', '2015-08-12 14:18:49');
INSERT INTO visit_log VALUES ('42', 'admin', '4', '2015-08-12 14:18:56');
INSERT INTO visit_log VALUES ('43', 'admin', '3', '2015-08-12 14:19:06');
INSERT INTO visit_log VALUES ('44', 'admin', '3', '2015-08-12 14:21:06');
INSERT INTO visit_log VALUES ('45', 'admin', '3', '2015-08-12 14:32:30');
INSERT INTO visit_log VALUES ('46', 'admin', '4', '2015-08-12 14:32:39');
INSERT INTO visit_log VALUES ('47', 'admin', '4', '2015-08-12 14:37:07');
INSERT INTO visit_log VALUES ('48', 'admin', '4', '2015-08-12 14:37:44');
INSERT INTO visit_log VALUES ('49', 'admin', '4', '2015-08-12 14:41:33');
INSERT INTO visit_log VALUES ('50', 'admin', '4', '2015-08-12 14:42:46');
INSERT INTO visit_log VALUES ('51', 'admin', '4', '2015-08-12 14:43:00');
INSERT INTO visit_log VALUES ('52', 'admin', '4', '2015-08-12 14:43:45');
INSERT INTO visit_log VALUES ('53', 'admin', '4', '2015-08-12 14:51:05');
INSERT INTO visit_log VALUES ('54', '', '4', '2015-08-12 15:11:59');
INSERT INTO visit_log VALUES ('55', 'admin', '5', '2015-08-12 15:17:57');
INSERT INTO visit_log VALUES ('56', 'admin', '5', '2015-08-12 15:19:29');
INSERT INTO visit_log VALUES ('57', 'admin', '5', '2015-08-12 15:19:39');
INSERT INTO visit_log VALUES ('58', 'admin', '4', '2015-08-12 15:19:49');
INSERT INTO visit_log VALUES ('59', 'admin', '4', '2015-08-12 15:20:11');
INSERT INTO visit_log VALUES ('60', 'admin', '5', '2015-08-12 15:21:14');
INSERT INTO visit_log VALUES ('61', 'admin', '5', '2015-08-12 15:21:21');
INSERT INTO visit_log VALUES ('62', 'admin', '5', '2015-08-12 15:21:29');
INSERT INTO visit_log VALUES ('63', 'admin', '5', '2015-08-12 17:03:49');
INSERT INTO visit_log VALUES ('64', 'admin', '5', '2015-08-12 17:04:00');
INSERT INTO visit_log VALUES ('65', 'admin', '6', '2015-08-12 17:16:00');
INSERT INTO visit_log VALUES ('66', 'admin', '6', '2015-08-12 17:16:18');
INSERT INTO visit_log VALUES ('67', 'admin', '6', '2015-08-12 17:16:35');
INSERT INTO visit_log VALUES ('68', 'admin', '6', '2015-08-12 17:19:57');
INSERT INTO visit_log VALUES ('69', 'admin', '6', '2015-08-12 17:20:03');
INSERT INTO visit_log VALUES ('70', 'admin', '5', '2015-08-12 17:22:33');
INSERT INTO visit_log VALUES ('71', 'admin', '5', '2015-08-12 17:25:05');
INSERT INTO visit_log VALUES ('72', '', '6', '2015-08-13 00:11:58');
INSERT INTO visit_log VALUES ('73', '', '4', '2015-08-13 00:12:07');
INSERT INTO visit_log VALUES ('74', '', '6', '2015-08-13 00:40:17');
INSERT INTO visit_log VALUES ('75', '', '4', '2015-08-13 00:40:24');
INSERT INTO visit_log VALUES ('76', '', '6', '2015-08-13 01:03:01');
INSERT INTO visit_log VALUES ('77', 'admin', '7', '2015-08-13 01:43:58');
INSERT INTO visit_log VALUES ('78', 'admin', '6', '2015-08-13 02:30:07');
INSERT INTO visit_log VALUES ('79', 'admin', '4', '2015-08-13 02:30:19');
INSERT INTO visit_log VALUES ('80', 'admin', '4', '2015-08-13 02:30:22');
INSERT INTO visit_log VALUES ('81', '', '3', '2015-08-13 09:49:30');
INSERT INTO visit_log VALUES ('82', '', '4', '2015-08-13 09:49:38');
INSERT INTO visit_log VALUES ('83', '', '4', '2015-08-13 09:54:07');
INSERT INTO visit_log VALUES ('84', '', '4', '2015-08-13 14:58:18');
INSERT INTO visit_log VALUES ('85', '', '7', '2015-08-13 15:00:09');
INSERT INTO visit_log VALUES ('86', '', '7', '2015-08-13 15:00:43');
INSERT INTO visit_log VALUES ('87', 'admin', '7', '2015-08-13 15:15:22');
INSERT INTO visit_log VALUES ('88', 'admin', '7', '2015-08-13 15:15:39');
INSERT INTO visit_log VALUES ('89', 'admin', '7', '2015-08-13 15:15:49');
INSERT INTO visit_log VALUES ('90', 'admin', '7', '2015-08-13 15:16:08');
INSERT INTO visit_log VALUES ('91', 'admin', '7', '2015-08-13 15:16:16');
INSERT INTO visit_log VALUES ('92', 'admin', '7', '2015-08-13 15:16:19');
INSERT INTO visit_log VALUES ('93', 'admin', '7', '2015-08-13 15:16:31');
INSERT INTO visit_log VALUES ('94', 'admin', '7', '2015-08-13 15:16:39');
INSERT INTO visit_log VALUES ('95', 'admin', '7', '2015-08-13 15:16:49');
INSERT INTO visit_log VALUES ('96', 'admin', '7', '2015-08-13 15:17:03');
INSERT INTO visit_log VALUES ('97', 'admin', '7', '2015-08-13 15:17:15');
INSERT INTO visit_log VALUES ('98', 'admin', '7', '2015-08-13 15:17:22');
INSERT INTO visit_log VALUES ('99', 'a', '8', '2015-08-13 15:24:06');
INSERT INTO visit_log VALUES ('100', 'a', '9', '2015-08-13 15:33:21');
INSERT INTO visit_log VALUES ('101', 'a', '9', '2015-08-13 15:33:32');
