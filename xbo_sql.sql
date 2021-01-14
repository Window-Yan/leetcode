-- 创建table device

-- 插入设备信息
insert into 
	device (id,品牌,name,系统版本,发布时间) 
values(16,'华为','Huawei P20 Pro','Android 9','2018-4-12'),
	(17,'华为','Huawei Honor V20','Android 10.0','2018-12-28'),
	(18,'华为','Huawei Enjoy 9','Android 8.1','2018-12-1'),
	(19,'华为','Huawei Mate 30 5G','Android 10','2019-11-1'),
	(20,'华为','Huawei Honor 9x','Android 10','2019-7-23'),
	(21,'华为','Huawei Honor Play3','Android 9',null),
	(22,'华为','Huawei Honor 30 Pro','Android 10',null),
	(23,'华为','Huawei nova 5 Pro','Android 9',null),
	(24,'vivo','vivo U1','Android 8.1.0','2019-2-1'),
	(25,'vivo','vivo X27','Android 9.0','2019-3-19'),
	(26,'vivo','vivo Y71','Android 8.1.0','2018-4-1'),
	(27,'vivo','vivo Z5x','Android 9',null),
	(28,'vivo','vivo S6','Android 10',null),
	(29,'vivo','iQOO NEO 855','Android 9','2019-11-1'),
	(30,'OPPO','OPPO R17','Android 10','2018-8-23'),
	(31,'OPPO','OPPO A5','Android 8.1','2018-7-5'),
	(32,'OPPO','OPPO Reno Ace','Android 10','2019-10-17'),
	(33,'OPPO','OPPO K5','Android 10','2019-10-17'),
	(34,'OPPO','OPPO Find X2','Android 11',null),
	(35,'OPPO','OPPO Reno4 5G','Android 10',null),	
	(36,'realme','Realme x','Android 10','2019-5-1'),
	(37,'魅族','Meizu X8','Android 8.1.0','2018-9-19'),
	(38,'魅族','Meizu 16s','Android 9','2019-4-28'),
	(39,'小米','XiaoMi 8','Android 9.0','2018-6-5'),
	(40,'小米','Redmi Note 8 Pro','Android 9',null),
	(41,'小米','Redmi K30 5G','Android 10',null),
	(42,'联想','Lenovo Z5s','Android 9','2018-12-24'),
	(43,'一加','OnePlus 7T Pro','Android 10',null),
	(44,'锤子','smartisan Pro 2s','Android 8.1.0',null)
;


-- 创建表 phone_number


-- 插入手机号信息
INSERT INTO
	phone_number
VALUES
	(101,'移动','18701235408',3),
	(102,'移动','13521065120',44),
	(103,'移动','13520168621',20),
	(104,'移动','13520168172',11),
	(105,'移动','18701320072',14),
	(106,'移动','13521446024',15),
	(107,'移动','17746576381',13),	
	(201,'电信','17778043126',19),
	(202,'电信','17744480805',36),
	(203,'电信','13366301325',16),
	(204,'电信','13391836220',37),
	(205,'电信','13391831220',39)
;

-- 创建表 person_info
CREATE TABLE person(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(25) NOT NULL,-- 实名信息
	birth date,-- 出生日期
	sex varchar(1),-- 性别
	usertype varchar(10)-- 用户类型 成年/未成年/null
);
-- 添加身份信息
INSERT INTO
	person
VALUES
	(1,'Amanda',null,'女','adult'),
	(2,'Candy',null,'女','adult'),
	(3,'Clark','1997-5-24','男','adult'),
	(4,'Jeade','1983-11-27','女','adult'),
	(5,'Jenny',null,'女','adult'),
	(6,'Amanda Daughter',null,'女','under-aged'),
	(7,'Jeade Daughter','2014-5-25','女','under-aged'),
	(8,'Jenny Son','2005-9-13','男','under-aged'),
	(9,'Fiona Son 芮','2011-11-9','男','under-aged'),
	(10,'Fiona Son 泽','2009-1-16','男','under-aged'),
	(11,'HR提供 1','2004-3-22','男','under-aged'),
	(12,'HR提供 2','2002-6-22','男','adult'),
	(13,'未知实名信息',null,null,'under-aged'),
	(14,'未实名',null,null,null)
;

/* -- 账号类型
CREATE TABLE platfrom(
	int id PRIMARY KEY AUTO_INCREMENT,
	pf varchar(25) -- 账号类型
);
-- 添加账号类型数据
INSERT INTO
	platform
VALUES
	(null,'WeChat'),
	(null,'QQ')
; */

/* -- OPEN ID表
CREATE TABLE openid{
	id int PRIMARY KEY AUTO_INCREMENT,
	openID varchar(100) -- OPEN ID
}; */


-- 账号状态表
CREATE TABLE states(
	id int PRIMARY KEY,
	dscr varchar(100) NOT NULL-- 账号状态描述
);
-- 添加状态描述数据
INSERT INTO
	states
VALUES
	(1,'正常'),
	(2,'客户使用'),
	(3,'特殊用途'),
	(10,'账号需要解封'),
	(11,'废弃账号')	
;

-- 创建表 accounts 用于存储账号
CREATE TABLE accounts(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(30), -- 昵称
	account varchar(25) NOT NULL, -- 账号
	open_id varchar(80), -- OPENId		
	acc_state int, -- 账号状态
	person_info int, -- 实名信息
	p_number int, -- 手机号
	acc_platform varchar(25), -- 账号平台
	FOREIGN KEY (acc_state) REFERENCES states(id) ON UPDATE CASCADE,
	FOREIGN KEY (person_info) REFERENCES person(id) ON UPDATE CASCADE,
	FOREIGN KEY (p_number) REFERENCES phone_number(id) ON UPDATE CASCADE
);
-- 添加账号数据
INSERT INTO
	accounts
