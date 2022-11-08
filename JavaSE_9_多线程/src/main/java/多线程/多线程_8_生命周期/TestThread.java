package 多线程.多线程_8_生命周期;


public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        //创建Thread类的子类MyThread1的对象，可以当做线程使用
        MyThread myThread = new MyThread();

        // 获取线程状态
        System.out.println("线程状态："+myThread.getState());
        // 启动线程
        myThread.start();

        // 如果状态不为终止状态（TERMINATED）就一直输出当前状态
        while (Thread.State.TERMINATED !=myThread.getState()){
            // 获取线程状态
            System.out.println("线程状态："+myThread.getState());
            // 让线程休眠1秒
            Thread.sleep(1000);
        }

        // 获取线程状态
        System.out.println("线程状态："+myThread.getState());

    }
}
