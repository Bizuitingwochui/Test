package DAY06;
import java.util.Scanner;
import java.util.Arrays;
public class MethDemo {
    public static void main(String[] args) {
//        say();      //调用say方法
//        System.out.println("继续");


//        System.out.println("name");
//        Scanner scan = new Scanner(System.in);
//        String a = scan.next();
//        sayHi(a);

//        sayHi("HHH");

//        sayHello("hhh",18); //                     实参

//        double a;
//        a = getNum();
//        System.out.println(a);

//        int a = plus(3,6);
//        System.out.println(a);
//        int m=50,n=60;
//        int c =plus(m,n);       //传 m与n里面的数
//        System.out.println(c);

        int[] d = integerArray(5,10);
        System.out.println("长度为"+d.length);
        Arrays.sort(d);
        for (int i =0;i<d.length;i++){
            System.out.println(d[i]);
        }

    }

    //有参数 有返回值
    public static int plus(int num1,int num2){
        int num = num1+num2;
        return num;
    }


    //无参数 无返回值
    public static void say(){
        System.out.println("123");
    }


    //有参数 无返回值
    public static void sayHi(String name){      //              形参
        System.out.println("我是"+name);
    }

    //无参数 有返回值
    public static double getNum(){
        return 8.88;
    }


    public static void sayHello(String name,int age){//         形参
        System.out.println("我是"+name+"年龄："+age);
    }

    //生成整形数组 并 填充 随机数据
    public static int[] integerArray (int length,int max){
        int[] arr = new int[length];
        for (int i =0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*(max+1));     //max+1  表示包括这个数
        }
        return arr;
    }

    // return 值     结束方法，用在有返回值的方法
    // return ；     结束方法，用在没有返回值的方法

}
