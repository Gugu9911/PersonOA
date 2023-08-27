package com.gugu.service;

import com.gugu.pojo.Auditing;

import java.util.List;

public interface AuditingService {

    //添加请假的审核历史
    Integer save(Auditing auditing,Integer day);

    //按照条件查询指定信息：我的审核历史
    List<Auditing> findMore(String empid);

    //查询审核备注（auditHistory.jsp）
    List<Auditing> findOne(Integer expid);
}
