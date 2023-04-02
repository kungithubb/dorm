package com.dorm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RepairController {

    @RequestMapping("/repair")
    public String Repair(){

        return "repair";
    }

}
