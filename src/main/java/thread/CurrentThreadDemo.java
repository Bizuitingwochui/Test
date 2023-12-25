package thread;
/**
 * java中所有的代码都是靠线程执行的，main方法也不例外。执行main方法的线程是JVM创建的
 * 并取名为"main",因此我们也称它为:"主线程"
 */
public class CurrentThreadDemo {
    /*
    * Thread有一个静态方法：
    * Thread currentThread
    * */
    //主线程执行main方法进来后会执行下面这句，此方法返回的就是主线程
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println("主线程:"+main);
        dosome();
        System.out.println("主线程main执行完成");
    }

    public static void dosome(){
        //获取调用dosome方法的线程
        Thread t = Thread.currentThread();
        System.out.println("调用dosome方法的线程是："+t);
    }
}
