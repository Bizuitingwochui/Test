package ooday08;

public class MultiTypeDemo {
    public static void main(String[] args) {

        //条件1 ：引用所指向的对象，就是该类型
        //条件2：引用所指向的对象，实现了该接口或者继承了该类
        Aoo o = new Boo();
        Boo o1= (Boo) o;            //满足条件1  引用所指向的o的对象就是Boo
        Inter o2 =(Inter) o;        //满足条件2  引用o所实现的接口就是Inter
        // Coo o3 = (Coo) o;        //运行是出现类型转换异常
        if (o instanceof Coo){
            Coo o4 = (Coo) o;
        }else {
            System.out.println("o不是Coo类型");
        }

    }
}

interface Inter{ }

class Aoo{ }

class Boo extends Aoo implements Inter { }

class Coo extends Aoo{ }