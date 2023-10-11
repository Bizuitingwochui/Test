package DAY04;
import java.util.Scanner;
public class SwitchCaseDemo {
    public static void main(String[] args) {
            //switch 的类型可以为 byte short char int String(jdk 1.7) 枚举(jdk 1.5)
//        int num =2;
//        switch (num){
//            case 1:
//                System.out.println(111);
//                break;
//            case 2:
//                System.out.println(222);
//                break;
//            case 3:
//                System.out.println(333);
//                break;
//            default:
//                System.out.println(".gg");
//        }

//        Scanner scan = new Scanner(System.in);
//        System.out.println("请选择功能：1.存款 2.取款 3.查询余额 4.退卡");
//        int function = scan.nextInt();
//        switch (function){
//            case 1:
//                System.out.println("用户选择存款");
//                break;
//            case 2:
//                System.out.println("用户选择取款");
//                break;
//            case 3:
//                System.out.println("用户选择查询余额");
//                break;
//            case 4:
//                System.out.println("用户选择退卡");
//                break;
//            default:
//                System.out.println("输入错误");
//        }

        int a =1,b=1;
        while (a<6){
            System.out.println("知识是人类进步的阶梯");
            a+=1;
        }

        while (b<10){
            int c;
            c=b*9;
            System.out.println(b+"*9="+c);
            b+=1;
        }

    }
}
