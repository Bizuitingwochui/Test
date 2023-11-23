package file;

import java.io.File;
import java.io.FileFilter;

public class Test3 {
    public static void main(String[] args) {
        File dir = new File(".");
        File[] files = dir.listFiles(file-> file.getName().endsWith(".txt"));
        for (File f : files){
            System.out.println(f.getName());
        }
    }
}
