package com.tedu.entity.plant;

import com.tedu.entity.GifFrame;
import com.tedu.entity.other.PB00;
import com.tedu.img.Images;

/**
 * 豌豆射手
 *
 * @author admin
 * @create 2023/2/27 15:48
 **/
public class Peashooter extends Plant{

    private static final GifFrame[] Peashooter = Images.Peashooter;

    public Peashooter(int x,int y) {
        super(Peashooter[0].width, Peashooter[0].height,x,y,-Peashooter[0].x,-Peashooter[0].y,45);
    }

    @Override
    public GifFrame getImages() {
        return getImages(Peashooter);
    }

    @Override
    public void hurt() {
        health--;
    }

    public PB00 shoot(){
        return new PB00(x+width,y+5);
    }

    //存在时间定时器 让射击更真实
    private int shootIndex = 1;
    public int getCreateIndex(){
        return shootIndex++;
    }

}
