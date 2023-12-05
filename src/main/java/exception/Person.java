package exception;

public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if (age<0 || age>100){
            /*
                java将异常分为了两类:
                1:检查异常,除了RuntimeException的其他类型异常
                2:非检查异常,RuntimeException及其子类异常
                这里检查指的是当我们抛出一个异常时，编译器检查是否对该异常有处理有段
                (要么try-catch要么在方法上throws声明抛出)，如果没有处理手段编译不
                通过。
                而所谓的非检查异常指的是当我们抛出这类异常时，编译器不要求必须定义处理
                异常的手段。

                RuntimeException翻译过来为:运行时异常
                RuntimeException常见子类型:
                NullPointerException                空指针异常
                ArrayIndexOutOfBoundsException      数组下标越界异常
                ClassCastException                  类造型异常
                NumberFormatException               数字格式异常

                RuntimeException定位的都属于BUG级别的异常，都是通过修改逻辑可以完美
                避免的异常。这类问题就不应当用异常处理机制来处理。
             */
//            throw new RuntimeException("年龄不合法");
            /*
                当我们使用throw显示的抛出一个非RuntimeException的其他类型异常时
                编译器要求我们必须处理这个异常，否则编译不通过。
                而这里的做法就是在方法上使用throws声明这个异常的抛出
             */

            throw new IllegalAgeException("年龄不合法");
        }
        this.age = age;
    }


}
