package com.tedu.entity.zombie;

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

import java.awt.*;

/**
 * 撑杆跳僵尸
 *
 * @author admin
 * @create 2023/2/21 13:43
 **/
public class PoleVaultingZombie extends Zombie{

    public static final int JUMP_MODE = 100;
    public static final int JUMPING_MODE = 101;

    private static final GifFrame[] PoleVaultingZombie = Images.PoleVaultingZombieWalk;
    public PoleVaultingZombie() {

        super(PoleVaultingZombie[0].width, PoleVaultingZombie[0].height,-210,-95,-PoleVaultingZombie[0].x,-PoleVaultingZombie[0].y-20,9);
        state = JUMP_MODE;
    }

    private Boolean jumpCross = false;
    private GifFrame oldImage = null;

    @Override
    public void move() {
        if(isJump()||(isDying()&&deathWalk&&!jumpCross))
            x-=2;
        else if(isNormal()||(isDying()&&deathWalk&&jumpCross)){
            x-=1;
        }
    }

    public GifFrame getImages() {
        if(isJump()){
            return getImages(Images.PoleVaultingZombie);
        }else if(isJumping() && !jumpCross){
            GifFrame image = getImages(Images.PoleVaultingZombieJump);
            if(index/3 == Images.PoleVaultingZombieJump.length){
                jumpCross = true;
                resetGif();
            }
            return image;
        }else if (isJumping() && jumpCross){
            if(index == 0){
                x-=125;
            }
            GifFrame image = getImages(Images.PoleVaultingZombieJump2);
            if(index/3 == Images.PoleVaultingZombieJump2.length){
                state = Zombie.NORMAL_MODE;
                resetGif();
            }
            return image;
        }else if(isEating()){
            return getImages(Images.PoleVaultingZombieAttack);
        }else if(isDying() && deathWalk && !jumpCross){
            GifFrame image = getImages(Images.PoleVaultingZombieLostHead);
            if(index/3 == Images.PoleVaultingZombieHead.length){
                deathWalk = false;
                resetGif();
            }
            return image;
        }else if(isDying() && deathWalk && jumpCross){
            GifFrame image = getImages(Images.PoleVaultingZombieLostHeadWalk);
            if(index/3 == Images.PoleVaultingZombieHead.length){
                deathWalk = false;
                resetGif();
            }
            return image;
        }else if(isDying() && !deathWalk){
            GifFrame image = getImages(Images.PoleVaultingZombieDie);
            if(index/3 ==  Images.PoleVaultingZombieDie.length){
                state = Zombie.DEAD_MODE;
            }
            return image;
        }else if(isBoomDie()){
            if(index==0){
                imageX+=110;
                imageY+=55;
            }
            GifFrame image = getImages(Images.BoomDie1);
            if(index/3 ==  Images.BoomDie1.length){
                state = Zombie.DEAD_MODE;
            }
            return image;
        }
        return getImages(PoleVaultingZombie);
    }

    @Override
    public GifFrame getHeadImages(){
        return getHeadImages(Images.PoleVaultingZombieHead);
    }

    public Boolean isJump(){
        return state == JUMP_MODE;
    }

    public Boolean isJumping(){
        return state == JUMPING_MODE;
    }
}
