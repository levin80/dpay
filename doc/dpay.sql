/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50627
Source Host           : 127.0.0.1:3306
Source Database       : dpay

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2017-05-25 01:23:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hb_account
-- ----------------------------
DROP TABLE IF EXISTS `hb_account`;
CREATE TABLE `hb_account` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCID` varchar(32) NOT NULL COMMENT '账户ID的生成规则为:2位（表示中国移动山西发行的标志）＋8位机构编码＋4位的年月（YYMM）+6位的序列号（这个序列由SEQ_ACCOUT_SN产生）\r\n            \r\n            ',
  `STATUS` char(1) DEFAULT NULL,
  `PASSWD` varchar(32) DEFAULT NULL COMMENT '目前规定只使用6位',
  `CREATETIME` datetime DEFAULT NULL,
  `CANCELTIME` datetime DEFAULT NULL,
  `MODIFYTIME` datetime DEFAULT NULL,
  `TRAN_PASSWD` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=270 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_account
-- ----------------------------
INSERT INTO `hb_account` VALUES ('269', '5b521e3da5a740c98cda9137a7770676', '0', 'E10ADC3949BA59ABBE56E057F20F883E', '2016-07-24 17:18:38', null, null, 'E10ADC3949BA59ABBE56E057F20F883E');

-- ----------------------------
-- Table structure for hb_acc_cash
-- ----------------------------
DROP TABLE IF EXISTS `hb_acc_cash`;
CREATE TABLE `hb_acc_cash` (
  `CASH_ACCID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCID` varchar(32) DEFAULT NULL,
  `STATUS` char(1) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `MODIFYTIME` datetime DEFAULT NULL,
  `CASH` int(12) DEFAULT '0',
  PRIMARY KEY (`CASH_ACCID`)
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_acc_cash
-- ----------------------------
INSERT INTO `hb_acc_cash` VALUES ('226', '5b521e3da5a740c98cda9137a7770676', '0', '2016-07-24 17:18:38', null, '3605');

-- ----------------------------
-- Table structure for hb_acc_charge
-- ----------------------------
DROP TABLE IF EXISTS `hb_acc_charge`;
CREATE TABLE `hb_acc_charge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` varchar(32) DEFAULT NULL,
  `cash` int(12) DEFAULT NULL,
  `chargeCash` int(12) DEFAULT NULL,
  `chargeTime` datetime DEFAULT NULL,
  `describ` varchar(1000) DEFAULT NULL,
  `accountsonid` varchar(32) DEFAULT NULL,
  `chargetype` char(2) DEFAULT NULL,
  `createperson` varchar(32) DEFAULT NULL,
  `chargestatus` int(2) DEFAULT '0' COMMENT '充值状态，0：等待充值 1：充值成功',
  `FLOWID` varchar(32) DEFAULT NULL,
  `FLOWIDOLD` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_acc_charge
-- ----------------------------

-- ----------------------------
-- Table structure for hb_acc_charge_record
-- ----------------------------
DROP TABLE IF EXISTS `hb_acc_charge_record`;
CREATE TABLE `hb_acc_charge_record` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CHARGE_NO` varchar(19) DEFAULT NULL COMMENT '交易流水（年月日时分秒14位+5位随机码）',
  `ACCOUNT_ID1` varchar(32) DEFAULT NULL COMMENT '账户ID',
  `ACCOUNT_ID2` varchar(32) DEFAULT NULL,
  `ACCOUT_TYPE` varchar(10) DEFAULT NULL COMMENT '账本类型：CASH-现金账本，FAVOUR-优惠账本',
  `BALANCE` int(10) DEFAULT NULL COMMENT '账户余额',
  `TYPE` int(2) DEFAULT NULL COMMENT '类型：1-充值、2-扣费，3-冲正',
  `FEE` int(10) DEFAULT NULL COMMENT '金额（分）',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MEMO` varchar(255) DEFAULT NULL COMMENT '备注',
  `CHARGEWAY` varchar(2) DEFAULT NULL COMMENT '记录方式，1-在线支付，2-预存款支付，3-portal充值',
  `USER_ID1` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `USER_ID2` varchar(32) DEFAULT NULL,
  `ORIGIN_NO` decimal(19,0) DEFAULT NULL COMMENT '原交易流水',
  `CHARGESTATE` int(2) DEFAULT '0' COMMENT '充值状态 0：等待充值，1：充值成功',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `OP_USER` varchar(255) DEFAULT NULL COMMENT '操作员',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_acc_charge_record
-- ----------------------------
INSERT INTO `hb_acc_charge_record` VALUES ('170', '201608070944136957', '99edcecdaeff4dbca0bbf27a83f910bf', null, 'CASH', '24645', '1', '10000', '2016-08-07 09:44:14', '前台用户充值', '3', '2970d885c74e4367a4ab824149e3427e', null, null, null, 'levin@126.com', '华胜天成', '550d4e6b7b284e3c8f8a8dead285da3a');

-- ----------------------------
-- Table structure for hb_acc_favour
-- ----------------------------
DROP TABLE IF EXISTS `hb_acc_favour`;
CREATE TABLE `hb_acc_favour` (
  `CASH_FAVOUR_ACCID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCID` varchar(32) DEFAULT NULL,
  `STATUS` char(1) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `MODIFYTIME` datetime DEFAULT NULL,
  `CASH` int(11) DEFAULT '0',
  PRIMARY KEY (`CASH_FAVOUR_ACCID`)
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_acc_favour
-- ----------------------------
INSERT INTO `hb_acc_favour` VALUES ('226', '5b521e3da5a740c98cda9137a7770676', '0', null, null, '86515');

-- ----------------------------
-- Table structure for hb_acc_status
-- ----------------------------
DROP TABLE IF EXISTS `hb_acc_status`;
CREATE TABLE `hb_acc_status` (
  `STATUS` char(1) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `FLAG` char(1) DEFAULT NULL COMMENT '0－正常状态 1－无效状态',
  PRIMARY KEY (`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_acc_status
-- ----------------------------

