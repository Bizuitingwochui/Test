package ooday04;

public class StaticoDemo {
    public static void main(String[] args) {
        Foo o1 = new Foo();
        o1.show();
        Foo o2 = new Foo();
        o2.show();
        Foo o3 = new Foo();
        o3.show();
        System.out.println(Foo.b);  //常常通过类名点来访问

        int num = Hoo.plus(5,6);
        System.out.println(num);

        Ioo o4 = new Ioo();
        Ioo o5 = new Ioo();
        Ioo o6 = new Ioo();
    }
}

class Foo{
    int a;          //实例变量（通过对象来访问）
    static int b;   //静态变量（通过类名来访问）
    Foo(){
        a++;
        b++;
    }
    void show(){
        System.out.println("a="+a+",b="+b);
    }
}

class Ioo{
    static {
        System.out.println("静态块");
    }
    Ioo(){
        System.out.println("构造方法");
    }
}
