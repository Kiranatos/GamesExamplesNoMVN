package net.kiranatos.youtube.g12platf;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;

public class Menue {
    public static boolean GameOver = false; // если Проиграшь

    static int XMove;
    static int XMove1 = 1500;
    static int YMove;

    Listeners listeners = new Listeners();
    Let let = new Let();
    GameBack gameBack = new GameBack();

    static Image back = new ImageIcon(Paths.BACKGROUND).getImage();
    static Image back1 = new ImageIcon(Paths.BACKGROUND).getImage();


    static ButtMenue play = new ButtMenue(400,300,180,100,Paths.MENU_PLAY,"Старт");
    static ButtMenue settings = new ButtMenue(100,340,100,100,Paths.MENU_SETTINGS,"Выход");
    static ButtMenue cross = new ButtMenue(680,390,50,50,Paths.MENU_CROSS,"");
    static ButtMenue crossSettings = new ButtMenue(680,390,50,50,Paths.MENU_CROSS,"");

    Image addres []  = { back,back1} ;

    public void menueDraw(Graphics2D g) {
        g.drawImage(addres[0], XMove, YMove,null);
        g.drawImage(addres[1], XMove1, YMove,null);
    }
    public void settingsUpdate(ButtMenue e) {
        if (Panel.mouseX > e.getX() && Panel.mouseX < e.getX() + e.getW() &&
                Panel.mouseY > e.getY() && Panel.mouseY < e.getY() + e.getH()) {
            settings.s = Paths.MENU_C_SETTINGS;

            if (listeners.settingsClick == true) {
                Panel.state = Panel.STATES.SETTINGS;
                listeners.settingsClick = false;
            }
        }
        else {
            settings.s = Paths.MENU_SETTINGS;
        }
    }

    public void update(ButtMenue e) {
        if (Panel.mouseX > e.getX() && Panel.mouseX < e.getX() + e.getW() &&
                Panel.mouseY > e.getY() && Panel.mouseY < e.getY() + e.getH()) {
            
            play.s = Paths.MENU_C_PLAY;
            
            if (listeners.playClick == true) {
                Panel.state = Panel.STATES.PLAY;
                listeners.playClick = false;
            }
        }
        else {
            play.s = Paths.MENU_PLAY;
        }
    }
    
    public void CrossBoard(ButtMenue e) {
        if (Panel.mouseX > e.getX() && Panel.mouseX < e.getX() + e.getW() &&
                Panel.mouseY > e.getY() && Panel.mouseY < e.getY() + e.getH()) {

            cross.s = Paths.MENU_C_CROSS;

            if (listeners.boardCross == true) {
                let.score = 0;

                gameBack.GameOver = false;
                let.Plus3 = false;
                let.Plus2 = false;
                let.Plus1 = false;
                let.Xbox1 = 1900;
                let.Xbox3 = 1200;
                let.Xbox4 = 1500;

                Panel.state = Panel.STATES.MENUE;
            }
        }
        else {
            cross.s = Paths.MENU_CROSS;
        }
    }

    public void CrossSettings(ButtMenue e) {
        if (Panel.mouseX > e.getX() && Panel.mouseX < e.getX() + e.getW() &&
                Panel.mouseY > e.getY() && Panel.mouseY < e.getY() + e.getH()) {

            crossSettings.s = Paths.MENU_C_CROSS;

            if (listeners.settingsCross == true) {
                Panel.state = Panel.STATES.MENUE;
            }
        }
        else {
            crossSettings.s = Paths.MENU_CROSS;
        }
    }

    static int speed = 20;
    
    public void menueUpdate() { // Движение картинки
            XMove -= speed;
            XMove1 -= speed;
            
            if (XMove == -1500) {
                XMove = 0;
            }

            if (XMove1 == 0) {
                XMove1 = 1500;
            }
    }

    static class ButtMenue {
        public String s2;
        private double x;
        private double y;
        private double w;
        private double h;

        public Color color1;

        public String f; // Надпись на кнопке
        public String s; // адресс картинки

        public ButtMenue(int x, int y, int w, int h, String s, String f ) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.f = f;
            this.s = s;
            color1 = Color.WHITE;
        }

        public void drawBut(Graphics2D g) {
            g.drawImage(new ImageIcon(String.valueOf(s)).getImage(), (int)x , (int)y, null );
        }

        public double getX() {
            return x;
        }

        public double getY() { return y; }

        public double getW() {
            return w;
        }

        public double getH() {
            return h;
        }
    }
}
