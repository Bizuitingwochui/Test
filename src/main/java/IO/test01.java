package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test01 {
    public static void main(String[] args) throws IOException {
        for (int i=1;i<101;i++){
//            FileOutputStream file = new FileOutputStream(i+".txt");
            File file = new File(i+".txt");
            if (!file.exists()){
                file.createNewFile();
            }
        }
        System.out.println("生成完成");
    }
}
