package com.tedu.entity.other;

import com.tedu.JpanelBuilder;
import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

/**
 * @author admin
 * @create 2023/3/6 19:55
 **/
public class ReadyGif {

    public int width;
    public int height;
    public int x;
    public int y;
    public int imageX;
    public int imageY;
    protected GifFrame oldImage = null;
    public GifFrame[] textGif;

    public ReadyGif(GifFrame[] textGif) {

        width = textGif[0].width;
        height = textGif[0].height;
        x= JpanelBuilder.WIDTH/2 - width/2;
        y= JpanelBuilder.HEIGHT/2 - height/2;
        imageX = -textGif[0].x;
        imageY = -textGif[0].y;
        this.textGif = textGif;
    }

    private int index=0;
    public GifFrame getImages(int time){
        if(oldImage!=null){
            imageX -= oldImage.x;
            imageY -= oldImage.y;
        }
        GifFrame image = textGif[(index++/time)%textGif.length];
        imageX += image.x;
        imageY += image.y;
        oldImage = image;
        if(index/time>=textGif.length){
            return null;
        }
        return image;

    }


}
