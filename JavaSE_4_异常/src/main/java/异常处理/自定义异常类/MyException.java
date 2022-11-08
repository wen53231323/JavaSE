package 异常处理.自定义异常类;


// 自定义异常类
// 步骤：
//（1）继承于现有的异常结构：RuntimeException 、Exception
//（2）提供全局常量：serialVersionUID
//（3）提供重载的构造器
public class MyException extends Exception {
    // 提供全局常量：serialVersionUID
    static final long serialVersionUID = -5641210210148784L;

    // 用于保存异常发生的原因
    private String message;

    // 构造器
    public MyException() {
    }

    // 构造器
    public MyException(String message) {
        super(message);
        this.message = message;
    }

}
