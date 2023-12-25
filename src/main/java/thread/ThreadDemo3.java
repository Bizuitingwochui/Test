package thread;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                for (int i=0;i<1000;i++){
                    System.out.println("你谁");
                }
            }
        };

//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<1000;i++){
//                    System.out.println("我是你爹");
//                }
//            }
//        };
//        Thread t2 = new Thread(r2);


        Thread t2 = new Thread(()->{
            for (int i=0;i<1000;i++){
                    System.out.println("我是你爹");
                }
        });



        t1.start();
        t2.start();

    }
}
