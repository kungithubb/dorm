package com.dorm.controller;

import com.dorm.dao.UserDao;
import com.dorm.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 配置登录控制器
 */
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    /**
     * 登陆页面
     */
    @GetMapping(value = {"/index","/admin/login","/"})
    public String toLoginPage(){
//        跳转至登录页面
        return "login";
    }

    /**
     * 用户登录
     *登录认证方法
     * 连接数据库user表登录后台系统
     */
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request, HttpSession session) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("username:{}", username);
        log.info("password:{}", password);
        User user = userDao.selectUser(username,password);
        if(user != null) {

            session.setAttribute("username","password");
            return "redirect:/admin/main";
        } else {

            model.addAttribute("error","用户名或密码不正确");
//            如果输入的username,password不正确，则返回登录页
            return "login";
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
        return "redirect:/admin/login";
    }
}

