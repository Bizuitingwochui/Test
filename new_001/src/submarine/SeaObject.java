package submarine;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public abstract class SeaObject {

    public static final int LIVE =0;    //活着的
    public static final int DEAD =1;    //死去的
    int state = LIVE;                   //当前状态（默认是活着的）

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
        x = -width;                                          //暂时设为正
        Random rand = new Random();
        y  = rand.nextInt(World.HEIGHT-height-150+1)+150;    //生成一个 150-(窗口高-潜艇高）之间的随机数
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
    public abstract void move();        //抽象方法 保持统一性 并且强制子类重写方法 包含抽象方法的类必须是抽象类

    public boolean isLive(){            //判断是否是活着的
        return state == LIVE;           //如果state为LIVE表示活着的 返回true 否则返回false
    }

    public boolean isDead(){            //判断是否是死去的
        return state == DEAD;           //如果state为DEAD表示是死去的 返回true 否则返回false
    }

    public abstract ImageIcon getImage();   //抽象方法 获取对象的图片

    public void paintImage(Graphics g){     //画对象
        if (this.isLive()){
            this.getImage().paintIcon(null,g,this.x,this.y);
        }
    }

    public boolean isOutOfBounds(){
        //x 超出world的width y 超出world的height
//        if (this.x >=  World.WIDTH){
//            return true;
//        }
//        else {
//            return false;
//        }
        return this.x >= World.WIDTH;

    }

}


