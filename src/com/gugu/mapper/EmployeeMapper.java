package com.gugu.mapper;

import com.gugu.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface EmployeeMapper {

    //查询所有员工实现：找上级领导
    @Select("select * from employee where emptype=2")
    List<Employee> selectMgr();

    //添加员工的实现
    int insert(Employee employee);

    //按照条件查询指定员工的信息
    List<Employee> selectMore(String empid,String deptno,String onduty,String hireDate);

    //查询单个员工的实现
    @Select("select * from employee where empid=#{param1}")
    Employee selectOne(String empid);

    //修改员工的实现
    int update(Employee employee);

    //删除员工操作
    @Delete("delete from employee where empid=#{param1}")
    int delete(String empid);

    //查询单个员工:登录
    @Select("select * from employee where empid=#{param1} and password=#{param2}")
    Employee selectOne2(String empid,String password);


    //查询单个员工：我的信息.jsp
    @Select("select * from employee where empid=#{param1}")
    Employee selectOne3(String empId);


}
