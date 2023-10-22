package submarine;

public class Mine {
    int width;
    int height;
    int x;
    int y;
    int speed;


    // 构造方法
    Mine(int x,int y){              //水雷的坐标需要通过水雷潜艇的坐标来计算
        width = 11;
        height = 11;
        this.x = x;
        this.y = y;
        speed = 3;
    }
}
