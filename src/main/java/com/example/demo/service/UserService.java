package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: linxueqin
 * @Description: service层
 * @date: Created on 2018/11/21 18:48
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名获取用户信息
     * @param name 请求的用户信息
     * @return 用户信息列表
     */
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    /**
     * 获取所有用户的信息
     * @return 所有用户信息列表
     */
    public List<User> findUserInfos(){
        return userMapper.findUserInfos();
    }

    public long insertUserInfo(User user) {
        return userMapper.insertUserInfo(user);
    }

    public User getInfoById(Long id) {
        return userMapper.getInfoById(id);
    }

    public long updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    public long deleteUserInfo(Long id) {
        return userMapper.deleteUserInfo(id);
    }
}
