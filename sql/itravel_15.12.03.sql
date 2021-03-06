/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : itravel

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-03 16:18:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_city
-- ----------------------------
DROP TABLE IF EXISTS `base_city`;
CREATE TABLE `base_city` (
  `id` varchar(32) NOT NULL,
  `name_zh` varchar(15) DEFAULT NULL,
  `name_en` varchar(20) DEFAULT NULL,
  `province_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `city_province_id` (`province_id`),
  CONSTRAINT `city_province_id` FOREIGN KEY (`province_id`) REFERENCES `base_province` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_city
-- ----------------------------
INSERT INTO `base_city` VALUES ('8aba9552511ee7b701511ee89b1a0000', '南京', 'NanJing', '8aba9552511dd0a301511dd380230000');
INSERT INTO `base_city` VALUES ('8aba9552511ee7b701511eee2dd60001', '首尔', 'ShouEr', '8aba9552511dfa8801511dfb5d620000');
INSERT INTO `base_city` VALUES ('8aba9552511f986c01511f9e7ffa0002', '巴黎', 'BaLi', '8aba9552511e01c901511e052a2e0000');
INSERT INTO `base_city` VALUES ('8aba955251387f6401513880ce190000', '苏州', 'SuZhou', '8aba9552511dd0a301511dd380230000');

-- ----------------------------
-- Table structure for base_continent
-- ----------------------------
DROP TABLE IF EXISTS `base_continent`;
CREATE TABLE `base_continent` (
  `id` varchar(32) NOT NULL,
  `name_zh` varchar(15) DEFAULT NULL,
  `name_en` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_continent
-- ----------------------------
INSERT INTO `base_continent` VALUES ('1', '亚洲', 'Asia');
INSERT INTO `base_continent` VALUES ('8aba955250ffe7090150ffe8734a0002', '欧洲', 'Europe');
INSERT INTO `base_continent` VALUES ('8aba955250ffe7090150ffe93f2a0003', '非洲', 'Africa');
INSERT INTO `base_continent` VALUES ('8aba955250fff1cc0150fff2f1960000', '大洋洲', 'Oceania');
INSERT INTO `base_continent` VALUES ('8aba955250fff1cc0150fff30e870001', '北美洲', 'North America');
INSERT INTO `base_continent` VALUES ('8aba955250fff1cc0150fff32a780002', '南美洲', 'South America');
INSERT INTO `base_continent` VALUES ('8aba955250fff1cc0150fff34d930003', '南极洲', 'Antarctica');

-- ----------------------------
-- Table structure for base_country
-- ----------------------------
DROP TABLE IF EXISTS `base_country`;
CREATE TABLE `base_country` (
  `id` varchar(32) NOT NULL,
  `name_zh` varchar(15) DEFAULT NULL,
  `name_en` varchar(20) DEFAULT NULL,
  `city_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_city_id` (`city_id`),
  CONSTRAINT `country_city_id` FOREIGN KEY (`city_id`) REFERENCES `base_city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_country
-- ----------------------------
INSERT INTO `base_country` VALUES ('8aba9552511ee7b701511f0a583f0002', '溧水', 'LiShui', '8aba9552511ee7b701511ee89b1a0000');

-- ----------------------------
-- Table structure for base_dicionary
-- ----------------------------
DROP TABLE IF EXISTS `base_dicionary`;
CREATE TABLE `base_dicionary` (
  `id` varchar(32) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  `value` int(3) DEFAULT NULL,
  `label` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_dicionary
-- ----------------------------
INSERT INTO `base_dicionary` VALUES ('12312313', 'travel_route_status', '0', '热卖', '旅游线路状态');
INSERT INTO `base_dicionary` VALUES ('123123132323', 'travel_route_status', '1', '最新', '旅游线路状态');
INSERT INTO `base_dicionary` VALUES ('8aba95525132618501513263c4fc0000', 'tourism_types', '0', '境内游玩', '旅游线路类型');
INSERT INTO `base_dicionary` VALUES ('8aba955251326185015132645c440001', 'tourism_types', '1', '境外游玩', '旅游线路类型');
INSERT INTO `base_dicionary` VALUES ('8aba95525132618501513267542c0002', 'travel_theme', '0', '全家游', '旅游主题');
INSERT INTO `base_dicionary` VALUES ('8aba95525132618501513267ae9f0003', 'travel_theme', '1', '亲子游', '旅游主题');
INSERT INTO `base_dicionary` VALUES ('8aba9552513261850151326865810004', 'travel_theme', '2', '蜜月游', '旅游主题');
INSERT INTO `base_dicionary` VALUES ('8aba95525132618501513268a09c0005', 'travel_theme', '3', '情侣游', '旅游主题');
INSERT INTO `base_dicionary` VALUES ('8aba95525132618501513268eb490006', 'travel_theme', '4', '老年', '旅游主题');
INSERT INTO `base_dicionary` VALUES ('8aba955251326185015132690e200007', 'travel_theme', '5', '购物', '旅游主题');
INSERT INTO `base_dicionary` VALUES ('8aba955251326185015132693f4a0008', 'travel_theme', '6', '亲近自然', '旅游主题');
INSERT INTO `base_dicionary` VALUES ('8aba955251566a7f0151566b2ede0000', '2', '0', '2', '2');
INSERT INTO `base_dicionary` VALUES ('d3d32d3', 'hide', '0', '显示', '是否隐藏');
INSERT INTO `base_dicionary` VALUES ('d3d32d3dwq3fd3', 'hide', '1', '隐藏', '是否隐藏');

-- ----------------------------
-- Table structure for base_nation
-- ----------------------------
DROP TABLE IF EXISTS `base_nation`;
CREATE TABLE `base_nation` (
  `id` varchar(32) NOT NULL,
  `name_zh` varchar(15) DEFAULT NULL,
  `name_en` varchar(20) DEFAULT NULL,
  `delta_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `state_delta_id` (`delta_id`),
  CONSTRAINT `state_delta_id` FOREIGN KEY (`delta_id`) REFERENCES `base_continent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_nation
-- ----------------------------
INSERT INTO `base_nation` VALUES ('8aba9552510ef58d01510ef6ed200000', '英国', 'England', '8aba955250ffe7090150ffe8734a0002');
INSERT INTO `base_nation` VALUES ('8aba9552510f181601510f1aebb80000', '中国', 'China', '1');
INSERT INTO `base_nation` VALUES ('8aba9552511843910151184c977d0001', '法国', 'France', '8aba955250ffe7090150ffe8734a0002');
INSERT INTO `base_nation` VALUES ('8aba9552511843910151184ce2450002', '韩国', '思密达', '1');
INSERT INTO `base_nation` VALUES ('8aba9552511843910151184d0b9a0003', '日本', '雅蠛蝶', '1');
INSERT INTO `base_nation` VALUES ('8aba9552511843910151184d6b380004', '美国', 'America', '8aba955250fff1cc0150fff32a780002');

-- ----------------------------
-- Table structure for base_place_of_start
-- ----------------------------
DROP TABLE IF EXISTS `base_place_of_start`;
CREATE TABLE `base_place_of_start` (
  `id` varchar(32) NOT NULL,
  `city_id` varchar(32) DEFAULT NULL,
  `name_zh` varchar(15) DEFAULT NULL,
  `name_en` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `placeofstart_city_id` (`city_id`),
  CONSTRAINT `placeofstart_city_id` FOREIGN KEY (`city_id`) REFERENCES `base_city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_place_of_start
-- ----------------------------
INSERT INTO `base_place_of_start` VALUES ('1', '8aba9552511ee7b701511ee89b1a0000', '南京', 'NanJing');
INSERT INTO `base_place_of_start` VALUES ('2', '8aba9552511ee7b701511eee2dd60001', '首尔', 'ShouEr');
INSERT INTO `base_place_of_start` VALUES ('3', '8aba9552511f986c01511f9e7ffa0002', '巴黎', 'BaLi');
INSERT INTO `base_place_of_start` VALUES ('8aba955251388a2c0151388a67a60000', '8aba955251387f6401513880ce190000', '苏州', 'SuZhou');

-- ----------------------------
-- Table structure for base_province
-- ----------------------------
DROP TABLE IF EXISTS `base_province`;
CREATE TABLE `base_province` (
  `id` varchar(32) NOT NULL,
  `name_zh` varchar(15) DEFAULT NULL,
  `name_en` varchar(20) DEFAULT NULL,
  `state_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `province_state_id` (`state_id`),
  CONSTRAINT `province_state_id` FOREIGN KEY (`state_id`) REFERENCES `base_nation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_province
-- ----------------------------
INSERT INTO `base_province` VALUES ('8aba9552511dd0a301511dd380230000', '江苏', 'JiangSu', '8aba9552510f181601510f1aebb80000');
INSERT INTO `base_province` VALUES ('8aba9552511dfa8801511dfb5d620000', '某省会', 'OneProvince', '8aba9552511843910151184ce2450002');
INSERT INTO `base_province` VALUES ('8aba9552511e01c901511e052a2e0000', '某省会', 'OneProvince', '8aba9552511843910151184c977d0001');

-- ----------------------------
-- Table structure for base_scenic_spots
-- ----------------------------
DROP TABLE IF EXISTS `base_scenic_spots`;
CREATE TABLE `base_scenic_spots` (
  `id` varchar(32) NOT NULL,
  `city_id` varchar(32) DEFAULT NULL,
  `name_zh` varchar(10) DEFAULT NULL,
  `hide` varchar(1) DEFAULT NULL COMMENT '是否隐藏',
  `for_people` varchar(100) DEFAULT NULL COMMENT '适宜人群（数组信息，最多50条信息）',
  `type` varchar(100) DEFAULT NULL COMMENT '景点类型（数组信息，最多有50条状态信息）',
  `country_id` varchar(32) DEFAULT NULL,
  `place` varchar(100) DEFAULT NULL COMMENT '景区地址',
  `imgUrl` varchar(999) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  PRIMARY KEY (`id`),
  KEY `scenic_spots_city_id` (`city_id`),
  KEY `scenic_spots_country_id` (`country_id`),
  CONSTRAINT `scenic_spots_city_id` FOREIGN KEY (`city_id`) REFERENCES `base_city` (`id`),
  CONSTRAINT `scenic_spots_country_id` FOREIGN KEY (`country_id`) REFERENCES `base_country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_scenic_spots
-- ----------------------------
INSERT INTO `base_scenic_spots` VALUES ('8aba9552511f77f601511f85f2b70000', '8aba9552511ee7b701511ee89b1a0000', '中山陵', '0', '老人和小孩', '绿色景区、青山绿水', null, '南京市中山陵风景区', null, '中山陵风景区');
INSERT INTO `base_scenic_spots` VALUES ('8aba9552511f986c01511f9b55850000', '8aba9552511ee7b701511ee89b1a0000', '海底世界', '1', '小孩、青年人', '水下世界', null, '南京市海底世界风景区', null, '海底世界大观园');
INSERT INTO `base_scenic_spots` VALUES ('8aba9552511f986c01511f9db6000001', '8aba9552511ee7b701511eee2dd60001', '逛逛街', '1', '时尚达人', '购物', null, '韩国首尔市中心', null, '韩国首尔时尚购物中心');
INSERT INTO `base_scenic_spots` VALUES ('8aba9552511f986c01511f9f4cda0003', '8aba9552511f986c01511f9e7ffa0002', '巴黎圣母院', '1', '所有人', '名胜古迹', null, '法国巴黎', null, '法国巴黎圣母院大教堂');

-- ----------------------------
-- Table structure for base_travel_type
-- ----------------------------
DROP TABLE IF EXISTS `base_travel_type`;
CREATE TABLE `base_travel_type` (
  `id` varchar(32) NOT NULL,
  `name_zh` varchar(10) DEFAULT NULL,
  `name_en` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_travel_type
-- ----------------------------
INSERT INTO `base_travel_type` VALUES ('8aba9552513323c20151332ae5d90000', '2', '2');

-- ----------------------------
-- Table structure for bk_account
-- ----------------------------
DROP TABLE IF EXISTS `bk_account`;
CREATE TABLE `bk_account` (
  `id` varchar(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bk_account
-- ----------------------------
INSERT INTO `bk_account` VALUES ('123', 'test', '5a2e54ee57e5b7273b9a8fed78c1ebd8');

-- ----------------------------
-- Table structure for bk_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `bk_userinfo`;
CREATE TABLE `bk_userinfo` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `age` int(200) NOT NULL,
  `birthday` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `card` varchar(20) NOT NULL,
  `accountId` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userinfo_accounid` (`accountId`) USING BTREE,
  CONSTRAINT `bk_userinfo_ibfk_1` FOREIGN KEY (`accountId`) REFERENCES `bk_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bk_userinfo
-- ----------------------------
INSERT INTO `bk_userinfo` VALUES ('123', '3', '3', '3', '2015-11-17 16:21:56', '3123', '123');
INSERT INTO `bk_userinfo` VALUES ('8aba9552511d73fb01511d73febd0000', 'kkkk', '男', '20', '2015-11-24 15:18:33', '211212121212', '123');
INSERT INTO `bk_userinfo` VALUES ('8aba9552511d7f8401511d7f87e60000', 'user', '男', '20', '2015-11-19 10:07:56', '211212121212', null);
INSERT INTO `bk_userinfo` VALUES ('8aba9552511d81bd01511d81c1060000', 'user', '男', '20', '2015-11-19 10:10:22', '211212121212', null);
INSERT INTO `bk_userinfo` VALUES ('8aba9552511d834a01511d834e7d0000', 'user', '男', '20', '2015-11-19 10:12:03', '211212121212', null);

-- ----------------------------
-- Table structure for travel_route
-- ----------------------------
DROP TABLE IF EXISTS `travel_route`;
CREATE TABLE `travel_route` (
  `id` varchar(32) NOT NULL,
  `title` varchar(100) DEFAULT NULL COMMENT '旅游线路标题',
  `subtitle` varchar(100) DEFAULT NULL COMMENT '旅游线路副标题',
  `hide` varchar(1) DEFAULT NULL COMMENT '是否隐藏',
  `status` varchar(100) DEFAULT NULL COMMENT '旅游线路状态（数组信息，最多有50条状态信息）',
  `travel_type` varchar(32) DEFAULT NULL COMMENT '旅游线路类型',
  `theme` varchar(100) DEFAULT NULL COMMENT '旅游线主题（数组信息集合，最多50个信息）',
  `adult_price` double(8,2) DEFAULT NULL COMMENT '成人现价',
  `children_price` double(8,2) DEFAULT NULL COMMENT '儿童现价',
  `adult_original_price` double(8,2) DEFAULT NULL COMMENT '成人原价',
  `children_original_price` double(8,2) DEFAULT NULL COMMENT '儿童原价',
  `discount` double(5,1) DEFAULT NULL COMMENT '折扣',
  `days` int(3) DEFAULT NULL COMMENT '旅游总天数',
  `place_of_start` varchar(320) DEFAULT NULL COMMENT '出发地址',
  `recommend` varchar(500) DEFAULT NULL COMMENT '推荐理由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of travel_route
-- ----------------------------
INSERT INTO `travel_route` VALUES ('8aba95525136e032015136e088a40000', '云南七日游', '云南七日游', '0', '0,1', '0', '0,1,6', '7000.00', '5000.00', '7000.00', '5000.00', '9.5', null, '1,8aba955251388a2c0151388a67a60000', null);
INSERT INTO `travel_route` VALUES ('8aba95525136ff670151370c71d70000', '海南度假游', '海南度假游', '1', '0,1', '0', '1,3', '8000.00', '7000.00', '8000.00', '7000.00', '9.8', null, '1,2', null);
INSERT INTO `travel_route` VALUES ('8aba95525137f0f8015137f383400001', '泰国7日游', '泰国7日游', '0', '0,1', '1', '0,5,6', '3200.00', '1500.00', '3200.00', '1500.00', '9.5', null, '2,3', null);

-- ----------------------------
-- Table structure for travel_route_detail
-- ----------------------------
DROP TABLE IF EXISTS `travel_route_detail`;
CREATE TABLE `travel_route_detail` (
  `id` varchar(32) NOT NULL,
  `travel_route_id` varchar(32) DEFAULT NULL,
  `day` int(3) DEFAULT NULL COMMENT '第几天',
  `serial_number` int(2) DEFAULT NULL COMMENT '当前景点顺序号',
  `scenic_spot_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `travel_route_detail_travel_route_id` (`travel_route_id`),
  KEY `travel_route_detail_scenic_spot_id` (`scenic_spot_id`),
  CONSTRAINT `travel_route_detail_scenic_spot_id` FOREIGN KEY (`scenic_spot_id`) REFERENCES `base_scenic_spots` (`id`),
  CONSTRAINT `travel_route_detail_travel_route_id` FOREIGN KEY (`travel_route_id`) REFERENCES `travel_route` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of travel_route_detail
-- ----------------------------

-- ----------------------------
-- Table structure for travel_route_img
-- ----------------------------
DROP TABLE IF EXISTS `travel_route_img`;
CREATE TABLE `travel_route_img` (
  `id` varchar(32) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  `travel_route_id` varchar(32) DEFAULT NULL,
  `size` double(8,2) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `travel_img_travel_route_id` (`travel_route_id`),
  CONSTRAINT `travel_img_travel_route_id` FOREIGN KEY (`travel_route_id`) REFERENCES `travel_route` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of travel_route_img
-- ----------------------------
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c60151466033cc0000', '/file/img/20151127/74D2BD5A5D4D47468D236D9C7597FF51.jpg', '8aba95525136e032015136e088a40000', '0.02', '74D2BD5A5D4D47468D236D9C7597FF51');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c60151466034e20001', '/file/img/20151127/D071A193B68443E9A5370113C369C7C9.gif', '8aba95525136e032015136e088a40000', '0.71', 'D071A193B68443E9A5370113C369C7C9');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c601514660351b0002', '/file/img/20151127/6FE4BB2DB3844E7CAAB2574FC744530A.jpg', '8aba95525136e032015136e088a40000', '0.02', '6FE4BB2DB3844E7CAAB2574FC744530A');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c60151468402470003', '/file/img/20151127/B652A6A9F74D4012A9E89F23AB626313.jpg', '8aba95525136ff670151370c71d70000', '0.02', 'B652A6A9F74D4012A9E89F23AB626313');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c60151468402d50004', '/file/img/20151127/92532C90B16C4987B76132C0CF22DCDD.gif', '8aba95525136ff670151370c71d70000', '0.71', '92532C90B16C4987B76132C0CF22DCDD');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c60151468403260005', '/file/img/20151127/2FF7653819544BD6AC0A5FC74A7EC861.jpg', '8aba95525136ff670151370c71d70000', '0.02', '2FF7653819544BD6AC0A5FC74A7EC861');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c601514685af870006', '/file/img/20151127/949D3645ABAF4AF19B358529A9D8C8CC.jpg', '8aba95525136ff670151370c71d70000', '0.02', '949D3645ABAF4AF19B358529A9D8C8CC');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c601514685aff60007', '/file/img/20151127/9B01303175674FD9ACA4ABB32D7075A1.gif', '8aba95525136ff670151370c71d70000', '0.71', '9B01303175674FD9ACA4ABB32D7075A1');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c601514685b0410008', '/file/img/20151127/72E28A82505B4047AB4D77BCB2602FBE.jpg', '8aba95525136ff670151370c71d70000', '0.02', '72E28A82505B4047AB4D77BCB2602FBE');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c601514685d5eb0009', '/file/img/20151127/4CD43308B7124352AFE6195A99D9A6C5.jpg', '8aba95525136ff670151370c71d70000', '0.02', '4CD43308B7124352AFE6195A99D9A6C5');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c601514685d645000a', '/file/img/20151127/33504B3F0E334F26B29E18FB1AF198C0.gif', '8aba95525136ff670151370c71d70000', '0.71', '33504B3F0E334F26B29E18FB1AF198C0');
INSERT INTO `travel_route_img` VALUES ('8aba9552514655c601514685d675000b', '/file/img/20151127/0DCD87847C8C4162ADAE3709D1E9CAEF.jpg', '8aba95525136ff670151370c71d70000', '0.02', '0DCD87847C8C4162ADAE3709D1E9CAEF');
INSERT INTO `travel_route_img` VALUES ('8aba95525156018a0151560d2c5e0000', '/file/img/20151130/54FB653C2C214D568D764E6B6A2C9DB3.bmp', '8aba95525136e032015136e088a40000', '4.32', '54FB653C2C214D568D764E6B6A2C9DB3');
