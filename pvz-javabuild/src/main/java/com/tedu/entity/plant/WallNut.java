package com.tedu.entity.plant;

import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

/**
 * 坚果
 */
public class WallNut extends Plant {
    private static final GifFrame[] WallNut = Images.WallNut;
    private static final GifFrame[] WallNut1 = Images.WallNut_cracked;
    private static final GifFrame[] WallNut2 = Images.WallNut_cracked2;
    public WallNut(int x,int y) {
        super(WallNut[0].width, WallNut[0].height,x,y,-WallNut[0].x,-WallNut[0].y,800);
    }


    @Override
    public GifFrame getImages() {
        while (true){
            if(health>500){
                return getImages(WallNut);
            }else if(health>250){
                return getImages(WallNut1);
            }else {
                return getImages(WallNut2);
            }
        }
    }

    @Override
    public void hurt() {
        health--;
    }
}
