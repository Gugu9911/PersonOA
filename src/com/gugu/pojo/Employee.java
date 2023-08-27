package com.gugu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

    private String empId;//员工编号
    private String password;//密码
    private  Integer   deptno ;//部门编号
    private  Integer  posid;//岗位编号
    private  String  mgrid;//上级领导编号
    private String realName;//真实姓名
    private String sex;//性别
    private Date birthDate;//出生日期
    private Date hireDate;//入职日期
    private Date leaveDate;//离职日期
    private Integer onDuty;//是否在职  0-离职  1-在职
    private Integer  empType;//员工类型  1.普通员工  2.管理人员 含经理、总监、总裁等  3.管理员
    private String phone;//联系方式
    private String qq;
    private String emerContactPerson;//紧急联系人信息
    private String idCard;//身份证号码

    //方法一：把另外两个对象依赖到当前对象中
/*    private Dept dept;
    private Position position;*/

    //方法二：适用于字段比较少的情况
    private String deptname;
    private String pname;



    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }



    public Employee() {
    }

    public Employee(String empId, String password, Integer deptno, Integer posid, String mgrid, String realName, String sex, Date birthDate, Date hireDate, Date leaveDate, Integer onDuty, Integer empType, String phone, String qq, String emerContactPerson, String idCard) {
        this.empId = empId;
        this.password = password;
        this.deptno = deptno;
        this.posid = posid;
        this.mgrid = mgrid;
        this.realName = realName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.leaveDate = leaveDate;
        this.onDuty = onDuty;
        this.empType = empType;
        this.phone = phone;
        this.qq = qq;
        this.emerContactPerson = emerContactPerson;
        this.idCard = idCard;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getMgrid() {
        return mgrid;
    }

    public void setMgrid(String mgrid) {
        this.mgrid = mgrid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Integer getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(Integer onDuty) {
        this.onDuty = onDuty;
    }

    public Integer getEmpType() {
        return empType;
    }

    public void setEmpType(Integer empType) {
        this.empType = empType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmerContactPerson() {
        return emerContactPerson;
    }

    public void setEmerContactPerson(String emerContactPerson) {
        this.emerContactPerson = emerContactPerson;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", password='" + password + '\'' +
                ", deptno=" + deptno +
                ", posid=" + posid +
                ", mgrid='" + mgrid + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", leaveDate=" + leaveDate +
                ", onDuty=" + onDuty +
                ", empType=" + empType +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", emerContactPerson='" + emerContactPerson + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
