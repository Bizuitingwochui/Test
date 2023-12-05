package exception;
/**
 * 异常中常用方法
 */
public class ExcepitonApiDemo {
    public static void main(String[] args) {
        try {
            String str = "abc";
            //将字符串转换为数字时，如果字符串内容不符，则会出现:NumberFormatException
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            //将异常信息输出到控制台上，帮助程序员追踪异常出现的情况
            e.printStackTrace();
            //获取错误消息(一般用来提示给用户，或者记录日志)
            String message = e.getMessage();
            System.out.println("error:"+message);
        }
    }
}
