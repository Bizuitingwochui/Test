package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fil = new FileInputStream("image.png");
        FileOutputStream fout = new FileOutputStream("image_cp.png");
                /*
            在字节输入流超类InputStream上定义了块读操作
            块读:一次读取一组字节

            int read(byte[] data)
            一次性读取给定数组data总长度的字节并从data数组第一个字节位置开始存入到该数组中。
            返回值为实际读取到的字节数。如果返回值为-1则表示流读取到了末尾。


            -------------------------------------------------
            假设:
            ppt.pptx文件内容(8个字节):
            11110000 00001111 10101010 01010101 11001100 00110011 11100010 00011100

            创建一个byte数组
            byte[] data = new byte[3];
            data数组初始内容(十进制):[0, 0, 0]
            data数组初始内容(二进制):[00000000, 00000000, 00000000]

            int len=0;//记录每次读取的字节数

            -------------------------------------------------------
            第一次调用:
            len = fis.read(data);
            由于data数组长度为3，因此fis会尝试从文件中一次性读取3个字节并转入到data中

            读取ppt.pptx文件内容:
            11110000 00001111 10101010 01010101 11001100 00110011 11100010 00011100
            ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
            |--第一次读取的3个字节内容---|
            将其装入data数组，此时data数组内容:
            data(2进制):[11110000, 00001111, 10101010]
            read方法的返回值为3，表达本次真实读取到了3个字节。因此len=3;
            len:3

            ------------------------------------------------------------
            第二次调用:
            len = fis.read(data);
            由于data数组长度为3，因此fis会尝试从文件中一次性读取3个字节并转入到data中

            读取ppt.pptx文件内容:
            11110000 00001111 10101010 01010101 11001100 00110011 11100010 00011100
                                       ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
                                       |--第二次读取的3个字节内容---|
            将其装入data数组，此时data数组内容:
            data(2进制):[01010101, 11001100, 00110011]

            read方法的返回值为3，表达本次真实读取到了3个字节。因此len=3;
            len:3

            -------------------------------------------------------------------------
            第三次调用:
            len = fis.read(data);
            由于data数组长度为3，因此fis会尝试从文件中一次性读取3个字节并转入到data中

            读取ppt.pptx文件内容:
            11110000 00001111 10101010 01010101 11001100 00110011 11100010 00011100 文件末尾了
                                                                  ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
                                                                  第三次读取时只能读2个字节内容
            将其装入data数组，此时data数组内容:
            data(2进制):[11100010, 00011100, 00110011]
                        |--本次读取的2字节--|  |-旧数据-|
            read方法的返回值为2，表达本次真实读取到了2个字节。因此len=2;
            len:2

            ----------------------------------------------------------------------
            第四次调用:
            len = fis.read(data);
            由于data数组长度为3，因此fis会尝试从文件中一次性读取3个字节并转入到data中

            读取ppt.pptx文件内容:
            11110000 00001111 10101010 01010101 11001100 00110011 11100010 00011100 文件末尾了
                                                                                    ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
                                                                                    已经没有数据了
            本此data数组没有任何变化:
            data(2进制):[11100010, 00011100, 00110011]
                        |----------旧数据------------|
            read方法的返回值为-1，表达流已经读取到末尾了。因此len=-1;
            len:-1



            ---------------------------------------------------------------
            字节输出流超类OutputStream上定义了块写操作:
            void write(byte data)
            一次性将给定的字节数组中所有字节写出

            void write(byte data,int offset,int len)
            一次性将给定的字节数组从下标offset处开始的连续len个字节写出

         */
        int len;
        byte[] data = new byte [1024*10];   //块读的字节:10kb
        long start_time = System.currentTimeMillis();
        while (( len = fil.read(data))!= -1){
            fout.write(data,0,len);
        }
        long end_time = System.currentTimeMillis();
        long time = end_time-start_time;

        System.out.println("复制完成,耗时："+time+"毫秒");
        fil.close();
        fout.close();
    }
}
