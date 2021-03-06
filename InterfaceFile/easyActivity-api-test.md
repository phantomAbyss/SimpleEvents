## register
- 接口描述：该接口用于注册，返回是否注册成功
- URI —— /user/register
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request  —— 请求参数

	|名称|必填|备注|
	|:----:|:----:|:----:|
	|uName|是|用户名|
	|uPassword|是|用户密码|
	|uSignature|否|用户签名|
	|uSex|是|用户性别|
	|uPhone|是|用户手机号码|
	|uEmail|否|用户邮箱|
	|&nbsp;|&nbsp;|&nbsp;|
	|userImage|否|用户头像图片|

- response —— 响应参数
<font color=-990000 size=4 face="黑体">注册成功：</font>
	```json
	{
		"status":200,
		"registerMessage":"注册成功",
		"registerSuccess":true,
		"registerTime":1482213602000
	}
	```
	<font color=-990000 size=4 face="黑体">注册失败：</font>
	<font color=-990000 size=3 face="黑体">用户名已存在</font>
	```json
	{
		"status":200,
		"registerMessage":"注册失败，用户名已存在",
		"registerSuccess":false,
		"registerTime":1482213602000
	}
	```
## login
- 接口描述:登录成功后，返回该用户的基础信息
- URI —— /user/login
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request  —— 请求参数

	|名称|必填|备注
	|:----|:----:|:----:|
	|uName|是|用户名|
	|uPassword|是|用户密码|
	|checkCode|是|验证码，***暂时未使用，可不传该参数***|

- response  —— 响应参数

	|名称|类型|备注|
	|:----:|:----:|:----:|
	|uId|int|用户id,唯一|
	|uName|String|用户名|
	|uPassword|String|用户密码|
	|uSignature|String|用户签名|
	|uSex|boolean|用户性别|
	|uPhone|String|用户电话|
	|uEmail|String|用户邮箱|
	|&nbsp;|&nbsp;|&nbsp;|
	|registerTime|long|注册时间|
	|userImage|String|用户头像，链接后面为时间戳|
	<font color=-990000 size=4 face="黑体">登录成功：</font>
	```json
	{
		"status":200,
		"loginMessage":"登录成功",
		"loginSuccess":true,
		"loginTime":1482213602000,
		"userImage":"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
		"userData":{
			"uId":1,
			"uName":"李四",
			"uPassword":"123456",
			"uSignature":"这个人很懒，什么也没有留下",
			"uSex":false,
			"uPhone":"15320749549",
			"uEmail":"wy911@163.com",
		}
	}
	```
	<font color=-990000 size=4 face="黑体">登录失败：</font>
	```json
	{
		"status":200,
		"loginMessage":"登录失败，用户名或者密码输入错误",
		"loginSuccess":false,
		"loginTime":1482213602000,
		"userImage":"",
		"userData":{

		}
	}
	```

## getAllActivity
- 接口描述：获取所有活动的详细信息，图片数
- URI —— /activity/getAllActivity
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request  —— 请求参数
	无
- response —— 响应参数
	```json
	{
	"status":200,
	"getMessage":"数据获取成功",
	"getSuccess":true,
	"activityData":[
		{
			"aId":1,
			"uId":2,
			"pId":1,
			"aName":"图灵小活动",
			"aCreationTime":"2019-05-19",
			"aDeadlineTime":"2020-04-23",
			"aPartionpation":23,
			"aAbstract":"活动摘要",
			"aDescreption":"活动描述",
			"aStatus":true,
			"aNotice":"活动公告",
			"aAddress":"活动地点",
			"images":[
				"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
				"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
				"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000"
			]
		},
		{
			"aId":2,
			"uId":1,
			//"pId":[1,2,3,4],
			"aName":"图灵小活动",
			"aCreationTime":"2019-05-19",
			"aDeadlineTime":"2020-04-23",
			"aPartionpation":23,
			"aAbstract":"活动摘要",
			"aDescreption":"活动描述",
			"aStatus":true,
			"aNotice":"活动公告",
			"aAddress":"活动地点",
			"images":[
				"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
				"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
				"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000"
			]
		}
	]
	}
	```


