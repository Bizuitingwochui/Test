package com.tedu.entity.plantcard;

import com.tedu.entity.plant.Chomper;
import com.tedu.img.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 食人花卡片
 *
 */
public class ChomperCard extends PlantCard{

    private final static BufferedImage ChomperCard = Images.ChomperCard;
    public ChomperCard(int y){
        super(ChomperCard.getWidth(), ChomperCard.getHeight(), y,150, Chomper.class);
    }

    @Override
    public BufferedImage getImage() {
        return ChomperCard;
    }

    @Override
    public void loading() {
        if(loadIndex++%5==0){
            shadowHeight --;
            show();
        }
    }

}
