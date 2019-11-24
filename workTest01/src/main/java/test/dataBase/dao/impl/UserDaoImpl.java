package test.dataBase.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dataBase.dao.UserDao;
import test.dataBase.domain.UserInfo;
import test.dataBase.utils.JDBCUtils;

import java.util.Date;


public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public UserInfo loginByUsername(String username) {
        try {
            String sql = "select * from userinfo where uName = ?";
            UserInfo user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
                    username);
            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserInfo loginByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from userinfo where uName = ? and uPassword = ?";
            UserInfo user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
                    username, password);
            //System.out.println("login:" + user);
            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserInfo loginByThird(String thirdKey) {
        String sqlThirdKey = "select * from ThirdLogin where thirdKey = ?";

        return null;
    }

    @Override
    public UserInfo loginById(int id) {
        String sql = "select ";
        UserInfo user = new UserInfo();
        return user;
    }


    @Override
    public void save(UserInfo user) {
        //定义sql
        String sql = "insert into userinfo values(null,?,?,?,?,?,?)";
        template.update(sql,user.getuName(),
                user.getuPassword(),
                user.getuSignature(),
                user.isuSex(),
                user.getuPhone(),
                user.getuEmail());
    }



    @Override
    public UserInfo getUserByuName(String uName) {
        UserInfo user = null;
        try {
            String sql = "select * from userinfo where uName = ?";
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
                    uName);
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }

    @Override
    public UserInfo getUserByuId(int uId) {
        String sql = "select * from userinfo where uId = ?";
        UserInfo user = null;
        try {
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
                    uId);
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }

    @Override
    public UserInfo findUserByuId(int uId) {
        String sql = "select * from userinfo where uId = ?";
        UserInfo user = null;
        try {
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<UserInfo>(UserInfo.class), uId);
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }

    @Override
    public String getImage(int uId, int flag) {
        //select * from images where id = ? and flag = ?
        String sql = "select url from images where id = ? and flag = ?";
        String image = null;
        try {
            image = template.queryForObject(sql, String.class, uId, flag);
        } catch (DataAccessException e) {
            return null;
        }
        return image;
    }

    @Override
    public void addImage(int uId,String image) {
        String sql = "insert into images values(null,?,?,?)";
        template.update(sql,uId,image,0);
    }


}
