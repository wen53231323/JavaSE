package 多线程.多线程_6_线程的礼让与插队;

// 通过继承于Thread类，重写Thread类的run()方法，来开发线程
class MyThread extends Thread {
    // 重写Thread类的run()，写上自己的逻辑
    @Override
    public void run() {

        for (int i = 0; i < 6; i++) {
            try {
                System.out.println(i + "子线程------");
                // 让线程休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建Thread类的子类MyThread1的对象，可以当做线程使用
        MyThread myThread = new MyThread();
        // 启动线程
        myThread.start();

        // 设置子线程插队
        for (int i = 0; i < 6; i++) {
            System.out.println("--------主线程" + i);
            if (i == 3) {
                System.out.println("=================让子线程插队================");
                // 调用对方的join方法，让子线程插队
                myThread.join();

                System.out.println("=================礼让子线程================");
                // 调用Thread的静态方法yield()，设置线程礼让
                Thread.yield();
            }
        }
    }
}
