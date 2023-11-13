package submarine;

import javax.swing.ImageIcon;

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
        //暂时搁置
    }

    public ImageIcon getImage(){
        return Images.battleship;
    }

    public Bomb shootBomb(){
        return new Bomb(getX()+22,getY()+11);
    }

    public void rightMove(){                //战舰右移
        if (getX() < World.WIDTH-getWidth()){
            setX(getX()+getSpeed());
        }
    }

    public void leftMove(){                 //战舰左移
        if (getX() >0){
            setX(getX()-getSpeed());
        }
    }

    /* 战舰增加生命 */
    public void addLife(int num){
        life += num;
    }

    /* 获取当前命数 */
    public int getLife(){
        return life;
    }


}
