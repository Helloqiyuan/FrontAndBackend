package com.qiyuan;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResonseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //1.设置响应状态码
        response.setStatus(404);
        //2.设置响应头
        response.setHeader("name","qiyuan");
        response.addHeader("age","18");
        //3.设置响应体
        response.getWriter().write("<h1>Hello World!<h>");
    }

}
