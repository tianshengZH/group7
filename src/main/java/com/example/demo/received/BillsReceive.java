package com.example.demo.received;

public class BillsReceive {
    public float getDollarIncome() {
        return dollarIncome;
    }

    public void setDollarIncome(float dollarIncome) {
        this.dollarIncome = dollarIncome;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    private float dollarIncome;
    private String pName;
    private String email;
    private int uid;
    private int pid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
