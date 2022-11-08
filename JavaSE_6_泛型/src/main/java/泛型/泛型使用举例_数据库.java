package 泛型;

import org.junit.Test;

import java.util.List;

public class 泛型使用举例_数据库 {
    @Test
    public void test(){
        studentDAO stu = new studentDAO();
        stu.add(new student());
    }
}

//DAO：操作数据库的类
class DAO<T>{
    //增：添加一条记录
    public void add(T t){

    }
    //删：删除一条记录
    public boolean remove(int index){
        return false;
    }
    //改：修改一条记录
    public void update(int index){

    }
    //查：查询一条
    public T getT(int index){
        return null;
    }
    //查：查询多条记录
    public List<T> getlist(int index){
        return null;
    }
    //泛型方法：
    public <E> E getValue(){
        return null;
    }

}
//对应数据库中的student表
class student{

}

//用来操作学生表（继承DAO）
class studentDAO extends DAO<student>{

}

