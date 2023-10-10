package com.tedu.entity.other;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

/**
 * @author admin
 * @create 2023/3/7 15:13
 **/
public class LawnMower {
    public static final int NORMAL_MODE = 0;
    public static final int RUSH_MODE = 1;
    public int state = NORMAL_MODE;
    public int x;
    public int y;
    public int width;
    public int height;
    public int imageX;
    public int imageY;
    public int readyX;

    public LawnMower(int numY) {
        width = Images.LawnMower[0].width;
        height = Images.LawnMower[0].height;
        x = -width;
        y = 100*numY+80;
        imageX = -Images.LawnMower[0].x;
        imageY = -Images.LawnMower[0].y;
        readyX = 30;
    }

    private int index = 0;
    private GifFrame oldImage = null;
    public GifFrame getImages(){
        if(oldImage!=null){
            imageX -= oldImage.x;
            imageY -= oldImage.y;
        }
        GifFrame image = Images.LawnMower[(index++ / 3) % Images.LawnMower.length];
        imageX += image.x;
        imageY += image.y;
        oldImage = image;
        return image;
    }

    public void move(){
        if(x >= readyX && isNormal()){
            x = readyX;
            return;
        }
        x += 10;
    }

    public Boolean isNormal(){
        return state == NORMAL_MODE;
    }

    public Boolean isRush(){
        return state == RUSH_MODE;
    }
}
