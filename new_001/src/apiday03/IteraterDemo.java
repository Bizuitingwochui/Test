package apiday03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteraterDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");

        System.out.println(c);  //[one, #, two, #, three, #, four, #, five]

        Iterator it = c.iterator();     //获取集合C的迭代器
        while (it.hasNext()){
            String str = (String) it.next();    //获取下一个元素
            System.out.println(str);

            if ("#".equals(str)){        //如果str为井号
                it.remove();                //删除next方法所获取到的元素
            }
        }
        System.out.println(c);

    }
}
