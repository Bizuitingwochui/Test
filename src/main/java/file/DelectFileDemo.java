package file;

import java.io.File;

public class DelectFileDemo {
    public static void main(String[] args) {
        File file = new File("text.txt");
        if (file.exists()){
            file.delete();
            System.out.println("文件已删除");
        }else {
            System.out.println("该文件不存在!");
        }
    }
}
