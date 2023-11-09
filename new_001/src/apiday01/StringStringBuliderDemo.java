package apiday01;

public class StringStringBuliderDemo {
    public static void main(String[] args) {

        StringBuilder s = new StringBuilder("a");       //执行效率高 适合频繁地修改操作
        for (int i=0;i<10000000;i++){
            s.append(i);
        }
        System.out.println("执行完成");







        String str = "好好学习";
        StringBuilder builder = new StringBuilder(str); //复制str中的内容到bulider里面

        //append():追加内容---在末尾追加
        builder.append(",Day Day Up");
        System.out.println(builder);                    //好好学习，Day Day Up

        //replace():替换部分内容（含头不含尾）
        builder.replace(5,17,"为了我的生活");
        System.out.println(builder);                    //好好学习，为了我的生活

        //delete():删除部分内容（含头不含尾）
        builder.delete(0,4);                            //，为了我的生活
        System.out.println(builder);

        //insert():插入内容
        builder.insert(0,"赚钱");
        System.out.println(builder);                    //赚钱，为了我的生活
















        /*
        // StringBulider 创建方式
        StringBuilder builder1 = new StringBuilder();       //空字符串
        StringBuilder builder2 = new StringBuilder("abc");  //abc串

        //String StringBulider 互转
        String s1 = "abc";
        StringBuilder builder3 = new StringBuilder(s1);     //将string 转换为 bulider
        String s2 = builder3.toString();                    //将buider 转换为 string

         */
    }
}
