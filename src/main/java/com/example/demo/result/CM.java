package com.example.demo.result;

public class CM {
    private int code;
    private String msg;
    public static CM SUCCCESS = new CM(0,"success");
    public static CM LOGINERROR = new CM(1,"LOGINERROR");
    public static CM REGISTERERROR = new CM(2,"REGISTERERROR, EMAIL HAS BEEN REGISTERED");
    public CM(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
