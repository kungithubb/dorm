package com.dorm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkerController {

    @RequestMapping("/worker")
    public String Worker(){

        return "worker";
    }

}
