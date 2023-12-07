package thread;

/**
 * 多线程
 * 线程之间是并发执行。
 * 线程的第一种创建方式:
 * 继承Thread并重写run方法
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        //实例化两个线程
        Thread t1 = new MyThead1();
        Thread t2 = new MyThread2();
        //调用线程的start将线程启动。注意:启动线程不能直接调用run方法！！！
        t1.start();
        t2.start();

    }
}


/**
 * 此种线程创建方式的优点:结构简单，利于匿名内部类形式创建
 * 缺点:
 * 1:存在继承冲突问题
 *   java是单继承的，这意味着如果继承了Thread就无法再继承其他类了，这在实际开发中
 *   存在着诸多不便(实际上继承最主要的目的是为了复用方法)
 *
 * 2:继承Thread的同时重写run方法，将线程任务定义在run方法中，这会导致线程与线程要
 *   执行的任务存在了必然的耦合关系，不利于线程的重(chong)用
 *
 */
class MyThead1 extends Thread{
    public void run(){
        for (int i=0;i<100000;i++){
            System.out.println("你谁");
        }
    }
}

class MyThread2 extends Thread{
    public void run(){
        for (int i=0;i<100000;i++){
            System.out.println("我是你爹");
        }
    }
}
