package com.tedu.entity.plantcard;

import com.tedu.entity.plant.Peashooter;
import com.tedu.entity.plant.SunFlower;
import com.tedu.img.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 豌豆射手卡片
 *
 * @author admin
 * @create 2023/2/27 15:51
 **/
public class PeashooterCard extends PlantCard{

    private static final BufferedImage PeashooterCard = Images.PeashooterCard;
    public PeashooterCard(int y) {
        super(PeashooterCard.getWidth(),PeashooterCard.getHeight(),y,100, Peashooter.class);
    }

    @Override
    public BufferedImage getImage() {
        return PeashooterCard;
    }

    @Override
    public void loading() {
        shadowHeight --;
        show();
    }


}
