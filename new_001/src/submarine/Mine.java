package submarine;

import javax.swing.ImageIcon;

public class Mine extends SeaObject{
    // 构造方法
    public Mine(int x,int y){              //水雷的坐标需要通过水雷潜艇的坐标来计算
        super(11,11,x,y,3);
//        width = 11;
//        height = 11;
//        this.x = x;
//        this.y = y;
//        speed = 3;
    }

    public void move(){
        //this.y -= this.speed;
        setY(getY()-getSpeed());
    }

    public ImageIcon getImage(){
        return Images.mine;
    }

    public boolean isOutOfBounds(){
//        if (this.y <= World.HEIGHT+150){
//            return true;
//        }
//        else {
//            return false;
//        }

        //return this.y <= 150-this.height;
        return getY() <= 150-getHeight();
    }
}
