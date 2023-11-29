package IO;

import java.io.File;

public class test02 {
    public static void main(String[] args) {
        for (int i=1;i<101;i++){
//            FileOutputStream file = new FileOutputStream(i+".txt");
            File file = new File(i+".txt");
            if (file.exists()){
                file.delete();
            }
        }
        System.out.println("删除完成");
    }
}
