package submarine;

public class BattleShip extends SeaObject{
    private int life;           //命数 私有

    // 构造方法
    public BattleShip(){
        super(66,26,270,124,20);
//        width = 66;
//        height = 26;
//        x = 270;
//        y = 124;
//        speed = 20;
        life = 5;
    }

    //重写move移动
    public void move(){
        System.out.println("战舰X左右移动");
    }




}