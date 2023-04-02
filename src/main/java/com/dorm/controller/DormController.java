package com.dorm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DormController {

    @RequestMapping("/dorm")
    public String Dorm(){

        return "dorm";
    }

}
