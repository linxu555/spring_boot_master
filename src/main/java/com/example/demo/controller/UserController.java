package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    /**
     * 创建线程安全的map
     **/
    static Map<Long,User> userMap = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * @Description 获取用户列表
     * @Date 2018/11/21 10:38
     * @Param []
     * @return java.util.List<com.example.demo.entity.User>
     **/
    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> users = new ArrayList<User>(userMap.values());
        return users;
    }

    /**
     * @Description 处理post请求，用来创建User
     * @Date 2018/11/21 10:44
     * @Param [user]
     * @return java.lang.String
     **/
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        userMap.put(user.getId(),user);
        return "success";
    }
    /**
     * @Description 通过url中的id获取user信息
     * @Date 2018/11/21 10:48
     * @Param [id]
     * @return com.example.demo.entity.User
     **/
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@ModelAttribute Long id){

        return userMap.get(id);
    }

    /**
     * @Description  处理PUT请求，用来更新User信息
     * @Date 2018/11/21 10:53
     * @Param [id, user]
     * @return java.lang.String
     **/
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        User u = userMap.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        userMap.put(id,u);
        return "success";
    }

    /**
     * @Description 处理DELETE请求，用来删除user
     * @Date 2018/11/21 10:56
     * @Param [id]
     * @return java.lang.String
     **/
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        userMap.remove(id);
        return "successs";
    }

    /*@ApiOperation(value="查询用户", notes="根据用户名查找用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/getUserByName/{name}", method = RequestMethod.GET)
    @ResponseBody*/

    @RequestMapping(value = "/getUserByName",method = RequestMethod.GET)
    public User getUserByName(HttpServletRequest request){
        String name = request.getParameter("name");
        return userService.findByName(name);
    }

    @RequestMapping(value = "/getUserInfos",method = RequestMethod.GET)
    public List<User> getUserInfos(){

        return userService.findUserInfos();
    }

}
