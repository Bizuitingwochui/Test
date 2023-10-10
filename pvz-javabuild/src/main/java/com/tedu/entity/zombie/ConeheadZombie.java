package com.tedu.entity.zombie;

import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

/**
 * 路障僵尸类
 *
 * @author admin
 * @create 2023/2/21 13:40
 **/
public class ConeheadZombie extends Zombie{

    private static final GifFrame[] ConeheadZombie = Images.ConeheadZombie;
    public ConeheadZombie() {

        super(ConeheadZombie[0].width, ConeheadZombie[0].height,-10,-25,-ConeheadZombie[0].x,-ConeheadZombie[0].y-20,18);
    }

    private GifFrame oldImage = null;

    @Override
    public void move() {
        if(isNormal()||(isDying() && deathWalk))
            x-=1;
    }

    public GifFrame getImages() {
        if(isEating()){
            return getImages(Images.ConeheadZombieAttack);
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
        return getImages(ConeheadZombie);
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
