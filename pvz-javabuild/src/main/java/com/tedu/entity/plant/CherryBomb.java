package com.tedu.entity.plant;

import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

/**
 * 樱桃炸弹
 *
 */

public class CherryBomb extends Plant{
    private static final GifFrame[] CherryBomb = Images.CherryBomb;
    private static final GifFrame[] Boom=Images.Boom;
    private static final GifFrame[] CherryBombBoom(){
        GifFrame[] CherryBombBoom = new GifFrame[CherryBomb.length+Boom.length];
        System.arraycopy(CherryBomb,0,CherryBombBoom,0,CherryBomb.length);
        System.arraycopy(Boom,0,CherryBombBoom,CherryBomb.length,Boom.length);
        return CherryBombBoom;
    }

    public CherryBomb(int x,int y) {
        super(CherryBomb[0].width, CherryBomb[0].height,x,y,-CherryBomb[0].x,-CherryBomb[0].y,1);
    }

    @Override
    public GifFrame getImages() {
        GifFrame image = getImages(CherryBombBoom());
        if(index/3>=CherryBombBoom().length){
             state=DEAD_MODE;
        }
        return image;
    }

    @Override
    public void hurt() {

    }
}
