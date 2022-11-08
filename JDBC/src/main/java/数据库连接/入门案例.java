package 数据库连接;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class 入门案例 {
    public static void main(String[] args) throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // System.out.println(conn);
        //3. 定义sql
        String sql = "update user set uID = 2000";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5. 执行sql
        int count = stmt.executeUpdate(sql);//受影响的行数
        //6. 处理结果
        System.out.println(count);
        //7. 释放资源
        stmt.close();
        conn.close();
    }

}
