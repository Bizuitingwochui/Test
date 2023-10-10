package com.tedu.entity.plantcard;

import com.tedu.entity.plant.SunFlower;
import com.tedu.img.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 向日葵卡片
 *
 * @author admin
 * @create 2023/2/21 16:28
 **/
public class SunFlowerCard extends PlantCard{

    private static final BufferedImage SunFlowerCard = Images.SunFlowerCard;
    public SunFlowerCard(int y) {
        super(SunFlowerCard.getWidth(),SunFlowerCard.getHeight(),y,50, SunFlower.class);
    }

    @Override
    public BufferedImage getImage() {
        return SunFlowerCard;
    }

    @Override
    public void loading() {
        shadowHeight --;
        show();
    }
}
