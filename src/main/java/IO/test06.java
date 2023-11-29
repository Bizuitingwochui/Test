package IO;

import java.io.File;
import java.io.FileFilter;

public class test06 {
    public static void main(String[] args) {
        File dir = new File(".");
//        File[] subs = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File f) {
//                String name = f.getName();
//                return name.contains("s");
//            }
//        });

        File[]  subs = dir.listFiles( f -> f.getName().contains("x"));

        for (File sub : subs ){
            System.out.println(sub);
        }
    }
}
