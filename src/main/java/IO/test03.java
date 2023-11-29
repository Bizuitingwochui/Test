package IO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test03 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个目录名");
        String str = scanner.nextLine();
        File file = new File("./"+str);
        if (file.exists()){
            System.out.println("该目录已存在");
        }
        else {
            file.mkdirs();
            System.out.println("创建完成");
        }
    }
}
