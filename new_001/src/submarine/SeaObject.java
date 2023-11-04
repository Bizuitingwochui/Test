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
        return this.x >= World.WIDTH;
    }

    /* 碰撞检测 this：一个对象 other:另一个对象 */
    public boolean isHit(SeaObject other){
//        if (this.x-other.width < other.x && this.x < other.x && this.y+other.height> other.y &&this.y<other.y) {
//            return true;
//        }
//        return false;
        /* 假设潜艇为this,炸弹为other */
        int x1 = this.x-other.width;        //x1 为潜艇的x-炸弹的宽
        int x2 = this.x+this.width;        //x2 为潜艇的x+潜艇的宽
        int y1 = this.y-other.height;       //y1 为潜艇的y-炸弹的高
        int y2 = this.y+this.height;       //y2 为潜艇的y+潜艇的高
        int x = other.x;
        int y = other.y;
        return x >= x1 && x<= x2 && y >= y1 && y<=y2; //当x在x1--x2之间并且 y在y1--y2之间说明碰撞上了
    }

    public boolean isHitBatlltship(SeaObject other){                 //other是战舰的数据
        int x1 = other.x;                                            //x1 为战舰的x
        int x2 = other.x+other.width;                                //x2 为战舰的x+战舰的宽
        int y1 = other.y+other.height;                               //y2 为战舰的y+战舰的高
        int x = this.x;
        int y = this.y;
        return x >= x1 && x<= x2 && y <= y1; //当x在x1--x2之间并且 y比y1小说明碰撞上了
    }

    /* 海洋生物死亡 */
    public void goDead(){
        state = DEAD;       //碰撞后把状态修改为DEAD
    }



}


