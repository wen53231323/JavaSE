package 多线程.多线程_10_线程同步;

class MyThread extends Thread {

    @Override
    public void run() {

    }

    // 方法中加入synchronized关键字，就是同步方法，该线程完成操作，其他线程才能对该内存地址进行操作
    // 非静态的同步方法，此时互斥锁在 this对象
    public synchronized void test1() {
        System.out.println("线程同步---");
    }

    // 静态的同步方法，此时互斥锁在 当前类本身（MyThread.class）
    public static synchronized void test2() {
        System.out.println("线程同步---");
    }

    // 非静态的同步方法，此时互斥锁在 this对象
    public void test3() {
        // 同步代码块
        synchronized (this) {
            System.out.println("线程同步---");
        }

    }

    // 静态的同步方法，此时互斥锁在 当前类本身（MyThread.class）
    public static void test4() {
        // 同步代码块
        synchronized (MyThread.class) {
            System.out.println("线程同步---");
        }

    }

}
