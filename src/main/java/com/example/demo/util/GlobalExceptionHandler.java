package com.example.demo.util;

import com.example.demo.entity.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * -@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。
 * @author: linxueqin
 * @Description: 全局异常处理类
 * @date: Created on 2018/11/22 8:42
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 为MyException异常创建对应的处理
     * -@ExceptionHandler用来定义函数针对的异常类型
     * -@ResponseBody，就能让处理函数return的内容转换为JSON格式。
     * @param request http请求
     * @param e 自定义的异常
     * @return 异常信息
     * @throws Exception 异常
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request,MyException e) throws Exception{
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.Error);
        r.setData("some data");
        r.setUrl(request.getRequestURL().toString());
        return r;
    }
}
