/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jsk

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-20 17:51:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `courseid` varchar(20) NOT NULL,
  `coursenane` varchar(100) NOT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('C001', '大学语文');
INSERT INTO `courses` VALUES ('C002', '新视野英语');
INSERT INTO `courses` VALUES ('C003', '离散数学');
INSERT INTO `courses` VALUES ('C004', '概率论与数理统计');
INSERT INTO `courses` VALUES ('C005', '线性代数');
INSERT INTO `courses` VALUES ('C006', '高等数学(一)');
INSERT INTO `courses` VALUES ('C007', '高等数学(二)');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `studentid` varchar(16) NOT NULL,
  `courseid` varchar(20) NOT NULL,
  `scores` float DEFAULT NULL,
  PRIMARY KEY (`studentid`,`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1001', 'C001', '67');
INSERT INTO `score` VALUES ('1001', 'C002', '87');
INSERT INTO `score` VALUES ('1001', 'C003', '83');
INSERT INTO `score` VALUES ('1001', 'C004', '88');
INSERT INTO `score` VALUES ('1001', 'C005', '77');
INSERT INTO `score` VALUES ('1002', 'C001', '68');
INSERT INTO `score` VALUES ('1002', 'C002', '88');
INSERT INTO `score` VALUES ('1002', 'C003', '84');
INSERT INTO `score` VALUES ('1002', 'C004', '89');
INSERT INTO `score` VALUES ('1002', 'C005', '78');
INSERT INTO `score` VALUES ('1003', 'C001', '69');
INSERT INTO `score` VALUES ('1003', 'C002', '89');
INSERT INTO `score` VALUES ('1003', 'C003', '85');
INSERT INTO `score` VALUES ('1003', 'C004', '90');
INSERT INTO `score` VALUES ('1003', 'C005', '79');
INSERT INTO `score` VALUES ('1004', 'C001', '70');
INSERT INTO `score` VALUES ('1004', 'C002', '90');
INSERT INTO `score` VALUES ('1004', 'C003', '86');
INSERT INTO `score` VALUES ('1004', 'C004', '91');
INSERT INTO `score` VALUES ('1005', 'C001', '71');
INSERT INTO `score` VALUES ('1005', 'C002', '91');
INSERT INTO `score` VALUES ('1005', 'C003', '87');
INSERT INTO `score` VALUES ('1005', 'C004', '92');
INSERT INTO `score` VALUES ('1006', 'C001', '72');
INSERT INTO `score` VALUES ('1006', 'C002', '92');
INSERT INTO `score` VALUES ('1006', 'C003', '88');
INSERT INTO `score` VALUES ('1006', 'C004', '93');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentid` varchar(32) NOT NULL COMMENT '学号',
  `studentname` varchar(64) NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1001', '张三');
INSERT INTO `student` VALUES ('1002', '李四');
INSERT INTO `student` VALUES ('1003', '赵二');
INSERT INTO `student` VALUES ('1004', '王五');
INSERT INTO `student` VALUES ('1005', '刘青');
INSERT INTO `student` VALUES ('1006', '周明');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(64) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `group` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'name1', '1', '1', '1');
INSERT INTO `user` VALUES ('2', 'name2', '2', '2', '1');
INSERT INTO `user` VALUES ('3', 'name3', '3', '3', '2');
INSERT INTO `user` VALUES ('4', 'name4', '4', '4', '2');

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '	自增序列',
  `email` varchar(32) NOT NULL COMMENT '登录账号',
  `tokenvalue` varchar(64) DEFAULT NULL COMMENT 'TOKEN的值',
  `isEnable` tinyint(1) DEFAULT '0' COMMENT '是否启用 0表示不启用，1表示启用',
  `tokencreatetime` varchar(21) DEFAULT NULL COMMENT 'postgresql 精确到SSS毫秒',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_token
-- ----------------------------
