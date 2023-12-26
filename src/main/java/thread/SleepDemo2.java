package thread;
/*
* 当一个线程调用sleep方法处于睡眠阻塞的过程中，如果调用interrupt（）
* 会立即中断睡眠阻塞并在sleep这里抛出异常
* 并且跳转到catch块
* */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread(){
            public void run(){
                System.out.println("睡眠开始：");
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    System.out.println("睡眠出现异常");
                }
                System.out.println("睡眠结束");
            }
        };

        Thread lin2 = new Thread(){
            public void run(){
                System.out.println("第二个出现");
                for (int i=0;i<5;i++){
                    System.out.println("延时1秒");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("ok,结束");
                //lin2线程中断lin线程的睡眠阻塞
                lin.interrupt();
            }
        };
        lin.start();
        lin2.start();
    }
}
