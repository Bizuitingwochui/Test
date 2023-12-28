package thread;
/*
* 守护线程
* 线程分为用户线程跟守护线程
* 正常创建的线程都是用户线程，只用调用该现成的setDaemon(true)才会把该线程改为守护线程
*
* 当一个java进程中的所有用户线程都结束的时候，该进程就会结束，会强制杀掉所有还在运行的守护线程
*
*
*
* */
public class DeamonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread(){
            public void run(){
                for (int i=0 ; i<5;i++){
                    System.out.println("沃德法");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("why you bully me");
                System.out.println(".GG");
            }
        };

        Thread jack = new Thread(){
            public void run(){
                for (int i=0;i<20;i++){
                    System.out.println("really?");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        rose.start();
        jack.setDaemon(true);//将Jack线程设置为守护线程，必须要在线程启动之前，否则会抛出异常
        jack.start();

        System.out.println("main方法执行完成，主线程结束");
        /*
        * 主线程也是守护线程，如果主线程不结束，进程就不会结束，不会杀掉还在进行的守护线程
        * */
//        while(true);

    }
}
