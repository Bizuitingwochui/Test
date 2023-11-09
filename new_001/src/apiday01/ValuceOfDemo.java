package apiday01;

public class ValuceOfDemo {
    public static void main(String[] args) {
        int a = 123;
        String s1 = String.valueOf(a);          //把int型变量a 转换为string类型并且赋值给s1
        System.out.println(s1);

        double b = 123456.789;
        String s2 = String.valueOf(b);          //把double型变量b 转换为string类型并赋值给s2
        System.out.println(s2);

        String c =b+"";                         //任何类型与字符串相连，结果都会变为字符串类型，不推荐使用效率低
        System.out.println(c);
    }
}
