package 多线程.多线程_1_线程创建.方式三_实现Callable接口;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// （1）创建一个实现Callable接口的实现类
class MyThread implements Callable {
    // （2）实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            try {
                // currentThread()：静态方法，返回执行当前代码的线程
                System.out.println(i + "线程名：" + Thread.currentThread().getName());
                // 让线程休眠1秒
                Thread.sleep(1000);
                // 如果i等于5，则退出线程
                if (i == 5) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // （3）创建Callable接口实现类的对象
        MyThread myThread = new MyThread();

        // （4）创建FutureTask的对象，将Callable接口实现类的对象，作为参数传递到FutureTask构造器中
        FutureTask futureTask = new FutureTask(myThread);

        // （5）将FutureTask的对象，作为参数传递到Thread类的构造器中，创建Thread对象，并调用start
        // 或者用：new Thread(futureTask).start();
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            // （6）获取Callable中call方法的返回值
            // get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}