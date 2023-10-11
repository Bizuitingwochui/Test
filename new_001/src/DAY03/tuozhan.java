package DAY03;

public class tuozhan {
    public static void main(String[] args) {
        // 两个数的最大值
//        int a=8,b=5;
//        int max = a>b?a:b;
//        System.out.println(max);

//        int a=8,b=5;
//        int max;
//        if (a>b){
//            max=a;
//            System.out.println("最大值为"+max);
//        }
//        else {
//            max=b;
//            System.out.println("最大值为"+max);
//        }



        //闰年 平年判断

        int year=2024;
        if(year%4==0 && year%100!=0 || year%400==0){
            System.out.println(year+"是闰年");
        }
        else {
            System.out.println(year+"是平年");
        }

    }
}
