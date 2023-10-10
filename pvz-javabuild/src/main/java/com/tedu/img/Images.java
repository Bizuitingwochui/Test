package com.tedu.img;

import com.sun.imageio.plugins.gif.GIFImageMetadata;
import com.tedu.JpanelBuilder;
import com.tedu.entity.GifFrame;
import com.tedu.entity.other.LawnMower;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * 图片类
 *
 * @author admin
 * @create 2023/2/21 9:57
 **/
public class Images {
    //其他
    public final static BufferedImage background;
    public final static BufferedImage selectPlant;
    public final static GifFrame[] PB00;
    public final static BufferedImage SunBack;
    public final static GifFrame[] Sun;
    public final static BufferedImage Shovel;
    public final static BufferedImage ShovelBack;
    public final static BufferedImage ZombiesWon;
    public final static BufferedImage backgroundShadow;
    public final static GifFrame[] PrepareGrowPlants;
    public final static BufferedImage logo;
    public final static GifFrame[] LawnMower;
    public final static BufferedImage FlagMeterEmpty;
    public final static BufferedImage FlagMeterFull;
    public final static BufferedImage FlagMeterParts1;
    public final static BufferedImage FlagMeterParts2;
    public final static GifFrame[] LargeWave;
    public final static GifFrame[] FinalWave;
    public final static BufferedImage trophy;

    //植物卡片
    public final static BufferedImage SunFlowerCard;
    public final static BufferedImage CherryBombCard;
    public final static BufferedImage ChomperCard;
    public final static BufferedImage PeashooterCard;
    public final static BufferedImage WallNutCard;
    public final static BufferedImage JalapenoCard;

    //植物
    public final static GifFrame[] SunFlower;
    public final static GifFrame[] Chomper;
    public final static GifFrame[] ChomperAttack;
    public final static GifFrame[] ChomperDigest;
    public final static GifFrame[] CherryBomb;
    public final static GifFrame[] Boom;
    public final static GifFrame[] Peashooter;
    public final static GifFrame[] WallNut;
    public final static GifFrame[] WallNut_cracked;
    public final static GifFrame[] WallNut_cracked2;
    public final static GifFrame[] Jalapeno;
    public final static GifFrame[] JalapenoAttack;


    //僵尸
    public final static GifFrame[] NormalZombie;
    public final static GifFrame[] BucketheadZombie;
    public final static GifFrame[] ConeheadZombie;
    public final static GifFrame[] PoleVaultingZombie;
    public final static GifFrame[] NormalZombieAttack;
    public final static GifFrame[] BucketheadZombieAttack;
    public final static GifFrame[] ConeheadZombieAttack;
    public final static GifFrame[] PoleVaultingZombieAttack;
    public final static GifFrame[] PoleVaultingZombieJump;
    public final static GifFrame[] PoleVaultingZombieJump2;
    public final static GifFrame[] PoleVaultingZombieWalk;
    public final static GifFrame[] NormalZombieDie;
    public final static GifFrame[] PoleVaultingZombieDie;
    public final static GifFrame[] PoleVaultingZombieLostHeadWalk;
    public final static GifFrame[] PoleVaultingZombieHead;
    public final static GifFrame[] PoleVaultingZombieLostHead;
    public final static GifFrame[] NormalZombieLostHead;
    public final static GifFrame[] NormalZombieHead;
    public final static GifFrame[] FlagZombie;
    public final static GifFrame[] FlagZombieAttack;
    public final static GifFrame[] FlagZombieLostHead;
    public final static GifFrame[] BoomDie1;

