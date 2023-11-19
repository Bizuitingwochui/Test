package collection;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println("list:"+list);

        /*
        * E get(int index)
        * 根据下标获取指定元素
        * */
        String e =list.get(1);      //获取第二个元素
        System.out.println(e);      //two

        for (int i=0;i<list.size();i++){        //遍历list集合
            String e1 = list.get(i);
            System.out.println(e1);
        }

        /*
        * E set(int index,E e)
        * 替换指定元素
        * */
//        e = list.set(2,"seven");
//        System.out.println(list);
//        System.out.println("被替换的元素："+e);

        for (int i=0;i<list.size()/2;i++){
            String str = list.get(i);
            str = list.set(list.size()-1-i, str);
            list.set(i,str);
            //list.set(i,list.set(list.size()-1-i,list.get(i)));
        }
        System.out.println(list);
    }
}
