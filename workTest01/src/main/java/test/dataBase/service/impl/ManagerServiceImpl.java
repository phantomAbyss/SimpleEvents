package test.dataBase.service.impl;


import test.dataBase.dao.ActivityDao;
import test.dataBase.dao.ManagerDao;
import test.dataBase.dao.UserDao;
import test.dataBase.dao.impl.ActivityDaoImpl;
import test.dataBase.dao.impl.MangerDaoImpl;
import test.dataBase.dao.impl.UserDaoImpl;
import test.dataBase.domain.*;
import test.dataBase.service.ManagerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerServiceImpl implements ManagerService {
    private UserDao userDao = new UserDaoImpl();
    private ActivityDao activityDao = new ActivityDaoImpl();
    private ManagerDao managerDao = new MangerDaoImpl();
    private final String pathFirst = "http://192.168.1.237:8080/test/images/";

    @Override
    public boolean addManager(String uName, String aName) {
        //通过用户名得到用户信息
        UserInfo user = userDao.getUserByuName(uName);
        if(user == null){
            return false;
        }
        //活动名称得到活动信息
        Activity activity = activityDao.findActivityByaNameAnduId(aName, 0);
        if(activity == null){
            return false;
        }
        //调用add方法添加管理员
        managerDao.add(user.getuId(),activity.getaId());
        return true;
    }

    @Override
    public boolean addManager(int uId, int aId) {
        if(uId >= 0 && aId >= 0){
            managerDao.add(uId,aId);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteManager(String uName, String aName) {
        //通过用户名得到用户信息
        UserInfo user = userDao.getUserByuName(uName);
        if(user == null){
            return false;
        }
        //活动名称得到活动信息
        Activity activity = activityDao.findActivityByaNameAnduId(aName, 0);
        if(activity == null){
            return false;
        }
        //调用managerDao删除该管理员
        managerDao.delete(user.getuId(),activity.getaId());
        return true;
    }

    @Override
    public boolean deleteManager(int uId, int aId) {
        if(uId >= 0 && aId >= 0){
            managerDao.delete(uId,aId);
            return true;
        }
        return false;
    }

    @Override
    public List<RankInfo> rankList(int aId, String aName,int flag) {
        //得到排序后的信息
        List<UserActivityInfo> rank = managerDao.rank(aId, flag);
        if(rank == null){
            return null;
        }
        //存储排序后的具体信息
        List<RankInfo> rankInfoList = new ArrayList<RankInfo>();
        for(UserActivityInfo userActivityInfo : rank){
            //设置排行信息
            RankInfo rankInfo = new RankInfo();
            //rankInfo.setActivity(activity);
            int uId = userActivityInfo.getuId();
            UserInfo user = userDao.getUserByuId(uId);
            String avatarUrl = user.getuAvatarUrl();
            avatarUrl = pathFirst + avatarUrl;
            user.setuAvatarUrl(avatarUrl);
            rankInfo.setUser(user);
            rankInfo.setTotalScore(userActivityInfo.getTotalScore());
            //存储排名用户
            rankInfoList.add(rankInfo);

        }
        return rankInfoList;
    }

    @Override
    public Map<String,String> getNames(int aId) {
        List<FieldInfo> names = managerDao.getNames(aId);
        Map<String,String> fields = new HashMap<String,String>();
        for(FieldInfo name : names){
            fields.put(name.getName(),name.getNotice());
        }
        return fields;
    }

    @Override
    public void signUp(SignUpInfo signUpInfo) {
        managerDao.signUp(signUpInfo);

    }


}
