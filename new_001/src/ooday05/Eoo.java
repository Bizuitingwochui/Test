package ooday05;

import ooday04.Coo;
/*
        public:公开的，任何类

        private：私有的，本类

        protected：受保护的，本类，派生类，同包类

        默认的：什么都不写，本类，同包类

类的访问权限是 public 或 默认的
类中成员的访问权限是4种都可以

 */
public class Eoo{

    void show(){
        Coo c = new Coo();
        c.a =1;
//        c.b =2;
//        c.c =3;
//        c.d =1;
    }
}

class Foo extends Coo{          //演示protected
    void show(){
        a = 1;
        b = 2;
//        c = 3;
//        d = 4;
    }
}