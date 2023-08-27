package com.gugu.service.impl;

import com.gugu.mapper.EmployeeMapper;
import com.gugu.mapper.PositionMapper;
import com.gugu.pojo.Employee;
import com.gugu.pojo.Position;
import com.gugu.service.EmployeeService;
import com.gugu.util.SqlsesionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    //查询所有：找上级领导
    @Override
    public List<Employee> findMgr() {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.selectMgr();
        sqlSession.close();
        return list;
    }

    //添加员工的实现
    @Override
    public int save(Employee employee) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int insert = mapper.insert(employee);
        sqlSession.close();
        return insert;
    }

    //按照条件查询员工实现
    @Override
    public List<Employee> findMore(String empid, String deptno, String onduty, String hireDate) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.selectMore(empid,deptno,onduty,hireDate);
        sqlSession.close();
        return list;
    }

    //查询单个员工的实现
    @Override
    public Employee findOne(String empid) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectOne(empid);
        sqlSession.close();
        return employee;
    }

    //员工修改后提交
    @Override
    public int change(Employee employee) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int i = mapper.update(employee);
        sqlSession.close();
        return i;
    }

    @Override
    public int remove(String empid) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int i = mapper.delete(empid);
        sqlSession.close();
        return i;
    }

    @Override
    public Employee login(String empid, String pwd) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectOne2(empid, pwd);
        sqlSession.close();
        return employee;
    }


    //查询单个员工：我的信息.jsp
    @Override
    public Employee findOne3(String empid) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectOne3(empid);
        sqlSession.close();
        return employee;
    }



}
