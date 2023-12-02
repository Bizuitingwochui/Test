package exception;
/**
 * JAVA 异常处理机制
 *
 * java.lang.Throwable是所有java中错误的顶级超类
 * 其下面派生了两个子类型：
 * Error和Exception
 * Error(错误)表示不可恢复的错误，一般表示系统级别问题，出现后通常程序就直接结束了。
 * Exception(意外，例外)是可以恢复的错误，如果正常处理完程序可以继续运行。
 *
 * 而java异常处理机制通常关心的就是Exception这类问题，不关心Error。
 */
public class TryCratchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始");
        //catch用来捕获在try中出现的某个异常并提供解决办法
        /*
            异常处理机制是使用在明知程序执行过程中可能出现某种不可抗因素导致的错误，无法
            通过逻辑避免掉的问题，此时针对这类异常指定B计划。
         */
        //try语句块用来括上可能出现异常的代码片段
        try {
//            String line  = null;
            String line = "";
            System.out.println(line.length());
            System.out.println(line.charAt(0));

        }
//        catch (NullPointerException e){     //针对try中出现空指针异常后的解决办法(B计划)
//            System.out.println("出现空指针"+e);
//        }
//        catch (StringIndexOutOfBoundsException e){
//            System.out.println("出现字符串下标越界"+e);
//        }
        catch (NullPointerException | StringIndexOutOfBoundsException exception){
            System.out.println("出现空指针或者下标越界"+exception);
        }
        /*
            捕获超类异常，凡是该异常的子类型异常都可以使用这个catch处理
            这种捕获粒度比较粗糙，一般不建议用特别靠上的超类。
         */
        catch (Exception e){
            System.out.println("出现异常"+e);
        }

        System.out.println("程序结束");
    }
}
