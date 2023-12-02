package IO;

import java.io.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        File dir = new File(".");
        File[] subs = dir.listFiles(f->f.getName().endsWith(".txt"));
        for (File sub : subs){
            FileInputStream fis = new FileInputStream(sub);
            BufferedInputStream bis = new BufferedInputStream(fis);

            String filename = sub.getName();
            String name = filename.substring(0,filename.lastIndexOf(".")) + "_cp" + filename.substring(filename.lastIndexOf("."));
            FileOutputStream fos = new FileOutputStream(name);
            BufferedOutputStream bus = new BufferedOutputStream(fos);
            int d;
            while ((d = bis.read())!=-1){
                bus.write(d);
            }
        }
        System.out.println("复制完成");
    }
}
