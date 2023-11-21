package collection;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for (int i=0; i<10;i++){
            list.add(i);
        }
        System.out.println(list);

        //获取List集合中的【3-7】这部分的元素
        List<Integer> sublist = list.subList(3,8);
        System.out.println("sublist:"+sublist);

        for (int i=0;i<=4;i++){
            int x = sublist.get(i)*10;
            sublist.set(i,x);
        }
        System.out.println(sublist);
        //对子集的操作就是对原集合对应的操作
        System.out.println(list);

        //删除集合2-8这部分的元素
        List<Integer> sublist2 = list.subList(2,9);
        sublist2.clear();
        System.out.println(list);

    }
}
