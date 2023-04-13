package com.dorm.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {

    private String name;  //定义一个公共的私有变量

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        name = request.getParameter("name");     //获取name参数
        try{
            Thread.sleep(10000);   //让线程沉睡10秒钟。
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        response.getWriter().println("获取的name参数为：" + name);   //输出信息
    }
}
