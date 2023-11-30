package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OOSDemo {
    public static void main(String[] args) throws IOException {
        //将一个Person对象写入文件person.obj

        String name = "优纪";
        int age = 22;
        String gender = "男";
        String[] otherInfo = {
                "技术好","沃德法","外挂"
        };

        Person person = new Person(name,age,gender,otherInfo);
        //低级流 将字节写入到文件中
        FileOutputStream fos = new FileOutputStream("person.obj");
        //person对象------
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /*
        * writeObject
        * 对象输出流独有的方法，将给定的对象序列化为一组字节后在通过流将字节写出
        *
        * NotSerializableException
        * 需要实现IO.Person这个接口
        * */
        oos.writeObject(person);
        System.out.println("写出完毕");
        oos.close();




    }
}
