package file;

import java.io.File;
import java.io.IOException;

public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //当前项目目录下新建一个文件：text.txt
//        File file = new File("./test.txt");
        //在相对路径中最开始的"./"是可以忽略不写的，默认就是从"./"开始
        File file = new File("text.txt");
/*
            boolean exists()
            判断当前File表示的路径下是否已经真实存在该文件或目录了
            若已经从存在则返回true，否则返回false
         */
        if (file.exists()){
            System.out.println("该文件已存在");
        }else {
            file.createNewFile();
            System.out.println("文件已创建!");
        }
    }
}
