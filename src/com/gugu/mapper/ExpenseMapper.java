package com.gugu.mapper;

import com.gugu.pojo.Duty;
import com.gugu.pojo.Expense;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface ExpenseMapper {

    //添加请假申请
    int insert(Expense expense);

    //查询待审请假的操作
    @Select("select  *  from   expense   exp  join  employee  emp  on   exp.empid=emp.empid  where  exp.nextauditor=#{param1}  and  exp.status=0")
    List<Expense> selectMore(String  empid);

    //修改请假申请状态
    Integer update(Integer expid,String next,String status);

    //查询我的请假申请
//    @Select("select * from expense exp join auditing a on exp.expid = a.expid where exp.empid=#{empId}")
    @Select("select * from expense where empid=#{empId}")
    List<Expense> findSome(String empId);
}
