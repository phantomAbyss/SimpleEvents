package test.dataBase.service.impl;

import test.dataBase.dao.ActivityDao;
import test.dataBase.dao.UserDao;
import test.dataBase.dao.impl.ActivityDaoImpl;
import test.dataBase.dao.impl.UserDaoImpl;
import test.dataBase.domain.*;
import test.dataBase.service.ActivityService;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = new ActivityDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public static void main(String[] args) {
        ActivityService activityService = new ActivityServiceImpl();

        //测试获得单个活动的方法
//        Activity activity = activityService.getSingleActivity("吃鸡", "");
//        System.out.println(activity);
        /*UserInfo user = new UserInfo();
        user.setuName("李四");
        List<Activity> activityList = activityService.getActivity(user, -1);
        for(Activity activity : activityList){
            System.out.println(activity);
        }*/
        List<String> paras = new ArrayList<String>();
        paras.add("string");
        activityService.createActivity(10001,paras);
    }

    private final String pathFirst = "http://192.168.1.237:8080/test/images/";

    /**
     * 添加活动信息
     * @param activity
     */
    @Override
    public Activity addActivity(Activity activity,String uName) {
        //通过用户名查找用户id
        UserInfo user = userDao.getUserByuName(uName);
        if(user == null){
            return null;
        }
        activity.setuId(user.getuId());
        activityDao.add(activity);
        return activityDao.findActivityByaNameAnduId(activity.getaName(), activity.getuId());
    }

    @Override
    public List<Activity> getAllActivity() {

        List<Activity> activityList = activityDao.getMainActivity();
        for(Activity activity : activityList){
            String picturePath = activity.getaPicturePath();
            picturePath = pathFirst + picturePath;
            activity.setaPicturePath(picturePath);
        }
        return activityList;
    }

    @Override
    public Activity getSingleActivity(String aName,String uName) {
        //通过用户名查找该用户id
        UserInfo user = userDao.getUserByuName(uName);
        if(!"".equals(aName) && aName != null){
            //通过活动名称和创建该活动的id得到该活动
            return activityDao.findActivityByaNameAnduId(aName, user == null ? 0 : user.getuId());
        }
        return null;

    }

    @Override
    public List<Activity> getActivity(UserInfo user, int status) {
        //通过用户名得到该用户的id
        UserInfo temp = userDao.getUserByuName(user.getuName());

        if(temp == null){
            return null;
        }
        //通过用户的uId查询它所有参加活动的caId
        List<RelationInfo> relationList = activityDao.getActivityByuId(temp.getuId());
        if(relationList == null){
            return null;
        }
        //通过得到的用户参与的活动的caId得到该用户所有参与的活动
        //防止重复
        List<Activity> participationList = new ArrayList<Activity>();
        Set<Integer> aIdSet = new TreeSet<Integer>();
        //遍历得到所有用户和活动关联的信息，得到该用户参加的所有活动
        for(RelationInfo relation : relationList){
            if(status == relation.getUaRelation()){
                int aId = activityDao.findChildActivityBycaId(relation.getCaId());
                //通过子活动找到主活动
                aIdSet.add(aId);
            }
        }
        for(Integer aId : aIdSet){
            if(aId == -1){
                continue;
            }
            Activity activity = activityDao.findActivityByaId(aId);
            //更新图片路径
            String picturePath = activity.getaPicturePath();
            picturePath = pathFirst + picturePath;
            activity.setaPicturePath(picturePath);
            participationList.add(activity);
        }
        return participationList;
    }

    /**
     * 创建活动表
     * @param aId
     * @param parameters
     */
    @Override
    public void createActivity(int aId, List<String> parameters) {
        Activity activity = activityDao.findActivityByaId(aId);
        if(activity == null){
            return;
        }
        String aName = activity.getaName();
        if("".equals(aName)){
            aName = "该活动还没有名字哟";
        }
        /*try {
            aName = new String(aName.getBytes("utf-8"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        String tableName = aName + aId;
        List<String> pars = new ArrayList<String>();
        for(String parm : parameters){
            System.out.println(parm);
            if(parm == null || "null".equals(parm))
                continue;

            pars.add(parm);
        }
        activityDao.enrollTable(tableName, pars);
    }

    /**
     * 添加子活动
     * @param childActivityList
     */
    @Override
    public void addChildActivity(List<ChildActivity> childActivityList) {
        if(childActivityList != null){
            for(ChildActivity childActivity : childActivityList){
                activityDao.addChildActivity(childActivity);
            }
        }

    }
    /**
     * 添加子活动
     * @param childActivity
     */
    @Override
    public void addChildActivity(ChildActivity childActivity) {
        if(childActivity != null){
            activityDao.addChildActivity(childActivity);
        }

    }

    @Override
    public boolean updateScores(String uName, String aName, String caName) {
        //通过用户名获得参加该活动的用户的信息
        UserInfo user = userDao.getUserByuName(uName);
        //通过主活动的名称查询主活动
        Activity activity = activityDao.findActivityByaNameAnduId(aName, 0);
        //得到对应的子活动
        ChildActivity childActivity = activityDao.findChildActivityByCaNameAndaId(caName, activity.getaId());
        activityDao.updateScore(user.getuId(),childActivity.getScore());
        return true;
    }
    @Override
    public Activity cancelActivity(String uName, String aName) {
        //通过用户名查找该用户
        UserInfo user = userDao.getUserByuName(uName);
        //通过用户id和活动名称查询该活动是否存在
        Activity activity = activityDao.findActivityByaNameAnduId(aName, user.getuId());
        if(activity == null){
            return null;
        }
        //更新活动的状态
        activityDao.updateActivityStatus(activity.getaId());
        String picture = activity.getaPicturePath();
        picture = pathFirst + picture;
        activity.setaPicturePath(picture);
        return activity;
    }

    @Override
    public void addFieldNotice(int aId,List<FieldInfo> fieldInfoList) {
        if(aId >= 0 && fieldInfoList != null){
            for(FieldInfo field : fieldInfoList){
                activityDao.addNotice(aId,field);
            }
        }
    }

    @Override
    public List<ChildActivity> getAllChildActivity(int aId,String aName) {
        return activityDao.getAllChildActivity(aId,aName);
    }

    @Override
    public Activity getSingleActivity(int aId) {
        if(aId != 0){
            return activityDao.findActivityByaId(aId);
        }
        return null;
    }
}
