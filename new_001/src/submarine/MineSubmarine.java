package submarine;

public class MineSubmarine extends SeaObject{
    // 构造方法
    public MineSubmarine(){
        /*
        width = 63;
        height = 19;
        x = -width;
        Random rand = new Random();
        y  = rand.nextInt(479-height-150+1)+150;    //生成一个 150-(窗口高-潜艇高）之间的随机数
        speed = rand.nextInt(3)+1;                  //生成一个 1-2之间的随机数

         */

        super(63,19);

    }

    public void move(){
        System.out.println("水雷潜艇x向右移动");
    }
}
