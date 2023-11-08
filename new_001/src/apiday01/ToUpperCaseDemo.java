package apiday01;

public class ToUpperCaseDemo {
    public static void main(String[] args) {
        String str = "我爱Java";
        String upper = str.toUpperCase();       //把str中的英文部分都转化为大写
        System.out.println(upper);
        String lower = str.toLowerCase();       //把str中的英文部分都转化为小写
        System.out.println(lower);
    }
}
