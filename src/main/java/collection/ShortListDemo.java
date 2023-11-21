package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShortListDemo {
    public static void main(String[] args) {
        Random random =  new Random();
        List<Integer> list = new ArrayList<>();
        for (int i=0 ; i<10;i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
