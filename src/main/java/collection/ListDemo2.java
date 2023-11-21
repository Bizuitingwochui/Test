package collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {
    public static void main(String[] args) {
        List<String>  list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);

        list.add(2,"six");      //在第三个元素插入 six
        System.out.println(list);

        String str =  list.remove(3); //删除第四个元素
        System.out.println(list);
        System.out.println("删除的元素是："+str);
    }
}
