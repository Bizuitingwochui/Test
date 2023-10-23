package ooday01;

public class ConsDemo {
    public static void main(String[] args) {
        Student zs = new Student("张三",22,"NB");
        Student zs2 = new Student();
        Student zs3 = new Student("321");
        zs.sayHI();
        zs2.sayHI();
        zs3.sayHI();

    }
}