    static {
        //其他
        background = readImage("img/interface/background1.jpg");
        selectPlant = readImage("img/plantshadow32.png");
        PB00 = getGifImageList("img/Plants/PB00.gif");
        SunBack = readImage("img/interface/SunBack.png");
        Sun = getGifImageList("img/Sun.gif");
        ShovelBack = readImage("img/interface/ShovelBack.png");
        Shovel = readImage("img/interface/Shovel.png");
        ZombiesWon = readImage("img/ZombiesWon.png");
        backgroundShadow = new BufferedImage(background.getWidth(),background.getHeight(),BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < background.getHeight(); i++) {
            for (int j = 0; j < background.getWidth(); j++) {
                backgroundShadow.setRGB(j,i,new Color(0,0,0,100).getRGB());
            }
        }
        PrepareGrowPlants = getGifImageList("img/PrepareGrowPlants.gif");
        LargeWave = getGifImageList("img/LargeWave.gif");
        FinalWave = getGifImageList("img/FinalWave.gif");
        logo = readImage("img/Logo.jpg");
        LawnMower = getGifImageList("img/LawnMower.gif");
        FlagMeterEmpty = readImage("img/interface/FlagMeterEmpty.png");
        FlagMeterFull = readImage("img/interface/FlagMeterFull.png");
        FlagMeterParts1 = readImage("img/interface/FlagMeterParts1.png");
        FlagMeterParts2 = readImage("img/interface/FlagMeterParts2.png");
        trophy = readImage("img/interface/trophy.png");

        //僵尸
        NormalZombie = getGifImageList("img/Zombies/Zombie/Zombie.gif");
        BucketheadZombie = getGifImageList("img/Zombies/BucketheadZombie/BucketheadZombie.gif");
        ConeheadZombie = getGifImageList("img/Zombies/ConeheadZombie/ConeheadZombie.gif");
        PoleVaultingZombie = getGifImageList("img/Zombies/PoleVaultingZombie/PoleVaultingZombie.gif");
        FlagZombie = getGifImageList("img/Zombies/FlagZombie/FlagZombie.gif");

        //僵尸攻击
        NormalZombieAttack = getGifImageList("img/Zombies/Zombie/ZombieAttack.gif");
        BucketheadZombieAttack = getGifImageList("img/Zombies/BucketheadZombie/BucketheadZombieAttack.gif");
        ConeheadZombieAttack = getGifImageList("img/Zombies/ConeheadZombie/ConeheadZombieAttack.gif");
        PoleVaultingZombieAttack = getGifImageList("img/Zombies/PoleVaultingZombie/PoleVaultingZombieAttack.gif");
        FlagZombieAttack = getGifImageList("img/Zombies/FlagZombie/FlagZombieAttack.gif");

        //僵尸死亡
        NormalZombieDie = getGifImageList("img/Zombies/Zombie/ZombieDie.gif");
        PoleVaultingZombieDie = getGifImageList("img/Zombies/PoleVaultingZombie/PoleVaultingZombieDie.gif");
        PoleVaultingZombieLostHead = getGifImageList("img/Zombies/PoleVaultingZombie/PoleVaultingZombieLostHead.gif");
        PoleVaultingZombieLostHeadWalk = getGifImageList("img/Zombies/PoleVaultingZombie/PoleVaultingZombieLostHeadWalk.gif");
        PoleVaultingZombieHead = getGifImageList("img/Zombies/PoleVaultingZombie/PoleVaultingZombieHead.gif");
        NormalZombieLostHead = getGifImageList("img/Zombies/Zombie/ZombieLostHead.gif");
        NormalZombieHead = getGifImageList("img/Zombies/Zombie/ZombieHead.gif");
        FlagZombieLostHead = getGifImageList("img/Zombies/FlagZombie/FlagZombieLostHead.gif");
        BoomDie1 = getGifImageList("img/Zombies/BoomDie1.gif");

        //撑杆跳
        PoleVaultingZombieJump = getGifImageList("img/Zombies/PoleVaultingZombie/PoleVaultingZombieJump.gif");
        PoleVaultingZombieJump2 = getGifImageList("img/Zombies/PoleVaultingZombie/PoleVaultingZombieJump2.gif");
        PoleVaultingZombieWalk = getGifImageList("img/Zombies/PoleVaultingZombie/PoleVaultingZombieWalk.gif");

        //植物
        SunFlower = getGifImageList("img/Plants/SunFlower/SunFlower.gif");
        CherryBomb = getGifImageList(("img/Plants/CherryBomb/CherryBomb.gif"));
        Boom = getGifImageList("img/Plants/CherryBomb/Boom.gif");
        Peashooter = getGifImageList("img/Plants/Peashooter/Peashooter.gif");
        Chomper = getGifImageList("img/Plants/Chomper/Chomper.gif");
        ChomperAttack = getGifImageList("img/Plants/Chomper/ChomperAttack.gif");
        ChomperDigest = getGifImageList("img/Plants/Chomper/ChomperDigest.gif");
        WallNut = getGifImageList("img/Plants/WallNut/WallNut.gif");
        WallNut_cracked = getGifImageList("img/Plants/WallNut/WallNut_cracked1.gif");
        WallNut_cracked2 = getGifImageList("img/Plants/WallNut/WallNut_cracked2.gif");
        Jalapeno = getGifImageList("img/Plants/Jalapeno/Jalapeno.gif");//
        JalapenoAttack = getGifImageList("img/Plants/Jalapeno/JalapenoAttack.gif");
        //卡片
        SunFlowerCard = readImage("img/Card/SunFlower.png");
        CherryBombCard = readImage("img/Card/CherryBomb.png");
        PeashooterCard = readImage("img/Card/Peashooter.png");
        ChomperCard = readImage("img/Card/Chomper.png");
        WallNutCard = readImage("img/Card/wallNut.png");
        JalapenoCard = readImage("img/Card/Jalapeno.png");


    }

    /**
     * 读取图片方法
     *
     * @author Yoki
     * @date 2023/2/21 9:58
     **/
    private static BufferedImage readImage(String uri) {
        try {
            File file = new File(JpanelBuilder.class.getResource("/").getPath() + "/static/" + uri);
            return ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 获取GIF的图片组
     *
     * @param uri
     * @return GifFrame[]
     */
    private static GifFrame[] getGifImageList(String uri) {
        try {
            //JpanelBuilder.class.getResource("/").getPath() 获取target/classes路径
            File gifFile = new File(JpanelBuilder.class.getResource("/").getPath() + "/static/" + uri);//img/Zombies/Zombie/Zombie.gif
            final GifFrame[] frames;
            ImageReader reader = null;
            //获取图片输入流
            ImageInputStream imageIn = ImageIO.createImageInputStream(gifFile);
            Iterator<ImageReader> iter = ImageIO.getImageReadersByFormatName("gif");
            if (iter.hasNext()) {
                reader = iter.next();
            }
            reader.setInput(imageIn, false);
            int count = reader.getNumImages(true);
            frames = new GifFrame[count];
            for (int i = 0; i < count; i++) {
                frames[i] = new GifFrame();
                frames[i].image = reader.read(i);
                frames[i].x = ((GIFImageMetadata) reader.getImageMetadata(i)).imageLeftPosition;
                frames[i].y = ((GIFImageMetadata) reader.getImageMetadata(i)).imageTopPosition;
                frames[i].width = ((GIFImageMetadata) reader.getImageMetadata(i)).imageWidth;
                frames[i].height = ((GIFImageMetadata) reader.getImageMetadata(i)).imageHeight;
                frames[i].disposalMethod = ((GIFImageMetadata) reader.getImageMetadata(i)).disposalMethod;
                frames[i].delayTime = ((GIFImageMetadata) reader.getImageMetadata(i)).delayTime;
            }
            return frames;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
