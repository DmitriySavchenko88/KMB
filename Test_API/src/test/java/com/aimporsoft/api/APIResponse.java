package com.aimporsoft.api;

public class APIResponse {
    private Integer code;
    public String type;
    private String message;

    public APIResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public APIResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
