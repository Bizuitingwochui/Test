package IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
* 从文本读数据
* */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/java/IO/ReadStringDemo.java");
        //创建一个与text.txt 文件等长的字节数组
        FileInputStream fin = new FileInputStream(file);
        //使用块读操作一次性将文件所有字节读入到Byte数组
        byte[] data = new byte[(int) file.length()];
        fin.read(data);
        //使用String的构造器可以将给定字节数组所有的字节按照UTF_8的格式转换为字符串
        String line = new String(data, StandardCharsets.UTF_8);
        System.out.println(line);

    }
}
