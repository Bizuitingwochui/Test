package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class IRSDemo {
    public static void main(String[] args) throws IOException {
        //读取osw.txt所有字符读取输出
        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        /*
            字符流Read上定义的读取字符的方法:
            int read()
            该方法是一次读取一个字符，实际上返回的int值是一个char(一个char为2字节，所以
            返回的int中对应的2进制应当是"低16位"有数据)。如果返回的int值为整数-1仍然表达
            流读取到了末尾
         */
        int d;
        while ((d = isr.read())!= -1){
            char c = (char) d;
            System.out.print(c);
        }
        isr.close();

//        isr.read();
    }
}
