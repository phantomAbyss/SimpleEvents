create table UserInfo  -- 用户信息表
(	
	uId int primary key auto_increment,  -- 用户ID
	uName nvarchar(20) not null,				 -- 用户用户名
	uPassword varchar(20) not null,      -- 用户密码
	uSignature nvarchar(100),						 -- 用户签名
	uSex boolean not null,							 -- 性别
	uAvatarUrl nvarchar(50),						 -- 用户头像路径
	uPhone varchar(12),                 -- 用户电话
	uEmail varchar(30)                   -- 用户邮箱
);

create table Activity   -- 主活动
(
	aId int primary key auto_increment, -- id
	uId int,                            -- 创建活动的用户的id
	aName nvarchar(20),  								-- 活动名称
	aCreationTime date not null,				-- 活动创建时间
	aDeadlineTime date not null,        -- 活动失效的时间
	aParticipation int default 0,       -- 活动参与人数
	aAbstract nvarchar(20),   					-- 活动摘要
	aDescription nvarchar(256),         -- 活动详细信息
	aStatus int default 1,             	-- 活动状态 0：失效  1：未失效
	aNotice nvarchar(128),              -- 活动公告信息
	aAddress nvarchar(128)              -- ** 活动地点
);


create table ChildActivity   -- 子活动
(
	caId int primary key auto_increment,  			  -- 子活动id
	aId int not null,											 				-- 主活动id（外键）
	caName nvarchar(40) not null,         			  -- 子活动名称
	caDescription nvarchar(128),                   -- ** 描述
	caScore int default 0,												-- ** 单次参与积分
	caDayMaxJoin int default 1,            				-- 此活动每天参加此活动积分有效的最大次数
	caIsAvailable boolean default true,    				-- 活动默认可参加
	
	foreign key(aId) references Activity(aId)     -- 外键
);


create table Manager(  -- 管理活动
	aId int,
	caId int not null,
	uId int,
	mDeadTime date,                           -- 管理员身份失效时间
	
	foreign key(aId) references  Activity(aId),
	foreign key(uId) references UserInfo(uId),
	foreign key(caId) references ChildActivity(caId),
	primary key(caId,uId)
);

create table PublishMessage(  -- 发布动态
	pId int primary key auto_increment,
	uId int,
	aId int,
	praiseCount int default 0
);

create table Comment(  -- 评论 
	cId int primary key auto_increment,              -- 
	pId int,													-- 定位到具体评论的动态
	fromUid int,											-- 评论的用户
	toCid int,												-- 被评论的对象
	content nvarchar(256),						-- 评论内容
	commentTime date									-- 评论的时间
);

create table Field(  -- 报名字段
	fId int primary key auto_increment,
	aId int,			
	fieldName nvarchar(28),  -- 字段的名字
	fieldNotice nvarchar(64),	-- 字段描述
	
	foreign key(aId) references Activity(aId)
	
);

create table ApplicationContent(  -- 用户报名填写的信息
	fId int,
	uId int,
	content nvarchar(64),    -- 报名字段内容
	
	foreign key(fId) references Field(fId)
);
	
create table JoinCaForm(  -- 用户参加子活动的记录
	uId int,
	caId int,
	joinTime date,    -- 参加活动时间
	
	foreign key(uId) references UserInfo(uId),
	foreign key(caId) references ChildActivity(caId)
);

create table images(      -- 存储图片
	iId int primary key auto_increment,           -- 图片的id,自增长
	id int,                                       -- 用户id或者活动id
	url varchar(128),                             -- 图片的路径
	flag int                                      -- 图片的标记，0:用户头像，1:活动图片 2:动态图片
);


