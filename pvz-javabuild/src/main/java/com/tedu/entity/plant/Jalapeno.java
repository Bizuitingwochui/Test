package com.tedu.entity.plant;

import com.tedu.entity.GifFrame;
import com.tedu.img.Images;

import static com.tedu.img.Images.JalapenoAttack;

public class Jalapeno extends Plant{
    public static final int FIRE_MODE = 1001;
    private static final GifFrame[] Jalapeno = Images.Jalapeno;
    private static final GifFrame[] JalapenoAttack = Images.JalapenoAttack;



    public Jalapeno(int x,int y){
        super(Jalapeno[0].width,Jalapeno[0].height,x,y,-Jalapeno[0].x,-Jalapeno[0].y,1);

    }

    @Override
    public GifFrame getImages() {
        GifFrame image = getImages(Jalapeno);
        if (index / 3 >= Jalapeno.length) {
            state = FIRE_MODE;
            resetGif();
        }
        return image;
    }

    public GifFrame fire(){
        GifFrame image = getImages(JalapenoAttack);
        if (index / 3 >= JalapenoAttack.length) {
            state = DEAD_MODE;
        }
        return image;
    }

    @Override
    public void hurt() {

    }

    public Boolean isFire(){
        return state == FIRE_MODE;
    }

}
