package ooday05;


public class StaticDemo{
    public static void main(String[] args) {
        Ioo i1 = new Ioo();
        Ioo i2 = new Ioo();
    }

}
class Goo {
    int a;          //实例变量（通过对象来访问）
    static int b;   //静态变量（通过类名来访问）
    void show(){        //有隐式this
        System.out.println(this.a);
        System.out.println(Goo.b);
    }

    static void test(){ //没有隐式this
        //静态方法没有隐式this传递，没有this就意味着没有对象，实例变量a必须通过对象点来访问
//        System.out.println(a);
        System.out.println(b);

    }

}

class Hoo{
    int a;
    void show(){                        //需要访问对象的属性，说明该方法与对象有关，所以不能设计为静态方法
        System.out.println(a);
    }
    static int plus(int num1,int num2){ //不需要访问对象的属性，说明该方法与对象无关，所以可以设计为静态方法。
        int num = num1+num2;
        return num;
    }
}

class  Ioo{                         //静态快属于类，只有第一次会执行
    static {
        System.out.println("这是静态快");
    }
    Ioo(){
        System.out.println("构造方法");
    }
}





















