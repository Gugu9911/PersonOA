package com.gugu.mapper;

import com.gugu.pojo.Auditing;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuditingMapper {

    //添加请假历史的实现
    @Insert("insert into auditing values(default,#{expId},#{empId},#{result},#{auditDesc},#{time})")
    Integer insert(Auditing auditing);

    //按照条件查询指定信息：我的审核历史
    @Select("select * from auditing a join expense exp on a.expid =exp.expid join employee emp on emp.empid=exp.empid where a.empid=#{empid}")
    List<Auditing> selectMore(String empid);

    //查询审核备注（auditHistory.jsp）
    @Select("select * from auditing a join employee emp on a.empid=emp.empid join expense exp on a.expid = exp.expid where a.expid=#{expid}")
    List<Auditing> selectOne(Integer expid);
}
