package com.qiyuan.mapper;


import com.qiyuan.pojo.User;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper //应用程序在运行时，会自动的为该接口创建一个实现类对象(代理对象),并且会自动将该实现类对象存入IOC容器中 -> bean
public interface UserMapper {
    /**
     * 查询所有用户
     */
//    @Select("select * from user")
    public List<User> findAll();

    /**
     * 根据id删除用户
     */
    @Delete("delete from user where id = #{id}")
    public Integer deleteById(Integer id);

    /**
     * 添加用户
     */
    @Insert("insert into user(username, password, name, age) value (#{username},#{password},#{name},#{age})")
    public Integer insert(User user);

    /**
     * 更新用户
     */
    @Insert("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    public Integer update(User user);

    /**
     * 根据username和密码查询用户
     */
    @Select("select * from user where username = #{un} and password = #{pwd}")
    public User findByUsernameAndPassword(@Param("un") String username,@Param("pwd") String password);


}
