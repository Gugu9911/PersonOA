package com.gugu.controller;


import com.google.gson.Gson;
import com.gugu.service.EChartsService;
import com.gugu.service.impl.EChartsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/gugu/EChartsServlet")
public class EChartsServlet extends BaseServlet {

    private EChartsService eChartsService = new EChartsServiceImpl();

    protected void positionChart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List list = eChartsService.findAll();
        String json = new Gson().toJson(list);
        resp.getWriter().print(json);

    }


    protected void deptChart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List list = eChartsService.findAll2();
        String json = new Gson().toJson(list);
        resp.getWriter().print(json);

    }
}
