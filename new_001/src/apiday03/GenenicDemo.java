package apiday03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenenicDemo {
    public static void main(String[] args) {

         Collection<Point> c = new ArrayList<>();
         c.add( new Point(1,2));
         c.add(new Point(3,4));
         c.add(new Point(5,6));
         c.add(new Point(7,8));
         c.add(new Point(9,0));

         Iterator<Point> it = c.iterator();
         while (it.hasNext()){
             Point p = it.next();
             System.out.println(p);
         }

         for (Point pp : c){
             System.out.println(pp);
         }













//        Collection<String> c = new ArrayList<>();   //泛型集合 <String>代表只能加入String类型的数据，其他会报错
//        c.add("one");
//        c.add("two");
//        c.add("three");
//        c.add("four");
//        c.add("five");
//
//        Iterator<String> it = c.iterator();
//        while (it.hasNext()){
//            String str = it.next();
//            System.out.println(str);
//        }
//
//        for (String str : c){
//            System.out.println(str);
//        }
    }
}
