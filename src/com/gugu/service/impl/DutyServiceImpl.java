package com.gugu.service.impl;

import com.gugu.mapper.DutyMapper;
import com.gugu.mapper.PositionMapper;
import com.gugu.pojo.Dept;
import com.gugu.pojo.Duty;
import com.gugu.pojo.Position;
import com.gugu.service.DutyService;
import com.gugu.util.SqlsesionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class DutyServiceImpl implements DutyService {

    @Override
    public int signIn(Duty duty) {
        SqlSession sqlSession=null;
        int insert;
        try {
            sqlSession = SqlsesionUtil.getSqlSession();
            DutyMapper mapper = sqlSession.getMapper(DutyMapper.class);
            Duty du = mapper.selectOne(duty.getEmprId(), duty.getDtDate());

            if (du!=null){
                return -1;
            }
            insert = mapper.insert(duty);
        } finally {

            sqlSession.close();
        }
        return insert;
    }

    @Override
    public int signOut(Duty duty) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DutyMapper mapper = sqlSession.getMapper(DutyMapper.class);
        int update = mapper.update(duty);
        sqlSession.close();
        return update;
    }

    @Override
    public List<Duty> findMore(String empid, String deptno, String dtdate) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DutyMapper mapper = sqlSession.getMapper(DutyMapper.class);
        List<Duty> list = mapper.selectMore(empid, deptno, dtdate);
        sqlSession.close();
        return list;
    }

    //我的考勤
    @Override
    public List<Duty> findSome(String empId) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DutyMapper mapper = sqlSession.getMapper(DutyMapper.class);
        List<Duty> list = mapper.findSome(empId);
        sqlSession.close();
        return list;
    }


}
