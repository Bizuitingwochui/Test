package ooday04;

public class Goo {
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
