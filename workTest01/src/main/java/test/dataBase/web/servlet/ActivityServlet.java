package test.dataBase.web.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import test.dataBase.domain.*;
import test.dataBase.service.ActivityService;
import test.dataBase.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/activity/*")
public class ActivityServlet extends BaseServlet {

    private ActivityService activityService = new ActivityServiceImpl();

    /**
     * 获取所有活动的信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getAllActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Activity> allActivity = activityService.getAllActivity();

        //添加返回到客户端的消息
        Map<String,Object> mapJson = new HashMap<String,Object>();
        //状态码
        mapJson.put("status",response.getStatus());
        if(allActivity == null){
            //数据库中没有数据，或者查询失败
            //查询消息
            mapJson.put("activityMessage","数据库中没有消息或者查询失败");
            mapJson.put("activityData",null);

        }else{

            //查询消息
            mapJson.put("activityMessage","查询成功");
            mapJson.put("activityData",allActivity);
        }
        //将信息输出到界面
        writeValue(mapJson,response);
    }

    /**
     * 获取单个活动的信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getSingleActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置网页编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");


        //获取所有参数
        //活动名称
        String aName = request.getParameter("aName");
        //创建该活动的用户的用户名
        String uName = request.getParameter("uName");
        Activity activityInfo = activityService.getSingleActivity(aName,uName);

        //将需要发送到客户端的消息序列化json
        Map<String,Object> mapJson = new HashMap<String,Object>();
        //状态码
        mapJson.put("status",response.getStatus());

        if(activityInfo == null){
            // 该活动不存在
            mapJson.put("getMessage","该活动不存在");
            mapJson.put("getInfoSuccess",false);
        }else{
            //该活动存在
            mapJson.put("getMessage","该活动存在");
            mapJson.put("getInfoSuccess",true);
            mapJson.put("ActivityData",activityInfo);
        }
        //将数据发送到客户端
        writeValue(mapJson,response);
    }

    /**
     * 用户参与/管理/创建的活动
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getActivity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置网页编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取客户端的参数
        String uName = request.getParameter("uName");
//        if(!"".equals(uName) && uName != null){
//            uName = new String(uName.getBytes("iso-8859-1"),"utf-8");
//        }
        String aStatus = request.getParameter("aStatus");
        String statusStr = new String();
        if("0".equals(aStatus)){
            statusStr = "管理";
        }else if("1".equals(aStatus)){
            statusStr = "创建";
        }else{
            statusStr = "参与";
        }


        UserInfo user = new UserInfo();
        user.setuName(uName);

        List<Activity> participationActivity = activityService.getActivity(user,Integer.parseInt(aStatus));
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        if(participationActivity == null){
            mapJson.put("participationMessage","该用户还没有" + statusStr + "任何活动");
            mapJson.put("participationData",null);
        }else{
            mapJson.put("participationMessage","该用户" + statusStr + "了" + participationActivity.size() + "项活动");
            mapJson.put("participationData",participationActivity);
        }

        //将数据写回到客户端
        writeValue(mapJson,response);
    }
    /**
     * 新建活动
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置网页编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        String uName = request.getParameter("uName");
        //封装对象
        Activity activity = new Activity();
        try {
            BeanUtils.populate(activity,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //设置活动的初始化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        activity.setaCreationTime(sdf.format(new Date()));


        //调用activityService方法添加新建活动
        Activity addActivity = activityService.addActivity(activity,uName);
        Map<String,Object> mapJson = new HashMap<String,Object>();
        //状态码
        mapJson.put("status",response.getStatus());
        if(addActivity == null){
            mapJson.put("addMessage","添加失败，该用户还未注册");
            mapJson.put("activityData",null);
        }else{
            mapJson.put("addMessage","添加成功");
            mapJson.put("activityData",addActivity);
        }
        //将数据写回到客户端
        writeValue(mapJson,response);
    }


    /**
     * 创建活动，即创建表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void createActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取输入流数据
        String createMessage = readJson(request);
        System.out.println(createMessage);
        //将得到的字符串转化为json数据
        JSONObject json = JSONObject.parseObject(createMessage);
        //将获取到的数据转换为table的信息
        Table table = json.toJavaObject(Table.class);
        /*JSONArray jsonArray = json.getJSONArray("fieldList");
        List<FieldInfo> fieldInfos = jsonArray.toJavaList(FieldInfo.class);
        for(FieldInfo info : fieldInfos){
            System.out.println(info);
        }*/
        Activity activity = table.getActivity();
        //设置活动的初始化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        activity.setaCreationTime(sdf.format(new Date()));

        //得到需要建表的字段
        List<FieldInfo> fieldList = table.getFieldList();
        List<String> parameters = new ArrayList<String>();
        List<String> notices = new ArrayList<String>();
        for(FieldInfo fieldInfo : fieldList){
            parameters.add(fieldInfo.getName());
            System.out.println(fieldInfo.getName());
            notices.add(fieldInfo.getNotice());
        }
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        Activity addActivity = activityService.addActivity(activity, table.getuName());
        if(addActivity != null){
            table.setaId(addActivity.getaId());

            //调用service创建活动对应的表
            activityService.createActivity(table.getaId(),parameters);

            //添加字段说明
            activityService.addFieldNotice(table.getaId(),fieldList);

            //添加子活动
            List<ChildActivity> childActivityList = table.getChildActivityList();
            for(ChildActivity childActivity : childActivityList){
                childActivity.setaId(addActivity.getaId());
            }
            activityService.addChildActivity(childActivityList);
            mapJson.put("activityMessage",addActivity);
            mapJson.put("createMessage","创建成功");
            mapJson.put("createSuccess",true);
        }else{
            mapJson.put("addMessage","添加失败");
            mapJson.put("activityMessage",null);
            mapJson.put("createMessage","创建失败");
            mapJson.put("createSuccess",false);
        }

        writeValue(mapJson,response);
    }


    /**
     * 添加子活动
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addChildActitivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取json数据
        String jsonString = readJson(request);
        //将读取的数据转化为json
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        //获取大活动的名称
        String aName = jsonObject.getString("aName");
        //获取大活动的id
        int aId = jsonObject.getInteger("aId");
        //获取需要添加的子活动
        JSONArray jsonArray = jsonObject.getJSONArray("childActivityList");
        List<ChildActivity> childActivityList = jsonArray.toJavaList(ChildActivity.class);

        //调用activityService方法添加子活动
        //activityService.addChildActivity(childActivity);
        activityService.addChildActivity(childActivityList);

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("addChildActivityMessage","添加成功");
        writeValue(mapJson,response);
    }


    /**
     * 上传对应的子活动的分数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateScores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置网页编码格式
        response.setContentType("application/json;charset=utf-8");
        //获取所有参数
        //获取活动的名称
        String aName = request.getParameter("aName");
        //获取参与该活动的用户的用户名
        String uName = request.getParameter("uName");
        //获取该子活动的名称
        String caName = request.getParameter("caName");

        //调用activityService方法上传该分数
        boolean flag = activityService.updateScores(uName,aName,caName);
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        if(flag == false){
            mapJson.put("updateMessage","上传分数失败，用户名或者活动名称或者子活动名称有误，请检查后重新上传");
            mapJson.put("updateSuccess",false);
        }else{
            mapJson.put("updateMessage","上传成功");
            mapJson.put("updateSuccess",true);
        }
        //将数据写回到客户端
        writeValue(mapJson,response);
    }

    /**
     * 取消某项活动
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void cancelActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有参数
        //获取当前用户的用户名
        String uName = request.getParameter("uName");
        //获取需要取消的活动的名称
        String aName = request.getParameter("aName");

        //调用userService方法
        Activity activity = activityService.cancelActivity(uName,aName);
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        if(activity == null){
            mapJson.put("cancelMessage","取消失败，请检查用户名或者活动名是否有误,或者该用户没有删除该项活动的权限");
            mapJson.put("cancelSuccess",false);
        }else{
            mapJson.put("cancelMessage","取消成功");
            mapJson.put("cancelData",activity);
            mapJson.put("cancelSuccess",true);
        }

        //将数据写回到客户端
        writeValue(mapJson,response);
    }


}
