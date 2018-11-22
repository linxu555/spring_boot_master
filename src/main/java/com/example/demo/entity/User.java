package com.example.demo.entity;

import lombok.Data;

/**
 * @author: linxueqin
 * @Description: TODO
 * @date: Created on 2018/11/21 10:21
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String password;
}
