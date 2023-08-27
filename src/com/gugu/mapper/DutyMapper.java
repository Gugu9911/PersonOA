package com.gugu.mapper;

import com.gugu.pojo.Duty;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;


public interface DutyMapper {

    //用户签到的实现
    @Insert("insert into duty values(default,#{emprId},#{dtDate},#{signinTime},#{signoutTime})")
    int insert(Duty duty);

    //查询用户签到信息的实现(确保每个用户只能签到一次)
    @Select("select * from duty where dtdate=#{param2} and emprid=#{param1}")
    Duty selectOne(String emprid, Date dtdate);

    //修改操作（签退）
    @Update("update duty set signoutTime=#{signoutTime} where dtdate=#{dtDate} and emprid=#{emprId}")
    int update(Duty duty);

    //按照条件查询考勤的信息
    List<Duty> selectMore(String empid,String deptno,String dtdate);


    //我的考勤：查询考勤表
    @Select("select * from duty where emprid=#{empId}")
    List<Duty> findSome(String empId);
}
