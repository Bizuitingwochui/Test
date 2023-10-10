package com.tedu.entity.zombie;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tedu.JpanelBuilder;
import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

import java.util.Random;

/**
 * 僵尸总类
 *
 * @author admin
 * @create 2023/2/21 9:30
 **/
public abstract class Zombie {
    public final static int NORMAL_MODE = 0;
    public final static int EATING_MODE = 1;
    public final static int DYING_MODE = 2;
    public final static int DEAD_MODE =3;
    public final static int BOOM_DIE_MODE = 8;
    public int state = NORMAL_MODE;
    public int width;
    public int height;
    public int x;
    public int y;
    public int imageX;
    public int imageY;
    public int headX;
    public int headY;
    public int headImageX;
    public int headImageY;
    public int health;
    public int[] roadY = {45,135,245,325,435};
    public Boolean deathWalk = true;
    protected GifFrame oldImage = null;
    protected GifFrame oldHeadImage = null;

    public Zombie(int width, int height,int headX,int headY, int imageX , int imageY, int health) {
        this.width = width;
        this.height = height;
        this.x = JpanelBuilder.WIDTH;
        Random random = new Random();
        this.y = roadY[random.nextInt(5)];
        this.imageX = imageX;
        this.imageY = imageY;
        this.headX = headX;
        this.headY = headY;
        this.health = health;
    }

    public abstract void move();

    public abstract GifFrame getImages();
    public abstract GifFrame getHeadImages();
    public void hurt(){
        health--;
    }

    protected int index = 0;
    public void resetGif(){
        index=0;
    }
    public GifFrame getImages(GifFrame[] gifFrames) {
        if(oldImage!=null){
            imageX -= oldImage.x;
            imageY -= oldImage.y;
        }
        GifFrame image = gifFrames[(index++ / 3) % gifFrames.length];
        imageX += image.x;
        imageY += image.y;
        oldImage = image;
        return image;
    }

    public GifFrame getHeadImages(GifFrame[] gifFrames){
        if(oldHeadImage!=null){
            headImageX -= oldHeadImage.x;
            headImageY -= oldHeadImage.y;
        }
        GifFrame image = null;
        if(isDying() && deathWalk){
            image = gifFrames[(index / 3) % gifFrames.length];
        }
        headImageX += image.x;
        headImageY += image.y;

        oldHeadImage = image;
        return image;
    }

    public Boolean isNormal(){
        return state == NORMAL_MODE;
    }
    public Boolean isEating(){
        return state == EATING_MODE;
    }
    public Boolean isDying(){
        return state == DYING_MODE;
    }
    public Boolean isDead(){
        return state == DEAD_MODE;
    }
    public Boolean isBoomDie(){
        return state==BOOM_DIE_MODE;
    }

}
