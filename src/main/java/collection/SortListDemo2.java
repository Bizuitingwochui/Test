package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(1,2));
        list.add(new Point(3,4));
        list.add(new Point(5,6));
        list.add(new Point(7,8));
        list.add(new Point(9,0));
        System.out.println(list);
       //Collections.sort(list);  编译错误

        //为Point定义一个比较规则 点到原点的长
//        Comparator<Point> comparator = new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {        //比较
//                //计算o1到原点的距离
//                int len1 =o1.getX()*o1.getX()+o1.getY()*o1.getY();
//                //计算o2到原点的距离
//                int len2 =o2.getX()*o2.getX()+o2.getY()*o2.getY();
//                /*
//                * o1 > o2  返回 > 0
//                  o1 = o2  返回 = 0
//                  o1 < o2  返回 < 0
//                * */
//                return len1-len2;
//            }
//        };
//
//        Collections.sort(list,comparator);

        Collections.sort(list,new Comparator<Point>() {             //没有侵略性的写法
            @Override
            public int compare(Point o1, Point o2) {        //比较
                int len1 =o1.getX()*o1.getX()+o1.getY()*o1.getY();
                int len2 =o2.getX()*o2.getX()+o2.getY()*o2.getY();
                return len1-len2;
            }
        });

        System.out.println(list);
    }
}
