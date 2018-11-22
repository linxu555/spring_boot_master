package com.example.demo.entity;

import lombok.Data;

/**
 * @author: linxueqin
 * @Description: 统一的异常信息json返回对象
 * @date: Created on 2018/11/22 9:50
 **/
@Data
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer Error = 100;

    /**
     * 消息类型
     */
    private Integer code;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 请求的url
     */
    private String url;

    /**
     * 请求返回的数据
     */
    private T data;
}
