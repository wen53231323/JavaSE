package 多线程.多线程_9_API方法;


//创建继承于Thread类的子类（打印100以内的奇数）
class MyThread2 extends Thread{
    //重写Thread类的run()
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+i+"   优先级："+getPriority());
            }
        }
    }
    //构造器中线程命名
    public MyThread2(String name){
        super(name);
    }
}