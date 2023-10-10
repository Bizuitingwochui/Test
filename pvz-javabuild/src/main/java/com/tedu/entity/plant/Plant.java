package com.tedu.entity.plant;

import com.tedu.JpanelBuilder;
import com.tedu.entity.GifFrame;

import java.util.Random;

public abstract class Plant {

    /**
     * 植物存活状态
     */
    public static final int NORMAL_MODE = 0;
    /**
     * 植物死亡状态
     */
    public static final int DEAD_MODE = 1;
    /**
     * 植物状态
     */
    public int state = NORMAL_MODE;
    /**
     * 植物受击状态
     */
    public Boolean injuring = false;
    /**
     * 图片宽度
     */
    public int width;
    /**
     * 图片高度
     */
    public int height;
    /**
     * 植物真实坐标
     */
    public int x;
    /**
     * 植物真实坐标
     */
    public int y;
    /**
     * 图片的X坐标(GifFrame提供)
     */
    public int imageX;
    /**
     * 图片的Y坐标(GifFrame提供)
     */
    public int imageY;
    /**
     * 植物生命
     */
    public int health;

    /**
     * 生命时间计算公式 health * 40ms
     */
    public Plant(int width, int height,int x,int y,int imageX,int imageY, int health) {
        this.width = width;
        this.height = height;
        this.x = (JpanelBuilder.WIDTH - 150) / 9 * x + 100;
        this.y = (JpanelBuilder.HEIGHT - 85) / 5 * y + 70;
        this.imageX = imageX;
        this.imageY = imageY;
        this.health = health;
    }
    /**
     * 获取植物图片(gif)
     * @return GifFrame
     */
    public abstract GifFrame getImages();
    protected int index = 0;
    public void resetGif(){
        index=0;
    }
    private GifFrame oldImage = null;
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
    /**
     * 植物减少生命
     */
    public abstract void hurt();
    /**
     * 植物是否存活
     * @return Boolean
     */
    public Boolean isNormal() {
        return state == NORMAL_MODE;
    }
    /**
     * 植物是否受击
     * @return Boolean
     */
    public Boolean isInjuring(){
        return injuring;
    }
    /**
     * 植物是否死亡
     * @return Boolean
     */
    public Boolean isDead() {
        return state == DEAD_MODE;
    }

}
