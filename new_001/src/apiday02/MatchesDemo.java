package apiday02;

public class MatchesDemo {
    public static void main(String[] args) {
        /*
        邮箱正则表达式:
        [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+
        * */
        String email = "a473033593@163.com";
        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+"; // \中的第一个\是在转义正则表达式中的\

        boolean match = email.matches(regex);
        if (match){
            System.out.println("邮箱格式正确的");
        }
        else {
            System.out.println("邮箱格式错误的");
        }

    }
}
