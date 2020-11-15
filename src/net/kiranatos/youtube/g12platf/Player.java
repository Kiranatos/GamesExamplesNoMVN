package net.kiranatos.youtube.g12platf;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Vector;

import static java.lang.Long.valueOf;

public class Player {

    ArrayList <String> list = new ArrayList<>();

    public static boolean Fly1;
    public static boolean Fly2;

    public static boolean F1 = false;
    public static boolean F2 = false;

    static Image Fly = new ImageIcon(Paths.FLY).getImage();

    private String ad; // адрес

    public Color color1 = Color.WHITE;

    public int h = 140;
    public int w = 90;

    Let let = new Let();

    public int XFly = 450; // Положения персонажапо X
    public int YFly = 380 ; // Положения персонажа по Y
    public int Time = 10; // Время в низ
    public int speed = 2;  // Скорость полета в верх
    public int Pspeed = 1 ; // скорость пржка в верх
    public int Ptime = 10 ; // время прыжкка в верх

    public int i_anim;

    public Player () {

        list.add(Paths.RUN_ONE);
        list.add(Paths.RUN_ONE);
        list.add(Paths.RUN_ONE);
        list.add(Paths.RUN_ONE);

        list.add(Paths.RUN_TWO);
        list.add(Paths.RUN_TWO);
        list.add(Paths.RUN_TWO);
        list.add(Paths.RUN_TWO);
    }

    public void update(){
        if(let.Plus3 == false) {
            i_anim++;
            if (i_anim >= list.size()) i_anim = 0;
            ad = list.get(i_anim);
        }
    }

    public void updateFly() {
        if (let.Plus3 == false) {
            Time += 20;
            Ptime -= 20;

            if (Fly1 == true) {
                if (YFly >= 29) {
                    YFly = YFly - (Time * Pspeed);
                }
            } else {
                Time = 10;
                speed = 2;
            }

            if (Fly2 == true) {
                if (YFly <= 380) {
                    YFly = YFly + (Time * speed);
                }
            } else {
                Time = 10;
                speed = 2;
            }
        }
    }

    public Rectangle getRect() { // получение прямоугоьников
        return new Rectangle(XFly,YFly, 80,  130); //возвращаем конструктор с размером объекта
    }
    //гетеры
    public double getX() {
        return XFly;
    }

    public double getY() {
        return YFly;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public void AnimDraw(Graphics2D g){
        g.drawImage(new ImageIcon(ad).getImage(),(int)XFly,(int)YFly,null);
    }

    public void FlyDraw(Graphics2D g){
        g.drawImage(Fly,(int)XFly,(int)YFly,null);
    }

    public void YDraw (Graphics2D g){
        g.setColor(color1);
        Font font = new Font("Arial", Font.ITALIC,60);
        g.setFont(font);
        g.drawString(String.valueOf(YFly + " Высота"),(int)10,(int)60);
    }
}
