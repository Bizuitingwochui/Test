package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* IO
* Intput:输入
* Output:输出
* */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        //向当前项目目录下的fos.dat文件中写入数据
        /*
        文件流输出流在创建时，如果指定的路径下对应的文件不存在时
        如果该文件所在的目录存在则会自动将该文件创建出来。

        如果该文件所在的目录不存在则会直接抛出异常:
        java.io.FileNotFoundException: .\abc\fos.dat (系统找不到指定的路径。)
         */
        FileOutputStream fos = new FileOutputStream("./fos.dat");

        fos.write(1);
        fos.write(2);
        fos.write(6);
        System.out.println("写入完成");
        fos.close();


    }
}
