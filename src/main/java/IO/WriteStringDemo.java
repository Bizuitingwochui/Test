package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("text.txt");
        String line = "闭嘴听我吹";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);

        fos.write(data);

        fos.write("闭嘴听我吹喔".getBytes(StandardCharsets.UTF_8));

        System.out.println("写入完成");
        fos.close();
    }
}