-- ----------------------------
-- Table structure for hb_customer
-- ----------------------------
DROP TABLE IF EXISTS `hb_customer`;
CREATE TABLE `hb_customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_ID` varchar(32) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `TYPE` char(1) DEFAULT NULL COMMENT '1-主办方，2-参展商，3-场地提供方，4-服务提供方，5-观众',
  `SEX` char(1) DEFAULT NULL,
  `PROFESSION` varchar(100) DEFAULT NULL,
  `CREDENTIALS_TYPE` varchar(11) DEFAULT NULL COMMENT '证件类型',
  `CREDENTIALS_NUMBER` varchar(200) DEFAULT NULL COMMENT '证件编号',
  `EMAIL` varchar(100) DEFAULT NULL,
  `WORK_NATURE` varchar(200) DEFAULT NULL,
  `WORK_UNIT` varchar(20) DEFAULT NULL,
  `POSITION` varchar(1000) DEFAULT NULL,
  `LP_ORG_NAME` varchar(2000) DEFAULT NULL,
  `CONTACT` varchar(300) DEFAULT NULL,
  `LP_ORG_NATURE` varchar(200) DEFAULT NULL,
  `CREDIBILITY` varchar(11) DEFAULT NULL,
  `LEVEL` varchar(11) DEFAULT NULL COMMENT '级别',
  `STATUS` varchar(11) DEFAULT NULL COMMENT '状态',
  `ADDRESS` varchar(100) DEFAULT NULL COMMENT '地址',
  `MOBILE_PHONE` varchar(100) DEFAULT NULL COMMENT '手机号',
  `LANDLINE_PHONE` varchar(100) DEFAULT NULL COMMENT '座机',
  `POST_CODE` varchar(50) DEFAULT NULL COMMENT '邮编',
  `CREATE_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `PROVINCE` varchar(20) DEFAULT NULL COMMENT '省份编号',
  `CITY` varchar(20) DEFAULT NULL,
  `COUNTY` varchar(20) DEFAULT NULL,
  `BIRTH_DATE` datetime DEFAULT NULL COMMENT '出生日期',
  `TRADE` varchar(20) DEFAULT NULL COMMENT '所属行业',
  `ENTERPRISE_SCALE` varchar(20) DEFAULT NULL COMMENT '企业规模',
  `ORG_CODE` varchar(32) DEFAULT NULL COMMENT '组织机构代码 ',
  `BUSINESS_LICENSE_ADDR` varchar(200) DEFAULT NULL COMMENT '营业执照地址',
  `COM_IMGS` varchar(200) DEFAULT NULL COMMENT '企业LOGO',
  `COM_DESC` varchar(200) DEFAULT NULL COMMENT '公司概述',
  `COM_FAX` varchar(100) DEFAULT NULL,
  `COM_WEBSITE` varchar(100) DEFAULT NULL,
  `COM_LOCATION` varchar(100) DEFAULT NULL,
  `THUMBNAIL_IMG` varchar(100) DEFAULT NULL COMMENT '缩略图地址',
  `INFO_REVIEW_STATE` tinyint(2) DEFAULT '0' COMMENT '公司信息审核状态，0：初始化，1：待审核，2：审核通过，3：审核拒绝',
  `GENERAL_REVIEW_STATE` tinyint(2) DEFAULT '0' COMMENT '全景申请状态：  0-未申请 ，1-审核中，2-通过-全景制作中，3-拒绝，4-全景已生成',
  `INFO_REVIEW_OPINION` varchar(100) DEFAULT NULL COMMENT '审核意见',
  `INFO_REVIEW_USER_ID` varchar(100) DEFAULT NULL COMMENT '审核人ID',
  `GENERAL_REVIEW_OPTION` varchar(100) DEFAULT NULL COMMENT '审核意见',
  `GENERAL_REVIEW_USER_ID` varchar(100) DEFAULT NULL COMMENT '审核ID',
  `PANO_URL` varchar(255) DEFAULT NULL COMMENT '全景展示URL',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_customer
-- ----------------------------

-- ----------------------------
-- Table structure for hb_order
-- ----------------------------
DROP TABLE IF EXISTS `hb_order`;
CREATE TABLE `hb_order` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `ORDER_ID` varchar(19) DEFAULT NULL COMMENT '订单号：订单号规则：订单生成日期14位+5位数，递增',
  `SKU_ID` int(11) DEFAULT NULL COMMENT 'skuid',
  `SKU_NAME` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `PHONE` varchar(60) DEFAULT NULL COMMENT '联系电话',
  `FEE` int(10) DEFAULT NULL COMMENT '订单价格',
  `COST` int(10) DEFAULT NULL COMMENT '成本',
  `PROFITS` int(10) DEFAULT NULL COMMENT '利润',
  `PAYMENT` int(1) DEFAULT NULL COMMENT '支付方式：1: 在线支付；2: 账户支付',
  `PAY_PLATFORM` int(2) DEFAULT NULL COMMENT '支付平台：1: 工商银行; 2: 建设银行; 3: 招商银行',
  `IS_PAID` int(1) DEFAULT NULL COMMENT '未付款(待付款)=0;已付款(付款成功)=1;已付款(付款失败)=2;待退款=3;退款成功=4;退款失败=5;撤销成功=6;撤销失败=7;关闭=8;',
  `STATE` int(2) DEFAULT NULL COMMENT '订单状态。0：无效订单  1：创建订单，未支付 2：已发起支付 、支付成功  3:已发起支付 、支付失败 4:已发货 5:已收货 6:已失效 7:买家已评价 详见HbOrderConstants.OrderStateConstant',
  `PAYMENT_NO` varchar(30) DEFAULT NULL COMMENT '支付号',
  `ORDER_TIME` datetime DEFAULT NULL COMMENT '下单时间',
  `PAY_TIME` datetime DEFAULT NULL COMMENT '付款时间',
  `DEPOSIT_TIME` datetime DEFAULT NULL COMMENT '到帐时间',
  `SUCCESS_TIME` datetime DEFAULT NULL COMMENT '成功时间',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='订单。包括实体商品和虚拟商品的订单';

-- ----------------------------
-- Records of hb_order
-- ----------------------------
INSERT INTO `hb_order` VALUES ('4', '2016080807201803222', '3006', '移动全国2G', '13803450916', '7000', '7000', '0', null, '1', '1', '12', null, '2016-08-08 07:20:19', null, null, null, '550d4e6b7b284e3c8f8a8dead285da3a');
INSERT INTO `hb_order` VALUES ('5', '2017052500515703235', '3004', '移动全国500M', '13503515489', '3000', '240000', '-237000', null, '1', '1', '12', null, '2017-05-25 00:51:57', null, null, null, '550d4e6b7b284e3c8f8a8dead285da3a');

-- ----------------------------
-- Table structure for hb_permission
-- ----------------------------
DROP TABLE IF EXISTS `hb_permission`;
CREATE TABLE `hb_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
  `PERM_ID` varchar(32) NOT NULL COMMENT '权限主键',
  `PERM_UPID` varchar(32) DEFAULT NULL,
  `PERM_TYPE` decimal(1,0) DEFAULT NULL,
  `PERM_NAME` varchar(100) DEFAULT NULL,
  `PERM_URL` varchar(100) DEFAULT NULL,
  `DEPENDENT_URL` text,
  `PERM_USE` decimal(1,0) DEFAULT NULL,
  `PERM_ORDER` decimal(11,0) DEFAULT NULL,
  `PERM_NOTE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_permission
-- ----------------------------
INSERT INTO `hb_permission` VALUES ('1', '0a78136780424943b5096b1755b84add', '0', null, '权限', '/clouds/console/permission/index.do', null, '1', null, '权限管理【后台】');
INSERT INTO `hb_permission` VALUES ('3', '466e3c5a972b49c2a6a5d2f05785eb75', '0a78136780424943b5096b1755b84add', null, '用户管理', '/clouds/console/permission/user/listUser.do', null, '1', null, '用户管理');
INSERT INTO `hb_permission` VALUES ('4', '12d67b67dbce468ab48f150bb7d5136c', '0a78136780424943b5096b1755b84add', null, '角色管理', '/clouds/console/permission/role/listRole.do', null, '1', null, '角色管理');
INSERT INTO `hb_permission` VALUES ('31', '52438bdce9c84845aee6084fedf87077', '0', null, '首页', '/clouds/console/main.do', null, '1', null, '首页【后台】');
INSERT INTO `hb_permission` VALUES ('37', '48e5575860cd4a01a1d021614cbcc1ae', '0a78136780424943b5096b1755b84add', null, '权限管理', '/clouds/console/permission/perm/listPerm.do', null, '1', null, '权限管理');
INSERT INTO `hb_permission` VALUES ('38', 'f6fd7280c0834fc89c8abfd7384c0a4b', '0', null, '栏目', '/clouds/console/pms/channel/channel_list.do', null, '1', null, '栏目管理【后台】');
INSERT INTO `hb_permission` VALUES ('39', '59583427b11c40b9bbf2390809b81a2f', '0', null, '内容', '/clouds/console/content/index.do', null, '1', null, '内容管理【后台】');
INSERT INTO `hb_permission` VALUES ('40', 'f58cca83d0c54fc982662d497a5ad5ec', '0', null, '审核', '/clouds/console/pms/review/index.do', null, '1', null, '审核管理【后台】');
INSERT INTO `hb_permission` VALUES ('41', '6a184fa1588c4239bd1f7f7cbb3b4266', '0', null, '模板', '/clouds/console/pms/template/index.do', null, '1', null, '模板管理【后台】');
INSERT INTO `hb_permission` VALUES ('46', '845799be2f9f4c92940f007068d77c3d', '0', null, '客户', '/clouds/console/customer/index.do', null, '1', null, '客户管理【后台】');
INSERT INTO `hb_permission` VALUES ('49', '938ddbe6f3fc488a93640c7d1319e2d3', '0', null, '系统', '/clouds/console/sys/index.do', null, '1', null, '系统管理【后台】');
INSERT INTO `hb_permission` VALUES ('50', 'c5a20d6565514f7599b8143ffd4cf429', '845799be2f9f4c92940f007068d77c3d', null, '客户管理', '/clouds/console/customer/ptlUserList.do', null, '1', null, '客户管理');
INSERT INTO `hb_permission` VALUES ('59', 'ae73706633f544708f33ceebf3d1231d', 'f58cca83d0c54fc982662d497a5ad5ec', null, '内容审核', '/clouds/console/pms/review/index.do', null, '1', null, '内容审核');
INSERT INTO `hb_permission` VALUES ('60', 'f7d05a5be51f4391804e7bd1dec84136', '59583427b11c40b9bbf2390809b81a2f', null, '内容类型管理', '/clouds/console/sys/contentType/list.do', null, '1', null, '内容类型管理');
INSERT INTO `hb_permission` VALUES ('61', '393e420d5b2f4cdea691c1ac93022d65', '938ddbe6f3fc488a93640c7d1319e2d3', null, '模型管理', '/clouds/console/sys/model/list.do', null, '1', null, '模型管理');
INSERT INTO `hb_permission` VALUES ('62', 'd2dcf098cf00409a995fe276fcad955e', '938ddbe6f3fc488a93640c7d1319e2d3', null, '全量发布', '/clouds/console/publish/index.do', null, '1', null, '全量发布');
INSERT INTO `hb_permission` VALUES ('64', 'c3481b1df62c48119cf18e2b7979d2dd', '0', null, '我的信息', '/user/manager', null, '1', null, '我的信息【前台】');
INSERT INTO `hb_permission` VALUES ('65', 'c280c11b17b2400085d1dfcb6d68e7b3', 'c3481b1df62c48119cf18e2b7979d2dd', null, '基本信息', '/user/userInfo.do', '/organ/updateBasicEx.do|/page/nsite/index.do', '1', null, '基本信息');
INSERT INTO `hb_permission` VALUES ('70', '6b49a35429b04756b12da2c7e74907d2', '0', null, '展会管理', '/organ/manager', '/organ/addExSucc.do|/organ/addExThree.do|/organ/publish/exhibInfo.do', '1', null, '展会管理【前台】');
INSERT INTO `hb_permission` VALUES ('71', 'bbaee3a8816441f2a05548fd0174d8ff', '6b49a35429b04756b12da2c7e74907d2', null, '展会发布', '/organ/addExFirst.do', '/user/getCityListByPid.do|/venue/venueCalendar.do|/organ/addExSecond.do|/venue/venueInfo.do|/image/uploadImage.do', '1', null, '展会发布');
INSERT INTO `hb_permission` VALUES ('72', 'd92b8385b1bb49328d92a7aa34dd02b9', '6b49a35429b04756b12da2c7e74907d2', null, '展会列表', '/organ/exList.do', '/organ/publish/exhibInfo.do|/organ/exDetail.do|/organ/preview/exhibInfo.do|/organ/exSelect.do|/organ/checkExhibVenueUse.do', '1', null, '展会列表');
INSERT INTO `hb_permission` VALUES ('73', '514976a0d3244c31ae7a4dafc2d0a716', '0', null, '展会场馆', '/venue/manager', null, '1', null, '展会场馆【前台】');
INSERT INTO `hb_permission` VALUES ('74', '75365387893a4b57ba123d39ea6f5395', '514976a0d3244c31ae7a4dafc2d0a716', null, '新增场馆', '/venue/jumpModifyVenue.do', '/venue/modifyVenue.do', '1', null, '新增场馆');
INSERT INTO `hb_permission` VALUES ('75', '6d0950c0dc71466cac09aa60401774a7', '514976a0d3244c31ae7a4dafc2d0a716', null, '场馆信息', '/venue/venue_list.do', '/venue/jumpModifyVenue.do|/venue/jumpModifyVenue.do|/venue/venueInfo.do|/venue/publish.do', '1', null, '场馆信息');
INSERT INTO `hb_permission` VALUES ('76', '85e8c90ab9e84914b6465506d4db0fbd', '0', null, '参展管理', '/organ/attendExhib', '/organ/initEx.do', '1', null, '参展【前台】');
INSERT INTO `hb_permission` VALUES ('77', 'd8856e5182634a25bbd9d0ab18ef6b43', '85e8c90ab9e84914b6465506d4db0fbd', null, '参展展会', '/organ/joinExhibList.do', '/organ/joinInExhib.do|/organ/checkJoinExhib.do|/organ/showExhibDetail.do|/organ/exDetail.do|/organ/exSelect.do', '1', null, '参展展会');
INSERT INTO `hb_permission` VALUES ('78', '2fcc9865c8c9478badeb6455df2a8270', '0', null, '合作伙伴管理', '/organ/manager_parnter', null, '1', null, '合作伙伴管理【前台】');
INSERT INTO `hb_permission` VALUES ('79', 'c8ead2a9f4bc4e84a40d86b0370fbdd4', '2fcc9865c8c9478badeb6455df2a8270', null, '参展商列表', '/organ/parnterListCz.do', '/organ/parnterList1.do', '1', null, '参展商列表');
INSERT INTO `hb_permission` VALUES ('80', '6c14666777f24b918d345c3ad51c0e35', '2fcc9865c8c9478badeb6455df2a8270', null, '服务商列表', '/organ/parnterListFw.do', '/organ/parnterList1.do|/organ/listTopParnter.do|/organ/parnterListCz.do|/organ/parnterUnPass.do|/organ/parnterPass.do', '1', null, '服务商列表');
INSERT INTO `hb_permission` VALUES ('91', 'f241a8da86624f09aa878d5073422c8d', '0', null, '门票管理', '/ticket/manager', null, '1', null, '门票管理【前台】');
INSERT INTO `hb_permission` VALUES ('92', '68014cba46824807be073d20f77a78f0', 'f241a8da86624f09aa878d5073422c8d', null, '我的门票', '/ticket/myTicket.do', null, '1', null, '我的门票');
INSERT INTO `hb_permission` VALUES ('93', 'a5aec5fa498545128d3f16959c34beec', 'f241a8da86624f09aa878d5073422c8d', null, '门票统计', '/ticket/exList.do', '/ticket/ticketCount.do', '1', null, '门票统计');
INSERT INTO `hb_permission` VALUES ('103', '6cc48f83476043c1957ad069078324cb', '0', null, '3d会展管理', '/clouds/console/3d', null, '1', null, '3d会展管理【后台】');
INSERT INTO `hb_permission` VALUES ('104', 'bfa83e5434cd454da13bb29deaab97d0', '6cc48f83476043c1957ad069078324cb', null, '行业类别管理', '/clouds/console/3d/category/index.do', '/clouds/console/3d/category/categoryList.do', '1', null, '');
INSERT INTO `hb_permission` VALUES ('107', '4c68671aead841c3b5da7dc36734d6d4', '6cc48f83476043c1957ad069078324cb', null, '三维馆管理', '/clouds/console/3d/venue/index.do', null, '1', null, '');
INSERT INTO `hb_permission` VALUES ('108', '625803d05cb44cfcbf522ced4e46dd16', '938ddbe6f3fc488a93640c7d1319e2d3', null, '站点管理', '/clouds/console/sys', null, '1', null, '');
INSERT INTO `hb_permission` VALUES ('109', 'f1090825284e468fa017a82c8dd0141c', '625803d05cb44cfcbf522ced4e46dd16', null, '基本信息', '/clouds/console/sys/getConfig.do', '/clouds/console/sys/editConfig.do', '1', null, '基本信息');
INSERT INTO `hb_permission` VALUES ('110', '14e6fe0c09704fa38f482ab27dae624f', '6b49a35429b04756b12da2c7e74907d2', null, '3D展会申请', '/portal/organ/threeExhibList.do', '/organ/updateEx.do', '1', null, '申请3D展会');
INSERT INTO `hb_permission` VALUES ('114', '9111af2595cb436fb3f798e7d38c3017', '6cc48f83476043c1957ad069078324cb', null, '三维馆申请记录', '/clouds/console/3d/venue/generalListReview.do', null, '1', null, '');
INSERT INTO `hb_permission` VALUES ('115', '6a1675c45d6a4183adae3b8dc99d67f3', '0', null, '帮助中心管理', '/clouds/console/help', null, '1', null, '帮助中心管理【后台】');
INSERT INTO `hb_permission` VALUES ('116', '65be3ea5b578423b8a0f7948fbd8a2b9', '6a1675c45d6a4183adae3b8dc99d67f3', null, '帮助分类管理', '/clouds/console/helpType/index.do', null, '1', null, '');
INSERT INTO `hb_permission` VALUES ('117', '0fda7209b978498c8b0a415a1be3557d', '6a1675c45d6a4183adae3b8dc99d67f3', null, '帮助内容管理', '/clouds/console/help/index.do', null, '1', null, '');
INSERT INTO `hb_permission` VALUES ('118', '5d009b2148e34fc6b232043ba67cef46', '0', null, '展会', '/clouds/console/exhibition/index.do', null, '1', null, '展会管理【后台】');
INSERT INTO `hb_permission` VALUES ('119', '61015832e509460c949b5025f95b89a8', '5d009b2148e34fc6b232043ba67cef46', null, '展会审核', '/clouds/console/exhibition/listReview.do', null, '1', null, '展会审核');
INSERT INTO `hb_permission` VALUES ('120', 'b297811c2d014a6eae0ec1de5f2a2495', '5d009b2148e34fc6b232043ba67cef46', null, '参展审核', '/clouds/console/exhibition/listAudit.do', null, '1', null, '参展审核');
INSERT INTO `hb_permission` VALUES ('122', '66778b95b46b4897bf7aa0755624b1d6', '514976a0d3244c31ae7a4dafc2d0a716', null, '预约信息', '/venue/venue_use_list.do', '/portal/exhibition/changeExhibitReviewState.do', '1', null, '预约信息');
INSERT INTO `hb_permission` VALUES ('123', 'f432246542a1437f8d9e57c2d06874c5', '5d009b2148e34fc6b232043ba67cef46', null, '场馆审核', '/clouds/console/venue/listReview.do', null, '1', null, '场馆审核');
INSERT INTO `hb_permission` VALUES ('124', '032adabcdb884edb895c7d3305f24b9d', '938ddbe6f3fc488a93640c7d1319e2d3', null, '地区管理', '/clouds/console/area/list.do', null, '1', null, '地区管理');
INSERT INTO `hb_permission` VALUES ('125', '9b2172f9cd01451c92ab0208cb79e99d', '6b49a35429b04756b12da2c7e74907d2', null, '展会配置', '/organ/exhibConfig.do', null, '1', null, '展会三级页面配置');
INSERT INTO `hb_permission` VALUES ('127', 'acb5d6d8cae04207910c9ac6cf14aa10', 'c3481b1df62c48119cf18e2b7979d2dd', null, '信息管理', '/shop/shopInfo.do', '/shop/updateInfo.do|/image/uploadImageResizesFix.do|/shop/changeGeneralReviewState.do', '1', null, '信息管理');
INSERT INTO `hb_permission` VALUES ('128', 'b31a10c7d65b4c61b779649fce61452a', '514976a0d3244c31ae7a4dafc2d0a716', null, '场馆配置', '/venue/venueConfig.do', '/venue/updateConfig.do', '1', null, '场馆配置');
INSERT INTO `hb_permission` VALUES ('130', 'cfe7b26dfcfb4d529747277097bb0aa2', 'b31a10c7d65b4c61b779649fce61452a', null, '首页图片', '/venue/config/guide.do', '/venue/config/saveGuide.do', '1', null, '首页图片');
INSERT INTO `hb_permission` VALUES ('131', 'f3853d19a2f6449aaf55d5e49a471bc3', 'b31a10c7d65b4c61b779649fce61452a', null, '公司信息', '/venue/config/com.do', '/venue/config/saveCom.do|/image/uploadImageResizesFix.do', '1', null, '公司信息');
INSERT INTO `hb_permission` VALUES ('132', '2e598791321d422aa4ca79b44e3b2d64', 'b31a10c7d65b4c61b779649fce61452a', null, '展览信息', '/venue/config/common.do', '/venue/config/saveCommon.do', '1', null, '展览信息');
INSERT INTO `hb_permission` VALUES ('133', '60f82b525ed5427993f82dfbaaa2e010', 'b31a10c7d65b4c61b779649fce61452a', null, '相关下载', '/venue/configration/download.do', '/venue/config/configFile.do|/venue/config/saveFile.do', '1', null, '相关下载');
INSERT INTO `hb_permission` VALUES ('134', '682168f568484d289fdda0a9ebd0aaa8', '9b2172f9cd01451c92ab0208cb79e99d', null, '展会日程', '/organ/exScheduleList.do', '/organ/jumpModifyExSchedule.do|/organ/deleteExSchedule.do|/organ/modifyExSchedule.do', '1', null, '展会日程');
INSERT INTO `hb_permission` VALUES ('135', '1a2917ffb41246b78fb93d7d97f0ab97', '9b2172f9cd01451c92ab0208cb79e99d', null, '展位信息', '/organ/exSpaceList.do', '/organ/jumpModifyExSpace.do|/organ/modifyExSpace.do', '1', null, '展位信息');
INSERT INTO `hb_permission` VALUES ('136', 'cb76dd3b2126453898eee9e095c5dd2e', '9b2172f9cd01451c92ab0208cb79e99d', null, '展会平面图', '/organ/ichnography.do', '/organ/saveGraphy.do', '1', null, '展会平面图');
INSERT INTO `hb_permission` VALUES ('137', '1876dbfbcec54efebea804c6fe5a9746', '85e8c90ab9e84914b6465506d4db0fbd', null, '参展展品', '/organ/toProductPic.do', '/organ/toProductPic.do|/organ/saveProductPic.do|image/uploadImageResizesFix.do', '1', null, '参展展品');
INSERT INTO `hb_permission` VALUES ('138', 'd7da0a99316044228f73868c424b1c70', '6d0950c0dc71466cac09aa60401774a7', null, '发布', '/venue/publish.do', null, '1', null, '场馆发布');
INSERT INTO `hb_permission` VALUES ('139', '864c40fdbf5b4d6fabe9712a8c1161f2', '845799be2f9f4c92940f007068d77c3d', null, '企业信息审核', '/clouds/console/customer/infoListReview.do', '/customer/showCustomer.do|/customer/changInfoReviewState.do', '1', null, '企业信息审核');
INSERT INTO `hb_permission` VALUES ('140', '45473ce383764da9b73b8f0de35f3d90', '6cc48f83476043c1957ad069078324cb', null, '展位管理', '/clouds/console/3d/stand/index.do', null, '1', null, '展位管理');
INSERT INTO `hb_permission` VALUES ('141', '1a2d4fb442fa472887764605e175f91e', '9b2172f9cd01451c92ab0208cb79e99d', null, '首页图片', '/organ/config/guide.do', '/organ/config/saveGuide.do', '1', null, '');

-- ----------------------------
-- Table structure for hb_role
-- ----------------------------
DROP TABLE IF EXISTS `hb_role`;
CREATE TABLE `hb_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
  `ROLE_ID` varchar(32) NOT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `PRIORITY` decimal(11,0) DEFAULT NULL,
  `IS_SUPER` varchar(1) DEFAULT NULL,
  `ROLE_NOTE` varchar(200) DEFAULT NULL,
  `STATUS` decimal(1,0) DEFAULT NULL,
  `FLAG` int(1) NOT NULL DEFAULT '1' COMMENT '1:后台角色；2:前台角色',
  `TYPE` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_role
