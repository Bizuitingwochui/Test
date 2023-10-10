package com.tedu.entity.plantcard;

import com.tedu.entity.plant.CherryBomb;
import com.tedu.entity.plant.WallNut;
import com.tedu.img.Images;
import java.awt.image.BufferedImage;

/**
 * 坚果卡片
 */
public class WallNutCard extends PlantCard{

    private static final BufferedImage WallNutCard = Images.WallNutCard;
    public WallNutCard(int y){
        super(WallNutCard.getWidth(),WallNutCard.getHeight(),y,50, WallNut.class);
    }
    @Override
    public BufferedImage getImage() {
        return WallNutCard;
    }

    @Override
    public void loading() {
        if(loadIndex++%5==0){
            shadowHeight--;
            show();
        }
    }
}
