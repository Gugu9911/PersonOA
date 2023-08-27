package com.gugu.service;

import com.gugu.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    //查询所有上级领导
    List<Employee> findMgr();

    //添加员工实现
    int save(Employee employee);

    //按照条件查询员工实现
    List<Employee> findMore(String empid,String deptno,String onduty,String hireDate);

    //查询单个员工的实现
    Employee findOne(String empid);

    //修改员工的实现
    int change(Employee employee);

    //删除员工的实现
    int remove(String empid);

    //查询单个员工:登录实现
    Employee login(String empid,String pwd);



    //查询单个员工：我的信息.jsp
    Employee findOne3(String empid);


}
