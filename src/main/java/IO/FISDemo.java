package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream file =  new FileInputStream("fos.dat");

        /*
            InputStream字节输入流超类中，定义了所有字节输入流读取字节的基本方法:
            int read()
            从输入流连接的另一端读取1个字节，以int形式返回。返回的int值中对应的2进制
            应当是"低八位"有效。但是如果返回的int值为整数-1，则表示流读取到了末尾。
         */
        int d = file.read();
        System.out.println(d);
        /*
            fos.dat文件中的数据:
            00000001 00000010

            ----------------------分割线--------------------------

            当我们第一次调用:
            int d = fis.read();

            读取的是fos.dat文件的:
            00000001 00000010
            ^^^^^^^^
            读取的字节

            read方法按返回的int值存储在d变量上，该值对应的2进制为:
            d:00000000 00000000 00000000 00000001
              |------自动补充24个0-------| 读取的字节
            因此返回的int值为整数1

         */
        d = file.read();
        System.out.println(d);
        /*
            当我们第二次调用:
            d = fis.read();

            读取的是fos.dat文件的:
            00000001 00000010
                     ^^^^^^^^
                     读取的字节

            read方法按返回的int值存储在d变量上，该值对应的2进制为:
            d:00000000 00000000 00000000 00000010
              |------自动补充24个0-------| 读取的字节
            因此返回的int值为整数2
         */
        d = file.read();
        System.out.println(d);
        /*
            当我们第三次调用:
            d = fis.read();

            读取的是fos.dat文件的:
            00000001 00000010 文件末尾
                              ^^^^^^^^
                              读取的字节

            read方法按返回的int值存储在d变量上，该值对应的2进制为:
            注:int型的整数-1对应的2进制应当是32位都位1.
            d:11111111 11111111 11111111 11111111
            因此返回的int值为整数-1
         */
        d = file.read();            //-1 就是读到头了
        System.out.println(d);
    }
}
