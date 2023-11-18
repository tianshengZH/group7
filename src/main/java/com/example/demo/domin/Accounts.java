package com.example.demo.domin;

public class Accounts {
    private int acId;
    private int userId;
    private String accountNumber;
    private int acType;

    public float getRMBIncome() {
        return RMBIncome;
    }

    public void setRMBIncome(float RMBIncome) {
        this.RMBIncome = RMBIncome;
    }

    public float getDollarIncome() {
        return dollarIncome;
    }

    public void setDollarIncome(float dollarIncome) {
        this.dollarIncome = dollarIncome;
    }

    private float RMBIncome;
    private  float dollarIncome;
    public int getAcId() {
        return acId;
    }

    public void setAcId(int acId) {
        this.acId = acId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAcType() {
        return acType;
    }

    public void setAcType(int acType) {
        this.acType = acType;
    }
}
