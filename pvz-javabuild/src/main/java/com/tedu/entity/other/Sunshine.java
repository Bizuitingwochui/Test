package com.tedu.entity.other;

import com.tedu.JpanelBuilder;
import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

import java.util.Random;

/**
 * 阳光
 *
 * @author admin
 * @create 2023/3/2 9:21
 **/
public class Sunshine {

    public static final int NORMAL_MODE = 0;
    public static final int REMOVE_MODE = 1;
    public int state = NORMAL_MODE;
    public int x;
    public int y;
    public int width;
    public int height;
    public int imageX;
    public int imageY;
    public int finalY;
    public int sunshine;

    public Sunshine() {
        Random random = new Random();
        this.width = Images.Sun[0].width;
        this.height = Images.Sun[0].height;
        this.imageX = -Images.Sun[0].x;
        this.imageY = -Images.Sun[0].y;
        this.x = random.nextInt(JpanelBuilder.WIDTH-190)+170-width;
        this.y = -height;
        this.finalY = random.nextInt(JpanelBuilder.HEIGHT-115)+90-height;
        this.sunshine = 25;
    }

    public Sunshine(int x,int y, int finalY) {
        this.width = Images.Sun[0].width;
        this.height = Images.Sun[0].height;
        this.imageX = -Images.Sun[0].x;
        this.imageY = -Images.Sun[0].y;
        this.x = x;
        this.y = y;
        this.finalY = finalY;
        this.sunshine = 25;
    }

    private int index = 0;
    private GifFrame oldImage = null;
    public GifFrame getImages(){
        if(oldImage!=null){
            imageX -= oldImage.x;
            imageY -= oldImage.y;
        }
        GifFrame image = Images.Sun[(index++ / 3) % Images.Sun.length];
        imageX += image.x;
        imageY += image.y;
        oldImage = image;
        return image;
    }

    private int stopIndex = 0;
    public void move(){
        if(finalY > y)
            y+=3;
        else{
            y = finalY;
            stopIndex++;
            if(stopIndex==150){
                state = REMOVE_MODE;
            }
        }
    }

    public Boolean isRemove(){
        return state == REMOVE_MODE;
    }

    public Boolean isNormal(){
        return state == NORMAL_MODE;
    }

}
