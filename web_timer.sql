/*
Navicat MySQL Data Transfer

Source Server         : localtion - test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : web_timer

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-29 15:56:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `web_timer_task`
-- ----------------------------
DROP TABLE IF EXISTS `web_timer_task`;
CREATE TABLE `web_timer_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '定时任务表',
  `name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '定时任务名称',
  `description` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '定时任务描述',
  `cron` varchar(255) DEFAULT NULL COMMENT '时间表达式',
  `timeout` int(11) DEFAULT NULL COMMENT '任务执行超时时间，如果超时，则自动失败,单位 秒',
  `http_api_url` varchar(255) DEFAULT NULL COMMENT 'http api 请求地址',
  `type_id` tinyint(4) DEFAULT NULL COMMENT '定时任务类型，1、以httpclient 请求接口',
  `last_execute_timer` datetime DEFAULT NULL COMMENT '最后一次执行时间',
  `last_result` tinyint(4) DEFAULT NULL COMMENT '最后一次执行结果，成功，失败，还是超时',
  `concurrent` tinyint(4) DEFAULT NULL COMMENT '上次任务没有执行完是否启动下次任务执行1，是，2否',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态，1、已启动，2、未启动，3、删除',
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_timer_task
-- ----------------------------

-- ----------------------------
-- Table structure for `web_timer_task_result`
-- ----------------------------
DROP TABLE IF EXISTS `web_timer_task_result`;
CREATE TABLE `web_timer_task_result` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '定时任务执行结果表',
  `timer_task_id` bigint(20) DEFAULT NULL COMMENT '任务ID',
  `begin_time` datetime DEFAULT NULL COMMENT '执行开始时间',
  `end_timer` datetime DEFAULT NULL COMMENT '执行结束时间',
  `result_type` tinyint(4) DEFAULT NULL COMMENT '结果类型，1、成功，2、失败，3、超时',
  `result` varchar(1000) DEFAULT NULL COMMENT '返回结果,1000字符以内',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_timer_task_result
-- ----------------------------
