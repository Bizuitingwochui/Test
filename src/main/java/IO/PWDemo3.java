package IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
* 简易记事本工具
* 输入的每行字符串 按行写入文件 note.txt
* 单独输入exit退出。
*
* 自行完成4层流链接
* */
public class PWDemo3 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("note.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw,true);                  //true 自动flush
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("请输入你的字符串");
            String str = scanner.nextLine();
//            if (str.equals("exit")){
//                break;
//            }
//            else {
//                pw.println(str);
//            }
            if ("exit".equalsIgnoreCase(str)){      //equalsIgnoreCase  忽略大小写
                break;
            }
            else {
                pw.println(str);
            }
        }
        System.out.println("写入完成");
        pw.close();
    }
}
