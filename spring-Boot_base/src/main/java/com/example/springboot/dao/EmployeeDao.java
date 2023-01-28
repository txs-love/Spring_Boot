package com.example.springboot.dao;
import com.example.springboot.pojo.Department;
import com.example.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author txssherry@gmail.com
 * @date 2023/1/25 21:53
 */
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap = null;
    @Autowired
                 private static DepartmentDao departmentDao;
    static {
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(101, new Employee(1, "txs", "txs@123", "男",new Department(1,"项目部")));
        employeeMap.put(102, new Employee(2, "ysl", "ysk@123", "女",new Department(2,"后勤部")));
        employeeMap.put(103, new Employee(3, "lsk", "loa@123", "女",new Department(3,"资金部")));
    }
    //自增主键
    private static Integer initId = 4;

    public EmployeeDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getId()));
        employeeMap.put(employee.getId(), employee);
    }
    // 查询全部员工信息
    public Collections getAll(){
        return (Collections) employeeMap.values();
    }
    //通过id查询id
    private Employee getEmployeeById(Integer initId){
        return employeeMap.get(initId);
    }
    //删除员工信息
    private void DeleteEmployeeById(Integer initId){
        employeeMap.remove(initId);
    }
}
