package file;

import java.io.File;
import java.io.FileFilter;

public class ListFilesDemo3 {
    public static void main(String[] args) {
        File dir = new File(".");

        File[] sub = dir.listFiles(file-> file.getName
                ().startsWith(".txt"));

        for (File f : sub){
            System.out.println(f.getName());
        }
    }
}
