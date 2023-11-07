package ooday09;

public class StringDemo {
    public static void main(String[] args) {
        /* 使用字面量（“”）来创建字符串对象，JVM会检查常量池中是否有该对象
        *   如果 没有 则会创建字符串对象，并将其引用存入到常量池中
        *   如果 有   则会将常量池中的对象（引用）返回，并不会创建新的字符串对象      *  */
        String s1 = "123";      //常量池中并没有，会创建一个字符串对象，并且存入常量池
        String s2 = "123";      //常量池里已经有了，直接复用该对象
        String s3 = "123";      //常量池里已经有了，直接复用该对象
        String s4 = "abc";      //常量池中并没有，会创建一个新的字符串对象，并存入到常量池。

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);

        s1 = s1+"!";    //创建新的字符串对象（123！）并将地址赋值给s1
        System.out.println(s1 == s2);
    }
}
