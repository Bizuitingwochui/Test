package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 异常处理机制在IO操作中的应用
 */
public class FinallyDemo2 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("fos.dat");
            fos.write(1);
        } catch (IOException e) {
            throw new RuntimeException(e);      //错误信息输出到控制台
        } finally {
            try {
                if (fos != null ) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
