package test.dataBase.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dataBase.dao.ManagerDao;
import test.dataBase.domain.FieldInfo;
import test.dataBase.domain.SignUpInfo;
import test.dataBase.domain.UserActivityInfo;
import test.dataBase.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class MangerDaoImpl implements ManagerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void add(int uId, int aId) {
        String sql = "insert into manager values(?,?)";
        template.update(sql,aId,uId);

    }

    @Override
    public void delete(int uId, int aId) {
        String sql = "delete from manager where aId = ? and uId = ?";
        template.update(sql,aId,uId);
    }

    @Override
    public List<UserActivityInfo> rank(int aId,int flag) {
        String sql = "select * from user_activity where aId = ? order by totalScore ";
        if(flag == 1){
            sql += "ASC ";
        }else{
            sql += "DESC ";
        }
        List<UserActivityInfo> infoList = null;
        try {
            infoList = template.query(sql,
                    new BeanPropertyRowMapper<UserActivityInfo>(UserActivityInfo.class),
                    aId);
        } catch (DataAccessException e) {
            return null;
        }
        return infoList;
    }

    @Override
    public List<FieldInfo> getNames(int aId) {
        String sql = "select name,notice from fieldsinfo where aId = ?";
        List<FieldInfo> fieldInfoList = null;
        try {
            fieldInfoList = template.query(sql,
                    new BeanPropertyRowMapper<FieldInfo>(FieldInfo.class),
                    aId);
        } catch (DataAccessException e) {
            return null;
        }
        return fieldInfoList;

    }

    @Override
    public void signUp(SignUpInfo signUpInfo) {
        String tableName = signUpInfo.getaName() + signUpInfo.getaId();
        String sql = "insert into " + tableName + " values(" + signUpInfo.getuId() + "," + signUpInfo.getaId();
        StringBuilder sb = new StringBuilder(sql);
        List<String> signUpMessage = signUpInfo.getSignUpMessage();
        for(int i = 0;i < signUpMessage.size();i++){
            sb.append(",'" + signUpMessage.get(i) + "'");
        }
        sb.append(")");
        template.update(sb.toString());
    }

    public static void main(String[] args) {
        SignUpInfo signUpInfo = new SignUpInfo();
        signUpInfo.setaName("test");
        signUpInfo.setaId(10001);
        signUpInfo.setuId(10001);
        List<String> values = new ArrayList<String>();
        values.add("nihao");
        values.add("string");
        signUpInfo.setSignUpMessage(values);
        ManagerDao managerDao = new MangerDaoImpl();
        managerDao.signUp(signUpInfo);
    }

}
