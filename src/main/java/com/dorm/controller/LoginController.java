package com.dorm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器
 */
@Controller
public class LoginController {

    /*private static File userDir;
    static {
        userDir = new File("./users");
        if(!userDir.exists()){
            userDir.mkdirs();
        }
    }*/

    /**
     * 登陆页面
     */
    @RequestMapping("/toLoginPage")
    public String toLoginPage(){

//        跳转至登录页面
        return "login";
    }

    /**
     * 用户登录
     *
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request, String username, String password)
    {

        //验证登录信息
        if (username.equals("123") && password.equals("123"))
        {

            //验证成功，记录Session信息
            request.getSession().setAttribute("username", username);

            //重定向到首页
            return "redirect:toIndexPage";
        }
        else {

            //跳转至登录页面
            return toLoginPage();
        }
    }

//    @RequestMapping("/loginUser")
//    private void login(HttpServletRequest request, HttpServletResponse response) {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
//
//            try {
//
//                response.sendRedirect("login_info_error");
//            } catch (IOException e) {
//
//                e.printStackTrace();
//            }
//            return;
//        }
//        File userFile = new File(userDir,username + ".obj");
////        用户名没有输入正确
//        if(!userFile.exists()) {
//
//            try {
//
//                response.sendRedirect("login_fail");
//            } catch (IOException e) {
//
//                e.printStackTrace();
//            }
//        } else {
////        用户名输入正确
//            try(
//
//                FileInputStream fis = new FileInputStream(userFile);
//                ObjectInputStream ois = new ObjectInputStream(fis);
//            ) {
////                读取该注册用户信息
//                User user = (User)ois.readObject();
////                用户名和密码正确
//                if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
////                    登录成功
//                    response.sendRedirect("login_success");
//                    return;
//                } else {
////                用户名或密码不正确
//                    response.sendRedirect("login_fail");
//                }
//            } catch (IOException | ClassNotFoundException e) {
//
//                e.printStackTrace();
//            }
//        }
//    }

    /**
     * 登出
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request)
    {

        //销毁session对象
        request.getSession().invalidate();

        //重定向到登录页面
        return "redirect:toLoginPage";
    }
}

