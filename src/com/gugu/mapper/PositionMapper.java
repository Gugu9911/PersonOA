package com.gugu.mapper;

import com.gugu.pojo.Position;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PositionMapper {


    //分页：统计当前的总条数
    @Select("select count(*) from position")
    int selectCount();

    //查询所有岗位信息
    @Select("select * from position")
    List<Position> selectAll();

    //增加岗位
    @Insert("insert into position values(#{posid},#{pname},#{pdesc})")
    int insert(Position position);

    //查询单个部门的信息(进行修改功能的前提)
    @Select("select * from position where posid=#{param1}")
    Position selectOne(int posid);

    //修改部门的操作
    @Update("update position set pname=#{pname}, pdesc=#{pdesc} where posid=#{posid}")
    int update(Position position);

    //删除部门的实现
    @Delete("delete from position where posid=#{posid}")
    int delete(int posid);

}
