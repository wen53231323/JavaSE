
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 打印类的信息，包括类的构造函数，成员函数，成员变量
 */
public class ClassUtil {

    /**
     * 获取对象的成员方法的信息
     */
    public static void printClassMethodMessage(Object obj) {
        // 要获取类的信息 首先要获取类的类类型,传递的是哪个子类的对象 c就是该子类的类类型
        Class clazz = obj.getClass();
        // 获取类的名称
        System.out.println("类的名称是:" + clazz.getName());
        // Method类，方法对象 一个成员方法就是一个Method对象
        // getDeclaredMethods()获取的是所有该类自己声明的方法，不包括访问权限
        Method[] declaredMethods = clazz.getDeclaredMethods();
        // getMethods()方法获取的是所有的public的函数，包括父类继承而来的
        Method[] ms = clazz.getMethods();
        for (int i = 0; i < ms.length; i++) {
            // 得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            // 得到方法的名称
            System.out.print(ms[i].getName() + "(");
            // 获取参数类型--->得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

    /**
     * 获取对象的成员变量的信息
     */
    public static void printFieldMessage(Object obj) {
        Class clazz = obj.getClass();
        // 成员变量也是对象 java.lang.reflect.Field Field类封装了关于成员变量的操作
        // getFields()方法获取的是所有的public的成员变量的信息
        Field[] fields = clazz.getFields();
        // getDeclaredFields获取的是该类自己声明的成员变量的信息
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            // 得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            // 得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    /**
     * 打印对象的构造函数的信息
     */
    public static void printConMessage(Object obj) {
        Class clazz = obj.getClass();
        // 构造函数也是对象 java.lang.Constructor中封装了构造函数的信息
        Constructor[] constructors = clazz.getConstructors();
        // getConstructors获取所有的public的构造函数 getDeclaredConstructors得到所有的构造函数
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.print(constructor.getName() + "(");
            // 获取构造函数的参数列表--->得到的是参数列表的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }
}