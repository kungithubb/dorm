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

    /**
     * 登陆页面
     */
    @RequestMapping("/toLoginPage")
    public String toLoginPage(){

//        跳转至登录页面
        return "login";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request, String userName, String password)
    {

        //验证登录信息
        if (userName.equals("2023001") && password.equals("123456"))
        {

            //验证成功，记录Session信息
            request.getSession().setAttribute("userName", userName);

            //重定向到首页
            return "redirect:toIndexPage";
        }
        else {

            //跳转至登录页面
            return toLoginPage();
        }
    }

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

