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

            //向上造型（多态）         超类型的引用指向了派生类的对象
        //Animal o1 = new Tiger();
        //Persion p1 = new Student();
        //Persion p2 = new Teacher();
        //Persion p3 = new Doctor();
        //SdaObject o2 = new SeaObject();

        Aoo o3 = new Boo();
        o3.show();
        o3.a =1;



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
