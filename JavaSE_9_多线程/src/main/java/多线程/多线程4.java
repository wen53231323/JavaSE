package 多线程;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
创建线程的
方式四：使用线程池
（1）提供指定线程数量的线程池
（2）执行指定线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
（3）关闭线程池

设置线程池的属性
CorePoolSize：核心池的大小
maximumPoolSize：最大线程数
KeepAliveTime：线程没有任务时最多保持多长时间后会终止

*/
public class 多线程4 {
    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ExecutorService server = Executors.newFixedThreadPool(10);

        //设置线程池的属性
        ThreadPoolExecutor server1=(ThreadPoolExecutor) server;
        server1.setCorePoolSize(15);

        //执行指定线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        MyThread5 t5 = new MyThread5();
        MyThread6 t6 = new MyThread6();
        server.execute(t5);//适合适用于Runnable
        server.submit(t6);//适合使用于Callable

        //关闭线程池
        server.shutdown();

    }
}


class MyThread5 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"："+i);
            }
        }
    }
}

class MyThread6 implements Callable {
    //实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"："+i);
            }
        }
        return null;
    }
}

