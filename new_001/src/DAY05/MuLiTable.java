package DAY05;
public class MuLiTable {
    public static void main(String[] args) {

        //循环中套循环 常常是多行多列使用，一般外层控制行，内层控制列
        //外层循环走一次，内层循环走所有次
        //建议：嵌套的层数越少越好，能用一层就不用两层。能用两层就不用三层
        //break 只跳出当前一层循环

//        int num = 9;
        for (int num = 1; num <= 9; num++) {                        //九九乘法表
            for (int i = 1; i <= num; i++) {
                System.out.print(i + "*" + num + "=" + i * num+"\t");
            }
            System.out.println();
        }


//        // \t  水平制表位 固定8位
//        int num = 5;
//        for (int i = 1; i <= num; i++) {
//                System.out.print(i + "*" + num + "=" + i * num+"\t");
//            }
//        System.out.println();       //里面什么都不写表示换行
//
//        num = 6;
//        for (int i = 1; i <= num; i++) {
//            System.out.print(i + "*" + num + "=" + i * num+"\t");
//        }



    }
}
