# login
## 一、使用用户名和密码登录
### 通过username和password登录
### URL —— http://192.168.1.237:8080/test/user/login
### 支持格式 —— JSON
### HTTP请求方式 —— POST
### request:
    userName   -- 用户名
    password   -- 密码
    checkCode   -- 验证码
### response:
### 登录成功：
```json
{
    "loginMessage": "登录成功",
    "loginSuccess": true,
    "userData": {
        "uId": 1,
        "uName": "zhangsan",
        "uPassword": "123321",
        "uSignature": "哥只是一个传说",
        "uSex": false,
        "uAvatarUrl": "http://192.168.1.237:8080/test/images/1.jpg",
        "uPhone": "15086998050",
        "uEmail": "1762861794@qq.com"
    },
    "status": 200
}
```
### 用户名不存在，即还未注册
```json
{
    "loginMessage": "该用户还未注册，请注册后登录",
    "loginSuccess": false,
    "userData": null,
    "status": 200
}
```
### 用户名或者密码输入错误
```json
{
    "loginMessage": "用户名或者密码输入有误！！",
    "loginSuccess": false,
    "userData": null,
    "status": 200
}
```



## 二、使用第三方工具进行登录
**注意：第三方暂时不开放**
### request:
    qq/WeChat        -- qq或者微信登录
    username         -- 用户名
    使用第三方得到的信息
### response:
```json
接口调用请求说明
https请求方式: POST
{
	"suite_id":"id_value" ,
	"suite_secret": "secret_value", 
	"suite_ticket": "ticket_value" 
}
请求参数说明     
    参数									说明
    suite_id	                            应用套件id
    suite_secret	                        应用套件secret
    suite_ticket	                        微信后台推送的ticket
返回结果示例

{
	"suite_access_token":"61W3mEpU66027wgNZ_MhGHNQDHnFATkDa9-2llqrMBjUwxRSNPbVsMmyD-yq8wZETSoE5NQgecigDrSHkPtIYA",
	"expires_in":7200
}
结果参数说明
    参数									说明
    suite_access_token	                    应用套件access_token. 长度为64至512个字节
    expires_in	                            有效期
```

# register
### URL —— http://192.168.1.237:8080/test/user/register
### 支持格式 —— JSON
### HTTP请求方式 —— POST  
### request:
    uName                  用户名
    uPassword              密码
    confirmPassword        确认密码
    uPhone                 电话
    uSex                    性别
    checkCode               验证码
    
    建议添加添加邮箱以及个性签名、头像
    但不是一定需要填写的
    如果没有用户没有填写个性签名和头像
    服务器端就会自动设置一个基础性个性签名和头像 

### response:

添加失败：
```json
{
    "registerSuccess": false,
    "registerMessage": "用户数据已经存在",
    "registerUser": {
        "uId": 0,
        "uName": "hello",
        "uPassword": "123",
        "uSignature": "这个人很懒，什么也没有留下.......",
        "uSex": false,
        "uAvatarUrl": "2.jpg",
        "uPhone": "",
        "uEmail": ""
    },
    "status": 200
}
```
添加成功：
```json
{
    "registerSuccess": true,
    "registerMessage": "用户数据添加成功",
    "registerUser": {
        "uId": 0,
        "uName": "hello",
        "uPassword": "123",
        "uSignature": "这个人很懒，什么也没有留下.......",
        "uSex": false,
        "uAvatarUrl": "2.jpg",
        "uPhone": "",
        "uEmail": ""
    },
    "status": 200
}
``` 
   
# 获取单个活动的所用信息

### URL —— http://192.168.1.237:8080/test/activity/getSingleActivity
### 支持格式 —— JSON
### HTTP请求方式 —— POST

### request:
    aName            活动名称
    uName            创建该活动的用户的用户名
  	可以只传aName
### response:
- 活动存在
```json
{
    "ActivityData": {
        "aId": 10000,
        "aName": "吃鸡",
        "aCreationTime": "2012-08-12",
        "aDeadlineTime": "2012-10-12",
        "aParticipation": 0,
        "aAbstract": "大吉大利，今晚吃鸡",
        "aDescription": "就是吃鸡，不想多bb",
        "aPicturePath": "http://192.168.0.101:8080/test/img/liaojincan.jpg",
        "aStatus": 1,
        "aNotice": "今天开始",
        "aHaveChild": true
    },
    "getMessage": "该活动存在",
    "getInfoSuccess": true,
    "status": 200
}
```

- 活动不存在：
```json
{
    "getMessage": "该活动不存在",
    "getInfoSuccess": false,
    "status": 200
}
```



