package com.example.demo.util;

/**
 * @author: linxueqin
 * @Description: 自定义异常 用来实验捕获该异常并返回json
 * @date: Created on 2018/11/22 9:52
 **/
public class MyException extends Exception {

    public MyException(String message){
        super(message);
    }
}
