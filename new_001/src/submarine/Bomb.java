package submarine;

import javax.swing.ImageIcon;

public class Bomb extends SeaObject{
    // 构造方法
    Bomb(int x,int y){                             //炸弹坐标需要根据战舰坐标计算出来
        super(9,12,x,y,3);
//        width = 9;
//        height = 12;
//        this.x = x;
//        this.y = y;
//        speed = 3;
    }

    public void move(){
        System.out.println("y向下移动");
    }

    public ImageIcon getImage(){
        return Images.bomb;
    }
}
