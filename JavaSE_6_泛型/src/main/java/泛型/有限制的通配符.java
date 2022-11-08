package 泛型;

import org.junit.Test;

import java.util.List;
//有限制条件的通配符：
// <? extends Person>
// G<? extends Person>可以作为G<A>和G<B>的父类，其中B是A的子类
// <? super Person>可以作为G<A>和G<B>的父类，其中B是A的父类
public class 有限制的通配符 {
    @Test
   public void test(){
        List<? extends Person> list1=null;
        List<? super Person> list2=null;

        List<Student> list3=null;
        List<Person> list4=null;
        List<Object> list5=null;

        list1=list3;
        list1=list4;
        //list1=list5;

        //list2=list3;
        list2=list4;
        list2=list5;

    }
}
class Person{

}
class Student extends Person{

}