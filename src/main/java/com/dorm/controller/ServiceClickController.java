package com.dorm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ServiceClickController {

    @RequestMapping("/service/click")
    public String ServiceClick(){

        return "service_click";
    }
}