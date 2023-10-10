package com.tedu.entity.other;

import com.tedu.entity.zombie.*;
import com.tedu.img.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 进度条
 *
 * @author admin
 * @create 2023/3/7 18:41
 **/
public class FlagMeter {

    /**
     * 关卡僵尸数量
     */
    public int zombieNumber;
    public int x;
    public int y;
    public int width;
    public int height;
    public int loadWidth;
    public int createZombieNumber;

    public FlagMeter(int zombieNumber) {
        this.zombieNumber = zombieNumber;
        x = 650;
        y = 580;
        width = Images.FlagMeterEmpty.getWidth();
        height = Images.FlagMeterEmpty.getHeight();
        createZombieNumber = 0;
    }

    public BufferedImage getBackImages() {
        return Images.FlagMeterEmpty;
    }

    public BufferedImage getLoadImages() {
        loadWidth = (int) (((double) createZombieNumber / (double) zombieNumber) * (width - 14)) + 7;
        BufferedImage flagMeterFull = Images.FlagMeterFull;
        return flagMeterFull.getSubimage(width - loadWidth, 0, loadWidth, height);
    }

    public Boolean isOver() {
        return zombieNumber == createZombieNumber;
    }


    /**
     * 随机生成一只僵尸
     *
     * @return 僵尸对象
     */
    public Zombie randomZombie() {
        Random random = new Random();
        createZombieNumber++;
        int i = random.nextInt(50 + loadWidth);
        if (i >= 120) {
            i = 120;
        }
        if (i < 40) {
            //普通僵尸
            return new NormalZombie();
        } else if (i < 60) {
            //路障僵尸
            return new ConeheadZombie();
        } else if (i < 80) {
            //撑杆跳僵尸
            return new PoleVaultingZombie();
        } else {
            //铁桶僵尸
            return new BucketheadZombie();
        }
//        else if (i < 30) {
//            //旗帜僵尸
//            return new FlagZombie();
//        }
    }

    public List<Zombie> finalWaveZombies(){
        List<Zombie> zombies = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            zombies.add(new NormalZombie());
        }
        for (int i = 0; i < 7; i++) {
            zombies.add(new ConeheadZombie());
        }
        for (int i = 0; i < 4; i++) {
            zombies.add(new PoleVaultingZombie());
        }
        for (int i = 0; i < 6; i++) {
            zombies.add(new BucketheadZombie());
        }
        return zombies;
    }
}
