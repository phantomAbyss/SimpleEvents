package test.dataBase.dao;


import test.dataBase.domain.Activity;
import test.dataBase.domain.ChildActivity;
import test.dataBase.domain.FieldInfo;
import test.dataBase.domain.RelationInfo;

import java.util.List;

public interface ActivityDao {
    /**
     * 通过活动创建时间查询活动信息
     * @param creationtime
     * @return
     */
    Activity findActivityByaNameAnduId(String aName, int uId);
    /**
     * 通过用户id查询该用户参与的活动的id
     * @param uId
     * @return
     */
    List<RelationInfo> getActivityByuId(int uId);

    /**
     * 通过活动id查询子活动
     * @param getuName
     * @return
     */
    int findChildActivityBycaId(int caId);

    /**
     * 通过主活动id查询所有信息
     * @param getaId
     * @return
     */
    Activity findActivityByaId(int aId);
    /**
     * 动态创建活动的报名表
     * @param datas
     * @return
     */
    void enrollTable(String tableName, List<String> parms);

    /**
     * 在大活动表中添加一项活动
     * @param activity
     * @return
     */
    void add(Activity activity);


    /**
     * 查询所有的活动信息
     * @return
     */
    List<Activity> getMainActivity();

    /**
     * 添加子活动
     * @param childActivity
     */
    void addChildActivity(ChildActivity childActivity);

    /**
     *
     * @param caName
     * @return
     */
    ChildActivity findChildActivityByCaNameAndaId(String caName, int aId);

    /**
     * 更新该用户的积分数
     * @param getaId
     * @param score
     */
    void updateScore(int uId, int score);

    /**
     * 更新活动的状态
     * @param getaId
     */
    void updateActivityStatus(int aId);

    /**
     * 添加字段说明
     * @param aId
     * @param fieldInfo
     */
    void addNotice(int aId, FieldInfo fieldInfo);

    /**
     * 得到所有子活动
     * @param aId
     * @return
     */
    List<ChildActivity> getAllChildActivity(int aId,String aName);

    /**
     * 通过表名得到字段
     * @param tableName
     * @return
     */
    List<String> getNames(String tableName);

}
