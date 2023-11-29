package IO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test05 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入文件名");
            String name = scanner.nextLine();
            File file = new File(name);
            if (file.exists()){
                System.out.println("该文件已存在，请重新输入一个名称");
            }
            else {
                file.createNewFile();
                System.out.println("该文件已创建");
                break;
            }
        }
    }
}
