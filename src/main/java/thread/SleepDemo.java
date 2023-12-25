package thread;

import java.util.Scanner;

/**
 * 线程提供了一个静态方法:
 * static void sleep(long ms)
 * 该方法可以让运行这个方法的线程处于阻塞状态指定毫秒，超时后线程会自动回到RUNNABLE状态
 * 再次等待获取时间片并发执行。
 */
public class SleepDemo {
    public static void main(String[] args) {

        System.out.println("程序开始");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你要倒计时的数字");
        int num = scanner.nextInt();
        for (int i=num;i>=0;i--){
            if (i !=0){
                try {
                    System.out.println(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (i == 0 ) {
            System.out.println(i);
            }

        }

        System.out.println("程序结束");
    }
}
