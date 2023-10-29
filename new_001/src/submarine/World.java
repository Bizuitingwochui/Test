package submarine;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class World extends JPanel{    //游戏窗口

    public static final int WIDTH = 641;    //窗口的宽
    public static final int HEIGHT = 479;   //窗口的高

    private BattleShip ship = new BattleShip(); //战舰对象
    private SeaObject[] submarines = {
            new ObserveSubmarine(),
            new MineSubmarine(),
            new TorpedoSubmarine()
    };                                      //潜艇数组对象
    private Mine[] mines = {
            new Mine(200,250)
    };                                      //水雷数组对象
    private Bomb[] bombs = {
            new Bomb(230,300)
    };                                      //炸弹数组对象

    public void paint(Graphics g){          //重写paint方法，重叠画，背景图片需要放到最上面去画
        Images.sea.paintIcon(null,g,0,0);   //画出海洋背景图
        ship.paintImage(g);                         //画出战舰
        for (int i=0;i<submarines.length;i++){      //画出潜艇
            submarines[i].paintImage(g);
        }
        for (int i=0;i<mines.length;i++){           //画出水雷
            mines[i].paintImage(g);
        }
        for (int i=0;i<bombs.length;i++){           //画出炸弹
            bombs[i].paintImage(g);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        World world = new World();                              //从这分配World类中的实例变量 并且在构造方法中赋值
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH+16,HEIGHT+39);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);         //默认调用paint方法


    }
}
