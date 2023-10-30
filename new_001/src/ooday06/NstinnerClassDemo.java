package ooday06;

public class NstinnerClassDemo {
    public static void main(String[] args) {

        //创建了Boo的一个子类，但是没有名字
        //为该子类创建了一个对象，名为o3，向上造型为Boo
        //大括号中为子类的类体，如果有抽象方法，需要在类体中重写抽象方法
        //内部类中变量默认为final，无法修改
        Boo o3 = new Boo() {
            @Override
            void show() {
                System.out.println("show show");
            }
        };
    }
}

abstract class Boo{
    abstract void show();
}
