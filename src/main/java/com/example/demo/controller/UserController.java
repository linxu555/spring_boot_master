package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author: linxueqin
 * @Description: 实现对User对象的操作接口
 * @date: Created on 2018/11/21 10:23
 **/
@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public long postUser(@RequestBody @ApiParam(name = "user", value = "用户信息", required = true)User user){
        return userService.insertUserInfo(user);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value = "/getInfoById/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return userService.getInfoById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value = "/updateInfo", method = RequestMethod.PUT)
    public long putUser(@RequestBody @ApiParam(name = "user", value = "用户信息", required = true)User user){
        return userService.updateUserInfo(user);
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @RequestMapping(value = "/deleteUserInfo/{id}", method = RequestMethod.DELETE)
    public long deleteUser(@PathVariable Long id){
        return userService.deleteUserInfo(id);
    }

    @RequestMapping(value = "/getUserByName/{name}",method = RequestMethod.GET)
    @ApiOperation(value="查询用户", notes="根据用户名查询用户信息")
    public User getUserByName(@PathVariable String name){
        return userService.findByName(name);
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ApiOperation(value="获取用户", notes="查询所有用户信息")
    public List<User> getUserInfos(){
        return userService.findUserInfos();
    }

}
