package com.cxw.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommonResult
 * @Author xuwen_chen
 * @Date 2022-02-17 1:05
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code,String msg) {
        this(code, msg, null);
    }
}
