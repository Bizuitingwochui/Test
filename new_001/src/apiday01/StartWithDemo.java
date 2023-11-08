package apiday01;

public class StartWithDemo {
    public static void main(String[] args) {
        String str = "thinking in java";
        boolean starts = str.startsWith("think");           //判断 str 的 开头是否是 think开始的
        System.out.println(starts);
        boolean ends = str.endsWith(".png");               //判断 str的结尾是否是.png 经常用来检测格式是否正确
        System.out.println(ends);
    }
}
