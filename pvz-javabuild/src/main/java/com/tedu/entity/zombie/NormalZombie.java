package com.tedu.entity.zombie;

import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

import java.awt.*;

/**
 * 普通僵尸类
 *
 * @author admin
 * @create 2023/2/21 10:14
 **/
public class NormalZombie extends Zombie
{

    private static final GifFrame[] NormalZombie = Images.NormalZombie;
    public NormalZombie() {
        super(NormalZombie[0].width, NormalZombie[0].height,0,0,-NormalZombie[0].x,-NormalZombie[0].y,8);
    }

    private GifFrame oldImage = null;

    @Override
    public void move() {
        if(isNormal()||(isDying() && deathWalk))
            x-=1;
    }

    public GifFrame getImages() {
        if(isEating()){
            return getImages(Images.NormalZombieAttack);
        }else if(isDying() && deathWalk){
            GifFrame image = getImages(Images.NormalZombieLostHead);
            if(index/3 == Images.NormalZombieHead.length){
                deathWalk = false;
                resetGif();
            }
            return image;
        }else if(isDying() && !deathWalk){
            GifFrame image = getImages(Images.NormalZombieDie);
            if(index/3 ==  Images.NormalZombieDie.length){
                state = Zombie.DEAD_MODE;
            }
            return image;
        }else if(isBoomDie()){
            GifFrame image = getImages(Images.BoomDie1);
            if(index/3 ==  Images.BoomDie1.length){
                state = Zombie.DEAD_MODE;
            }
            return image;
        }
        return getImages(NormalZombie);
    }

    @Override
    public GifFrame getHeadImages() {
        return getHeadImages(Images.NormalZombieHead);
    }
}
