package apiday03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewForDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        for (int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }

        for (String s : array){
            System.out.println(s);
        }

        Collection c = new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        Iterator it = c.iterator();
        while (it.hasNext()){
            String str = (String) it.next();
            System.out.println(str);
        }

        for (Object str : c){
            String s =(String) str;
            System.out.println(s);
        }
    }
}
