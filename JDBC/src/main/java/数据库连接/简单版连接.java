package 数据库连接;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class 简单版连接 {
    @Test
    //精简版
    public void test() throws Exception {
        //1.加载驱动
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8","root", "123456");
        System.out.println(con);
    }
}
