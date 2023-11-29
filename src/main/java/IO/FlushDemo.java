package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bat.txt");

        String line = new String("哈哈哈哈哈哈哈哈哈");
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);
        fos.flush();            //flush 冲水 将缓冲区中的数据 强制写出

        System.out.println("写入完成");
        fos.close();            //close会自动flush一次
    }
}
