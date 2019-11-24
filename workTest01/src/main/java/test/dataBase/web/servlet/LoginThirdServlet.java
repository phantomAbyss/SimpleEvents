package test.dataBase.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import test.dataBase.domain.UserInfo;
import test.dataBase.service.UserService;
import test.dataBase.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginThirdServlet")
public class LoginThirdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置网页格式
        response.setContentType("application/json;charset=utf-8");
        //获取第三方登录的唯一标识
        String thirdKey = request.getParameter("thirdKey");

        //调用service方式判断是否登录信息是否正确
        UserService service = new UserServiceImpl();
        UserInfo loginUser = service.loginByThird(thirdKey);

        Map<String,Object> mapJson = new HashMap<String,Object>();
        ObjectMapper mapper = new ObjectMapper();


        //判断是否登录成功
        if(loginUser != null){
            //登录成功
            //调用service方法查找用户
            UserInfo user = service.loginById(loginUser.getuId());

            //登录成功,添加需要传输的信息
            //状态码
            mapJson.put("status",response.getStatus());
            //登录成功
            mapJson.put("loginMessage","登录成功");
            //用户是否登录成功过
            mapJson.put("loginSuccess",true);
            //登录用户的所有基本信息
            mapJson.put("userData",loginUser);

            //传输json信息
            String value = mapper.writeValueAsString(mapJson);
            response.getWriter().write(value);
        }else{
            //登录失败
            //状态码
            mapJson.put("status",response.getStatus());
            //登录成功
            mapJson.put("loginMessage","第三方登录失败");
            //用户是否存在
            mapJson.put("loginSuccess",false);
            //登录用户的所有基本信息
            mapJson.put("userData",null);
            //传输json信息
            String value = mapper.writeValueAsString(mapJson);
            response.getWriter().write(value);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
