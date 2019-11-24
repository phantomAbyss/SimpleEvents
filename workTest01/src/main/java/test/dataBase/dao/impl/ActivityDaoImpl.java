package test.dataBase.dao.impl;



import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import test.dataBase.dao.ActivityDao;
import test.dataBase.domain.Activity;
import test.dataBase.domain.ChildActivity;
import test.dataBase.domain.FieldInfo;
import test.dataBase.domain.RelationInfo;
import test.dataBase.utils.JDBCUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class ActivityDaoImpl implements ActivityDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Activity findActivityByaNameAnduId(String aName, int uId) {
        Activity activity = null;
        try {
            StringBuilder sql = new StringBuilder("select * from activity where 1 = 1 ");
            List<Object> parms = new ArrayList<Object>();
            if(uId != 0){
                sql.append(" and uId = ? ");
                parms.add(uId);
            }
            if(aName != null || !"".equals(aName)){
                sql.append(" and aName = ?");
                parms.add(aName);
            }
            activity = template.queryForObject(sql.toString(),
                    new BeanPropertyRowMapper<Activity>(Activity.class),
                    parms.toArray());
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
        return activity;
    }
    @Override
    public List<RelationInfo> getActivityByuId(int uId) {
        List<RelationInfo> relationInfoList = null;
        try {
            String sql = "select * from userinfo_childactivity where uId = ?";
            relationInfoList = template.query(sql,
                    new BeanPropertyRowMapper<RelationInfo>(RelationInfo.class),
                    uId);
        } catch (DataAccessException e) {
            return null;
        }
        return relationInfoList;
    }

    @Override
    public int findChildActivityBycaId(int caId) {
        Integer aId = null;
        try {
            String sql = "select aId from childactivity where caId = ?";
            aId = template.queryForObject(sql, Integer.class, caId);
        } catch (DataAccessException e) {
            return -1;
        }
        return aId;
    }

    @Override
    public Activity findActivityByaId(int aId) {
        Activity activity = null;
        try {
            String sql = "select * from activity where aId = ?";
            activity = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Activity>(Activity.class),
                    aId);
        } catch (DataAccessException e) {
            return null;
        }
        return activity;
    }

    /**
     * 根据活动信息动态创建的报名表
     * @param tableName
     * @param parms
     * @return
     */
    @Override
    public void enrollTable(String tableName, List<String> parms) {
        StringBuilder sb = new StringBuilder();
        sb.append("create table `" + tableName + "`(");
        sb.append("`uId` int(11) NOT NULL AUTO_INCREMENT,");
        sb.append("`aId` int(11) NOT NULL,");
        for(String parm : parms){
            sb.append("`" + parm + "` varchar(255) DEFAULT '',");
        }
        sb.append(" PRIMARY KEY (`uId`),");
        sb.append("foreign key(aId) references Activity(aId)");
        sb.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
        template.update(sb.toString());
    }

    /**
     * 向数据库中添加一项活动
     * @param activity
     * @return
     */
    @Override
    public void add(Activity activity) {
        String sql = "insert into activity values(null,?,?,?,?,?,?,?,?,?,?,true)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date createTime = new Date();
        Date deadlineTime = new Date();
        try {
            //活动创建时间
            createTime = sdf.parse(activity.getaCreationTime());
            //活动截止时间
            deadlineTime = sdf.parse(activity.getaDeadlineTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        template.update(sql,activity.getuId(),
                            activity.getaName(),
                            createTime,
                            deadlineTime,
                            activity.getaParticipation(),
                            activity.getaAbstract(),
                            activity.getaDescription(),
                            activity.getaPicturePath(),
                            activity.getaStatus(),
                            activity.getaNotice());
    }


    @Override
    public List<Activity> getMainActivity() {
        String sql = "select * from Activity";
        List<Activity> activityList = null;
        try {
            activityList = template.query(sql,
                    new BeanPropertyRowMapper<Activity>(Activity.class));
        } catch (DataAccessException e) {
            return null;
        }
        return activityList;
    }

    @Override
    public void addChildActivity(ChildActivity childActivity) {
        String sql = "insert into childActivity values(null,?,?,?,?,?,?)";
        template.update(sql,childActivity.getaId(),
                            childActivity.getCaName(),
                            childActivity.getCaDayMaxJoin(),
                            childActivity.isCaIsAvailable(),
                            childActivity.getScore(),
                            childActivity.getCaDescription());
    }

    @Override
    public ChildActivity findChildActivityByCaNameAndaId(String caName, int aId) {
        ChildActivity childActivity = null;
        try {
            String sql = "select * from childActivity where aId = ? and caName = ?";
            childActivity = template.queryForObject(sql,
                    new BeanPropertyRowMapper<ChildActivity>(ChildActivity.class),
                    aId, caName);
        } catch (DataAccessException e) {
            return null;
        }
        return childActivity;

    }

    @Override
    public void updateScore(int uId, int score) {
        String sql = "update user_activity set totalScore = totalScore + ? where uId = ?";
        template.update(sql,score,uId);
    }

    @Override
    public void updateActivityStatus(int aId) {
        String sql = "update activity set aStatus = 0 where aId = ?";
        template.update(sql,aId);
    }

    @Override
    public void addNotice(int aId, FieldInfo fieldInfo) {
        String sql = "insert into fieldsInfo values(?,?,?)";
        template.update(sql,aId,fieldInfo.getName(),fieldInfo.getNotice());
    }

    @Override
    public List<ChildActivity> getAllChildActivity(int aId,String aName) {
        String sql = "select * from childactivity where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> parms = new ArrayList<Object>();
        if(aId != 0){
            sb.append(" and aId = ? ");
            parms.add(aId);
        }
        if("".equals(aName) && aName != null){
            sb.append(" and aName = ?");
            parms.add(aName);
        }
        List<ChildActivity> childActivityList = null;
        try {
            childActivityList = template.query(sb.toString(),
                    new BeanPropertyRowMapper<ChildActivity>(ChildActivity.class),
                    parms.toArray());
        } catch (DataAccessException e) {
            return null;
        }
        return childActivityList;

    }

    @Override
    public List<String> getNames(String tableName){
        String sql = "select * from " + tableName + " limit 0";
        SqlRowSet sqlRowSet = template.queryForRowSet(sql);
        List<String> names = new LinkedList<String>();
        SqlRowSetMetaData metaData = sqlRowSet.getMetaData();
        for(int i = 1;i <= metaData.getColumnCount();i++){
            names.add(metaData.getColumnName(i));
        }
        return names;
    }

    public static void main(String[] args) {
        ActivityDao activityDao = new ActivityDaoImpl();
        List<String> fieldsinfo = activityDao.getNames("activity");
        for(String str : fieldsinfo){
            System.out.println(str);
        }
    }


}
