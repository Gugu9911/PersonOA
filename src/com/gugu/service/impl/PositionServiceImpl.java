package com.gugu.service.impl;

import com.gugu.mapper.PositionMapper;
import com.gugu.pojo.Position;
import com.gugu.service.PositionService;
import com.gugu.util.SqlsesionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PositionServiceImpl implements PositionService {

    //查询所有部门
    @Override
    public List<Position> findAll() {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        List<Position> list = mapper.selectAll();
        sqlSession.close();
        return list;
    }



    //查询单个部门的信息(进行修改功能的前提)
    @Override
    public Position findOne(int posid) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        Position position= mapper.selectOne(posid);
        sqlSession.close();
        return position;
    }

    //修改部门的操作
    @Override
    public int change(Position position) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        int update = mapper.update(position);
        sqlSession.close();
        return update;
    }

    //删除部门的实现
    @Override
    public int remove(int posid) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        int delete = mapper.delete(posid);
        sqlSession.close();
        return delete;
    }


    //添加部门
    @Override
    public int save(Position position) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        PositionMapper mapper = sqlSession.getMapper(PositionMapper.class);
        int insert = mapper.insert(position);
        sqlSession.close();
        return insert;
    }
}