# 获取已经创建的所有活动
### URL —— http://192.168.1.237:8080/test/activity/getAllActivity
### 支持格式 —— JSON
### HTTP请求方式 —— POST
### request:
        无

### response:
```json
{
    "activityData": [
        {
            "aId": 10000,
            "aName": "吃鸡",
            "aCreationTime": "2012-08-12",
            "aDeadlineTime": "2012-10-12",
            "aParticipation": 0,
            "aAbstract": "大吉大利，今晚吃鸡",
            "aDescription": "就是吃鸡，不想多bb",
            "aPicturePath": "http://192.168.1.237:8080/test/img/2.jpg",
            "aStatus": 1,
            "aNotice": "今天开始",
            "aHaveChild": true
        },
        {
            "aId": 10001,
            "aName": "图灵运动挑战赛",
            "aCreationTime": "2016-10-15",
            "aDeadlineTime": "2017-02-12",
            "aParticipation": 0,
            "aAbstract": "只为运动",
            "aDescription": "有很多的小项目，很多运动",
            "aPicturePath": "http://192.168.1.237:8080/test/img/2.jpg",
            "aStatus": 1,
            "aNotice": "有可能中间会关闭",
            "aHaveChild": true
        },
        {
            "aId": 10002,
            "aName": "春节联欢晚会",
            "aCreationTime": "2018-12-31",
            "aDeadlineTime": "2019-01-01",
            "aParticipation": 0,
            "aAbstract": "每年举办一次",
            "aDescription": "庆祝春节，庆祝过年",
            "aPicturePath": "http://192.168.1.237:8080/test/img/3.jpg",
            "aStatus": 1,
            "aNotice": "时间为3个小时",
            "aHaveChild": true
        },
        {
            "aId": 10003,
            "aName": "做迷藏",
            "aCreationTime": "2012-08-12",
            "aDeadlineTime": "2012-08-13",
            "aParticipation": 0,
            "aAbstract": "捉迷藏小游戏",
            "aDescription": "大家藏好一个人去找",
            "aPicturePath": "http://192.168.1.237:8080/test/img/1.jpg",
            "aStatus": 1,
            "aNotice": "此活动只开放一天",
            "aHaveChild": false
        }
    ],
    "activityMessage": "查询成功",
    "status": 200
}
```
        
# 我参与或者管理或者创建的活动
    
### URL —— http://192.168.1.237:8080/test/activity/getActivity
### 支持格式 —— JSON
### HTTP请求方式 —— POST

### request:
    uName     用户名
	aStatus   标志是参照参与的活动还是管理的活动
	-1:参加 0：管理 1：创建


### response:
### 参与
```json
{
    "participationMessage": "该用户参加了3项活动",
    "participationData": [
        {
            "aId": 10001,
            "aName": "图灵运动挑战赛",
            "aCreationTime": "2016-10-15",
            "aDeadlineTime": "2017-02-12",
            "aParticipation": 0,
            "aAbstract": "只为运动",
            "aDescription": "有很多的小项目，很多运动",
            "aPicturePath": "http://192.168.0.101:8080/test/img/6.jpg",
            "aStatus": 1,
            "aNotice": "有可能中间会关闭",
            "aHaveChild": true
        },
        {
            "aId": 10002,
            "aName": "春节联欢晚会",
            "aCreationTime": "2018-12-31",
            "aDeadlineTime": "2019-01-01",
            "aParticipation": 0,
            "aAbstract": "每年举办一次",
            "aDescription": "庆祝春节，庆祝过年",
            "aPicturePath": "http://192.168.0.101:8080/test/img/3.jpg",
            "aStatus": 1,
            "aNotice": "时间为3个小时",
            "aHaveChild": true
        },
        {
            "aId": 10003,
            "aName": "做迷藏",
            "aCreationTime": "2012-08-12",
            "aDeadlineTime": "2012-08-13",
            "aParticipation": 0,
            "aAbstract": "捉迷藏小游戏",
            "aDescription": "大家藏好一个人去找",
            "aPicturePath": "http://192.168.0.101:8080/test/img/4.jpg",
            "aStatus": 1,
            "aNotice": "此活动只开放一天",
            "aHaveChild": false
        }
    ],
    "status": 200
}
```
### 管理
```json
{
    "participationMessage": "该用户管理了0项活动",
    "participationData": [],
    "status": 200
}
```
### 创建  
```json
{
    "participationMessage": "该用户创建了1项活动",
    "participationData": [
        {
            "aId": 10000,
            "uId": 1,
            "aName": "吃鸡",
            "aCreationTime": "2012-08-12",
            "aDeadlineTime": "2012-10-12",
            "aParticipation": 0,
            "aAbstract": "大吉大利，今晚吃鸡",
            "aDescription": "就是吃鸡，不想多bb",
            "aPicturePath": "http://192.168.1.237:8080/test/images/1.jpg",
            "aStatus": 0,
            "aNotice": "今天开始",
            "aHaveChild": true,
            "totalScore": 0
        }
    ],
    "status": 200
}
```    

    
    
