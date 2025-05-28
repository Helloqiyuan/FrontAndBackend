package com.qiyuan;

import com.qiyuan.mapper.UserMapper;
import com.qiyuan.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootTest
@ComponentScan("com.qiyuan.mapper.UserMapper")
class SpringbootMybatisQuickstartApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testDeleteById(){
        Integer i = userMapper.deleteById(1);
    }

    /**
     * 新增测试
     */
    @Test
    public void testInsert(){
        User user = new User(null, "qiyuan", "123456", "qiyuan", 18);
        Integer i = userMapper.insert(user);
    }
    /**
     * 更新测试
     */
    @Test
    public void testUpdate(){
        User user = new User(2, "qiyuan", "123456", "qiyuan", 18);
        Integer i = userMapper.update(user);
    }
    /**
     * 查询测试
     */
    @Test
    public void testFindByUsernameAndPassword(){
        User user = userMapper.findByUsernameAndPassword("qiyuan", "123456");
        System.out.println(user);
    }
}
