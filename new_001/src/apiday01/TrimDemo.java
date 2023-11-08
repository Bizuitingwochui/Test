package apiday01;

public class TrimDemo {
    public static void main(String[] args) {
        String s1 = "        hello world    ";
        s1 = s1.trim();     //去除s1两边的空白字符（生成一个新的字符串对象）
        System.out.println(s1);
    }
}
