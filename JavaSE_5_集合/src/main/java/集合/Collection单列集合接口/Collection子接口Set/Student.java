package 集合.Collection单列集合接口.Collection子接口Set;

public class Student implements Comparable {

    private int id;
    private String name;

    // 比较器：实现Comparable接口，重写compareTo
    // 按照姓名从大到小排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student t = (Student) o;
            return this.name.compareTo(t.name);
        } else {
            throw new RuntimeException("输入的数据类型不匹配");
        }
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
