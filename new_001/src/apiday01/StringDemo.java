package apiday01;

public class StringDemo {
    public static void main(String[] args) {

        String s = new String("hello");     //创建了两个对象
        String s1 = "hello";                        //复用常量池中的字面量对象
        System.out.println("s:"+s);
        System.out.println("s1:"+s1);
        System.out.println(s == s1);                //false 比较地址是否相同

        System.out.println(s.equals(s1));           //true 比较内容是否相同
    }
}
