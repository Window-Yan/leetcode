-- 创建table device


-- 创建表 phone_number


-- 创建表 person_info
CREATE TABLE person(
	int id PRIMARY KEY AUTO_INCREMENT,
	name varchar(25) NOT NULL, -- 实名信息
	birth DATE, -- 出生日期
	sex varchar(1) -- 性别
);
-- 添加身份信息
INSERT INTO
	person
VALUES
	(null,'Amanda',null,'女'),
	(null,'Candy',null,'女'),
	(null,'Clark','1997-5-24','男'),
	(null,'Jeade','1983-11-27','女'),
	(null,'Jenny',null,'女'),
	(null,'Amanda Daughter',null,'女'),
	(null,'Jeade Daughter','2014-5-25','女'),
	(null,'Jenny Son','2005-9-13','男'),
	(null,'Fiona Son 芮','2011-11-9','男'),
	(null,'Fiona Son 泽','2009-1-16','男'),
	(null,'HR提供 1','2004-3-22','男'),
	(null,'HR提供 2','2002-6-22','男'),
	(null,'未知实名信息',null,null),
	(null,'未实名',null,null)
;

-- 账号类型
CREATE TABLE platform(
	int id PRIMARY KEY AUTO_INCREMENT,
	pf varchar(25) -- 账号类型
);
-- 添加账号类型数据
INSERT INTO
	platform
VALUES
	(null,'WeChat'),
	(null,'QQ')
;

-- 创建表 accounts 用于存储账号
CREATE TABLE accounts(
	int id PRIMARY KEY AUTO_INCREMENT,
	account varchar(25) NOT NULL, -- 账号
	open_id varchar(50), -- OPENId
	
	acc_state int FOREIGN KEY, -- 账号状态
	person_info int FOREIGN KEY, -- 实名信息
	platform int FOREIGN KEY NOT NULL, -- 账号平台
	p_number int FOREIGN KEY, -- 手机号
	
);



-- 插入设备信息
insert into device (品牌,name,系统版本,发布时间) 
values('华为','','Android '，''),

('vivo','','Android '，''),



('OPPO','','Android '，''),


('iQOO','','Android '，''),

('realme','','Android '，''),


('魅族','','Android '，''),


('小米','','Android '，''),

('联想','','Android '，''),

('一加','','Android '，''),

('锤子','','Android '，'')

;


-- 插入手机号信息



-- 添加person_info信息


-- 添加accounts信息