# 创建一项活动
### URL —— http://192.168.1.237:8080/test/activity/createActivity
### 支持格式 —— JSON
### HTTP请求方式 —— POST

### request:
```json
{
    "uName": "李四",
    "activity": {
        "aName": "String",
        "aDeadlineTime": "2017-8-12",
        "aParticipation": 12,
        "aAbstract": "你好",
        "aDescription": "helloe",
        "aNotice": "helloer"
    },
    "fieldList": [
        {
            "name": "你好",
            "notice": "test"
        },
        {
            "name": "string",
            "notice": "string"
        }
    ],
    "childActivityList": [
        {
		***  以下关于子活动的信息可以不全部发送，但是活动名必须有 ***
            "caName": "string",
            "caDayMaxJoin": 3,
            "caIsAvailable": true,
			"caDescription":"String",
            "score": 12
        },
        {
            "caName": "string",
            "caDayMaxJoin": 5,
            "caIsAvailable": true,
			"caDescription":"String",
            "score": 18
        }
    ]
}
```   
        
### response
```json
{
    "activityMessage": {
        "aId": 10043,
        "uId": 2,
        "aName": "图灵",
        "aCreationTime": "2019-05-25",
        "aDeadlineTime": "2017-08-12",
        "aParticipation": 12,
        "aAbstract": "你好",
        "aDescription": "helloe",
        "aPicturePath": null,
        "aStatus": 0,
        "aNotice": "helloer",
        "aHaveChild": true,
        "totalScore": 0
    },
    "createMessage": "创建成功",
    "createSuccess": true,
    "status": 200
}
```
    
# 添加管理员
### URL —— http://192.168.1.237:8080/test/manager/addManager
### 支持格式 —— JSON
### HTTP请求格式 —— POST

### request
	uName      用户名  
	aName      活动名
	或者
	uId        用户uId
	aId        用户aId

### response
```json
{
    "addSuccess": true,
    "addMessage": "添加成功",
    "status": 200
}
```	 
# 删除管理员
### URL —— http://192.168.1.237:8080/test/manager/
### 支持格式 —— JSON
### HTTP请求格式 —— POST

### request
	uName      用户名  
	aName      活动名
	或者
	uId        用户uId
	aId        用户aId
### response
```json
{
    "addSuccess": true,
    "addMessage": "添加成功",
    "status": 200
}
```	 
# 得到大活动下的所有子活动
### URL —— http://192.168.1.237:8080/test/manager/getAllChildActivity
### 支持格式  —— JSON
### HTTP请求格式 —— POST
### request
	aId,aName   任意一个即可
### response
```json
{
    "childActivityMessagae": [
        {
            "caId": 1001,
            "aId": 10001,
            "caName": "跑步",
            "caIntrgral": 10,
            "caDayMaxJoin": 2,
            "caIsAvailable": true,
            "score": 2
        },
        {
            "caId": 1000002,
            "aId": 10001,
            "caName": "跳绳",
            "caIntrgral": 2,
            "caDayMaxJoin": 4,
            "caIsAvailable": true,
            "score": 2
        },
        {
            "caId": 1000006,
            "aId": 10001,
            "caName": "跑步",
            "caIntrgral": 3,
            "caDayMaxJoin": 1,
            "caIsAvailable": true,
            "score": 7
        },
        {
            "caId": 1000009,
            "aId": 10001,
            "caName": "俯卧撑",
            "caIntrgral": 5,
            "caDayMaxJoin": 1,
            "caIsAvailable": true,
            "score": 5
        },
        {
            "caId": 1000015,
            "aId": 10001,
            "caName": "跑步",
            "caIntrgral": 10,
            "caDayMaxJoin": 2,
            "caIsAvailable": true,
            "score": 2
        },
        {
            "caId": 1000032,
            "aId": 10001,
            "caName": "string",
            "caIntrgral": 12,
            "caDayMaxJoin": 3,
            "caIsAvailable": true,
            "score": 12
        }
    ],
    "status": 200,
    "getSuccess": true
}
```

