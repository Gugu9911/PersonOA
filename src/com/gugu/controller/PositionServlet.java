package com.gugu.controller;


import com.google.gson.Gson;
import com.gugu.pojo.Dept;
import com.gugu.pojo.Position;
import com.gugu.service.PositionService;
import com.gugu.service.impl.PositionServiceImpl;
import com.gugu.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/gugu/PositionServlet")
public class PositionServlet extends BaseServlet {

    private PositionService positionService = new PositionServiceImpl();

   //删除部门的实现
   protected void posiRemove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

       int posid = Integer.parseInt(req.getParameter("posid"));
       int remove = positionService.remove(posid);

       resp.sendRedirect(req.getContextPath()+"/gugu/PositionServlet?method=posiFindAll");

   }





    //修改部门的操作
    protected void posiChange(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Integer posid = Integer.parseInt(req.getParameter("posid"));
        String pname = req.getParameter("pname");
        String pdesc = req.getParameter("pdesc");

        Position position= new Position(posid,pname,pdesc);
        int change = positionService.change(position);
        if (change>0){
            resp.sendRedirect(req.getContextPath()+"/gugu/PositionServlet?method=posiFindAll");
        }else {
            req.setAttribute("msg","修改失败");
            req.getRequestDispatcher("/positionUpdate.jsp").forward(req,resp);
        }


    }



    //查询单个部门的信息(进行修改功能的前提)
    protected void posiFindOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //接受前台页面中的数据
        int posid = Integer.parseInt(req.getParameter("posid"));

        //数据处理
        Position position = positionService.findOne(posid);

        //根据结果进行响应
        req.setAttribute("position",position);
        req.getRequestDispatcher("/positionUpdate.jsp").forward(req,resp);
    }



    //查询所有部门
    protected void posiFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //接受前台页面中的数据

        //数据处理
        List<Position> list = positionService.findAll();

        //根据结果进行响应
        req.setAttribute("list",list);
        req.getRequestDispatcher("/positionList.jsp").forward(req,resp);
    }



    //增加部门
    protected void posiSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //接手前台页面中数据
        Integer posid = Integer.parseInt(req.getParameter("posid"));
        String pname = req.getParameter("pname");
        String pdesc = req.getParameter("pdesc");
        Position position = new Position(posid,pname,pdesc);

        //数据的处理- 连接数据库
        int save = positionService.save(position);

        //根据结果，给前台用户做出响应
        if (save>0) {
            //重定向到查询页面
            resp.sendRedirect(req.getContextPath()+"/gugu/PositionServlet?method=posiFindAll");
        }else {
            req.setAttribute("msg","添加失败");
            req.getRequestDispatcher("/positionList.jsp").forward(req,resp);

        }
    }


    //查询所有部门:ajax方法
    protected void positionFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Position> list = positionService.findAll();
        String json = new Gson().toJson(list);
        resp.getWriter().print(json);
    }



}
