package submarine;

import javax.swing.ImageIcon;

public class TorpedoSubmarine extends SeaObject{
    // 构造方法
    public TorpedoSubmarine(){
        /*
        width = 64;
        height = 20;
        x = -width;
        Random rand = new Random();
        y  = rand.nextInt(479-height-150+1)+150;    //生成一个 150-(窗口高-潜艇高）之间的随机数
        speed = rand.nextInt(3)+1;                  //生成一个 1-2之间的随机数
         */

        super(64,20);
    }

    public void move(){
        System.out.println("鱼雷潜艇x向右移动");
    }

    public ImageIcon getImage(){
        return Images.torpesubm;
    }
}
