package com.tedu.entity.other;

import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

/**
 * 豌豆子弹
 *
 * @author admin
 * @create 2023/2/27 20:02
 **/
public class PB00 {

    public int width;
    public int height;
    public int x;
    public int y;
    public int imageX;
    public int imageY;

    public PB00(int x,int y){
        this.width = Images.PB00[0].width;
        this.height = Images.PB00[0].height;
        this.x = x;
        this.y = y;
    }

    private int index = 0;
    private GifFrame oldImage = null;
    public GifFrame getImages() {
        if(oldImage!=null){
            imageX -= oldImage.x;
            imageY -= oldImage.y;
        }
        GifFrame image = Images.PB00[(index++ / 3) % Images.PB00.length];
        imageX += image.x;
        imageY += image.y;
        oldImage = image;
        return image;
    }

    public void move(){
        x+=4;
    }

}
