package apiday01;

public class SubstringDemo {
    public static void main(String[] args) {
        /*
        String str = "www.tedu.com";
        String name = str.substring(4,8);
        System.out.println(name);
         */

        String str = "www.tedu.com";
        int start = str.indexOf(".")+1;
        int end = str.lastIndexOf(".");
        String name = str.substring(start,end);
        System.out.println(name);
    }
}
