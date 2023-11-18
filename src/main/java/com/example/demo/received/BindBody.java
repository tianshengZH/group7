package com.example.demo.received;

public class BindBody {
    private String email;
    private int userId;
    private String newNumber;
    private String oldNumber;
    private int acType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNewNumber() {
        return newNumber;
    }

    public int getAcType() {
        return acType;
    }

    public void setAcType(int acType) {
        this.acType = acType;
    }

    public void setNewNumber(String newNumber) {
        this.newNumber = newNumber;
    }

    public String getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(String oldNumber) {
        this.oldNumber = oldNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