-- ----------------------------
INSERT INTO `hb_role` VALUES ('2', '2114e0ba7cf94b0d81654c9142f0382f', '系统管理员', '1', '1', '系统管理员', '1', '1', null);
INSERT INTO `hb_role` VALUES ('3', '8850e8de73b6402fbf45aac0fe3f5c38', '配置管理员', '1', '1', '配置管理员', '1', '1', null);
INSERT INTO `hb_role` VALUES ('23', '104e604577cc415ea8014020099407b0', '超级管理员', '1', '1', '超级管理员', '1', '1', null);
INSERT INTO `hb_role` VALUES ('25', 'c9ef373f9e034488bd1b7e2e70b0f069', '代理商', '1', '1', '代理商', '1', '1', null);

-- ----------------------------
-- Table structure for hb_roleperm
-- ----------------------------
DROP TABLE IF EXISTS `hb_roleperm`;
CREATE TABLE `hb_roleperm` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
  `PERM_ID` varchar(32) NOT NULL COMMENT '权限UUID',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色UUID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3887 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_roleperm
-- ----------------------------
INSERT INTO `hb_roleperm` VALUES ('264', '0', '8850e8de73b6402fbf45aac0fe3f5c38');
INSERT INTO `hb_roleperm` VALUES ('265', '0a78136780424943b5096b1755b84add', '8850e8de73b6402fbf45aac0fe3f5c38');
INSERT INTO `hb_roleperm` VALUES ('266', '466e3c5a972b49c2a6a5d2f05785eb75', '8850e8de73b6402fbf45aac0fe3f5c38');
INSERT INTO `hb_roleperm` VALUES ('267', '12d67b67dbce468ab48f150bb7d5136c', '8850e8de73b6402fbf45aac0fe3f5c38');
INSERT INTO `hb_roleperm` VALUES ('268', '48e5575860cd4a01a1d021614cbcc1ae', '8850e8de73b6402fbf45aac0fe3f5c38');
INSERT INTO `hb_roleperm` VALUES ('2991', 'c3481b1df62c48119cf18e2b7979d2dd', '671170b5b50d45e8835b1696b156846b');
INSERT INTO `hb_roleperm` VALUES ('2992', 'c280c11b17b2400085d1dfcb6d68e7b3', '671170b5b50d45e8835b1696b156846b');
INSERT INTO `hb_roleperm` VALUES ('2993', 'acb5d6d8cae04207910c9ac6cf14aa10', '671170b5b50d45e8835b1696b156846b');
INSERT INTO `hb_roleperm` VALUES ('2994', '85e8c90ab9e84914b6465506d4db0fbd', '671170b5b50d45e8835b1696b156846b');
INSERT INTO `hb_roleperm` VALUES ('2995', 'd8856e5182634a25bbd9d0ab18ef6b43', '671170b5b50d45e8835b1696b156846b');
INSERT INTO `hb_roleperm` VALUES ('2996', '1876dbfbcec54efebea804c6fe5a9746', '671170b5b50d45e8835b1696b156846b');
INSERT INTO `hb_roleperm` VALUES ('3085', '0', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3086', 'c3481b1df62c48119cf18e2b7979d2dd', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3087', 'c280c11b17b2400085d1dfcb6d68e7b3', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3094', 'acb5d6d8cae04207910c9ac6cf14aa10', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3095', '6b49a35429b04756b12da2c7e74907d2', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3096', 'bbaee3a8816441f2a05548fd0174d8ff', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3097', 'd92b8385b1bb49328d92a7aa34dd02b9', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3098', '14e6fe0c09704fa38f482ab27dae624f', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3099', '9b2172f9cd01451c92ab0208cb79e99d', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3100', '682168f568484d289fdda0a9ebd0aaa8', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3101', '1a2917ffb41246b78fb93d7d97f0ab97', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3102', 'cb76dd3b2126453898eee9e095c5dd2e', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3103', '514976a0d3244c31ae7a4dafc2d0a716', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3104', '75365387893a4b57ba123d39ea6f5395', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3105', '6d0950c0dc71466cac09aa60401774a7', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3107', '66778b95b46b4897bf7aa0755624b1d6', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3108', 'b31a10c7d65b4c61b779649fce61452a', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3109', 'cfe7b26dfcfb4d529747277097bb0aa2', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3110', 'f3853d19a2f6449aaf55d5e49a471bc3', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3111', '2e598791321d422aa4ca79b44e3b2d64', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3112', '60f82b525ed5427993f82dfbaaa2e010', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3113', '85e8c90ab9e84914b6465506d4db0fbd', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3114', 'd8856e5182634a25bbd9d0ab18ef6b43', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3115', '1876dbfbcec54efebea804c6fe5a9746', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3116', '2fcc9865c8c9478badeb6455df2a8270', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3117', 'c8ead2a9f4bc4e84a40d86b0370fbdd4', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3118', '6c14666777f24b918d345c3ad51c0e35', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3123', 'f241a8da86624f09aa878d5073422c8d', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3124', '68014cba46824807be073d20f77a78f0', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3125', 'a5aec5fa498545128d3f16959c34beec', 'd17b253fde894b9f8ca1a71de0683e5d');
INSERT INTO `hb_roleperm` VALUES ('3432', 'c3481b1df62c48119cf18e2b7979d2dd', '195162eacc20419a9c6d7a447c96e721');
INSERT INTO `hb_roleperm` VALUES ('3433', 'c280c11b17b2400085d1dfcb6d68e7b3', '195162eacc20419a9c6d7a447c96e721');
INSERT INTO `hb_roleperm` VALUES ('3434', 'f241a8da86624f09aa878d5073422c8d', '195162eacc20419a9c6d7a447c96e721');
INSERT INTO `hb_roleperm` VALUES ('3435', '68014cba46824807be073d20f77a78f0', '195162eacc20419a9c6d7a447c96e721');
INSERT INTO `hb_roleperm` VALUES ('3573', 'c3481b1df62c48119cf18e2b7979d2dd', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3574', 'c280c11b17b2400085d1dfcb6d68e7b3', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3575', 'acb5d6d8cae04207910c9ac6cf14aa10', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3576', '514976a0d3244c31ae7a4dafc2d0a716', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3577', '75365387893a4b57ba123d39ea6f5395', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3578', '6d0950c0dc71466cac09aa60401774a7', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3579', '66778b95b46b4897bf7aa0755624b1d6', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3580', 'b31a10c7d65b4c61b779649fce61452a', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3581', 'cfe7b26dfcfb4d529747277097bb0aa2', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3582', 'f3853d19a2f6449aaf55d5e49a471bc3', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3583', '2e598791321d422aa4ca79b44e3b2d64', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3584', '60f82b525ed5427993f82dfbaaa2e010', 'a1885da427a34b2d9e88d10214b720a7');
INSERT INTO `hb_roleperm` VALUES ('3618', '0', 'ff6eb0818313412eb9edb07e506e98c5');
INSERT INTO `hb_roleperm` VALUES ('3619', 'c3481b1df62c48119cf18e2b7979d2dd', 'ff6eb0818313412eb9edb07e506e98c5');
INSERT INTO `hb_roleperm` VALUES ('3620', 'c280c11b17b2400085d1dfcb6d68e7b3', 'ff6eb0818313412eb9edb07e506e98c5');
INSERT INTO `hb_roleperm` VALUES ('3621', 'acb5d6d8cae04207910c9ac6cf14aa10', 'ff6eb0818313412eb9edb07e506e98c5');
INSERT INTO `hb_roleperm` VALUES ('3622', '85e8c90ab9e84914b6465506d4db0fbd', 'ff6eb0818313412eb9edb07e506e98c5');
INSERT INTO `hb_roleperm` VALUES ('3623', 'd8856e5182634a25bbd9d0ab18ef6b43', 'ff6eb0818313412eb9edb07e506e98c5');
INSERT INTO `hb_roleperm` VALUES ('3624', '1876dbfbcec54efebea804c6fe5a9746', 'ff6eb0818313412eb9edb07e506e98c5');
INSERT INTO `hb_roleperm` VALUES ('3658', '0', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3659', 'c3481b1df62c48119cf18e2b7979d2dd', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3660', 'c280c11b17b2400085d1dfcb6d68e7b3', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3661', 'acb5d6d8cae04207910c9ac6cf14aa10', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3662', '6b49a35429b04756b12da2c7e74907d2', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3663', 'bbaee3a8816441f2a05548fd0174d8ff', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3664', 'd92b8385b1bb49328d92a7aa34dd02b9', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3665', '14e6fe0c09704fa38f482ab27dae624f', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3666', '9b2172f9cd01451c92ab0208cb79e99d', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3667', '682168f568484d289fdda0a9ebd0aaa8', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3668', '1a2917ffb41246b78fb93d7d97f0ab97', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3669', 'cb76dd3b2126453898eee9e095c5dd2e', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3670', '1a2d4fb442fa472887764605e175f91e', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3671', '514976a0d3244c31ae7a4dafc2d0a716', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3672', '75365387893a4b57ba123d39ea6f5395', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3673', '6d0950c0dc71466cac09aa60401774a7', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3674', '66778b95b46b4897bf7aa0755624b1d6', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3675', 'b31a10c7d65b4c61b779649fce61452a', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3676', 'cfe7b26dfcfb4d529747277097bb0aa2', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3677', 'f3853d19a2f6449aaf55d5e49a471bc3', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3678', '2e598791321d422aa4ca79b44e3b2d64', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3679', '60f82b525ed5427993f82dfbaaa2e010', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3680', '2fcc9865c8c9478badeb6455df2a8270', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3681', 'c8ead2a9f4bc4e84a40d86b0370fbdd4', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3682', '6c14666777f24b918d345c3ad51c0e35', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3683', 'f241a8da86624f09aa878d5073422c8d', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3684', 'a5aec5fa498545128d3f16959c34beec', '293c751ef086442da118b7d6aa6df1eb');
INSERT INTO `hb_roleperm` VALUES ('3851', '0', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3852', '0a78136780424943b5096b1755b84add', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3853', '466e3c5a972b49c2a6a5d2f05785eb75', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3854', '12d67b67dbce468ab48f150bb7d5136c', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3855', '48e5575860cd4a01a1d021614cbcc1ae', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3856', '52438bdce9c84845aee6084fedf87077', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3857', 'f6fd7280c0834fc89c8abfd7384c0a4b', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3858', '59583427b11c40b9bbf2390809b81a2f', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3859', 'f7d05a5be51f4391804e7bd1dec84136', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3860', 'f58cca83d0c54fc982662d497a5ad5ec', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3861', 'ae73706633f544708f33ceebf3d1231d', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3862', '6a184fa1588c4239bd1f7f7cbb3b4266', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3863', '845799be2f9f4c92940f007068d77c3d', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3864', 'c5a20d6565514f7599b8143ffd4cf429', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3865', '864c40fdbf5b4d6fabe9712a8c1161f2', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3866', '938ddbe6f3fc488a93640c7d1319e2d3', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3867', '393e420d5b2f4cdea691c1ac93022d65', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3868', 'd2dcf098cf00409a995fe276fcad955e', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3869', '625803d05cb44cfcbf522ced4e46dd16', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3870', 'f1090825284e468fa017a82c8dd0141c', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3871', '032adabcdb884edb895c7d3305f24b9d', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3872', 'c3481b1df62c48119cf18e2b7979d2dd', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3873', 'c280c11b17b2400085d1dfcb6d68e7b3', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3874', 'acb5d6d8cae04207910c9ac6cf14aa10', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3875', '6cc48f83476043c1957ad069078324cb', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3876', 'bfa83e5434cd454da13bb29deaab97d0', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3877', '4c68671aead841c3b5da7dc36734d6d4', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3878', '9111af2595cb436fb3f798e7d38c3017', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3879', '45473ce383764da9b73b8f0de35f3d90', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3880', '6a1675c45d6a4183adae3b8dc99d67f3', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3881', '65be3ea5b578423b8a0f7948fbd8a2b9', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3882', '0fda7209b978498c8b0a415a1be3557d', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3883', '5d009b2148e34fc6b232043ba67cef46', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3884', '61015832e509460c949b5025f95b89a8', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3885', 'b297811c2d014a6eae0ec1de5f2a2495', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_roleperm` VALUES ('3886', 'f432246542a1437f8d9e57c2d06874c5', '2114e0ba7cf94b0d81654c9142f0382f');

-- ----------------------------
-- Table structure for hb_sku
-- ----------------------------
DROP TABLE IF EXISTS `hb_sku`;
CREATE TABLE `hb_sku` (
  `SKU_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '最小销售单元主键',
  `SKU_NAME` varchar(100) DEFAULT NULL COMMENT 'SKU名称',
  `SHORT_NAME` varchar(255) DEFAULT NULL,
  `SKU_PRICE` int(10) unsigned zerofill NOT NULL COMMENT '(以分币为单位)',
  `TYPE` int(10) DEFAULT NULL COMMENT '类别：1-移动，2-联通，3-电信',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态',
  `SHOW_STATUS` int(2) DEFAULT '1' COMMENT '上下架状态：0.为上架；1.为下架',
  `SKU_SORT` int(5) unsigned zerofill DEFAULT '00000' COMMENT '前台显示排序',
  `CREATE_TIME` datetime(6) DEFAULT NULL,
  `UPDATE_TIME` datetime(6) DEFAULT NULL,
  `CREATE_USER_ID` int(11) DEFAULT NULL,
  `UPDATE_USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SKU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3011 DEFAULT CHARSET=utf8 COMMENT='最小销售单元，包括实体商品、虚拟商品（如号卡、套卡、话费等）\r\n';

-- ----------------------------
-- Records of hb_sku
-- ----------------------------
INSERT INTO `hb_sku` VALUES ('3000', '10M', '移动全国10M', '0000000300', '1', '1', '1', '00001', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3001', '30M', '移动全国30M', '0000000500', '1', '1', '1', '00002', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3002', '70M', '移动全国70M', '0000001000', '1', '1', '1', '00003', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3003', '150M', '移动全国150M', '0000002000', '1', '1', '1', '00004', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3004', '500M', '移动全国500M', '0000003000', '1', '1', '1', '00005', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3005', '1G', '移动全国1G', '0000005000', '1', '1', '1', '00006', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3006', '2G', '移动全国2G', '0000007000', '1', '1', '1', '00007', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3007', '3G', '移动全国3G', '0000010000', '1', '1', '1', '00008', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3008', '4G', '移动全国4G', '0000013000', '1', '1', '1', '00009', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3009', '6G', '移动全国6G', '0000018000', '1', '1', '1', '00010', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);
INSERT INTO `hb_sku` VALUES ('3010', '11G', '移动全国11G', '0000028000', '1', '1', '1', '00011', '2016-08-07 10:56:19.000000', '2016-08-07 10:58:14.000000', null, null);

-- ----------------------------
-- Table structure for hb_user
-- ----------------------------
DROP TABLE IF EXISTS `hb_user`;
CREATE TABLE `hb_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户ID（逻辑主键）',
  `USERNAME` varchar(100) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT ' 密码',
  `FULLNAME` varchar(100) DEFAULT NULL COMMENT '全称',
  `GENDER` decimal(1,0) DEFAULT NULL COMMENT '性别',
  `EMAIL` varchar(100) DEFAULT NULL COMMENT '邮箱地址',
  `STATUS` decimal(1,0) DEFAULT NULL COMMENT '状态',
  `REGISTER_TIME` datetime DEFAULT NULL COMMENT '注册时间',
  `REGISTER_IP` varchar(50) DEFAULT NULL COMMENT '注册IP',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登录时间',
  `LAST_LOGIN_IP` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `LOGIN_COUNT` decimal(11,0) DEFAULT NULL COMMENT '登录次数',
  `IS_ADMIN` decimal(1,0) DEFAULT NULL COMMENT '是否管理员',
  `SYS_FLAG` int(1) DEFAULT NULL COMMENT '系统标识',
  `CURR_LEVEL` int(2) DEFAULT NULL COMMENT '当前层次',
  `USER_UPID` varchar(32) DEFAULT NULL COMMENT '父节点',
  `ACCOUNT_ID` varchar(32) DEFAULT NULL COMMENT '账户ID',
  `PER` int(4) DEFAULT NULL,
  `RATE` int(4) DEFAULT NULL COMMENT '佣金费率',
  `REAL_RATE` int(4) DEFAULT NULL COMMENT '真实费率(通过计算各级代理商)',
  `HAS_CHILD` int(1) DEFAULT NULL COMMENT '是否有子节点',
  PRIMARY KEY (`ID`),
  KEY `INDEX_USER_ID` (`USER_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_user
-- ----------------------------
INSERT INTO `hb_user` VALUES ('18', '550d4e6b7b284e3c8f8a8dead285da3a', 'admin', '1BBD886460827015E5D605ED44252251', '管理员', '1', 'xwlig@isoftstone.com', '1', '2015-06-24 09:33:45', '', '2017-05-25 00:49:19', '', '0', '0', '1', '0', null, 'c6ec751f401747948f6ef38377ef3356', null, null, '80', '1');

-- ----------------------------
-- Table structure for hb_userrole
-- ----------------------------
DROP TABLE IF EXISTS `hb_userrole`;
CREATE TABLE `hb_userrole` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
  `USER_ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hb_userrole
-- ----------------------------
INSERT INTO `hb_userrole` VALUES ('5', 'e7f7afacd09844849c252204052bc0a5', '70c84a3559b94f4cbd0f4ea00b015a9c');
INSERT INTO `hb_userrole` VALUES ('168', 'a089390881fb4b43a1a9c51030d7d620', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_userrole` VALUES ('169', 'a089390881fb4b43a1a9c51030d7d620', '8850e8de73b6402fbf45aac0fe3f5c38');
INSERT INTO `hb_userrole` VALUES ('170', 'a089390881fb4b43a1a9c51030d7d620', '104e604577cc415ea8014020099407b0');
INSERT INTO `hb_userrole` VALUES ('187', '550d4e6b7b284e3c8f8a8dead285da3a', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_userrole` VALUES ('188', '550d4e6b7b284e3c8f8a8dead285da3a', '8850e8de73b6402fbf45aac0fe3f5c38');
INSERT INTO `hb_userrole` VALUES ('199', 'a9ee0f59246744c5acefac77edb78d32', '2114e0ba7cf94b0d81654c9142f0382f');
INSERT INTO `hb_userrole` VALUES ('200', '2970d885c74e4367a4ab824149e3427e', 'c9ef373f9e034488bd1b7e2e70b0f069');
INSERT INTO `hb_userrole` VALUES ('201', '04ab950fbd254b62b6aab230fcad77d1', 'c9ef373f9e034488bd1b7e2e70b0f069');
INSERT INTO `hb_userrole` VALUES ('202', 'c560b312563641faa352088962278077', 'c9ef373f9e034488bd1b7e2e70b0f069');
INSERT INTO `hb_userrole` VALUES ('203', '9af0116af3da4b0d8d656523098c7f8a', 'c9ef373f9e034488bd1b7e2e70b0f069');

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `NAME` varchar(50) NOT NULL,
  `CURRENT_VALUE` decimal(14,0) NOT NULL,
  `INCREMENT` decimal(10,0) NOT NULL DEFAULT '1',
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO `sequence` VALUES ('SEQALBUMID', '1008', '1');
INSERT INTO `sequence` VALUES ('SEQINSOFFER', '13000000000216', '1');
INSERT INTO `sequence` VALUES ('SEQINSPRICEINFO', '14000000000207', '1');
INSERT INTO `sequence` VALUES ('SEQINSPRICEPLAN', '15000000000207', '1');
INSERT INTO `sequence` VALUES ('SEQINSPROD', '11000000000216', '1');
INSERT INTO `sequence` VALUES ('SEQINSPRODSKU', '12000000000216', '1');
INSERT INTO `sequence` VALUES ('SEQORDERDETAILID', '20056', '1');
INSERT INTO `sequence` VALUES ('SEQORDERNO', '3235', '1');
INSERT INTO `sequence` VALUES ('SEQVENUEINFOID', '3063', '1');

-- ----------------------------
-- Table structure for user_open_info
-- ----------------------------
DROP TABLE IF EXISTS `user_open_info`;
CREATE TABLE `user_open_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` varchar(32) NOT NULL COMMENT '用户id 用户唯一标示',
  `product_id` varchar(32) DEFAULT NULL COMMENT '法证邮产品id 目前分免费和8元版',
  `product_name` varchar(32) DEFAULT NULL COMMENT '产品名称',
  `product_fee` int(11) DEFAULT NULL COMMENT '产品资费',
  `mail_capacity` int(11) DEFAULT NULL COMMENT '邮箱容量',
  `mailroot` int(11) DEFAULT NULL COMMENT '邮箱mailroot',
  `opentime` datetime DEFAULT NULL COMMENT '创建时间',
  `endtime` datetime DEFAULT NULL COMMENT '法证邮截止时间，0元版默认无',
  `state` int(2) DEFAULT NULL COMMENT '状态栏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_open_info
-- ----------------------------

-- ----------------------------
-- Function structure for currval
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS decimal(14,0)
    DETERMINISTIC
BEGIN
         DECLARE value DECIMAL(14);
         SET value = 0;
         SELECT CURRENT_VALUE INTO value
                   FROM SEQUENCE
                   WHERE NAME = seq_name;
         RETURN value;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nextval`(seq_name VARCHAR(50)) RETURNS decimal(14,0)
    DETERMINISTIC
BEGIN
         UPDATE SEQUENCE
                   SET CURRENT_VALUE = CURRENT_VALUE + increment
                   WHERE NAME = seq_name;
         RETURN currval(seq_name);
END
;;
DELIMITER ;
