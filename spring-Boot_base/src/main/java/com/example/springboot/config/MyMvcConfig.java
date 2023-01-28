package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;
/**
 * @author txssherry@gmail.com
 * @date 2023/1/25 17:40
 */
// 前面扩展MVC
@Configuration   //如果你想自定义一些组件,把他交给springBoot,俺门的spring_boot就会自动装配
   // @EnableWebMvc      //这里不能加上EnableWebMvc这个类;WebMvcConfig
@RestController
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/").setViewName("index.html");
    }
}