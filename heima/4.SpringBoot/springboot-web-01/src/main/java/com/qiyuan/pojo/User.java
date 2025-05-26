package com.qiyuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data //  自动提供getter、setter
@NoArgsConstructor //  自动提供无参构造方法
@AllArgsConstructor //  自动提供全参构造方法
public class User {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;

}
