package com.gugu.mapper;

import com.gugu.pojo.ECharts;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EChartsMapper  {

    //查询职位人数信息
    @Select("SELECT COUNT(*) count,pname FROM employee emp JOIN position pos on emp.posid = pos.posid GROUP BY pname")
    List<ECharts> selectAll();

    //根据部门查询人数信息
    @Select("SELECT COUNT(*) value,deptname name FROM employee emp JOIN dept on emp.deptno = dept.deptno GROUP BY deptname")
    List<ECharts> selectAll2();
}
