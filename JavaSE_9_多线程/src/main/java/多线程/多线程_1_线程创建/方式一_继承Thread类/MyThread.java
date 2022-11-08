package 多线程.多线程_1_线程创建.方式一_继承Thread类;

// （1）通过继承于Thread类，重写Thread类的run()方法，来开发线程
class MyThread extends Thread {
    // （2）重写Thread类的run()，写上自己的逻辑
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                // currentThread()：静态方法，返回执行当前代码的线程
                System.out.println(i +"线程名：" + Thread.currentThread().getName() +  "   优先级：" + getPriority());
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

    // （3）创建子类的对象，通过此对象调用start()启动线程
    public static void main(String[] args) {
        // 创建Thread类的子类MyThread1的对象，可以当做线程使用
        MyThread myThread = new MyThread();
        // 调用start()启动线程
        myThread.start();
    }
}
