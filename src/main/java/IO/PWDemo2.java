package IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
* 流链接中创建文件输出流
* */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        //文件输出流(字节流，低级流),作用:将字节写入到连接的文件上
        FileOutputStream fos = new FileOutputStream("pw.txt",true); //true 多次写入数据追加
        //转换输出流(字符流，高级流),作用:1衔接字符与字节流  2将写出的字符转换为字节
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        //缓冲字符输出流(字符流，高级流),作用:块写文本数据加速
        BufferedWriter bw = new BufferedWriter(osw);
        //PrintWriter(字符流，高级流),作用:1按行写出字符串  2自动行刷新
        PrintWriter pw = new PrintWriter(bw);
        pw.println("111");
        pw.println("222");
        System.out.println("写入完成");
        pw.close();

    }
}
