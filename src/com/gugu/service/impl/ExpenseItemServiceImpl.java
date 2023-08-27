package com.gugu.service.impl;

import com.gugu.mapper.ExpenseItemMapper;
import com.gugu.pojo.ExpenseItem;
import com.gugu.service.ExpenseItemService;
import com.gugu.util.SqlsesionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class ExpenseItemServiceImpl implements ExpenseItemService {
    @Override
    public List<ExpenseItem> findAll(Integer expid) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        ExpenseItemMapper mapper = sqlSession.getMapper(ExpenseItemMapper.class);
        List<ExpenseItem> list = mapper.selectAll(expid);
        sqlSession.close();
        return list;
    }
}
