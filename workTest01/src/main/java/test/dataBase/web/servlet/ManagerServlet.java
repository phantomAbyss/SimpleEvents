package test.dataBase.web.servlet;

import com.alibaba.fastjson.JSONObject;
import test.dataBase.domain.*;
import test.dataBase.service.ActivityService;
import test.dataBase.service.ManagerService;
import test.dataBase.service.UserService;
import test.dataBase.service.impl.ActivityServiceImpl;
import test.dataBase.service.impl.ManagerServiceImpl;
import test.dataBase.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/manager/*")
public class ManagerServlet extends BaseServlet {

    private ManagerService managerService = new ManagerServiceImpl();
    private ActivityService activityService = new ActivityServiceImpl();
    private UserService userService = new UserServiceImpl();

    /**
     * 添加管理员
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有参数
        //获取该管理员的用户名
        String uName = request.getParameter("uName");
        //获取负责管理的活动的名称
        String aName = request.getParameter("aName");
        //获取uId
        String uId = request.getParameter("uId");
        //获取aId
        String aId = request.getParameter("aId");
        boolean flag = false;
        if(!"".equals(uId)&&uId != null&&!"".equals(aId)&&aId != null){
            flag = managerService.addManager(Integer.parseInt(uId),Integer.parseInt(aId));
        }else{
            //调用managerService方法添加管理员
            flag = managerService.addManager(uName, aName);
        }

        //将信息写回到客户端
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        if(flag == false){
            mapJson.put("addMessage","添加失败,管理员的用户名或者活动的名称有误");
            mapJson.put("addSuccess",false);
        }else{
            mapJson.put("addMessage","添加成功");
            mapJson.put("addSuccess",true);
        }
        writeValue(mapJson,response);
    }


    /**
     * 删除管理员
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有参数
        //获取该管理员的用户名
        String uName = request.getParameter("uName");
        //获取负责管理的活动的名称
        String aName = request.getParameter("aName");
        //获取uId
        String uId = request.getParameter("uId");
        //获取aId
        String aId = request.getParameter("aId");

        boolean flag = false;
        if(!"".equals(uId)&&uId != null&&!"".equals(aId)&&aId != null){
            flag = managerService.deleteManager(Integer.parseInt(uId),Integer.parseInt(aId));
        }else{
            //调用managerService方法添加管理员
            flag = managerService.deleteManager(uName, aName);
        }

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        if(flag == false){
            //删除失败
            mapJson.put("deleteMessage","删除失败，用户名或者活动名称输入错误");
            mapJson.put("deleteSuccess",false);
        }else{
            //删除成功
            mapJson.put("deleteMessage","删除成功");
            mapJson.put("deleteSuccess",true);
        }
        //将数据写回到客户端
        writeValue(mapJson,response);
    }
    /**
     * 得到一个大活动下的所有子活动
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getAllChildActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取活动名称
        String aName = request.getParameter("aName");
        //获取活动aId
        String aId = request.getParameter("aId");
        System.out.println(aId + "----");
        //调用service处理
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        List<ChildActivity> childActivityList = activityService.getAllChildActivity(Integer.parseInt(aId), aName);
        mapJson.put("childActivityMessagae",childActivityList);
        mapJson.put("getSuccess",true);
        writeValue(mapJson,response);
    }

    /**
     * 获取排行榜信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void rankList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取大活动aName或者aId
        String aName = request.getParameter("aName");
        String aId = request.getParameter("aId");
        String order = request.getParameter("order");


        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        if(aId == null && aName == null){
            mapJson.put("rankMessage","没有输入活动的信息");
            mapJson.put("rankSuccess",false);
            writeValue(mapJson,response);
            return;
        }
        //得到对应的排序信息
        List<RankInfo> rankInfoList = managerService.rankList(Integer.parseInt(aId), aName, Integer.parseInt(order));
        Activity activity = activityService.getSingleActivity(Integer.parseInt(aId));
        mapJson.put("activityMessage",activity);
        mapJson.put("rankMessage",rankInfoList);
        mapJson.put("rankSuccess",true);
        writeValue(mapJson,response);
    }

    public void entryFields(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数
        String aName = request.getParameter("aName");
        String aId = request.getParameter("aId");
        //掉service方法获得表名
        Map<String, String> names = managerService.getNames(Integer.parseInt(aId));
        Map<String,Object> mapJson = new HashMap<String,Object>();

        mapJson.put("status",response.getStatus());
        mapJson.put("fieldsInfo",names);
        //将数据写回到客户端
        writeValue(mapJson,response);
    }
        /**
         * 添加报名信息
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    public void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //读取客户端发来的json数据
        String jsonStr = readJson(request);
        System.out.println(jsonStr);
        //将数据解析为json
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        SignUpInfo signUpInfo = jsonObject.toJavaObject(SignUpInfo.class);
        //填写报名信息
        managerService.signUp(signUpInfo);
        UserInfo user = userService.getUserInfo(signUpInfo.getuId());
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("userMessage",user);
        mapJson.put("signUpMessage","报名成功");
        mapJson.put("signUpSuccess",true);

        //将数据写回到客户端
        writeValue(mapJson,response);

    }
}
