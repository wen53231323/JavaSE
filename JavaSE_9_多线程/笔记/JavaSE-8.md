---
title: JavaSE笔记-多线程
date: 2021-06-01 3:00:00
categories: Java
tags: JavaSE
cover: java.png
toc: true
---

## 多线程概念相关

### 线程与进程

（1）进程与线程概念

| 概念            | 简介                                                         |
| --------------- | ------------------------------------------------------------ |
| 进程（process） | 可以理解为一个个正在执行的应用程序，例如使用网易云音乐软件播放音乐 |
| 线程（thread）  | 线程是程序执行的最小单元，一个进程中可以有多个线程，每个进程都有至少一个线程称为主线程，主线程可以在流程中创建其他线程，例如听歌时去评论，听歌是一个线程，评论又是一个线程，两个线程互不干扰，都属于网易云进程 |

（2）常用的Windows、Linux等操作系统都采用抢占式多任务，如何调度线程完全由操作系统决定，程序自己不能决定什么时候执行，以及执行多长时间

（3）同一个应用程序，既可以有多个进程，也可以有多个线程

| 模式               | 简介                         |
| ------------------ | ---------------------------- |
| 多进程模式         | 每个进程只有一个线程         |
| 多线程模式         | 一个进程有多个线程           |
| 多进程＋多线程模式 | 多个进程，每个进程有多个线程 |

### 单核CPU和多核CPU

| CPU     | 简介                                                         |
| ------- | ------------------------------------------------------------ |
| 单核CPU | 假的多线程，因为在一个时间单元内，只能执行一个线程的任务，若同时间段内有多个线程需要CPU去运行时，CPU也只能交替去执行多个线程中的一个线程，但是由于其执行速度特别快，会造成一种貌似同时的错觉，实际是交替执行 |
| 多核CPU | 多核cpu是一枚处理器中集成多个完整的计算引擎(内核)，每一个核心都可以独立执行一个线程，能更好的发挥多线程的效率 |

### 并行和并发

| 概念 | 简介                                                         |
| ---- | ------------------------------------------------------------ |
| 并行 | 同一时刻，多个任务同时执行，多核CPU可以实现并行和并发        |
| 并发 | 同一时刻，多个任务交替执行，单核CPU实现的多任务（由于处理的很快，会造成一种貌似同时的错觉，实际是交替执行） |

### 线程的优先级

（1）高优先级的线程要抢占低优先级线程的CPU的执行权，但是只是从概率上讲，高优先级的线程高概率被执行，并不意外着只有当高优先级的线程执行完以后，低优先级的线程才执行

| 优先级        | 值            |
| ------------- | ------------- |
| MIN_PRIORITY  | 1             |
| NORM_PRIORITY | 5，默认优先级 |
| MAX_PRIORITY  | 10            |

（2）相关方法

| 方法                         | 简介             |
| ---------------------------- | ---------------- |
| getPriority()                | 获取线程优先级   |
| setPriority(int newPriority) | 设置线程的优先级 |



## 线程的创建

### 方式一：继承于Thread类（重点）

（1）创建步骤

```java
1、创建一个继承于Thread类的子类
2、重写Thread类的run()
3、创建Thread类的子类对象
4、通过此子类对象调用start()启动线程
```

（2）代码实例

```java
// （1）通过继承于Thread类，重写Thread类的run()方法，来开发线程
class MyThread extends Thread {
    // （2）重写Thread类的run()，写上自己的逻辑
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                // currentThread()：静态方法，返回执行当前代码的线程
                System.out.println(i +"线程名：" + Thread.currentThread().getName() +  "   优先级：" + getPriority());
                // 让线程休眠1秒
                Thread.sleep(1000);
                // 如果i等于5，则退出线程
                if (i == 5) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        // （3）创建Thread类的子类MyThread的对象，可以当做线程使用
        MyThread myThread = new MyThread();
        // （4）通过此子类对象调用start()启动线程
        myThread.start();
    }
}
```

### 方式二：实现Runnable接口（重点）

（1）创建步骤

```java
1、创建一个实现Runnable接口的实现类
2、实现类重写Runnable接口中的抽象方法run()
3、创建Runnable接口实现类的对象
4、创建Thread类的对象，将实现类的对象作为参数，传递到Thread类的构造器中
5、通过Thread类的对象调用start()启动线程
```

（2）代码示例

