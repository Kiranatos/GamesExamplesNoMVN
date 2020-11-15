package net.kiranatos.youtube.g11galaxian;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class EntityMy {

    protected float         damage;
    protected float         health;
    protected float         speed;
    protected int           level;
    protected float         x;
    protected float         y;
    protected float         scale;
    protected boolean       activ = false;
    protected BufferedImage image;


    protected void pushDamage(float damage){

        health -= damage;
    }

    protected float getX(){return x;}

    protected float getY(){return y;}

    protected float getWidth(){return image.getWidth() * scale;}

    protected float getHeight(){return image.getHeight() * scale;}

    protected float getHealth(){return health;}

    protected float getDamage(){return damage;}

    protected void setX(float x){this.x = x;}

    protected void setY(float y){this.y = y;}

    protected abstract void destroy();

    protected abstract void delete();

    protected abstract void update();

    protected abstract void render(Graphics2D g);
}
