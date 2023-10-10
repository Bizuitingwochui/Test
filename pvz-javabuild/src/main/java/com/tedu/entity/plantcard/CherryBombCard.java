package com.tedu.entity.plantcard;

import com.tedu.entity.plant.CherryBomb;
import com.tedu.img.Images;

import java.awt.image.BufferedImage;

/**
 * 樱桃炸弹卡片
 */
public class CherryBombCard extends PlantCard{

    private static final BufferedImage CherryBombCard = Images.CherryBombCard;
    public CherryBombCard(int y){
        super(CherryBombCard.getWidth(),CherryBombCard.getHeight(),y,150, CherryBomb.class);
    }
    @Override
    public BufferedImage getImage() {
        return CherryBombCard;
    }

    @Override
    public void loading() {
        if(loadIndex++%5==0) {
            shadowHeight--;
        }
        show();
    }
}
