package ooday01;


public class Student {
    String name;
    int age;
    String address;

    Student(){
        this("111",222,"333");
    }

    Student(String name){
        this.name =  name;
    }


    Student(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    void  sayHI(){
        System.out.println("我的名字是："+name+" 年龄是"+age+" 来自"+address);
    }

}
