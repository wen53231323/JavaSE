package 多线程.多线程_7_线程守护;

// 通过继承于Thread类，重写Thread类的run()方法，来开发线程
class MyThread extends Thread {
    // 重写Thread类的run()，写上自己的逻辑
    @Override
    public void run() {
        // 无限循环
        for (; ; ) {
            try {
                System.out.println("子线程------");
                // 让线程休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建Thread类的子类MyThread1的对象，可以当做线程使用
        MyThread myThread = new MyThread();

        // 设置子线程为守护线程，当主线程结束时，守护线程自动结束（设置守护进程 应在启动线程之前）
        myThread.setDaemon(true);

        // 启动线程
        myThread.start();

        for (int i = 0; i <= 3; i++) {
            System.out.println("--------主线程");
            // 让线程休眠1秒
            Thread.sleep(1000);
        }
    }
}