VALUES
	(1,null,'XBO_tester01','ocxI10bsXMeaCduY2QGAiNmWGhCI',1,6,1,'WeChat'),
	(3,null,'XBO_tester03','ocxI10QCMy1HsaYEt4PuMDfD-KII',1,5,104,'WeChat'),
	(4,null,'XBO_tester04','ocxI10VzgEsInAqYk6rieoftWWHA',1,9,null,'WeChat'),
	(5,null,'XBO_tester05','ocxI10bKYhAQmhQu5pDLR_FFOCpc',1,8,103,'WeChat'),
	(6,null,'XBO_tester06','ocxI10YliwF9-H_yvm81KtMX2L14',1,8,203,'WeChat'),
	(8,null,'XBO_tester08','ocxI10eri_ZU7UjdrVxtKUdQCcKw',2,4,4,'WeChat'),
	(9,null,'XBO_tester09','ocxI10UJ5BC-1_ojiL-As4DkpoVc',1,10,5,'WeChat'),
	(10,null,'XBO_tester10','ocxI10aYpWfNXG8jZ4zJvo62uUV0',1,14,3,'WeChat'),
	(11,null,'XBO_tester11','ocxI10fPSqM23n6IVvpH-xhnUEWw',1,7,204,'WeChat'),
	(12,null,'XBO_tester12','ocxl10Z3QtGGMggctmCzFTuu_MWU',12,5,102,'WeChat'),
	(13,null,'XBO_tester13','ocxI10eoAYr-pIhU6oeXyuZc7NcU',1,4,205,'WeChat'),
	(14,null,'XBO_tester14','ocxI10XcZbW8WeyL7fVMgVwTWomw',1,13,null,'WeChat'),
	(15,null,'XBO_tester15','ocxI10TDLZteBpwNcK6Y4aSxDRng',1,10,2,'WeChat'),
	(17,null,'XBO_tester17','ocxI10dGy0J3qMNBMw91XRo8NOzE',1,4,101,'WeChat'),
	(18,null,'XBO_tester18','ocxI10cOdz4DYqnOswlU1833soXE',1,9,105,'WeChat'),
	(19,null,'XBO_tester19','ocxI10fDWw0XVtzzfIkh2-yzVbfw',3,14,106,'WeChat'),
	(20,null,'XBO_tester20','ocxI10c3jzMiKBCKtGMdaxARRd-k',3,11,107,'WeChat'),
	(21,null,'XBO_tester21','ocxI10enDWfEfJefYN901B1dVJbI',10,14,201,'WeChat'),
	(22,null,'XBO_tester22','ocxI10QHJhcQbTHe-N6tW-WU7g-A',3,14,202,'WeChat'),
	(23,null,'XBO_tester23','ocxI10QEjBPkli4UYlnbMzXAaZUc',1,4,6,'WeChat'),
	(24,null,'XBO_tester24',null,1,14,7,'WeChat'),	
	(200,null,'1687024957','B812DB33298A55029BBE295C8107E69F',10,14,1,'QQ'),
	(203,'xboapptester4995','3055305810','22CB1BFCF4F36190FE91C11B307CFACE',1,14,5,'QQ'),
	(204,'XBO_tester4','3606399860','1FB72C5E2012DE8261A62FFAE781A1EF',1,2,null,'QQ'),
	(205,'XBO_QQ_05','1203662800','084783F40B974CE6ADECFB9CB7B4D202',1,14,103,'QQ'),
	(206,'XBO_QQ_06','2827241184','6F217C8C2EB2B8AFB813E7D3C088BAB1',1,8,203,'QQ'),
	(207,'XBO_QQ_07','2152728950','07A9E300E7202149DED04EC16DB74D34',1,4,2,'QQ'),
	(208,'XBO_QQ_08','3323113411',null,2,4,4,'QQ'),
	(209,'XBO_QQ_09','2740578155','7970BA0E8C8AB3228548903C3FD85AD2',1,8,3,'QQ'),
	(211,'XBO_QQ_11','2746158365','ADA8477284F095DA284915C350EE5F07',1,11,204,'QQ'),
	(212,'XBO_QQ_12','2648259311','490205CC90E70E668AF8E197C25A41A7',1,14,102,'QQ'),
	(213,'XBO_QQ_13','3491125471','B2D73965D1659E19AFFE5D50F060205E',1,12,205,'QQ'),
	(217,'XBO_QQ_17','1517809803','DC03C777EF1BD689933A06F72BA98A6A',1,4,101,'QQ'),
	(218,'XBO_QQ_18','3342407881','3906BFCA2343A32E023E35F0EE3454EC',1,4,105,'QQ'),
	(219,'XBO_QQ_19','1702936944','D19C05E18386F8FC46A9C957188732CC',1,9,106,'QQ'),
	(220,'XBO_QQ_20','1655653749','FEBEF18313A7D0D413E8650B2627A5B6',12,4,1107,'QQ'),
	(221,'XBO_QQ_21','1655517146','0F8A47F9DE9E6B8E22775DB220B1FAC3',1,10,201,'QQ'),
	(222,'XBO_QQ_22','3022650755','33AC69EC377776180CC9E44D3BF8513F',1,4,202,'QQ'),
	(223,'XBO_QQ_23','3527836851','252D2F7BDBBF49AFDA627E549CC90B90',1,1,205,'QQ'),
	(224,'XBO_QQ_24','3539533969','A5E157BA8BCC686A1E4B5509B17DAEBB',1,10,205,'QQ'),
	(225,'XBO_QQ_25','1921866268',null,1,6,14,'QQ'),
	(226,'XBO_QQ_26','3103560367',null,1,6,14,'QQ')
;









-- 添加accounts信息
