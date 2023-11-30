package IO;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/*
* JAVA BEAN
* 属性私有化
* 提供属性对应的公开 get set方法
* 提供公开的无参构造器
* */
public class Person implements Serializable {
    private String name;
    private int age;
    private String gender;
    /*
        transient关键字修饰的属性在对象序列化时会被忽略
        忽略不必要的属性可以达到对象序列化的"瘦身"目的，减少字节量。这样利于网络传输
        也利于减少磁盘开销。
     */
    private  transient  String[] otherInfo;

    // transient 序列化的时候忽略这个属性的值

     public Person(){}

    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }



}
