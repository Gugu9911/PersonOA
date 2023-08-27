package com.gugu.service.impl;

import com.gugu.mapper.AuditingMapper;
import com.gugu.mapper.ExpenseMapper;
import com.gugu.pojo.Auditing;
import com.gugu.service.AuditingService;
import com.gugu.util.SqlsesionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AuditingServiceImpl implements AuditingService {

    //添加请假的审核历史
    @Override
    public Integer save(Auditing auditing,Integer day) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        AuditingMapper mapper = sqlSession.getMapper(AuditingMapper.class);
        ExpenseMapper mapper2 = sqlSession.getMapper(ExpenseMapper.class);

        //审核业务的实现

        //获得审核的结果
        String result = auditing.getResult();
        if ("2".equals(result)){
            //证明审核通过

            //获得对请假天数进行判断
            if (day>5){
                //判断当前的审核人是否是gugu
                String empId = auditing.getEmpId();
                if ("gugu".equals(empId)){
                    //修改请假申请状态
                    mapper2.update(auditing.getExpId(),null,result);
                    //进行批准

                }else {
                    //修改下一个审核人
                    mapper2.update(auditing.getExpId(),"gugu",result);

                }
            }else {
                //修改请假申请状态
                mapper2.update(auditing.getExpId(),null,result);
                //进行批准

            }
        }else {
            //审核拒绝或者打回

            //修改请假申请的状态
            mapper2.update(auditing.getExpId(),null,result);
        }

        //添加审核记录的实现
        Integer insert = mapper.insert(auditing);
        sqlSession.close();
        return insert;
    }


    //按照条件查询指定信息：我的审核历史
    @Override
    public List<Auditing> findMore(String empid) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        AuditingMapper mapper = sqlSession.getMapper(AuditingMapper.class);
        List<Auditing> auditingList = mapper.selectMore(empid);
        sqlSession.close();
        return auditingList;
    }

    //查询审核备注（auditHistory.jsp）
    @Override
    public List<Auditing> findOne(Integer expid) {
        SqlSession sqlSession = SqlsesionUtil.getSqlSession();
        AuditingMapper mapper = sqlSession.getMapper(AuditingMapper.class);
        List<Auditing> auditingList2 = mapper.selectOne(expid);
        sqlSession.close();
        return auditingList2;
    }






}
