package com.tedu.entity.zombie;

import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

/**
 * 旗帜僵尸
 */
public class FlagZombie extends Zombie{
    private static final GifFrame[] FlagZombie = Images.FlagZombie;
    public FlagZombie() {

        super(FlagZombie[0].width, FlagZombie[0].height,-10,-25,-FlagZombie[0].x,-FlagZombie[0].y-20,8);
    }

    private GifFrame oldImage = null;

    @Override
    public void move() {
        if(isNormal()||(isDying() && deathWalk))
            x-=1;
    }

    public GifFrame getImages() {
        if(isEating()){
            return getImages(Images.FlagZombieAttack);
        }else if(isDying() && deathWalk){
            GifFrame image = getImages(Images.FlagZombieLostHead);
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
        return getImages(FlagZombie);
    }

    @Override
    public GifFrame getHeadImages() {
        if(oldHeadImage!=null){
            headImageX -= oldHeadImage.x;
            headImageY -= oldHeadImage.y;
        }
        GifFrame image = null;
        if(isDying() && deathWalk){
            image = Images.NormalZombieHead[(index / 3) % Images.NormalZombieHead.length];
        }
        headImageX += image.x;
        headImageY += image.y;

        oldHeadImage = image;
        return image;
    }
}
