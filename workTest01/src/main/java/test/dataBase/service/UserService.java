package test.dataBase.service;


import test.dataBase.domain.UserInfo;

public interface UserService {
    /**
     * 通过用户名和密码登录
     * @param user
     * @return
     */
    UserInfo login(UserInfo user);

    /**
     * 通过第三方登录
     * @param thirdKey
     * @return
     */
    UserInfo loginByThird(String thirdKey);

    /**
     * 判断用户名是否已经存在于数据库
     * @param username
     * @return
     */
    UserInfo isUsername(String username);

    /**
     *
     * @param id
     * @return
     */
    UserInfo loginById(int id);
    /**
     * 用户注册
     * @param registerUser
     * @return
     */
    UserInfo register(UserInfo registerUser);

    /**
     * 通过uId得到对应的用户信息
     * @param uId
     * @return
     */
    UserInfo getUserInfo(int uId);


    /**
     * 通过uId获取对应用户的头像图片
     * @param uId
     * @return
     */
    String getUserImage(int uId);

    /**
     * 给用户添加默认图片
     * @param uId
     * @param image
     * @return
     */
    String addUserImage(int uId,String image);
}
