package com.example.demo.result;

public class Result<T> {
    private int code;
    private String msg;
    private T data;
    public static <T> Result<T> success(T data){return new Result<T>(data);}
    public static <T> Result<T> error(CM cm){return new Result<T>(cm);}
    public int getCode() {
        return code;
    }

    public Result(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }
    public Result(CM cm) {
        this.code = cm.getCode();
        this.msg = cm.getMsg();

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
