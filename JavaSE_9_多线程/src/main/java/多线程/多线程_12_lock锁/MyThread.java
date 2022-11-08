package 多线程.多线程_12_lock锁;

import java.util.concurrent.locks.ReentrantLock;

// 通过实现Runnable，重写run()方法，来开发线程
class MyThread implements Runnable {
    private int ticket = 100;//定义一百张票
    // 实例化锁
    private ReentrantLock lock = new ReentrantLock();

    // 重写接口的run()方法，写上自己的逻辑
    @Override
    public void run() {
        while (true) {
            // 调用锁定方法lock
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售出第" + ticket + "张票");
                ticket--;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);
        t1.setName("窗口1");
        t2.setName("窗口1");
        t3.setName("窗口1");
        t1.start();
        t2.start();
        t3.start();
    }
}

