package file;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        for (int i =1 ;i<11;i++){
            File file = new File("text"+i+".txt");
            if (file.exists()){
                System.out.println("该文件已存在");
            }
            else {
                file.createNewFile();
                System.out.println(file+"已新建");
            }
        }
    }
}
