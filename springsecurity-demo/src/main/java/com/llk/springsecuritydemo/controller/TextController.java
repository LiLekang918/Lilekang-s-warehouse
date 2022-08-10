package com.llk.springsecuritydemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/text")
public class TextController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){

        return "hello security";
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index(){

        return "hello index";
    }

}
