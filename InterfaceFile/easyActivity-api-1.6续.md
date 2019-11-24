- # updateuName
- ### 接口描述：该接口用于修改用户名
- ### URI —— /user/updateuName
- ### HTTP请求方式 —— POST
- ### 支持格式 —— JSON
- ### request  —— 请求参数
- uId  用户的id
- uName 修改后的uName
- ### response —— 响应参数
 ```json
 {
	"status":200,
	"updateMessage":"用户名修改成功",
	"updateSuccess":true	
 }
 ```

- # updatePassword
- ### 接口描述：该接口用于修改密码
- ### URI —— /user/updatePassword
- ### HTTP请求方式 —— POST
- ### 支持格式 —— JSON
- ### request  —— 请求参数
- uId  用户的id
- uPassword 修改后的密码
- ### response —— 响应参数
 ```json
 {
	"status":200,
	"updateMessage":"密码修改成功",
	"updateSuccess":true	
 }
 ```

- # updateSignature
- ### 接口描述：该接口用于修改用户签名
- ### URI —— /user/updateSignature
- ### HTTP请求方式 —— POST
- ### 支持格式 —— JSON
- ### request  —— 请求参数
- uId  用户的id
- ### response —— 响应参数
 ```json
 {
	"status":200,
	"updateMessage":"用户签名修改成功",
	"updateSuccess":true	
 }
 ```

- # updatePhone
- ### 接口描述：该接口用于用户电话
- ### URI —— /user/updatePhone
- ### HTTP请求方式 —— POST
- ### 支持格式 —— JSON
- ### request  —— 请求参数
- uId  用户的id
- ### response —— 响应参数
 ```json
 {
	"status":200,
	"updateMessage":"用户电话号码修改成功",
	"updateSuccess":true	
 }
 ```
- # updateEmail
- ### 接口描述：该接口用于用户邮箱
- ### URI —— /user/updateEmail
- ### HTTP请求方式 —— POST
- ### 支持格式 —— JSON
- ### request  —— 请求参数
- uId  用户的id
- ### response —— 响应参数
 ```json
 {
	"status":200,
	"updateMessage":"用户邮箱修改成功",
	"updateSuccess":true	
 }
 ```

- # updateNotice
- ### 接口描述：该接口用于更新活动公告
- ### URI —— /activity/updateNotice
- ### HTTP请求方式 —— POST
- ### 支持格式 —— JSON
- ### request  —— 请求参数
- aId  活动的id
- aNotice 待更新的活动公告的内容
- ### response —— 响应参数
 ```json
 {
	"status":200,
	"updateMessage":"活动公告更新成功",
	"updateSuccess":true	
 }
 ```

- # updateAddress
- ### 接口描述：该接口用于更新活动地点
- ### URI —— /activity/updateAddress
- ### HTTP请求方式 —— POST
- ### 支持格式 —— JSON
- ### request  —— 请求参数
- aId  活动的id
- aAddress 待更新的活动的地点
- ### response —— 响应参数
 ```json
 {
	"status":200,
	"updateMessage":"活动地点更新成功",
	"updateSuccess":true	
 }
 ```

- # updateDescription
- ### 接口描述：该接口用于更新活动描述
- ### URI —— /activity/updateDescription
- ### HTTP请求方式 —— POST
- ### 支持格式 —— JSON
- ### request  —— 请求参数
- aId  活动的id
- aDescription 待更新的活动的描述
- ### response —— 响应参数
 ```json
 {
	"status":200,
	"updateMessage":"活动描述更新成功",
	"updateSuccess":true	
 }
 ```
- # exportExcel
- ### 接口描述：该接口用户将用户信息导出到用户的邮箱
- ### URI —— /manager/exportExcel
- ### HTTP请求方式 —— POST
- ### 支持格式 —— JSON
- ### request —— 请求参数
- uId 需要导出的用户的id
- aId 需要导出的活动的id
- ### reponse —— 响应参数
- #### 报名表导出成功
 ```json
 {
	"status":200,
	"exportMessage":"报名信息导出成功",
	"exportSuccess":true	
 }
 ``` 
- #### 报名表信息导出失败
```json
 {
	"status":200,
	"exportMessage":"报名信息导出失败，请检查是员否连接网络或者联系管理员",
	"exportSuccess":false	
 }
 ``` 

