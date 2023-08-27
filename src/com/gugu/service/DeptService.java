package com.gugu.service;

import com.gugu.pojo.Dept;

import java.util.List;

public interface DeptService {

    //添加部门的实现
    int save(Dept dept);

    //查询所有（分页）
    List<Dept> findAll(int start, int size);

    //查询单个部门
    Dept findOne(int deptno);

    //修改部门信息
    int change(Dept dept);

    //删除部门信息
    int remove(int deptno);

    int getCount();

    //查询所有
    List<Dept> findAll2();
}
