package com.qiyuan;

import com.qiyuan.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {
    @Test
    public void testUpdate() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/web";
        String username = "root";
        String password = "QQ666666";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        int i = statement.executeUpdate("update user set age = 29 where id = 1");
        System.out.println(i);
        connection.close();
        statement.close();

    }
    @Test
    public void testSelect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/web";
        String username = "root";
        String password = "QQ666666";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "daqiao");
        statement.setString(2, "'123456' or 1=1");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            User user = new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)
            );
            System.out.println(user);
        }
        connection.close();
        statement.close();
        resultSet.close();
    }
}
