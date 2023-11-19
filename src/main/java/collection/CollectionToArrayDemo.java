package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionToArrayDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println("集合："+c);

//        String[] array = c.toArray(new String[c.size()]);
//        String[] array = c.toArray(new String[10]);
        String[] arrays = c.toArray(new String[1]);
        //toarray 方法需要传入一个数组吗，如果数组长>=集合.size 则将元素全部存入该数组后再返回
        //如果数组不可用 长度<集合.size 则会自动创建一个与集合等长的数组并将元素存入后返回
        System.out.println("数组："+ Arrays.toString(arrays));
    }
}