## getSingleActivity
- 接口描述：根据活动的id获取单个活动所有信息,包括图片，子活动
- URI —— /activity/getSingleActivity
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数
	|名称|必填|备注
	|:----:|:----:|:----:|
	|aId|是|活动的id|
- response —— 响应参数
	```json
	{
		"status":200,
		"getMessage":"活动信息获取成功",
		"getSuccess":true,
		"activityData":{
			"aId":2,
			"uId":1,
			"aName":"图灵小活动",
			"aCreationTime":"2019-05-19",
			"aDeadlineTime":"2020-04-23",
			"aPartionpation":23,
			"aAbstract":"活动摘要",
			"aDescreption":"活动描述",
			"aStatus":true,
			"aNotice":"活动公告",
			"aAddress":"活动地点",
			"images":[
				"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
				"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
				"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000"
			]
		},
		"childActivityData":[
			{
				"caId":4,
				"aId":5,
				"caName":"子活动",
				"caDescription":"子活动描述",
				"caScore":12,
				"caDayMaxJoin":4,
				"caIsAvailable":true
			},
			{
				"caId":3,
				"aId":6,
				"caName":"子活动",
				"caDescription":"子活动描述",
				"caScore":8,
				"caDayMaxJoin":4,
				"caIsAvailable":false
			}
		]
	}
	```

## createActivity
- 接口描述：该接口实现创建一项活动的功能
- URI —— /activity/createActivity
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数
	```json
	{
	    "activity": {
			"uId":1,
			"aName":"图灵小活动",
			"aDeadlineTime":"2020-04-23",
			"aAbstract":"活动摘要",
			"aDescreption":"活动描述",
			"aAddress":"活动地点"
	    },
	    "fieldList": [
	        {
	            "name": "学号",
	            "notice": "学生的唯一标识"
	        },
	        {
	            "name": "身份证号码",
	            "notice": "身份证号码"
	        }
	    ],
	    "childActivityList": [
	        {
				"caName":"子活动",
				"caDescription":"子活动描述",
				"caScore":8,
				"caDayMaxJoin":4
	        },
	        {
				"caName":"子活动",
				"caDescription":"子活动描述",
				"caScore":8,
				"caDayMaxJoin":4
	        }
	    ]
	}
	```
- response —— 响应参数
<font color=-990000 size=4 face="黑体">创建成功：</font>
	```json
	{
		"status":200,
		"aId":3,
		"createMessage":"创建成功",
		"createSuccess":true
	}
	```
	<font color=-990000 size=4 face="黑体">创建失败：</font>
	***aId=-1表示该活动没有创建成功***
	```json
	{
		"status":200,
		"aId":-1,
		"createMessage":"创建失败",
		"createSuccesss":false;
	}
	```

## getActivity
- 接口描述：得到管理、创建或者参与的活动
- URI —— /activity/getActivity
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数

	|名称|必填|备注
	|:----:|:----:|:----:|
	|uId|是|需要查找的用户id|
	|flag|是|标志，0:创建  1:管理   2:参与|
- response —— 响应参数
	```json
	{
		"status":200,
		"getMessage":"获取成功",
		"getSuccess":true,
		"activityData":[
			{
				"aId":1,
				"uId":2,
				"aName":"图灵小活动",
				"aCreationTime":"2019-05-19",
				"aDeadlineTime":"2020-04-23",
				"aPartionpation":23,
				"aAbstract":"活动摘要",
				"aDescreption":"活动描述",
				"aStatus":true,
				"aNotice":"活动公告",
				"aAddress":"活动地点",
				"images":[
					"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
					"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
					"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000"
				]
			},
			{
				"aId":1,
				"uId":2,
				"aName":"图灵小活动",
				"aCreationTime":"2019-05-19",
				"aDeadlineTime":"2020-04-23",
				"aPartionpation":23,
				"aAbstract":"活动摘要",
				"aDescreption":"活动描述",
				"aStatus":true,
				"aNotice":"活动公告",
				"aAddress":"活动地点",
				"images":[
					"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
					"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
					"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000"
				]
			}
		]
	}
	```
