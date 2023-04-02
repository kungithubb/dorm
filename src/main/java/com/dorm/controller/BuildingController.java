package com.dorm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuildingController {

    @RequestMapping("/building")
    public String Building(){

        return "building";
    }

}
