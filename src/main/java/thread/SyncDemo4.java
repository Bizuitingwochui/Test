package thread;
/*
* 互斥锁
* 使用多个synchronized锁定多个代码片段，并且指定的都是同一个同步监视器对象
* 代码片段之间互斥，多个线程不能同时执行
*
* */
public class SyncDemo4 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread(){
            public void run(){
                foo.methodA();
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                foo.methodB();
            }
        };

        t1.start();
        t2.start();
    }
}

class Foo{
    public synchronized void methodA(){
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+"：正在使用A方法");
            Thread.sleep(5000);
            System.out.println(t.getName()+"使用结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void methodB(){
        synchronized (this) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + "：正在使用B方法");
                Thread.sleep(5000);
                System.out.println(t.getName() + "使用结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}