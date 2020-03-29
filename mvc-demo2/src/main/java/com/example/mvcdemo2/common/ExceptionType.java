package com.example.mvcdemo2.common;

public enum  ExceptionType {
    SUCCESS(200,"成功"),
    USER_INPUT_ERROR(400,"用户输入异常"),
    SERVER_ERROR(500,"系统服务异常"),
    NOT_FOUND_ERROR(404,"没找到"),
    OTHER_ERROR(999,"其他未知异常"),
            ;
    private int code;
    private String msg;
    ExceptionType(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
