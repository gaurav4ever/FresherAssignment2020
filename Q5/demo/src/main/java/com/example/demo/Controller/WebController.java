package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class WebController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