```java
// （1）通过实现Runnable接口，重写run()方法，来开发线程
class MyThread implements Runnable {
    // （2）重写Runnable接口的run()方法，写上自己的逻辑
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                // currentThread()：静态方法，返回执行当前代码的线程
                System.out.println(i +"线程名：" + Thread.currentThread().getName());
                // 让线程休眠1秒
                Thread.sleep(1000);
                // 如果i等于5，则退出线程
                if (i == 5) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // （3）创建Runnable接口实现类的对象
        MyThread myThread = new MyThread();
        // （4）创建Thread类的对象，将实现类的对象作为参数，传递到Thread类的构造器中
        Thread thread = new Thread(myThread);
        // （5）通过Thread类的对象调用start()启动线程
        thread.start();
    }
}
```

### 方式三：实现Callable接口（了解）

（1）与使用Runnable相比， Callable功能更强大些

```java
1、相比run()方法，call()方法可以有返回值
2、call()方法可以抛出异常
3、Callable支持泛型的返回值
4、需要借助FutureTask类，比如获取返回结果
```

（2）创建步骤

```java
1、创建一个实现Callable接口的实现类
2、实现call方法，将此线程需要执行的操作声明在call()中
3、创建Callable接口实现类的对象
4、创建FutureTask的对象，将Callable接口实现类的对象作为参数传递到FutureTask构造器中
5、创建Thread对象，将FutureTask的对象作为参数传递到Thread类的构造器中，并调用start
6、获取Callable中call方法的返回值
```

（3）代码示例

```java
// （1）创建一个实现Callable接口的实现类
class MyThread implements Callable {
    // （2）实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            try {
                // currentThread()：静态方法，返回执行当前代码的线程
                System.out.println(i + "线程名：" + Thread.currentThread().getName());
                // 让线程休眠1秒
                Thread.sleep(1000);
                // 如果i等于5，则退出线程
                if (i == 5) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // （3）创建Callable接口实现类的对象
        MyThread myThread = new MyThread();

        // （4）创建FutureTask的对象，将Callable接口实现类的对象，作为参数传递到FutureTask构造器中
        FutureTask futureTask = new FutureTask(myThread);

        // （5）将FutureTask的对象，作为参数传递到Thread类的构造器中，创建Thread对象，并调用start
        // 或者用：new Thread(futureTask).start();
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            // （6）获取Callable中call方法的返回值
            // get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
```

### 三种创建方式的对比

（1）继承Thread

| 优缺点 | 简介                                   |
| ------ | -------------------------------------- |
| 优点   | 可以直接使用Thread类中的方法，代码简单 |
| 缺点   | 继承Thread类之后就不能继承其他的类     |

（2）实现Runnable接口

| 优缺点 | 简介                                                         |
| ------ | ------------------------------------------------------------ |
| 优点   | 即时自定义类已经有父类了也不受影响，因为可以实现多个接口     |
| 缺点   | 在run方法内部需要获取到当前线程的Thread对象后才能使用Thread中的方法 |

（3）实现Callable接口

| 优缺点 | 简介                                                        |
| ------ | ----------------------------------------------------------- |
| 优点   | 可以获取返回值，可以抛出异常                                |
| 缺点   | 代码编写较为复杂，与使用Runnable相比， Callable功能更强大些 |

## Thread类的常用方法

| 方法名                       | 介绍                                                         |
| ---------------------------- | ------------------------------------------------------------ |
| start()                      | 启动当前线程，底层调用当前线程的run()                        |
| interrupt()                  | 中断线程，不是停止，一般用于中断正在休眠的线程               |
| run()                        | 线程在被调度时执行的操作，单独调用不会启动新线程             |
| currentThread()              | 静态方法，返回执行当前代码的线程                             |
| getName()                    | 获取当前线程的名称                                           |
| setName(String name)         | 设置当前线程名称                                             |
| getPriority()                | 获取线程优先级                                               |
| setPriority(int newPriority) | `设置线程的优先级`， 高优先级的线程要抢占低优先级线程的CPU的执行权，但是只是从概率上讲，  高优先级的线程高概率被执行，并不意外着只有当高优先级的线程执行完以后，低优先级的线程才执行，默认优先级NORM_PRIORITY值为5、优先级MIN_PRIORITY值为1、优先级MAX_PRIORITY值为10 |
| getState()                   | 获取线程状态                                                 |
| sellp()                      | `线程的阻塞`（睡眠）指定的时间（毫秒数，1000毫秒=1秒）令当前活动线程在指定时间段内放弃对CPU控制,使其他线程有机会被执行,时间到后重排队，抛出InterruptedException异常，需要用try-catch捕获异常 |
| yield()                      | `线程的礼让`，让其他线程执行，但礼让的时间不确定，所以不一定礼让成功  释放当前CPU执行权，线程让步  暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程  若队列中没有同优先级的线程，忽略此方法 |
| join()                       | `线程的插队`，插队的线程一旦插队，则肯定先执行完插入的线程所有的任务  在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态  低优先级的线程也可以获得执行 |
| isAlive()                    | 判断当前线程是否存在                                         |
| stop()                       | 已过时，当执行此方法时，强制结束当前线程                     |



