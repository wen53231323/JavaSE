package jdbc练习;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 操作 extends 连接与关闭 {

    ///增加操作
    public int add(student stu) {
        //获得连接
        Connection con = getCon();
        PreparedStatement ps = null;
        //执行sql语句
        int n = 0;
        String sql = "insert into student(stuid,stuage,classid)values(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, stu.getStuid());
            ps.setInt(2, stu.getStuage());
            ps.setInt(3, stu.getClassid());
//			ps.setString(4, stu.getStuname());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeAll(null, ps, con);
        }
        return n;
    }

    //删除
    public int name(int stuid) {
        //获得连接
        Connection con = getCon();
        PreparedStatement ps = null;
        //执行sql语句
        String sql = "delete from student where stuid=?";
        int n = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, stuid);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeAll(null, ps, con);
        }
        return n;
    }

    //修改
    public int updatastudent(student stu) {
        //获得连接
        Connection con = getCon();
        PreparedStatement ps = null;
        //执行sql语句
        int n = 0;
        String sql = "updata student set stuname=?,stuage?,classid=?where stuid?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, stu.getStuname());
            ps.setInt(2, stu.getStuid());
            ps.setInt(3, stu.getStuage());
            ps.setInt(4, stu.getClassid());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            closeAll(null, ps, con);
        }

        return n;
    }


    public static void main(String[] args) {
        操作 stu = new 操作();
        //增
        student test = new student(1, 2, 3);
        int b = stu.add(test);
        if (b > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }

    }
}