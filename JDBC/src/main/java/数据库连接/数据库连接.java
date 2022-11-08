package 数据库连接;

import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class 数据库连接 {
    @Test
    //方式一
    public void test1() throws SQLException {
//        //1.获取Driver接口实现类对象
//        //加载驱动
//        Driver driver = new com.mysql.jdbc.Driver();
//
//        //2.提供需要连接的数据库
//        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
//
//        //3.将用户名和密码封装在配置文件Properties中
//        Properties info = new Properties();
//        info.setProperty("user","root");
//        info.setProperty("password","123456");
//        //4.获取连接
//        Connection con=driver.connect(url, info);
//        System.out.println(con);
    }

    @Test
    //方式二：对方式一的迭代（使用了反射），
    //使得如下的方式不出现第三方API,使得程序具有更好的可移植性
    public void test2() throws Exception{
        //1.使用反射，获取Driver接口实现类对象
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver) clazz.newInstance();

        //2.提供需要连接的数据库
        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";

        //3.将用户名和密码封装在配置文件Properties中
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");

        //4.获取连接
        Connection con=driver.connect(url, info);
        System.out.println(con);
    }

    @Test
    //方式三：使用DriverManger替换Driver
    //使得如下的方式不出现第三方API,使得程序具有更好的可移植性
    public void test3() throws Exception{
        //1.获取Driver接口实现类对象
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver) clazz.newInstance();

        //2.提供另外三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
        String user="root";
        String password="123456";

        //3.注册驱动
        DriverManager.registerDriver(driver);

        //4.获取连接
        Connection con=DriverManager.getConnection(url, user, password);
        System.out.println(con);
    }

    @Test
    //方式四：方式三的优化
    //省略了注册驱动的步骤，可以只是加载驱动，不用显式的注册驱动了
    //在mysql的Driver实现类中注册了驱动
    public void testConnection4() throws Exception{
        //1.加载驱动
        Class clazz=Class.forName("com.mysql.jdbc.Driver");

        //2.提供另外三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
        String user="root";
        String password="123456";

        //3.获取连接
        Connection con= DriverManager.getConnection(url, user, password);
        System.out.println(con);
    }
    //方式五（final版）：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    //好处：
    //1.实现了数据与代码的分离，实现了解耦
    //2.如果需要修改配置文件信息，可以避免程序重新打包
    @Test
    public void test5() throws Exception{
        //1.读取配置文件中的4个基本信息
        //Properties()：用来读取配置文件
        Properties properties = new Properties();
        //加载配置文件（配置文件名后缀为.properties）
        FileInputStream f = new FileInputStream("jdbc\\JdbcTest\\mysql.properties");
        properties.load(f);//加载配置文件
        String url=properties.getProperty("url");//协议、ip、端口、数据库名
        String user=properties.getProperty("user");//用户名
        String password=properties.getProperty("password");//密码
        String driverclass=properties.getProperty("driverclass");//驱动名

        //2.加载驱动
        Class.forName(driverclass);

        //3.获取连接
        Connection con=DriverManager.getConnection(url, user, password);
        System.out.println(con);

    }
}
