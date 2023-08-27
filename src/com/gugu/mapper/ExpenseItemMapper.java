package com.gugu.mapper;

import com.gugu.pojo.ExpenseItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ExpenseItemMapper {

    //添加明细的实现
    @Insert("insert into  expenseitem  values(default,#{expId},#{type},#{amount},#{itemDesc})")
    int insert(ExpenseItem expenseItem);

    //查询所有明细（expenseitem）
    @Select("select * from expenseitem where expid=#{expid}")
    List<ExpenseItem> selectAll(Integer expid);
}
