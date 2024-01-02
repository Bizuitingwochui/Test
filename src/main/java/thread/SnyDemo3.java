package thread;

public class SnyDemo3 {
    public synchronized static void main(String[] args) {
        Boo b1 = new Boo();
        Boo b2 = new Boo();
        Thread t1 = new Thread(){
            public void run(){
                b1.dosome();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                b2.dosome();
            }
        };

        t1.start();
        t2.start();
    }
}

class Boo{
    /*
    * 使用上面main方法中的方式测试，两个线程一个调用b1实例的dosome方法，另一个调用b2的dosome方法：
    * 如果dosome方法是一个成员方法，那么synchronized指定的同步监视器对象为this,由于两个线程调用的并非同一个对
    * 象的dosome方法，因此看到的this也不是同一个对象，所以他们可以同时执行
    *
    * 如果dosome方法是一个静态方法，那么synchronized指定的同步监视器为当前类的类对象（class）,由于每个类都有并且只有
    * 一个类对象与之对应，因此多个线程看到的同一个类一定也是同一个类对象，因此执行dosome方法时是分开的
    *
    * 类对象：class实例，在JVM内部每个被加载的类都有且只有一个class实例与之绑定。
    * */
//    public synchronized void dosome(){                //成员方法：
    public synchronized static void dosome(){       //静态方法：静态方法上使用synchronized，锁对象不可选，只能是当前类的 类对象
        //静态方法中如果使用 同步块 同步监视器对象通常也使用当前类的类对象
        synchronized (Boo.class) {
            try {
                Thread t1 = Thread.currentThread();
                System.out.println(t1.getName() + ":正在执行方法");
                Thread.sleep(5000);
                System.out.println(t1.getName() + "：方法执行完成");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
