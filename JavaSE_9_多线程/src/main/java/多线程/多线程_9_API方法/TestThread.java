package 多线程.多线程_9_API方法;

public class TestThread {
    public static void main(String[] args) {
        //创建Thread类的子类的对象
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2("线程二：");

        //设置线程优先级
        t1.setPriority(6);
        t2.setPriority(Thread.MAX_PRIORITY);


        //设置当前线程名称
        t1.setName("线程一：");
        t2.setName("线程二：");

        // 通过此对象调用start()
        t1.start();
        t2.start();

        //给主线程命名
        Thread.currentThread().setName("主线程：");

        //如下操作在main线程中执行
        System.out.println(Thread.currentThread().getName()+"hello,word!"+"   获取线程优先级："+Thread.currentThread().getPriority());

        System.out.println("判断当前线程是否存在："+t1.isAlive());
    }
}
