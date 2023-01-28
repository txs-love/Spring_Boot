package com.example.springboot.dao;

import com.example.springboot.pojo.Department;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author txssherry@gmail.com
 * @date 2023/1/25 21:53
 */
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101,new Department(1,"项目部"));
        departments.put(102,new Department(2,"后勤部"));
        departments.put(103,new Department(3,"资金部"));
    }
    //返回所有部门信息
    public Collections getDepartment(){
        return (Collections) departments.values();
    }
    //通过Id返回所有部门信息
    public Department getDepartmentById(Integer id){
        return departments.get(id);     //通过id得到部门信息;
    }

}
