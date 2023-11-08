package apiday01;

public class IndexOfDemo {
    public static void main(String[] args) {
        String str = "thinking in java";
        int index = str.indexOf("in");              //检索in在str字符串中第一次出现的位置
        System.out.println(index);
        index = str.indexOf("in",3);   //检索in在str字符串中第一次出现的位置 从第三个下标开始
        System.out.println(index);
        index = str.indexOf("ABc");                 //在str里找abc 找不到返回-1
        System.out.println(index);
    }
}
