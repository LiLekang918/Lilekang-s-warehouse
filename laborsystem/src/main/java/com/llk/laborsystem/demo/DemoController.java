package com.llk.laborsystem.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("/index")
    public String index(){
        return "demo/index";
    }
}
