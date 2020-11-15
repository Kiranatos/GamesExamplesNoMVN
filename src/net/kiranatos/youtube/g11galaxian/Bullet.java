package net.kiranatos.youtube.g11galaxian;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends EntityMy{


    Bullet(BufferedImage image){

        this.speed  = Const.BULLET_SPEED;
        this.image  = image;
        this.scale  = 2.0f;
        this.damage = Const.BULLET_DAMAGE_1;
        this.health = 1.0f;
    }

    public void add(int x, int y){

        this.x = x;
        this.y = y;
        activ = true;
    }

    public void update(){

        y -= speed;
        if(y < -10) destroy();
    }

    public void render(Graphics2D g){

            if(activ)
                g.drawImage(image, (int)x, (int)y, (int) (image.getWidth() * scale),
                        (int) (image.getHeight() * scale), null);
    }

    @Override
    public void destroy(){
        activ = false;
    }

    @Override
    protected void delete() {

    }

}
