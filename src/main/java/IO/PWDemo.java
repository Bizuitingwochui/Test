package IO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //pww.txt 按行写入字符串
        /*
        * PrintWriter 支持直接对文件进行读写操作
        * PrintWriter (String name)
        * PrintWriter (File file)
        * */

        PrintWriter pw = new PrintWriter("pww.txt");

        pw.println("这是第一行数据");
        pw.println("这是第二行数据");
        pw.println("这是第三行数据");
        System.out.println("写入完成");
        pw.close();
    }
}
