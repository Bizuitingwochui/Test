package ooday04;

public class Coo {
     public int a;              //任何类
     protected  int b;          //本类 派生类 同包类
     int c;                     //本类 同包类
     private int d;             //本类

    void show(){
        a=1;
        b=2;
        c=3;
        d=4;
    }
}


class Doo {                     //同包类
    void show(){
        Coo c = new Coo();
        c.a =1;
        c.b =2;
        c.c =3;
//        c.d =4;
    }
}