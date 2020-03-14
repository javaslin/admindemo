package com.sl.boot.admindemo.vo.resp;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class LoginResp<T> {
    private Integer code;

    private String msg;

    private Integer type;

    private T data;


    public LoginResp() {
        super();
        this.code = 200;
        this.msg = "";
        this.type = 0;
    }

    public LoginResp(T t) {
        super();
        this.code = 200;
        this.msg = "";
        this.data = t;
    }

    public LoginResp(Integer count, T t) {
        super();
        this.code = 200;
        this.msg = "";
        this.type = count;
        this.data = t;
    }

    public LoginResp(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public LoginResp(Integer code, String msg, T data) {
        super();
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
}
