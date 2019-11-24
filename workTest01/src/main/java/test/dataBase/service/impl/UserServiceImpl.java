package test.dataBase.service.impl;

import test.dataBase.dao.UserDao;
import test.dataBase.dao.impl.UserDaoImpl;
import test.dataBase.domain.UserInfo;
import test.dataBase.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private final String pathFirst = "http://192.168.1.237:8080/test/images/";


    @Override
    public UserInfo login(UserInfo user) {
        UserInfo loginUser = userDao.loginByUsernameAndPassword(user.getuName(), user.getuPassword());
        if(loginUser == null) {
            return null;
        }
        return loginUser;
    }

    @Override
    public UserInfo loginByThird(String thirdKey) {
        return userDao.loginByThird(thirdKey);
    }

    @Override
    public UserInfo isUsername(String username) {
        return userDao.loginByUsername(username);
    }

    @Override
    public UserInfo loginById(int id) {
        return userDao.loginById(id);
    }



    @Override
    public UserInfo register(UserInfo user) {
        //通过用户名查询
        UserInfo temp = userDao.getUserByuName(user.getuName());
        if(temp != null){
            //用户名已经存在
            return null;
        }
        //保存用户
        userDao.save(user);
        UserInfo registerUser = userDao.getUserByuName(user.getuName());
        return registerUser;
    }

    @Override
    public UserInfo getUserInfo(int uId) {
        return userDao.findUserByuId(uId);
    }

    @Override
    public String getUserImage(int uId) {
        String image = userDao.getImage(uId,0);
       return pathFirst + image;
    }

    @Override
    public String addUserImage(int uId,String image) {
        //添加用户头像
        userDao.addImage(uId,image);
        return pathFirst + image;
    }


}
