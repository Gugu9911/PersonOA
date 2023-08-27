package com.gugu.controller;


import com.google.gson.GsonBuilder;
import com.gugu.pojo.Duty;
import com.gugu.pojo.Employee;
import com.gugu.service.DutyService;
import com.gugu.service.impl.DutyServiceImpl;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/gugu/DutyServlet")
public class DutyServlet extends BaseServlet{

    private DutyService dutyService = new DutyServiceImpl();



    //我的考勤查询
    protected void dutyFindSome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {

        Employee employee = (Employee) req.getSession().getAttribute("employee");
        String empId = employee.getEmpId();
        //数据处理
        List<Duty> list = dutyService.findSome(empId);

        //做出响应
        req.setAttribute("list",list);
        req.getRequestDispatcher("/myDuty.jsp").forward(req,resp);
    }





    //POI导出用户信息
    protected void dutyPOI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String empid = req.getParameter("empid");
        String deptno = req.getParameter("deptno");
        String dtdate = req.getParameter("dtdate");

        List<Duty> list = dutyService.findMore(empid, deptno, dtdate);

        //把数据导出成excel
        createExcel(list,resp);


    }

    private static void createExcel(List<Duty> list,HttpServletResponse response) {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("考勤表");

        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                4 // last column
        );
        sheet.addMergedRegion(region);

        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("考勤列表");

        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        /*  */
        headCell.setCellStyle(cellStyle);


        // 添加表头行
        hssfRow = sheet.createRow(1);
        // 添加表头内容
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("姓名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("部门");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("考勤日期");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("签到时间");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(4);
        headCell.setCellValue("签退时间");
        headCell.setCellStyle(cellStyle);


        // 添加数据内容
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            Duty duty = list.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(duty.getRealName());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(duty.getDeptname());
            cell.setCellStyle(cellStyle);


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(duty.getDtDate());
            cell = hssfRow.createCell(2);
            cell.setCellValue(format);
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(3);
            cell.setCellValue(duty.getSigninTime());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(4);
            cell.setCellValue(duty.getSignoutTime());
            cell.setCellStyle(cellStyle);
        }

        // 保存Excel文件
        try {
            //OutputStream outputStream = new FileOutputStream("D:/students.xls");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=duty.xls");

            OutputStream outputStream= response.getOutputStream();
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







    //查询考勤信息的实现
    protected void dutyFindMore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String empid = req.getParameter("empid");
        String deptno = req.getParameter("deptno");
        String dtdate = req.getParameter("dtdate");

        List<Duty> list = dutyService.findMore(empid, deptno, dtdate);
        String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);
        resp.getWriter().print(json);


    }


    //用户签退的实现
    protected void dutySignOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前台页面数据
        java.util.Date date = new Date();
        java.sql.Date dtDate = new java.sql.Date(date.getTime());

        //获得签退的时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String signoutTime = simpleDateFormat.format(date);

        //获得当前登录用户的id
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        Duty duty = new Duty(dtDate, signoutTime, employee.getEmpId());

        //数据处理 返回结果
        int i = dutyService.signOut(duty);

        //做出响应
        resp.getWriter().print(i);
    }




    //用户签到实现
    protected void dutySignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接收前台页面中的数据
        java.util.Date date = new Date();
        java.sql.Date dtDate = new java.sql.Date(date.getTime());

        //获得签到的时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String signinTime = simpleDateFormat.format(date);

        //获得当前登录用户的id
        Employee employee = (Employee) req.getSession().getAttribute("employee");

        Duty duty = new Duty( dtDate,signinTime, "00:00:00", employee.getEmpId());

        //数据的当前处理 返回结果
        int i = dutyService.signIn(duty);

        //给用户做出响应
        resp.getWriter().print(i);

    }
}
