package 多线程.多线程_8_生命周期;

// 通过继承于Thread类，重写Thread类的run()方法，来开发线程
class MyThread extends Thread {
    // 重写Thread类的run()，写上自己的逻辑
    @Override
    public void run() {
        System.out.println("子线程开始");

        try {
            // 让线程休眠3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
