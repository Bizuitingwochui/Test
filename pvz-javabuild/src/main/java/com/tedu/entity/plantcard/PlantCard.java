package com.tedu.entity.plantcard;

import com.tedu.entity.plant.Plant;
import com.tedu.img.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 植物卡片类
 *
 * @author admin
 * @create 2023/2/21 15:59
 **/
public abstract class PlantCard {
    /**
     * 普通模式
     */
    public final static int NORMAL_MODE = 0;
    /**
     * 加载模式
     * 种植成功后进入加载,loading()方法可控加载速度
     */
    public final static int LOADING_MODE = 1;
    /**
     * 选中模式
     */
    public final static int SELECTED_MODE = 2;
    /**
     * 阳光不足模式
     */
    public final static int NOSUNSHINE_MODE = 3;
    public int state = NORMAL_MODE;


    public int width;
    public int height;
    public int x;
    public int y;
    public int sunshine;
    public int shadowHeight;
    public BufferedImage shadow;
    public Class plant;
    public int loadIndex;


    public PlantCard(int width,int height,int y,int sunshine,Class plant) {
        this.x = 0;
        this.y = (height+10)*y;
        this.sunshine = sunshine;
        this.shadowHeight = height;
        this.width = width;
        this.height = height;
        this.plant = plant;
        this.shadow = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
    }

    public abstract BufferedImage getImage();

    public abstract void loading();
    protected void show() {
        if(state == NOSUNSHINE_MODE || state == SELECTED_MODE){
            if(shadowHeight== height){
                return;
            }
            shadowHeight = height;
            for (int j = 0; j < shadowHeight; j++) {
                for (int i = 0; i < width; i++) {
                    shadow.setRGB(i,j,new Color(0, 0,0, 100).getRGB());
                }
            }
        }else if(state == LOADING_MODE){
            if(shadowHeight<=0){
                state = NORMAL_MODE;
                return;
            }
            for (int i = 0; i < width; i++) {
                shadow.setRGB(i,shadowHeight-1,new Color(0, 0,0, 0).getRGB());
            }
        }else if(state == NORMAL_MODE){
            if(shadowHeight== 0){
                return;
            }
            shadowHeight = 0;
            for (int j = 0; j < height; j++) {
                for (int i = 0; i < width; i++) {
                    shadow.setRGB(i,j,new Color(0, 0,0, 0).getRGB());
                }
            }
        }
    }
    public Boolean isNormal(){
        return state == NORMAL_MODE;
    }

    public Boolean isLoading(){
        return state == LOADING_MODE;
    }

    public Boolean isSelected(){
        return state == SELECTED_MODE;
    }

    public Boolean isNoSunshine(){
        return state == NOSUNSHINE_MODE;
    }

}
