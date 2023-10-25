package submarine;

import java.util.Random;

public class SeaObject {

    int width;                  //访问权限暂时搁置 还没讲到getter\setter
    int height;
    int x;
    int y;
    int speed;

    //专门给侦查潜艇、鱼雷潜艇、水雷潜艇提供
    //因为三种潜艇的 width\height不一致所以不能写死，需要传参
    //三个潜艇的x/y/speed是一样的可以写死公用
    public SeaObject(int width,int height){
        this.width = width;
        this.height = height;
        x = -width;
        Random rand = new Random();
        y  = rand.nextInt(479-height-150+1)+150;    //生成一个 150-(窗口高-潜艇高）之间的随机数
        speed = rand.nextInt(3)+1;                  //生成一个 1-2之间的随机数
    }

    //专门给战舰 水雷 炸弹提供
    public SeaObject(int width,int height,int x,int y,int speed){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }



    //海洋移动
    public void move(){
        System.out.println("海洋对象开始移动");
    }
}


