package com.qiyuan;

import com.qiyuan.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWeb01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb01Application.class, args);
        User user = new User();
    }

}
