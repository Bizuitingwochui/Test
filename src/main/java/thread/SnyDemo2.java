package thread;

public class SnyDemo2 {
    public static void main(String[] args) {
        Shop shop1 = new Shop();
        Shop shop2 = new Shop();
        Thread t1 = new Thread("第一个人"){
            public void run(){
//                shop.buy();
                shop1.buy();
            }
        };

        Thread t2 = new Thread("第二个人"){
            public void run(){
//                shop.buy();
                shop2.buy();
            }
        };
        t1.start();
        t2.start();
    }



}

class Shop{
    //成员方法上直接使用synchronized时，同步监视器对象不可选，只能是this
//    public synchronized void buy(){
    public void buy(){
            try {
                Thread t1 = Thread.currentThread(); //获取运行bug方法的线程

                System.out.println(t1.getName()+":挑选衣服");
                Thread.sleep(5000);

                //此环节不允许多个线程同时运行
                /*
                * 使用同步块可以更灵活精准的控制需要多个线程同步执行的代码片段
                * 同步块使用需要再“（）”中制定一个称为 同步监视器对象，在语法层面上 必须是一个应用类型元素 否则编译不通过
                * 如果需要同步执行的多个线程看到的该对象必须是 同一个
                * 字面量是全局为一个对象，无论何时多个线程看到的都是同一个对象，因此仍和情况下执行
                * 下面的同步块都需要分开执行
                * 例如：两个线程一个调用shop1的buy一个调用shop2的buy方法
                * 实际开发中适合作为同步监视器的对象的通常就是临界资源：抢谁就锁谁
                * */
                synchronized (this) {
//                synchronized ("666") {
//                synchronized (new Object()) {         //无效的对象 只有带NEW一定无效
                    System.out.println(t1.getName() + ":试衣服");
                    Thread.sleep(5000);
                }

                System.out.println(t1.getName()+":买单走人");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
}

