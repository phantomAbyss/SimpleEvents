package test.dataBase.service;

import test.dataBase.domain.Activity;
import test.dataBase.domain.ChildActivity;
import test.dataBase.domain.FieldInfo;
import test.dataBase.domain.UserInfo;

import java.util.List;
import java.util.Map;

public interface ActivityService {

    /**
     * 添加新建活动信息
     * @param activity
     */
    public Activity addActivity(Activity activity,String uName);
    /**
     * 获取所有活动
     * @return
     */
    List<Activity> getAllActivity();

    /**
     * t通过活动名称和创建该用户的用户名
     * @param aName
     * @param uName
     * @return
     */
    Activity getSingleActivity(String aName, String uName);

    /**
     * 通过用户名查询该用户查询的所有活动
     * @param user
     * @return
     */
    List<Activity> getActivity(UserInfo user, int status);

    /**
     * 创建活动表
     * @param parameterMap
     */
    void createActivity(int aId, List<String> parameters);

    /**
     * 添加子活动
     * @param childActivity
     */
    void addChildActivity(List<ChildActivity> childActivityList);
    /**
     * 添加子活动
     * @param childActivity
     */
    void addChildActivity(ChildActivity childActivity);

    /**
     * 上传子活动的活动积分
     * @param uName
     * @param aName
     * @param caName
     * @return
     */
    boolean updateScores(String uName, String aName, String caName);

    /**
     * 删除某项活动
     * @param uName
     * @param aName
     * @return
     */
    Activity cancelActivity(String uName, String aName);

    /**
     * 添加字段说明
     * @param aId
     * @param fieldInfoList
     */
    void addFieldNotice(int aId,List<FieldInfo> fieldInfoList);


    /**
     * 通过大活动的名称查询所有子活动
     * @param aName
     * @return
     */
    List<ChildActivity> getAllChildActivity(int aId,String aName);

    /**
     * 通过aId获取活动信息
     * @param aId
     * @return
     */
    Activity getSingleActivity(int aId);


}
