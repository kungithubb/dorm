package com.dorm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrivateClickController {

    @RequestMapping("/private/click")
    public String PrivateClick(){

        return "private_click";
    }

}
