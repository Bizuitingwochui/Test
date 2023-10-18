package DAY06;
import java.sql.Array;
import java.util.Arrays;
public class MethTest {
    public static void main(String[] args) {

        //第一个方法
        say();
        //第二个方法
        sayHi("闭嘴听我吹");
        //第三个方法
        sayHello("闭嘴听我吹",21);
        //第四个方法
        double a = getNum();
        System.out.println(a);
        //第五个方法
        int b = plus(33,66);
        System.out.println(b);
        //第六个方法
        int[] c =testArray(33,10);
        System.out.println("数组的长度："+c.length);
        Arrays.sort(c);
        for (int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }


    }

    public static void say(){
        System.out.println("这是第一个方法");
    }

    public static void sayHi(String name){
        System.out.println("这是第二个方法,设置的名字是"+name);
    }

    public static void sayHello(String name, int age){
        System.out.println("这是第三个方法，设置的名字是"+name+"设置的年龄是"+age);
    }

    public static double getNum(){
        return 8.88;
    }

    public static int plus(int num1,int num2){
        int num = num1+num2;
        return num;
    }

    public static int[] testArray(int len,int max){
            int[] arr = new int[len];
            for (int i=0 ;i<arr.length;i++){
                arr[i] = (int) (Math.random()*(max+1));
            }
            return arr;
    }

}
