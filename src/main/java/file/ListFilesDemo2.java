package file;

import java.io.File;
import java.io.FileFilter;

public class ListFilesDemo2 {
    public static void main(String[] args) {
        File dir = new File(".");
            /*
            Filter:过滤器
            FileFilter:文件过滤器
            accept:接受
         */
        FileFilter filter =  new FileFilter() {
            //重写规则:定义过滤条件，当参数file符合过滤要求时方法应当返回true
            @Override
            public boolean accept(File file) {

                String name = file.getName();
                return name.startsWith("text");
            }
        };


        File[] subs = dir.listFiles(filter);
        for (File sub : subs){
            System.out.println(sub.getName());
        }
    }
}
