package apiday03;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionOperDemo {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        System.out.println("c1:"+c1);       //c1:[java, c++, .net]

        Collection c2 = new ArrayList();
        c2.add("android");
        c2.add("ios");
        c2.add("java");
        System.out.println("c2:"+c2);       //c2:[android, ios, java]

        c1.addAll(c2);
        System.out.println("c1:"+c1);       //c1:[java, c++, .net, android, ios, java]
        System.out.println("c2:"+c2);       //c2:[android, ios, java]

        Collection c3 = new ArrayList();
        c3.add("c++");
        c3.add("android");
        c3.add("php");

        boolean contains = c1.containsAll(c3);  //判断c1中是否包含c3中的所有元素
        System.out.println("包含所有："+contains);   //false

        /*
        c1.retainAll(c3);       //取交集 c1中仅保留 c1与c3的共有元素，c3不变
        System.out.println("c1:"+c1);       //c1:[c++, android]
        System.out.println("c3:"+c3);       //c3:[c++, android, php]

         */

        //删交集 将c1 c3中共有的元素删除，c3不变
        c1.removeAll(c3);
        System.out.println("c1:"+c1);   //c1:[java, .net, ios, java]
        System.out.println("c3:"+c3);   //c3:[c++, android, php]

    }
}
