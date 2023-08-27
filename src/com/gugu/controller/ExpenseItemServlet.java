package com.gugu.controller;


import com.gugu.pojo.Employee;
import com.gugu.pojo.ExpenseItem;
import com.gugu.service.ExpenseItemService;
import com.gugu.service.impl.ExpenseItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/gugu/ExpenseItemServlet")
public class ExpenseItemServlet extends BaseServlet {

    private ExpenseItemService expenseItemService = new ExpenseItemServiceImpl();

    protected void expenseItemFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String empId = employee.getEmpId();
        Integer expid = Integer.parseInt(req.getParameter("expid"));
        //处理数据
        List<ExpenseItem> expenseItemlist = expenseItemService.findAll(expid);
        //做出响应
        req.setAttribute("expenseItemlist",expenseItemlist);
        req.getRequestDispatcher("/expenseDetail.jsp").forward(req,resp);
    }
}
