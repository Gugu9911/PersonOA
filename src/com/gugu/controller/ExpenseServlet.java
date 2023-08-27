package com.gugu.controller;

import com.google.gson.GsonBuilder;
import com.gugu.pojo.Employee;
import com.gugu.pojo.Expense;
import com.gugu.pojo.ExpenseItem;
import com.gugu.service.ExpenseService;
import com.gugu.service.impl.ExpenseServiceImpl;
import org.apache.log4j.helpers.DateTimeDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/gugu/ExpenseServlet")
public class ExpenseServlet extends BaseServlet{

    private ExpenseService expenseService = new ExpenseServiceImpl();


    //查询:我的请假申请
    protected void expenseFindSome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        String empId = employee.getEmpId();

        List<Expense> expenseList = expenseService.findSome(empId);

        req.setAttribute("expenseList",expenseList);
        req.getRequestDispatcher("/myExpense.jsp").forward(req,resp);
    }




    //查询所有待审请假申请的实现
    protected void expenseFindMore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        List<Expense> list = expenseService.findMore(employee.getEmpId());
        String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
        resp.getWriter().print(json);
    }


    //添加请假申请的实现
    protected void expenseSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**********************接受请假申请的数据***************************/
        double totalAmount = Double.parseDouble(req.getParameter("totalAmount"));
        String nextAuditor = req.getParameter("nextAuditor");
        String expDesc = req.getParameter("expDesc");
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        java.sql.Date expTime = new java.sql.Date(new Date().getTime());
        Expense expense = new Expense(employee.getEmpId(),totalAmount, expTime, expDesc, nextAuditor);

        /**************************接收请假的具体日期+动向****************************/

        //[通信费用,通信费用]
        String[] types = req.getParameterValues("type");
        //[1000,4000]
        String[] amounts = req.getParameterValues("amount");
        String[] itemDescs = req.getParameterValues("itemDesc");

        List<ExpenseItem>  list=new ArrayList<>();
        for (int i = 0; i <types.length ; i++) {

            String type = types[i];
            Double amount =Double.parseDouble(amounts[i]);
            String itemDesc = itemDescs[i];

            ExpenseItem  expenseItem=new ExpenseItem(type,amount,itemDesc);
            list.add(expenseItem);

        }

        int save = expenseService.save(expense,list);

        resp.getWriter().print(save);

    }
}
