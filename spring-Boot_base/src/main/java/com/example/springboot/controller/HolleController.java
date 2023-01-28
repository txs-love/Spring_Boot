package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author txssherry@gmail.com
 * @date 2023/1/20 15:28
 */
@RestController
public class HolleController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello word";
    }
}
