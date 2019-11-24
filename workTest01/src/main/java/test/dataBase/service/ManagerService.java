package test.dataBase.service;

import test.dataBase.domain.RankInfo;
import test.dataBase.domain.SignUpInfo;
import test.dataBase.domain.UserActivityInfo;

import java.util.List;
import java.util.Map;

public interface ManagerService {

    /**
     * 添加管理员
     * @param uName
     * @param aName
     * @return
     */
    boolean addManager(String uName, String aName);

    /**
     * 添加管理员
     * @param uId
     * @param aId
     * @return
     */
    boolean addManager(int uId,int aId);

    /**
     * 删除管理员
     * @param uName
     * @param aName
     * @return
     */
    boolean deleteManager(String uName, String aName);

    /**
     * 删除管理员
     * @param uId
     * @param aId
     * @return
     */
    boolean deleteManager(int uId,int aId);

    /**
     * 得到该活动排序后的结果
     * @param aId
     * @param aName
     * @return
     */
    List<RankInfo> rankList(int aId, String aName, int flag);

    /**
     * 获取表名字段
     * @param tableName
     * @return
     */
    Map<String,String> getNames(int aId);

    /**
     * 添加报名信息
     * @param aName
     * @param aId
     * @param fieldsInfo
     */
    void signUp(SignUpInfo signUpInfo);
}
