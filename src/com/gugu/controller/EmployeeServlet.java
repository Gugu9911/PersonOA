package com.gugu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gugu.pojo.Dept;
import com.gugu.pojo.Employee;
import com.gugu.pojo.Position;
import com.gugu.service.DeptService;
import com.gugu.service.EmployeeService;
import com.gugu.service.PositionService;
import com.gugu.service.impl.DeptServiceImpl;
import com.gugu.service.impl.EmployeeServiceImpl;
import com.gugu.service.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet("/gugu/EmployeeServlet")
public class EmployeeServlet  extends  BaseServlet{

    private EmployeeService  employeeService=new EmployeeServiceImpl();
    private DeptService  deptService=new DeptServiceImpl();
    private PositionService positionService=new PositionServiceImpl();

    //注销登录
    protected void  empLoginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //注销当前的session
            req.getSession().invalidate();
        //跳转到登录页面
        resp.sendRedirect(req.getContextPath()+"/login.jsp");
    }

    //员工登录实现
    protected void  empLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String empid = req.getParameter("empid");
        String pwd = req.getParameter("pwd");

        Employee employee = employeeService.login(empid, pwd);
        if(employee != null){
            /*********************使用session完成登录的实现*************************/
            req.getSession().setAttribute("employee",employee);

            resp.sendRedirect(req.getContextPath()+"/main.html");
        }else {
            req.setAttribute("msg","登陆失败");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }





    //删除员工实现
    protected void  empRemove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");

        int remove = employeeService.remove(empid);

        resp.getWriter().print(remove);
    }




    //修改员工实现
    protected void  empChange(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受前台页面数据
        String empId = req.getParameter("empId");
        String password = req.getParameter("password");
        Integer deptno =Integer.parseInt(req.getParameter("deptno"));
        Integer posid = Integer.parseInt(req.getParameter("posid"));
        String mgrid = req.getParameter("mgrid");
        String realName = req.getParameter("realName");
        String sex = req.getParameter("sex");
        Date birthDate = java.sql.Date.valueOf(req.getParameter("birthDate")) ;
        Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate")) ;
        Date leaveDate = java.sql.Date.valueOf(req.getParameter("leaveDate")) ;
        Integer onDuty =Integer.parseInt(req.getParameter("onDuty"));
        Integer empType =Integer.parseInt(req.getParameter("empType")) ;
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String emerContactPerson = req.getParameter("emerContactPerson");
        String idCard = req.getParameter("idCard");

        Employee  employee = new Employee(empId,  password,  deptno,  posid,  mgrid,  realName,  sex,  birthDate,
                hireDate,  leaveDate,  onDuty,  empType,  phone,  qq,  emerContactPerson,  idCard);

        //数据的处理
        int change = employeeService.change(employee);
        //给用户做出响应
        resp.getWriter().print(change);
    }


    //查询单个员工信息
    protected void  empFindOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String empid = req.getParameter("empid");

        Employee employee = employeeService.findOne(empid);

        //上级领导的集合
        List<Employee> mgrList = employeeService.findMgr();
        //所有部门集合
        List<Dept> deptList = deptService.findAll2();
        //所有岗位信息查询
        List<Position> posList = positionService.findAll();

        req.setAttribute("employee",employee);
        req.setAttribute("mgrList",mgrList);
        req.setAttribute("deptList",deptList);
        req.setAttribute("posList",posList);

        req.getRequestDispatcher("/empUpdate.jsp").forward(req,resp);

    }


    //按照条件查询员工实现
    protected void  empFindMore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受前台页面中数据
        String empid = req.getParameter("empid");
        String deptno = req.getParameter("deptno");
        String onduty = req.getParameter("onduty");
        String hireDate = req.getParameter("hireDate");
        //[2]数据处理
        List<Employee> list = employeeService.findMore(empid, deptno, onduty, hireDate);

        //[3]给用户做出响应

//        String json = new Gson().toJson(list);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String json = gson.toJson(list);

        resp.getWriter().print(json);


    }

    //添加员工实现
    protected void  empSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受前台页面数据
        String empId = req.getParameter("empId");
        String password = req.getParameter("password");
        Integer deptno =Integer.parseInt(req.getParameter("deptno"));
        Integer posid = Integer.parseInt(req.getParameter("posid"));
        String mgrid = req.getParameter("mgrid");
        String realName = req.getParameter("realName");
        String sex = req.getParameter("sex");
        Date birthDate = java.sql.Date.valueOf(req.getParameter("birthDate")) ;
        Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate")) ;
        Date leaveDate = java.sql.Date.valueOf(req.getParameter("leaveDate")) ;
        Integer onDuty =Integer.parseInt(req.getParameter("onDuty"));
        Integer empType =Integer.parseInt(req.getParameter("empType")) ;
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String emerContactPerson = req.getParameter("emerContactPerson");
        String idCard = req.getParameter("idCard");

        Employee  employee=new Employee(empId,  password,  deptno,  posid,  mgrid,  realName,  sex,  birthDate,
                hireDate,  leaveDate,  onDuty,  empType,  phone,  qq,  emerContactPerson,  idCard);
        //[2]数据处理

        int save = employeeService.save(employee);

        //[3]给用户做出响应
        resp.getWriter().print(save);
    }


    //查询上级领导实现
    protected void  empFindMgr(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Employee> list = employeeService.findMgr();

        String json = new Gson().toJson(list);
        resp.getWriter().print(json);
    }



    //查询单个员工：我的信息.jsp
    protected void  empFindOne3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        String empId = employee.getEmpId();

        Employee employeeone3 = employeeService.findOne3(empId);

        req.setAttribute("employeeone3",employeeone3);
        req.getRequestDispatcher("/myInfo.jsp").forward(req,resp);

    }






}
