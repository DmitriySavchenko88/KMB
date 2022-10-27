package com.aimporsoft.api;

public class SuccessReg {
    private Integer code;
    public String type;
    private String message;

    public SuccessReg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public SuccessReg() {
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
