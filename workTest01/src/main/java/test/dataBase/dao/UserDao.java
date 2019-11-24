package test.dataBase.dao;

import test.dataBase.domain.UserInfo;

import java.util.List;

public interface UserDao {
    //通过用户名查找
    UserInfo loginByUsername(String username);

    /**
     * 通过用户名和密码登录
     * @param username
     * @param password
     * @return
     */
    UserInfo loginByUsernameAndPassword(String username, String password);
    //通过第三方登录的为一个标识码查找
    UserInfo loginByThird(String thirdKey);

    //通过用户id查找用户信息
    UserInfo loginById(int id);


    /**
     * 保存重新注册的用户
     * @param user
     */
    void save(UserInfo user);


    /**
     * 通过用户名查找用户
     * @param uName
     * @return
     */
    UserInfo getUserByuName(String uName);

    /**
     * 通过用户id查找用户
     * @param uId
     * @return
     */
    UserInfo getUserByuId(int uId);


    /**
     * 通过用户uId得到用户信息
     * @param uId
     * @return
     */
    UserInfo findUserByuId(int uId);

    /**
     * 通过uId获得用户的头像图片
     * @param uId
     * @return
     */
    String getImage(int uId,int flag);

    /**
     * 给用户添加默认图片
     * @param uId
     * @param image
     */
    void addImage(int uId,String image);
}
