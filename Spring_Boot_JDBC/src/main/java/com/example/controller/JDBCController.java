package com.example.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @author txssherry@gmail.com
 * @date 2023/1/26 20:36
 */
@Controller
public class JDBCController {
    /**
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/userList")
    public List<Map<String, Object>> maps(){
        String sql = "select * from t_dept";
        List<Map<String,Object>> list_map = jdbcTemplate.queryForList(sql);
        return list_map;
    }

    public String AddUser(){
       String sql = "insert into mybatis.t_dept(did,dept_name) values (1,'txs')";
       jdbcTemplate.update(sql);
       return "add_Ok";
    }


    @GetMapping("/deleteUser/{did}")
    public String deleteUser(@PathVariable(("did")) int did){
        String sql =  "delete into mybatis.t_dept where did=3";
        jdbcTemplate.update(sql,did);
        return "delete_Ok";
    }

    @GetMapping("/updateUser/{did}")
    public String updateUser(@PathVariable(("did")) int did){
        String sql =  "update mybatis.t_dept set did=? dept_name =? where did="+did;
        Object[] objects = new Object[2];
        objects[0]=4;
        objects[1]="Sherry";
        jdbcTemplate.update(sql,did);
        return "update_Ok";
    }
    */
}
