package com.gugu.controller;

import com.google.gson.Gson;
import com.gugu.pojo.Auditing;
import com.gugu.pojo.Employee;
import com.gugu.service.AuditingService;
import com.gugu.service.impl.AuditingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/gugu/AuditingServlet")
public class AuditingServlet extends BaseServlet{

    private AuditingService auditingService = new AuditingServiceImpl();

    //  查询审核备注（auditHistory.jsp）
    protected void auditFindOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Integer expid = Integer.parseInt(req.getParameter("expid"));

        List<Auditing> auditingList2 = auditingService.findOne(expid);

        req.setAttribute("auditingList2",auditingList2);
        req.getRequestDispatcher("/auditHistory.jsp").forward(req,resp);
    }




    //按照条件查询指定信息：我的审核历史
    protected void auditFindMore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        String empId = employee.getEmpId();


        List<Auditing> auditingList = auditingService.findMore(empId);


        req.setAttribute("auditingList",auditingList);
        req.getRequestDispatcher("/myAudit.jsp").forward(req,resp);


    }




    //请假申请信息的添加
    protected void auditSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer expId = Integer.parseInt(req.getParameter("expId"));
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        String result = req.getParameter("result");
        String auditDesc = req.getParameter("auditDesc");
        java.sql.Date time = new java.sql.Date(new Date().getTime());

        //接收请假总天数
        int day = Integer.parseInt(req.getParameter("day"));

        Auditing auditing = new Auditing(expId, employee.getEmpId(), result, auditDesc,time);

        AuditingService auditingService = new AuditingServiceImpl();
        Integer save = auditingService.save(auditing,day);
        resp.getWriter().print(save);
    }


}
