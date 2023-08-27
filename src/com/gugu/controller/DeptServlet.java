package com.gugu.controller;

import com.google.gson.Gson;
import com.gugu.pojo.Dept;
import com.gugu.service.DeptService;
import com.gugu.service.impl.DeptServiceImpl;
import com.gugu.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/gugu/DeptServlet")
public class DeptServlet extends BaseServlet {

    private DeptService deptService = new DeptServiceImpl();

    //Ajax方式查询部门的操作
    private void deptFindAll2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Dept> list = deptService.findAll2();
        String json = new Gson().toJson(list);
        resp.getWriter().print(json);
    }



    //删除部门的实现
    private void deptRemove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接受前台页面中的数据
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        //数据的处理，返回结果- 连接数据库
        int remove = deptService.remove(deptno);
        //根据结果作出响应
        resp.sendRedirect(req.getContextPath()+"/gugu/DeptServlet?method=deptFindAll");

    }


    //修改部门的实现
    private void deptChange(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //接受前台页面中的数据
        Integer deptno = Integer.parseInt(req.getParameter("deptno"));
        String deptname = req.getParameter("deptname");
        String location = req.getParameter("location");
        Dept dept= new Dept(deptno,deptname,location);
        //数据的处理，返回结果- 连接数据库
        int change = deptService.change(dept);
        //根据结果作出响应
        if (change>0){
            resp.sendRedirect(req.getContextPath()+"/gugu/DeptServlet?method=deptFindAll");
        }else {
            req.setAttribute("msg","修改失败");
            req.getRequestDispatcher("/deptUpdate.jsp").forward(req,resp);
        }

    }


    //查询单个部门
    private void deptFindOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受前台页面中的数据
        int deptno = Integer.parseInt(req.getParameter("deptno"));

        //数据的处理，返回结果- 连接数据库
        Dept dept = deptService.findOne(deptno);
        //根据结果作出响应
        req.setAttribute("dept",dept);
        req.getRequestDispatcher("/deptUpdate.jsp").forward(req,resp);
    }



    //查询所有部门实现
    private void deptFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受前台页面中的数据
        String index = req.getParameter("index");

        int ind=1;
        if (index !=null &&!"".equals(index)){
            ind = Integer.parseInt(index);
        }

        PageBean pg = new PageBean();
        pg.setIndex(ind);
        //设置总条数
        pg.setTotalCount(deptService.getCount());
        //获得开始下标
        int start = pg.getStartRow();
        //获得每一页显示的条数
        int size = pg.getSize();

        //数据的处理，返回结果- 连接数据库
        List<Dept> list = deptService.findAll(start,size);
        pg.setList(list);
        //根据结果作出响应
        req.setAttribute("pg",pg);
        req.getRequestDispatcher("/deptList.jsp").forward(req,resp);
    }


    //添加部门操作
    private void deptSave(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //接手前台页面中数据
        Integer deptno = Integer.parseInt(req.getParameter("deptno"));
        String deptname = req.getParameter("deptname");
        String location = req.getParameter("location");
        Dept dept = new Dept(deptno,deptname,location);

        //数据的处理- 连接数据库
        int save = deptService.save(dept);

        //根据结果，给前台用户做出响应
        if (save>0) {
            //重定向到查询页面
            resp.sendRedirect(req.getContextPath()+"/gugu/DeptServlet?method=deptFindAll");
        }else {
            req.setAttribute("msg","添加失败");
            req.getRequestDispatcher("/deptAdd.jsp").forward(req,resp);
        }

    }
}
