package submarine;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class World extends JPanel{    //游戏窗口

    public static final int WIDTH = 641;                              //窗口的宽
    public static final int HEIGHT = 479;                             //窗口的高

    private BattleShip ship = new BattleShip();                      //战舰对象
    private SeaObject[] submarines = {};                             //潜艇数组对象
    private Mine[] mines = {};                                      //水雷数组对象
    private Bomb[] bombs = {};                                      //炸弹数组对象


    /*  生成潜艇对象 */
    private SeaObject nextSubmarine(){
        Random random = new Random();
        int type = random.nextInt(20);                      //生成0-19的随机数
        if (type <10 ){
            //随机数小于10 生成侦查潜艇
            return new ObserveSubmarine();
        } else if (type < 16) {                                    //随机数大于10小于16 生成鱼雷潜艇
            return new TorpedoSubmarine();
        }else {                                                    //随机大于15数小于20 生成水雷潜艇
            return new MineSubmarine();
        }
    }

    private int subEnterIndex = 0;
    /*   潜艇入场   */
    private void submarineEnterAction(){
        subEnterIndex++;                        //10毫秒增加1
        if (subEnterIndex %40 ==0){             //400毫秒走一次
            SeaObject obj = nextSubmarine();    //获取潜艇对象
            submarines = Arrays.copyOf(submarines,submarines.length+1);     //数组扩容
            submarines[submarines.length-1] = obj;          //将obj添加到最后一个元素上
        }
    }

    private int mineEnterIndex = 0;
    /* 水雷入场 */
    private void mineEnterAction(){         //10毫秒走一次
        mineEnterIndex++;
        if (mineEnterIndex %100 ==0){
            //暂时搁置
//            Mine mine = new MineSubmarine().shootMine();
//            mines = Arrays.copyOf(mines, mines.length+1);
//            mines[mines.length-1] = mine;
        }
    }

    private int moveEnterIndex = 0;
    /* 海洋对象移动 */
    private void moveAction(){          //每10毫秒走一次
        for (int i =0;i<submarines.length;i++){         //遍历所有潜艇
            submarines[i].move();                       //潜艇移动
        }
        for (int i =0;i<mines.length;i++){              //遍历所有的水雷
            mines[i].move();                            //水雷的移动
        }
        for(int i =0;i<bombs.length;i++){               //遍历所有的炸弹
            bombs[i].move();                            //炸弹的移动
        }

    }

    /* 删除超出范围的对象 */
    private void outOfBoundsAction(){

    }





     /* 启动程序  */
    private void action(){
        //键盘侦听
        KeyAdapter k = new KeyAdapter() {
            /* 重写keyReleased()按键弹起事件  keyPressde()按键按下事件 */
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    /* 炸弹入场 */
                    Bomb obj = ship.shootBomb();
                    bombs = Arrays.copyOf(bombs,bombs.length+1);
                    bombs[bombs.length-1] = obj;
                }
            }
        };
        KeyAdapter k2 = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {                    //左键 右键移动
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    ship.leftMove();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    ship.rightMove();
                }
            }
        };
        this.addKeyListener(k2);
        this.addKeyListener(k);

        Timer timer = new Timer();                                  //创建定时器对象
        int interval = 10;                                          //定时间隔(毫秒为单位)

        timer.schedule(new TimerTask() {
            @Override
            public void run() {                                     //定时执行的事情（10毫秒自动执行）
                /* 潜艇入场 */
                submarineEnterAction();                             //潜艇入场
                /* 水雷入场 */
                mineEnterAction();
                /* 海洋对象移动 */
                moveAction();
                /* 删除超出范围的对象 */
                outOfBoundsAction();

                repaint();                             //重画（自动调用paint()方法）  10毫秒走一次

            }
        }, interval, interval);                        //定时日程表
    }


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
        World world = new World();                               //从这分配World类中的实例变量 并且在构造方法中赋值
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH+16,HEIGHT+39);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);                                 //默认调用paint方法

        world.action();                                         //启动程序的执行


    }
}
