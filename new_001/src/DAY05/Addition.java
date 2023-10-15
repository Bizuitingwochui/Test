package DAY05;
import java.util.Scanner;
public class Addition {
    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);
        int True = 0;
        int False = 0;

        for (int num = 1;num <= 10;num++){
            int math1 = (int) (Math.random()*100);
            int math2 = (int) (Math.random()*100);
            int math3 = math1+math2;
            System.out.println("("+num+")"+math1+"+"+math2+"=?");
            System.out.println("开始算吧！");
            int in_math = scan.nextInt();
            if (in_math == math3){
                System.out.println("答对了");
                True +=1;
            }else {
                System.out.println("答错了");
                False +=1;
            }
        }
        System.out.println("你在10题中总共答对了："+True+"题，答错了："+False+"题");
    }
}