## 线程的终止与中断

### 线程的终止

当线程完成任务后，会自动退出，有时需要使用变量，来控制run方法停止线程，即通知方式

```java
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
```

### 线程的中断

```java
// 通过继承于Thread类，重写Thread类的run()方法，来开发线程
class MyThread extends Thread {
    private int sum = 0;

    // 重写Thread类的run()，写上自己的逻辑
    @Override
    public void run() {
        while (true) {
            try {
                // currentThread()：静态方法，返回执行当前代码的线程
                System.out.println(++sum + "线程名：" + Thread.currentThread().getName() + "   优先级：" + getPriority());
                // 让线程休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // InterruptedException 是捕获一个中断异常
                System.out.println("线程被中断了");
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        //创建Thread类的子类MyThread1的对象，可以当做线程使用
        MyThread myThread = new MyThread();
        // 调用start()启动线程
        myThread.start();
        // 睡眠5秒
        Thread.sleep(5000);
        // interrupt()：中断线程，不是停止，一般用于中断正在休眠的线程
        myThread.interrupt();
    }
}
```

## 线程的礼让与插队

| 礼让与插队 | 简介                                                   |
| ---------- | ------------------------------------------------------ |
| 礼让       | 让其他线程执行，但礼让的时间不确定，所以不一定礼让成功 |
| 插队       | 插队的线程一旦插队，则肯定先执行完插入的线程所有的任务 |

```java
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
```



## 用户线程和守护线程

| 线程分类 | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 用户线程 | 也叫工作线程，当线程的任务执行完或通知方式结束，如主线程     |
| 守护线程 | 一般是为工作线程服务的，当所有的用户线束结束，守护线程自动结束，常见的守护线程：垃圾回收机制、异常处理线程 |

```java
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
```

## 线程的生命周期

### 声命周期的过程

| 生命周期                    | 简介                                                         |
| --------------------------- | ------------------------------------------------------------ |
| 新建（NEW）                 | 初始状态，当一个Thread类或其子类的对象被声明并创建时，新生的线程对象处于新建状态 ，保持这个状态直到程序 start() 这个线程 |
| 就绪（RUNNABLE）            | 可运行状态/运行状态，处于新建状态的线程对象被start()后，将进入线程队列等待CPU时间片，  此时它已具备了运行的条件，只是没分配到CPU资源 |
| 运行（Running）             | 当就绪的线程被调度并获得CPU资源时，便进入运行状态，run()方法定义了线程的操作和功能，处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态 |
| 阻塞（Blocked）             | 阻塞状态，线程执行了sleep()方法（睡眠）或suspend()方法（挂起）或执行输入输出操作时，让出 CPU 并临时中止自己的执行，此时改线程进入阻塞状态，睡眠时间结束或获得设备资源后重新进入就绪状态 |
| 无时限等待（WAITING）       |                                                              |
| 有时限等待（TIMED_WAITING） |                                                              |
| 死亡（TERMINATED）          | 线程完成了它的全部工作或线程被提前强制性地中止或出现异常导致结束 |

### 阻塞状态的三种情况

| 阻塞状态 | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 等待阻塞 | 运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态   |
| 同步阻塞 | 线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用) |
| 其他阻塞 | 通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态 |



## 线程同步

### 多线程安全性问题

（1）已知问题：当多条语句在操作同一个线程共享数据时，一个线程只执行了一部分，还没有执行完，另一个线程参与进来执行，导致共享数据的错误。

（2）解决思路：使用同步访问技术，对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不可以参与执行。 

### 解决方式一：synchronized关键字互斥锁（独占锁）

（1）在多线程编程，一些敏感数据不允许被多个线程同时访问，此时就需要使用同步访问技术，线程同步保证数据在可同一时刻，最多有一个线程访问，以保证数据的完整性

| 概念     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 线程同步 | 当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，该线程完成操作，其他线程才能对该内存地址进行操作 |

（2）线程的同步使用synchronized关键字，根据位置不同分为同步代码块和同步方法

```java
// 同步方法
修饰符 synchronized 返回值 方法名(方法形参){}

// 同步代码块
synchronized(同步监视器){需要被同步的代码}
```

