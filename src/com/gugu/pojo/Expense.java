package com.gugu.pojo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 报销单
 * @author Administrator
 *
 */
public class Expense {

	private  int expId;//申请单编号  序列自增
	private String empId;//申请人编号  添加时使用
	private double totalAmount;//请假总天数
	private Date expTime;//申请递交的时间  yyyMMdd
	private String expDesc;//请假总备注信息
	private String nextAuditor;//下一个审核人的编号
	private String lastResult;//最新的审核结果  数据中该列虽然有冗余，可以提高效率
	private String  status;//请假申请的状态     0：新创建  1：审核中   2 审核结束通过  3 审核拒绝  4 审核打回   5.已打款


	//添加报销真是姓名
	private   String  realName;

	private String auditDesc;

	public String getAuditDesc() {
		return auditDesc;
	}

	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Expense() {
		super();
	}
	public Expense(String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor, String lastResult, String status) {
		this.empId = empId;
		this.totalAmount = totalAmount;
		this.expTime = expTime;
		this.expDesc = expDesc;
		this.nextAuditor = nextAuditor;
		this.lastResult = lastResult;
		this.status = status;
	}

	public Expense(String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor) {
		this.empId = empId;
		this.totalAmount = totalAmount;
		this.expTime = expTime;
		this.expDesc = expDesc;
		this.nextAuditor = nextAuditor;
	}


	public Expense(int expId, String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor, String lastResult, String status) {
		this.expId = expId;
		this.empId = empId;
		this.totalAmount = totalAmount;
		this.expTime = expTime;
		this.expDesc = expDesc;
		this.nextAuditor = nextAuditor;
		this.lastResult = lastResult;
		this.status = status;
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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getExpTime() {
		return expTime;
	}

	public void setExpTime(Date expTime) {
		this.expTime = expTime;
	}

	public String getExpDesc() {
		return expDesc;
	}

	public void setExpDesc(String expDesc) {
		this.expDesc = expDesc;
	}

	public String getNextAuditor() {
		return nextAuditor;
	}

	public void setNextAuditor(String nextAuditor) {
		this.nextAuditor = nextAuditor;
	}

	public String getLastResult() {
		return lastResult;
	}

	public void setLastResult(String lastResult) {
		this.lastResult = lastResult;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Expense{" +
				"expId=" + expId +
				", empId='" + empId + '\'' +
				", totalAmount=" + totalAmount +
				", expTime=" + expTime +
				", expDesc='" + expDesc + '\'' +
				", nextAuditor='" + nextAuditor + '\'' +
				", lastResult='" + lastResult + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
