package IO;

import java.io.*;

public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //将person.obj文件中读取回来

        FileInputStream fis = new FileInputStream("person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        /*
            对象输入流提供了一个独有的方法:
            Object readObject()
            该方法会通过其连接的流读取对应的一组字节然后将其还原为相应的对象，并以
            Object类型(多态)返回
            需要注意:读取的字节应当是通过对象输出流将一个对象序列化的一组字节，否则
            这里读取时会抛出异常
         */
        Person person = (Person) ois.readObject();
        System.out.println(person);
//        System.out.println(person.getAge());
        ois.close();
    }
}
