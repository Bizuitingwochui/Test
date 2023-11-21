package collection;

import java.util.*;

public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("simple");
//        list.add("Niko");
//        list.add("zywoo");
//        list.add("device");
//        list.add("cadian");
//        list.add("Yuki");
//        list.add("Elige");
//        list.add("Bit");
//        Collections.sort(list);
//        System.out.println(list);

        list.add("张三");
        list.add("李四");
        list.add("沃德法");
        list.add("我勒个去");
        list.add("咋可能");
        list.add("优纪");
        list.add("大逼哥");
        list.add("胖球");



        Collections.sort(list,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                return len1-len2;
            }
        });
        System.out.println(list);


    }
}
