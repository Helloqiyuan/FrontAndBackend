package com.qiyuan;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.aop.TargetSource;

@DisplayName("用户信息测试类")
public class UserServiceTest {
//    @BeforeAll //在所有的单元测试方法运行之前,运行一次
//    public static void beforeAll(){
//        System.out.println("Before All");
//    }
//
//    @AfterAll //在所有的单元测试方法运行之后,运行一次
//    public static void afterAll(){
//        System.out.println("After All");
//    }
//
//    @BeforeEach //在每个单元测试方法运行之前,都会运行一次
//    public void beforeEach(){
//        System.out.println("before Each");
//    }
//    @AfterEach //在每个单元测试方法运行之后,都会运行一次
//    public void afterEach(){
//        System.out.println("after Each");
//    }
    @Test
    public void testAgeNull(){
        UserService userService = new UserService();
        //断言
        Assertions.assertThrows(IllegalArgumentException.class,()->userService.getAge(null));
    }

    @Test
    public void testGenderNull(){
        UserService userService = new UserService();
        //断言
        Assertions.assertThrows(IllegalArgumentException.class,()->userService.getGender(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"","100000200010011011777"})
    public void testGetAge(String idCard){
        UserService userService = new UserService();
        Assertions.assertThrows(IllegalArgumentException.class,()->userService.getAge(idCard));
    }

    @ParameterizedTest
    @ValueSource(strings = {"","100000200010011011777"})
    public void testGetGender(String idCard){
        UserService userService = new UserService();
        Assertions.assertThrows(IllegalArgumentException.class,()->userService.getGender(idCard));
    }
    @ParameterizedTest
    @ValueSource(strings = {"100000200010011012","100000200010011013"})
    public void testGetAgeWithParam(String idCard){
        UserService userService = new UserService();
        Integer age = userService.getAge(idCard);
        System.out.println(age);
    }

//    /*
//    断言
//     */
//    @Test
//    public void testGenderWithAssert(){
//        UserService userService = new UserService();
//        String gender = userService.getGender("100000200010011011");
//        //断言
//        Assertions.assertEquals("男",gender,"性别获取逻辑有问题");
//    }
//
//    @Test
//    public void testGenderWithAssert2(){
//        UserService userService = new UserService();
//        String gender = userService.getGender("100000200010011011");
//        //断言
//        Assertions.assertThrows(IllegalArgumentException.class,()->userService.getGender(null));
//    }

    /*
    参数化测试
     */
    @DisplayName("测试用户性别")
    @ParameterizedTest
    @ValueSource(strings = {"100000200010011011","100000200010011012","100000200010011023"})
    public void testGenderWithParam(String idCard){
        UserService userService = new UserService();
        String gender = userService.getGender(idCard);
        //断言
        System.out.println(gender);
    }
    @Test
    public void testMain(){
        Main.main(null);
    }
}
