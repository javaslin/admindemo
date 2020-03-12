package com.sl.boot.admindemo.vo.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class BaseResp<T> {

    private Integer code;

    private String msg;

    private Integer count;

    private T data;


    public BaseResp() {
        super();
        this.code = 0;
        this.msg = "";
        this.count = 0;
    }

    public BaseResp(T t) {
        super();
        this.code = 0;
        this.msg = "";
        this.data = t;
    }

    public BaseResp(Integer count, T t) {
        super();
        this.code = 0;
        this.msg = "";
        this.count = count;
        this.data = t;
    }

    public BaseResp(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public BaseResp(Integer code, String msg, T data) {
        super();
        this.data = data;
        this.code = code;
        this.msg = msg;
    }


}
