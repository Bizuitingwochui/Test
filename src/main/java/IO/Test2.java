package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws IOException {
        /*
        * 文件流默认创建形式为覆盖写模式，对应的构造器:
            FileOutputStream(String filename)
            FileOutputStream(File file)
            所谓覆盖写模式:如果创建流时指定的文件已经存在了，那么文件流会将该文件数据
            全部清除。然后将通过这个流写出的数据保存在文件中。

            文件流可以以追加模式创建，对应的构造器
            FileOutputStream(String filename,boolean append)
            FileOutputStream(File file,boolean append)
            如果第二个参数传入true，则文件流创建时为追加模式:
            如果此时指定的文件已经存在则文件流在创建时会将文件数据全部保留，通过
            当前流写出的数据会陆续的追加到文件中。
        *
        * */
        FileOutputStream fout = new FileOutputStream("note.txt",true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想要输入的第一个字符串：");
        String str = scanner.nextLine();
        while (!str.equals( "exit")){
            byte[] data = str.getBytes(StandardCharsets.UTF_8);
            fout.write(data);
            System.out.println("请输入下一个字符串：");
            str = scanner.nextLine();
        }
        System.out.println("用户输入exit,输入结束");
        fout.close();
    }
}
