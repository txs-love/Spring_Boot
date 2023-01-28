package com.example.sherry.controller;

import com.example.sherry.mapper.UserMapper;
import com.example.sherry.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author txssherry@gmail.com
 * @date 2023/1/27 16:25
 */
@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        for (User user:users){
            System.out.println(user);
        }
        return users;
    }
    @GetMapping("/queryUserById")
    public User queryUserById(){
       User user =  userMapper.queryUserById(2);
        return user;
    }

    @GetMapping("/updateUser")
    public String updateUser(){
    userMapper.updateUser(new User(1,"txs","111"));
        return "ok";
    }
}
