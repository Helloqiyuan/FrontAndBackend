package com.qiyuan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//表示当前类时一个请求处理类
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("name" + name);
        return "Hello" + name + "~";
    }
    @RequestMapping("/test")
    public String test(){
        return "这是测试相应";
    }

}
