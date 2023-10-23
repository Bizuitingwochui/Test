package ooday03;

public class ExtendsDemo {
    public static void main(String[] args) {        //子类可以访问父类 父类不能访问子类 具有继承性
        Aoo o1 = new Aoo();
        o1.a =1;
        o1.show();

        Boo o2 = new Boo();
        o2.a =2;
        o2.show();
        o2.b =3;
        o2.test();

    }
}

class Aoo {
    int a;
    void show(){

    }
}

class Boo extends Aoo{
    int b;
    void test(){

    }
}

class Coo extends Boo{
    int c;
    void hhh(){

    }
}
