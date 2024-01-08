package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/*
* 聊天室服务器
* */
public class Server {
    /*
        java.net.ServerSocket
        运行在服务端的ServerSocket主要工作:
        1:向系统申请对外的服务端口，客户端就是通过这个端口与服务端建立连接的
        2:监听服务端口，一旦一个客户端建立连接立即接受并获取一个Socket实例与之交互

        将ServerSocket想象为某客服呼叫中心的"总机"。用户拨打电话总是打给总机，然后
        总机下面连接着若干部电话，分配一台电话与该用户沟通，从而做到服务端可以同时与
        多个用户沟通的效果。
    * */
    public ServerSocket serverSocket;
    public Server(){
        try {
            System.out.println("正在启动服务器");
            /*
                ServerSocket在创建时需要指定对外的服务端口，该端口不能不能与服务器
                上其他运行的应用程序申请的端口一致，否则会报错:
                java.net.BindException:address already in use
                告知该地址已经被占用了，此时需要更换端口，或者自行在操作系统中杀死
                占用该端口的应用程序。
            * */
            serverSocket = new ServerSocket(8088);
            System.out.println("服务器正常启动");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void start(){
        try {

            Socket socket = null;
            while (true) {
                System.out.println("等待客户端链接");
            /*
                ServerSocket一个重要的方法:
                Socket accept()
                接受客户端的连接，该方法是一个阻塞方法，调用会进入阻塞状态(卡住)
                直到一个客户端建立连接，此时该方法会立即返回一个Socket与客户端
                形成对等关系，并利用这个Socket与客户端交互。
             */
                socket = serverSocket.accept();
                System.out.println("一个客户端链接了");

                //启动一个线程来处理与客户端的交互
                ClientHander hander = new ClientHander(socket);
                Thread t = new Thread(hander);
                t.start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /*
    * 该线程负责与指定的客户端进行交互
    * */
    private class ClientHander implements Runnable{
        private Socket socket;
        private String host; //记录客户端的ip地址
        public ClientHander(Socket socket){
            this.socket = socket;
            //获取客户端ip
            host = socket.getInetAddress().getHostAddress();
        }
        public void run(){
            try {
            /*
                    Socket重要的方法:
                    InputStream getInputStream()
                    通过Socket获取的输入流可以读取远端计算机发送过来的数据
            */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                //读取客户端的数据

                //通过socket获取输出流 将消息发送给客户端
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out,StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);        //容易打成reader
                PrintWriter pw = new PrintWriter(bw,true);




//            while (true) {
//                String str = br.readLine();
//                if (str == null){
//                    break;
//                }
//                System.out.println("收到：" + str);
//            }
                String line;
                /*
                 * 当客户端异常断开链接（没有调用 socket.close()断开）
                 * window的客户端如果异常断开：服务器会抛出异常
                 * linux的客户端异常断开，服务端会返回null
                 * */
                while ((line = br.readLine())!= null){
                    System.out.println(host+"收到"+line);

                    //将消息发送给客户端
                    pw.println(host+"说："+line);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
