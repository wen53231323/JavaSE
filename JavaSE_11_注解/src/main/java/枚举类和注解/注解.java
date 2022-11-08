package 枚举类和注解;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;

import static java.lang.annotation.ElementType.*;


@MyAnnotation(value = "test")
public class 注解 {

    @MyAnnotation
    public int id;

    @MyAnnotation
    public void test() {
    }
}

/**
 * 自定义注解
 * 自定义注解使用@interface声明
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@interface MyAnnotation {
    // 方法名称就是配置参数，可以为基本类型、String、enum、Class，通过default声明参数的默认值
    String value() default "参数默认值";
}



