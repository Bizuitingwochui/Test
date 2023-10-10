package com.tedu.entity.plantcard;

import com.tedu.entity.plant.Jalapeno;
import com.tedu.img.Images;

import java.awt.image.BufferedImage;

public class JalapenoCard  extends PlantCard  {
    private static final BufferedImage JalapenoCard = Images.JalapenoCard;
    public JalapenoCard(int y){
        super(JalapenoCard.getWidth(),JalapenoCard.getHeight(),y,125, Jalapeno.class);
    }
    @Override
    public BufferedImage getImage() {
        return JalapenoCard;
    }

    @Override
    public void loading() {
        if(loadIndex++%5==0) {
            shadowHeight--;
        }
        show();
    }
}
