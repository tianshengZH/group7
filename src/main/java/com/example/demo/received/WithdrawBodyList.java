package com.example.demo.received;
import java.util.*;
public class WithdrawBodyList {
    ArrayList<Integer> bid;
    String accountNumber;
    boolean flag;
    int type;

    public ArrayList<Integer> getBid() {
        return bid;
    }

    public void setBid(ArrayList<Integer> bid) {
        this.bid = bid;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