（3）同步监视器

```
同步监视器俗称锁，任何一个类的对象都能充当锁，但是要求多个线程必须要共用同一把锁
每个对象都对应于一个可称为“互斥锁“的标记，这个标记用来保证在任一时刻，能有一个线程访问该对象，保证共享数据操作的完整性。
使用关键字synchronized与对象的互斥锁联系，当某个对象用synchronized修饰时，表明该对象在任一时刻只能由一个线程访问
```

（4）线程同步优缺点

| 优缺点 | 简介                                                         |
| ------ | ------------------------------------------------------------ |
| 优点   | 解决了线程的安全问题                                         |
| 缺点   | 导致程序的执行效率要降低，操作同步代码时，只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低 |

（5）代码示例

```java
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
```

### 解决方式二：ReentrantLock互斥锁（独占锁）

（1）jdk中独占锁的实现除了使用关键字synchronized外，还可以使用ReentrantLock类，虽然在性能上ReentrantLock和synchronized没有什么区别，但ReentrantLock相比synchronized而言功能更加丰富，使用起来更为灵活，也更适合复杂的并发场景。

（2）ReentrantLock 类实现了 Lock 锁 ，拥有与 synchronized 相同的并发性和内存语义，但是添加了类似锁投票、定时锁等候和可中断锁等候的一些特性

（3）ReentrantLock锁可以被单个线程多次获取，但在同一个时间点只能被一个线程获取(当某线程获取到“锁”时，其它线程就必须等待)；是通过一个FIFO（先进先出）的等待队列来管理获取该锁所有线程的。

（4）ReentrantLock分为“公平锁”和“非公平锁”。它们的区别体现在获取锁的机制上是否公平。

| 锁       | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 公平锁   | 线程依次排队获取锁，表示线程获取锁的顺序是按照线程加锁的顺序来分配的，即先来先得的FIFO先进先出顺序 |
| 非公平锁 | 获取锁的抢占机制，是随机获得锁的，不管自己是不是在队列的开头都可能获取锁 |

（5）ReentrantLock类构造方法

| 构造器                      | 简介                                                         |
| --------------------------- | ------------------------------------------------------------ |
| ReentrantLock()             | 创建一个 ReentrantLock，默认是“非公平锁”。                   |
| ReentrantLock(boolean fair) | 创建策略是fair的 ReentrantLock，fair为true表示是公平锁，fair为false表示是非公平锁。 |

（6）类中的方法

| 方法                                                         | 简介                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| int getHoldCount()                                           | 查询当前线程保持此锁的次数                                   |
| protected Thread getOwner()                                  | 返回目前拥有此锁的线程，如果此锁不被任何线程拥有，则返回 null。 |
| protected Collection<Thread> getQueuedThreads()              | 返回一个 collection，它包含可能正等待获取此锁的线程。        |
| int getQueueLength()                                         | 返回正等待获取此锁的线程估计数                               |
| protected Collection<Thread> getWaitingThreads(Condition condition) | 返回一个 collection，它包含可能正在等待与此锁相关给定条件的那些线程。 |
| int getWaitQueueLength(Condition condition)                  | 返回等待与此锁相关的给定条件的线程估计数                     |
| boolean hasQueuedThread(Thread thread)                       | 查询给定线程是否正在等待获取此锁                             |
| boolean hasQueuedThreads()                                   | 查询是否有些线程正在等待获取此锁                             |
| boolean hasWaiters(Condition condition)                      | 查询是否有些线程正在等待与此锁有关的给定条件。               |
| boolean isFair()                                             | 如果是“公平锁”返回true，否则返回false。                      |
| boolean isHeldByCurrentThread()                              | 查询当前线程是否保持此锁                                     |
| boolean isLocked()                                           | 查询此锁是否由任意线程保持。                                 |
| `void lock()`                                                | 获取锁                                                       |
| void lockInterruptibly()                                     | 如果当前线程未被中断，则获取锁                               |
| Condition newCondition()                                     | 返回用来与此 Lock 实例一起使用的 Condition 实例。            |
| boolean tryLock()                                            | 仅在调用时锁未被另一个线程保持的情况下，才获取该锁。         |
| boolean tryLock(long timeout, TimeUnit unit)                 | 如果锁在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁。 |
| void unlock()                                                | 试图释放此锁                                                 |

（7）代码示例

```java
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
```

### synchronized与ReentrantLock的异同

（1）使用优先顺序：ReentrantLock -> 同步代码块 -> 同步方法

