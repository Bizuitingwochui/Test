package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * JAVA IO将流按照读写单位划分为字节流与字符流
 * 其中:
 * java.io.InputStream和OutputStream是所有字节输入流与输出流的超类
 * java.io.Reader和Writer则是所有字符输入流和输出流的超类
 * 字节流与字符流之间互不继承。
 * 字节流是以字节(8位2进制)为最小单位读写数据
 * 字符流则是以字符(char)为最小单位读写数据
 * 因此字符流仅用来读写文本数据，且字符流都是高级流。
 *
 *
 * 转换流
 * java.io.InputStreamReader和OutputStreamWriter
 * 转换流是字符流最常用的实现类，我们实际开发中不会直接操作这两个流，但是在流连接中他们
 * 是非常重要的一环，发挥着不可或缺的作用。
 * 对于它们我们最主要的就是了解它的意义。
 *
 * 意义:
 * 转换流是唯一一对可以连接在字节流上的字符流。而其他字符流都只能连接在字符流上。
 * 因此在流连接中我们使用的字符流只有先连接在转换流上才能再连接到字节流上进行工作。
 * 所以转换流起到了转换器的作用。
 * 就好比:电脑上的HDMI视频输出如果想连接到VGA接口的显示器上，则中间必须要添加一个
 * HDMI转VGA的转换器才能串联在一起工作一样。
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //使用转换流了解字符流怎么写出文本数据
        FileOutputStream fos = new FileOutputStream("osw.txt");
        //转换流在创建时除了指定连接在哪个流上之外，通常要明确指定字符集
        //这样一来通过当前流写出的文本都是按指定的字符集转换为字节后再写出
        OutputStreamWriter osw = new OutputStreamWriter(fos,StandardCharsets.UTF_8);
//        String line = "天青色等烟雨，而我在等你。";
//        byte[] data = line.getBytes(StandardCharsets.UTF_8);
//        fos.write(data);
        //字符流支持直接将字符串写出
        osw.write("天青色等烟雨，而我在等你。");
        osw.write("月色被打捞起，晕开了结局。");
        System.out.println("写出完毕");
        osw.close();
    }

}
