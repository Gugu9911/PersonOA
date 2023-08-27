package com.gugu.service.impl;

import com.gugu.mapper.DeptMapper;
import com.gugu.pojo.Dept;
import com.gugu.service.DeptService;
import com.gugu.util.SqlsesionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    //添加部门的实现
    @Override
    public int save(Dept dept){
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int insert = mapper.insert(dept);
        sqlSession.close();
        return insert;
    }

    //查询所有（分页）
    @Override
    public List<Dept> findAll(int start,int size) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = mapper.selectAll(start,size);
        sqlSession.close();
        return list;
    }

    //查询单个部门
    @Override
    public Dept findOne(int deptno) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.selectOne(deptno);
        sqlSession.close();
        return dept;
    }

    //修改部门信息
    @Override
    public int change(Dept dept) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int update = mapper.update(dept);
        sqlSession.close();
        return update;
    }

    //删除部门信息
    @Override
    public int remove(int deptno) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int delete = mapper.delete(deptno);
        sqlSession.close();
        return delete;
    }

    @Override
    public int getCount() {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int count = mapper.selectCount();
        sqlSession.close();
        return count;
    }

    @Override
    public List<Dept> findAll2() {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = mapper.selectAll2();
        sqlSession.close();
        return list;
    }
}
