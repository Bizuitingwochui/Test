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
        System.out.println("y向上移动");
    }

    public ImageIcon getImage(){
        return Images.mine;
    }
}