| 异同 | 简介                                                         |
| ---- | ------------------------------------------------------------ |
| 相同 | 二者都可以解决线程安全问题                                   |
| 不同 | synchronized机制在执行完相应的代码逻辑以后，自动的释放同步监视器<br>ReentrantLock需要手动的调用lock()启动同步，结束同步也需要手动的调用unlock()实现（lock的方式更为灵活） |

（2）与synchronized相比，ReentrantLock提供了更多，更加全面的功能，具备更强的扩展性。例如：时间锁等候，可中断锁等候，锁投票。

（3）ReentrantLock还提供了条件Condition，对线程的等待、唤醒操作更加详细和灵活，所以在多个条件变量和高度竞争锁的地方，ReentrantLock更加适合（下面会阐述Condition）。

（4）ReentrantLock提供了可轮询的锁请求。它会尝试着去获取锁，如果成功则继续，否则可以等到下次运行时处理，而synchronized则一旦进入锁请求要么成功，要么一直阻塞，所以相比synchronized而言，ReentrantLock会不容易产生死锁些。

（5）ReentrantLock支持更加灵活的同步代码块，但是使用synchronized时，只能在同一个synchronized块结构中获取和释放。注：ReentrantLock的锁释放一定要在finally中处理，否则可能会产生严重的后果。

（6）ReentrantLock支持中断处理，且性能较synchronized会好些。

（7） `lock 必须在 finally 块中释放`。否则，如果受保护的代码将抛出异常，锁就有可能永远得不到释放！这一点区别看起来可能没什么，但是实际上，它极为重要。忘记在 finally 块中释放锁，可能会在程序中留下一个定时炸弹，当有一天炸弹爆炸时，您要花费很大力气才有找到源头在哪。而使用同步，JVM 将确保锁会获得自动释放

（8） 当 JVM 用 synchronized 管理锁定请求和释放时，JVM 在生成线程转储时能够包括锁定信息。这些对调试非常有价值，因为它们能标识死锁或者其他异常行为的来源。 Lock 类只是普通的类，JVM 不知道具体哪个线程拥有 Lock 对象

### 线程死锁

（1）多个线程都占用了对方的锁资源，但不肯相让，导致了死锁（互相等待）

（2）死锁产生的必要条件

| 原因     |                                                              |
| -------- | ------------------------------------------------------------ |
| 互斥     | 进程对所分配到的资源不允许其他进程进行访问，若其他进程访问该资源，只能等待，直至占有该资源的进程使用完成后释放该资源 |
| 请求保持 | 进程获得一定的资源之后，又对其他资源发出请求，但是该资源可能被其他进程占有，此事请求阻塞，但又对自己获得的资源保持不放 |
| 不可剥夺 | 进程已获得的资源，在未完成使用之前，不可被剥夺，只能在使用完后自己释放 |
| 循环等待 | 进程发生死锁后，进程之间形成一种头尾相接的循环等待资源关系   |

（3）模拟线程死锁

```java
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
```

### 避免死锁

设计时考虑清楚锁的顺序，尽量减少嵌在的加锁交互数量

| 方式     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 加锁顺序 | 线程按照一定的顺序加锁，当多个线程需要相同的一些锁，但是按照不同的顺序加锁，死锁就很容易发生，如果能确保所有的线程都是按照相同的顺序获得锁，那么死锁就不会发生 |
| 加锁时限 | 线程尝试获取锁的时候加上一定的时限，超过时限则放弃对该锁的请求，并释放自己占有的锁 |
| 死锁检测 | JDK提供了两种方式来给我们检测死锁位置，图形化工具JConsole和命令行工具Jstack |



## 线程通信

（1）相关方法

| 方法        | 介绍                                                         |
| ----------- | ------------------------------------------------------------ |
| wait()      | 当前线程进入阻塞状态，并释放同步监视器。                     |
| notify()    | 唤醒被wait()的一个线程。如果有多个线程被wait，就唤醒优先级高的那个 |
| notifyAll() | 唤醒被wait()的所有线程。                                     |

（2）wait()、notify()、notifyAll()三个方法定义在Object类中，必须使用在同步代码块或同步方法中，调用者必须是同步代码块或同步方法中的同步监视器，否则会出现异常

 （3）sellp()和wait()的异同

| 异同   | 简介                                                         |
| ------ | ------------------------------------------------------------ |
| 相同点 | 一旦执行方法，都可以使当前的线程进入阻塞状态                 |
| 不同点 | 1.两个方法声明的位置不同：Thread类中声明sleep，Object类中声明wait()<br>2.调用的要求不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或同步方法中<br>3.是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sellp()不会释放锁，wait()会释放锁 |

