package com.sl.boot.admindemo.enums;

public enum ResponseEnum {

    OK(200, "操作成功"),
    REQUEST_SUCCEED(200, "请求成功"),
    AUTH_CODE_ERROR(201, "验证码错误"),
    ACCOUNTS_EXIST(203, "帐号已存在"),
    ACCOUNTS_OR_PWD_ERROR(204, "账号或密码错误"),
    ACCOUNTS_NOT_EXIST(205, "帐号不存在,请先注册"),
    TOKEN_ERROR(402, "Token 错误"),
    OBJECT_NULL(404, "资源不存在"),
    HTTP_METHOD_ERROR(405, "HTTP Method错误"),
    HTTP_MEDIA_TYPE_ERROR(415, "HTTP Method错误"),
    SYSTEM_ERROR(500, "系统错误"),
    QUERY_PARAM_INVALID(400, "请求的业务参数不合法"),

    SYSTEM_BUSY_PLEASE_TRY_AGAIN_LATER(-1, "系统繁忙，请稍后重试"),

    SIG_ERROR(4001, "签名错误"),

    POST_PARAM_INVALID(4003, "POST参数不合法,缺少必须的:OperatorID,sig,TimeStamp,Data,Seq五个参数"),


    USERNAME_ERROR(5002, "用户名错误"),
    PWD_ERROR(5003, "密码错误"),
    STATUS_ERROR(5004, "帐号已禁用");

    private final int value;

    private final String reasonPhrase;

    ResponseEnum(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}
