package thread;
/**
 * 线程的优先级
 * 线程有10个优先级，分别对应整数1-10.其中1为最低，10为最高，5为默认值。
 * 线程调用start方法后就纳入到线程调度器中被同一管理，此时线程只能被动的被分配时间片
 * 并发运行，而无法主动索取时间片。
 * 调度器会尽可能均匀的将时间片分配给每个线程。调整线程的优先级可以最大程度的改善获取
 * 时间片的概率，线程优先级越高的线程获取时间片的概率越高。
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            public void run(){
                for (int i =0;i<10000;i++){
                    System.out.println("min");
                }
            }
        };
        Thread max = new Thread(){
            public void run(){
                for (int i =0;i<10000;i++){
                    System.out.println("max");
                }
            }
        };

        Thread norm = new Thread(){
            public void run(){
                for (int i =0;i<10000;i++){
                    System.out.println("nor");
                }
            }
        };

        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        max.start();
        norm.start();
    }
}
