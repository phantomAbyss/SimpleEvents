package test.dataBase.dao;


import test.dataBase.domain.FieldInfo;
import test.dataBase.domain.SignUpInfo;
import test.dataBase.domain.UserActivityInfo;

import java.util.List;
import java.util.Map;

public interface ManagerDao {

    /**
     * 添加管理员
     * @param uId
     * @param aId
     */
    void add(int uId, int aId);


    /**
     * 删除管理员
     * @param uId
     * @param aId
     */
    void delete(int uId, int aId);

    /**
     * 排序，true升序排序，false降序排列
     * @param aId
     * @param flag
     * @return
     */
    List<UserActivityInfo> rank(int aId,int flag);


    /**
     * 通过表名获得字段名
     * @param aId
     * @return
     */
    List<FieldInfo> getNames(int aId);

    /**
     * 填写报名信息
     * @param signUpInfo
     */
    void signUp(SignUpInfo signUpInfo);
}
