package submarine;

import javax.swing.ImageIcon;

public class Bomb extends SeaObject{
    // 构造方法
    public Bomb(int x,int y){                             //炸弹坐标需要根据战舰坐标计算出来
        super(9,12,x,y,3);
//        width = 9;
//        height = 12;
//        this.x = x;
//        this.y = y;
//        speed = 3;
    }

    public void move(){
            //this.y += this.speed;
        setY(getY()+getSpeed());
    }

    public ImageIcon getImage(){
        return Images.bomb;
    }

    public boolean isOutOfBounds(){
//        if (this.y > World.HEIGHT){
//            return true;
//        }
//        else {
//            return false;
//        }
        //return this.y >= World.HEIGHT;
        return getY() >= World.HEIGHT;
    }
}


