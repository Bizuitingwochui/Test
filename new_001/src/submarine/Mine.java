package submarine;

public class Mine extends SeaObject{
    // 构造方法
    Mine(int x,int y){              //水雷的坐标需要通过水雷潜艇的坐标来计算
        width = 11;
        height = 11;
        this.x = x;
        this.y = y;
        speed = 3;
    }

    void move(){
        System.out.println("鱼雷开始移动");
    }
}
