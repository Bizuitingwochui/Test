package apiday02;

public class ReplaceAllDemo {
    public static void main(String[] args) {
        String line = "adv48svsvsd6786sadvf";
        line = line.replaceAll("[0-9]+","#number#");
        System.out.println(line);
    }
}
