package IO;

import java.io.*;

/*
* BufferReader
* 具有按行读取字符串
* */
public class BRDemo {
    public static void main(String[] args) throws IOException  {
        // 将当前源代码按行读取并输出到控制台
        FileInputStream fis = new FileInputStream(
                "./src/main/java/IO/BRDemo.java"
        );
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String str;
        while ((str= br.readLine()) != null){
            System.out.println(str);
        }
        br.close();

    }
}
