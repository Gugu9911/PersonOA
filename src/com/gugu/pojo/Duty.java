package com.gugu.pojo;

import java.sql.Date;

/**
 * 考勤类
 * @author Administrator
 *
 */
public class Duty {

	private int dtID;
	private Date dtDate;
	private String signinTime;
	private String signoutTime;
	private String emprId; //可以同时提供id和对象属性

	//直接存放两个字段
	private String realName;
	private String deptname;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getDtID() {
		return dtID;
	}
	public void setDtID(int dtID) {
		this.dtID = dtID;
	}
	public Date getDtDate() {
		return dtDate;
	}
	public void setDtDate(Date dtDate) {
		this.dtDate = dtDate;
	}
	public String getSigninTime() {
		return signinTime;
	}
	public void setSigninTime(String signinTime) {
		this.signinTime = signinTime;
	}
	public String getSignoutTime() {
		return signoutTime;
	}
	public void setSignoutTime(String signoutTime) {
		this.signoutTime = signoutTime;
	}
	public String getEmprId() {
		return emprId;
	}
	public void setEmprId(String emprId) {
		this.emprId = emprId;
	}



	public Duty(int dtID, Date dtDate, String signinTime, String signoutTime,
			String emprId) {
		super();
		this.dtID = dtID;
		this.dtDate = dtDate;
		this.signinTime = signinTime;
		this.signoutTime = signoutTime;
		this.emprId = emprId;
	}

	public Duty(Date dtDate, String signoutTime, String emprId) {
		this.dtDate = dtDate;
		this.signoutTime = signoutTime;
		this.emprId = emprId;
	}

	public Duty(Date dtDate, String signinTime, String signoutTime,
				String emprId) {
		super();
		this.dtDate = dtDate;
		this.signinTime = signinTime;
		this.signoutTime = signoutTime;
		this.emprId = emprId;
	}
	

	public Duty() {
		super();
	}
	@Override
	public String toString() {
		return "Duty [dtID=" + dtID + ", dtDate=" + dtDate + ", signinTime="
				+ signinTime + ", signoutTime=" + signoutTime + ", emprId="
				+ emprId + "]";
	}

	
	
	
	
}
