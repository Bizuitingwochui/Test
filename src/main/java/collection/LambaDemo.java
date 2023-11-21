package collection;

import java.util.Comparator;

public class LambaDemo {
    //匿名内部类创建
    public static void main(String[] args) {
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };
    }

    //lambda写法
        Comparator<String> c = (String o1, String o2) ->{
                return o1.length()-o2.length();
        };

    //lambda写法 参数类型可以忽略不写
    Comparator<String> c2 = ( o1,  o2) ->{
        return o1.length()-o2.length();
    };

    // 如果方法体只有一句话 {}也可以忽略不写 return关键字也要一起忽略
    Comparator<String> c3 = ( o1,  o2) -> o1.length()-o2.length();

}
