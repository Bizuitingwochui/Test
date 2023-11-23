package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FODDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");
        /*
            在ASC编码中(在任何现有字符集中，英文，数字，符号部分都是ASC编码部分。比如unicode
            编码中英文，数字，符号也是ASC编码这部分，2进制是一样的。)

            'a'的2进制与整数97的2进制长得一样。
            01100001  该字节如果以10进制换算，会得到整数97.
                      如果去ASC编码中会看到它对应字符'a'
         */
        //向文件中写入整数97的2进制
        /*
            int型97的2进制:
            00000000 00000000 00000000 01100001
                                       ^^^^^^^^
                                       写出的字节
            fos.txt文件中的内容:
            01100001
         */
//        fos.write(97);
        //将所有小写字母都写入文件
        for (int i =0;i<26;i++){
            fos.write(97+i);
        }
        System.out.println("写入完成");
        fos.close();
    }
}
