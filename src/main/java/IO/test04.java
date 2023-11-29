package IO;

import java.io.File;
import java.util.Scanner;

public class test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的目录名");
        String str = scanner.nextLine();
        File file = new File("./"+str);
        if (file.exists()){
            file.delete();
            System.out.println("删除完成");
        }
        else {
            System.out.println("不存在该目录名");
        }
    }
}
