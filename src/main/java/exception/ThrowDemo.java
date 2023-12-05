package exception;
/**
 * 异常的抛出
 * throw关键字可以让我们显示的主动对外抛出一个异常
 * 通常下述情况我们会这样做:
 * 1:当程序遇到了一个异常，但是该异常不应当在当前代码块中被处理时可以对外抛出给是上层
 *   调用者解决
 * 2:程序可以运行，但是运行场景不满足业务场景，可以当做异常主动对外抛出，本案例就是这样
 *   的情况。
 */
public class ThrowDemo {
    public static void main(String[] args) {
        System.out.println("开始");
        Person p = new Person();
        /*
            当我们调用一个含有throws声明异常抛出的方法时，编译器要求我们必须处理
            这个异常，否则编译不通过。
            处理方式有两种:
            1:使用try-catch主动捕获并处理这个异常
            2:在当前方法上继续使用throws声明将该异常抛出给上层
            具体选取那种取决于异常处理的责任制问题。
         */
        try {
            p.setAge(123);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("年龄"+p.getAge());
        System.out.println("结束");
    }
}
