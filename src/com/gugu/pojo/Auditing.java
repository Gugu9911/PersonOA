package com.gugu.pojo;

import java.util.Date;

public class Auditing {

    private int auditId; //审核编号
    private int expId; //请假单编号

    private String empId; //审核人编号
    private String result;//审核结果 通过 打回 拒绝
    private String auditDesc;//审核意见
    private Date time;

    //
    private String realName;
    private double totalAmount;
    private Date expTime;
    private String expDesc;

    public String getExpDesc() {
        return expDesc;
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc;
    }

    public Date getExpTime() {
        return expTime;
    }

    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    //
    public Auditing() {
    }

    public Auditing(int auditId, int expId, String empId, String result, String auditDesc, Date time) {
        this.auditId = auditId;
        this.expId = expId;
        this.empId = empId;
        this.result = result;
        this.auditDesc = auditDesc;
        this.time = time;
    }

    public Auditing(int expId, String empId, String result, String auditDesc, java.sql.Date time) {
        this.expId = expId;
        this.empId = empId;
        this.result = result;
        this.auditDesc = auditDesc;
        this.time = time;
    }

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Auditing{" +
                "auditId=" + auditId +
                ", expId=" + expId +
                ", empId='" + empId + '\'' +
                ", result='" + result + '\'' +
                ", auditDesc='" + auditDesc + '\'' +
                ", time=" + time +
                '}';
    }
}
