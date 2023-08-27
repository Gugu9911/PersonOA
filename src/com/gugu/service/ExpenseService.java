package com.gugu.service;

import com.gugu.pojo.Duty;
import com.gugu.pojo.Expense;
import com.gugu.pojo.ExpenseItem;

import java.util.List;

public interface ExpenseService {

    //添加请假申请
    int save(Expense expense, List<ExpenseItem> list);

    //查询待审请假的操作
    List<Expense> findMore(String empid);

    //查询我的请假申请
    List<Expense> findSome(String empId);
}
