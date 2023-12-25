package thread;

public class ThreadInfoDemo {
    public static void main(String[] args) {
        //获取主线程
        Thread main = Thread.currentThread();

        //获取线程的名字
        String name = main.getName();
        System.out.println("线程的名字:"+name);
        /*
            ID:唯一标识  使用该值可以唯一标识一个个体。
            可以做为唯一表示的值必须同时具备两个条件:
            1:非空  2:唯一
         */
        Long id = main.getId();
        System.out.println("id:"+id);

        //获取线程的优先级
        int priority = main.getPriority();
        System.out.println("优先级："+priority);
        //线程是否活着
        boolean isAlive= main.isAlive();
        //线程是否是守护线程
        boolean isDaemon = main.isDaemon();
        //线程是否被中断
        boolean isInterrupted = main.isInterrupted();
        System.out.println("isAlive:"+isAlive);
        System.out.println("isDaemon:"+isDaemon);
        System.out.println("isInterrupted:"+isInterrupted);
    }
}
