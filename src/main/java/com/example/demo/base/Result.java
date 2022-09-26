package com.example.demo.base;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Result<T> {

    private Integer code;

    private T data;

    public Result success(T data){
        return new Result().setCode(200).setData(data);
    }
}
