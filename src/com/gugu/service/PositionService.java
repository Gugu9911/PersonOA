package com.gugu.service;

import com.gugu.pojo.Position;

import java.util.List;

public interface PositionService {


    //添加岗位的实现
    int save(Position position);

    //查询所有岗位信息
    List<Position> findAll();


    //查询单个部门的信息(进行修改功能的前提)
    Position findOne(int posid);

    //修改部门的操作
    int change(Position position);

    //删除部门的实现
    int remove(int posid);
}
