package file;

import java.io.File;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要删除的文件名");
        String str = scanner.nextLine();
        File file = new File(str);
        if (file.exists()){
            file.delete();
            System.out.println("该文件已删除");
        }
        else {
            System.out.println("该文件不存在");
        }
    }
}
