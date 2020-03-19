package com.sl.boot.admindemo.vo.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class StaRep<T> {

    private Integer code;

    private String msg;

    private Integer count;

    private T dataX;

    private T dataY;

    private T dataY1;

    private T dataO;


    public StaRep() {
        super();
        this.code = 0;
        this.msg = "";
        this.count = 0;
    }


}
