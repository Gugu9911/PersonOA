package com.gugu.service;

import com.gugu.pojo.ExpenseItem;

import java.util.List;

public interface ExpenseItemService {

    //查询所有明细（expenseitem）
    List<ExpenseItem> findAll(Integer expid);
}
