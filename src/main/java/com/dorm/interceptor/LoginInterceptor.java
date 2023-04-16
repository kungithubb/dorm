package com.dorm.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object username = request.getSession().getAttribute("username");
        if(username != null) {

            log.info("当前登录拦截器正在拦截请求，请求的处理目标方法是：{}", handler);
            return true;
        }
        request.setAttribute("error","请先登 录系统！");
        request.getRequestDispatcher("/admin/login").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        log.info("目标方法已经处理完成，准备进行视图渲染，请求中携带的数据是:{} , 请求将转发到 {} 页面。",
                modelAndView.getModel() , modelAndView.getViewName());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception exception) throws Exception {
        log.info("请求已经处理完成，准备响应给客户端，此次请求中是否有异常？ {}",
                exception == null ? true :false);
    }
}
