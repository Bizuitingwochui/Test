package IO;

import java.io.*;

public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
//        FileOutputStream fout = new FileOutputStream("image_copy.png");         //输出
//        BufferedOutputStream bos = new BufferedOutputStream(fout);
//
//        FileInputStream fint = new FileInputStream("image.png");            //输入
//        BufferedInputStream bis = new BufferedInputStream(fint);
//
//        int d;
//        d = bis.read();
//        while (d != -1){
//            bos.write(d);
//        }


         /*
            文件流就是低级流，是实际链接程序与文件的管道，负责实际读写文件数据的流
         */
        FileInputStream fis = new FileInputStream("image.png");
        BufferedInputStream bis = new BufferedInputStream(fis);
//        FileInputStream fint = new FileInputStream("image.png");            //输入
//        BufferedInputStream bis = new BufferedInputStream(fint);

        FileOutputStream fos = new FileOutputStream("image_copy.png");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
//        FileOutputStream fout = new FileOutputStream("image_copy.png");         //输出
//        BufferedOutputStream bos = new BufferedOutputStream(fout);

        int d;
        /*
            缓冲流内部默认有一个8kb的字节数组，当我们使用缓冲流读写字节时，它们
            一定是转换为以8kb为单位的块读写进行来保证读写效率
         */
        while((d = bis.read())!=-1){
            bos.write(d);
        }
        System.out.println("写出完成");
        bis.close();
        bos.close();
    }
}
