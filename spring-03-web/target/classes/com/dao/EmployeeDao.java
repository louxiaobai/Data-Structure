package com.dao;

import com.pojo.Department;
import com.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lqw
 * @date 2022/1/2-5:08 下午
 */
@Repository//交给spring托管
public class EmployeeDao {


    //模拟数据库中的数据
    private static Map<Integer, Employee> employees=null;

    //员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees=new HashMap<Integer, Employee>();//创建一个部门表
        employees.put(101, new Employee(101,"AA","2072582@qq.com",1,new Department(101, "后勤部")));
        employees.put(102, new Employee(102,"AB","2072582@qq.com",0,new Department(102, "教研部")));
        employees.put(103, new Employee(103,"AC","2072582@qq.com",1,new Department(103, "市场部")));
        employees.put(104, new Employee(104,"AD","2072582@qq.com",0,new Department(104, "运营部门")));
        employees.put(105, new Employee(105,"AE","2072582@qq.com",1,new Department(105, "后勤部")));
    }
    //主健自加
    private static Integer initId=1006;
    //增加一个员工

    public void save(Employee employee){

        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);

    }



    //查询全部员工

    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id查询员工

    public Employee getEmployeeById(Integer id){

        return employees.get(id);
    }

    //删除员工 通过id
    public void delete(Integer id){

        employees.remove(id);

    }




}