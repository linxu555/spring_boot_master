package com.example.demo.controller;

import com.example.demo.util.MyException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value="aop切面测试", notes="web请求做切面来记录日志")
    @RequestMapping(value = "/aopTest",method = RequestMethod.GET)
    @ResponseBody
    public String aopTest(@RequestParam @ApiParam(name = "name", value = "名称", required = true)String name){
        return "hello aop:"+name;
    }
}
