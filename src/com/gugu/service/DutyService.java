package com.gugu.service;

import com.gugu.pojo.Duty;
import com.gugu.pojo.Position;

import java.util.Date;
import java.util.List;

public interface DutyService {

    //签到操作的实现
    int signIn(Duty duty);

    //签退的实现
    int signOut(Duty duty);

    //考勤信息的查询
    List<Duty> findMore(String empid, String deptno,String dtdate);


    //我的考勤：查询考勤表
    List<Duty> findSome(String empId);
}
