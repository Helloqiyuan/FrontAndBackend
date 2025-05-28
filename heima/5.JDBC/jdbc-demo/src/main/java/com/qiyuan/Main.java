package com.qiyuan;

import com.qiyuan.pojo.User;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        User user = new User(1,  "admin", "123456", "管理员", 18);
        System.out.println(user);
    }
}