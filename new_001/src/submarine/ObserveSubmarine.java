package submarine;


import javax.swing.ImageIcon;

public class ObserveSubmarine extends SeaObject implements EnemyScore{

    // 构造方法
    public ObserveSubmarine(){
        /*
        width = 63;
        height = 19;
        x = -width;
        Random rand = new Random();
        y  = rand.nextInt(479-height-150+1)+150;    //生成一个 150-(窗口高-潜艇高）之间的随机数
        speed = rand.nextInt(3)+1;                  //生成一个 1-2之间的随机数
         */

        /*
        随机的y坐标生成过程
        y = rand.nextInt(311)                               生成一个 0-310的随机数
        y = rand.nextInt(311)+150                           生成一个 150-460的随机数
        y = rand.nextInt(460-150+1)+150                     311的由来 所能设置的y减去上限，此处用的是海平面的y150，再去增加1，使随机数可以选择310
        y = rand.nextInt(479-height-150+1)+150              460的由来 整个背景的y减去该图片的y
         */

        super(63,19);
    }

   public void move(){
        this.x += this.speed;   //x+(向右)
    }

    public ImageIcon getImage(){
        return Images.obsersubm;
    }

    public int getScore(){      /* 得分10分 */
        return 10;
    }
}
