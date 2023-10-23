package submarine;

import java.util.Random;

public class TorpedoSubmarine extends SeaObject{
    // 构造方法
    TorpedoSubmarine(){
        width = 64;
        height = 20;
        x = -width;
        Random rand = new Random();
        y  = rand.nextInt(479-height-150+1)+150;    //生成一个 150-(窗口高-潜艇高）之间的随机数
        speed = rand.nextInt(3)+1;                  //生成一个 1-2之间的随机数
    }

    void move(){
        System.out.println("侦查艇开始移动");
    }

}
