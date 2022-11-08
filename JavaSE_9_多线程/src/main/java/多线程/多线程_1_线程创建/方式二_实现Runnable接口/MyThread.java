package 多线程.多线程_1_线程创建.方式二_实现Runnable接口;

// （1）通过实现Runnable接口，重写run()方法，来开发线程
class MyThread implements Runnable {
    // （2）重写Runnable接口的run()方法，写上自己的逻辑
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                // currentThread()：静态方法，返回执行当前代码的线程
                System.out.println(i +"线程名：" + Thread.currentThread().getName());
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
    }

    public static void main(String[] args) {
        // （3）创建Runnable接口实现类的对象
        MyThread myThread = new MyThread();
        // （4）创建Thread类的对象，将实现类的对象作为参数，传递到Thread类的构造器中
        Thread thread = new Thread(myThread);
        // （5）通过Thread类的对象调用start()启动线程
        thread.start();
    }
}