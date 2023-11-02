package submarine;

import javax.swing.ImageIcon;

public class MineSubmarine extends SeaObject implements EnemyLife{
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
            this.x += this.speed;
    }

    public ImageIcon getImage(){
        return Images.minesubm;
    }

    /* 发射水雷--生成水雷对象 */
    public Mine shootMine(){
        //水雷的x：水雷潜艇的x+水雷潜艇的宽
        //水雷的y：水雷潜艇的y-11(水雷的高)
        return new Mine(this.x+this.width,this.y-11);
    }

    public int getLife(){         /* 获得一条命 */
        return 1;
    }
}
