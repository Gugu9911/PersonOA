package com.gugu.service.impl;


import com.gugu.mapper.ExpenseItemMapper;
import com.gugu.mapper.ExpenseMapper;
import com.gugu.pojo.Expense;
import com.gugu.pojo.ExpenseItem;
import com.gugu.service.ExpenseService;
import com.gugu.util.SqlsesionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public int save(Expense expense, List<ExpenseItem> list) {
        SqlSession sqlSession = null;
        int insert = 0;
        try {
            sqlSession = SqlsesionUtil.getSqlSession();
            sqlSession.getMapper(ExpenseMapper.class).insert(expense);

            ExpenseItemMapper mapper = sqlSession.getMapper(ExpenseItemMapper.class);
            for (ExpenseItem expenseitem:list){

                //把请假申请的id设置到请假明细中
                expenseitem.setExpId(expense.getExpId());
                mapper.insert(expenseitem);
            }
            insert=1;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


        return insert;
    }

    @Override
    public List<Expense> findMore(String empid) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        List<Expense> list = sqlSession.getMapper(ExpenseMapper.class).selectMore(empid);
        sqlSession.close();

        return list;
    }

    //查询我的请假申请
    @Override
    public List<Expense> findSome(String empId) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        ExpenseMapper mapper = sqlSession.getMapper(ExpenseMapper.class);
        List<Expense> expenseList = mapper.findSome(empId);
        sqlSession.close();
        return expenseList;
    }
}