## getAllChildActivity
- 接口描述：得到一个大活动下的所有子活动
- URI —— /activity/getAllChildActivity
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数
	|名称|必填|备注
	|:----:|:----:|:----:|
	|aId|是|活动的id|

- response —— 响应参数
	```json
	{
		"status":200,
		"getMessage":"获取子活动信息成功",
		"getSuccesss":true,
		"childActivityData":[
			{
				"caId":5,
				"aId":3,
				"caName":"子活动1",
				"caDescription":"子活动1的描述",
				"caScore":12,
				"caDayMaxJoin":3,
				"caIsAvailable":true
			},
			{
				"caId":5,
				"aId":5,
				"caName":"子活动2",
				"caDescription":"子活动2的描述",
				"caScore":12,
				"caDayMaxJoin":3,
				"caIsAvailable":true
			}
		]
	}
	```

## getActivityFields
- 接口描述：获得一个大活动的所有报名字段
- URI —— /manager/getActivityFields
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数

	|名称|必填|备注
	|:----:|:----:|:----:|
	|aId|是|活动的id|
- response —— 响应参数
	```json
	{
		"status":200,
		"getMessage":"字段信息获取成功",
		"getSuccess":true,
		"fields":[
			{
				"fid":2,
				"name":"学号",
				"notice":"学号说明"
			},
			{
				"fid":4,
				"name":"姓名",
				"notice":"姓名的提示信息"
			}
		]
	}
	```

## addChildActivity
- 接口描述：添加子活动
- URI —— /manager/addChildActivity
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数

	|名称|必填|备注
	|:----:|:----:|:----:|
	|aId|是|活动的id|
	|childActivityData|是|待添加的子活动的信息|
	```json
	{
		"aId":3,
		"childActivityData":[
			{
				"caName":"子活动1",
				"caDescription":"子活动1的描述",
				"caScore":8,
				"caDayMaxJoin":4,
				"caIsAvailable":false
			},
			{
				"caName":"子活动2",
				"caDescription":"子活动2的描述",
				"caScore":8,
				"caDayMaxJoin":4,
				"caIsAvailable":false
			}
		]
	}
	```
- response —— 响应参数
	<font color=-990000 size=4 face="黑体">添加成功：</font>
	```json
	{
		"status":200,
		"addMessage":"添加成功",
		"addSuccess":true
	}
	```
	<font color=-990000 size=4 face="黑体">添加失败：</font>
	```json
	{
		"status":200,
		"addMessage":"添加失败",
		"addSuccess":false
	}
	```

## signUp
- 接口描述：该接口为填写报名信息
- URI —— /manager/signUp
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数

	|名称|必填|备注
	|:----:|:----:|:----:|
	|aId|是|报名活动的id|
	|uId|是|报名的用户的id|
	|signUpMessage|是|用户报名的信息|
	|childActivity|是|用户参加的子活动caId|
	```json
	{
		"aId":3,
		"uId":3,
		"signUpMessage":[
			{
				"fId":3,
				"uId":4,
				"content":"字段1的报名内容",
			},
			{
				"fId":3,
				"uId":5,
				"content":"字段2的报名内容",
			}
		],
		"childActivity":[
			1,
			3
		]
	}
	```
- response —— 响应参数
	<font color=-990000 size=4 face="黑体">报名成功：</font>
	```json
	{
		"status":200,
		"signUpMessage":"报名成功",
		"signUpSuccess":true
	}
	```
	<font color=-990000 size=4 face="黑体">报名失败：</font>
	```json
	{
		"status":200,
		"signUpMessage":"报名失败，请重新报名",
		"signUpSuccess":false
	}
	```