# 排行榜
### URL —— http://192.168.1.237:8080/test/manager/rankList
### 支持格式 —— JSON
### HTTP请求方式 —— POST
### request
	aName   -- 用户名
	aId    -- 用户名id
	order  -- 排序方式  1 表示升序  0 表示降序
*** 前两项必须要输入一项 ***
### response
```json
{
    "rankSuccess": true,
    "status": 200,
    "rankMessage": [
        {
            "activity": {
                "aId": 10000,
                "uId": 1,
                "aName": "吃鸡",
                "aCreationTime": "2012-08-12",
                "aDeadlineTime": "2012-10-12",
                "aParticipation": 0,
                "aAbstract": "大吉大利，今晚吃鸡",
                "aDescription": "就是吃鸡，不想多bb",
                "aPicturePath": "1.jpg",
                "aStatus": 0,
                "aNotice": "今天开始",
                "aHaveChild": true,
                "totalScore": 0
            },
            "user": {
                "uId": 12,
                "uName": "wy",
                "uPassword": "123456",
                "uSignature": "这个人很懒，什么也没有留下.......",
                "uSex": false,
                "uAvatarUrl": "2.jpg?time=1558365905296",
                "uPhone": "13272894356",
                "uEmail": ""
            },
            "totalScore": 98
        },
        {
            "activity": {
                "aId": 10000,
                "uId": 1,
                "aName": "吃鸡",
                "aCreationTime": "2012-08-12",
                "aDeadlineTime": "2012-10-12",
                "aParticipation": 0,
                "aAbstract": "大吉大利，今晚吃鸡",
                "aDescription": "就是吃鸡，不想多bb",
                "aPicturePath": "1.jpg",
                "aStatus": 0,
                "aNotice": "今天开始",
                "aHaveChild": true,
                "totalScore": 0
            },
            "user": {
                "uId": 10,
                "uName": "Forever X",
                "uPassword": "3267874905",
                "uSignature": "我屋嘻嘻最帅哒",
                "uSex": false,
                "uAvatarUrl": "1.jpg",
                "uPhone": "32678749050",
                "uEmail": "3267874905@qq.com"
            },
            "totalScore": 67
        }
    ]
}
```

# 填写对应活动的报名信息
### URL —— http://192.168.1.237:8080/test/manager/signUp
### 支持格式 —— JSON
### HTTP请求格式 —— POST
### request
```json
{
	"aId":int,
	"uId":int,
	"childActivity":{
			
    },
	"signUpMessage":
	[
		{
			"fid":int,
			"content":"String",
		},
		{
			"fid":int,
			"content":"String"
		}
		....
	]
}
```
### response
```json
{
    "signUpMessage": "报名成功",
    "userMessge": {    -- 报名的用户的信息
        "uId": 1,
        "uName": "zhangsan",
        "uPassword": "123321",
        "uSignature": "哥只是一个传说",
        "uSex": false,
        "uAvatarUrl": "1.jpg",
        "uPhone": "15086998050",
        "uEmail": "1762861794@qq.com"
    },
    "signUpSuccess": true,
    "status": 200
}
```

# 添加子活动
### URL —— http://192.168.1.237:8080/test/manager/signUp
### 支持格式 —— JSON
### HTTP请求格式 —— POST
### request
	aId,aName           大活动的名称或者aId
	小活动的信息

```json
{
	"aName","String",
	"aId":int,
	-- 上面两项数据可以只传一项，不传的置为null,或者0
	"childActivityList": [
        {
		***  以下关于子活动的信息可以不全部发送，但是活动名必须有 ***
            "caName": "string",
            "caDayMaxJoin": 3,
            "caIsAvailable": true,
			"caDescription":"String",
            "score": 12
        },
        {
            "caName": "string",
            "caDayMaxJoin": 5,
            "caIsAvailable": true,
			"caDescription":"String",
            "score": 18
        }
	]
}
```
### response
```json
{
	
}
```


# 获取报名表的字段
### URL —— http://192.168.1.237:8080/test/manager/entryFields
### 支持格式 —— JSON
### HTTP请求格式 —— POST
### request
	aId  活动的id
### response
```json
{
    "status": 200,
    "fieldsInfo": {
        "1": "1",
        "QQ": "请输入QQ",
        "姓名": "请输入姓名",
        "电话": "请输入电话",
        "身份证号码": "请输入身份证号码"
    }
}
```

# 取消活动
### URL —— http://192.168.1.237:8080/test/manager/signUp
### 支持格式 —— JSON
### HTTP请求格式 —— POST
### request
