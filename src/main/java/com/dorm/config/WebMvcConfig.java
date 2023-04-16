package com.dorm.config;

import com.dorm.interceptor.LoginInterceptor;
import com.dorm.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

//    给容器中添加一个原生Servlet
    @Bean
    public TestServlet testServlet() {

        return new TestServlet();
    }

//    注册servlet让其生效
    @Bean
    public ServletRegistrationBean<TestServlet> servletServletRegistrationBean(TestServlet testServlet) {

        return new ServletRegistrationBean<>(testServlet,"/test/testServlet");
    }

    /**
     * 配置登录拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        /**
         * 注册Interceptor拦截器
         * 将拦截器添加到拦截器注册中心，让其生效
         */
        InterceptorRegistration registration;
        registration = registry.addInterceptor(new LoginInterceptor());
        /**
         * 所有路径都被拦截
         * 配置拦截器拦截路径
         */
        registration.addPathPatterns("/*", "/admin/*");
        /**
         * 添加不拦截路径
         * 配置排除路径，告诉拦截器那些请求不拦截直接放行
         */
        registration.excludePathPatterns(
                "/",
                "/index",           //登录页面
                "/admin/login",            //登录请求
                "/register",
                "*.css",
                "*.js",
                "*.jpg",
                "*.png"
        );
    }

    /**
     * 控制器配置
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/admin/main").setViewName("main");
        registry.addViewController("/").setViewName("main");
    }
}