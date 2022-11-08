package 多线程.多线程_4_线程的终止;

// 通过继承于Thread类，重写Thread类的run()方法，来开发线程
class MyThread extends Thread {
    private int sum = 0;
    private boolean loop = true;

    // 重写Thread类的run()，写上自己的逻辑
    @Override
    public void run() {
        while (loop) {
            try {
                // currentThread()：静态方法，返回执行当前代码的线程
                System.out.println(++sum + "线程名：" + Thread.currentThread().getName() + "   优先级：" + getPriority());
                // 让线程休眠1秒
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建Thread类的子类MyThread的对象，可以当做线程使用
        MyThread myThread = new MyThread();
        // 调用start()启动线程
        myThread.start();

        // stop()：已过时，当执行此方法时，强制结束当前线程
        // myThread.stop();

        // 休眠5秒
        Thread.sleep(1000*5);

        // 设置false，退出线程
        myThread.setLoop(false);
    }
}
