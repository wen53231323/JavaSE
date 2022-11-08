package 泛型;

public class 泛型练习{
    public static void main(String args[]){
        person<lxfs> per = null ;		// 声明Person对象
        per = new person<lxfs>(new lxfs("北京市","01088888888","102206")) ;
        System.out.println(per);

        person<grxx> per2 = null ;		// 声明Person对象
        per2 = new person<grxx>(new grxx("李雷","男",24));
        System.out.println(per2) ;
    }
}
// 只有此接口的子类才是表示人的信息
interface Info{
}

// 表示联系方式的类
class lxfs implements Info{
    private String lxdz ;	// 联系地址
    private String sjh ;	// 手机号
    private String yzbm ;	// 邮政编码

    //构造器
    public lxfs(String lxdz, String sjh, String yzbm) {
        this.lxdz = lxdz;
        this.sjh = sjh;
        this.yzbm = yzbm;
    }
    //get、set
    public String getLxdz() {
        return lxdz;
    }

    public void setLxdz(String lxdz) {
        this.lxdz = lxdz;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }
    //toString
    @Override
    public String toString() {
        return "lxfs{" +
                "lxdz=" + lxdz +
                ", sjh=" + sjh +
                ", yzbm=" + yzbm +
                '}';
    }
}
// 表示个人信息的类
class grxx implements Info{
    private String name ;		// 姓名
    private String sex ;		// 性别
    private int age ;			// 年龄

    //构造器
    public grxx(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    //get、set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString
    @Override
    public String toString() {
        return "grxx{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
//T继承接口，而lxfs、grxx实现了接口
//所以通过此类造对象可以声明lxfs、grxx的泛型
class person<T extends Info>{
    private T info ;
    public person(T info){		// 通过构造器设置信息属性内容
        this.info = info;
    }
    public void setInfo(T info){
        this.info = info ;
    }
    public T getInfo(){
        return info ;
    }
    @Override
    public String toString() {
        return "Person [info=" + info + "]";
    }
}

