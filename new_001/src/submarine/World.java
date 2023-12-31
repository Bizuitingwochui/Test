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

    public static final int RUNNING =0;             //运行状态
    public static final int PAUSE =1;               //暂停状态
    public static final int GAMEOVER=2;             //游戏结束状态
    private int state = RUNNING;                    //当前状态 默认为运行状态

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
            for (int i=0;i<submarines.length;i++){                          //遍历所有潜艇
                if (submarines[i] instanceof MineSubmarine){                //如果是水雷艇,因为超类里面没有shootmine方法
                    MineSubmarine ms = (MineSubmarine) submarines[i];       //强转为水雷艇类型
                    Mine obj = ms.shootMine();
                    mines =Arrays.copyOf(mines,mines.length+1);   //扩容
                    mines[mines.length-1] = obj ;                           //输出水雷
                }
            }

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
        for (int i = 0;i<submarines.length;i++){        //遍历潜艇数组
            if (submarines[i].isOutOfBounds() || submarines[i].isDead()){         //如果有潜艇出街
                submarines[i] = submarines[submarines.length-1];        //把出界的元素替换为最后一个元素
                submarines = Arrays.copyOf(submarines,submarines.length-1); //缩容
            }
        }

        for(int i = 0;i <mines.length;i++){
            if (mines[i].isOutOfBounds() || mines[i].isDead()){
                mines[i] = mines[mines.length-1];
                mines = Arrays.copyOf(mines,mines.length-1);
            }
        }

        for (int i =0;i<bombs.length;i++){
            if (bombs[i].isOutOfBounds() || bombs[i].isDead()){
                bombs[i] = bombs[bombs.length-1];
                bombs = Arrays.copyOf(bombs,bombs.length-1);
            }
        }
    }

    private int score = 0;
    /* 炸弹碰撞潜艇 */
    private void bombBangAction(){      //每10毫秒走一次
        for (int i=0;i<bombs.length;i++){                       //遍历炸弹数组
            Bomb b = bombs[i];                                  //获取每一个炸弹
            for (int o=0;o<submarines.length;o++){              //遍历潜艇数组
                SeaObject s = submarines[o];                    //获取每一个潜艇
                if (b.isLive() && s.isLive() && s.isHit(b)){    //首先双方得是活着的状态，并且发生了碰撞
                    s.goDead();                                 //潜艇去死，从数组中删除
                    b.goDead();                                 //炸弹去死，从数组中删除

                    if (s instanceof EnemyScore){               //适用于所有实现了EnemyScore接口的
                        EnemyScore es =(EnemyScore)s;           //被撞潜艇强转为score接口
                        score += es.getScore();                 //玩家得分
                    }
                    if (s instanceof EnemyLife){                //适用于所有实现了EnemyLife接口的
                        EnemyLife ef =(EnemyLife) s;            //被撞潜艇强转为life接口
                        int num = ef.getLife();                 //获取命数
                        ship.addLife(num);                      //给战舰增加命数
                    }

                }
            }
        }
    }


    /* 水雷碰撞战舰 */
    private void mineBangBattleShip(){
        for (int i=0;i<mines.length;i++){           //遍历水雷群组
            Mine m = mines[i];
            if (m.isLive() && ship.isLive() && m.isHitBatlltship(ship)){
                m.goDead();
                int num = -1;
                ship.addLife(num);
            }
            int num = ship.getLife();
            if (num == 0){
                ship.goDead();
            }
        }
    }

    /* 检测游戏结束 */
    private void gameOver(){
        if (ship.isDead()){
            state = GAMEOVER;
        }
    }

     /* 启动程序  */
    private void action(){

        //键盘侦听
        KeyAdapter k = new KeyAdapter() {
            /* 重写keyReleased()按键弹起事件  keyPressde()按键按下事件 */
            @Override
            public void keyReleased(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_P){
                    if (state ==RUNNING){
                        state = PAUSE;
                    } else if (state == PAUSE) {
                        state = RUNNING;
                    }
                }

                if (state == RUNNING) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        /* 炸弹入场 */
                        Bomb obj = ship.shootBomb();
                        bombs = Arrays.copyOf(bombs, bombs.length + 1);
                        bombs[bombs.length - 1] = obj;
                    }
                }
            }
        };
        KeyAdapter k2 = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {                    //左键 右键移动
                if (state == RUNNING) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        ship.leftMove();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        ship.rightMove();
                    }
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
                if (state == RUNNING) {
                    /* 潜艇入场 */
                    submarineEnterAction();                             //潜艇入场
                    /* 水雷入场 */
                    mineEnterAction();
                    /* 海洋对象移动 */
                    moveAction();
                    /* 检测是否发生炸弹潜艇碰撞 */
                    bombBangAction();
                    /* 检测是否发生水雷战舰碰撞 */
                    mineBangBattleShip();
                    /* 删除超出范围的对象 */
                    outOfBoundsAction();
                    /* 当战舰生命归零游戏结束 */
                    gameOver();

                    repaint();                             //重画（自动调用paint()方法）  10毫秒走一次
                }
            }
        }, interval, interval);                        //定时日程表
    }


    public void paint(Graphics g){                  //重写paint方法，重叠画，背景图片需要放到最上面去画
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
        /* 画分数跟命数 */
        g.drawString("SCORE:"+score,200,50);
        g.drawString("LIFE:"+ship.getLife(),400,50);

        if (state == GAMEOVER){                 //当前状态为游戏结束
            Images.gameover.paintIcon(null,g,0,0);   //画出海洋背景图
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
