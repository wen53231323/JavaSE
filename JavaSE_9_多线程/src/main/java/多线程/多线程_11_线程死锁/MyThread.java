package 多线程.多线程_11_线程死锁;

// 通过继承于Thread类，重写Thread类的run()方法，来开发线程
class MyThread extends Thread {
    // 保证多线程，共享一个对象，这里使用static
    static Object o1 = new Object();
    static Object o2 = new Object();
    private boolean flag;

    public MyThread(boolean flag) {
        this.flag = flag;
    }

    // 重写Thread类的run()，写上自己的逻辑
    @Override
    public void run() {
        // 如果flag为true，线程A会先拿到o1的对象锁，然后尝试获取o2对象锁
        // 如果的不到o2的对象锁就会阻塞（Blocked）
        // 如果flag为false，线程B会先拿到o2的对象锁，然后尝试获取o1对象锁
        // 如果的不到o1的对象锁就会阻塞（Blocked）
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName()+"  进入1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName()+"  进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName()+"  进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName()+"  进入4");
                }
            }
        }
    }

    // 模拟线程死锁
    public static void main(String[] args) throws InterruptedException {
        //创建Thread类的子类MyThread1的对象，可以当做线程使用
        MyThread myThread1 = new MyThread(true);
        MyThread myThread2 = new MyThread(false);

        // 设置线程名称
        myThread1.setName("线程A");
        myThread2.setName("线程B");

        // 启动线程
        myThread1.start();
        myThread2.start();

        // 睡眠三秒
        Thread.sleep(3000);

        // 线程状态（BLOCKED）
        System.out.println("线程状态："+myThread1.getState());
        System.out.println("线程状态："+myThread2.getState());
    }
}
