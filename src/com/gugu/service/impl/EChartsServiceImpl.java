package com.gugu.service.impl;

import com.gugu.mapper.EChartsMapper;
import com.gugu.pojo.ECharts;
import com.gugu.service.EChartsService;
import com.gugu.util.SqlsesionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class EChartsServiceImpl implements EChartsService {

    //查询职位人数信息
    @Override
    public List findAll() {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EChartsMapper mapper = sqlSession.getMapper(EChartsMapper.class);
        List<ECharts> list= mapper.selectAll();

        List<Integer> listsub1 = new ArrayList<>();
        List<String> listsub2 = new ArrayList<>();

        for (ECharts eCharts:list){
            listsub1.add(eCharts.getCount());
            listsub2.add(eCharts.getPname());
        }
        List listt = new ArrayList();
        listt.add(listsub2);
        listt.add(listsub1);
        return listt;
    }


    @Override
    public List findAll2() {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        EChartsMapper mapper = sqlSession.getMapper(EChartsMapper.class);
        List<ECharts> list = mapper.selectAll2();

        for (ECharts eCharts:list){

        }
        List li = new ArrayList();
        li.add(list);
        return li;
    }


}
