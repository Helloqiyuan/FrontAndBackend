package com.qiyuan.service.impl;

import com.qiyuan.dao.UserDao;
import com.qiyuan.dao.impl.UserDaoImpl;
import com.qiyuan.pojo.User;
import com.qiyuan.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        List<String> lines = userDao.findAll();
        //2.将用户数据封装成User对象
        List<User> userList = lines.stream().map(line->{
            String[] parts = line.split(",");
            Integer  id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();
        return userList;
    }
}
