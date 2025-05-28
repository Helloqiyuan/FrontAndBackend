package com.qiyuan.controller;

import com.qiyuan.pojo.User;
import com.qiyuan.service.UserService;
import com.qiyuan.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
* 用户信息Controller
 */
@RestController
/*
@RestController = @Controller + @ResponseBody
@ResponseBody注解
    作用:将Controller(下面的各个方法)返回值直接作为响应体的数据直接响应;返回值是对象/集合->json->响应
 */
public class UserController {
    //如果有多个bean 则可以用
    /**
     * 方法一
     * @Resource(name = "userServiceImpl")
     *
     * 方法二
     * 2.@Autowired
     *@Qualifier("userServiceImpl")
     *
     */

    @Autowired
    private UserService userService;
//    @RequestMapping("/list")
//    public List<User> list(){
//        //1.加载并读取user.txt文件，获取用户数据
//        InputStream in =
//                this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> lines =
//                IoUtil.readLines(in, "utf-8", new ArrayList<>());
//        //2.将用户数据封装成User对象
//        List<User> userList =lines.stream().map(line->{
//            String[] parts = line.split(",");
//            Integer  id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime  updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new User(id, username, password, name, age, updateTime);
//        }).toList();
//
//        //3.返回数据(json) 服务器会自动封装成json格式
//        return userList;
//    }
    @RequestMapping("/list")
    public List<User> list(){
        List<User> userList = userService.findAll();

        //返回数据(json) 服务器会自动封装成json格式
        return userList;
    }
}
