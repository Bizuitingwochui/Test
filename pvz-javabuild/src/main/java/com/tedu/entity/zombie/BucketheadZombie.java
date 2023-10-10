package com.tedu.entity.zombie;

import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

/**
 * 铁桶僵尸
 *
 * @author admin
 * @create 2023/2/21 13:43
 **/
public class  BucketheadZombie extends Zombie{

    private static final GifFrame[] BucketheadZombie = Images.BucketheadZombie;
    public BucketheadZombie() {

        super(BucketheadZombie[0].width, BucketheadZombie[0].height,0,0,-BucketheadZombie[0].x,-BucketheadZombie[0].y-20,26);
    }


    @Override
    public void move() {
        if(isNormal()||(isDying() && deathWalk))
            x-=1;
    }

    public GifFrame getImages() {
        if(isEating()){
            return getImages(Images.BucketheadZombieAttack);
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
        return getImages(BucketheadZombie);
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
