package 多线程.多线程_9_API方法;

//创建继承于Thread类的子类（打印100以内的偶数）
class MyThread1 extends Thread{
    //重写Thread类的run()
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i+"   优先级："+getPriority());
            }
        }
    }
}
