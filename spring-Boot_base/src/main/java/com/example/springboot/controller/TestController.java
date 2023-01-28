package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author txssherry@gmail.com
 * @date 2023/1/25 16:05
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","<h1>hello springBoot</h1>");
        return "test";
    }
}
