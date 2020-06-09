package com.edu.online.exception;

public class XDException extends RuntimeException {
    private Integer code;
    private String msg;

    public XDException() {
    }

    public XDException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public XDException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public XDException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
