# register
### URL —— http://192.168.1.237:8080/test/user/register
### 支持格式 —— JSON
### HTTP请求方式 —— POST  
### request:
    uName                  用户名
    uPassword              密码
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
    "userImage": "http://192.168.1.237:8080/test/images/1.jpg",
    "registerUser": {
        "uId": 1,
        "uName": "zhangsan",
        "uPassword": "123456",
        "uSignature": "这个人很懒，什么也没有留下.......",
        "uSex": true,
        "uPhone": "0100101",
        "uEmail": "23432"
    },
    "status": 200
}
```
添加成功：
```json
{
    "registerSuccess": true,
    "registerMessage": "用户数据添加成功",
    "registerImage": "http://192.168.1.237:8080/test/images/1.jpg",
    "registerUser": {
        "uId": 1,
        "uName": "zhangsan",
        "uPassword": "123456",
        "uSignature": "这个人很懒，什么也没有留下.......",
        "uSex": true,
        "uPhone": "0100101",
        "uEmail": "23432"
    },
    "status": 200
}
```

# login
## 一、使用用户名和密码登录
### 通过username和password登录
### URL —— http://192.168.1.237:8080/test/user/login
### 支持格式 —— JSON
### HTTP请求方式 —— POST
### request:
    uName   -- 用户名
    uPassword   -- 密码
    checkCode   -- 验证码
### response:
### 登录成功：
```json
{
    "loginMessage": "登录成功",
    "loginSuccess": true,
    "userImagePath": "http://192.168.1.237:8080/test/images/1.jpg",
    "userData": {
        "uId": 1,
        "uName": "zhangsan",
        "uPassword": "123456",
        "uSignature": "这个人很懒，什么也没有留下.......",
        "uSex": true,
        "uPhone": "0100101",
        "uEmail": "23432"
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

# 创建一项活动
### URL —— http://192.168.1.237:8080/test/activity/createActivity
### 支持格式 —— JSON
### HTTP请求方式 —— POST

### request:
```json
{
    "uId": "1",
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
            "caScore": 12
        },
        {
            "caName": "string",
            "caDayMaxJoin": 5,
            "caIsAvailable": true,
			"caDescription":"String",
            "caScore": 18
        }
    ]
}
```   
        
### response
```json
{
    "createData": {
        "aId": 1,
        "uId": 1,
        "aName": "图灵小活动",
        "aCreationTime": "2019-05-28",
        "aDeadlineTime": "2017-08-12",
        "aParticipation": 12,
        "aAbstract": "你好",
        "aDescription": "helloe",
        "aStatus": 0,
        "aNotice": "helloer",
        "aAddress": null
    },
    "createMessage": "创建成功",
    "createSuccess": true,
    "status": 200
}
```

# 获取单个活动的所用信息

### URL —— http://192.168.1.237:8080/test/activity/getSingleActivity
### 支持格式 —— JSON
### HTTP请求方式 —— POST

### request:
   	aId  活动的id
### response:
- 活动存在
```json
{
    "activityImages": [],
    "activityMessage": {
        "aId": 1,
        "uId": 1,
        "aName": "图灵小活动",
        "aCreationTime": "2019-05-28",
        "aDeadlineTime": "2017-08-12",
        "aParticipation": 12,
        "aAbstract": "你好",
        "aDescription": "helloe",
        "aStatus": 0,
        "aNotice": "helloer",
        "aAddress": null
    },
    "getInfoSuccess": true,
    "status": 200
}
```

- 活动不存在：
```json
{
    "activityImages": null,
    "activityMessage": "该活动不存在",
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
            "aId": 1,
            "uId": 1,
            "aName": "图灵小活动",
            "aCreationTime": "2019-05-28",
            "aDeadlineTime": "2017-08-12",
            "aParticipation": 12,
            "aAbstract": "你好",
            "aDescription": "helloe",
            "aStatus": 0,
            "aNotice": "helloer",
            "aAddress": null
        },
		{
            "aId": 1,
            "uId": 1,
            "aName": "图灵小活动",
            "aCreationTime": "2019-05-28",
            "aDeadlineTime": "2017-08-12",
            "aParticipation": 12,
            "aAbstract": "你好",
            "aDescription": "helloe",
            "aStatus": 0,
            "aNotice": "helloer",
            "aAddress": null
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
    uId     用户名
	aStatus   标志是参照参与的活动还是管理的活动
	0:创建  1:管理   2:参与

### response
```json

```

# 得到大活动下的所有子活动
### URL —— http://192.168.1.237:8080/test/activity/getAllChildActivity
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

# 获取报名表的字段
### URL —— http://192.168.1.237:8080/test/activity/entryFields
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

```json
{
	"aId":int
	"childActivityList": [
        {
		***  以下关于子活动的信息可以不全部发送，但是活动名必须有 ***
            "caName": "String",
            "caDescription": "String",
            "caScore": 12,
			"caDayMaxJoin":12,
            "caISAvailable": true
        },
        {
            "caName": "String",
            "caDescription": "String",
            "caScore": 12,
			"caDayMaxJoin":12,
            "caISAvailable": true
        }
	]
}
```
### response
```json
{
	
}
```


# 发布评论
### URL —— http://192.168.1.237:8080/test/manager/publishMessage
### 支持格式 —— JSON
### HTTP请求格式 —— POST
### request
```json
{
	"aId":int,
	"uId":int,
}
```
### response
```json
{
	"actitivity":{
		
	},
	"userInfo":{
		
	}	
}
```

# 评论
### URL —— http://192.168.1.237:8080/test/manager/comment
### 支持格式 —— JSON
### HTTP请求格式 —— POST
### request
```json
{
	"pId":int,
	"fromUid":int,
	"toUid":int,
	"content":"String",
}
```
