package DAY03;

public class yunsuanfuyubiaodashi {
    public static void main(String[] args) {
        /*
        System.out.println(5%2);
        System.out.println(8%2);
        System.out.println(2%8);
         */

        /*
        int a=1,b;
        b= ++a;         // a++=a   ++a=a+1
        System.out.println(b)；
         */

        /*
        int a=5,b=5;
        a++;                    //单独直接使用 a++  ++a 效果一样。
        ++b;
        System.out.println(a);
        System.out.println(b);
        */

        /*
        int a=5,b=5;
        int c=a++;                  //1.记录a++的值 5  2.a 自增1 为6 3.把记录的a++的值 5 赋值给c
        int d=++b;                  //1.记录++b的值 6  2.b 自增1 为6 3.把记录的++b的值 6 赋值给d
        System.out.println(a);      // 6
        System.out.println(b);      // 6
        System.out.println(c);      // 5
        System.out.println(d);      // 6
        */


//        int a=5,b=10;
//        System.out.println(a++);            // 5    先输出在+1 a++=a
//        System.out.println(a);              // 6
//        System.out.println(++b);            // 11
//        System.out.println(b);              // 11

//        int a=5,b=5;
//        a--;                      // 4
//        --b;                      // 4
//        System.out.println(a);
//        System.out.println(b);

//        int a=5,b=5;
//        int c =a--;
//        int d =--b;
//        System.out.println(a);      // 4
//        System.out.println(b);      // 4
//        System.out.println(c);      // 5
//        System.out.println(d);      // 4

//        int a=5,b=10,c=5;
//        boolean b1 = a>b;
//        System.out.println(b1);         //  False
//        System.out.println(c<b);        //  True
//        System.out.println(a>=c);       //  True
//        System.out.println(a<=b);       //  True
//        System.out.println(a==c);       //  True
//        System.out.println(a!=c);       //  False
//
//        System.out.println(a+c>b);      //  优先a+c 再去比较  False
//        System.out.println(a%2 == 0);   //  False


//        int a=5,b=10,c=5;
//        System.out.println(c++>5);      //False
//        System.out.println(++c>5);      //True
//        System.out.println(c++>5);      //True

        // &&  ||  !
//        int a=5,b=10,c=5;
//        boolean b1 = b>=a && b<c;
//        System.out.println(b1);             // true && flase= flase
//        System.out.println(b<=c  && b>a);   //flase && true =flase
//        System.out.println(a==b && c>b );   //flase && flase=flase
//        System.out.println(b!=c && a<b);    //true && true=true

//        int a=5,b=10,c=5;
//        System.out.println(b>=a || b<c);        //true ||flase  true

//        int a=5,b=10,c=5;
//        boolean b2=  !(a<b);
//        System.out.println(b2);
//        System.out.println(!(a>b));
//
//        System.out.println(b<=c && b>a);        //当第一个条件为Flase时 发生短路 后面的不执行
//        System.out.println(b>=a || b<c);        //当第一个条件为True时 发生短路 后面的不执行

//        int a=5,b=10,c=5;
//        boolean b1 = a<b || c++>2;
//        System.out.println(b1);     //ture
//        System.out.println(c);      //5,发生短路导致后面没运行
//
//        boolean b2 = a>b && c++>2;
//        System.out.println(b2);     //flase
//        System.out.println(c);      //5，发生短路导致后面没运行



    }
}
