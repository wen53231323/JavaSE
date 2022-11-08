package 多线程.多线程_5_线程的中断;

// 通过继承于Thread类，重写Thread类的run()方法，来开发线程
class MyThread extends Thread {
    private int sum = 0;

    // 重写Thread类的run()，写上自己的逻辑
    @Override
    public void run() {
        while (true) {
            try {
                // currentThread()：静态方法，返回执行当前代码的线程
                System.out.println(++sum + "线程名：" + Thread.currentThread().getName() + "   优先级：" + getPriority());
                // 让线程休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // InterruptedException 是捕获一个中断异常
                System.out.println("线程被中断了");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建Thread类的子类MyThread1的对象，可以当做线程使用
        MyThread myThread = new MyThread();
        // 调用start()启动线程
        myThread.start();
        // 睡眠5秒
        Thread.sleep(5000);
        // interrupt()：中断线程，不是停止，一般用于中断正在休眠的线程
        myThread.interrupt();
    }
}
