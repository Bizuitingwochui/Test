package submarine;

import javax.swing.ImageIcon;

//图片类
public class Images {
//  公开的  静态的   图片数据类型 变量名
    public static ImageIcon sea;            //海洋图片
    public static ImageIcon battleship;     //战舰图片
    public static ImageIcon gameover;       //游戏结束图片
    public static ImageIcon obsersubm;      //侦查潜艇图片
    public static ImageIcon torpesubm;      //鱼雷潜艇图片
    public static ImageIcon minesubm;        //水雷潜艇图片
    public static ImageIcon mine;           //水雷图片
    public static ImageIcon bomb;           //炸弹图片


    static {    //初始化静态图片
        sea =  new ImageIcon("img/sea.png");
        battleship = new ImageIcon("img/battleship.png");
        bomb = new ImageIcon("img/bomb.png");
        gameover = new ImageIcon("img/gameover.png");
        mine = new ImageIcon("img/mine.png");
        minesubm = new ImageIcon("img/minesubm.png");
        obsersubm = new ImageIcon("img/obsersubm.png");
        torpesubm = new ImageIcon("img/torpesubm.png");
    }

    public static void main(String[] args) {        //测试图片
        //getImageLoadStatus() 返回8表示读取成功，返回其他数据表示读取失败
        System.out.println(sea.getImageLoadStatus());
        System.out.println(battleship.getImageLoadStatus());
        System.out.println(bomb.getImageLoadStatus());
        System.out.println(gameover.getImageLoadStatus());
        System.out.println(mine.getImageLoadStatus());
        System.out.println(minesubm.getImageLoadStatus());
        System.out.println(obsersubm.getImageLoadStatus());
        System.out.println(torpesubm.getImageLoadStatus());

    }

}
