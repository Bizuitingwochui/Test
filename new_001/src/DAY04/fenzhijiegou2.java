package DAY04;
import java.util.Scanner;       //导入Scannner包

public class fenzhijiegou2 {
    public static void main(String[] args) {
        // Scanner
        System.out.println("请输入年龄");
        Scanner scan = new Scanner(System.in);      //新建一个 扫描仪 scan
        int age = scan.nextInt();                   //扫描一个整数并且赋值给age
        System.out.println("输入的年龄为"+age);
        System.out.println("请输入身高");
        int tall = scan.nextInt();
        System.out.println("输入的身高为"+tall);
        System.out.println("请输入商品价格");
        double price = scan.nextDouble();
        System.out.println("商品价格为"+price);



    }
}
