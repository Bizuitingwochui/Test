package DAY05;

public class FroDemo {
    public static void main(String[] args) {
//        //for中的循环变量NUM的作用域，仅在当前for中存在
//        for (int num = 1;num <=9;num++){
//            System.out.println(num+"*9="+(num*9));
//        }
//
//        for (int num = 1;num <=9;num+=2){
//            System.out.println(num+"*9="+(num*9));
//        }
//
//        for (int num = 1;num <=9;num+=2){
//            System.out.println(num+"*9="+(num*9));
//        }

        //输出1-100的总和
//        int sum =0;
//        for (int i=1;i<=100;i++){
//            sum += i;
//        }
//        System.out.println("总和："+sum);

//        for (;;){
//            System.out.println("这是个死循环");
//        }


        // 先看存换是否与次数有关：
        //      如果有关------------直接选择for
        //      如果无关------------再看要素1与要素3的代码是否相同
        //          如果相同------------直接选择do....while
        //          如果不同------------直接选择while


//        for (int num = 1;num <=9;num++){
//            if (num ==4){
//                break;                  //跳出循环结束for
//            }
//            System.out.println(num+"*9="+(num*9));
//        }
//        System.out.println("结束");

        for (int num = 1;num <=9;num++){
            if (num ==4){
                continue;               //跳过剩下语句进入下一次循环
            }
            System.out.println(num+"*9="+(num*9));
        }
        System.out.println("结束");

    }
}
