package com.tedu.entity.plant;

import com.tedu.entity.GifFrame;
import com.tedu.entity.zombie.Zombie;
import com.tedu.img.Images;

public class Chomper extends Plant{
    public static final int ATTACKING_MODE = 10;

    public static final int EATING_MODE = 20;
    public Boolean kill = false;

    private static final GifFrame[] Chomper = Images.Chomper;
    public Chomper(int x,int y) {
        super(Chomper[0].width, Chomper[0].height,x,y,-Chomper[0].x,-Chomper[0].y,45);
    }
    @Override
    public GifFrame getImages() {
        if(isNormal()){
            return getImages(Chomper);
        }else if(isAttacking()){
            GifFrame image = getImages(Images.ChomperAttack);
            if(index/3 >= Images.ChomperAttack.length){
                resetGif();
                state = EATING_MODE;
            }
            return image;
        }else if(isEating()){
            GifFrame image = getImages(Images.ChomperDigest);
            if(digestionIndex>=375){
                resetGif();
                state = NORMAL_MODE;
                kill = false;
                digestionIndex=0;
            }
            digestion();
            return image;
        }
        return null;
    }

    private int digestionIndex = 0;
    public void digestion(){
        if(digestionIndex>=1&&!kill){
            state = NORMAL_MODE;
            digestionIndex=0;
            return;
        }
        digestionIndex++;
    }

    public Boolean isAttacking(){
        return state == ATTACKING_MODE;
    }

    public Boolean isEating(){
        return state == EATING_MODE;
    }
    @Override
    public void hurt() {
        health--;
    }
}
