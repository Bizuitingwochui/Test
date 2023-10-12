package DAY04;
import java.util.Scanner;
public class DoWhileDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /*
        System.out.println("请输入你的成绩");
        double ScoreLevel = scan.nextDouble();
        if (ScoreLevel < 0 || ScoreLevel >100){
            System.out.println("不合法");
        } else if (ScoreLevel >= 90) {
            System.out.println("你的成绩是：A");
        } else if (ScoreLevel >=80) {
            System.out.println("你的成绩是：B");
        } else if (ScoreLevel >=60) {
            System.out.println("你的成绩是：C");
        }else {
            System.out.println("你的成绩是：D");
        }

         */


        /*
        System.out.println("请输入你要做的操作：1.存钱 2.取钱 3.贷款 4.退卡");
        int CommandBySwitch = scan.nextInt();
        switch (CommandBySwitch){
            case 1 :
                System.out.println("前往存钱界面....");
                break;
            case 2:
                System.out.println("前往取钱界面....");
                break;
            case 3:
                System.out.println("前往贷款界面....");
                break;
            case 4:
                System.out.println("退卡中....");
                break;
            default:
                System.out.println("输入错误");
        }

         */

        /*
        int Guessing = (int) (Math.random()*1000+1);
        System.out.println("请你猜一个数");
        int In_Guessing = scan.nextInt();

        while (In_Guessing != Guessing ){
            if (Guessing > In_Guessing){
                System.out.println("你猜小了，请再猜一次吧");
            }else {
                System.out.println("你猜大了，请再猜一次吧");
            }
            In_Guessing = scan.nextInt();
        }
        System.out.println("恭喜你猜对了");
         */

        int Guessing = (int) (Math.random()*1000+1);
        System.out.println("请你猜一个数");
        int In_Guessing;
        do {
            In_Guessing = scan.nextInt();
            if (Guessing > In_Guessing){
                System.out.println("你猜小了，请再猜一次吧");
            }else if (Guessing < In_Guessing){
                System.out.println("你猜大了，请再猜一次吧");
            }else {
                System.out.println("恭喜你猜对了");
            }
        }while (Guessing!=In_Guessing);

    }
}
