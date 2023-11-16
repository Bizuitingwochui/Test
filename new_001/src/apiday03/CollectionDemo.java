package apiday03;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {

        Collection cc = new ArrayList();
        Point pp = new Point(1,2);
        cc.add(pp);
        System.out.println("pp:"+pp);   //(1,2)
        System.out.println("cc:"+cc);   //[(1,2)]

        pp.setX(1000);
        System.out.println("pp:"+pp);   //(1000,2)
        System.out.println("cc:"+cc);   //[(1000,2)]










        /*
        Collection c = new ArrayList();
        c.add(new Point(1,2));
        c.add(new Point(3,4));
        c.add(new Point(5,6));
        c.add(new Point(7,8));
        c.add(new Point(9,0));
        c.add(new Point(1,2));

        System.out.println(c);      //[(1,2), (3,4), (5,6), (7,8), (9,0), (1,2)]

        Point p = new Point(1,2);
        boolean contains = c.contains(p);   //根据当前集合是否包含给定的元素 p 判断依据为equals 必须要重写equals方法
        System.out.println("是否包含:"+contains);

        c.remove(p);
        c.remove(p);
        System.out.println(c);


         */











        /*
        Collection c = new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        //集合重写了object的tostring方法，返回格式为
        //[元素1.toString(),元素2.toString(),......]
        System.out.println(c);  //[one, two, three, four]

        System.out.println("size:"+c.size());       //输出集合的元素个数
        System.out.println("是否为空集："+c.isEmpty());   //false

        c.clear();  //清理集合
        System.out.println(c);      //[]
        System.out.println("size:"+c.size());       //0
        System.out.println("是否为空集："+c.isEmpty());//true

         */
    }
}
