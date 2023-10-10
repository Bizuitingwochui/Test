package com.tedu.entity.plant;

import com.tedu.entity.GifFrame;
import com.tedu.entity.other.Sunshine;
import com.tedu.img.Images;

/**
 * 向日葵
 *
 * @author admin
 * @create 2023/2/21 16:27
 **/
public class SunFlower extends Plant{

    private static final GifFrame[] SunFlower = Images.SunFlower;

    public SunFlower(int x,int y) {
        super(SunFlower[0].width, SunFlower[0].height,x,y,-SunFlower[0].x,-SunFlower[0].y,45);
    }


    @Override
    public GifFrame getImages() {
        return getImages(SunFlower);
    }

    @Override
    public void hurt() {
        health--;
    }

    public Sunshine createSunshine(){
        return new Sunshine(x+width/2,y,y+50);
    }

    //存在时间定时器 让产生阳光更真实
    private int sunShineIndex = 20;//第一次阳光生成比后面的快
    public int getCreateIndex(){
        return sunShineIndex++;
    }
}
