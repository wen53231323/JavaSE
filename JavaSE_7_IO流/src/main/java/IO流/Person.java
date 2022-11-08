package IO流;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 0;
    String name;
    int age;
    //构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //get、set、toString

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
