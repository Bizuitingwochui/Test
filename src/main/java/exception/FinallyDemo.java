package exception;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;

/**
 * 异常处理机制中的finally块
 * finally块是异常处理机制的最后一块，它可以直接跟在try之后，或者最后一个catch之后。
 * finally可以保证只要程序执行到try语句块中，无论try中的代码是否出现异常，最终finally
 * 都必定执行。
 * 实际开发中我们通常会将释放资源这类操作放在finally中确保执行，比如IO中的关闭流操作。
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始");

        try {
            String line = null;
            System.out.println(line.length());
            // try语句块中如果某句代码出现了异常，那么try中剩余代码都不会被执行
            return;
        } catch (Exception e) {
            System.out.println("出错了");
        } finally {
            System.out.println("finally 中的执行了");
        }

        System.out.println("程序结束");
    }
}
