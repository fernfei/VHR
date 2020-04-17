package com.fern.vhr.utils;

/**
 * 系统全局异常码定义
 */
public enum ErrorCodeEnum {
    SYS_ERROR("SYS_ERROR", "系统错误"),
    UNKNOWN_ERROR("UNKNOWN_SYS_ERROR", "未知系统异常"),
    SERVICE_INVOKE_FAIL("SERVICE_INVOKE_FAIL", "服务调用失败"),
    ILLEGAL_ARGS("ILLEGAL_ARGS", "参数校验错误");

    /**
     * 异常码
     */
    private String code;
    /**
     * 异常信息
     */
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static ErrorCodeEnum getErrorByCode(String code) {
        for (ErrorCodeEnum value : ErrorCodeEnum.values()) {
            if (code.equals(value.code)) {
                return value;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
