package apiday02;

public class IntegerDemo {
    public static void main(String[] args) {

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println("最大值为："+max+",最小值为:"+min);

        long max1 = Long.MAX_VALUE;
        long min1 = Long.MIN_VALUE;
        System.out.println("最大值为："+max1+",最小值为:"+min1);

        String s1 = "38";
        int age = Integer.parseInt(s1);
        System.out.println(age);

        String s2 = "132.456";
        double price = Double.parseDouble(s2);
        System.out.println(price);





        /*
        //触发自动 装箱 Integer i = Integer.valueOf(5);
        Integer i = 5;  //从基本类型到包装类-----装箱
        //触发自动 拆箱 int j =  i.intvalue();
        int j =i;       //从包装类型到基本类型---拆箱
        */

        /*
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);
        System.out.println(i1 == i2);           //false ==比较的是地址
        System.out.println(i1.equals(i2));      //true Integer 重写equals比较的是内容
        */

        //valueOf()方法会复用一个字节内的数据（-128到127），建议使用valueOf（）
        Integer i3 = Integer.valueOf(5);
        Integer i4 = Integer.valueOf(5);
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));
    }
}
