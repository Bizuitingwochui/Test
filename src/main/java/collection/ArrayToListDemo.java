package collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ArrayToListDemo {
    public static void main(String[] args) {
        String[] array={"one","two","three","four","five"};
        System.out.println("数组："+ Arrays.toString(array));
        /*
        * 使用Arrays的aslist方法 转换成list集合
        * 不使用set类型 set不能放重复数据
        * */
        List<String> list = Arrays.asList(array);
        System.out.println("集合："+list);
        /*
        *从数组转换来的list集合 不能 增删元素，会报错
        * */
//        List<String> six = Arrays.asList(array);
//        six.add("six");
//        System.out.println("list"+six);

        List<String> list2 = new ArrayList<>(list);
        System.out.println("list2:"+list2);
        list2.add("six");
        System.out.println("list2"+list2);


    }
}
