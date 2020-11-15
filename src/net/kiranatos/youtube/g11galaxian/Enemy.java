package net.kiranatos.youtube.g11galaxian;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends EntityMy{

    Enemy(BufferedImage image){

        this.image = image;
        x   = 0.0f;
        y   = Const.ENEMY_Y_START;

        scale = 2.0f;
        //temp
        level =0;
        speed = 0;
        damage = 10f;
        health = 2.0f;
    }

    public void add(int x, int y, int level){

        this.x = x;
        this.y = Const.ENEMY_Y_START;
        this.level = level;
        activ = true;
        speed = setSpeed(level);
        health = setHealth(level);
    }

    @Override
    protected void render(Graphics2D g){
        if(activ)
            g.drawImage(image, (int)x, (int)y, (int)(image.getWidth() * scale), (int)(image.getHeight() * scale), null);
    }

    @Override
    public void destroy(){

        activ   = false;
    }

    @Override
    protected void delete(){

        activ = false;
    }

    @Override
    public void update(){

        if(activ) {
            y += speed;
            if (y > Const.FRAME_HEIGHT || health <= 0) destroy();
        }
    }

    public float setSpeed(int level){
        if(level == 1) return Const.ENEMY_SPEED_1;
        else if(level == 2) return Const.ENEMY_SPEED_2;
        else if(level == 3) return Const.ENEMY_SPEED_3;
        else return Const.ENEMY_SPEED_0;
    }

    public float setHealth(int level){
        if(level == 1) return Const.ENEMY_HEALTH_1;
        else if(level == 2) return Const.ENEMY_HEALTH_2;
        else if(level == 3) return Const.ENEMY_HEALTH_3;
        else return Const.ENEMY_HEALTH_0;
    }

    public float getSpeed(){return speed;}

    public boolean getActiv(){return activ;}

    public void setActiv(boolean activ){this.activ = activ;}

    public void setImage(BufferedImage image){this.image = image;}

    public void setLevel(int level){this.level =  level;}
}
