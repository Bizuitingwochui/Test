package file;

import java.io.File;

public class MkDirDemo {
    public static void main(String[] args) {
        File dir = new File("./a/b/c/d/f");
        if (dir.exists()){
            System.out.println("该目录已存在");
        }else {
            /*
                make:做
                directory:目录
                小知识:mkdir在linux中是一个命令，用于创建一个目录

                mkdir()在创建目录时要求该目录所在的目录必须存在，否则无法创建
                mkdirs()在创建目录时会将所有不存在的父目录一同创建出来(推荐使用)
             */
//            dir.mkdir();
            dir.mkdirs();                           //创建多个嵌套目录
            System.out.println("该目录创建成功！");
        }
    }
}
