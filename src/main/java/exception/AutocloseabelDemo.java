package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后，java推出了自动关闭特性
 * 旨在更优雅的在异常处理机制中关闭如流这样的操作
 */
public class AutocloseabelDemo {
    public static void main(String[] args) {
        try (
        //      自动关闭特性是编译器认可的，代码最终会被编译器改成FinallyDemo2的样子
                FileOutputStream fos = new FileOutputStream("fos.dat");
        ){
//          只有实现了java.io.AutoCloseable接口的类才可以在这里定义
//          在try的()中定义并初始化需要在finally中调用close方法的对象。
            int d =1;
            fos.write(d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //不必再书写finally自行调用对应的close方法了
    }
}
