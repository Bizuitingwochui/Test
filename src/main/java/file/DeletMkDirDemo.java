package file;

import java.io.File;

public class DeletMkDirDemo {
    public static void main(String[] args) {
        File dir = new File("demo");
        if (dir.exists()){
            /*
                delete方法在删除目录时要求该目录必须是空目录才可以删除。
             */
            dir.delete();
            System.out.println("该目录已删除");
        }else {
            System.out.println("该目录不存在");
        }
    }
}
