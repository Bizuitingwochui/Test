package collection;
import java.io.File;
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("./demo.txt");

        String name = file.getName();
        System.out.println("名字："+name);

        long length = file.length();
        System.out.println("大小："+length+"字节");

        boolean cr = file.canRead();
        System.out.println("可读"+cr);

        boolean cw = file.canWrite();
        System.out.println("可写"+cw);

        boolean ih = file.isHidden();
        System.out.println("是否隐藏"+ih);
    }
}
