package com.gugu.pojo;

import java.io.Serializable;

public class ECharts implements Serializable {
    private int count;
    private int posid;
    private String pname;

    //
    private int value;
    private String name;

    public ECharts(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ECharts() {
    }


//
    public ECharts(int count, int posid, String pname) {
        this.count = count;
        this.posid = posid;
        this.pname = pname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPosid() {
        return posid;
    }

    public void setPosid(int posid) {
        this.posid = posid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
