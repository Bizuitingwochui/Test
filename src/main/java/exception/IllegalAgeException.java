package exception;
/*
 * 自定义异常
 * 通常用来表达那些满足语法但是不满足业务的错误。
 * 自定义异常定义应当符合下面的要求:
 * 1:类名要见名知义
 * 2:必须继承自Exception(直接继承或间接继承都可以)
 * 3:提供超类型异常所定义的所有种类构造器
* */
public class IllegalAgeException extends Exception {

    public IllegalAgeException() {
    }

    public IllegalAgeException(String message) {
        super(message);
    }

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAgeException(Throwable cause) {
        super(cause);
    }

    public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
