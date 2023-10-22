package submarine;

public class Bomb {
    int width;
    int height;
    int x;
    int y;
    int speed;


    // 构造方法
    Bomb(int x,int y){                             //炸弹坐标需要根据战舰坐标计算出来
        width = 9;
        height = 12;
        this.x = x;
        this.y = y;
        speed = 3;
    }
}
