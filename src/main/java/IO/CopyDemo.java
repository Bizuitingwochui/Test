package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fil = new FileInputStream("image.png");
        FileOutputStream fout = new FileOutputStream("image_cp.png");
        int d;
        long start_time = System.currentTimeMillis();
        while ((d = fil.read())!= -1){
            fout.write(d);
        }
        long end_time = System.currentTimeMillis();
        long time = end_time-start_time;

        System.out.println("复制完成,耗时："+time+"毫秒");
        fil.close();
        fout.close();
    }
}
