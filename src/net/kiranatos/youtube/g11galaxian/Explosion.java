package net.kiranatos.youtube.g11galaxian;

import java.awt.*;
import java.awt.image.BufferedImage;

//взрыв
public class Explosion extends EntityMy{

    private int count = 0;
    private BufferedImage sheet;

    Explosion(BufferedImage sheet){

        this.sheet = sheet;
        this.scale = 2.0f;
    }

    protected void add(int x, int y){

        this.x = x;
        this.y = y;
        activ = true;
        image = sheet.getSubimage(0, 10, 16, 16);
    }

    //explosion точками
    //image_0 sheet.getSubimage(0, 10, 16, 16);
    //image_1 sheet.getSubimage(23, 9, 18, 18);
    //image_2 sheet.getSubimage(49, 3, 30, 30);
    //image_3 sheet.getSubimage(89, 3, 30, 30);

    @Override
    protected void destroy() {
        activ = false;
    }

    @Override
    protected void delete() {
        activ = false;
    }

    @Override
    protected void update() {
        if(activ){
            count ++;
            if(count == 5) image = sheet.getSubimage(23, 9, 18, 18);
            if(count == 10) image = sheet.getSubimage(49, 3, 30, 30);
            if(count == 15) image = sheet.getSubimage(89, 3, 30, 30);
            if(count >= 20){count = 0; destroy();}
        }
    }

    @Override
    protected void render(Graphics2D g) {
        if(activ)
            g.drawImage(image,  (int)(x - image.getWidth() * scale / 2),
                                (int)(y + 10 - image.getHeight() * scale / 2),
                                (int)(image.getWidth() * scale),
                                (int)(image.getHeight() * scale), null);
    }
}
