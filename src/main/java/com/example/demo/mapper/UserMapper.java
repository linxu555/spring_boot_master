package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: linxueqin
 * @Description: 用户信息
 * @date: Created on 2018/11/21 18:54
 **/
@Mapper
public interface UserMapper {
    /**
     * 获取用户信息
     * @return 用户信息列表
     */
    List<User> findUserInfos();

    /**
     * 根据name获取用户信息
     * @param name 用户名
     * @return 用户信息列表
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    /**
     * 插入用户信息
     * @param name 用户名
     * @param age 用户年龄
     * @return 用户信息列表
     */
    @Insert("INSERT INTO user(name,age) VALUES (#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
