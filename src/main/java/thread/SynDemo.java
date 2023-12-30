package thread;
/*
* 多线程并发安全问题
* 当多个线程并发操作统一临界资源，由于线程切换实际不确定导致执行顺序出现混乱导致不良后果
* 临界资源：操作该资源的完成过程同一时刻只能被单一线程进行
* */
public class SynDemo {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread(){
            //如果run方法对外抛出一个非检查异常，线程就会死掉，结束
            public void run(){
                while (true){
                    //如果桌子没有豆子 getbean会抛出一个非检查异常
                    int bean = table.getBeans();
                    //主动放弃当前的时间片
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                while (true){
                    int bean = table.getBeans();
                    //主动放弃当前的时间片
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };
        t1.start();
        t2.start();
    }

}

class Table{
    private int beans = 20;
    /* synchronized 被修饰的方法称为同步方法
    * 多个线程不能同时在方法内部执行
    * 将 多个线程并发执行改为同步执行 可有效的解决并发安全问题
    * 同步执行：多个线程有先后顺序的执行
    */
    public synchronized int getBeans(){
        if (beans ==0){
            throw new RuntimeException("豆子用完了");
        }
        return beans--; //从桌上取走一个豆子并返回
    }



}
