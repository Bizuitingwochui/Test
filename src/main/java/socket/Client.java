package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
* 聊天室客户端
* */
public class Client {
    /*
    * Socket 封装 TCP协议通讯细节，使用它就可以给予两条流的读写完成与远程计算机数据交换
    * */
    private Socket socket;
    /*
    * 构造方法来初始化客户端与服务端建立TCP链接
    * */
    public Client(){
        try {
            /*
                Socket常用的构造器
                Socket(String host,int port)
                参数1:要连接的服务端的IP地址，用于找到服务端所在的计算机(服务器)
                参数2:服务端打开的服务端口，通过该端口连接到服务器上运行的服务端应用程序

                实例化的过程就是连接服务端的过程，如果连接失败会抛出异常
             */
            System.out.println("正在连接服务器......");
            socket = new Socket("localhost",8088);
            System.out.println("服务器连接成功..^^..");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        //字符串发给服务端
        try {
            /*
                Socket提供的方法:
                OutputStream getOutputStream()
                此方法会返回一个字节输出流，通过这个字节输出流写出的字节会通过网络
                发送给远端计算机
             */
            //Socket获取的输出流是一个低级流，通过这个流写出的字节会发送给对方
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw,true);
            while (true){
                System.out.println("请输入你想发的话（输入exit退出）：");
                String str = scanner.nextLine();
                if (str.equals("exit")){
                    break;
                }
                pw.println(str);

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                /*
                * 调用时会自动关闭通过socket获取的输入流与输出流
                * 与对方进行4次挥手断开操作
                * */
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();

    }
}
