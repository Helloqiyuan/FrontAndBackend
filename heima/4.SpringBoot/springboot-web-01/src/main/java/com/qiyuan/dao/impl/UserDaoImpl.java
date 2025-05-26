package com.qiyuan.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.qiyuan.dao.UserDao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll(){
        //1.加载并读取user.txt文件，获取用户数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, "utf-8", new ArrayList<>());
        return lines;
    }
}
