package com.example.demo.controller;

import com.example.demo.util.MyException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: linxueqin
 * @Description: 统一异常处理
 * @date: Created on 2018/11/21 21:15
 **/
@RestController
@RequestMapping(value="/hello")
public class HelloController {

    @ApiOperation(value="统一处理错误", notes="")
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public String hello() throws MyException{
        throw new MyException("发生错误");
    }
}