## publishMessage
- 接口描述:该接口的功能为发布动态
- URI —— /manager/publishMessage
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数

	|名称|必填|备注
	|:----:|:----:|:----:|
	|aId|否|该动态对应的活动的id|
	|uId|是|创建该活动的用户的id|
	|content|是|用户或者系统的评论内容|

- response —— 响应参数
	<font color=-990000 size=4 face="黑体">动态发布成功：</font>
	```json
	{
		"status":200,
		"pId":1,
		"publishMessage":"发布动态成功",
		"publishSuccess":true
	}
	```
	<font color=-990000 size=4 face="黑体">动态发布失败：</font>
	***pId=-1表示动态发布失败***
	```json
	{
		"status":200,
		"pId":-1
		"publishMessage":"发布动态失败",
		"publishSuccess":false
	}
	```

## comment
- 接口描述：该接口用于评论活动或者对其他人的评论进行评论
- URI —— /manager/comment
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数

	|名称|必填|备注
	|:----:|:----:|:----:|
	|pId|是|表示对那一条动态进行评论|
	|fromUid|是|表示是谁发布的该条评论|
	|toCid|是|表示这条评论是对那一条评论发布的的，<br>***toCid=0表示该条评论是对动态发布的***|
	|content|是|该评论的内容|
- response —— 响应参数
	<font color=-990000 size=4 face="黑体">评论发布成功：</font>
	```json
	{
		"status":200,
		"commentMessage":"评论发布成功",
		"commentSuccesss":true
	}
	```
	<font color=-990000 size=4 face="黑体">评论发布失败：</font>
	```json
	{
		"status":200,
		"commentMessage":"评论发布失败",
		"commentSuccesss":false
	}
	```

## addManager
- 接口描述:该接口的功能为活动添加管理员
- URI —— /manager/addManager
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数

	|名称|必填|备注
	|:----:|:----:|:----:|
	|uId(int)|是|待添加的用户的id|
	|aId(int)|是|管理的活动的id|
	|mDeadlineTime(long)|是|管理员截止的时间|
	```json
	{
		"uId":1,
		"aId":3,
		"managerData":[
			{
				"caId":2,
				"mDeadlineTime":123232321
			},
			{
				"caId":3,
				"mDeadlineTime":123232321
			}
		]
	}
	```
- response —— 响应参数
	<font color=-990000 size=4 face="黑体">添加失败：</font>
	```json
	{
		"status":200,
		"addMessage":"添加成功",
		"addSuccess":true
	}
	```
	<font color=-990000 size=4 face="黑体">添加成功：</font>
	```json
	{
		"status":200,
		"addMessage":"添加失败",
		"addSuccess":false
	}
	```

## deleteManager
- 接口描述:该接口的功能为活动添加管理员
- URI —— /manager/deleteManager
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数

	|名称|必填|备注
	|:----:|:----:|:----:|
	|uId|是|待删除的用户的id|
	|caId|是|管理的活动的caId|

- response —— 响应参数
	<font color=-990000 size=4 face="黑体">删除成功：</font>
	```json
	{
		"status":200,
		"addMessage":"删除成功",
		"addSuccess":true
	}
	```
	<font color=-990000 size=4 face="黑体">删除失败：</font>
	```json
	{
		"status":200,
		"addMessage":"删除失败",
		"addSuccess":false
	}
	```
## getActivityImage
- 接口描述:该接口可以获取活动的所有图片
- URI —— /manager/comment
- HTTP请求方式 —— POST
- 支持格式 —— JSON
- request —— 请求参数

	|名称|必填|备注
	|:----:|:----:|:----:|
	|aId|是|活动的id|
- response —— 响应参数
	<font color=-990000 size=4 face="黑体">获取成功：</font>
	```json
	{
		"status":200,
		"getMessage":"获取图片成功",
		"getSuccess":true,
		"activityImages":[
			"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000",
			"http://192.168.1.237:8080/test/images/1.jpg?time=1482213602000"
		]
	}
	```
