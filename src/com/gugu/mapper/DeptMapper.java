package com.gugu.mapper;

import com.gugu.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeptMapper {
    //添加部门实现
    @Insert("insert into  dept  values(#{deptno},#{deptname},#{location})")
    int   insert(Dept  dept);

    //查询所有部门的实现(分页)
    @Select("select * from dept limit #{param1},#{param2}")
    List<Dept> selectAll(int start, int size);

    //统计当前总条数
    @Select("select count(*) from dept")
    int selectCount();

    //查询单个部门信息
    @Select("select * from dept where deptno = #{param1}")
    Dept selectOne(int deptno);

    //修改部门的操作
    @Update("update dept set deptname=#{deptname},location=#{location} where deptno=#{deptno}")
    int update(Dept dept);

    //删除部门实现
    @Delete("delete from dept where deptno=#{param1}")
    int delete(int deptno);

    //查询所有部门的实现
    @Select("select * from dept")
    List<Dept> selectAll2();

}
